package com.mingle.spring.retry;

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.backoff.ThreadWaitSleeper;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;


/**
 * Created by mingle.
 * Time 14/05/2018 10:55
 * Desc 文件描述
 */
@Service
public class RemoteService {
    
    @Retryable(value = {RemoteAccessException.class}, maxAttempts = 3, backoff = @Backoff(delay = 5000l, multiplier = 2))
    public Object call() throws Exception {
        System.out.println("do something...");
        throw new RemoteAccessException("RPC调用异常");
    }
    
    @Recover
    public Object recover(RemoteAccessException e) {
        System.out.println(e.getMessage());
        return new Object();
    }
    
    public String retry() {
        RetryTemplate template = new RetryTemplate();
        //重试策略：次数重试策略
        RetryPolicy retryPolicy = new SimpleRetryPolicy(3);
        template.setRetryPolicy(retryPolicy);
        //退避策略：指数退避策略
        ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
        backOffPolicy.setInitialInterval(100);
        backOffPolicy.setMaxInterval(3000);
        backOffPolicy.setMultiplier(2);
        backOffPolicy.setSleeper(new ThreadWaitSleeper());
        template.setBackOffPolicy(backOffPolicy);
        int param = 100;
    
        //当重试失败后，执行RecoveryCallback
        String result = template.execute(new RetryCallback<String, RuntimeException>() {
            @Override
            public String doWithRetry(RetryContext context) throws RuntimeException {
                System.out.println("retry count:" + context.getRetryCount());
                System.out.println("param is : " + param);
                if (context.getRetryCount() < 2) {
                    throw new RuntimeException("timeout");
                } else {
                    return "mingle";
                }
                
            }
        }, new RecoveryCallback<String>() {
            @Override
            public String recover(RetryContext context) throws Exception {
                System.out.println("recover");
                return "recover";
            }
        });
        System.out.println("result: " + result);
    
        //当重试失败后，抛出异常
        /*String result = template.execute(new RetryCallback<String, RuntimeException>() {
            @Override
            public String doWithRetry(RetryContext context) throws RuntimeException {
                throw new RuntimeException("timeout");
            }
        });*/
        
        return "yes";
    }
}

package com.mingle.function;

import java.util.function.Consumer;


/**
 * Created by mingle.
 * Time 2018/4/7 下午10:08
 * Desc 文件描述
 */
@FunctionalInterface
public interface CustomLamda<T> {
    
    T testCustomFunction(Consumer<T> cunsumer);
    
    /**
     * 如果把下面方法的注释放开, 那么接口就报错了. 验证了前面所说的:@FunctionalInterface注解的接口只允许有一个抽象方法
     * @return
     */
    //T anErrorMethod();
}

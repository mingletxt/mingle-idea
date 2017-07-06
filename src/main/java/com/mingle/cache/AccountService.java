package com.mingle.cache;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;


/**
 * Created by mingle.
 * Time 05/03/2017 5:43 PM
 * Desc 文件描述
 */
@CacheConfig(cacheNames = "redis", keyGenerator = "userKeyGenerator")
public class AccountService {
    
    static final String CACHE = "pre";
    
    @Resource
    private RedisCacheManager cacheManager;
    @Resource
    private RedisTemplate redisTemplate;
    
//    public Account gets(String id) {
//        redisTemplate;
//    }
    
    @Cacheable(key = "T(com.mingle.cache.Constant).PRE + #account")// 使用了一个缓存名叫 accountCache
    public Account getAccount(Account account, String str) {
        // 方法内部实现不考虑缓存逻辑，直接实现业务
        return getFromDB(account.getName());
    }
    
    @Cacheable(key = "T(com.mingle.cache.CacheKey).BIZ_ROLE.combineKey('hello')")// 使用了一个缓存名叫 accountCache
    public Account getAccount(String userName) {
        CacheKey.BIZ_ROLE.combineKey("hello");
        // 方法内部实现不考虑缓存逻辑，直接实现业务
        return getFromDB(userName);
    }
    
    @Cacheable(key = "T(com.mingle.cache.Constant).PRE + 'debug' + 10L + #userName")// 使用了一个缓存名叫 accountCache
    public Account getAccountByName(String userName) {
        // 方法内部实现不考虑缓存逻辑，直接实现业务
        return getFromDB(userName);
    }
    
    @Caching(evict={@CacheEvict(key="#account.getName()"),@CacheEvict(key="#account.getName()+'-'")})
    public void updateAccount(Account account) {
        updateDB(account);
    }
    
    
    @CacheEvict(allEntries = true)// 清空 accountCache 缓存
    public void reload() {
    }
    
    
    private Account getFromDB(String acctName) {
        System.out.println("real querying db..." + acctName);
        return new Account(acctName);
    }
    
    
    private void updateDB(Account account) {
        System.out.println("real update db..." + account.getName());
    }
}

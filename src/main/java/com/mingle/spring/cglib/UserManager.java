package com.mingle.spring.cglib;

/**
 * Created by mingle.
 * Time 20/08/2018 11:08
 * Desc 文件描述
 */
public interface UserManager {
    
    //新增用户抽象方法
    void addUser(String userName,String password);
    //删除用户抽象方法
    void delUser(String userName);
    
}

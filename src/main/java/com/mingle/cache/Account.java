package com.mingle.cache;

import java.io.Serializable;


/**
 * Created by mingle.
 * Time 05/03/2017 5:43 PM
 * Desc 文件描述
 */
public class Account implements Serializable{
    
    private static final long serialVersionUID = -118280679985052795L;
    
    private Integer id;
    private String name;
    
    public Account(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
    
    
    public static void main(String[] args) {
        Account a = new Account("mingle");
        System.out.println(a);
    }
}

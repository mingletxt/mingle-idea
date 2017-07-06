package com.mingle.reflect;

/**
 * Created by mingle.
 * Time 2017/4/10 上午11:39
 * Desc 文件描述
 */
public class Company {
    
    /**
     * 公司名称
     */
    private String name;
    /**
     * 公司地址
     */
    private String address;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "Company [name=" + name + ", address=" + address + "]";
    }
    
}

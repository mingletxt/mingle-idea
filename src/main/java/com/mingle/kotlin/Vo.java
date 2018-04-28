package com.mingle.kotlin;

import lombok.Data;


/**
 * Created by mingle.
 * Time 2018/4/22 下午6:53
 * Desc 文件描述
 */
public class Vo {
    private String s;
    
    private Integer length;
    
    private JavaBean javaBean;
    
    
    public String getS() {
        return s;
    }
    
    
    public void setS(String s) {
        this.s = s;
    }
    
    
    public Integer getLength() {
        return length;
    }
    
    
    public void setLength(Integer length) {
        this.length = length;
    }
    
    
    public JavaBean getJavaBean() {
        return javaBean;
    }
    
    
    public void setJavaBean(JavaBean javaBean) {
        this.javaBean = javaBean;
    }
}

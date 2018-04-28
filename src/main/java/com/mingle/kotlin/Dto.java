package com.mingle.kotlin;


import lombok.NonNull;


/**
 * Created by mingle.
 * Time 2018/4/22 下午6:52
 * Desc 文件描述
 */
public class Dto {
    
    @NonNull
    private String s;
    
    private JavaBean javaBean;
    
    
    public String getS() {
        return s;
    }
    
    
    public void setS(String s) {
        this.s = s;
    }
    
    
    public JavaBean getJavaBean() {
        return javaBean;
    }
    
    
    public void setJavaBean(JavaBean javaBean) {
        this.javaBean = javaBean;
    }
}

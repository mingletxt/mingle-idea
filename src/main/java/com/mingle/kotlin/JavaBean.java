package com.mingle.kotlin;

import com.sun.istack.Nullable;


/**
 * Created by mingle.
 * Time 2018/4/22 下午4:21
 * Desc 文件描述
 */
public class JavaBean {
    
    private int i;
    @Nullable
    private String str;
    
    public int getI() {
        return i;
    }
    
    public void setI(int i) {
        this.i = i;
    }
    
    
    public String getStr() {
        return str;
    }
    
    
    public void setStr(String str) {
        this.str = str;
    }
}

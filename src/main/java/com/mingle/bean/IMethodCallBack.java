package com.mingle.bean;

/**
 * Created by mingle.
 * Time 2/26/17 3:06 PM
 * Desc 文件描述
 */
public interface IMethodCallBack {
    
    String getMethodName();
    
    ToBean callMethod(FromBean frombean) throws Exception;
}

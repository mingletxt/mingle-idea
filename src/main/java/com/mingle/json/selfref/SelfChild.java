package com.mingle.json.selfref;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;


/**
 * Created by mingle.
 * Time 2017/3/26 下午2:11
 * Desc 文件描述
 */
public class SelfChild extends Self{
    
    private String childName;
    
    
    public String getChildName() {
        return childName;
    }
    
    
    public void setChildName(String childName) {
        this.childName = childName;
    }
}

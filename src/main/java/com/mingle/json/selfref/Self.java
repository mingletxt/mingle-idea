package com.mingle.json.selfref;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;


/**
 * Created by mingle.
 * Time 2017/3/26 下午2:11
 * Desc 文件描述
 */
public class Self {
    
    private Long id;
    
    private String name;
    
    @JsonBackReference
    //@JsonManagedReference
    private Self self;
    
    
    public Long getId() {
        return id;
    }
    
    
    public void setId(Long id) {
        this.id = id;
    }
    
    
    public String getName() {
        return name;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }
    
    
    public Self getSelf() {
        return self;
    }
    
    
    public void setSelf(Self self) {
        this.self = self;
    }
}

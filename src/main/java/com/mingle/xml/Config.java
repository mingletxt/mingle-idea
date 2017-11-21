package com.mingle.xml;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * Created by mingle.
 * Time 2017/10/30 上午12:58
 * Desc 文件描述
 */
@XmlRootElement
public class Config {
    
    String author;  //开发者名称
    
    String basePackage; //项目级别packae
    
    String module;  //模块名称
    
    String database;    //数据库连接
    
    String user;    //数据库用户名
    
    String password;    //数据库密码
    
    String table;   //表名称
    
    Boolean dal = true;    //是否生成dal层代码
    
    Boolean query = true;    //是否条件查询对象
    
    Boolean param = true;    //是否insert和update的参数
    
    Boolean dto = true;    //是否DTO
    
    Boolean transutil = true;    //是否生成transutil代码
    
    public String getAuthor() {
        return author;
    }
    
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    
    public String getBasePackage() {
        return basePackage;
    }
    
    
    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }
    
    
    public String getModule() {
        return module;
    }
    
    
    public void setModule(String module) {
        this.module = module;
    }
    
    
    public String getDatabase() {
        return database;
    }
    
    
    public void setDatabase(String database) {
        this.database = database;
    }
    
    
    public String getUser() {
        return user;
    }
    
    
    public void setUser(String user) {
        this.user = user;
    }
    
    
    public String getPassword() {
        return password;
    }
    
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    public String getTable() {
        return table;
    }
    
    
    public void setTable(String table) {
        this.table = table;
    }
    
    
    public Boolean getDal() {
        return dal;
    }
    
    
    public void setDal(Boolean dal) {
        this.dal = dal;
    }
    
    
    public Boolean getQuery() {
        return query;
    }
    
    
    public void setQuery(Boolean query) {
        this.query = query;
    }
    
    
    public Boolean getParam() {
        return param;
    }
    
    
    public void setParam(Boolean param) {
        this.param = param;
    }
    
    
    public Boolean getDto() {
        return dto;
    }
    
    
    public void setDto(Boolean dto) {
        this.dto = dto;
    }
    
    
    public Boolean getTransutil() {
        return transutil;
    }
    
    
    public void setTransutil(Boolean transutil) {
        this.transutil = transutil;
    }
    
    
    @Override
    public String toString() {
        return "Config{" + "author='" + author + '\'' + ", basePackage='" + basePackage + '\'' + ", module='" + module + '\'' + ", database='" + database + '\'' + ", user='" + user + '\'' + ", " +
                "password='" + password + '\'' + ", table='" + table + '\'' + ", dal=" + dal + ", query=" + query + ", param=" + param + ", dto=" + dto + ", transutil=" + transutil + '}';
    }
}

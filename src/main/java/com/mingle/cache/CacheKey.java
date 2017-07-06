package com.mingle.cache;


/**
 * Created by wangpan.
 * Time 2017/2/14 下午4:38
 * Desc 文件描述
 */
public enum CacheKey implements ICacheKey {
   
    USER_PERMISSION("mingle" + "_user_permission", "用户权限"),
    SYS_ROLE_INIT_KEY("mingle" + "_role_init", "系统角色初始化key"),
    SHOP_PERMISSION("mingle" + "_shop_permission", "用户权限"),
    BIZ_ROLE("mingle" + "_role_default", "默认角色"),
    SAM_PERM_IDX("mingle" +"_perm_idx", "权限位"),
    SAM_PERM_LIST("mingle" +"_perm_list", "权限列表"),
    SAM_STAFF_PERM("mingle" +"_staff_perm", "权限列表"),
            ;
    private String key;
    
    private String desc;
    
    
    CacheKey(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }
    
    
    @Override
    public String getBaseKey() {
        return this.key;
    }
}

package com.mingle.excel;

import lombok.Data;


/**
 * Created by mingle. Time 2019-01-04 14:56 Desc 文件描述
 */
@Data
public class RechargeModel {
    
    private String objName;
    
    private Long originAmount;
    
    private Long account;
    
    private Integer singleDiscount;
    
    private Integer courseCardDiscount;
    
    private Integer productDiscount;
    
    private String createTime;
    
    private String status;
    
}

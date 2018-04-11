package com.mingle.validation;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Created by mingle.
 * Time 2018/1/15 上午11:45
 * Desc 文件描述
 */
public class Car {
    @NotNull
    private String manufacturer;
    
    @NotNull
    @Size(min = 2, max = 14)
    private String licensePlate;
    
    @Min(2)
    private int seatCount;
    
    public Car(String manufacturer, String licencePlate, int seatCount) {
        this.manufacturer = manufacturer;
        this.licensePlate = licencePlate;
        this.seatCount = seatCount;
    }
}

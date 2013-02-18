package com.mingle.jmx;

/**
 * User: mingle
 * Date: 13-1-15
 * Time: 下午11:47
 * desc
 */
public interface CentralHeaterImplMBean {
    public String getHeaterProvider();

    public int getCurrentTemperature();

    public void setCurrentTemperature(int newTemperature);

    public String printCurrentTemperature();
}

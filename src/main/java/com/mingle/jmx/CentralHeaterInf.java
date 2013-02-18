package com.mingle.jmx;

/**
 * User: mingle
 * Date: 13-1-15
 * Time: 下午11:43
 * desc
 */
public interface CentralHeaterInf {
    public final static String HEATER_PROVIDER = "British Gas Company";

    public int getCurrentTemperature();

    public void setCurrentTemperature(int newTemperature);

    public void turnOn();

    public void turnOff();

    public String printCurrentTemperature();
}

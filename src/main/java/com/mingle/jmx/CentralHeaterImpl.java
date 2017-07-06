package com.mingle.jmx;

import javax.management.NotCompliantMBeanException;
import javax.management.StandardMBean;

/**
 * User: mingle
 * Date: 13-1-15
 * Time: 下午11:45
 * desc
 */
public class CentralHeaterImpl extends StandardMBean implements CentralHeaterInf {
    private int currentTemperature;

    protected CentralHeaterImpl(Class<?> mbeanInterface) throws NotCompliantMBeanException {
        super(mbeanInterface);
    }

    public int getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(int newTemperature) {
        currentTemperature = newTemperature;
    }

    public void turnOff() {
        System.out.println("The heater is off. ");
    }

    public String printCurrentTemperature() {
        String printMsg = "Current temperature is:" + currentTemperature;
        System.out.println(printMsg);
        return printMsg;
    }


    public void turnOn() {
        System.out.println("The heater is on. ");
    }
}
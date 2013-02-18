package com.mingle.jmx;

/**
 * User: mingle
 * Date: 13-1-15
 * Time: 下午11:58
 * desc: http://my.oschina.net/itjava/blog/102001
 */

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class CentralHeaterAgent {
    private static MBeanServer mBeanServer;

    public static void main(String[] args) throws Exception {

        ObjectName oname;
        // get the default MBeanServer from Management Factory

        mBeanServer = ManagementFactory.getPlatformMBeanServer();
        // try {
        // create a instance of CentralHeaterImpl class
        CentralHeaterInf centralHeater = new CentralHeaterImpl(CentralHeaterInf.class);

        // assign a Object name to above instance
        oname = new ObjectName("MyHome:name=centralheater");

        // register the instance of CentralHeaterImpl to MBeanServer
        mBeanServer.registerMBean(centralHeater, oname);

        System.out.println("Press any key to end our JMX agent...");
        System.in.read();
    }
}

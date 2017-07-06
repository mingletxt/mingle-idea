package com.mingle.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * @author mingle
 * @Version 16/12/2
 */
public class MessageEngineAgent {
    public void start() {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        try {
            ObjectName mxbeanName = new ObjectName("com.example:type=MessageEngine");
            MessageEngineMXBean mxbean = new MessageEngine();
            mbs.registerMBean(mxbean, mxbeanName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

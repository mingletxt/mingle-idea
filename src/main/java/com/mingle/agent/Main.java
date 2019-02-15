package com.mingle.agent;

import com.sun.tools.attach.VirtualMachine;


/**
 * Created by mingle.
 * Time 18/10/2018 11:00
 * Desc 文件描述
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        String pid = args[0];
        String jarFileName = args[1];
        new Main().start(pid, jarFileName);
    }
    
    
    public void start(String processId, String jarFileName) throws Exception {
        VirtualMachine virtualMachine = null;
        try {
            virtualMachine = VirtualMachine.attach(processId);
            virtualMachine.loadAgent(jarFileName);
        } finally {
            if (virtualMachine != null) {
                virtualMachine.detach();
            }
        }
    }
}

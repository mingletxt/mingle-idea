package com.mingle.agent;

import java.lang.instrument.Instrumentation;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Created by mingle.
 * Time 18/10/2018 10:59
 * https://liuzhengyang.github.io/2017/10/21/dynamic-attach-jvm/
 */
public class HelloWorldAgent {
    public static void premain(String args, Instrumentation instrumentation) {
        agentmain(args, instrumentation);
    }
    public static void agentmain(String args, Instrumentation instrumentation) {
        System.out.println("Hello World " + new Date());
        ThreadInfo[] threadInfos = ManagementFactory.getThreadMXBean().dumpAllThreads(false, false);
        Map<Thread.State, Long> stateStatMap = Arrays.stream(threadInfos).collect(Collectors
                .groupingBy(t -> t.getThreadState(), Collectors.counting()));
        System.out.println(stateStatMap);
    }
}

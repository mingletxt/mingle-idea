package com.mingle.log.ext;

import org.slf4j.profiler.Profiler;
import org.slf4j.profiler.ProfilerRegistry;


/**
 * Created by mingle.
 * Time 2017/3/19 上午11:53
 * Desc 文件描述
 */
public class BasicProfilerDemo {
    
    public static void main(String[] args) {
        // create a profiler called "BASIC"
        Profiler profiler = new Profiler("BASIC");
        profiler.start("A");
        doA();
        
        profiler.start("B");
        doB();
        profiler.stop().print();
    }
    
    
    public static String doA() {
        for (int i = 0; i < 10000; i++) {
            int a = i;
        }
        return "return doA";
    }
    
    
    public static String doB() {
        for (int i = 0; i < 1000; i++) {
            int a = i;
        }
        return "return doB";
    }
    
    
    public static String doOther() {
        
        doA();
        doB();
        ProfilerRegistry profilerRegistry = ProfilerRegistry.getThreadContextInstance();
        Profiler profiler = profilerRegistry.get("NESTED-DEMO1");
        profiler.startNested("NESTED-DEMO3");
        Profiler nested = profilerRegistry.get("NESTED-DEMO3");
        nested.start("doA-nested");
        String str3 = BasicProfilerDemo.doA();
        return "return doOther";
    }
}

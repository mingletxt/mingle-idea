package com.mingle.log.ext;

import org.slf4j.profiler.Profiler;
import org.slf4j.profiler.ProfilerRegistry;


/**
 * Created by mingle.
 * Time 2017/3/19 下午12:06
 * Desc 文件描述
 */
public class NestedProfilerDemo {
    public static void main(String[] args) {
        // create a profiler called "DEMO"
        Profiler profiler = new Profiler("DEMO");
        
        // register this profiler in the thread context's profiler registry
        ProfilerRegistry profilerRegistry = ProfilerRegistry.getThreadContextInstance();
        profiler.registerWith(profilerRegistry);
        
        // start a stopwatch called "RANDOM"
        profiler.start("PARENT-DEMO");
        BasicProfilerDemo.doA();
        BasicProfilerDemo.doB();
        // create and start a nested profiler called "SORT_AND_PRUNE"
        // By virtue of its parent-child relationship with the "DEMO"
        // profiler, and the previous registration of the parent profiler,
        // this nested profiler will be automatically registered
        // with the thread context's profiler registry
        profiler.startNested("NESTED-DEMO1");
        Profiler nestedProfiler = profilerRegistry.get("NESTED-DEMO1");
        nestedProfiler.start("doOther1");
        String str1 = BasicProfilerDemo.doOther();
        nestedProfiler.start("doOther2");
        String str2 = BasicProfilerDemo.doOther();
    
        profiler.startNested("NESTED-DEMO2");
        Profiler nestedProfiler2 = profilerRegistry.get("NESTED-DEMO2");
        nestedProfiler2.start("doOther3");
        String str3 = BasicProfilerDemo.doOther();
        nestedProfiler2.start("doOther4");
        String str4 = BasicProfilerDemo.doOther();
        
        // stop and print the "DEMO" printer
        profiler.stop().print();
    }
}

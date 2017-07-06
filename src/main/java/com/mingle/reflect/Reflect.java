package com.mingle.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


/**
 * Created by mingle.
 * Time 2017/3/30 下午3:26
 * Desc 文件描述
 */
public class Reflect {
    
    /**
     * Prints all constructors of a class
     *
     * @param cl a class
     */
    public static void printConstructors(Class cl) {
        System.out.println("printConstructors");
        Constructor[] constructors = cl.getDeclaredConstructors();
        
        for (Constructor c : constructors) {
            String name = c.getName();
            System.out.print("   " + Modifier.toString(c.getModifiers()));
            System.out.print(" " + name + "(");
            
            // print parameter types
            Class[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0)
                    System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }
    
    /**
     * Prints all methods of a class
     *
     * @param cl a class
     */
    public static void printMethods(Class cl) {
        System.out.println("printMethods");
        Method[] methods = cl.getDeclaredMethods();
        
        for (Method m : methods) {
            Class retType = m.getReturnType();
            String name = m.getName();
            
            // print modifiers, return type and method name
            System.out.print("   " + Modifier.toString(m.getModifiers()));
            System.out.print(" " + retType.getName() + " " + name + "(");
            
            // print parameter types
            Class[] paramTypes = m.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++) {
                if (j > 0)
                    System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }
    
    
    /**
     * Prints all fields of a class
     *
     * @param cl
     *            a class
     */
    public static void printFields(Class cl) {
        System.out.println("printFields");
        Field[] fields = cl.getDeclaredFields();
        
        for (Field f : fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("   " + Modifier.toString(f.getModifiers()));
            System.out.println(" " + type.getName() + " " + name + ";");
        }
    }
    
    
    public static void main(String[] args) {
        printConstructors(String.class);
        System.out.println("---------");
        printMethods(MethodTest.class);
        System.out.println("---------");
        printFields(String.class);
    }
    
}

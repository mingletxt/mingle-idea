package com.mingle.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;


/**
 * Created by mingle.
 * Time 2018/3/7 上午11:41
 * Desc 文件描述
 */
public class MethodTypeTest {
    public static void main(String[] args) throws Exception {
        Method[] methods = MethodTypeTest.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("method:" + method.getName());// 方法名
            
            // //////////////方法的参数
            System.out.println(" paramTypeType: ");
            Type[] paramTypeList = method.getGenericParameterTypes();// 方法的参数列表
            for (Type paramType : paramTypeList) {
                System.out.println("  " + paramType);// 参数类型
                if (paramType instanceof ParameterizedType)/**//* 如果是泛型类型 */{
                    Type[] types = ((ParameterizedType) paramType)
                            .getActualTypeArguments();// 泛型类型列表
                    System.out.println("  TypeArgument: ");
                    for (Type type : types) {
                        System.out.println("   " + type);
                    }
                }
            }
            
            // //////////////方法的返回值
            System.out.println(" returnType: ");
            Type returnType = method.getGenericReturnType();// 返回类型
//            if (returnType instanceof String) {
//
//            }
            System.out.println("  " + returnType);
            if (returnType instanceof ParameterizedType)/**//* 如果是泛型类型 */{
                Type[] types = ((ParameterizedType) returnType)
                        .getActualTypeArguments();// 泛型类型列表
                System.out.println("  TypeArgument: ");
                for (Type type : types) {
                    System.out.println("   " + type);
                }
            }
            
        }
        
    }
    
    public static String method1(List list) {
        return null;
    }
    
    private static Map<String, Double> method2(Map<String, Object> map) {
        return null;
    }
}

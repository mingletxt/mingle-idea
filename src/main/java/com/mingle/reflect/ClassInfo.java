package com.mingle.reflect;

/**
 * Created by mingle.
 * Time 2017/4/10 上午11:38
 * Desc 文件描述
 */

import java.lang.reflect.Field;


/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * @since：2015-5-25 下午07:02:09
 */
public class ClassInfo {
    
    public static void getParameters(Class<?> clazz) {
        
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getName());
        }
    }
    
    
    public static void getFieldsValue(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        /**
         * 基本类型、包装类型、String类型
         */
        String[] types = {"java.lang.Integer", "java.lang.Double", "java.lang.Float", "java.lang.Long", "java.lang.Short", "java.lang.Byte", "java.lang.Boolean", "java.lang.Character", "java.lang"
                + ".String", "int", "double", "long", "short", "byte", "boolean", "char", "float"};
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                System.out.println("字段：" + f.getName() + " 类型为：" + f.getType().getName() + " 值为：" + f.get(obj));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public static void main(String[] args) throws Exception {
        People people = new People();
        people.setAge(12);
        people.setSex("男");
        Company company = new Company();
        company.setAddress("北京");
        company.setName("科技股份有限公司");
        people.setCompany(company);
        people.setMoney(1000.00);
        getFieldsValue(people);
    }
    
}

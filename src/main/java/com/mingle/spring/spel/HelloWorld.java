package com.mingle.spring.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;


/**
 * Created by mingle.
 * Time 2017/3/12 下午10:41
 * Desc http://spring.cndocs.tk/expressions.html
 */
public class HelloWorld {
    
    public static String helloworld() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");
        String message = (String) exp.getValue();
        return message;
    }
    
    public static String concat() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.concat('!')");
        String message = (String) exp.getValue();
        return message;
    }
    
    public static byte[] bean() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.bytes");
        byte[] bytes = (byte[]) exp.getValue();
        return bytes;
    }
    
    public static Integer prop() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'.bytes.length");
        Integer length = (Integer)  exp.getValue();
        return length;
    }
    
    public static String str() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("new String('hello world').toUpperCase()");
        String message = exp.getValue(String.class);
        return message;
    }
    
    public static void main(String[] args) {
        System.out.println(helloworld());
        System.out.println(concat());
        System.out.println(bean());
        System.out.println(prop());
        System.out.println(str());
    
    }
}

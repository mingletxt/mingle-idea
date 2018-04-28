package com.mingle.kotlin

/**
 * Created by mingle.
 * Time 2018/4/22 下午3:57
 * Desc 文件描述
 */

fun main(args: Array<String>) {
    println("hello world")
    val bean = JavaBean()
    println(bean?.str);
    var str = bean.str;
    println(str.toInt()?: -1)
    bean.i = 10
    println(bean.i)
    println(bean.str?.toInt())
    bean.str = "100"
    println(bean.str?.toInt())
    println(sum(10, 20))

    //类型后面加?表示可为空
    var age: String? = "23"
    //抛出空指针异常
    val ages = age!!.toInt()
    //不做处理返回 null
    val ages1 = age?.toInt()
    //age为空返回-1
    val ages2 = age?.toInt() ?: -1

    println("test trans")

    var a: String = "abc"
    //a = null // 编译错误
    var b: String? = "abc"
    b = null // ok
    //val l = b.length // 错误：变量“b”可能为空
}

fun sum(a: Int, b: Int): Int {   // Int 参数，返回值 Int
    return a + b
}
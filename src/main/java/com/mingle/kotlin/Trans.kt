package com.mingle.kotlin

/**
 * Created by mingle.
 * Time 2018/4/22 下午6:53
 * Desc 文件描述
 */

fun tran(dto: Dto?): Vo {
    if (dto != null) {
        var vo = Vo();
        vo.s = dto.s;
        vo.length = dto.s.length
        dto.javaBean?.let {
            vo.javaBean = JavaBean();
            vo.javaBean.i = dto.javaBean.i
        }
        return vo
    }
    return Vo()
}
package com.itheima.controller;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 实现converter转换器接口
 * converter<S,T>
 *      泛型S：原来的数据  String
 *      泛型T：将要转换的数据类型  Date
 */

public class DateFormartConverter implements Converter<String,Date>{
    public Date convert(String source) {
        //要求：与前台页面传递格式一样
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parse = simpleDateFormat.parse(source);
            return parse;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}

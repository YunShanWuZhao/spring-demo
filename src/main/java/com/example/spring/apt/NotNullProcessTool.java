package com.example.spring.apt;

import com.example.spring.annotation.NotNull;
import com.example.spring.exception.BizException;
import com.example.spring.model.enums.ErrorCode;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class NotNullProcessTool {

    public static void checkParam(Object paramObj){
        if(paramObj == null){
            throw new BizException(ErrorCode.PARAM_NOTNULL);
        }
        Class clazz = paramObj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            NotNull annotation = field.getAnnotation(NotNull.class);
            try {
                if(annotation != null && (field.get(paramObj) == null || StringUtils.isEmpty(field.get(paramObj)))){
                    throw new BizException(ErrorCode.PARAM_NOTNULL.getCode(), ErrorCode.PARAM_NOTNULL.getMsg()+annotation.name());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}

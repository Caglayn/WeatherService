package com.c8n.weatherservice.util;

import com.c8n.weatherservice.exception.RequiredParameterException;
import org.springframework.http.HttpStatus;

import java.util.Collection;

public class ControlUtil {
    public static boolean isEmpty(Object object){
        if (object == null)
            return true;

        return switch (object) {
            case String stringVal -> stringVal.trim().isEmpty();
            case Collection col -> col.isEmpty();
            default -> false;
        };
    }

    public static void checkRequiredParams(Object ...params){
        for (Object param : params){
            if (param == null)
                throw new RequiredParameterException("Required parameters cannot be null !", HttpStatus.BAD_REQUEST.value());

            switch (param){
                case String stringVal -> {
                    if (stringVal.isEmpty())
                        throw new RequiredParameterException("Required parameters cannot be empty !", HttpStatus.BAD_REQUEST.value());
                }
                default -> {
                    return;
                }
            }
        }
    }
}

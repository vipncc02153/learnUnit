package pers.huangpy.main.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectUtil {
    public static Boolean isBean(Object obj){
        Class<? extends Object> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods)
        {
            String name = m.getName();

            //判断javabean中是否只有set/get/toString方法
            if (!name.startsWith("set") && !name.startsWith("get") && !name.startsWith("toString")) {
                return false;
            }
        }
        return true;
    }

    public static Boolean isNumber(Field field){
        return field.getGenericType().toString().equals("class java.math.BigDecimal")
                || field.getGenericType().toString().equals("class java.lang.Long")
                || field.getGenericType().toString().equals("class java.lang.Byte")
                || field.getGenericType().toString().equals("class java.lang.Integer")
                || field.getGenericType().toString().equals("class java.lang.Double")
                || field.getGenericType().toString().equals("class java.lang.Float")
                || field.getGenericType().toString().equals("class java.lang.Short")
                || field.getGenericType().toString().equals("int")
                || field.getGenericType().toString().equals("short")
                || field.getGenericType().toString().equals("byte")
                || field.getGenericType().toString().equals("float")
                || field.getGenericType().toString().equals("long")
                || field.getGenericType().toString().equals("double");
    }
}

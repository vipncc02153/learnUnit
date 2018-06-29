package pers.huangpy.main.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class AllFieldAndReadMethod {

    public static Map<String,Method> getAllMethod(Class<? extends Object> clazz){
        Map<String,Method> allMethods = new HashMap<>();

        Field[] fields = getAllDeclaredFields(clazz);
        Method[] allDeclaredMethod = clazz.getMethods();

        for(Field field: fields){
            String fieldReadMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            for(Method method: allDeclaredMethod){
                if(method.getName().equals(fieldReadMethodName)){
                    allMethods.put(field.getName(),method);
                }
            }
        }

        return allMethods;
    }

    public static Field[] getAllDeclaredFields(Class<? extends Object> clazz){
        List<Field> allFields = new ArrayList<>();

        Class<? extends Object> currentClz = clazz;

        //使用
        while(currentClz != null){
            Collections.addAll(allFields, currentClz.getDeclaredFields());
            currentClz = currentClz.getSuperclass();
        }
        return allFields.toArray(new Field[0]);

    }

}

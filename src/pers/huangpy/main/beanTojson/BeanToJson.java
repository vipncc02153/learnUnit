package pers.huangpy.main.beanTojson;

import pers.huangpy.main.util.AllFieldAndReadMethod;
import pers.huangpy.main.util.DateUtil;
import pers.huangpy.main.util.ObjectUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Created by ss on 2018/6/24.
 */
public class BeanToJson {

    public static String beanToJson(Object bean){
        Class<? extends Object> clazz = bean.getClass();
        Field[] fields = AllFieldAndReadMethod.getAllDeclaredFields(clazz);
        Map<String, Method> methods = AllFieldAndReadMethod.getAllMethod(clazz);
        //Map<String, String> result = new HashMap<>();
        StringBuilder json = new StringBuilder("{");
        Integer index = 0;

        try{
            for(Field field : fields){
                Method method = methods.get(field.getName());
                Object invoke = method.invoke(bean);
                json.append(invokeToResult(invoke, field));

            }

        }catch(Exception e){
            e.printStackTrace();
        }

        json = new StringBuilder(json.substring(0, json.length() - 2));
        json.append("}");

        return json.toString();
    }

    public static String beanToJson2(Object testBean1){
        Field[] fields = AllFieldAndReadMethod.getAllDeclaredFields(testBean1.getClass());
        StringBuilder json = new StringBuilder("{");
        for(Field field : fields){
            try {
                field.setAccessible(true);
                Object invoke = field.get(testBean1);
                json.append(invokeToResult2(invoke, field));
            }catch(Exception e){

                e.printStackTrace();
            }
        }
        json = new StringBuilder(json.substring(0, json.length() - 2));
        json.append("}");
        return json.toString();
    }

    private static String invokeToResult(Object invoke,Field field){
        if (invoke != null ) {
            if(ObjectUtil.isNumber(field)) {
                return "\"" + field.getName() + "\"" + ":" + invoke.toString() + ", ";
            }else if(ObjectUtil.isBean(invoke)){
                return "\"" + field.getName() + "\"" + ":" + beanToJson(invoke) + ", ";
            }else if(field.getGenericType().toString().equals("class java.util.Date")){
                return "\"" + field.getName() + "\"" + ":" + "\"" + DateUtil.formatDateObj(invoke) + "\"" + ", ";
            }else{
                return "\"" + field.getName() + "\"" + ":" + "\"" + invoke.toString() + "\"" + ", ";
            }
        }
        return "";
    }

    private static String invokeToResult2(Object invoke,Field field){
        if (invoke != null ) {
            if(ObjectUtil.isNumber(field)) {
                return "\"" + field.getName() + "\"" + ":" + invoke.toString() + ", ";
            }else if(ObjectUtil.isBean(invoke)){
                return "\"" + field.getName() + "\"" + ":" + beanToJson2(invoke) + ", ";
            }else if(field.getGenericType().toString().equals("class java.util.Date")){
                return "\"" + field.getName() + "\"" + ":" + "\"" + DateUtil.formatDateObj(invoke) + "\"" + ", ";
            }else{
                return "\"" + field.getName() + "\"" + ":" + "\"" + invoke.toString() + "\"" + ", ";
            }
        }
        return "";
    }
}

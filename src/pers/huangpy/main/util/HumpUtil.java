package pers.huangpy.main.util;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.sun.xml.internal.ws.util.StringUtils;
import pers.huangpy.main.appointtask.TaskDTO;

import javax.management.StringValueExp;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HumpUtil {

    public static void toCamel(){
        System.out.println("请输入所需操作，0-转驼峰，1-转下划线:");
        boolean flag;
        Scanner input = new Scanner(System.in);
        if(input.nextLine().equals("0")) {
            flag = true;
        }else {
            flag = false;
        }

        System.out.println("请输入需要转换的字符串，输入空行结束:");

        List<String> list = new ArrayList<>();

        while(true){
            String str = input.nextLine();
            if(str.isEmpty()){
                break;
            }
            list.add(str);
        }

        if(flag){
            toHump(list);
        }else{
            toLine(list);
        }

    }

    private static void toHump(List<String> list) {

        for (String str : list) {
            Pattern linePattern1 = Pattern.compile("\\s(\\w)");
            Pattern linePattern2 = Pattern.compile("_(\\w)");

            str = str.toLowerCase();
            str = replaceString(str, linePattern1);
            str = replaceString(str, linePattern2);

            System.out.println(str);
        }
    }

    private static String replaceString(String str, Pattern linePattern1) {
        Matcher matcher1 = linePattern1.matcher(str);
        StringBuffer sb1 = new StringBuffer();
        while(matcher1.find()){
            matcher1.appendReplacement(sb1, matcher1.group(1).toUpperCase());
        }
        matcher1.appendTail(sb1);
        return sb1.toString();
    }


    private static void toLine(List<String> list){
        list.forEach(c->{
            String separator = "_";
            c = c.replaceAll("([a-z])([A-Z])", "$1" + separator + "$2").toUpperCase();
            System.out.println(c);
        });
    }

    public static void maintest(){
        Map<String, String> map2  = new HashMap<>();
        map2.put("1", "a");
        map2.put("2", "b");

        Map<String, String> map3  = new HashMap<>();
        map3.put("3", "c");
        map3.put("4", "d");

        List<Map<String, String>> list = new ArrayList<>();
        list.add(map2);
        list.add(map3);

        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println(json );

        List<Map<String, String>> list2 = gson.fromJson(json, List.class);
        System.out.println(list2.toString());
    }

    public static void maintest2(){
        TaskDTO customer = new TaskDTO();
        customer.setTaskId(123L);
        customer.setIpAddress("123:123:123:123");
        customer.setCreateTime(new Timestamp(System.currentTimeMillis()));
        customer.setAmount(new BigDecimal("123.12").setScale(2, BigDecimal.ROUND_HALF_UP));
        for (Field declaredField : TaskDTO.class.getDeclaredFields()) {
            try {
                Field beanField = TaskDTO.class.getDeclaredField(declaredField.getName());
                Method method = TaskDTO.class.getMethod("get" + StringUtils.capitalize(declaredField.getName()));
                Object val = method.invoke(customer);
                String fieldValue = "";
                if(beanField.getType().getSimpleName().equals(BigDecimal.class.getSimpleName())){
                    if(val != null){
                        BigDecimal bigDecimal = (BigDecimal) val;
                        fieldValue = bigDecimal.toPlainString();
                    }
                }else if(beanField.getType().getSimpleName().equals(Timestamp.class.getSimpleName())){
                    if(val != null){
                        Timestamp timestamp = (Timestamp) val;
                        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
                        fieldValue = sdf.format(timestamp.getTime());
                    }
                }else{
                    if(val != null){
                        fieldValue = String.valueOf(val);
                    }
                }

                if(fieldValue != null && !fieldValue.equals("")) {
                    System.out.println(fieldValue);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

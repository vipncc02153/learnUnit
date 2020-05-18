package pers.huangpy.main.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClameUtil {

    public static void toCamel(){
        //System.out.println("请输入转换前字符串类型，0-下划线，1-空格:");
        Scanner input = new Scanner(System.in);

        System.out.println("请输入需要转换的字符串，输入空行结束:");

        List<String> list = new ArrayList<>();
        while(true){
            String str = input.nextLine();
            if(str.isEmpty()){
                break;
            }
            list.add(str);
        }

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
}

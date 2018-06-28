package pers.huangpy.main.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUtil {

    public static String formatDateObj(Object invoke){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置显示格式
        return dateFormat.format(invoke);
    }
}

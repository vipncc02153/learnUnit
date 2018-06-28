package pers.huangpy.test.beanTojsonUnit;

import pers.huangpy.main.beanTojson.BeanToJson;

import java.math.BigDecimal;
import java.util.Date;

public class BeanToJsonUnit {
    public static void beanToJsonUnit(){
        RentDTO rentDTO = new RentDTO(1,"科兴",
                new BigDecimal(100.1).setScale(2,BigDecimal.ROUND_HALF_DOWN),"101A","一号公司");
        rentDTO.setCreateBy("huang");
        rentDTO.setNum(1);

        Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间

        rentDTO.setCreateDate(dt);

        TestBean1<String> testBean1 = (TestBean1<String>) CreateTestBean.createTest1();
        System.out.println(BeanToJson.beanToJson2(testBean1));
        System.out.println(BeanToJson.beanToJson(rentDTO));
    }
}

package pers.huangpy.test.beanTojsonUnit;

import java.math.BigDecimal;

public class CreateTestBean {

    public static Object createTest1(){
        TestBean1<String> bean1 = new TestBean1<>();
        bean1.setString1("sting1");
        StringBuilder builder = new StringBuilder();
        builder.append("string2");
        bean1.setStringBuilder(builder);
        bean1.setInt1(10);
        bean1.setLong2(20l);
        bean1.setLong1(30l);
        bean1.setByte1((byte)1);
        bean1.setByte2((byte)2);
        bean1.setBool2(true);
        bean1.setBool1(false);
        bean1.setBigDecimal1(new BigDecimal(1000.0));
        bean1.setDouble1(10.0);
        bean1.setDouble2(20.1);
        bean1.setObject("string3");
        TestBean1<String> bean2 = new TestBean1<>();
        bean1.setBean(bean2);
        bean1.setType("string4");

        return bean1;
    }
}

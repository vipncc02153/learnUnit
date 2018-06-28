package pers.huangpy.test.beanTojsonUnit;

import java.io.Serializable;
import java.math.BigDecimal;

public class TestBean1<T> implements Serializable {
    private String string1;
    private Integer int1;
    private TestBean1 bean;
    private Long long1;
    private long long2;
    private BigDecimal bigDecimal1;
    private StringBuilder stringBuilder;
    private Object object;
    private byte byte1;
    private Byte byte2;
    private Boolean bool2;
    private boolean bool1;
    private Double double1;
    private double double2;
    private T type;

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public Integer getInt1() {
        return int1;
    }

    public void setInt1(Integer int1) {
        this.int1 = int1;
    }

    public TestBean1 getBean() {
        return bean;
    }

    public void setBean(TestBean1 bean) {
        this.bean = bean;
    }
    public Long getLong1() {
        return long1;
    }

    public void setLong1(Long long1) {
        this.long1 = long1;
    }

    public BigDecimal getBigDecimal1() {
        return bigDecimal1;
    }

    public void setBigDecimal1(BigDecimal bigDecimal1) {
        this.bigDecimal1 = bigDecimal1;
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public void setStringBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public long getLong2() {
        return long2;
    }

    public void setLong2(long long2) {
        this.long2 = long2;
    }

    public byte getByte1() {
        return byte1;
    }

    public void setByte1(byte byte1) {
        this.byte1 = byte1;
    }

    public Byte getByte2() {
        return byte2;
    }

    public void setByte2(Byte byte2) {
        this.byte2 = byte2;
    }

    public Boolean getBool2() {
        return bool2;
    }

    public void setBool2(Boolean bool2) {
        this.bool2 = bool2;
    }

    public boolean getBool1() {
        return bool1;
    }

    public void setBool1(boolean bool1) {
        this.bool1 = bool1;
    }

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

    public Double getDouble1() {
        return double1;
    }

    public void setDouble1(Double double1) {
        this.double1 = double1;
    }

    public double getDouble2() {
        return double2;
    }

    public void setDouble2(double double2) {
        this.double2 = double2;
    }
}

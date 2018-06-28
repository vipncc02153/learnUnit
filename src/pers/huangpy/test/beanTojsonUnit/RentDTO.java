package pers.huangpy.test.beanTojsonUnit;

import java.math.BigDecimal;

public class RentDTO extends Rent {
    private Integer id;
    private String address;
    private BigDecimal price;
    private String numberPlate;
    private String company;


    private int num;

    public RentDTO(){

    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public RentDTO(Integer id, String address, BigDecimal price, String numberPlate, String company) {
        this.id = id;
        this.address = address;
        this.price = price;
        this.numberPlate = numberPlate;
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "RentDTO{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", numberPlate='" + numberPlate + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}

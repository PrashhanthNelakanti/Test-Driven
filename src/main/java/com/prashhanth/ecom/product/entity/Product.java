package com.prashhanth.ecom.product.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "product",schema="public")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pid;
    private float price;
    private String pname;
    private String countryOrign;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCountryOrign() {
        return countryOrign;
    }

    public void setCountryOrign(String countryOrign) {
        this.countryOrign = countryOrign;
    }
}

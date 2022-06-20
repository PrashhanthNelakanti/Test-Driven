package com.prashhanth.tdd.product.entity;

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
}

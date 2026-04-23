package com.trisha.productapp.dto;

import com.trisha.productapp.entity.Product;
import jakarta.validation.constraints.*;

public class ProductDTO {

    private Integer id;
    @NotBlank
    private String name;
    @Positive
    private double price;

    public ProductDTO() {
    }

    public ProductDTO(Integer id, String name,double price){
        this.id=id;
        this.name=name;
        this.price=price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}

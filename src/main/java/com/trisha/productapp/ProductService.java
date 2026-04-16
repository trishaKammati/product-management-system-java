package com.trisha.productapp;

import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class ProductService {

    List<Product> products=new ArrayList<>();


    public Product addProduct( Product product){
        products.add(product);
        System.out.println(products);
        return product;
    }


    public List<Product> getAllProducts(){
        return products;
    }


    public Product getProduct(int id){
        for(Product p: products){
            if(p.getId()==id){
                return p;
            }
        }
       // return null;
        throw new RuntimeException("Product not found");
    }


    public String deleteProduct(int id){
        for(Product p: products){
            if(p.getId() == id){
                products.remove(p);
                return null;
            }
        }
        throw new RuntimeException("Product not found");
    }


    public Product updateProduct(int id, Product newProduct){
        for(Product p: products){
            if(p.getId()==id){
                p.setName(newProduct.getName());
            }
            return newProduct;
        }
        throw new RuntimeException("Product not found");
    }
}



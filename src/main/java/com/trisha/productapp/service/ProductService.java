package com.trisha.productapp.service;

import com.trisha.productapp.dto.ProductDTO;
import com.trisha.productapp.entity.Product;
import com.trisha.productapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductDTO addProduct(ProductDTO dto){
        Product entity=convertToEntity(dto);
        Product saved=repository.save(entity);
        return convertToDTO(saved);

    }

    public List<ProductDTO> getAllProducts(){
        List<Product> products = repository.findAll();
        List<ProductDTO> dtoList=new ArrayList<>();
        for (Product p: products) {
          dtoList.add(convertToDTO(p));
        }
        return dtoList;
    }

    public ProductDTO getProductById(int id){
        Product product=repository.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found"));

        return convertToDTO(product);
    }

    public void deleteProduct(int id){
        Product existing=repository.findById(id).orElseThrow(()->new RuntimeException("Product Not found"));
        repository.deleteById(id);

    }

    public ProductDTO updateProduct(int id, ProductDTO newDto){
        Product existing=repository.findById(id).orElseThrow(()->new RuntimeException("Product Not found"));
        existing.setName(newDto.getName());
        existing.setPrice(newDto.getPrice());
        Product updated=repository.save(existing);
        return convertToDTO(updated);
    }

    public ProductDTO convertToDTO(Product product){

        if(product == null) return null;

        return new ProductDTO(product.getId(), product.getName(), product.getPrice());
    }
    public Product convertToEntity(ProductDTO dto){
        if (dto == null) return null;
        return new Product(dto.getName(), dto.getPrice());

    }


}

/*


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
    }*/

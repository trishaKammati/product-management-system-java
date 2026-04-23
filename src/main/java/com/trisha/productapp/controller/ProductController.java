package com.trisha.productapp.controller;

import com.trisha.productapp.response.ApiResponse;
import com.trisha.productapp.service.ProductService;
import com.trisha.productapp.dto.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {

      @Autowired
      ProductService service;

     @PostMapping("/add")
      public ResponseEntity<ApiResponse> addProduct(@Valid @RequestBody ProductDTO dto){

            return ResponseEntity.ok(
                    ApiResponse.created(service.addProduct(dto))
            );
      }


      @GetMapping("/products")
      public ResponseEntity<ApiResponse> getAllProducts(){
            return ResponseEntity.ok(
                   ApiResponse.success(service.getAllProducts())
            );
      }

      @GetMapping("/products/{id}")
      public ResponseEntity<ApiResponse> getProductById(@PathVariable int id){
            return ResponseEntity.ok(
                    ApiResponse.success(service.getProductById(id))
            );
      }

      @DeleteMapping("/products/{id}")
      public ResponseEntity<ApiResponse> deleteProduct(@PathVariable int id){
          service.deleteProduct(id);
            return ResponseEntity.ok(
                    ApiResponse.deleted()
            );
      }

      @PutMapping("/products/{id}")
      public ResponseEntity<ApiResponse> updateProduct(@PathVariable int id,@RequestBody ProductDTO newDto){
            return ResponseEntity.ok(
                   ApiResponse.success(service.updateProduct(id,newDto))
            );
      }
}

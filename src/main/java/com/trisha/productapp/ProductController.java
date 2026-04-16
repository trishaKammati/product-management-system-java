package com.trisha.productapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class ProductController {

      @Autowired
      ProductService service;

      @PostMapping("/add")
      public ResponseEntity<ApiResponse> addProduct(@RequestBody Product product){
            return ResponseEntity.ok(
                    new ApiResponse("Product added",service.addProduct(product))
            );
      }


      @GetMapping("/products")
      public ResponseEntity<ApiResponse> getAllProducts(){
            return ResponseEntity.ok(
                   new ApiResponse("Products fetched", service.getAllProducts())
            );
      }

      @GetMapping("/product/{id}")
      public ResponseEntity<ApiResponse> getProduct(@PathVariable int id){
            return ResponseEntity.ok(
                    new ApiResponse("Product fetched", service.getProduct(id))
            );
      }

      @DeleteMapping("/product/{id}")
      public ResponseEntity<ApiResponse> deleteProduct(@PathVariable int id){
            return ResponseEntity.ok(
                    new ApiResponse("Product deleted",service.deleteProduct(id))
            );
      }

      @PutMapping("/product/{id}")
      public ResponseEntity<ApiResponse> updateProduct(@PathVariable int id,@RequestBody Product newProduct){
            return ResponseEntity.ok(
                   new ApiResponse("Product updated",service.updateProduct(id,newProduct))
            );
      }
}

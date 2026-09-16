package com.example.ecomproject.controller;


import com.example.ecomproject.model.Product;
import com.example.ecomproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService service;



    @GetMapping("/products")
    public List<Product>getallproducts(){
        return service.getallproducts();
    }


    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id){

        return service.getProductById(id);
    }

    @PostMapping(value = "/products", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> addProduct(
            @RequestPart("product") Product product,
            @RequestPart("imageFile") MultipartFile imageFile) {
        try {
            Product product1= service.addProduct(product, imageFile);
            return new ResponseEntity<>(product1,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/products/{id}/image")
    public ResponseEntity<byte[]>getImageByProductId(@PathVariable int id){
        Product product = service.getProductById(id);
        byte[] imageFile = product.getImageData();
        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(imageFile);
    }

        @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart("product") Product product,
                                                @RequestPart("imageFile") MultipartFile imageFile){
            Product product1= null;
            try {
                product1 = service.updateProduct(id,product,imageFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if(product1!=null){
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("NotUpdated",HttpStatus.BAD_REQUEST);
        }

    }
    @DeleteMapping("products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id){
        Product product = service.getProductById(id);
        if(product != null){
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted successfuly",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Product not found",HttpStatus.NOT_FOUND);
        }



    }
    @GetMapping("/products/search")
    public ResponseEntity<List<Product>>searchProducts(@RequestParam String keyword){
        System.out.println("Searching with "+keyword);
        List<Product> products = service.searchProducts(keyword);
        return new ResponseEntity<>(products,HttpStatus.OK);

    }
}

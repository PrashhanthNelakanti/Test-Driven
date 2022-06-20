package com.prashhanth.tdd.product.controller;

import com.prashhanth.tdd.product.entity.Product;
import com.prashhanth.tdd.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts(){
        return (List<Product>) productService.getAllProducts();
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        return productService.removeProduct(id);
    }
}

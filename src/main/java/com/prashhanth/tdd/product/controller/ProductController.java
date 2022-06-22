package com.prashhanth.tdd.product.controller;

import com.prashhanth.tdd.product.entity.Product;
import com.prashhanth.tdd.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        logger.info("Adding a new Product:"+product);
        return productService.addProduct(product);
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts(){
        List<Product> allProducts = productService.getAllProducts();
        logger.info("Fetching all Products with count:"+allProducts.size());
        return allProducts;
    }

    @GetMapping("/getProduct/{pid}")
    public Product getProduct(@PathVariable("pid") Integer pid){
        Product product = productService.getProductById(pid);
        logger.info("Product to be fetched by pid"+product);
        return product;
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product product) {
        logger.info("Product to be updated:"+product);
        return productService.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        logger.info("Producted to be deleted:"+id);
        return productService.removeProduct(id);
    }
}

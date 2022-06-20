package com.prashhanth.tdd.product.service;

import com.prashhanth.tdd.product.entity.Product;
import com.prashhanth.tdd.product.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepo.findAll();
    }

    public String removeProduct(Integer id) {
        Product product = productRepo.findProductByPid(id);
        productRepo.delete(product);
        return "Product removed ID:" + id;
    }

    public Product updateProduct(Product updatedProduct) {
        Product product = productRepo.findProductByPid(updatedProduct.getPid());
        product.setPname(updatedProduct.getPname());
        product.setPrice(updatedProduct.getPrice());
        product.setCountryOrign(updatedProduct.getCountryOrign());
        return productRepo.save(updatedProduct);
    }
}

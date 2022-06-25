package com.prashhanth.ecom.product.service;

import com.prashhanth.ecom.product.entity.Product;
import com.prashhanth.ecom.product.repo.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepo productRepo;

    public Product addProduct(Product product) {
        logger.info("Product added is:"+product);
        return productRepo.save(product);
    }

    public List<Product> getAllProducts() {
        List<Product> products = (List<Product>) productRepo.findAll();
        logger.info("Products available is:"+products);
        return (List<Product>) productRepo.findAll();
    }

    public String removeProduct(Integer id) {
        Product product = productRepo.findProductByPid(id);
        logger.info("Product to be removed is:"+product);
        productRepo.delete(product);
        return "Product removed ID:" + id;
    }

    public Product updateProduct(Product updatedProduct) {
        Product product = productRepo.findProductByPid(updatedProduct.getPid());
        logger.info("Product before update:"+product);
        product.setPname(updatedProduct.getPname());
        product.setPrice(updatedProduct.getPrice());
        product.setCountryOrign(updatedProduct.getCountryOrign());
        logger.info("Product after update:"+product);
        return productRepo.save(updatedProduct);
    }

    public Product getProductById(Integer pid) {
        Product product = productRepo.findProductByPid(pid);
        logger.info("Product found by pid :"+pid+" and product :"+product);
        return product;
    }
}

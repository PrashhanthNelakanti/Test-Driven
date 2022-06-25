package com.prashhanth.ecom.products;

import com.prashhanth.ecom.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestProductsRepo extends JpaRepository<Product,Integer> {
}

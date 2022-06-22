package com.prashhanth.tdd.products;

import com.prashhanth.tdd.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestProductsRepo extends JpaRepository<Product,Integer> {
}

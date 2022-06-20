package com.prashhanth.tdd.product.repo;

import com.prashhanth.tdd.product.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product,Integer> {
    @Query
    public Product findProductByPid(Integer pid);
}

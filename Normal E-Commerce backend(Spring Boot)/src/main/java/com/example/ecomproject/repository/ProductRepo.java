package com.example.ecomproject.repository;

import com.example.ecomproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    @Query("SELECT a from Product a WHERE "+
            "LOWER(a.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "+
            "LOWER(a.des) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "+
            "LOWER(a.brand) LIKE LOWER(CONCAT('%', :keyword, '%')) OR "+
            "LOWER(a.cate) LIKE LOWER(CONCAT('%', :keyword, '%'))  "
    )
    List<Product>searchProducts(String keyword);

}

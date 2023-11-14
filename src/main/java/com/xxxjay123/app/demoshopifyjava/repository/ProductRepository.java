package com.xxxjay123.app.demoshopifyjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xxxjay123.app.demoshopifyjava.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}

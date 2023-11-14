package com.xxxjay123.app.demoshopifyjava.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xxxjay123.app.demoshopifyjava.entity.Product;
import com.xxxjay123.app.demoshopifyjava.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

  @Autowired
  private ProductRepository productRepository;

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public Optional<Product> getProductById(Long productId) {
    return productRepository.findById(productId);
  }

  public Product createProduct(Product product) {
    return productRepository.save(product);
  }

  public Product updateProduct(Long productId, Product updatedProduct) {
    if (productRepository.existsById(productId)) {
      updatedProduct.setProductId(productId);
      return productRepository.save(updatedProduct);
    }
    return null; // Handle not found case
  }

  public void deleteProduct(Long productId) {
    productRepository.deleteById(productId);
  }

}

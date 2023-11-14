package com.xxxjay123.app.demoshopifyjava.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xxxjay123.app.demoshopifyjava.entity.Product;
import com.xxxjay123.app.demoshopifyjava.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping("/get-all-product")
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @GetMapping("/{productId}")
  public ResponseEntity<Product> getProductById(@PathVariable Long productId) {
    Optional<Product> product = productService.getProductById(productId);
    return product.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping("/create-product")
  public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    Product createdProduct = productService.createProduct(product);
    return ResponseEntity.ok(createdProduct);
  }

  @PutMapping("/{productId}")
  public ResponseEntity<Product> updateProduct(@PathVariable Long productId,
      @RequestBody Product updatedProduct) {
    Product product = productService.updateProduct(productId, updatedProduct);
    return product != null ? ResponseEntity.ok(product)
        : ResponseEntity.notFound().build();
  }

  @DeleteMapping("/{productId}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
    productService.deleteProduct(productId);
    return ResponseEntity.noContent().build();
  }
}

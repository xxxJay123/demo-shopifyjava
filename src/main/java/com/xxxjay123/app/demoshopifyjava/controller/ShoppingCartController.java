package com.xxxjay123.app.demoshopifyjava.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xxxjay123.app.demoshopifyjava.entity.ShoppingCart;
import com.xxxjay123.app.demoshopifyjava.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/shopping-carts")
@RequiredArgsConstructor
public class ShoppingCartController {
  @Autowired
  private ShoppingCartService shoppingCartService;

  @GetMapping("/{cartId}")
  public ResponseEntity<ShoppingCart> getShoppingCartById(
      @PathVariable Long cartId) {
    Optional<ShoppingCart> shoppingCart =
        shoppingCartService.getShoppingCartById(cartId);
    return shoppingCart.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping("/create")
  public ResponseEntity<ShoppingCart> createShoppingCart(
      @RequestBody ShoppingCart shoppingCart) {
    ShoppingCart createdShoppingCart =
        shoppingCartService.createShoppingCart(shoppingCart);
    return ResponseEntity.ok(createdShoppingCart);
  }

  @DeleteMapping("/{cartId}")
  public ResponseEntity<Void> deleteShoppingCart(@PathVariable Long cartId) {
    shoppingCartService.deleteShoppingCart(cartId);
    return ResponseEntity.noContent().build();
  }
}

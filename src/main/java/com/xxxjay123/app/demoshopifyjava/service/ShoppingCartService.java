package com.xxxjay123.app.demoshopifyjava.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xxxjay123.app.demoshopifyjava.entity.ShoppingCart;
import com.xxxjay123.app.demoshopifyjava.repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {

  @Autowired
  private ShoppingCartRepository shoppingCartRepository;

  public Optional<ShoppingCart> getShoppingCartById(Long cartId) {
    return shoppingCartRepository.findById(cartId);
  }

  public ShoppingCart createShoppingCart(ShoppingCart shoppingCart) {
    return shoppingCartRepository.save(shoppingCart);
  }

  public void deleteShoppingCart(Long cartId) {
    shoppingCartRepository.deleteById(cartId);
  }
}

package com.xxxjay123.app.demoshopifyjava.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cart_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long itemId;

  @ManyToOne
  @JoinColumn(name = "cart_id")
  private ShoppingCart shoppingCart;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  private int quantity;
}

package com.xxxjay123.app.demoshopifyjava.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderId;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  private LocalDateTime orderDate;
  private String orderStatus;
  private String shippingAddress;
}

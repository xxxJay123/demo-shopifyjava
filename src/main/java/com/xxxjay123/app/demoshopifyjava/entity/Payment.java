package com.xxxjay123.app.demoshopifyjava.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long paymentId;

  @ManyToOne
  @JoinColumn(name = "order_id")
  private Order order;

  private double amount;
  private LocalDateTime paymentDate;
  private String paymentMethod;

}

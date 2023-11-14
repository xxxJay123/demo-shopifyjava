package com.xxxjay123.app.demoshopifyjava.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;


  private String username;
  private String password;
  private String email;
  private String address;

}

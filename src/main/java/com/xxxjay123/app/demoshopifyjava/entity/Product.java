package com.xxxjay123.app.demoshopifyjava.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;
    private String description;
    private double price;
    private int stock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}

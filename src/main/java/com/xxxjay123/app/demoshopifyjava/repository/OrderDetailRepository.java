package com.xxxjay123.app.demoshopifyjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xxxjay123.app.demoshopifyjava.entity.OrderDetail;

public interface OrderDetailRepository
    extends JpaRepository<OrderDetail, Long> {

}

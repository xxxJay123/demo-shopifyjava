package com.xxxjay123.app.demoshopifyjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.xxxjay123.app.demoshopifyjava.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}

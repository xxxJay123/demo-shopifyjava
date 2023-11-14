package com.xxxjay123.app.demoshopifyjava.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xxxjay123.app.demoshopifyjava.entity.Payment;
import com.xxxjay123.app.demoshopifyjava.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {
  @Autowired
  private PaymentRepository paymentRepository;

  public List<Payment> getAllPayments() {
    return paymentRepository.findAll();
  }

  public Optional<Payment> getPaymentById(Long paymentId) {
    return paymentRepository.findById(paymentId);
  }

  public Payment createPayment(Payment payment) {
    return paymentRepository.save(payment);
  }

  public Payment updatePayment(Long paymentId, Payment updatedPayment) {
    if (paymentRepository.existsById(paymentId)) {
      updatedPayment.setPaymentId(paymentId);
      return paymentRepository.save(updatedPayment);
    }
    return null; // Handle not found case
  }

  public void deletePayment(Long paymentId) {
    paymentRepository.deleteById(paymentId);
  }
}

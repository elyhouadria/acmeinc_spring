package com.elyhouadria.acmeinc.services;

import com.elyhouadria.acmeinc.entities.Payment;
import com.elyhouadria.acmeinc.exceptions.PaymentNotFoundException;
import com.elyhouadria.acmeinc.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServices {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentServices(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> findAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment updatePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment findPaymentById(Integer id) {
        return paymentRepository.findPaymentById(id)
                .orElseThrow(() -> new PaymentNotFoundException("Payment by id: " + id + " was not found"));
    }

    public void deletePaymentById(Integer id) {
        paymentRepository.deletePaymentById(id);
    }

}

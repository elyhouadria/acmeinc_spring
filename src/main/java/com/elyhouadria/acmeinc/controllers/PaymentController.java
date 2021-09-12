package com.elyhouadria.acmeinc.controllers;
import com.elyhouadria.acmeinc.entities.Payment;
import com.elyhouadria.acmeinc.services.PaymentServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentServices paymentServices;

    public PaymentController(PaymentServices paymentServices) {
        this.paymentServices = paymentServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentServices.findAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Payment> findPaymentById(@PathVariable("id") Integer id) {
        Payment payment = paymentServices.findPaymentById(id);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Payment> addPayment(@Valid
                                              @RequestBody Payment payment) {
        Payment newPayment = paymentServices.addPayment(payment);
        return new ResponseEntity<>(newPayment, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Payment> updatePayment(@Valid
                                                 @RequestBody Payment payment) {
        Payment updatePayment = paymentServices.updatePayment(payment);
        return new ResponseEntity<>(updatePayment, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePayment(@PathVariable("id") Integer id) {
        paymentServices.deletePaymentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.example.postgresdemo.controller;

import com.example.postgresdemo.model.Payment;
import com.example.postgresdemo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/payments")
    public Page<Payment> getQuestions(Pageable pageable) {
        return paymentRepository.findAll(pageable);
    }


    @PostMapping("/payments")
    public Payment createQuestion(@Valid @RequestBody Payment question) {
        return paymentRepository.save(question);
    }

}

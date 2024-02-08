package dev.hrpayroll.services;

import org.springframework.stereotype.Service;

import dev.hrpayroll.entities.Payment;

@Service
public class PaymentService {
    
    public Payment getPayment(long workerId, Integer days) {
        return new Payment("Audalison", 200.0, days);
    }
}

package dev.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.hrpayroll.entities.Payment;
import dev.hrpayroll.entities.Worker;
import dev.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {
    @Autowired()
    private WorkerFeignClient workerFeignClient;
    
    public Payment getPayment(long workerId, Integer days) {
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}

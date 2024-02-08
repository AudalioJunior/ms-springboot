package dev.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dev.hrpayroll.entities.Payment;
import dev.hrpayroll.entities.Worker;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;
    
    public Payment getPayment(long workerId, Integer days) {
        Map<String, String> uriVariable = new HashMap<>();
        uriVariable.put("id", ""+workerId);
        

        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariable);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}

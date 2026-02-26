package com.demo.spring;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UPIPayment implements PaymentService{
    @Override
    public String pay(double amount) {
        return "Payment of "+amount+" made using Credit card";
    }
}

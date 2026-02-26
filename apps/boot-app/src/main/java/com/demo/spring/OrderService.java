package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private PaymentService paymentService;

@Autowired
    public OrderService(@Qualifier("netBankingPayment") PaymentService paymentService){
        this.paymentService=paymentService;
    }

    public void checkout(double amount){
        System.out.println(paymentService.pay(amount));
    }
}

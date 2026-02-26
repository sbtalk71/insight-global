package com.demo.spring.runners;

import com.demo.spring.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class OrderServiceRunner implements CommandLineRunner {

    @Value("${spring.profiles.active:default}")
    private String profileName;

   private OrderService orderService;

    public OrderServiceRunner(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) throws Exception {
        //if(args.length!=1) throw new IllegalArgumentException("wrong no of arguments..");
        System.out.println("Profile Name : "+profileName);
        orderService.checkout(5000);

    }
}

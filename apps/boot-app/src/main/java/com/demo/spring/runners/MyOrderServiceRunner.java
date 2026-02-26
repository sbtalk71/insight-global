package com.demo.spring.runners;

import com.demo.spring.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class MyOrderServiceRunner implements CommandLineRunner {

    @Value("${spring.profiles.active:default}")
    private String profileName;

   private OrderService orderService;

    public MyOrderServiceRunner(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) throws Exception {
       // if(args.length!=1) throw new IllegalArgumentException("wrong no of arguments..");
        //orderService.checkout(Double.parseDouble(args[0]));
        System.out.println("Profile Name : "+profileName);
        orderService.checkout(3000);

    }
}

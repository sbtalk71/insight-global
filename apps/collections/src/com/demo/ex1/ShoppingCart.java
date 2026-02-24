package com.demo.ex1;

import java.util.HashMap;

public class ShoppingCart {
    private HashMap<String, Integer> cart;

    public ShoppingCart(){
        this.cart=new HashMap<>();
    }

    public void addToCart(String item){
        if(cart.containsKey(item)){
            cart.put(item,cart.get(item)+1);
        }else{
            cart.put(item,1);
        }
    }

    public void removeFromCart(String item){
        if(cart.get(item)>1){
            cart.put(item,cart.get(item)-1);
        }else{
            cart.remove(item);
        }
    }

    public void displayCart(){
        System.out.println(cart);
    }
}

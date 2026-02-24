package com.demo.ex1;

public class NumConverter {
    public static void main(String[] args) {
        if(args.length!=1){
            System.out.println("enter only one entry");
            System.exit(1);
        }else {
            try {
                String input=args[0];
                Integer num=Integer.parseInt(input);
                System.out.println(num);
            }catch (NumberFormatException e){
               e.printStackTrace();
            }
        }
    }
}

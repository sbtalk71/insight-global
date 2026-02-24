package day3.exceptions;

public class ExceptionDemo {
    public static void main(String[] args) {
       try {
           int a = 10;
           int b = 10;
           double d = a / b;
           int[] nums=new int[3];
           System.out.println(nums[2]);
           System.out.println("No Exceptions..");

       }catch(ArithmeticException e){
           System.out.println(e);

       }catch(ArrayIndexOutOfBoundsException e){
           System.out.println(e);
       }finally {
           System.out.println("Finally executed...");
       }
        System.out.println("Normal flow resumed..");
    }
}

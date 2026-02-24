package day3.exceptions;

import day3.com.exceptions.InvalidAgeException;

public class ClubMain {
    public static void main(String[] args) {
        Club club= new Club();
try {
    club.checkAge(17);
}catch (RuntimeException e){
    System.out.println(e.getMessage());
}
        System.out.println("Club is open now...");
    }
}

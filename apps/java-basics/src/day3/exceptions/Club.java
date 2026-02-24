package day3.exceptions;

import day3.com.exceptions.InvalidAgeException;

public class Club {

    public void checkAge(int age) {
        try {
            if (age < 18 || age > 60) {

                throw new InvalidAgeException("Your age is not permitted..");
            } else {
                System.out.println("You are allowed to enter..");
            }
        } catch (InvalidAgeException e) {
            //System.out.println(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}


package day3.com.exceptions;

public class InvalidAgeException extends RuntimeException{
    public InvalidAgeException(){

    }
    public InvalidAgeException(String message){
    super(message);
    }
}

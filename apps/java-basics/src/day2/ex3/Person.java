package day2.ex3;

public class Person {
    private int id;
    private String name;

    public Person(int id, String name){
        this.id=id;
        this.name=name;
    }

    public String getDetails(){
        return this.id+" "+this.name;
    }
}

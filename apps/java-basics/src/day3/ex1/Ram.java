package day3.ex1;

public class Ram {
    private int capacity;
    private String make;
    Ram(int capacity, String make){
        this.capacity=capacity;
        this.make=make;
    }

    public void setCapacity(int capacity){
        this.capacity=capacity;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
}

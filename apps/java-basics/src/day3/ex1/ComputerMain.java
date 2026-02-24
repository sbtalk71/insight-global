package day3.ex1;

public class ComputerMain {
    public static void main(String[] args) {
        Ram ram=new Ram(32,"Samsung");

        Computer computer=new Computer(ram);

        System.out.println(computer.getRam().getCapacity());
        System.out.println(computer.getRam().getMake());
    }
}

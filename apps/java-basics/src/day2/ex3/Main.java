package day2.ex3;

public class Main {
    public static void main(String[] args) {

        Employee emp= new Employee(100,"Shantanu",40000);

        System.out.println(emp.getDetails());

        TraineeEmp te= new TraineeEmp(101,"Amith",56000,"good");

        System.out.println(te.getDetails());

        Person p=emp;
        printDetails(p);


        p=te;
        printDetails(p);

        //emp =(Employee) p;

    }

    public static void printDetails(Person p){
        System.out.println(p.getDetails());
    }
}

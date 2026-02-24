package day2.ex4;

public class FigureMain {
    public static void main(String[] args) {

        Figure ref;
        Triangle t= new Triangle(10,20);
        Rectangle r= new Rectangle(20,30);

        ref=r;
        System.out.println(ref.area());

        ref=t;
        System.out.println(ref.area());
    }
}

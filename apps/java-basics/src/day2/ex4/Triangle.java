package day2.ex4;

public class Triangle extends Figure{
    public Triangle(int dim1, int dim2) {
        super(dim1, dim2);
    }

    @Override
    public double area() {
        return (dim1*dim2)/2;
    }
}

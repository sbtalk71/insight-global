package day2.ex4;

public abstract class Figure {
    protected int dim1;
    protected int dim2;

    public Figure(int dim1, int dim2){
        this.dim1=dim1;
        this.dim2=dim2;
    }

    public abstract double area();
}

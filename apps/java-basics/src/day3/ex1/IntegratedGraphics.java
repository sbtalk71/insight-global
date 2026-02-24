package day3.ex1;

public class IntegratedGraphics implements GraphicCard{
    private int memory;
    private String make;

    @Override
    public void setMemory(int memory) {
        this.memory=memory;
    }

    @Override
    public int getMemory() {
        return this.memory;
    }

    @Override
    public void setMake(String make) {
        this.make=make;
    }

    @Override
    public String getMake() {
        return this.make;
    }
}

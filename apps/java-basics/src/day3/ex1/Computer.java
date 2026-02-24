package day3.ex1;

public class Computer {
    private Ram ram;
    private GraphicCard graphicCard;

    public Computer(Ram ram){
        this.ram=ram;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public GraphicCard getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(GraphicCard graphicCard) {
        this.graphicCard = graphicCard;
    }
}

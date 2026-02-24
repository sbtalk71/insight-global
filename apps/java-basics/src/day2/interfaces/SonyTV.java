package day2.interfaces;

public class SonyTV implements MyRemote{
    @Override
    public void switchOff() {
        System.out.println("SonyTV switched Off");
    }

    @Override
    public void switchOn() {
        System.out.println("SonyTV switched On");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("SonyTV set channel to "+ channel);
    }
}

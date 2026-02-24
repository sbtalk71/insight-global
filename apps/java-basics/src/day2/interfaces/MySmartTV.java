package day2.interfaces;

public class MySmartTV implements MyRemote{

    @Override
    public void switchOff() {
        System.out.println("SmartTV switched Off");
    }

    @Override
    public void switchOn() {
        System.out.println("SmartTV switched On");
    }

    @Override
    public void setChannel(int channel) {
        System.out.println("SmartTV set channel to "+ channel);
    }
    @Override
    public void connectToNetFlix() {
        System.out.println("Connected to Netflix");
    }

    @Override
    public void connectToPrime() {
        System.out.println("Connected to Prime");
    }
}

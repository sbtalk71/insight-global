package day2.interfaces;

public class RemoteMain {
    public static void main(String[] args) {
        MyRemote remote=new SonyTV();

        remote.switchOff();
        remote.switchOn();
        remote.setChannel(20);


        MyRemote remote2=new MySmartTV();

        remote2.connectToNetFlix();

        remote.connectToNetFlix();
    }
}

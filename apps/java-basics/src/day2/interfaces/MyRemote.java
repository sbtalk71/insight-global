package day2.interfaces;

public interface MyRemote {
    void switchOff();
    void switchOn();
    void setChannel(int channel);

    default void connectToNetFlix(){
        throw new IllegalArgumentException("Function not available");
    }

    default void connectToPrime(){
        throw new IllegalArgumentException("Function not available");
    }
}

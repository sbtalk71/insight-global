import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializerDemo {
    public static void main(String[] args) {

        Email email = new Email("hello");
        email.setToAddress("me@anywhere.com");
        email.setFromAddress("admin@admin.com");
        email.setContent("Checking serialization");
        try (

                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("emails.ser"));

        ) {
            for(int i=0;i<3;i++) {
                oos.writeObject(email);
                System.out.println("Serialization done...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

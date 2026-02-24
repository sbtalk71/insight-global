import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializerDemo {
    public static void main(String[] args) {
        try (
                FileInputStream fis = new FileInputStream("emails.ser");
                ObjectInputStream ois= new ObjectInputStream(fis);
        ) {

            while(true) {
                Email email = (Email) ois.readObject();
                System.out.println(email.getFromAddress() + " " + email.getContent());
            }
        } catch (EOFException e){
            System.out.println("deserialization complete");
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("demos.txt");
            int b = 0;
            while (b != -1) {
                b=fis.read();
                System.out.println((char)b);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" end of program..");
    }
}

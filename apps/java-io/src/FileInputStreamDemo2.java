import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamDemo2 {
    public static void main(String[] args) {

        try(
                FileInputStream fis=new FileInputStream("demo.txt");
                FileOutputStream fos= new FileOutputStream("demo2.txt",true)
                )
        {
            int b = 0;
            while ((b = fis.read()) != -1) {
                fos.write(b);

                System.out.print((char)b);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("end of program..");
    }
}

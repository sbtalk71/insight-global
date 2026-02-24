import java.io.*;

public class ReaderDemo {
    public static void main(String[] args) {
        try (
                FileReader reader = new FileReader("demo.txt");
                FileWriter writer = new FileWriter("demo3.txt");
                BufferedReader br=new BufferedReader(reader);
                BufferedWriter bw=new BufferedWriter(writer);
        ) {

            int b = 0;
            while ((b = br.read()) != -1) {
                bw.write(b);
                System.out.println((char) b);
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

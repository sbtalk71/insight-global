import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReaderDemo {
    public static void main(String[] args) {
        try(FileInputStream fis= new FileInputStream("details.properties");){
            Properties props= new Properties();
            props.load(fis);
            System.out.println(props.getProperty("name"));
            System.out.println(props.getProperty("location"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

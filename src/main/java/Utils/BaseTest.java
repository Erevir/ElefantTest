package Utils;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    private static Properties property;
    private FileInputStream file;

    @Before

    public void setup() throws IOException {

        driver = new DriverLoader().loadDriver();
        driver.get("https://www.elefant.ro");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Before
    public void loadFileProperty() throws FileNotFoundException {
        //using properties Class to create an object
        property = new Properties();
        //Call the file using
        file = new FileInputStream("C:\\Users\\veremia\\Desktop\\Test automation internship\\TestBVB\\src\\main\\resources\\browser.properties");
        //Load the file
        try {
            property.load(file);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static String getValue(String key) {
        return property.getProperty(key);
    }
//    @After
//    public void tearDown(){
//        driver.quit();
//    }
}

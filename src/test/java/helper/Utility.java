package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;

public class Utility {
    private static int createUserId = -1;
    public  static WebDriver driver;
    private static String createUsername;

    public static File getJSONSchema(String JSONFile) {
        return new File("src/test/java/helper/jsonSchemaData/" + JSONFile);
    }

    //ini digunakan untuk menyimpan user ID pada scenario Create New User
    public static void saveUserId(int userID){
        createUserId = userID;
    }

    // ini digunakan untuk mengambil user ID yang sudah disimpan pada method saveUserId, untuk kebutuhan update & delete user
    public static int getUserId(){
        return createUserId;
    }

    public static void startDriver (){
        // added manual driver
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public static void quitDriver(){
        driver.close();
    }

    public static void saveUsername(String username){
        createUsername = username;
    }

    public static String getUsername(){
        return createUsername;
    }
}

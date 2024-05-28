package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser {

    public static void main(String[] args) {
        System.out.println("Test");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User.DESKTOP-VN57FBP\\Downloads\\chromedriver.exe");

        // Kreiramo Chrome instancu
        WebDriver driver = new ChromeDriver();

        driver.get("https://amplitudo.me");
    }
}

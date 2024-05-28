package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser {

    public static void main(String[] args) {

        // ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User.DESKTOP-VN57FBP\\Downloads\\chromedriver.exe");

        // Onstanca Chrome browsera
        WebDriver driver = new ChromeDriver();

        // Otvaranje stranice
        driver.get("https://amplitudo.me");

        // Dobijanje title-a
        String pageTitle = driver.getTitle();
        System.out.println("Title: " + pageTitle);
        System.out.println("Title length: " + pageTitle.length());

        // Dobijanje URL-a
        String pageUrl = driver.getCurrentUrl();
        System.out.println("Page URL: " + pageUrl);

        // Provjera da li je URL siguran
        if (pageUrl.startsWith("https")) {
            System.out.println("URL is secure");
        } else {
            System.out.println("URL is not secure");
        }

        // Dobijanje page source-a
        String pageSource = driver.getPageSource();
        System.out.println("Page Source Length: " + pageSource.length());

        // Navigiranje do neke sub page
        driver.navigate().to("https://amplitudo.me/about-us/");
        System.out.println("Sub-page: https://amplitudo.me//");

        // Navigiranje nazad
        driver.navigate().back();

        // Navigiranje naprijed
        driver.navigate().forward();

        // Refresh
        driver.navigate().refresh();

        driver.quit();
    }
}

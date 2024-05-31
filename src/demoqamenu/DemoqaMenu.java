package demoqamenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DemoqaMenu {

    public static void main(String[] args) throws InterruptedException {
        // ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User.DESKTOP-VN57FBP\\Downloads\\chromedriver.exe");

        // Instanca Chrome browsera
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/select-menu");

        WebElement oldStyleSelectMenu = driver.findElement(By.id("oldSelectMenu"));
        System.out.println("oldSelect menu je tu.");

        // Dobijanje svih opcija iz dropdown menu-ja
        List<WebElement> options = oldStyleSelectMenu.findElements(By.tagName("option"));

        // Ispisivanje svih opcija
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        // Inicijalizacija Select objekta
        Select select = new Select(oldStyleSelectMenu);

        // Selektovanje opcije Purple preko indeksa
        select.selectByIndex(4);
        System.out.println("Selektovan je: " + select.getFirstSelectedOption().getText());

        Thread.sleep(2000);

        // Selektovanje opcije Magenta preko visible text-a
        select.selectByVisibleText("Magenta");
        System.out.println("Selektovana je: " + select.getFirstSelectedOption().getText());

        Thread.sleep(2000);

        // Selektovanje preko value-a
        String valueToSelect = "1";
        for (WebElement option : options) {
            if (option.getAttribute("value").equals(valueToSelect)) {
                option.click();
                System.out.println("Selektovana je: " + option.getText());
                break;
            }
        }

        Thread.sleep(2000);

        driver.quit();
    }
}

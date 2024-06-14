package challenge;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ClickButtons {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/Click-Buttons/index.html");

        // Izazov 1:
        WebElement button1 = driver.findElement(By.xpath("//span[@id='button1']"));
        button1.click();

        Thread.sleep(2000);

        // Izazov 2:
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        String cssSelector = "button[id='button2']";

        jsExecutor.executeScript("document.querySelector('" + cssSelector + "').click();");

        // Izazov 3:

        // Actions za Move & Click
        Actions actions = new Actions(driver);

        WebElement button3 = driver.findElement(By.xpath("//span[@id='button3']"));

        // Izvrsavanje Move & Click koriscenjem Actions
        actions.moveToElement(button3).click().perform();
        Thread.sleep(2000);

        driver.quit();


    }
}

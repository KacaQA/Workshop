package contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactUs {

    public static void main(String[] args) throws InterruptedException {
        // Instanca Chrome browsera
        WebDriver driver = new ChromeDriver();

        driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");

        WebElement firstName = driver.findElement(By.name("first_name"));
        WebElement lastName = driver.findElement(By.name("last_name"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement message = driver.findElement(By.name("message"));

        firstName.sendKeys("Katarina Test");
        lastName.sendKeys("Neko prezime");
        email.sendKeys("test@gmail.com");
        message.sendKeys("Neka testna poruka.");
        Thread.sleep(2000);

        WebElement submitBtn = driver.findElement(By.cssSelector("input[type='submit']"));
        submitBtn.click();

    }
}

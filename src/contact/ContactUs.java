package contact;


import org.testng.Assert;
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

        WebElement thankYou = driver.findElement(By.cssSelector("#contact_reply h1"));
        String givenMessage = thankYou.getText();
        Assert.assertEquals(givenMessage, "Thank You for your Message!");

        driver.navigate().back();

        WebElement resetBtn = driver.findElement(By.cssSelector("input[type='reset']"));
        resetBtn.click();

        submitBtn.click();
        Thread.sleep(2000);

        // Provjera poruka o greskama
        WebElement bodyMessage = driver.findElement(By.cssSelector("html"));
        String givenBodyMessage = bodyMessage.getText();
        System.out.println("Poruke koje su ispisane : " +givenBodyMessage);

        // Assert poruke o greskama
        Assert.assertTrue(givenBodyMessage.contains("Error: all fields are required"), "Poruka 'all fields are required' nije prikazana");
        Assert.assertTrue(givenBodyMessage.contains("Error: Invalid email address"), "Poruka 'Invalid email address' nije prikazana");

        driver.navigate().back();

        driver.quit();


    }
}

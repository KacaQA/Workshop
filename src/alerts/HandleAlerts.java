package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.Instant;

public class HandleAlerts {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Prvi alert
            driver.findElement(By.id("button1")).click();
            Alert alert = driver.switchTo().alert();

            // Uzimamo tekst
            String alertText = alert.getText();
            System.out.println("Tekst prvog alerta je " + alertText);

            // Prihvatamo alert
            alert.accept();

        } catch (Exception e) {
            System.out.println("Doslo je do greske : " + e.getMessage());
        }

        // Drugi alert
        try {
            driver.findElement(By.id("button2")).click();

            Thread.sleep(2000);

            driver.findElement(By.xpath("//button[text()='Close']")).click();
        } catch (Exception e) {
            System.out.println("Doslo je do greske " + e.getMessage());
        }

        // Treci alert (moram malo bolje da podesim wait)

//        try {
//            driver.findElement(By.id("button3")).click();
//
//            // Cekamo da se pojavi dugme nakon ucitavanja
//            WebElement ajaxButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#button1")));
//            ajaxButton.click();
//
//            // Cekamo da se alert pojavi
//            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//            String alertText = alert.getText();
//            System.out.println("Tekst alerta je: " + alertText);
//
//            // Prihvatamo alert
//            alert.accept();
//
//            // Zatvaramo modal
//            WebElement closeButton = driver.findElement(By.xpath("//button[@type='button' and @class='btn btn-default' and @data-dismiss='modal']"));
//            closeButton.click();
//
//            // Cekamo da se modal zatvori
//            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#myModalClick")));
//
//        } catch (Exception e) {
//            System.out.println("Doslo je do greske: " + e.getMessage());
//        }

//        // Cetvrti alert

        try {
            driver.findElement(By.id("button4")).click();

            Alert confirmBox = driver.switchTo().alert();
            String confirmBoxText = confirmBox.getText();
            System.out.println("Tekst confirm box-a: " + confirmBoxText);

            confirmBox.accept();

        } catch (Exception e) {
            System.out.println("Doslo je do greske: " + e.getMessage());
        }





    }
}

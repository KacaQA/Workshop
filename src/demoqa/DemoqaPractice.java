package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoqaPractice {

    public static void main(String[] args) {

        // Instanca Chrome browsera
        WebDriver driver = new ChromeDriver();

        try {

            driver.get("https://demoqa.com/automation-practice-form");

            // Eksplicitno cekanje za <label> element
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement sportsLabel = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='hobbies-checkbox-1']")));

            // Klik na <label> element povezan sa checkbox-om
            sportsLabel.click();
            System.out.println("Checkbox je cekiran klikom na label.");

            // Provjera da li je checkbox cekiran
            WebElement sportsCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
            if (sportsCheckbox.isSelected()) {
                System.out.println("Checkbox je uspjesno cekiran.");
            } else {
                System.out.println("Checkbox nije cekiran.");
            }

            // Nisam uspjela direkt preko checkboxa da cekiram Sports, jer mi je javljalo gresku
            // Doslo je do greske: element click intercepted: Element <input type="checkbox" id="hobbies-checkbox-1"
            // class="custom-control-input" value="1"> is not clickable at point (367, 463). Other element would
            // receive the click: <label title="" for="hobbies-checkbox-1" class="custom-control-label">...</label>
            // Pa sam preko labele, jer izgleda da postoji neka interakcija izmedju checkboxa i njegove label, pa
            // ometaju klik na checkbox

            // Cekamo da vidimo rezultat prije zatvaranja
            Thread.sleep(3000);

            // Klik na Reading koristeći labelu
            WebElement readingLabel = driver.findElement(By.xpath("//label[text()='Reading']"));
            readingLabel.click();


            // Provjera da li je Music selektovan
            WebElement musicCheckbox = driver.findElement(By.id("hobbies-checkbox-3"));
            if (musicCheckbox.isSelected()) {
                System.out.println("Music checkbox je selektovan.");
            } else {
                System.out.println("Music checkbox nije selektovan.");
            }

            Thread.sleep(3000);

            // Radio buttons
            WebElement radioBtns = driver.findElement(By.name("gender"));
            WebElement secondRadioBtnLabel = driver.findElement(By.xpath("//label[@for='gender-radio-2']"));
            WebElement secondRadioBtn = driver.findElement(By.id("gender-radio-2"));

            if (radioBtns.isEnabled()) {
                System.out.println("Radio buttons su enabled.");
                secondRadioBtnLabel.click();
            } else {
                System.out.println("Radio buttons nisu enabled.");
            }

            if (secondRadioBtn.isSelected()) {
                System.out.println("Drugi radio button je selektovan.");
            } else {
                System.out.println("Radio button nije selektovan.");
            }

            Thread.sleep(3000);

        } catch (Exception e) {
            System.out.println("Doslo je do greske: " + e.getMessage());
        } finally {

            driver.quit();
        }
    }
}
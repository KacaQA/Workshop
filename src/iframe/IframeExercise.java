package iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeExercise {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/IFrame/index.html");

        // Prebacujemo se na iframe
        driver.switchTo().frame("frame"); // ili driver.switchTo().frame("iframe-name");

        // Pronalazimo naslov i tekst u iframe-u
        WebElement greatServiceTitle = driver.findElement(By.xpath("//p[@class='sub-heading' and text()='GREAT SERVICE!']"));
        WebElement greatServiceText = driver.findElement(By.xpath("//p[@class='sub-heading' and text()='GREAT SERVICE!']/../../div[@class='caption']/p"));

        // Ispisujemo naslov i tekst
        System.out.println("Naslov: " + greatServiceTitle.getText());
        System.out.println("Tekst: " + greatServiceText.getText());

        // Vraćamo se na glavni sadrzaj
        driver.switchTo().defaultContent();

        driver.quit();

        }

}

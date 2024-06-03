package rahul;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RahulPractice {
    public static void main(String[] args) {

        // Instanca Chrome browsera
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Select second radio button
        WebElement radioBtn = driver.findElement(By.xpath("(//input[@name='radioButton'])[2]"));
        radioBtn.click();

        // Select second option
        WebElement secondOpt = driver.findElement(By.id("dropdown-class-example"));
        secondOpt.findElement(By.xpath("//option[3]")).click();

        // Select second checkbox
        WebElement secondCheck = driver.findElement(By.id("checkBoxOption2"));
        secondCheck.click();

        // Choose dynamically second row and print it from first table
        WebElement secondRow = driver.findElement(By.xpath("//table[@name='courses']//tr[3]"));
        System.out.println("Second row: " + secondRow.getText());

        // Print all positions from the second table
        List<WebElement> positions = driver.findElements(By.xpath("//div[@class='tableFixHead']//table[@id='product']//td[2]"));
        System.out.println("Positions from the second table:");
        for (WebElement position : positions) {
            System.out.println(position.getText());
        }

        // Print size of the second list
        List<WebElement> checkboxList = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println("Size of the second list: " + checkboxList.size());

        // Print all prices from the first table - my exercise
        List<WebElement> prices = driver.findElements(By.xpath("//table[@name='courses']//td[3]"));
        System.out.println("Prices are: ");
        for (WebElement price : prices) {
            System.out.println(price.getText());
        }

        // Print names from the second table - my exercise
        List<WebElement> names = driver.findElements(By.xpath("//div[@class='tableFixHead']//table[@id='product']//td[1]"));
        System.out.println("Names: ");
        for (WebElement name : names) {
            System.out.println(name.getText());
        }
        driver.quit();


    }
}

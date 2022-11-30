package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class EditPages {

    public static WebDriver driver;
    public  WebElement element;
    public  WebDriverWait wait;

    public EditPages (WebDriver driver){
        this.driver = driver;
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickMyAccount(){

        driver.switchTo().frame("home");
        element = driver.findElement(By.xpath("//a[@class='iac account']"));
        waitAndClick(element);
        System.out.println("My Account Clicked");
        driver.switchTo().defaultContent();
    }

    public void clickPersonalData(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("ciss"))));
        driver.switchTo().frame("ciss");
        element= driver.findElement(By.xpath("//li[@data-icon='personal-data']//a"));
        waitAndClick(element);
        System.out.println("Personal Data Clicked");
    }

    public void clickEditProfilePage(){
        element= driver.findElement(By.xpath("(//div[@class='links-menu__link-body'])[1]"));
        waitAndClick(element);
        System.out.println("Edit Profile clicked");
    }

    public void editFirstName(String firstName , String password){
        element = driver.findElement(By.xpath("//input[contains(@name, 'firstName')]"));
        element.clear();
        System.out.println("Input cleared");
        element.sendKeys(firstName);
        System.out.println("First Name edited");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        System.out.println("Password entered");
    }

    public void clickSaveChanges(){
        element = driver.findElement(By.id("id9"));
        waitAndClick(element);
        System.out.println("Save Changes Clicked");
    }

    public void waitAndClick(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
}

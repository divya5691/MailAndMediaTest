package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//import static signupTest.SignupTest.wait;

public class SignupPage {
    public static WebDriver driver;
    public static WebElement element;
    public static WebDriverWait wait;
    By login_button = By.xpath("//a[@title='Login']");

    public SignupPage(WebDriver driver) {
        this.driver =driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void clickLogin(){
        element= driver.findElement(login_button);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void setEmailId(String emailId){
        element =  driver.findElement(By.xpath("//input[@id='login-email']"));
        wait.until(ExpectedConditions.visibilityOf(element));
       element.sendKeys(emailId);
        System.out.println("Entered Email-id : " + emailId);
    }

    public void setPassword(String password){
        driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys(password);
        System.out.println("Entered Password : " + password);
    }

    public void clickLoginButton(){
        element = driver.findElement(By.xpath("//button[@type='submit' and @class='btn btn-block login-submit']"));
        element.click();
        System.out.println("Login button Clicked");
    }
}



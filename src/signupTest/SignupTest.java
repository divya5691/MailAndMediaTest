package signupTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.EditPages;
import pages.SignupPage;

import java.util.concurrent.TimeUnit;


public class SignupTest {

    public static WebDriver driver;
    public  WebElement element;

    public WebDriverWait wait;
    public  SignupPage signupPage;
    public  EditPages editPage;

    String email = "int_01@mail.com";
    String password = "3457576545635345" ;
    String firstName = "Divya";

    public static void main(String[] args) {
        System.out.println("Mail and Media Selenium Webdriver Test");
        SignupTest test = new SignupTest();
        test.setup();
        test.login();
        test.editProfile();
        test.verifySuccessMessage();
        test.verifyEditedName();
       // test.closeBrowser();

    }

    public void setup()  {

        // browser setup

        String chromeDriverPath = "C:/Program Files/Java/chromedriver.exe";
        String url = "https://mail.com";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
       // wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);

        // this is code to agree and continue

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='permission-core-iframe']")));
        driver.switchTo().frame(0);
        element= driver.findElement(By.xpath("//div[@class='banner-actions-container']/button"));
        element.click();
        driver.switchTo().defaultContent();
    }

    public void login(){
        signupPage = new SignupPage(driver);
        signupPage.clickLogin();
        signupPage.setEmailId(email);
        signupPage.setPassword(password);
        signupPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void editProfile(){
        editPage = new EditPages(driver);

        editPage.clickMyAccount();

        editPage.clickPersonalData();

        editPage.clickEditProfilePage();

        editPage.editFirstName(firstName, password);

        editPage.clickSaveChanges();
    }

    public void verifySuccessMessage(){
        boolean success_message_popup = driver.findElement(By.xpath("//div[contains(@class, 'wrapper--success')]")).isDisplayed();
        Assert.assertTrue(success_message_popup);

        String success_message = driver.findElement(By.xpath("//span[@class='hint-headline']")).getText();
        Assert.assertEquals("Personal data successfully changed", success_message);
        System.out.println(success_message);
    }

    public void verifyEditedName(){
       // WebElement homeNavigation = driver.findElement(By.xpath("//*[@id='actions-menu-primary']/a[1]"));
        element= driver.findElement(By.xpath("(//div[@class='links-menu__link-body'])[1]"));
        String text = element.getText().toLowerCase();
        Assert.assertTrue("Updated First Name " + firstName + " is not as expected" + text, text.contains(firstName.toLowerCase()));
      //  wait.until(ExpectedConditions.visibilityOf(homeNavigation));
      //  homeNavigation.click();
    }

    public void closeBrowser() {
        driver.quit();
    }


}


package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        // Find log in link and click on login link
        clickOnElement(By.xpath("//div[@class='header-links']/ul[1]/li[1]/a"));

        // This is from requirement
        String expectedMessage = "Register";

        // Find the Register text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//div[@class='header-links']/ul[1]/li[1]/a"));

        // Validate actual and expected message
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void userShouldRegisterAccountsSuccessfullySuccessfully() {
        // Find log in link and click on login link
        clickOnElement(By.xpath("//div[@class='header-links']/ul[1]/li[1]/a"));
        //Select gender radio button
        clickOnElement(By.id("gender-male"));
        //Enter first name
        sendTextToElement(By.id("FirstName"),"Manan");
        //Enter Last name
        sendTextToElement(By.id("LastName"),"Shah");
        //Select day
        sendTextToElement(By.name("DateOfBirthDay"),"3");
        //Select Month
        sendTextToElement(By.name("DateOfBirthMonth"),"December");
        //Select Year
        sendTextToElement(By.name("DateOfBirthYear"),"2002");
        //Enter Email address
        sendTextToElement(By.id("Email"),"test123@gmail.com");
        //Enter Password
        sendTextToElement(By.name("Password"),"Password12345");
        //Enter Confirm Password
        sendTextToElement(By.name("ConfirmPassword"),"Password12345");
        // Click on register Button
        clickOnElement(By.name("register-button"));
        //This is from requirement
        String expectedMessage= "Your registration completed";
       // WebElement actualTextMessageElement = driver.findElement(By.xpath("//div[@class='result']"));
        String actualMessage = getTextFromElement(By.xpath("//div[@class='result']"));
        // Validate actual and expected message
        Assert.assertEquals(expectedMessage,actualMessage);

    }
    @After
    public void testDown(){
        closeBrowser();
    }
}
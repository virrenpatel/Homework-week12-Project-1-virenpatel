package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    //Setup base URL
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        // Find log in link and click on login link
        clickOnElement(By.linkText("Log in"));

        // This is from requirement
        String expectedMessage= "Welcome, Please Sign In!";

        // Find the welcome text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));

        // Validate actual and expected message
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Click on the 'Login' link
        clickOnElement(By.linkText("Log in"));

        //Enter valid user name
        sendTextToElement(By.id("Email"),"test123@gmail.com");

        //Enter valid Password
        sendTextToElement(By.name("Password"),"Password12345");

        //Click on login button
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
    }
    @Test
    public void verifyErrorMessageWithInvalidCredentials(){
        //Click on 'Login' link
        clickOnElement(By.linkText("Log in"));

        //Enter Invalid user name
        sendTextToElement(By.id("Email"),"test1234@gmail.com");

        //Enter Invalid Password
        sendTextToElement(By.name("Password"),"Password123");

        //Click on login button
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        getTextFromElement(By.xpath("//div[@class ='message-error validation-summary-errors']"));

        // This is from requirement
        String expectedMessage= "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        // Find the text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//div[@class ='message-error validation-summary-errors']"));

        // Validate actual and expected message
        Assert.assertEquals(expectedMessage,actualMessage);

    }
    @After
    public void testDown(){
        closeBrowser();
    }
}
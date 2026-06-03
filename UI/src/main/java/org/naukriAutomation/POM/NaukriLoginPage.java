package org.naukriAutomation.POM;

import org.naukriAutomation.webdrivermanager.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementInteractions;

import java.time.Duration;

public class NaukriLoginPage {

    private WebDriver driver = DriverFactory.getDriver();

    @FindBy(id = "login_Layer") private WebElement loginButton;

    @FindBy(xpath = "//input[@placeholder=\"Enter your active Email ID / Username\"]") private WebElement username;

    @FindBy(xpath = "//input[@placeholder=\"Enter your password\"]") private WebElement password;

    @FindBy(xpath = "//button[text()=\"Login\"]") private WebElement signIn;

    public NaukriLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickLoginBtn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOf(loginButton));
//        ElementInteractions.highlightElement(driver, loginBtn);
        loginBtn.click();
    }

    public void enterUserName(String userName){
        ElementInteractions.highlightElement(driver, username);
        username.sendKeys(userName);
    }

    public void enterPassWord(String passWord){
        ElementInteractions.highlightElement(driver, password);
        password.sendKeys(passWord);
    }

    public void clickOnSignIn(){
        ElementInteractions.highlightElement(driver, signIn);
        signIn.click();
    }
}

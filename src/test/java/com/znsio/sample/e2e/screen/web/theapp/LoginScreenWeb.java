package com.znsio.sample.e2e.screen.web.theapp;

import com.znsio.e2e.tools.Driver;
import com.znsio.e2e.tools.Visual;
import com.znsio.sample.e2e.screen.theapp.LoginScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.znsio.e2e.tools.Wait.waitFor;

public class LoginScreenWeb
        extends LoginScreen {
    private final Driver driver;
    private final Visual visually;
    private final String SCREEN_NAME = LoginScreenWeb.class.getSimpleName();
    private static final By userNameId = By.id("username");
    private static final By passwordId = By.id("password");
    private static final By loginButtonXpath = By.xpath("//button/i[contains(text(),\"Login\")]");
    private static final By errorMessageId = By.id("flash");
    private static final By dismissAlertXpath = By.xpath("//a[@href=\"#\"]");

    public LoginScreenWeb(Driver driver, Visual visually) {
        this.driver = driver;
        this.visually = visually;
        visually.checkWindow(SCREEN_NAME, "Home screen");
    }

    @Override
    public LoginScreen enterLoginDetails(String username, String password) {
        waitFor(2);
        driver.findElement(userNameId)
              .sendKeys(username);
        driver.findElement(passwordId)
              .sendKeys(password);
        visually.checkWindow(SCREEN_NAME, "entered login details");
        return this;
    }

    @Override
    public LoginScreen login() {
        driver.findElement(loginButtonXpath)
              .click();
        waitFor(2);
        return this;
    }

    @Override
    public String getInvalidLoginError() {
        WebElement alertText = driver.waitForClickabilityOf(errorMessageId);
        visually.checkWindow(SCREEN_NAME, "Invalid Login alert");
        return alertText.getText()
                        .trim();
    }

    @Override
    public LoginScreen dismissAlert() {
        waitFor(2);
        visually.checkWindow(SCREEN_NAME, "Invalid Login alert dismissed");
        return this;
    }
}

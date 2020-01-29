package com.MavenProject_v1.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver localDriver;

    public LoginPage(WebDriver remoteDriver) {
        localDriver = remoteDriver;
        PageFactory.initElements(remoteDriver, this);
    }

    @FindBy(name = "uid")
    @CacheLookup
    WebElement txtUserName;

    @FindBy(name = "password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(name = "btnLogin")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
    @CacheLookup
    WebElement logout;

    public void setUserName(String uname) {
        txtUserName.sendKeys(uname);
    }

    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void clickSubmit() {
        btnLogin.click();
    }

    public void logOut() {
        logout.click();
    }
}

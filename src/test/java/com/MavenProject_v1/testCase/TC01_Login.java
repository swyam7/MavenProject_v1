package com.MavenProject_v1.testCase;

import com.MavenProject_v1.pageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC01_Login extends BaseClass {
    @Test
    public void loginTest() throws IOException {
        logger.info("URL is opened!!");
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(userId);
        lp.setPassword(password);
        lp.clickSubmit();

        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
            Assert.assertTrue(true);
            logger.info("Login is successful!!");
        } else {
            captureScreen(driver, "loginTest");
            Assert.assertTrue(false);
            logger.info("Login is not successful");
        }
    }

}

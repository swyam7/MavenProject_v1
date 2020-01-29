package com.MavenProject_v1.testCase;

import com.MavenProject_v1.pageObject.LoginPage;
import com.MavenProject_v1.utility.XLUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC02_LoginDDT extends BaseClass {
    @Test(dataProvider = "LoginData")
    public void loginDDT(String user, String pwd) throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(user);
        logger.info("User Name provided");
        lp.setPassword(pwd);
        logger.info("User Name provided");
        lp.clickSubmit();
        Thread.sleep(3000);

        if (isAlertPresent() == true) {
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            logger.warning("Login Failed");
        } else {
            Assert.assertTrue(true);
            logger.info("Login Passed");
            lp.logOut();
            Thread.sleep(3000);
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @DataProvider(name = "LoginData")
    public Object[][] getData() throws IOException {
        //String path = System.getProperty("user.dir") + "src/test/java/com.MavenProject_v1/testData/LoginData.xlsx";
        String path = "/Users/swyam/IdeaProjects/MavenProject_v1/src/test/java/com/MavenProject_v1/testData/LoginData.xlsx";
        int rownum = XLUtils.getRowCount(path, "Sheet1");
        int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

        String loginData[][] = new String[rownum][colcount];
        for (int i = 1; i <= rownum; i++) {
            for (int j = 0; j < colcount; j++) {
                loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
            }
        }
        return loginData;

    }
}

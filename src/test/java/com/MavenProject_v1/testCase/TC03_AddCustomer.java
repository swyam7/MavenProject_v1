package com.MavenProject_v1.testCase;

import java.io.IOException;

import com.MavenProject_v1.pageObject.AddCustomerPage;
import com.MavenProject_v1.pageObject.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_AddCustomer extends BaseClass {

    @Test
    public void addNewCustomer() throws InterruptedException, IOException {
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(userId);
        logger.info("User name is provided");
        lp.setPassword(password);
        logger.info("Passsword is provided");
        lp.clickSubmit();

        Thread.sleep(3000);

        AddCustomerPage addcust = new AddCustomerPage(driver);

        addcust.clickAddNewCustomer();

        logger.info("providing customer details....");


        addcust.custName("Swyam");
        addcust.custgender("male");
        addcust.custdob("07", "22", "1987");
        Thread.sleep(5000);
        addcust.custaddress("INDIA");
        addcust.custcity("DEO");
        addcust.custstate("UP");
        addcust.custpinno("274001");
        addcust.custtelephoneno("9742123456");

        String email = randomstring() + "@gmail.com";
        addcust.custemailid(email);
        addcust.custpassword("abcdef");
        addcust.custsubmit();

        Thread.sleep(3000);

        logger.info("validation started....");

        boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

        if (res == true) {
            Assert.assertTrue(true);
            logger.info("test case passed....");

        } else {
            logger.info("test case failed....");
            captureScreen(driver, "addNewCustomer");
            Assert.assertTrue(false);
        }

    }
}

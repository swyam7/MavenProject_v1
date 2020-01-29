package com.MavenProject_v1.testCase;

import com.MavenProject_v1.utility.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BaseClass {
    ReadConfig rc = new ReadConfig();
    public String baseURL = rc.getApplicationURL();
    public String userId = rc.getUserId();
    public String password = rc.getPassword();
    public static WebDriver driver;
    public static Logger logger;

    @Parameters("Browser")
    @BeforeClass
    public void setUp(String browser) {

        logger = Logger.getLogger("MavenProject_v1");
        PropertyConfigurator.configure("log4j.properties");

        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", rc.getChromePath());
            driver = new ChromeDriver();
        } else if (browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", rc.getFirefoxPath());
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshot/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

    public String randomstring() {
        String generatedString = RandomStringUtils.randomAlphabetic(8);
        return generatedString;
    }
}


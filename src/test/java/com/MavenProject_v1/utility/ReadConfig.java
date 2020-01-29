package com.MavenProject_v1.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties pro;

    public ReadConfig() {
        File src = new File("./Configuration/config.properties");
        try {
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getApplicationURL() {
        String baseURL = pro.getProperty("baseURL");
        return baseURL;
    }

    public String getUserId() {
        String userId = pro.getProperty("userId");
        return userId;
    }

    public String getPassword() {
        String password = pro.getProperty("password");
        return password;
    }

    public String getChromePath() {
        String chromePath = pro.getProperty("chromePath");
        return chromePath;
    }

    public String getFirefoxPath() {
        String firefoxPath = pro.getProperty("firefoxPath");
        return firefoxPath;
    }

}

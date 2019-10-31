package com.csdn.adminedupages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import bsh.This;

public class TestAdminEdu {
	private WebDriver driver;
	private String loginPageUrl = "https://passport.csdn.net/account/login?from=http://betaadminbss.csdn.net/";
	private String userName = "cpongo1";
	private String passWord = "k123456";
	private Login login;
	private HomePage homePage;
	
	
	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@Test
	public void testCoursePending(){
		try {
			login = new Login(driver, loginPageUrl);
			login.login(userName, passWord);
			homePage = new HomePage(driver);
			homePage.courseManageList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	

}

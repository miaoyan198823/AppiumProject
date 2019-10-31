package com.csdn.csto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.csdn.mallpages.*;

public class TestCreatePro {
	private WebDriver driver;
	private LoginPage lPage;
	private CreateProPage crPage;
	private String loginPageUrl = "https://passport.csdn.net/account/login?from=http://www.csto.com/";
	private String userName = "miaoyan1989";
	private String passWord = "miaoyan2011";
	private String proName = "selenium测试外包";
	private String proDescript = "完成selenium自动化测试环境搭建，完成基于UI自动化测试用例脚本编写";
	private String fileContent = "D:\\build.xml";
	private String proBudget = "￥3,000-￥5,000";
	private String mobileNum = "15010719147";
	private String bidPeriodTime = "30";
	private String proCompleteTime = "10-20天";
	
	
	
	
	@BeforeMethod
	public void setUp(){
		if (driver == null) {
			driver = new FirefoxDriver();
			lPage = new LoginPage(driver, loginPageUrl);
			crPage = new CreateProPage(driver);
		}
	}
	
	@Test
	public void testCreatePro(){
		lPage.login(userName, passWord);
		crPage.createProOperation(proName, proDescript, fileContent, proBudget, mobileNum, bidPeriodTime, proCompleteTime);
		
	}
	
	
	
	
/**	@AfterMethod
	public void tearDown(){
		driver.quit();
	}  */

}

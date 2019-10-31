package com.csdn.adminedupages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.csdn.mallpages.*;

public class TestCreateVolume {
	private WebDriver driver;
	private LoginPage lPage;
	private CreateVolumePage createVolumePage;
	private String loginPageUrl = "https://passport.csdn.net/account/login?from=http://ucadmin.csdn.net:3002";
	private String userName = "cpongo1";
	private String passWord = "k123456";
	private String platTypeText = "学院";
	private String volumeTypeText = "现金券";
	private String volumeNameText = "50元现金卷";
	private String volumeValue = "50";
	private String volumeNum = "5";
	
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		if (driver==null) {
			driver = new ChromeDriver();
			lPage = new LoginPage(driver, loginPageUrl);
			createVolumePage = new CreateVolumePage(driver);
		}
	}
	
//	验证优惠卷创建操作
	@Test
	public void testCreateVolume(){
		lPage.login(userName, passWord);
		createVolumePage.createVolumeOperation(platTypeText, volumeTypeText, volumeNameText, volumeValue, volumeNum);
		
	}
	
//	优惠卷后台通过查看优惠卷验证新创建的优惠卷信息
	@Test(enabled = false)
	public void verifyNewVolume(){
		lPage.login(userName, passWord);
		createVolumePage.seeVolumeInfo(platTypeText, volumeTypeText);
		Assert.assertTrue(true);
	}
	
	
	
}

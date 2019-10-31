package com.csdn.mallpages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.csdn.mallpages.*;
/**
 * 测试商城登录页面功能
 * @author miaoyan
 *
 */
public class TestLogin {
	public static final String loginPageUrl = "https://passport.csdn.net/account/login?from=http://betamall.csdn.net/";
	private WebDriver driver;
	private LoginPage page;
	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
		page = new LoginPage(this.driver, loginPageUrl);
	}
	//验证登录页面是否正确正常加载
	@Test(enabled = false)
	public void testPageLoading(){
		Assert.assertEquals(true,this.page.isLoaded());
	}
	//验证获取登录页面标题是否正确
	@Test(enabled = false)
	public void testPageTitle(){
		Assert.assertEquals(page.TITLE, this.page.getTitle());
	}
	//验证是否正确输入用户名和密码
	@Test
	public void testSuccessLogin(){
		Assert.assertEquals(true,this.page.login("miaoyan1989","miaoyan2011"));
	}
	
	
	@AfterMethod
	public void tearDown(){
		this.driver.quit();
	}
}

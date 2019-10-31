package com.csdn.mallpages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



/**
 * 商城登录页面
 * @author miaoyan
 *
 */

public class LoginPage  {
	
	public static final String TITLE = "帐号登录";
	public static final String USERNAME_ID = "username";
	public static final String PASSWORD_ID = "password";
	public static final String LOGINB_BTN_CLASS = "logging";
	private WebDriver driver;
	//登录页面URL
	protected String loginPageUrl;
	
	public LoginPage(WebDriver driver,String loginPageUrl){
		this.driver = driver;
		this.loginPageUrl = loginPageUrl;
	//加载登录页面
		this.driver.get(loginPageUrl);
	}
	
	//获取当前页面标题
	public String getTitle(){
		return this.driver.getTitle();
	}
	//检测是否正确加载登录页面，判断title是否相等 T/F
	public boolean 	isLoaded(){
		return LoginPage.TITLE.equals(this.getTitle());
	}
	
	//登录商城操作，传入用户名和密码，点击提交操作按钮，通过Title判断
	public boolean login(String userName,String passWord){
		this.driver.findElement(By.id(LoginPage.USERNAME_ID)).sendKeys(userName);
		this.driver.findElement(By.id(LoginPage.PASSWORD_ID)).sendKeys(passWord);
		this.driver.findElement(By.className(LoginPage.LOGINB_BTN_CLASS)).click();
		driver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);
		return MallHomePage.HOMEPAGE_TITLE.equals(this.getTitle());
	}
	
}

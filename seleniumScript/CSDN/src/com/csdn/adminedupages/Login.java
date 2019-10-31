package com.csdn.adminedupages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	private WebDriver driver;
	private String loginPageUrl;
	private String userName;
	private String passWord;
	private static By userNameLocator = By.id("username");
	private static By passWordLocator = By.id("password");
	private static By loginButtonLocator = By.className("logging");
	
	public Login(WebDriver driver,String loginPageUrl){
		this.driver = driver;
		this.loginPageUrl = loginPageUrl;
		this.driver.get(loginPageUrl);
	}
	
	public WebElement getUserNameField(){
		return this.driver.findElement(userNameLocator);
	}
	
	public WebElement getPassWordField(){
		return this.driver.findElement(passWordLocator);
	}
	
	public WebElement getLoginBtnField(){
		return this.driver.findElement(loginButtonLocator);
	}
	
	public HomePage login(String userName,String passWord){
		this.getUserNameField().sendKeys(userName);
		this.getPassWordField().sendKeys(passWord);
		this.getLoginBtnField().click();
		driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
		return new HomePage(driver);
	}

}

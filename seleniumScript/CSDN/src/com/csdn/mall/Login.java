package com.csdn.mall;

import java.util.concurrent.TimeUnit;

import net.sourceforge.htmlunit.corejs.javascript.ast.NewExpression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Login {
	WebDriver driver = new FirefoxDriver();
	private String url;
	private String userName;
	private String passWord;
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
		driver.get(url);
		String current_Url = driver.getCurrentUrl();
		Assert.assertEquals(current_Url,url);
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(userName);
		String str_text_username = driver.findElement(By.id("username")).getAttribute("value");
		Assert.assertEquals(str_text_username, userName);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	
	public String getPassWord() {
		return passWord;
	}
	
	public void setPassWord(String passWord) {
		this.passWord = passWord;
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(passWord);
		String str_text_password = driver.findElement(By.id("password")).getAttribute("value");
		Assert.assertEquals(str_text_password,passWord);
		
		driver.findElement(By.id("rememberMe"));
		if(!driver.findElement(By.id("rememberMe")).isSelected()){
			driver.findElement(By.id("rememberMe")).click();
			
		}
		Assert.assertTrue(driver.findElement(By.id("rememberMe")).isSelected());
		driver.findElement(By.className("logging")).click();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		String current_url = driver.getCurrentUrl();
		System.out.println("登录CSDN商城成功，商城首页地址为："+current_url);
		
	}
	
	public void mouse_moveInfo(){
		WebElement mouse_moveElement= driver.findElement(By.xpath("html/body/div[1]/div/div[2]/ul/li[6]/div/img"));
		Actions actions = new Actions(driver);
		actions.moveToElement(mouse_moveElement).build().perform();
		Assert.assertTrue(mouse_moveElement.isDisplayed());
	}
	

}

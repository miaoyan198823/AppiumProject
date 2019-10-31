package com.csdn.edu;
import java.util.concurrent.TimeUnit;

import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;

import org.apache.http.auth.UsernamePasswordCredentials;
import org.junit.internal.ExactComparisonCriteria;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.IReporter;

import bsh.commands.dir;


public class EduLogin {
	
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
		if(driver.findElement(By.id("password")).isEnabled()){
			System.out.println("password_text is Enabled!");
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys(passWord);
		}else{
			System.out.println("password_text is not Enabled!");
		}
		
		driver.findElement(By.id("rememberMe"));
		if(!driver.findElement(By.id("rememberMe")).isSelected()){
			driver.findElement(By.id("rememberMe")).click();
			
		}
		Assert.assertTrue(driver.findElement(By.id("rememberMe")).isSelected());
		
		driver.findElement(By.className("logging")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	

	public void mouse_moveInfo(){
		WebElement mouse_moveElement= driver.findElement(By.xpath("html/body/div[1]/div/div[2]/ul/li[6]/div/img"));
		Actions actions = new Actions(driver);
		actions.moveToElement(mouse_moveElement).build().perform();
		Assert.assertTrue(mouse_moveElement.isDisplayed());
	}     

}

package com.csdn.iteye;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class TestDay {
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@Test
	public void testDay(){
		driver.get("https://passport.csdn.net/account/login?from=http://ucadmin.csdn.net:3002/");
		driver.findElement(By.id("username")).sendKeys("cpongo1");
		driver.findElement(By.id("password")).sendKeys("k123456");
		driver.findElement(By.className("logging")).click();
		driver.findElement(By.xpath(".//*[@id='accordion']/div[4]/div[1]/h4/a")).click();
		driver.findElement(By.xpath(".//*[@id='collapseFour']/div/a[1]")).click();
		
		
	}

}

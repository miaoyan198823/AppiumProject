package com.csdn.edu;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.opera.core.systems.scope.protos.ExecProtos.ActionList.Action;

public class EduLogout extends EduLogin{
	public  void logout(){
		WebElement mouse_moveElement= driver.findElement(By.xpath("html/body/div[1]/div/div[2]/ul/li[6]/div/img"));
		Actions actions = new Actions(driver);
		actions.moveToElement(mouse_moveElement).build().perform();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".icon-signout")).click();
		
	}
	
	@Test
	public void logouOpration(){
		this.setUrl("https://passport.csdn.net/account/login?from=http://edu.csdn.net");
		this.setUserName("miaoyan1989");
		this.setPassWord("miaoyan2011");
		logout();
	}

}

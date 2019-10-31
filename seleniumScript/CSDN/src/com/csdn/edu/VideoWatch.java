package com.csdn.edu;

import java.util.Set;

import javax.sound.sampled.BooleanControl;

import net.sourceforge.htmlunit.corejs.javascript.JavaScriptException;

import org.testng.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class VideoWatch extends EduLogin{
	
	private void videoWatchLessonInfo(){
		driver.findElement(By.linkText("课程")).click();
		String expectedUrl = "http://edu.csdn.net/courses";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl,expectedUrl);
		String parentWindowId = driver.getWindowHandle();
		driver.findElement(By.cssSelector(".course_lists.clearfix>dd>a")).click();
		Set<String> allWindosId = driver.getWindowHandles();
		for(String windowId : allWindosId){
			if(driver.switchTo().window(windowId)
					.getPageSource().contains("课程目录")){
				driver.switchTo().window(windowId);
				driver.manage().window().maximize();
				System.out.println(driver.getCurrentUrl());
				System.out.println("成功进入课程视频播放页面！");
			}
		}
		Assert.assertTrue(driver.getPageSource().contains("立即购买"));
		
	}
	
	@Test
	public void videoWatchTest(){
		this.setUrl("https://passport.csdn.net/account/login?from=http://edu.csdn.net");
		this.setUserName("miaoyan1989");
		this.setPassWord("miaoyan2011");
		mouse_moveInfo();
		videoWatchLessonInfo();
	}

}

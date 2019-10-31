package com.csdn.edu;

/**
 * @author miaoyan
 * 测试CSDN学院首页导航栏各个按钮，验证各个按钮是否成功进入各自对应页面
 */

import java.sql.Driver;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class VerifyNavigation extends EduLogin {
	private void verifyNavigationOprationInfo(){
		
//		验证【课程】导航按钮功能链接
		driver.findElement(By.linkText("课程")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		String course_list_url = driver.getCurrentUrl();
		System.out.println("点击“课程导航按钮”进入课程列表页地址为："+course_list_url);
		Assert.assertTrue(course_list_url.contains("courses"));
//		验证【套餐】导航按钮功能链接
		driver.findElement(By.linkText("套餐")).click(); 
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		String combo_list_url = driver.getCurrentUrl();
		System.out.println("点击“套餐导航按钮”进入套餐列表页地址为："+combo_list_url);
		Assert.assertTrue(combo_list_url.contains("combo"));
//		验证【讲师/机构】导航按钮功能链接
		driver.findElement(By.linkText("讲师/机构")).click();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		String lecturer_list_url = driver.getCurrentUrl();
		System.out.println("点击“讲师/机构导航按钮”进入讲师机构列表页地址为："+lecturer_list_url);
		boolean isFindPageSourse=true;
		try {
			driver.getPageSource().contains("签约讲师");
			driver.getPageSource().contains("签约机构");
			isFindPageSourse=true;
		} catch (Exception e) {
			e.printStackTrace();
			isFindPageSourse=false;
		}finally{
			System.out.println("当前页面内容是否包含有【签约讲师】和【签约机构】字样："+isFindPageSourse);
		}
		
//	       验证【实训营】导航按钮功能链接
		driver.findElement(By.linkText("实训营")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		String opencourse_list_url = driver.getCurrentUrl();
		System.out.println("点击“实训营”进入讲师公开课列表页链接地址为："+opencourse_list_url);
		

		
//		验证【移动客户端】导航按钮功能链接
		String parentWindowId = driver.getWindowHandle();
		driver.findElement(By.linkText("移动客户端")).click();
		Set<String> allWindowsId = driver.getWindowHandles();
		for(String windowId : allWindowsId){
			if(driver.switchTo().window(windowId)
					.getPageSource().contains("CSDN学院移动客户端")){
				driver.switchTo().window(windowId);
				System.out.println("移动客户端页面地址为："+driver.getCurrentUrl());
				driver.close();
				
			}
		}
		
		
	
		
	}
	

		
	@Test
	public void verifyNavigationOpration(){
		this.setUrl("https://passport.csdn.net/account/login?from=http://edu.csdn.net");
		this.setUserName("miaoyan1989");
		this.setPassWord("miaoyan2011");
		verifyNavigationOprationInfo();
	}
	
	@AfterClass
	public void Aclass(){
		driver.quit();
	}
	

}

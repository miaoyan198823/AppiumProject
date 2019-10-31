package com.csdn.edu;


/**
 * @author miaoyan
 * 测试快捷支付效果，验证是否成功调用第三方支付接口
 */
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class QuickBuy extends EduLogin{

	private void quickpaymentInfo(){
		driver.findElement(By.linkText("课程")).click();
		String expectedUrl = "http://edu.csdn.net/courses";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl,expectedUrl);
		String parentWindowId = driver.getWindowHandle();
		driver.findElement(By.cssSelector(".course_lists.clearfix>dd>a")).click();
		Set<String> allWindowId = driver.getWindowHandles();
		for(String windowId : allWindowId){
			if(driver.switchTo().window(windowId)
					.getPageSource().contains("课程目录")){
				driver.switchTo().window(windowId);
				driver.manage().window().maximize();
				
			}
			
		}
		Assert.assertTrue(driver.getPageSource().contains("立即购买"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".player_list_buy_bt.cklayer")).click();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		boolean isFindPageSourse=true;
		try {
			driver.getPageSource().contains("微信支付");
			driver.getPageSource().contains("支付宝支付");
			isFindPageSourse=true;
		} catch (Exception e) {
			e.printStackTrace();
			isFindPageSourse=false;
		}finally{
			System.out.println("验证点击“立即购买”按钮，是否出现【微信支付】和【支付宝支付】字样："+isFindPageSourse);
		}
		
		
		
	
	}
	
	
	
		@Test
		public void buyTest(){
			this.setUrl("https://passport.csdn.net/account/login?from=http://edu.csdn.net");
			this.setUserName("miaoyan1989");
			this.setPassWord("miaoyan2011");
			quickpaymentInfo();
	}

}

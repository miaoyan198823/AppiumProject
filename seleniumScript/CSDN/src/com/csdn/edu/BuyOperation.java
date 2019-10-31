package com.csdn.edu;

import java.awt.Container;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;

public class BuyOperation extends EduLogin {
	/**
	 * @author miaoyan
	 * 测试商品购买方式为微信支付方式，验证是否成功跳转进入第三方微信支付页面
	 */
	private void wx_PayOperationInfo(){
		driver.findElement(By.cssSelector(".nav_shopping_cart")).click();
		String expectedUrl = "http://edu.csdn.net/order/addCart";
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		Assert.assertEquals(actualUrl, expectedUrl);
		
		driver.findElement(By.xpath("//input[@id='allSelect'][@type='checkbox']"));
		if(!driver.findElement(By.xpath("//input[@id='allSelect'][@type='checkbox']")).isSelected()){
			driver.findElement(By.xpath("//input[@id='allSelect'][@type='checkbox']")).click();
			
		}
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='allSelect'][@type='checkbox']")).isSelected());
		
		driver.findElement(By.className("qujiesuan")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		WebElement wx_payImg = driver.findElement(By.xpath(".//*[@id='paymentMode']/a[2]/img"));
		if(wx_payImg.isSelected()){
			driver.findElement(By.id("tijiaodingdan")).click();
		}else {
			System.out.println("weixinPay is not selected!");
			wx_payImg.click();
		}
		 
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.id("tijiaodingdan")).click();
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("微信支付"));
		String pageSourse = driver.getPageSource();
		Assert.assertTrue(pageSourse.contains("微信支付"));
	
	}
	
	/**
	 * @author miaoyan
	 * 测试商品购买方式为支付宝支付方式，验证是否成功跳转进入第三方支付宝页面
	 */
	private void aliPayOperationInfo(){
		driver.findElement(By.cssSelector(".nav_shopping_cart")).click();
		String expectedUrl = "http://edu.csdn.net/order/addCart";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		
		driver.findElement(By.xpath("//input[@id='allSelect'][@type='checkbox']"));
		if(!driver.findElement(By.xpath("//input[@id='allSelect'][@type='checkbox']")).isSelected()){
			driver.findElement(By.xpath("//input[@id='allSelect'][@type='checkbox']")).click();
			
		}
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='allSelect'][@type='checkbox']")).isSelected());
		
		driver.findElement(By.className("qujiesuan")).click();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		driver.findElement(By.id("tijiaodingdan")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("支付宝"));
		String pageSourse = driver.getPageSource();
		Assert.assertTrue(pageSourse.contains("CSDN课程订单"));
		
		
		
	}
		
		
	
	@Test
	public void alipayOperation(){
		this.setUrl("https://passport.csdn.net/account/login?from=http://edu.csdn.net/");
		this.setUserName("miaoyan1989");
		this.setPassWord("miaoyan2011");
		mouse_moveInfo();
		wx_PayOperationInfo();
		aliPayOperationInfo();
	}
}

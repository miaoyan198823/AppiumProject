package com.csdn.edu;

import java.util.Set;
import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.*;
import org.testng.annotations.Test;
import org.testng.Assert;
public class EmptyCart extends EduLogin{
/**
 * @author miaoyan
 * 当购物车为空时，进行商品加入购物车操作,然后进行商品购买
 */
	private void emptyCartOperationInfo(){
		driver.findElement(By.cssSelector(".nav_shopping_cart")).click();
		
		if(driver.getPageSource().contains("继续购课")){
			driver.findElement(By.linkText("继续购课")).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		
		driver.findElement(By.cssSelector(".course_lists.clearfix>dd>a")).click();
		Set<String> allWindowId = driver.getWindowHandles();
		for(String windowId : allWindowId){
			if(driver.switchTo().window(windowId)
					.getPageSource().contains("课程目录")){
				driver.switchTo().window(windowId);
				driver.manage().window().maximize();
				System.out.println("当前课程详情页地址为："+driver.getCurrentUrl());
			}
		}
		driver.findElement(By.id("gouwuche")).click();
		driver.findElement(By.className("to_buy")).click();
//		验证购物车内是否为空，如果为空，则出现“继续购物”字样，如果不为空，则没有“继续购物”字样
		boolean isNotFindPageSourse=true;
		try {
			driver.getPageSource().contains("继续购物");
			isNotFindPageSourse=true;
		} catch (Exception e) {
			e.printStackTrace();
			isNotFindPageSourse=false;
		}finally{
			System.out.println("购物车页面没有出现“继续购物”等文字："+isNotFindPageSourse);
		}
		
	}
	
	
	@Test
	public void emptyCartOperation(){
		this.setUrl("https://passport.csdn.net/account/login?from=http://edu.csdn.net");
		this.setUserName("miaoyan1989");
		this.setPassWord("miaoyan2011");
		emptyCartOperationInfo();
	}
}

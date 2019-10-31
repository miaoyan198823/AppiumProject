package com.csdn.mall;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.map.StaticBucketMap;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * 验证通过支付宝方式购买商城商品
 * @author miaoyan
 *
 */

public class BuyOperationInfo extends Login{
	private static final String LINK_TEXT = "软件商城";
	private static final String SOFTTOOLS_XPATH = "html/body/div[4]/div[1]/div[2]/div[2]/ul/li[3]/a[1]/img";
	private static final String SOFTTOOLS_PAGEINFO = "立即购买";
	private static final String SOFT_BUY_BTN= "buy_now";
	private static final String ORDER_CONTACT_BTN ="order_contact_button"; 
	private static final String ORDER_TITLE = "订单信息";
	private static final String INV_SAVE_BTN = "btn_inv_sav";
	private static final String SUB_ORDER_BTN = "submitOrderForm";
	private static final String SUCCESS_ORDER_INFO = "您的订单已经提交成功！";
	private static final String PAY_BY_INFO = "支付方式";
	
	
	
	public  void BuySoftToolsInfo(){
		driver.findElement(By.linkText(LINK_TEXT)).click();
		driver.findElement(By.xpath(SOFTTOOLS_XPATH)).click();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
//		进入商城软件工具页面，并验证是否成功进入
		Set<String> allWindowId = driver.getWindowHandles();
		for (String windowId : allWindowId) {
			if (driver.switchTo().window(windowId)
					.getPageSource().contains(SOFTTOOLS_PAGEINFO)) {
				driver.switchTo().window(windowId);
				driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
				System.out.println("当前软件工具商品详情页地址为："+driver.getCurrentUrl());
				Assert.assertTrue(driver.getPageSource().contains(SOFTTOOLS_PAGEINFO));
			}else {
				driver.close();
			}
			
		}
		
		driver.findElement(By.id(SOFT_BUY_BTN)).click();
		driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
		Assert.assertEquals(ORDER_TITLE,driver.getTitle());
		driver.findElement(By.id(ORDER_CONTACT_BTN)).click();
		driver.findElement(By.id(INV_SAVE_BTN)).click();
		driver.findElement(By.id(SUB_ORDER_BTN)).click();
		boolean isFindPageSource=true;
		try {
			driver.getPageSource().contains(SUCCESS_ORDER_INFO);
			driver.getPageSource().contains(PAY_BY_INFO);
			isFindPageSource=true;
		} catch (Exception e) {
			e.printStackTrace();
			isFindPageSource=false;
		}finally{
			System.out.println("成功提交订单页面是否出现 "+ SUCCESS_ORDER_INFO + "字样："+isFindPageSource);
		}
		
	
		
	}
	@Test
	public void BuyOperation(){
		this.setUrl("https://passport.csdn.net/account/login?from=http://betamall.csdn.net/");
		this.setUserName("miaoyan1989");
		this.setPassWord("miaoyan2011");
		mouse_moveInfo();
		BuySoftToolsInfo();
	}
	
	
}

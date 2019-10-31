package com.csdn.mall;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 验证通过C币支付购买商城商品
 * @author miaoyan
 */

public class BuyOperationToCpay extends Login{
	
	private static final String LINK_TEXT = "C币商城";
	private static final String PRO_CSS = ".pro_list>dl>dt>a";
	private static final String PRO_PAGEINFO = "立即购买";
	private static final String PRO_BUY_BTN= "buy_now";
	private static final String ORDER_CONTACT_BTN ="order_contact_button"; 
	private static final String SUB_ORDER_BTN = "submitOrderForm";
	private static final String ORDER_TITLE = "订单信息";
	private static final String SUCCESS_ORDER_INFO = "您的订单已经提交成功！";
	private static final String ORDER_CONFIRM_BTN = ".confirm_btn";
	private static final String SUCCESS_PAY_INFO = "支付成功，请等待系统确认。";
	
	private void cBuyOperationInfo(){
		driver.findElement(By.linkText(LINK_TEXT)).click();
		driver.findElement(By.cssSelector(PRO_CSS)).click();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
//		进入C币商品详情页，并验证是否成功进入
		Set<String> allWindowId = driver.getWindowHandles();
		for (String windowId : allWindowId) {
			if(driver.switchTo().window(windowId)
					.getPageSource().contains(PRO_PAGEINFO)){
				driver.switchTo().window(windowId);
				System.out.println("当前C币商品详情页地址为："+driver.getCurrentUrl());
			}else{
				driver.close();
			}
		}
		driver.findElement(By.id(PRO_BUY_BTN)).click();
		driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
//		验证是否成功进入订单信息页面
		Assert.assertEquals(ORDER_TITLE,driver.getTitle());
		driver.findElement(By.id(ORDER_CONTACT_BTN)).click();
//		验证是否成功提交订单信息，是否出现【确认支付】按钮
		driver.findElement(By.id(SUB_ORDER_BTN)).click();
		boolean isFindPageSource=true;
		try {
			driver.getPageSource().contains(SUCCESS_ORDER_INFO);
			driver.findElement(By.cssSelector(ORDER_CONFIRM_BTN));
			isFindPageSource=true;
		} catch (Exception e) {
			e.printStackTrace();
			isFindPageSource=false;
		}finally{
			System.out.println("成功提交订单页面是否出现 "+ SUCCESS_ORDER_INFO + "字样："+isFindPageSource);
		}
//		进入支付页面，验证是否支付成功
		driver.findElement(By.cssSelector(ORDER_CONFIRM_BTN)).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		Assert.assertTrue(driver.getPageSource().contains(SUCCESS_PAY_INFO));
		
	}
	
	
	@Test
	public void CbuyOperation(){
		this.setUrl("https://passport.csdn.net/account/login?from=http://betamall.csdn.net/");
		this.setUserName("miaoyan1989");
		this.setPassWord("miaoyan2011");
		mouse_moveInfo();
		cBuyOperationInfo();
	}
}

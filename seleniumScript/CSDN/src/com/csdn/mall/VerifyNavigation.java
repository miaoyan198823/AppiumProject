package com.csdn.mall;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opera.core.systems.EmulationProfile.IME;



public class VerifyNavigation extends Login{
	public void verifyNavigationOperationInfo(){
//		验证商城首页【软件商城】导航按钮返回数据内容是否正确
		driver.findElement(By.linkText("软件商城")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String tool_url = driver.getCurrentUrl();
		System.out.println("软件商城页面链接地址为："+tool_url);
		String str_pageInfo = driver.getPageSource();
		Assert.assertTrue(str_pageInfo.contains("软件企业"));
		if(str_pageInfo.contains("软件企业")){
			System.out.println("是否包含【软件企业】字样：true");
		}else {
			System.out.println("内容不存在");
		}
		
//		验证商城首页【C币商城】导航按钮返回数据内容是否正确
		driver.findElement(By.linkText("C币商城")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String coin_currentUrl = driver.getCurrentUrl();
		System.out.println("C币商城页面链接地址为："+coin_currentUrl);
		
//		验证商城首页【C币充值】导航按钮返回数据内容是否正确
		driver.findElement(By.linkText("C币充值")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String cbuy_currentUrl = driver.getCurrentUrl();
		System.out.println("C币充值页面链接地址为："+cbuy_currentUrl);
		boolean isFindPageSource=true;
		try {
			driver.getPageSource().contains("C币充值");
			driver.getPageSource().contains("兑换下载积分");
			driver.getPageSource().contains("兑换论坛可用积分");
			isFindPageSource=true;
		} catch (Exception e) {
			e.printStackTrace();
			isFindPageSource=false;
		}finally{
			System.out.println("C币充值页面是否出现【C币充值】【兑换下载积分】【兑换论坛可用积分】字样："+isFindPageSource);
		}
		
//		验证商城首页【帮助】导航按钮返回数据内容是否正确
		driver.findElement(By.linkText("帮助")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String help_currentUrl = driver.getCurrentUrl();
		System.out.println("帮助页面链接地址为："+help_currentUrl);
		boolean isFindHelpPageSource=true;
		try {
			driver.getPageSource().contains("帮助中心");
			driver.getPageSource().contains("软件商城帮助");
			driver.getPageSource().contains("C币商城帮助");
		} catch (Exception e) {
			e.printStackTrace();
			isFindHelpPageSource=false;
		}finally{
			System.out.println("帮助中心页面是否出现【帮助中心】【软件商城帮助】【C币商城帮助】字样："+isFindHelpPageSource);
		}
		
	}
	
	
	@Test
	public void verifyNavigationOperation(){
		this.setUrl("https://passport.csdn.net/account/login?from=http://mall.csdn.net");
		this.setUserName("miaoyan1989");
		this.setPassWord("miaoyan2011");
		mouse_moveInfo();
		verifyNavigationOperationInfo();
		
	}
}

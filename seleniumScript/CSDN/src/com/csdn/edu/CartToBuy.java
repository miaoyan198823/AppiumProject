package com.csdn.edu;

/**
 * @author miaoyan
 * 通过将商品加入购物车进行购买操作，验证是否正常调用第三方支付接口
 */



import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.*;

public class CartToBuy extends EduLogin{
	private void cartToBuyOprationInfo(){
		driver.findElement(By.linkText("课程")).click();
		System.out.println("验证课程列表页地址为："+driver.getCurrentUrl());
		driver.findElement(By.cssSelector(".course_lists.clearfix>dd>a")).click();
		Set<String> allWindowId = driver.getWindowHandles();
		for(String windowId : allWindowId){
			if(driver.switchTo().window(windowId)
					.getPageSource().contains("课程目录")){
				driver.switchTo().window(windowId);
				System.out.println("当前课程详情页地址为："+driver.getCurrentUrl());
				
			}
		}
		driver.findElement(By.id("gouwuche")).click();
		driver.findElement(By.className("to_buy")).click();
		System.out.println("正确进入购物车链接地址为："+driver.getCurrentUrl());
		
		WebElement allSelect = driver.findElement(By.id("allSelect"));
		if(!allSelect.isSelected()){
				allSelect.click();
			}
			
		driver.findElement(By.className("qujiesuan")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//      通过微信方式进行课程支付
		WebElement wx_payImg = driver.findElement(By.xpath(".//*[@id='paymentMode']/a[2]/img"));
		if(wx_payImg.isSelected()){
			driver.findElement(By.id("tijiaodingdan")).click();
		}else {
			System.out.println("weixinPay is not selected!");
			wx_payImg.click();
		}
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.findElement(By.id("tijiaodingdan")).click();
//      验证是否成功进入第三方微信支付页面
		String title = driver.getTitle();
		System.out.println("第三方支付页面标题为："+title);                     //通过页面标题进行验证
		Assert.assertTrue(title.contains("微信支付"));
		driver.getCurrentUrl();
		System.out.println("第三方支付页面链接地址为："+driver.getCurrentUrl()); //通过页面链接地址进行验证
		boolean isFindPageSourse=true;		
		try {
			driver.getPageSource().contains("微信支付");
			isFindPageSourse=true;
		} catch (Exception e) {
			e.printStackTrace();
			isFindPageSourse=false;                                          //通过页面资源信息进行验证
			
		}finally{
			System.out.println("验证进入第三方页面是否有“微信支付”页面资源："+isFindPageSourse);
		}
		
		
	}
	
	
	@Test
	public void cartToBuyOpration(){
		this.setUrl("https://passport.csdn.net/account/login?from=http://edu.csdn.net");
		this.setUserName("miaoyan1989");
		this.setPassWord("miaoyan2011");
		cartToBuyOprationInfo();
	}
}

package com.csdn.mall;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * 验证商城首页各精品推荐商品是否准确返回链接地址
 * @author miaoyan
 *
 */

public class VerifyHomePageRecommended extends Login{
	private void verifyHomePageRecommendedInfo(){
		List<WebElement>links = driver.findElements(By.cssSelector(".recommend_l.fl>dl>dd>a"));
		for (int i = 0; i < links.size(); i++) {
			System.out.println("商城首页精品推荐精品详情页地址为："+links.get(i).getAttribute("href"));
		}
		driver.close();
	}
	
	
	@Test
	public void verifyHomePageRecommendedOperation(){
		this.setUrl("https://passport.csdn.net/account/login?from=http://mall.csdn.net/");
		this.setUserName("miaoyan1989");
		this.setPassWord("miaoyan2011");
		mouse_moveInfo();
		verifyHomePageRecommendedInfo();
	}
	
	@AfterClass
	public void Aclass(){
		driver.quit();
	}

}

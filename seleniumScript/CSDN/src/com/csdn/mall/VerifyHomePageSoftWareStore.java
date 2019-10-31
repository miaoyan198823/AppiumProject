package com.csdn.mall;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * 验证商城首页软件商城个软件是否准确返回详情页链接地址
 * @author miaoyan
 *
 */

public class VerifyHomePageSoftWareStore extends Login{
	private void verifySofWareStoreInfo(){
		List<WebElement>links = driver.findElements(By.cssSelector(".liCur>a"));
		for (int i = 0; i < links.size(); i++) {
			System.out.println("商城首页软件商城各软件详情页地址为："+links.get(i).getAttribute("href"));
		}
		driver.close();
	}
	
	@Test
	public void verifySoftWareStoreOperation(){
		this.setUrl("https://passport.csdn.net/account/login?from=http://mall.csdn.net/");
		this.setUserName("miaoyan1989");
		this.setPassWord("miaoyan2011");
		mouse_moveInfo();
		verifySofWareStoreInfo();
	}
	
	@AfterClass
	public void Aclass(){
		driver.quit();
	}


}

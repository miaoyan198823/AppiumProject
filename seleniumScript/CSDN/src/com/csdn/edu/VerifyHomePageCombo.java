package com.csdn.edu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * @author miaoyan
 * 验证点击首页推荐套餐图片是否成功进入各套餐详情页
 */

public class VerifyHomePageCombo extends EduLogin {
	private void verifyHomePageComboInfo(){
		List<WebElement>links = driver.findElements(By.cssSelector(".listcontent.smallsize.clearfix>dd>a"));
		for(int i=0;i<links.size();i++){
			System.out.println("首页各热卖套餐详情页地址为："+links.get(i).getAttribute("href"));
		}
		driver.close();
	}
	
	@Test
	public void verifyHomePageOperation(){
		this.setUrl("https://passport.csdn.net/account/login?from=http://edu.csdn.net");
		this.setUserName("miaoyan1989");
		this.setPassWord("miaoyan2011");
		verifyHomePageComboInfo();
	}
	
	@AfterClass
	public void Aclass(){
		driver.quit();
	}


}

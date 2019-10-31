package com.csdn.edu;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * @author miaoyan
 * 验证点击首页合作机构图片是否成功进入各机构网站
 */
public class VerifyHomePageAgency extends EduLogin{
	private void verifyHomePageAgencyInfo(){
		List<WebElement> links = driver.findElements(By.cssSelector(".cooperation.clearfix>li>a"));
		for(int i=0;i<links.size();i++){
			System.out.println("首页各机构页面地址为："+links.get(i).getAttribute("href"));
		}
		driver.close();
	}
	
	@Test
	public void verifyHomePageAgencyOperation(){
		this.setUrl("https://passport.csdn.net/account/login?from=http://edu.csdn.net");
		this.setUserName("miaoyan1989");
		this.setPassWord("miaoyan2011");
		verifyHomePageAgencyInfo();
	}
	
	@AfterClass
	public void Aclass(){
		driver.quit();
	}

}

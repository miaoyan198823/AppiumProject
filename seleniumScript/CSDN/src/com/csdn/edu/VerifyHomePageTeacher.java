package com.csdn.edu;

/**
 * @author miaoyan
 * 验证点击首页某推荐讲师图片是否成功进入该讲师详情页
 */
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.stylesheets.LinkStyle;

public class VerifyHomePageTeacher extends EduLogin{

	private void verifyHomePageLecturerInfo(){
		List<WebElement> links = driver.findElements(By.cssSelector(".listcontent02>dd>a"));
		for(int i = 0;i < links.size();i++){
			System.out.println("首页各推荐讲师详情页地址为："+links.get(i).getAttribute("href"));
			
		}
		
		driver.close();
	}

	
	@DataProvider
	public Object[][] logindaga(){
		return new Object[][]{{"a"},{"b"}};
	}
	
	
	@Test
	public void verifyHomePageTeacherOperation(){
		this.setUrl("https://passport.csdn.net/account/login?from=http://edu.csdn.net");
		this.setUserName("miaoyan1989");
		this.setPassWord("miaoyan2011");
		verifyHomePageLecturerInfo();
	}

	@AfterClass
	public void Aclass(){
		driver.quit();
	}


	

	
}

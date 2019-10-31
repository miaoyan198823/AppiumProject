package com.csdn.edu;
/**
 * @author miaoyan
 * 以讲师身份创建套餐，前提是当前讲师需要有5个以上已发布的课程
 */

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ApplyCombo extends EduLogin {
	private void applyComboOprationInfo(String comboName,String comboImgFile,String comboDescription,String comboCat1,String comboCat2,String comboTags,String comboPrice){
		driver.findElement(By.name("combo_name")).clear();
		driver.findElement(By.name("combo_name")).sendKeys(comboName);
		driver.findElement(By.id("uploadButton2")).click();
		driver.findElement(By.name("imgFile")).sendKeys(comboImgFile);
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type='button'][@value='确定']")).click();
		driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//textarea[@name='description']")).clear();
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(comboDescription);
		new Select(driver.findElement(By.id("combo_cat1"))).selectByVisibleText(comboCat1);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		new Select(driver.findElement(By.id("combo_cat2"))).selectByVisibleText(comboCat2);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("tag")).clear();
		driver.findElement(By.name("tag")).sendKeys(comboTags);
		driver.findElement(By.xpath("//input[@name='course_list[]'][@value='1311']")).click();
		driver.findElement(By.xpath("//input[@name='course_list[]'][@value='1308']")).click();
		driver.findElement(By.xpath("//input[@name='course_list[]'][@value='1306']")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.name("combo_price")).clear();
		driver.findElement(By.name("combo_price")).sendKeys(comboPrice);
		driver.findElement(By.cssSelector(".btn.btn-danger.btn-lg.next-step")).click();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		System.out.println("套餐信息提交成功后页面返回正确链接地址为："+driver.getCurrentUrl());
		boolean isFindPageSourceInfo=true;
		try {
			driver.getPageSource().contains("您的套餐申请已成功提交");
			isFindPageSourceInfo=true;
		} catch (Exception e) {
			e.printStackTrace();
			isFindPageSourceInfo=false;
		}finally{
			System.out.println("验证套餐信息提交页面是否出现“您的套餐申请已成功提交”字样:"+isFindPageSourceInfo);
		}
	}
	
	@Test
	public void applyComboOpration(){
		this.setUrl("https://passport.csdn.net/account/login?from=http://testedu.csdn.net/combo/apply");
		this.setUserName("miaoyan1989");
		this.setPassWord("miaoyan2011");
		mouse_moveInfo();
		String comboName = "缪岩测试课程套餐"+System.currentTimeMillis();
		String comboImgFile = "G:\\111.png";
		String comboDescription = "本系列套餐主要针对软件开发从业者设计";
		String comboCat1 = "数据库";
		String comboCat2 = "数据库管理";
		String comboTags = "selenium,java";
		String comboPrice = "0.01";
		applyComboOprationInfo(comboName, comboImgFile, comboDescription, comboCat1, comboCat2, comboTags, comboPrice);
	}
	
	@AfterClass
	public void tearDown(){
		driver.close();
	}

	

}

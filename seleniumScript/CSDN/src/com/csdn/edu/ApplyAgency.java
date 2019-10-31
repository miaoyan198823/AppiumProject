package com.csdn.edu;

/**
 * @author miaoyan
 * 创建机构操作
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ApplyAgency extends EduLogin{
	public void applyAgencyOprationInfo(String agencyName,String agencySite,String agencySkill,String agencyIntro,String agencyWeibo,String imgfile,String agencyEmail,String agencyTel,String agencyQQ){
		
		driver.findElement(By.id("agency_name")).clear();
		driver.findElement(By.id("agency_name")).sendKeys(agencyName);
		driver.findElement(By.id("agency_site")).clear();
		driver.findElement(By.id("agency_site")).sendKeys(agencySite);
		driver.findElement(By.id("agency_skill")).clear();
		driver.findElement(By.id("agency_skill")).sendKeys(agencySkill);
		driver.findElement(By.id("agency_intro")).clear();
		driver.findElement(By.id("agency_intro")).sendKeys(agencyIntro);
		driver.findElement(By.id("agency_weibo")).clear();
		driver.findElement(By.id("agency_weibo")).sendKeys(agencyWeibo);
		driver.findElement(By.id("uploadlogo")).click();
		driver.findElement(By.name("imgFile")).sendKeys(imgfile);
		driver.findElement(By.xpath("//input[@type='button'][@value='确定']")).click();
		driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
		driver.findElement(By.id("agency_email")).clear();
		driver.findElement(By.id("agency_email")).sendKeys(agencyEmail);
		driver.findElement(By.id("agency_tel")).clear();
		driver.findElement(By.id("agency_tel")).sendKeys(agencyTel);
		driver.findElement(By.name("agency_qq")).clear();
		driver.findElement(By.name("agency_qq")).sendKeys(agencyQQ);
		driver.findElement(By.xpath("//input[@type='submit'][@value='提交']")).click();
		driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);    
		System.out.println("机构信息提交成功后页面返回正确链接地址为："+driver.getCurrentUrl());
		boolean isFindPageSourceInfo=true;
		try {
			driver.getPageSource().contains("申请成功");
			isFindPageSourceInfo=true;
		} catch (Exception e) {
			e.printStackTrace();
			isFindPageSourceInfo=false;
		}finally{
			System.out.println("验证机构信息提交页面是否出现“申请成功”字样:"+isFindPageSourceInfo);
		}
	}
	
	@Test
	public void applyAgencyOpration(){
		this.setUrl("https://passport.csdn.net/account/login?from=http://testedu.csdn.net/agency/apply");
		this.setUserName("csto_funds");
		this.setPassWord("miaoyan1989");
		mouse_moveInfo();
		String agencyName = "大象学院" +System.currentTimeMillis();
		String agencySite = "http://www.csdn.net";
		String agencySkill = "java,php";
		String agencyIntro = "是一家从事IT在线教育培训的网站。网站经过五年来的发展，已培养数万IT各领域高端人才，已成为目前国内IT在线培训第一品牌";
		String agencyWeibo = "http://csdn.net.cn";
		String imgfile = "G:\\111.png";
		String agencyEmail = "550775725@qq.com";
		String agencyTel = "15010147457";
		String agencyQQ = "550775725";
		applyAgencyOprationInfo(agencyName, agencySite, agencySkill, agencyIntro, agencyWeibo, imgfile, agencyEmail, agencyTel, agencyQQ);
	}
}

package com.csdn.edu;
/**
 * @author miaoyan
 * 创建讲师操作
 */
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.IReporter;

import bsh.This;

import com.opera.core.systems.OperaDriver.PrivateData;
import com.opera.core.systems.OperaLogs.DriverLogsHandler;

public class ApplyTeacher extends EduLogin {
	public void applyTeacherOprationInfo(String teacherName,String teacherBlog,String teacherCorp,String teacherTags,String teacherIntro,String teaherExpr,String teacherWeibo,
		String imgFile,String teacherEmail,String teacherMobile,String teacherQQ,String teacherAdress){
		
		driver.findElement(By.linkText("讲师/机构")).click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		driver.findElement(By.className("lectorBtn")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.id("lecturer_name")).clear();
		driver.findElement(By.id("lecturer_name")).sendKeys(teacherName);
		driver.findElement(By.id("lecturer_blog")).clear();
		driver.findElement(By.id("lecturer_blog")).sendKeys(teacherBlog);
		driver.findElement(By.id("lecturer_corp")).clear();
		driver.findElement(By.id("lecturer_corp")).sendKeys(teacherCorp);
		new Select(driver.findElement(By.id("lecturer_pos"))).selectByVisibleText("测试经理");
		Select lecturer_pos = new Select(driver.findElement(By.id("lecturer_pos")));
		Assert.assertFalse(lecturer_pos.isMultiple());
		new Select(driver.findElement(By.name("lecturer_agency"))).selectByVisibleText("CSDN高校俱乐部");
		Select lecturer_agency = new Select(driver.findElement(By.name("lecturer_agency")));
		Assert.assertFalse(lecturer_agency.isMultiple());
		Assert.assertEquals("CSDN高校俱乐部",lecturer_agency.getFirstSelectedOption().getText());
		driver.findElement(By.id("lecturer_tags")).clear();
		driver.findElement(By.id("lecturer_tags")).sendKeys(teacherTags);
		driver.findElement(By.id("lecturer_intro")).sendKeys(teacherIntro);
		driver.findElement(By.id("lecturer_expr")).sendKeys(teaherExpr);
		driver.findElement(By.id("lecturer_weibo")).sendKeys(teacherWeibo);
		driver.findElement(By.id("uploadButton")).click();
		driver.findElement(By.name("imgFile")).sendKeys(imgFile);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type='button'][@value='确定']")).click();
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		driver.findElement(By.id("lecturer_email")).clear();
		driver.findElement(By.id("lecturer_email")).sendKeys(teacherEmail);
		driver.findElement(By.id("lecturer_mobile")).clear();
		driver.findElement(By.id("lecturer_mobile")).sendKeys(teacherMobile);
		driver.findElement(By.name("lecturer_qq")).clear();
		driver.findElement(By.name("lecturer_qq")).sendKeys(teacherQQ);
		driver.findElement(By.id("address")).clear();
		driver.findElement(By.id("address")).sendKeys(teacherAdress);
		driver.findElement(By.xpath("//input[@type='submit'][@value='提交']")).click();
		driver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS);
		System.out.println("信息提交成功，正确返回提交页面地址为："+driver.getCurrentUrl());
		boolean isFindPageSourse=true;
		try {
			driver.getPageSource().contains("申请成功");
			isFindPageSourse=true;
		} catch (Exception e) {
			e.printStackTrace();
			isFindPageSourse=false;
		}finally{
			System.out.println("讲师申请信息提交页面返回页面内容是否正确："+isFindPageSourse);
		}
		
	}
	
	@Test
	public void applyTeacherOpration(){
		this.setUrl("https://passport.csdn.net/account/login?from=http://betaedu.csdn.net/");
		this.setUserName("csto_funds");
		this.setPassWord("miaoyan1989");
		mouse_moveInfo();
		String teacherName = "百灵晶"+System.currentTimeMillis();
		String teacherBlog = "http://blog.csdn.net";
		String teacherCorp = "CSDN";
		String teacherTags = "java,php";
		String teacherIntro = "从事软件开发很多年，丰富的软件从业经验";
		String teacerExpr = "从事软件相关培训课程多年 ，有丰富的授课经验";
		String teacherWeibo = "www.csdn.net";
		String imgFile = "G:\\111.png";
		String teacherEmail = "550775725@qq.com";
		String teacherMobile = "15010719147";
		String teacherQQ = "550775725";
		String teacherAdress = "北京市朝阳区广顺北大街";
		applyTeacherOprationInfo(teacherName, teacherBlog, teacherCorp, teacherTags, teacherIntro, teacerExpr, teacherWeibo, imgFile, teacherEmail, teacherMobile, teacherQQ, teacherAdress);
		
		
	}
}
	
	
	


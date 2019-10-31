package com.csdn.edu;

/**
 * @author miaoyan
 * 以讲师身份创建课程及课程大纲内容
 */

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.*;
import org.testng.annotations.*;


import bsh.This;

public class ApplyCourse extends EduLogin {
	public void applyCourseOprationInfo(String courseName,String courseCat1,String courseCat2,String courseIntro,String courseObjective,String coursePlan,String courseSuit,String courseTags,String courseCount,String coursePrice,
		String courseImgFile,String courseTitle,String lesson_1,String lesson_2,String lesson_3){
		
		driver.findElement(By.id("course_name")).clear();
		driver.findElement(By.id("course_name")).sendKeys(courseName);
		new Select(driver.findElement(By.id("course_cat1"))).selectByVisibleText(courseCat1);
		Select course_cat1 = new Select(driver.findElement(By.id("course_cat1")));
		Assert.assertFalse(course_cat1.isMultiple());
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		new Select(driver.findElement(By.id("course_cat2"))).selectByVisibleText(courseCat2);
		driver.findElement(By.id("course_intro")).clear();
		driver.findElement(By.id("course_intro")).sendKeys(courseIntro);
		driver.findElement(By.id("course_objectives")).clear();
		driver.findElement(By.id("course_objectives")).sendKeys(courseObjective);
		driver.findElement(By.id("course_plan")).clear();
		driver.findElement(By.id("course_plan")).sendKeys(coursePlan);
		driver.findElement(By.id("getTags")).clear();
		driver.findElement(By.id("getTags")).sendKeys(courseTags);
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("(//input[@name='course_type'])[2]"));
		if(!driver.findElement(By.xpath("(//input[@name='course_type'])[2]")).isSelected()){
			driver.findElement(By.xpath("(//input[@name='course_type'])[2]")).click();
			
		}
		Assert.assertTrue(driver.findElement(By.xpath("(//input[@name='course_type'])[2]")).isSelected());
		
		driver.findElement(By.xpath("(//input[@name='course_level'])[2]"));
		if(!driver.findElement(By.xpath("(//input[@name='course_level'])[2]")).isSelected()){
			driver.findElement(By.xpath("(//input[@name='course_level'])[2]")).click();
			
		}
		Assert.assertTrue(driver.findElement(By.xpath("(//input[@name='course_level'])[2]")).isSelected());
		
		driver.findElement(By.xpath("(//input[@name='course_attr'])[3]"));
		if(!driver.findElement(By.xpath("(//input[@name='course_attr'])[3]")).isSelected()){
			driver.findElement(By.xpath("(//input[@name='course_attr'])[3]")).click();
			
		}
		Assert.assertTrue(driver.findElement(By.xpath("(//input[@name='course_attr'])[3]")).isSelected());
		
		driver.findElement(By.xpath("(//input[@name='is_free'])[1]"));
		if(!driver.findElement(By.xpath("(//input[@name='is_free'])[1]")).isSelected()){
			driver.findElement(By.xpath("(//input[@name='is_free'])[1]")).click();
			
		}
		Assert.assertTrue(driver.findElement(By.xpath("(//input[@name='is_free'])[1]")).isSelected());
		
		driver.findElement(By.id("course_count")).clear();
		driver.findElement(By.id("course_count")).sendKeys(courseCount);
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		driver.findElement(By.name("course_price")).clear();
		driver.findElement(By.name("course_price")).sendKeys(coursePrice);
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		driver.findElement(By.id("uploadButton2")).click();
		driver.findElement(By.name("imgFile")).sendKeys(courseImgFile);
		driver.findElement(By.xpath("//input[@type='button'][@value='确定']")).click();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type='submit'][@value='下一步']")).click();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
//		driver.findElement(By.id("title_0")).clear();
//		driver.findElement(By.id("title_0")).sendKeys(courseTitle);
//		driver.findElement(By.xpath(".//*[@id='myform']/ul/li[4]/input")).click();
		driver.findElement(By.xpath(".//*[@id='myform']/ul/li[4]/a[2]")).click();
		driver.findElement(By.name("lesson[1]")).clear();
		driver.findElement(By.name("lesson[1]")).sendKeys(lesson_1);
		driver.findElement(By.name("lesson[2]")).clear();
		driver.findElement(By.name("lesson[2]")).sendKeys(lesson_2);
		driver.findElement(By.name("lesson[3]")).clear();
		driver.findElement(By.name("lesson[3]")).sendKeys(lesson_3);
		driver.findElement(By.xpath("//input[@type='submit'][@value='提交课程']")).click();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		System.out.println("课程信息提交成功后页面返回正确链接地址为："+driver.getCurrentUrl());
		boolean isFindPageSourceInfo=true;
		try {
			driver.getPageSource().contains("您的课程申请已经成功提交");
			isFindPageSourceInfo=true;
		} catch (Exception e) {
			e.printStackTrace();
			isFindPageSourceInfo=false;
		}finally{
			System.out.println("验证课程信息提交页面是否出现“您的课程申请已经成功提交”字样："+isFindPageSourceInfo);
		}
		
		
		
	}
	
	@Test
	public void applyCourseOpration(){
		this.setUrl("https://passport.csdn.net/account/login?from=http://betaedu.csdn.net/course/apply");
		this.setUserName("miaoyan1989");
		this.setPassWord("miaoyan2011");
		mouse_moveInfo();
		String courseName = "selenium 23145" + System.currentTimeMillis();
		String courseCat1 = "大学课程";
		String courseCat2 = "计算机网络";
		String courseIntro = "主要针对初步学习自动化测试的测试人员";
		String courseObjective = "让测试人员对selenium测试开发工具有一定的认识和了解，可以写基础的测试开发脚本";
		String coursePlan = "selenium测试工具介绍，元素定位，方法调用规范，测试语法基础";
		String courseSuit = "计算机相关专业学生";
		String courseTags = "测试，selenium，WebDriver";
		String courseCount = "3";
		String coursePrice = "2";
		String courseImgFile = "G:\\111.png";
		String courseTitle = "selenium测试工具介绍";
		String lesson_1 = "selenium 介绍";
		String lesson_2 = "selenium 元素定位";
		String lesson_3 = "selenium 语法介绍";
		applyCourseOprationInfo(courseName, courseCat1, courseCat2, courseIntro, courseObjective, coursePlan, courseSuit, courseTags, courseCount, coursePrice, courseImgFile, courseTitle, lesson_1, lesson_2, lesson_3);
	}
}

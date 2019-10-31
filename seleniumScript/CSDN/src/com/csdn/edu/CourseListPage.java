package com.csdn.edu;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 课程列表页
 * @author miaoyan
 *
 */

public class CourseListPage {
	private WebDriver driver;
	private static By courseImgLinkLocator = By.cssSelector(".course_lists.clearfix>dd>a");
	
	public CourseListPage(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getCourseImgLinkTextField(){
		return this.driver.findElement(courseImgLinkLocator);
	}
	
	public static void switchHandles(WebDriver driver){
		try {
			ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(windows.get(1));
		} catch (Exception e) {
			driver.quit();
		}
	}
	
	public CourseDetailPage CourseImgLinkClick(){
		this.getCourseImgLinkTextField().click();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		this.switchHandles(driver);
		return new CourseDetailPage(driver);
	}

}

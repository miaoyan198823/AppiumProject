package com.csdn.adminedupages;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 进入CSDN学院管理后台
 * @author miaoyan
 *
 */
public class HomePage {
	private WebDriver driver;
	public  static final String HOME_PAGE_URL = "http://betaadminbss.csdn.net/ ";
	private static By iframeValueLocator = By.id("rightMain");
	private static By courseManageLocator = By.xpath(".//*[@id='_MP517']/a");
	private static By coursePendingLocator = By.xpath("html/body/div[3]/div[2]/a[2]/em");
	
	
	public HomePage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getCurrentUrl(){
		return this.driver.getCurrentUrl();
	}
	
	public WebElement courseManageTextField(){
		return this.driver.findElement(courseManageLocator);
	}
	
	public WebElement coursePendingTextField(){
		return this.driver.findElement(coursePendingLocator);
	}
	
//	切换Iframe方法
	public void switchFrame(WebDriver driver){
		try {
			driver.switchTo().frame(driver.findElement(iframeValueLocator));
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		} catch (Exception e) {
			driver.quit();	
		}
	}
	
//	进入课程管理列表方法
	public void courseManageList(){
		this.courseManageTextField().click();  //课程管理导航
		this.switchFrame(driver);
		this.coursePendingTextField().click();  // 待审核
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	}

}

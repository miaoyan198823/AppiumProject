package com.csdn.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByLinkText;
import com.csdn.mallpages.*;

/**
 * 课程详情页
 * @author miaoyan
 *
 */

public class CourseDetailPage {
	private WebDriver driver;
	private static By cartLocator = By.id("gouwuche");
	private static By toClearLocator = By.cssSelector(".to_buy");
	
	public CourseDetailPage(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getCartTextField(){
		return this.driver.findElement(cartLocator);
	}
	
	public WebElement getToClearClick(){
		return this.driver.findElement(toClearLocator);
	}
	
	public CartPage addCartOperation(){
		this.getCartTextField().click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		this.getToClearClick().click();
		return new CartPage(driver);
		
	}
}

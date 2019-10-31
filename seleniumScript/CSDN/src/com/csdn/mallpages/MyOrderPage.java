package com.csdn.mallpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


/**
 * 我的订单页面
 * @author miaoyan
 *
 */
public class MyOrderPage {
	
	private WebDriver driver;
	private static By orderTypeLocator = By.id("goods_type");
	private static By orderCreateTimeLocator = By.id("create_time");
	private static By orderStatusLocator = By.id("order_status");
	
	public MyOrderPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getPageSource(){
		return this.driver.getPageSource();
	}
	
	public WebElement orderTypeField(){
		return this.driver.findElement(orderTypeLocator);
	}
	
	public WebElement orderCreateTimeField(){
		return this.driver.findElement(orderCreateTimeLocator);
	}
	
	public WebElement orderStatusField(){
		return this.driver.findElement(orderStatusLocator);
	}
//	订单类型检索条件
	public void orderTypeSelect(String orderTypeText){
		new Select(this.orderTypeField()).selectByVisibleText(orderTypeText);
	}
//	订单状态检索条件
	public void orderStatusSelect(String orderStatusText){
		new Select(this.orderStatusField()).selectByVisibleText(orderStatusText);
	}
}

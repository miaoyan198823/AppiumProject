package com.csdn.mallpages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 软件商城商品详情页
 * @author miaoyan
 *
 */

public class SoftProductDetailPage {
	private WebDriver driver;
	private static By buyNowBtnLocator = By.id("buy_now");
	private static By addCarBtnLocator = By.id("add_shoppingCar");
	private static By payAccountBtnLocator = By.cssSelector(".payAccount");
	
	public SoftProductDetailPage(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getBuyNowBtnField(){
		return this.driver.findElement(buyNowBtnLocator);
	}
	
	public WebElement getAddCarBtnField(){
		return this.driver.findElement(addCarBtnLocator);
	}
	
	public WebElement getPayAccountBtnField(){
		return this.driver.findElement(payAccountBtnLocator);
	}
	
//	点击【立即购买】按钮跳转进入订单提交页面
	public OrderSubmitPage buyNowOperation(){
		this.getBuyNowBtnField().click();
		return new OrderSubmitPage(driver);
	}
	
//	软件商品详情页，点击【加入购物车】按钮，是否正确进入购物车页面
	public CartPage addCartOperataion(){
		this.getAddCarBtnField().click();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		this.getPayAccountBtnField().click();
		return new CartPage(driver);
	}

}

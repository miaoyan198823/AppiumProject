package com.csdn.mallpages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * C币商城某C币商品详情页页面
 * @author miaoyan
 *
 */
public class CproductDetailPage {
	public final String CPR_DETAIL_TITLE = "C币商城测试商品-杯子-CSDN C币商城";
	private WebDriver driver;
	
	private static By buyNowBtnLocator = By.id("buy_now");
	private static By addCarBtnLocator = By.id("add_shoppingCar");
	private static By payAccountBtnLocator = By.cssSelector(".payAccount");
	
	public CproductDetailPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getTitle(){
		return this.driver.getTitle();
	}
	
	public WebElement getBuyNowTextField(){
		return this.driver.findElement(buyNowBtnLocator);
	}
	
	public WebElement getAddCarBtnTextField(){
		return this.driver.findElement(addCarBtnLocator);
	}
	
	public WebElement getPayAccountField(){
		return this.driver.findElement(payAccountBtnLocator);
	}
	
//	C币商品详情页，点击【立即购买】按钮，是否正确返回提交订单页面
	public OrderSubmitPage buyNowOperation(){
		this.getBuyNowTextField().click();
		return new OrderSubmitPage(driver);
	}
	
//	C币商品详情页，点击【加入购物车】按钮，是否正确进入购物车页面
	public CartPage addCartOpertion(){
		this.getAddCarBtnTextField().click();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		this.getPayAccountField().click();
		return new CartPage(driver);
	}
}

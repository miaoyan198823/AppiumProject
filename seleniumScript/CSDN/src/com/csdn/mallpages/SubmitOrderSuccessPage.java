package com.csdn.mallpages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



/**
 * 成功提交订单页面
 * @author miaoyan
 *
 */

public class SubmitOrderSuccessPage {
	public static  String SUBMIT_ORDER_SUCCESS_PAGETITLE = "成功提交订单";
	private WebDriver driver;
	private static By confirmPayBtnLocator = By.cssSelector(".confirm_btn");
	private static By aliPayButtonLocator = By.xpath("html/body/div[3]/div/div[2]/div/p/a[1]/img");
	private static By weChatPayButtonLocatorBy = By.xpath("html/body/div[3]/div/div[2]/div/p/a[2]/img");
	
	public SubmitOrderSuccessPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getTitle(){
		return this.driver.getTitle();
	}
	
	public String getCunrrentUrl(){
		return this.driver.getCurrentUrl();
	}
	
	public String getPageSource(){
		return this.driver.getPageSource();
	}
	
	public WebElement getConfirmPayBtnField(){
		return this.driver.findElement(confirmPayBtnLocator);
	}
	
	public WebElement getAliPayButtonField(){
		return this.driver.findElement(aliPayButtonLocator);
	}
	
	public WebElement getWeChatPayButtonField(){
		return this.driver.findElement(weChatPayButtonLocatorBy);
	}
//	C币商品支付时，成功提交订单 页面出现【确认支付】按钮
	public SuccessPayPage confirmPayBtnClick(){
		this.getConfirmPayBtnField().click();
		return new SuccessPayPage(driver);
	}
	
//	点击【支付宝支付】图标按钮操作,正确返回第三方支付宝支付页面
	public AliPayPage aliPayImgClick(){
		this.getAliPayButtonField().click();
		driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
		return new AliPayPage(driver);
	}
	
//	点击【微信支付】图标按钮操作，正确返回第三方微信支付页面
	public WeChatPayPage weChatImgClick(){
		this.getWeChatPayButtonField().click();
		driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
		return new WeChatPayPage(driver);
	}
	
}

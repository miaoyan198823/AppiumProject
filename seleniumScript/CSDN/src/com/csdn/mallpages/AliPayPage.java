package com.csdn.mallpages;
import org.openqa.selenium.WebDriver;


/**
 * 第三方支付宝页面
 * @author miaoyan
 *
 */

public class AliPayPage {
	public static final String aliPay_TITLE = "支付宝 - 网上支付 安全快速！";
	private WebDriver driver;
	
	public AliPayPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getTitle(){
		return this.driver.getTitle();
	}
	
	public String getCurrentUrl(){
		return this.driver.getCurrentUrl();
	}
	
	public String getPageSource(){
		return this.driver.getPageSource();
	}
}

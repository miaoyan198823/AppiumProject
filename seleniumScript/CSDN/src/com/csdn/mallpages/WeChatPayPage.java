package com.csdn.mallpages;
import org.openqa.selenium.WebDriver;


/**
 * 第三方微信支付页面
 * @author miaoyan
 *
 */

public class WeChatPayPage {
	public static final String WECHATPAY_TITLE = "微信支付 - CSDN";
	private WebDriver driver;
	
	public WeChatPayPage(WebDriver driver){
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

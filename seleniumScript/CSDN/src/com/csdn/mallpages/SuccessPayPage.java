package com.csdn.mallpages;
import org.openqa.selenium.WebDriver;

/**
 * 订单支付成功页面
 * @author miaoyan
 *
 */

public class SuccessPayPage {
	public static final String SUCCESS_PAY_PAGE_TITLE = "订单中心";
	
	private WebDriver driver;
	
	public SuccessPayPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getPageSource(){
		return this.driver.getPageSource();
	}
	
	public String getTitle(){
		return this.driver.getTitle();
	}
	

}

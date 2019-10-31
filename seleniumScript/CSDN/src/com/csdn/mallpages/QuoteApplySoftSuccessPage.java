package com.csdn.mallpages;
import org.openqa.selenium.WebDriver;


/**
 * 软件报价单申请成功页面
 * @author miaoyan
 *
 */

public class QuoteApplySoftSuccessPage {
	public static String qasPageInfoText = "您的报价单成功提交！";
	public static String qasPageUrl = "http://mall.csdn.net/quota/doapply";
	private WebDriver driver;
	
	public QuoteApplySoftSuccessPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getCurrentUrl(){
		return this.driver.getCurrentUrl();
	}
	
	public String getPageSource(){
		return this.driver.getPageSource();
	}
}

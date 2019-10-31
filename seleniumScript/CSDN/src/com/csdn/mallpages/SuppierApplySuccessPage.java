package com.csdn.mallpages;

import org.openqa.selenium.WebDriver;

/**
 * 申请供应商成功页面
 * @author miaoyan
 *
 */
public class SuppierApplySuccessPage {
	private WebDriver driver;
	public String SCpageUrl="http://betamall.csdn.net/";
	public static final String PageSourceInfo = "申请成功";
	
	public SuppierApplySuccessPage(WebDriver driver,String SCpageUrl){
		this.driver = driver;
		this.SCpageUrl = SCpageUrl;
		
	}
	
	public String getPageSource(){
		return driver.getPageSource();
	}
	
	public String getCurrentUrl(){
		return this.driver.getCurrentUrl();
	}
}

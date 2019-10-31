package com.csdn.mallpages;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



/**
 * 软件商城列表页
 * @author miaoyan
 *
 */

public class SoftToolPage {
	private WebDriver driver;
	private static By quoteApplySoftLocator = By.cssSelector(".mod_apply_btn1");
	
	public SoftToolPage(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getQuoteApplySoftBtnField(){
		return this.driver.findElement(quoteApplySoftLocator);
	}
	
	public void switchHandles(WebDriver driver){
		try {
			ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(windows.get(1));
		} catch (Exception e) {
			driver.quit();
		}
	}
	
//	点击【软件报价单申请】按钮，是否进入软件报价单申请页面
	public QuoteApplySoftPage quoteApplySoftBtnClick(){
		this.getQuoteApplySoftBtnField().click();
		this.switchHandles(driver);
		return new QuoteApplySoftPage(driver);
		
	}
}

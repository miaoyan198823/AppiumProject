package com.csdn.mallpages;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.apache.commons.collections.map.StaticBucketMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * 商城首页页面
 * @author miaoyan
 *
 */

public class MallHomePage  {
	private String homePageUrl = "http://betamall.csdn.net/";
	public static final String HOMEPAGE_TITLE = "CSDN商城";
	private static By suppierApplyBtnLocator = By.cssSelector(".applyTo_supplier");
	private static By cBproductImgLocator = By.xpath("html/body/div[5]/div[6]/div[1]/div[2]/ul/li[1]/a/img");
	private static By softProductImgLocator = By.xpath("html/body/div[5]/div[4]/div[1]/div[2]/ul/li[1]/a/img");
	private WebDriver driver;
	
	public MallHomePage(WebDriver driver,String homePageUrl){
		this.driver = driver;
		this.homePageUrl = homePageUrl;
		
		
	}
	//返回页面标题
	public String getTitle(){
		return this.driver.getTitle();
	}
	
	public String getCurrentUrl(){
		return this.driver.getCurrentUrl();
	}
	
	public WebElement suppierApplyBtnField(){
		return this.driver.findElement(suppierApplyBtnLocator);
	}
	
	public WebElement cbProductImgClickLink(){
		return this.driver.findElement(cBproductImgLocator);
	}
	
	public WebElement softProductImgClickLink(){
		return this.driver.findElement(softProductImgLocator);
	}
	
	
//	多窗口切换方法
	public static void switchHandles(WebDriver driver){
		try {
			ArrayList<String> Windows = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(Windows.get(1));
		} catch (Exception e) {
			driver.quit();
		}
	}
//	商城首页【申请供应商】操作按钮
	public boolean suppierApplyBtnClick(){
		this.suppierApplyBtnField().click();
		this.switchHandles(driver);
		return SuppierApplyPage.SUPPIER_APPLY_PAGE_TITLE.equals(this.getTitle());
	}
//	点击商城首页C币商城某一商品进入该商品详情页操作
	public CproductDetailPage goToCproductDetailsImgClick(){
		this.cbProductImgClickLink().click();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		this.switchHandles(driver);
		return new CproductDetailPage(driver);
	}
	
//  点击商城首页软件商城某一商品进入该软件商品详情页
	public SoftProductDetailPage goToSoftProductDetailsImgClick(){
		this.softProductImgClickLink().click();
		this.switchHandles(driver);
		return new SoftProductDetailPage(driver);
	}
	
}

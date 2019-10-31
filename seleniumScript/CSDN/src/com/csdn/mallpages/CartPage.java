package com.csdn.mallpages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * 购物车页面
 * @author miaoyan
 *
 */

public class CartPage {
	public String caPageUrl = "http://cart.csdn.net/cart";
	public static String caPageCpductSourceText = "程序员2015年11月";
	public static String caPageSoftSourceText = "Enterprise Architect 12 中文版/英文版";
	private WebDriver driver;
	private static By payAccountBtnLocator = By.xpath(".//*[@id='submit_full']/a");
	private static By delCheckCartBtnLocator = By.cssSelector(".shopping_tr_b>td>a");
	
	public CartPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getCurrentUrl(){
		return this.driver.getCurrentUrl();
	}
	
	public String getPageSource(){
		return this.driver.getPageSource();
	}
	
	public WebElement getPayAccountBtnField(){
		return this.driver.findElement(payAccountBtnLocator);
	}
	
	public WebElement getDelCheckCartBtnField(){
		return this.driver.findElement(delCheckCartBtnLocator);
	}
	
//	点击购物车【去结算】按钮，页面是否正确跳转到进入订单提交页面
	public OrderSubmitPage payAccountBtnClick(){
		this.getPayAccountBtnField().click();
		return new OrderSubmitPage(driver);
	}
	
//	点击购物车页面【移除选中商品】按钮
	public void delCartProductOperation(){
		this.getDelCheckCartBtnField();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	}
}

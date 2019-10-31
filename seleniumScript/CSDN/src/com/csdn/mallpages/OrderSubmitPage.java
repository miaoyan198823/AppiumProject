package com.csdn.mallpages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;




/**
 * 订单提交页面
 * @author miaoyan
 *
 */

public class OrderSubmitPage {
	public String OSpageUrl = "http://order.csdn.net/order/order_submit_info";
	public static final String ORDER_SUB_PAGE_TITLE = "订单信息";
	private WebDriver driver;
	private static By orderContactNameLocator = By.xpath(".//*[@id='edit_order_contact']/div[1]/input");
	private static By orderContactMobileNumLocator = By.xpath(".//*[@id='edit_order_contact']/div[2]/input");
	private static By orderContactCompanyNameLocator = By.xpath(".//*[@id='edit_order_contact']/div[3]/input");
	private static By orderContactEmailLocator = By.xpath(".//*[@id='edit_order_contact']/div[4]/input");
	private static By orderContactProvinceSelectLocator = By.xpath(".//*[@id='province']");
	private static By orderContactCitySelectLocator = By.xpath(".//*[@id='city']");
	private static By orderContactAddressLocator = By.xpath(".//*[@id='edit_order_contact']/div[6]/input");
	private static By orderContactPostNumLocator = By.xpath(".//*[@id='edit_order_contact']/div[7]/input");
	private static By orderContactSaveButtonLocator = By.xpath(".//*[@id='order_contact_button']");
	private static By orderInvoiceSaveButtonLocator = By.xpath(".//*[@id='btn_inv_sav']");
	private static By submitOrderFormButtonLocator = By.xpath(".//*[@id='submitOrderForm']");
	
	
	
	
	public OrderSubmitPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getTitle(){
		return this.driver.getTitle();
	}
	
	public String getCurrentUrl(){
		return this.driver.getCurrentUrl();
	}
	
	public WebElement getOrderContactNameField(){
		return this.driver.findElement(orderContactNameLocator);
	}
	
	public WebElement getOrderContactMobileNumField(){
		return this.driver.findElement(orderContactMobileNumLocator);
	}
	
	public WebElement getOrderContactCompanyNameField(){
		return this.driver.findElement(orderContactCompanyNameLocator);
	}
	
	public WebElement getOrderContactEmailField(){
		return this.driver.findElement(orderContactEmailLocator);
	}
	
	public WebElement getOrderContactProvinceSelectField(){
		return this.driver.findElement(orderContactProvinceSelectLocator);
	}
	
	public WebElement getOrderContactCitySelectField(){
		return this.driver.findElement(orderContactCitySelectLocator);
	}
	
	public WebElement getOrderContactAddressField(){
		return this.driver.findElement(orderContactAddressLocator);
	}
	
	public WebElement getOrderContactPostNumField(){
		return this.driver.findElement(orderContactPostNumLocator);
	}
	
	public WebElement getOrderContactSaveButtonField(){
		return this.driver.findElement(orderContactSaveButtonLocator);
	}
	
	public WebElement getOrderInvoiceSaveButtonField(){
		return this.driver.findElement(orderInvoiceSaveButtonLocator);
	}
	
	public WebElement getSubmitOrderFormButtonField(){
		return this.driver.findElement(submitOrderFormButtonLocator);
	}
	
	public SubmitOrderSuccessPage submitOrderFormBtn(){
		this.getSubmitOrderFormButtonField().click();
		return new SubmitOrderSuccessPage(driver);
	}
//	填写订单提交页面联系人信息，然后点击【提交订单】按钮，是否正确返回订单成功页面
	public SubmitOrderSuccessPage orderSubmitInfoOperation(String contactName,String contactMobileNum,String contactCompanyName,String contactEmail,String contactProvinceSelectText,String contactCitySelectText,
	String contactAddress,String contactPostNum){
		this.getOrderContactNameField().clear();
		this.getOrderContactNameField().sendKeys(contactName);
		this.getOrderContactMobileNumField().clear();
		this.getOrderContactMobileNumField().sendKeys(contactMobileNum);
		this.getOrderContactCompanyNameField().clear();
		this.getOrderContactCompanyNameField().sendKeys(contactCompanyName);
		this.getOrderContactEmailField().clear();
		this.getOrderContactEmailField().sendKeys(contactEmail);
		new Select(this.getOrderContactProvinceSelectField()).selectByVisibleText(contactProvinceSelectText);
		driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
		new Select(this.getOrderContactCitySelectField()).selectByVisibleText(contactCitySelectText);
		this.getOrderContactAddressField().clear();
		this.getOrderContactAddressField().sendKeys(contactAddress);
		this.getOrderContactPostNumField().clear();
		this.getOrderContactPostNumField().sendKeys(contactPostNum);
		this.getOrderContactSaveButtonField().click();
		this.getOrderInvoiceSaveButtonField().click();                             //软件商城商品订单需要设置发票内容，C币商城商品则不需要设置发票内容
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		this.getSubmitOrderFormButtonField().click();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		return new SubmitOrderSuccessPage(driver);
	}
}

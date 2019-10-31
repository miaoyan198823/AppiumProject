package com.csdn.mallpages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



/**
 * 软件报价单申请页面
 * @author miaoyan
 *
 */
public class QuoteApplySoftPage {
	public String qaPageUrl = "http://betamall.csdn.net/quota/apply";
	private WebDriver driver;
	private static By suppierNameSelectLocator = By.id("supplier_id");
	private static By softCheckboxLocator = By.xpath("//input[@type='checkbox'][@value='618']");
	private static By companyNameLocator = By.id("company");
	private static By contactNameLocator = By.id("real_name");
	private static By contactTelNumLocator = By.id("telephone");
	private static By contactMobileNumLocator = By.id("mobile");
	private static By contactEmailLocator = By.id("email");
	private static By submitButtonLocator = By.name("submit");
	
	public QuoteApplySoftPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getCurrentUrl(){
		return this.driver.getCurrentUrl();
	}
	
	public WebElement getSuppierNameSelectField(){
		return this.driver.findElement(suppierNameSelectLocator);
	}
	
	public WebElement getSoftCheckboxField(){
		return this.driver.findElement(softCheckboxLocator);
	}
	
	public WebElement getCompanyNameTextField(){
		return this.driver.findElement(companyNameLocator);
	}
	
	public WebElement getContactNameTextField(){
		return this.driver.findElement(contactNameLocator);
	}
	
	public WebElement getContactTelNumTextField(){
		return this.driver.findElement(contactTelNumLocator);
	}
	
	public WebElement getContactMobileNumTextField(){
		return this.driver.findElement(contactMobileNumLocator);
	}
	
	public WebElement getContactEmailTextField(){
		return this.driver.findElement(contactEmailLocator);
	}
	
	public WebElement getSubmitButtonField(){
		return this.driver.findElement(submitButtonLocator);
	}
	

	
	public QuoteApplySoftSuccessPage quoteApplySoftOperation(String supplierId,String companyName,String contactName,String telNum,String mobileNum,String email){
		new Select(this.getSuppierNameSelectField()).selectByVisibleText(supplierId);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		this.getSoftCheckboxField().click();
		this.getCompanyNameTextField().sendKeys(companyName);
		this.getContactNameTextField().sendKeys(contactName);
		this.getContactTelNumTextField().sendKeys(telNum);
		this.getContactMobileNumTextField().sendKeys(mobileNum);
		this.getContactEmailTextField().sendKeys(email);
		this.getSubmitButtonField().click();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		return new QuoteApplySoftSuccessPage(driver);
		
	}
}

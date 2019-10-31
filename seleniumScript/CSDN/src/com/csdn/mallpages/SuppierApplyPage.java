package com.csdn.mallpages;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.map.StaticBucketMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.csdn.mallpages.*;
/**
 * 申请供应商操作信息页面
 * @author miaoyan
 *
 */
public class SuppierApplyPage {
	public static final String SUPPIER_APPLY_PAGE_TITLE = "软件供应商申请-CSDN软件商城";
	public String SCpageUrl="http://betamall.csdn.net/";
	private WebDriver driver;
	private SuppierApplyPage spage;
	private SuppierApplySuccessPage scPage;
	private static By companyNameLocator = By.id("company_name");
	private static By companySiteLocator = By.id("company_site");
	private static By companyDescLocator = By.id("company_desc");
	private static By softWareNameLocator = By.id("software_name");
	private static By softWareDescLocator = By.id("software_desc");
	private static By softWarePriceLocator = By.id("software_price");
	private static By softLimitRadioLocator = By.id("buy_limit_btn2");
	private static By contactNameLocator = By.id("name");
	private static By companyTelNumLocator = By.id("company_tel");
	private static By contactMobileNumLocator = By.id("mobile");
	private static By contactEmailLocator = By.id("email");
	private static By submitButtonLocator = By.xpath(".//*[@id='myform']/ul[2]/li[6]/input");
	
	public SuppierApplyPage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getCurrentUrl(){
		return this.driver.getCurrentUrl();
	}
	
	public String getTitle(){
		return this.driver.getTitle();
	}
	
	public WebElement getCompanyNameTextField(){
		return this.driver.findElement(companyNameLocator);
	}
	
	public WebElement getCompanySiteTextField(){
		return this.driver.findElement(companySiteLocator);
	}
	
	public WebElement getCompanyDescTextField(){
		return this.driver.findElement(companyDescLocator);
	}
	
	public WebElement getSoftwareNameTextField(){
		return this.driver.findElement(softWareNameLocator);
	}
	
	public WebElement getSoftwareDescTextField(){
		return this.driver.findElement(softWareDescLocator);
	}
	
	public WebElement getSoftwarePriceTextField(){
		return this.driver.findElement(softWarePriceLocator);
	}
	
	public WebElement getSoftwareLimitRadioLocatorTextField(){
		return this.driver.findElement(softLimitRadioLocator);
	}
	
	public WebElement getContactNameLocatorTextField(){
		return this.driver.findElement(contactNameLocator);
	}
	
	public WebElement getCompanyTelNumTextField(){
		return this.driver.findElement(companyTelNumLocator);
	}
	
	public WebElement getContactMobileNumTextField(){
		return this.driver.findElement(contactMobileNumLocator);
	}
	
	public WebElement getContactEmailTextField(){
		return this.driver.findElement(contactEmailLocator);
	}
	
	public WebElement getSubmitButtonTextField(){
		return this.driver.findElement(submitButtonLocator);
	}
	
	public boolean isLoaded(){
		
		return SuppierApplyPage.SUPPIER_APPLY_PAGE_TITLE.equals(this.driver.getTitle());
	}
//	申请供应商操作，申请成功后正确返回申请成功页面
	public SuppierApplySuccessPage suppierApplySuccessOperation(String companyName,String companySite,String companyDesc,String softWareName,String softWareDesc,String softWarePrice,String contactName,
	String companyTelNum,String contactMobileNum,String contactEmail){
		this.getCompanyNameTextField().sendKeys(companyName);
		this.getCompanySiteTextField().sendKeys(companySite);
		this.getCompanyDescTextField().sendKeys(companyDesc);
		this.getSoftwareNameTextField().sendKeys(softWareName);
		this.getSoftwareDescTextField().sendKeys(softWareDesc);
		this.getSoftwarePriceTextField().sendKeys(softWarePrice);
		this.getSoftwareLimitRadioLocatorTextField().click();
		this.getContactNameLocatorTextField().sendKeys(contactName);
		this.getCompanyTelNumTextField().sendKeys(companyTelNum);
		this.getContactMobileNumTextField().sendKeys(contactMobileNum);
		this.getContactEmailTextField().sendKeys(contactEmail);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		this.getSubmitButtonTextField().click();
		driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
		return new SuppierApplySuccessPage(driver,SCpageUrl);
		}
	
}

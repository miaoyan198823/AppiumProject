package com.csdn.csto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateProPage {
	private WebDriver driver;
    private static By publishFreeProBtnLocator = By.cssSelector(".publish_free");
	private static By proNameLocator = By.id("input_prjnew_title");
	private static By proTypeTagLocator = By.id("tag1");
	private static By proTypeRadioLocator = By.id("tag_ck_35");
	private static By typeDivCompleteLocator = By.cssSelector(".input_btn");
	private static By proDescrptionLocator = By.id("input_prjnew_text");
	private static By uploadButtonLocator = By.id("but_att_upload");
	private static By fileContentLocator = By.name("attachment1");
	private static By tagNewLocator = By.cssSelector(".tagNew");
	private static By tagIdLocator = By.id("119");
	private static By tagDivCloseLocator = By.cssSelector(".tagClose");
	private static By proBudgetLocator = By.id("money_start");
	private static By mobileStatusLocator = By.id("mobile_status");
	private static By mobileformLocator = By.id("mobile");
	private static By showIconLocator = By.id("show_demand");
	private static By bidPeriodLocator = By.id("bids_period");
	private static By proCompleteTimeLocator = By.id("prj_time");
	private static By submitProButton = By.xpath("//input[@type='button'][@value='提交普通项目']");
	
	
	public CreateProPage(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getPublishFreeProBtnTextField(){
		return this.driver.findElement(publishFreeProBtnLocator);
	}
	
	public WebElement getProNameTextField(){
		return this.driver.findElement(proNameLocator);
	}
	
	public WebElement getProTypeTagTextField(){
		return this.driver.findElement(proTypeTagLocator);
	}
	
	public WebElement getProTypeRadioTextField(){
		return this.driver.findElement(proTypeRadioLocator);
	}
	
	public WebElement getTypeDivCompleteTextField(){
		return this.driver.findElement(typeDivCompleteLocator);
	}
	
	public WebElement getProDescrptionTextField(){
		return this.driver.findElement(proDescrptionLocator);
	}
	
	public WebElement getUploadButtonTextField(){
		return this.driver.findElement(uploadButtonLocator);
	}
	
	public WebElement getFileContentTextField(){
		return this.driver.findElement(fileContentLocator);
	}
	
	public WebElement getTagNewTextField(){
		return this.driver.findElement(tagNewLocator);
	}
	
	public WebElement getTagIdTextField(){
		return this.driver.findElement(tagIdLocator);
	}
	
	public WebElement getTagDivCloseTextField(){
		return this.driver.findElement(tagDivCloseLocator);
	}
	
	public WebElement getProBudgetTextField(){
		return this.driver.findElement(proBudgetLocator);
	}
	
	public WebElement getMobileStatusTextField(){
		return this.driver.findElement(mobileStatusLocator);
	}
	
	public WebElement getMobileFormTextField(){
		return this.driver.findElement(mobileformLocator);
	}
	
	public WebElement getShowIconTextField(){
		return this.driver.findElement(showIconLocator);
	}
	
	public WebElement getBidPeriodTextField(){
		return this.driver.findElement(bidPeriodLocator);
	}
	
	public WebElement getProCompleteTimeTextField(){
		return this.driver.findElement(proCompleteTimeLocator);
	}
	
	public WebElement getSubmitProButtonTextField(){
		return this.driver.findElement(submitProButton);
	}
	
	public void selectProType(){
		try {
			this.getProTypeTagTextField().click();
			
				this.getProTypeRadioTextField().click();
				this.getTypeDivCompleteTextField().click();
				driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
			
		} catch (Exception e) {
			e.printStackTrace();
	}
		
}
	
	public void selectProTag(){
		try {
			this.getTagNewTextField().click();
			if (!getTagIdTextField().isSelected()) {
				this.getTagIdTextField().click();
				this.getTagDivCloseTextField().click();
				driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			}
		} catch (Exception e) {
			e.printStackTrace();
	}
}
	public void inputMobileInfo(){
		if (!getMobileStatusTextField().isSelected()) {
			this.getMobileStatusTextField().click();
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		}
	}
	
	public ProMangementPage createProOperation(String proName,String proDescript,String fileContent,String proBudget,String mobileNum,String bidPeriodTime,String proCompleteTime){
		this.getPublishFreeProBtnTextField().click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		this.getProNameTextField().sendKeys(proName);
		this.selectProType();
		this.getProDescrptionTextField().sendKeys(proDescript);
		this.getUploadButtonTextField().click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		this.getFileContentTextField().sendKeys(fileContent);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		this.selectProTag();
		new Select(this.getProBudgetTextField()).selectByVisibleText(proBudget);
		this.inputMobileInfo();
		this.getMobileFormTextField().sendKeys(mobileNum);
		this.getShowIconTextField().click();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		new Select(this.getBidPeriodTextField()).selectByVisibleText(bidPeriodTime);
		new Select(this.getProCompleteTimeTextField()).selectByVisibleText(proCompleteTime);
		this.getSubmitProButtonTextField().click();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	    return new ProMangementPage(driver);
	}

}

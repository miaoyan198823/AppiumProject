package com.csdn.adminedupages;

/**
 * @author miaoyan
 * 优惠卷管理后台
 */
import java.nio.Buffer;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateVolumePage {
	private WebDriver driver;
	private String volumeUrl;
	public final String VOLUME_NAME = "50元现金卷";
	private static By volumeAdminLocator = By.xpath(".//*[@id='accordion']/div[4]/div[1]/h4/a");
	private static By createVolumeLocator = By.xpath(".//*[@id='collapseFour']/div/a[1]");
	private static By platTypeLocator = By.id("platType");
	private static By volumeTypeLocator = By.id("type");
	private static By volumeNameLocator = By.id("name");
	private static By volumeValueLocator = By.id("value1");
	private static By volumeNumberLocator = By.id("total");
	private static By userLimitLocator = By.xpath("//input[@type='radio'][@value='1']");
	private static By beginDateLocator = By.id("begindate");
	private static By beginDateTimeLocator = By.xpath("//tr/td[@onclick='day_Click(2015,12,29);']");		
	private static By endDateLocator = By.id("enddate");
	private static By endDateTimeLocator = By.xpath("//tr/td[@onclick='day_Click(2015,12,30);']");
	private static By createButtonLocator = By.xpath("//input[@type='submit'][@value='创建']");
	private static By volumeEffectLocator = By.id("valid");
	private static By iframeLocator = By.xpath("//iframe[@border='0']");
	private static By seeVolumeLocator = By.xpath(".//*[@id='collapseFour']/div/a[2]");
	private static By findVolumeLocator = By.xpath("//input[@type='submit'][@value='查找']");
	private static By verifyVolumeNameLocator = By.xpath("//td[.='50元现金卷']");
	
	
	public CreateVolumePage(WebDriver driver){
		this.driver = driver;
		
	}
	
	public WebElement getVolumeAdminField(){
		return this.driver.findElement(volumeAdminLocator);
	}
	
	public WebElement getCreateVolumeField(){
		return this.driver.findElement(createVolumeLocator);
	}
	
	public WebElement getPlatTypeField(){
		return this.driver.findElement(platTypeLocator);
	}
	
	public WebElement getVolumeTypeField(){
		return this.driver.findElement(volumeTypeLocator);
	}
	
	public WebElement getVolumeNameField(){
		return this.driver.findElement(volumeNameLocator);
	}
	
	public WebElement getVolumeValueField(){
		return this.driver.findElement(volumeValueLocator);
	}
	
	public WebElement getVolumeNumberField(){
		return this.driver.findElement(volumeNumberLocator);
	}
	
	public WebElement getUserLimitField(){
		return this.driver.findElement(userLimitLocator);
	}
	
	public WebElement getBeginDateField(){
		return this.driver.findElement(beginDateLocator);
	}
	
	public WebElement getBeginDateTimeField(){
		return this.driver.findElement(beginDateTimeLocator);
	}
	
	public WebElement getEndDateField(){
		return this.driver.findElement(endDateLocator);
	}
	
	public WebElement getEndDateTimeField(){
		return this.driver.findElement(endDateTimeLocator);
	}
	
	public WebElement getCreateButtonField(){
		return this.driver.findElement(createButtonLocator);
	}
	
	public WebElement getVolumeEffectField(){
		return this.driver.findElement(volumeEffectLocator);
	}
	
	public WebElement getSeeVolumeField(){
		return this.driver.findElement(seeVolumeLocator);
	}
	
	public WebElement getFindVolumeField(){
		return this.driver.findElement(findVolumeLocator);
	}
	
	public WebElement getVerifyVolumeNameField(){
		return this.driver.findElement(verifyVolumeNameLocator);
	}
	
	public void checkRadio(){
		if (!getUserLimitField().isSelected()) {
			this.getUserLimitField().click();
		}
	}
	
//	判断Alert是否存在，如果存在点击【确定】按钮
	public boolean isAlertPresent(){
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			return true;
		} catch (Exception e) {
			return false;
	}
}
	
//	获取Alert弹窗message
	public String getAlert(){
		Alert alert = driver.switchTo().alert();
		String Str_alert = alert.getText();
		return Str_alert;
	}
	
//	选择时间优惠卷起始时间
	public void switchIframeDate(){
		getBeginDateField().click();
		driver.switchTo().frame(driver.findElement(iframeLocator));
		getBeginDateTimeField().click();
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		getEndDateField().click();
		driver.switchTo().frame(driver.findElement(iframeLocator));
		getEndDateTimeField().click();
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
	}
	
//	创建优惠卷操作
	public void createVolumeOperation(String platTypeText,String volumeTypeText,String volumeNameText,String volumeValue,String volumeNum){
		this.getVolumeAdminField().click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		this.getCreateVolumeField().click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		new Select(this.getPlatTypeField()).selectByVisibleText(platTypeText);
		new Select(this.getVolumeTypeField()).selectByVisibleText(volumeTypeText);
		this.getVolumeNameField().sendKeys(volumeNameText);
		this.getVolumeValueField().sendKeys(volumeValue);
		this.getVolumeNumberField().sendKeys(volumeNum);
		this.checkRadio();
		this.switchIframeDate();
		this.getCreateButtonField().click(); // 创建按钮
		this.isAlertPresent();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		this.getVolumeEffectField().click();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		this.isAlertPresent();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		this.isAlertPresent();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
	
		
	}
	
//	查看优惠卷方法
	public boolean seeVolumeInfo(String platTypeText,String volumeTypeText){
		this.getVolumeAdminField().click();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		this.getSeeVolumeField().click();
		new Select(this.getPlatTypeField()).selectByVisibleText(platTypeText);
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		new Select(this.getVolumeTypeField()).selectByVisibleText(volumeTypeText);
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		this.getFindVolumeField().click();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		return this.VOLUME_NAME.equals(this.getVerifyVolumeNameField().getText());
	}
	
}

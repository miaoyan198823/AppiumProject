package com.csdn.mall;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class QuotaApply extends Login{
	
	private String supplierId = "ZOHO";
	private String companyName = "CSDN";
	private String contactName = "缪岩";
	private String telNumber = "64132155";
	private String mobileNumber = "15010719147";
	private String email = "550775725@qq.com";
	
	private void quotaApplyOperationInfo(){
		new Select(driver.findElement(By.id("supplier_id"))).selectByVisibleText(supplierId);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement radio_crm = driver.findElement(By.xpath("//input[@type='checkbox'][@value='614']"));
		if(!radio_crm.isSelected()){
			radio_crm.click();
		}
		WebElement radio_docs = driver.findElement(By.xpath("//input[@type='checkbox'][@value='619']"));
		if(!radio_docs.isSelected()) {
			radio_docs.click();
		}
		
		driver.findElement(By.id("company")).clear();
		driver.findElement(By.id("company")).sendKeys(companyName);
		driver.findElement(By.id("real_name")).clear();
		driver.findElement(By.id("real_name")).sendKeys(contactName);
		driver.findElement(By.id("telephone")).clear();
		driver.findElement(By.id("telephone")).sendKeys(telNumber);
		driver.findElement(By.id("mobile")).clear();
		driver.findElement(By.id("mobile")).sendKeys(mobileNumber);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.xpath("//input[@type='submit'][@value='提交']")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		System.out.println("软件报价单申请信息提交成功后返回页面地址为："+driver.getCurrentUrl());
		boolean isFindPageSource=true;
		try {
			driver.getPageSource().contains("您的报价单成功提交！");
			isFindPageSource=true;
		} catch (Exception e) {
			e.printStackTrace();
			isFindPageSource=false;
		}finally{
			System.out.println("软件报价单申请成功页面是否成功返回【您的报价单成功提交！】字样："+isFindPageSource);
		}
		
	}
	
	@Test
	public void quotaApplyOperation(){
		this.setUrl("https://passport.csdn.net/account/login?from=http://betamall.csdn.net/quota/apply");
		this.setUserName("miaoyan1989");
		this.setPassWord("miaoyan2011");
		mouse_moveInfo();
		quotaApplyOperationInfo();
		
		
	}
}

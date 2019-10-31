package com.csdn.mall;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SupplierApply extends Login{
	private void supplierApplyOperationInfo(String company_name,String company_site,String company_desc,String software_name,String software_desc,String software_price,
		String contact_name,String company_Tel,String contact_mobile,String contact_email){
		driver.findElement(By.id("company_name")).clear();
		driver.findElement(By.id("company_name")).sendKeys(company_name);
		driver.findElement(By.id("company_site")).clear();
		driver.findElement(By.id("company_site")).sendKeys(company_site);
		driver.findElement(By.id("company_desc")).clear();
		driver.findElement(By.id("company_desc")).sendKeys(company_desc);
		driver.findElement(By.id("software_name")).clear();
		driver.findElement(By.id("software_name")).sendKeys(software_name);
		driver.findElement(By.id("software_desc")).clear();
		driver.findElement(By.id("software_desc")).sendKeys(software_desc);
		driver.findElement(By.id("software_price")).clear();
		driver.findElement(By.id("software_price")).sendKeys(software_price);
		
		WebElement radio_btn = driver.findElement(By.id("buy_limit_btn2"));
		if(!radio_btn.isSelected()){
			radio_btn.click();
		}else{
			System.out.println("软件知识产权情况选项未选中！");
		}
		Assert.assertTrue(radio_btn.isSelected());
		
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys(contact_name);
		driver.findElement(By.id("company_tel")).clear();
		driver.findElement(By.id("company_tel")).sendKeys(company_Tel);
		driver.findElement(By.id("mobile")).clear();
		driver.findElement(By.id("mobile")).sendKeys(contact_mobile);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(contact_email);
		driver.findElement(By.xpath("//input[@type='submit'][@value='提交']")).click();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		System.out.println("供应商申请信息提交成功后返回页面链接地址为："+driver.getCurrentUrl());
		boolean isFindPageSource=true;
		try {
			driver.getPageSource().contains("申请成功");
			isFindPageSource=true;
		} catch (Exception e) {
			e.printStackTrace();
			isFindPageSource=false;
		}finally{
			System.out.println("供应商申请信息提交成功页面是否包含【申请成功】字样："+isFindPageSource);
		}
	}
	
	
	
	@Test
	public void supplierApplyOperation(){
		this.setUrl("https://passport.csdn.net/account/login?from=http://betamall.csdn.net/supplier/apply");
		this.setUserName("miaoyan1989");
		this.setPassWord("miaoyan2011");
		mouse_moveInfo();
		String company_name = "selenium科技";
		String company_site = "http://selenium.cn";
		String company_desc = "公司主要致力于软件测试开发课程培训及产品研发";
		String software_name = "selenium WebDriver";
		String software_desc = "是一款基于页面元素的自动化测试框架，支持多种开发语言";
		String software_price = "100";
		String contact_name = "缪岩";
		String company_Tel = "010-64132155";
		String contact_mobile = "15101183723";
		String contact_email = "miaoyan@csdn.net";
		supplierApplyOperationInfo(company_name, company_site, company_desc, software_name, software_desc, software_price, contact_name, company_Tel, contact_mobile, contact_email);
	}
}

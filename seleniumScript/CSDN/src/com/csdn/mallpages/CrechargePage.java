package com.csdn.mallpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * C币充值页面
 * @author miaoyan
 *
 */
public class CrechargePage {
	public String rechargeAmountInfoText = "100.00";
	public String aliPaySourceInfoText = "支付宝支付";
	public String weChatSourceInfoText = "微信支付";
	private WebDriver driver;
	private static By numChargeLocator = By.xpath("html/body/div[3]/div/div[2]/div/form/ul/li[3]/span/em[3]");
	private static By aliPayChargeWayLocator = By.xpath("html/body/div[3]/div/div[2]/div/form/ul/li[5]/span/a[1]/img");
	private static By weChatChargeWayLocator = By.xpath("html/body/div[3]/div/div[2]/div/form/ul/li[5]/span/a[2]/img");
	public CrechargePage(WebDriver driver){
		this.driver = driver;
	}
	
	public String getPageSource(){
		return this.driver.getPageSource();
	}
	
	public WebElement getNumChargeField(){
		return this.driver.findElement(numChargeLocator);
	}
	
	public WebElement getAliPayChargeWayField(){
		return this.driver.findElement(aliPayChargeWayLocator);
	}
	
	public WebElement getWeChatChargeWayField(){
		return this.driver.findElement(weChatChargeWayLocator);
	}
	
//	选择C币充值数量为【1000C币】
	public void numReChargeClick(){
		this.getNumChargeField().click();
	}
	
//	选择支付宝支付方式
	public void aliPayRechargeWayClick(){
		this.getAliPayChargeWayField().click();
	}
	
//	选择微信支付方式
	public void WeChatReChargeWayClick(){
		this.getWeChatChargeWayField().click();
	}

}

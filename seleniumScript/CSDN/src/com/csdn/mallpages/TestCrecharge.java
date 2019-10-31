package com.csdn.mallpages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * 测试C币充值
 * @author miaoyan
 *
 */
public class TestCrecharge {
	private WebDriver driver;
	private String loginPageUrl = "https://passport.csdn.net/account/login?from=http://betamall.csdn.net/cbuy";
	private String userName = "miaoyan1989";
	private String passWord = "miaoyan2011";
	private LoginPage lPage;
	private CrechargePage crePage;
	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
//	通过支付宝方式支付验证
	@Test
	public void testCrechargeAliPayWay(){
		boolean isFindAliPaySourceInfo = true;
			try {
				lPage = new LoginPage(driver, loginPageUrl);
				lPage.login(userName, passWord);
				crePage = new CrechargePage(driver);
				if (!crePage.getNumChargeField().isSelected()) {
					crePage.numReChargeClick();
					driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
					Assert.assertTrue(crePage.getPageSource().contains(crePage.rechargeAmountInfoText));
				}
				crePage.aliPayRechargeWayClick();
				Assert.assertTrue(crePage.getPageSource().contains(crePage.aliPaySourceInfoText));
				isFindAliPaySourceInfo = true;
			} catch (Exception e) {
				e.printStackTrace();
				isFindAliPaySourceInfo = false;
			}finally{
				System.out.println("Crecharge contains 【rechargeAmountInfoText】and 【aliPaySourceInfoText】："+isFindAliPaySourceInfo);
		}
			
	}
	
//	通过微信支付方式验证
	@Test
	public  void testCrechargeWeChatWay(){
		boolean isFindWeChatSourceInfo = true;
			try {
				lPage = new LoginPage(driver, loginPageUrl);
				lPage.login(userName, passWord);
				crePage = new CrechargePage(driver);
				if (!crePage.getNumChargeField().isSelected()) {
					crePage.numReChargeClick();
					driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
					Assert.assertTrue(crePage.getPageSource().contains(crePage.rechargeAmountInfoText));
				}
				crePage.WeChatReChargeWayClick();
				Assert.assertTrue(crePage.getPageSource().contains(crePage.weChatSourceInfoText));
				isFindWeChatSourceInfo = true;
			} catch (Exception e) {
				e.printStackTrace();
				isFindWeChatSourceInfo = false;
			}finally{
				System.out.println("Crecharge contains 【rechargeAmountInfoText】and【weChatSourceInfoText】："+isFindWeChatSourceInfo);
		}
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}

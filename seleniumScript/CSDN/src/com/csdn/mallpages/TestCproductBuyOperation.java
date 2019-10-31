package com.csdn.mallpages;
import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.csdn.mallpages.*;

/**
 * 测试订单提交页面功能
 * @author miaoyan
 *
 */

public class TestCproductBuyOperation {
	private String loginPageUrl = "https://passport.csdn.net/account/login?from=http://betamall.csdn.net/";
	private String homePageUrl = "http://mall.csdn.net/";
	private String sosPageUrlText = "submit_order_success";
	private String sosPageSourceText = "您的订单已经提交成功，请尽快支付！";
	private String sUpageSourceText = "支付成功，请等待系统确认。";
	private WebDriver driver;
	private LoginPage lPage;
	private MallHomePage hpage;
	private CproductDetailPage cpage;
	private OrderSubmitPage OSpage;
	private SubmitOrderSuccessPage SOSpage;
	private SuccessPayPage sUpagePage;
	private String contactName = "缪岩";
	private String contactMobileNum	 = "15101154754";
	private String contactCompanyName = "CSDN";
	private String contactEmail = "550775725@qq.com";
	private String contactProvinceSelectText = "北京";
	private String contactCitySelectText = "朝阳";
	private String contactAddress = "广顺北大街33号院福马大厦B座";
	private String contactPostNum = "100012";
	private String userName = "miaoyan1989";
	private String passWord = "miaoyan2011";

	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
//	验证订单提交页面联系人信息输入及保存，提交订单按钮功能是否正常运行，是否正确返回订单提交成功页面内容【您的订单已经提交成功，请尽快支付！】
	@Test
	public void testOrderSubmitPageFeatures(){
		lPage = new LoginPage(driver, loginPageUrl);
		lPage.login(userName, passWord);
		hpage = new MallHomePage(driver, homePageUrl);
		hpage.goToCproductDetailsImgClick();
		cpage = new CproductDetailPage(driver);
		cpage.buyNowOperation();
		OSpage = new OrderSubmitPage(driver);
		OSpage.orderSubmitInfoOperation(contactName, contactMobileNum, contactCompanyName, contactEmail, contactProvinceSelectText, contactCitySelectText, contactAddress, contactPostNum);
		SOSpage = new SubmitOrderSuccessPage(driver);
		System.out.println("订单提交成功页面链接地址为："+SOSpage.getCunrrentUrl());
		Assert.assertTrue(SOSpage.getCunrrentUrl().contains(sosPageUrlText));
		Assert.assertTrue(SOSpage.getPageSource().contains(sosPageSourceText));
	
	
	}   
//	验证正常购买流程，页面正确跳转到订单提交成功页面，并正确返回【支付成功】页面内容
	@Test
	public void testBuyCproductOperationFeatures(){
		lPage = new LoginPage(driver, loginPageUrl);
		lPage.login(userName, passWord);
		hpage = new MallHomePage(driver, homePageUrl);
		hpage.goToCproductDetailsImgClick();
		cpage = new CproductDetailPage(driver);
		cpage.buyNowOperation();
		OSpage = new OrderSubmitPage(driver);
		OSpage.orderSubmitInfoOperation(contactName, contactMobileNum, contactCompanyName, contactEmail, contactProvinceSelectText, contactCitySelectText, contactAddress, contactPostNum);
		SOSpage = new SubmitOrderSuccessPage(driver);
		SOSpage.confirmPayBtnClick();
		sUpagePage = new SuccessPayPage(driver);
		System.out.println(sUpagePage.getTitle());
		Assert.assertEquals(sUpagePage.SUCCESS_PAY_PAGE_TITLE,sUpagePage.getTitle());
		Assert.assertTrue(sUpagePage.getPageSource().contains(sUpageSourceText));
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}

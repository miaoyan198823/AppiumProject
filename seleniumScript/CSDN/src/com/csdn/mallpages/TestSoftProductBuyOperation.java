package com.csdn.mallpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * 验证通过第三方支付方式支付软件商城商品操作
 * @author miaoyan
 *
 */
public class TestSoftProductBuyOperation {
	private WebDriver driver;
	private String loginPageUrl = "https://passport.csdn.net/account/login?from=http://mall.csdn.net/";
	private String homePageUrl = "http://mall.csdn.net/";
	private String aPageUrl = "alipay.com";
	private String aPageSource = "支付宝";
	private String wPageSource = "微信支付";
	private String userName = "miaoyan1989";
	private String passWord = "miaoyan2011";
	private String contactName = "缪岩";
	private String contactMobileNum	 = "15101154754";
	private String contactCompanyName = "CSDN";
	private String contactEmail = "550775725@qq.com";
	private String contactProvinceSelectText = "北京";
	private String contactCitySelectText = "海淀";
	private String contactAddress = "广顺北大街33号院福马大厦B座";
	private String contactPostNum = "100012";
	private LoginPage lPage;
	private MallHomePage hPage;
	private SoftProductDetailPage spPage;
	private OrderSubmitPage OSpage;
	private SubmitOrderSuccessPage SOSpage;
	private AliPayPage aPage;
	private WeChatPayPage wPage;

	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
	}

//	通过支付宝方式支付商品，验证是否正确返回第三方支付宝页面
	@Test
	public void testAliPayOperation(){
		lPage = new LoginPage(driver, loginPageUrl);
		lPage.login(userName, passWord);
		hPage = new MallHomePage(driver, homePageUrl);
		hPage.goToSoftProductDetailsImgClick();
		spPage = new SoftProductDetailPage(driver);
		spPage.buyNowOperation();
		OSpage = new OrderSubmitPage(driver);
		OSpage.orderSubmitInfoOperation(contactName, contactMobileNum, contactCompanyName, contactEmail, contactProvinceSelectText, contactCitySelectText, contactAddress, contactPostNum);
		SOSpage = new SubmitOrderSuccessPage(driver);
		SOSpage.aliPayImgClick();
		aPage = new AliPayPage(driver);
//		通过页面Title对支付宝页面进行验证
		Assert.assertTrue(aPage.aliPay_TITLE.equals(aPage.getTitle()));
//		验证是否成功进入第三方支付宝页面，并成功返回链接地址包含【alipay.com】地址信息
		System.out.println("AliPay PageURL："+aPage.getCurrentUrl());
		Assert.assertTrue(aPage.getCurrentUrl().contains(aPageUrl));
//		验证如果成功进入第三方支付宝页面，页面内是否包含【支付宝】页面信息
		Assert.assertTrue(aPage.getPageSource().contains(aPageSource));
		
		
		
	}
	
	@Test
	public void testWeChatPayOperation(){
		lPage = new LoginPage(driver, loginPageUrl);
		lPage.login(userName, passWord);
		hPage = new MallHomePage(driver, homePageUrl);
		hPage.goToSoftProductDetailsImgClick();
		spPage = new SoftProductDetailPage(driver);
		spPage.buyNowOperation();
		OSpage = new OrderSubmitPage(driver);
		OSpage.orderSubmitInfoOperation(contactName, contactMobileNum, contactCompanyName, contactEmail, contactProvinceSelectText, contactCitySelectText, contactAddress, contactPostNum);
		SOSpage = new SubmitOrderSuccessPage(driver);
		SOSpage.weChatImgClick();
		wPage = new WeChatPayPage(driver);
		System.out.println("WeChatPayPageUrl:"+wPage.getCurrentUrl());
//		通过页面Title对微信支付页面进行验证
		Assert.assertTrue(wPage.WECHATPAY_TITLE.equals(wPage.getTitle()));
//		验证如果成功进入第三方微信支付页面，页面内是否包含【微信支付】页面信息
		Assert.assertTrue(wPage.getPageSource().contains(wPageSource));
		
		
	} 
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
}

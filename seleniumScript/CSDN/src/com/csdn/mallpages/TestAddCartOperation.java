package com.csdn.mallpages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * 测试加入购物车操作
 * @author miaoyan
 *
 */

public class TestAddCartOperation {
	private WebDriver driver;
	private String loginPageUrl = "https://passport.csdn.net/account/login?from=http://mall.csdn.net/";
	private String homePageUrl = "http://mall.csdn.net/";
	private String userName = "miaoyan1989";
	private String passWord = "miaoyan2011";
	private LoginPage lPage;
	private MallHomePage hPage;
	private CproductDetailPage cpage;
	private SoftProductDetailPage spPage;
	private CartPage caPage;
	private OrderSubmitPage OSpage;
	
	
	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
		
	}
	
//	验证C币商城商品加入购物车操作
	@Test
	public void testAddCartCproductOperation(){
		lPage = new LoginPage(driver, loginPageUrl);
		lPage.login(userName, passWord);
		hPage = new MallHomePage(driver, homePageUrl);
		hPage.goToCproductDetailsImgClick();
		cpage = new CproductDetailPage(driver);
		cpage.addCartOpertion();
		caPage = new CartPage(driver);
//		通过购物车页面链接地址判断是否成功进入购物车页面
		Assert.assertTrue(caPage.caPageUrl.equals(caPage.getCurrentUrl()));
//		通过加入购物车商品名称判断C币商城商品是否成功加入购物车
		Assert.assertTrue(caPage.getPageSource().contains(caPage.caPageCpductSourceText));
		
	}
	
//	验证软件商城商品加入购物车操作
	@Test
	public void testAddCartSoftproductOperation(){
		lPage = new LoginPage(driver, loginPageUrl);
		lPage.login(userName, passWord);
		hPage = new MallHomePage(driver, homePageUrl);
		hPage.goToSoftProductDetailsImgClick();
		spPage = new SoftProductDetailPage(driver);
		spPage.addCartOperataion();
		caPage = new CartPage(driver);
//		通过购物车页面链接地址判断是否成功进入购物车页面
		Assert.assertTrue(caPage.caPageUrl.equals(caPage.getCurrentUrl()));
//		通过加入购物车商品名称判断软件商城商品是否成功加入购物车
		Assert.assertTrue(caPage.getPageSource().contains(caPage.caPageSoftSourceText));
	}
	
	@Test
	public void testPayAccountBtn(){
		lPage = new LoginPage(driver, loginPageUrl);
		lPage.login(userName, passWord);
		hPage = new MallHomePage(driver, homePageUrl);
		hPage.goToSoftProductDetailsImgClick();
		spPage = new SoftProductDetailPage(driver);
		spPage.addCartOperataion();
		caPage = new CartPage(driver);
		caPage.payAccountBtnClick();
		OSpage = new OrderSubmitPage(driver);
//		验证点击购物车页面【去结算】按钮是否成功进入提交订单页面
		Assert.assertTrue(OSpage.OSpageUrl.equals(OSpage.getCurrentUrl()));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}

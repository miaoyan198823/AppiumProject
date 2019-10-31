package com.csdn.mallpages;


import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * 测试商城首页部分功能
 * @author miaoyan
 *
 */
public class TestMallHomePage {
	public static final String CPR_DETAIL_TITLE = "C币商城测试商品-杯子-CSDN C币商城";
	private  final String SUPPIER_PAGE_TITLE = "软件供应商申请-CSDN软件商城";
	private static final String loginPageUrl = "https://passport.csdn.net/account/login?from=http://betamall.csdn.net/";
	private String homePageUrl = "http://betamall.csdn.net/";
	private String sPageUrl = "http://betamall.csdn.net/supplier/apply";
	private String userName = "csto_funds";
	private String passWord = "miaoyan1989";
	private WebDriver driver;
	private LoginPage page;
	private MallHomePage hpage;
	private SuppierApplyPage spage;
	private CproductDetailPage cpage;
	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
	}

//	验证点击首页【申请成为供应商】按钮是否跳转到对应页面
	@Test
	public void testMallHome(){
		page = new LoginPage(driver, loginPageUrl);
		page.login(userName, passWord);
		hpage = new MallHomePage(driver,homePageUrl);
		spage = new SuppierApplyPage(driver);
		hpage.suppierApplyBtnClick();
		Assert.assertEquals(sPageUrl, this.spage.getCurrentUrl());
		Assert.assertEquals(SUPPIER_PAGE_TITLE,this.spage.getTitle()); 
		}
//	验证点击商城首页C币商城某商品，是否正确进入该商品详情页
	@Test
	public void testMallHomeCbProImgLinkClick(){
		page = new LoginPage(driver, loginPageUrl);
		page.login(userName, passWord);
		hpage = new MallHomePage(driver,homePageUrl);
		hpage.goToCproductDetailsImgClick();
		cpage = new CproductDetailPage(driver);
		Assert.assertTrue(cpage.CPR_DETAIL_TITLE.equals(cpage.getTitle()));
	}  
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}

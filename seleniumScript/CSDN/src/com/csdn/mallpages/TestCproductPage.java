package com.csdn.mallpages;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.csdn.mallpages.*;
/**
 * 测试C币商品详情页面功能
 * @author miaoyan
 *
 */

public class TestCproductPage {
	private String loginPageUrl = "https://passport.csdn.net/account/login?from=http://mall.csdn.net/";
	private String homePageUrl = "http://mall.csdn.net/";
	private String userName = "miaoyan1989";
	private String passWord = "miaoyan2011";
	private WebDriver driver;
	private LoginPage lPage;
	private MallHomePage hpage;
	private CproductDetailPage cpage;
	private OrderSubmitPage OSpage;
	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
	}
//	验证进入C币详情页面，点击【立即购买】按钮是否准确到提交订单页面，并通过订单提交页面Title来判断
	@Test
	public void cProductDetailBuyNowBtn(){
		lPage = new LoginPage(driver, loginPageUrl);
		lPage.login(userName, passWord);
		hpage = new MallHomePage(driver, homePageUrl);
		hpage.goToCproductDetailsImgClick();
		cpage = new CproductDetailPage(driver);
		cpage.buyNowOperation();
		OSpage = new OrderSubmitPage(driver);
		System.out.println(OSpage.getTitle());
		Assert.assertTrue(OSpage.ORDER_SUB_PAGE_TITLE.equals(OSpage.getTitle()));
		
		
	}

}

package com.csdn.edu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.csdn.mallpages.*;

/**
 * 测试通过加入购物车进行课程购买
 * @author miaoyan
 *
 */
public class TestBuyCourseOperation {
	private WebDriver driver;
	private String loginPageUrl = "https://passport.csdn.net/account/login?from=http://betaedu.csdn.net/courses";
	private String userName = "miaoyan1989";
	private String passWord = "miaoyan2011";
	private String sosPageSourceText = "您的订单已经提交成功，请尽快支付！";
	private LoginPage lPage;
	private CourseListPage clPage;
	private CourseDetailPage cdPage;
	private CartPage caPage;
	private OrderSubmitPage OSpage;
	private SubmitOrderSuccessPage SOSpage;
	
	
	
	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	/**
	 * 验证订单是否正确成功提交
	 */
	@Test
	public void buyCourseOperation(){
		lPage = new LoginPage(driver, loginPageUrl);
		lPage.login(userName, passWord);
		clPage = new CourseListPage(driver);
		clPage.CourseImgLinkClick();
		cdPage = new CourseDetailPage(driver);
		cdPage.addCartOperation();
		caPage = new CartPage(driver);
		caPage.payAccountBtnClick();
		OSpage = new OrderSubmitPage(driver);
		OSpage.submitOrderFormBtn();
		Assert.assertTrue(SOSpage.getPageSource().contains(sosPageSourceText));
		
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
	
}

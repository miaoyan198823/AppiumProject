package com.csdn.mallpages;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;


/**
 * 测试我的订单页面检索功能
 * @author miaoyan
 *
 */
public class TestMyOrder {
	private WebDriver driver;
	private String loginPageUrl = "https://passport.csdn.net/account/login?from=http://betaorder.csdn.net/myorder";
	private String userName = "miaoyan1989";
	private String passWord = "miaoyan2011";
	private String orderTypeText = "学院";
	private String orderStatusText = "未支付";
	private LoginPage lPage;
	private MyOrderPage mPage;
	
	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
//	通过订单类型来验证订单信息
	@Test
	public void testOrderTypeSelectInfo(){
		lPage = new LoginPage(driver, loginPageUrl);
		lPage.login(userName, passWord);
		mPage = new MyOrderPage(driver);
		boolean isFindPageSource = true;
		try {
			mPage.orderTypeSelect(orderTypeText);
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			isFindPageSource = true;
		} catch (Exception e) {
			e.printStackTrace();
			isFindPageSource = false;
		}finally{
			System.out.println("MyOrder type source contains 【orderTypeText】:"+isFindPageSource);
		}
		
		
	}
	
//	通过订单状态来验证订单信息
	@Test
	public void testOrderStatusSelectInfo(){
		lPage = new LoginPage(driver, loginPageUrl);
		lPage.login(userName, passWord);
		mPage = new MyOrderPage(driver);
		boolean isFindOrderStatusSource = true;
		try {
			mPage.orderStatusSelect(orderStatusText);
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			Assert.assertTrue(mPage.getPageSource().contains(orderStatusText));
			isFindOrderStatusSource=true;
		} catch (Exception e) {
			e.printStackTrace();
			isFindOrderStatusSource = false;
		}finally{
			System.out.println("MyOrder status source contains 【orderStatusText】:"+isFindOrderStatusSource);
		}
		
	}
	
//	通过选择订单类型和订单状态两个检索条件来验证订单信息
	@Test
	public void testOrderRetrievalOperation(){
		lPage = new LoginPage(driver, loginPageUrl);
		lPage.login(userName, passWord);
		mPage = new MyOrderPage(driver);
		boolean isMyOrderRetrievalInfo = true;
		try {
			mPage.orderTypeSelect(orderTypeText);
			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			mPage.orderStatusSelect(orderStatusText);
			driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			Assert.assertTrue(mPage.getPageSource().contains(orderTypeText));
			Assert.assertTrue(mPage.getPageSource().contains(orderStatusText));
			isMyOrderRetrievalInfo = true;
		} catch (Exception e) {
			e.printStackTrace();
			isMyOrderRetrievalInfo = false;
		}finally{
			System.out.println("MyOrder retrieval info contains【orderTypeText】and【orderStatusText】:"+isMyOrderRetrievalInfo);
		}
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	
	

}

package com.csdn.mallpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.csdn.mallpages.*;

/**
 * 测试软件报价单申请操作
 * @author miaoyan
 *
 */

public class TestQuoteApply {
	private WebDriver driver;
	private String loginPageUrl = "https://passport.csdn.net/account/login?from=http://betamall.csdn.net/quota/apply";
	private String userName = "miaoyan1989";
	private String passWord = "miaoyan2011";
	private String supplierId = "ZOHO";
	private String companyName = "CSDN测试";
	private String contactName = "缪岩测试";
	private String telNum = "010-64132155";
	private String mobileNum = "15010719147";
	private String email = "550775725@qq.com";
	private LoginPage lPage;
	private QuoteApplySoftPage qaPage;
	private QuoteApplySoftSuccessPage qasPage;
	
	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@Test
	public void testQuoteApplyOperation(){
			lPage = new LoginPage(driver, loginPageUrl);
			lPage.login(userName, passWord);
			qaPage = new QuoteApplySoftPage(driver);
			qaPage.quoteApplySoftOperation(supplierId, companyName, contactName, telNum, mobileNum, email);
			qasPage = new QuoteApplySoftSuccessPage(driver);
			
		
		
	}
	

	
}

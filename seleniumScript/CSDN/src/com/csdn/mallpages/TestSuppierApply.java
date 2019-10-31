package com.csdn.mallpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.csdn.mallpages.*;
/**
 * 测试申请供应商部分功能case
 * @author miaoyan
 *
 */
public class TestSuppierApply {
	public static final String PageSourceInfo = "申请成功";
	public String SCpageUrl="http://betamall.csdn.net/";
	public static final String loginPageUrl = "https://passport.csdn.net/account/login?from=http://betamall.csdn.net/supplier/apply";
	private WebDriver driver;
	private LoginPage lPage;
	private SuppierApplySuccessPage scPage;
	private SuppierApplyPage spage;
	private String userName = "csto_funds";
	private String passWord = "miaoyan1989";
	private String companyName = "selenium科技22";
	private String companySite = "http://selenium.cn";
	private String companyDesc = "公司主要致力于软件测试开发课程培训及产品研发";
	private String softWareName = "selenium WebDriver";
	private String softWareDesc = "是一款基于页面元素的自动化测试框架，支持多种开发语言";
	private String softWarePrice = "100";
	private String contactName = "缪岩";
	private String companyTelNum = "010-64132155";
	private String contactMobileNum = "15010719147";
	private String contactEmail = "miaoyan@csdn.net";
	
	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
	}
//	验证申请供应商操作是否成功
	@Test
	public void testSuppierApply(){
		lPage = new LoginPage(driver, loginPageUrl);
		lPage.login(userName, passWord);
		spage = new SuppierApplyPage(driver);
		scPage = new SuppierApplySuccessPage(driver,SCpageUrl);
		spage.suppierApplySuccessOperation(companyName, companySite, companyDesc, softWareName, softWareDesc, softWarePrice, contactName, companyTelNum, contactMobileNum, contactEmail);
//		验证信息提交成功之后，提交成功页面是否出现【申请成功】字样
		Assert.assertTrue(scPage.getPageSource().contains(PageSourceInfo));
		
		
		
		
	}
	
}

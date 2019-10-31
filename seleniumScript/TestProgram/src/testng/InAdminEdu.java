package testng;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.IReporter;
import org.testng.ITestListener;


public class InAdminEdu {
	WebDriver driver;
	@BeforeMethod
	public void startUp(){
		driver = new FirefoxDriver();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		System.setProperty("Webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		
	}
	@Test()
	public void InAdminEdu_TestVerify_Add_Class() throws Exception{
		driver.get("http://passport.csdn.net/account/login?from=http://betaadminbss.csdn.net/");
		WebElement text_user_name= driver.findElement(By.id("username"));
		text_user_name.clear();
		text_user_name.sendKeys("cpongo1");
		String str_value= text_user_name.getAttribute("value");
		Assert.assertEquals(str_value, "cpongo1");
		WebElement text_password_name= driver.findElement(By.id("password"));
		text_password_name.clear();
		text_password_name.sendKeys("k123456");
		Thread.sleep(3000);
		WebElement btn_Login = driver.findElement(By.xpath("//*[@id='fm1']/input[6]"));
		btn_Login.click();
//      验证页面是否成功进入在线培训后台
		String expectedUrl = "http://betaadminbss.csdn.net/";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl,expectedUrl);
//      验证是否成功进入后台并且可以看到站点首页字样		
		WebElement homepage_text= driver.findElement(By.id("site_homepage"));
		String str_homepage_text= homepage_text.getText();
		Assert.assertEquals(str_homepage_text, "站点首页");
		WebElement linkText= driver.findElement(By.linkText("讲师管理"));
		linkText.click();
		WebElement frameRight= driver.findElement(By.id("rightMain"));
	    driver.switchTo().frame(frameRight);
		driver.findElement(By.xpath("html/body/div[3]/div[2]/a[2]/em")).click();
		Thread.sleep(3000);
//      验证后台讲师列表页是否出现“王岩”讲师申请资料
		WebElement Create_name= driver.findElement(By.xpath("html/body/div[4]/table/tbody/tr[2]/td[3]/a"));
		String str_Create_nameText=Create_name.getText();
		Assert.assertEquals(str_Create_nameText, "王岩");
		
		
		
		
	}

}

package testng;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.IReporter;
import org.testng.ITestListener;
import org.testng.Assert;

import com.opera.core.systems.OperaLogs.DriverLogsHandler;
public class TestEduAddAgency {
	WebDriver driver;
	@BeforeMethod
	public void startUp(){
		driver= new FirefoxDriver();
		System.setProperty("Webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	}
	@Test
	public void TestEdu_addAgency() throws Exception{
		driver.get("http://passport.csdn.net/account/login?from=http://betaeduol.csdn.net/course");
		Thread.sleep(2000);
		WebElement text_username= driver.findElement(By.id("username"));
		text_username.clear();
		text_username.sendKeys("csto_funds");
		String str_text_username= text_username.getAttribute("value");
		Assert.assertEquals(str_text_username,"csto_funds");
		WebElement text_password= driver.findElement(By.id("password"));
		text_password.clear();
		text_password.sendKeys("miaoyan1989");
		String str_text_password= text_password.getAttribute("value");
		Assert.assertEquals(str_text_password,"miaoyan1989");
		WebElement submit= driver.findElement(By.className("logging"));
		submit.click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("首页")).click();
		Thread.sleep(1000);
		WebElement succeed_username= driver.findElement(By.className("name"));
		String str_succed_username= succeed_username.getText();
		Assert.assertTrue(str_succed_username.contains("大叔范_123"));
		driver.findElement(By.linkText("讲师/机构申请")).click();
		WebElement linkText= driver.findElement(By.linkText("合作机构申请"));
		linkText.click();
		String current_Url= driver.getCurrentUrl();
		Assert.assertEquals(current_Url,"http://betaeduol.csdn.net/agency/apply");
		WebElement text_agency_name= driver.findElement(By.id("agency_name"));
		text_agency_name.clear();
		text_agency_name.sendKeys("三叶草教育机构");
		WebElement text_agency_site= driver.findElement(By.id("agency_site"));
		text_agency_site.clear();
		text_agency_site.sendKeys("http://www.wanda.edu");
		WebElement text_agency_skill= driver.findElement(By.id("agency_skill"));
		text_agency_skill.clear();
		text_agency_skill.sendKeys("java");
		WebElement text_agency_intro= driver.findElement(By.id("agency_intro"));
		text_agency_intro.clear();
		text_agency_intro.sendKeys("具有线上/线下培训经验");
		WebElement text_agency_weibo= driver.findElement(By.id("agency_weibo"));
		text_agency_weibo.clear();
		text_agency_weibo.sendKeys("http://www.baidu.com");
		driver.findElement(By.id("uploadlogo")).click();
		WebElement imfile= driver.findElement(By.name("imgFile"));
		imfile.sendKeys("E:\\123.png");
		driver.findElement(By.xpath("//input[@type='button'][@value='确定']")).click();
		Thread.sleep(20000);
		WebElement text_agency_email= driver.findElement(By.id("agency_email"));
		text_agency_email.clear();
		text_agency_email.sendKeys("550775725@qq.com");
		WebElement text_agency_tel= driver.findElement(By.id("agency_tel"));
		text_agency_tel.clear();
		text_agency_tel.sendKeys("15010719147");
		WebElement text_agency_qq= driver.findElement(By.name("agency_qq"));
		text_agency_qq.clear();
		text_agency_qq.sendKeys("550775725");
		WebElement sub_btn= driver.findElement(By.id("sub_btn"));
		sub_btn.click();
		Thread.sleep(3000);
		
		
		
	}

}

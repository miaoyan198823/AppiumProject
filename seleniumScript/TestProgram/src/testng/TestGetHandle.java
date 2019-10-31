package testng;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.IReporter;
import org.testng.ITestListener;

import com.opera.core.systems.scope.protos.WmProtos.WindowID;


public class TestGetHandle {
	WebDriver driver;
	@BeforeMethod
	public void startUp(){
		driver= new FirefoxDriver();
		System.setProperty("Webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	}
	@Test
	public void TestGetHandle_Windows() throws Exception{
		driver.get("http://passport.csdn.net/account/login?from=http://betaeduol.csdn.net/course");
		Thread.sleep(2000);
		WebElement text_username= driver.findElement(By.id("username"));
		text_username.clear();
		text_username.sendKeys("miaoyan1989");
		String str_text_username= text_username.getAttribute("value");
		Assert.assertEquals(str_text_username,"miaoyan1989");
		WebElement text_password= driver.findElement(By.id("password"));
		text_password.clear();
		text_password.sendKeys("miaoyan2011");
		String str_text_password= text_password.getAttribute("value");
		Assert.assertEquals(str_text_password,"miaoyan2011");
		WebElement submit= driver.findElement(By.className("logging"));
		submit.click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Ê×Ò³")).click();
		Thread.sleep(1000);
		WebElement succeed_username= driver.findElement(By.className("name"));
		String str_succed_username= succeed_username.getText();
		Assert.assertTrue(str_succed_username.contains("miaoyan1989"));
		String parentwinHandle= driver.getWindowHandle();
		System.out.println(parentwinHandle);
		driver.findElement(By.xpath("html/body/div[3]/div[1]/div[2]/div[1]/div[1]/div/div/a/button")).click();
		Thread.sleep(1000);
		String[] handles= new String[(driver.getWindowHandles().size())];
		driver.getWindowHandles().toArray(handles);
		WebDriver childwindowDriver= driver.switchTo().window(handles[1]);
		driver.switchTo().window(handles[0]);
		

	}
}

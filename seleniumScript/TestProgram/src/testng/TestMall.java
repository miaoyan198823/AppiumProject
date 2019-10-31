package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestMall {
	WebDriver driver;
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
	}
	@Test
	public void testmall(){
		driver.get("https://passport.csdn.net/account/login?from=http://betaorder.csdn.net/myorder");
		driver.findElement(By.id("username")).sendKeys("miaoyan1989");
		driver.findElement(By.id("password")).sendKeys("miaoyan2011");
		driver.findElement(By.className("logging")).click();
		String title = driver.getTitle();
		System.out.println(title);
	}
}

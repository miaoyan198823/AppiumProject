package testng;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.IReporter;
import org.testng.ITestListener;

import com.opera.core.systems.OperaLogs.DriverLogsHandler;
import com.sun.jna.FromNativeContext;

public class Test_combo {
	WebDriver driver;
	 private String username = "miaoyan1989";
	 private String password = "miaoyan2011";
	 String baseUrl="https://passport.csdn.net/account/login?from=http://testedu.csdn.net/";
	@BeforeMethod
	public void startUp(){
		driver= new FirefoxDriver();
		System.setProperty("Webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		
	}
	@Test
	public void combo_apply() throws Exception{
		driver.get(baseUrl);
		
		WebElement user_name= driver.findElement(By.id("username"));
		user_name.clear();
		user_name.sendKeys(username);
		String str_user_name= user_name.getAttribute("value");
		Assert.assertEquals(str_user_name,username);
		WebElement pass_word= driver.findElement(By.id("password"));  
		pass_word.clear();
		pass_word.sendKeys(password);
		String str_pass_word= pass_word.getAttribute("value");
		Assert.assertEquals(str_pass_word,password);
		WebElement remember_check= driver.findElement(By.id("rememberMe"));
		if(!remember_check.isSelected()){
			remember_check.click();
		}
		Assert.assertTrue(remember_check.isSelected());
		WebElement btn= driver.findElement(By.className("logging"));
		btn.click();
		Thread.sleep(1000);
		WebElement mouse_moveElement= driver.findElement(By.xpath("html/body/div[1]/div/div[2]/ul/li[6]/div/img"));
		Actions actions= new Actions(driver);
		actions.moveToElement(mouse_moveElement).build().perform();
		Assert.assertTrue(mouse_moveElement.isDisplayed());
		WebElement myclass_link = driver.findElement(By.xpath("html/body/div[2]/div/div/ul/li[5]"));
		myclass_link.click();
		driver.findElement(By.linkText("我的学院")).click();
		driver.findElement(By.className("newCourseBtn")).click();
		WebElement combo_name= driver.findElement(By.xpath("//input[@name='combo_name'][@type='text']"));
		combo_name.clear();
		combo_name.sendKeys("缪岩套餐123");
		String str_combo_name=combo_name.getAttribute("value");
		Assert.assertEquals(str_combo_name,"缪岩套餐123");  
		WebElement upload_button=driver.findElement(By.id("uploadButton2"));
		upload_button.click();
		WebElement imfile_name =driver.findElement(By.name("imgFile"));
		imfile_name.sendKeys("E:\\111.png");
		driver.findElement(By.xpath("//input[@value='确定'][@type='button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("description")).clear();
		driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div/form/ul/li[4]/textarea")).sendKeys("很好的套餐，希望大家踊跃购买！");
		new Select(driver.findElement(By.id("combo_cat1"))).selectByVisibleText("数据库");
		Select combo_cat1 = new Select(driver.findElement(By.id("combo_cat1")));
		Assert.assertFalse(combo_cat1.isMultiple());
		Thread.sleep(2000);
		new Select(driver.findElement(By.id("combo_cat2"))).selectByVisibleText("BI");
		Select combo_cat2 =new Select(driver.findElement(By.id("combo_cat2")));
		Assert.assertFalse(combo_cat2.isMultiple());
		driver.findElement(By.name("tag")).clear();
		driver.findElement(By.name("tag")).sendKeys("java");
		
		
		
			}
		
	
}

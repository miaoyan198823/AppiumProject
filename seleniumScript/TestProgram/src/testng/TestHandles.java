package testng;

import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;

import org.apache.commons.collections.map.StaticBucketMap;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.IReporter;

public class TestHandles {
	WebDriver driver = new FirefoxDriver();
	private String userName;
	private String passWord;
	private String url;
	
	public void goToEduLogin(){
		this.url = "https://passport.csdn.net/account/login?from=http://testedu.csdn.net/";
		this.userName = "miaoyan1989";
		this.passWord = "miaoyan2011";
		driver.get(url);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(userName);
		String str_username_text = driver.findElement(By.id("username")).getAttribute("value");
		Assert.assertEquals(str_username_text,userName);
		if(driver.findElement(By.id("password")).isEnabled()){
			System.out.println("password_text is Enabled");
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys(passWord);
			
		}else{
			System.out.println("password_text is not Enabled");
		}
		driver.findElement(By.id("rememberMe"));
		if(!driver.findElement(By.id("rememberMe")).isSelected()){
			 driver.findElement(By.id("rememberMe")).click();
			 
		 }
		 Assert.assertTrue(driver.findElement(By.id("rememberMe")).isSelected());
		 driver.findElement(By.className("logging")).click();
		
	}
	@BeforeTest
	public void startUp(){
		 driver = new FirefoxDriver();
		 System.setProperty("Webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	}
	
	public void mouse_moveInfo(){
		WebElement mouse_moveElement= driver.findElement(By.xpath("html/body/div[1]/div/div[2]/ul/li[6]/div/img"));
		Actions actions = new Actions(driver);
		actions.moveToElement(mouse_moveElement).build().perform();
		Assert.assertTrue(mouse_moveElement.isDisplayed());
	}
	
	public void testMultpleWindowHanles(){
		String parentWindowid = driver.getWindowHandle();
		Assert.assertEquals("window open() Method", driver.getTitle());
		
		
		
	}
	
	@Test
	public void type_Handles(){
		
		
	}
}
	
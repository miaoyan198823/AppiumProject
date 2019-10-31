package testng;

import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;

import org.testng.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Teacher {
	WebDriver driver = new FirefoxDriver();
	private String username;
	private String password;
	private String url;
	
	/**
	 * 构造方法
	 * @author miaoyan
	 */
	public Teacher(){
		this.url = "https://passport.csdn.net/account/login?from=http://testedu.csdn.net/";
		this.username = "miaoyan1989";
		this.password = "miaoyan2011";
		driver.get(url);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);
		String str_username_text = driver.findElement(By.id("username")).getAttribute("value");
		Assert.assertEquals(str_username_text,username);
		
		if (driver.findElement(By.id("password")).isEnabled()) {
			System.out.println("password text is enabled!");
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.className("logging")).click();
		}else{
			System.out.println("password text is not enabled!");
		}
	}
	/**
	 * 封装方法 set方法和get方法
	 */
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
		driver.get(url);
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(username);
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
		
		
	}  
	@Test
	public void LoingInfo(){
		/**
		 * 构造方法调用
		 */
		Teacher teacher = new Teacher();    
		
		/**
		 * 封装方法调用
		 */
		teacher.setUrl("https://passport.csdn.net/account/login?from=http://testedu.csdn.net/");
		teacher.setUsername("miaoyan1989");
		teacher.setPassword("miaoyan2011");
		driver.findElement(By.className("logging")).click();
		driver.manage().window().maximize();
		driver.findElement(By.className("logging")).click();
	}
	
	
}

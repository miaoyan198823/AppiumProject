package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestDiv {
	private WebDriver driver;
	private String url = "https://passport.csdn.net/account/login?from=http://edu.csdn.net/courses";
	private String userName = "miaoyan1989";
	private String passWord = "miaoyan2011";
	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
	}
	
	@Test
	public void testDiv(String url,String userName,String passWord){
		driver.get(url);
		
	}
}

package testng;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.IReporter;
import org.testng.ITestListener;
import org.testng.AssertJUnit;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

public class TestEduAddCourseClass{
	WebDriver driver;
	@BeforeMethod
	public void startUp(){
		driver = new FirefoxDriver();
		System.setProperty("Webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		
	}
	
	@Test
	public void add_course_class() throws Exception{
		
		driver.get("http://passport.csdn.net/account/login?from=http://betaeduol.csdn.net/lecturer/board/11124");
		WebElement text_user_name= driver.findElement(By.id("username"));
		text_user_name.clear();
		text_user_name.sendKeys("miaoyan1989");
		String str_value= text_user_name.getAttribute("value");
		Assert.assertEquals(str_value,"miaoyan1989");
		WebElement text_password_name= driver.findElement(By.id("password"));
		text_password_name.clear();
		text_password_name.sendKeys("miaoyan2011");
		String prt_value= text_password_name.getAttribute("value");
		Assert.assertEquals(prt_value,"miaoyan2011");
		driver.findElement(By.xpath("//*[@id='fm1']/input[6]")).click();
		Thread.sleep(2000);
		String edu_show_URL= driver.getCurrentUrl();
		Assert.assertEquals(edu_show_URL,"http://betaeduol.csdn.net/lecturer/board/11124");
		WebElement btn_add_class = driver.findElement(By.xpath("html/body/div[3]/div[2]/div[2]/div[1]/a[2]"));
		btn_add_class.click();
		WebElement add_class = driver.findElement(By.name("new_lesson"));
		add_class.sendKeys("课程10");
		String new_lesson_value =add_class.getAttribute("value");
		Assert.assertEquals(new_lesson_value, "课程10");
		driver.findElement(By.xpath("//*[@id='popup_reward']/form/div[2]/input[2]")).click();
		Thread.sleep(7000);
//      验证课时10是否创建成功，并正确显示在11124课程课时管理页面
		WebElement span_text= driver.findElement(By.xpath("html/body/div[3]/div[2]/div[2]/div[2]/table/tbody/tr[10]/t/[1]"));
		String str_span_text = span_text.getText();
		System.out.println(str_span_text);
		Assert.assertEquals(str_span_text,"10课程10[5095]");
	
		
		
		
		
		
		
		
		
//		System.out.println("================"+driver.navigate().to());
		//driver.findElement(By.className("operate").className("clearfix").tagName("li").tagName("a").linkText("课时管理")).click();
		

		
		
	
		
		
		

		
		

		
		
		
		
		
		
	}
	

}

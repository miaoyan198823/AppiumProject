package testng;
import javax.xml.xpath.XPath;

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

import com.gargoylesoftware.htmlunit.javascript.host.Element;

public class TestCSTO {
	WebDriver driver;
	@BeforeMethod
	public void startUp(){
		driver= new FirefoxDriver();
		System.setProperty("Webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	}
	@Test
	public void Create_Project() throws Exception{
		driver.get("https://www.csto.com/login");
		WebElement user_name= driver.findElement(By.id("u"));
		user_name.clear();
		user_name.sendKeys("miaoyan1989");
		String str_user_name= user_name.getAttribute("value");
		Assert.assertEquals(str_user_name, "miaoyan1989");
		WebElement user_passwd= driver.findElement(By.id("p"));
		user_passwd.clear();
		user_passwd.sendKeys("miaoyan2011");
		String str_user_passwd= user_passwd.getAttribute("value");
		Assert.assertEquals(str_user_passwd,"miaoyan2011");
		WebElement remember_me= driver.findElement(By.id("r"));
		if(!remember_me.isSelected()){
			remember_me.click();
		}
		Assert.assertTrue(remember_me.isSelected());
		WebElement btn_logging= driver.findElement(By.xpath("//input[@type='button'][@value='登录']"));
		btn_logging.click();
		Thread.sleep(2000);
		String expectedUrl="http://www.csto.com/";
		String actualUrl= driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		WebElement mouse_moveElement= driver.findElement(By.xpath("//*[@id='HomePage']/div[1]/div/div/div[4]/a"));
		Actions actions= new Actions(driver);
		actions.moveToElement(mouse_moveElement).build().perform();
		Assert.assertTrue(mouse_moveElement.isDisplayed());
		WebElement btn_release_Project=driver.findElement(By.className("publish_free"));
		btn_release_Project.click();
		WebElement project_title= driver.findElement(By.id("input_prjnew_title"));
		project_title.clear();
		project_title.sendKeys("外包公司OA系统开发");
		String str_project_title= project_title.getAttribute("value");
		Assert.assertEquals(str_project_title,"外包公司OA系统开发");
		WebElement tag1=driver.findElement(By.id("tag1"));
		tag1.click();
		WebElement proj_type= driver.findElement(By.id("tag_ck_21"));
		if(!proj_type.isSelected()){
			proj_type.click();
		}
		Assert.assertTrue(proj_type.isSelected());
		WebElement input_btn= driver.findElement(By.xpath("//*[@id='tag1_div']/div[3]/input"));
		input_btn.click();
		WebElement proj_text= driver.findElement(By.id("input_prjnew_text"));
		proj_text.clear();
		proj_text.sendKeys("使用ab命令加上“-c”与“-t”附加“-k”参数模拟5个用户同时访问百度总共9秒,百度会打开5个并发连接，从而减少web服务器创建新链接所花费的时间。");
		WebElement upload= driver.findElement(By.id("but_att_upload"));
		upload.click();
		WebElement file_img= driver.findElement(By.name("attachment1"));
		file_img.sendKeys("E:\\123.png");
		Thread.sleep(500);
		WebElement tagNew= driver.findElement(By.xpath("//*[@id='prj_new']/table/tbody/tr[5]/td/div/div[1]/span"));
		if(!tagNew.isDisplayed()){
			System.out.println("Element is not displayed!");
			}
		tagNew.click();
		WebElement tagname= driver.findElement(By.xpath("//*[@id='111']"));
		if(!tagname.isDisplayed()){
			System.out.println("Element is not displayed!");
			}
		tagname.click();
		Thread.sleep(200);
		driver.findElement(By.xpath("//*[@id='prj_new']/table/tbody/tr[5]/td/div/div[2]/h4/i")).click();
		Select money_start= new Select(driver.findElement(By.id("money_start")));
		Assert.assertFalse(money_start.isMultiple());
		new Select(driver.findElement(By.id("money_start"))).selectByVisibleText("￥5,000-￥10,000");
		Thread.sleep(500);
		WebElement mobile_status= driver.findElement(By.id("mobile_status"));
		if(!mobile_status.isSelected()){
			mobile_status.click();
		}
		Assert.assertTrue(mobile_status.isSelected());
		WebElement mobile_text= driver.findElement(By.id("mobile"));
		mobile_text.sendKeys("15014752145");
		WebElement QQ_text= driver.findElement(By.id("con_qq"));
		if(!QQ_text.isSelected()){
			QQ_text.click();
		}
		Assert.assertTrue(QQ_text.isSelected());
		QQ_text.sendKeys("2300923585");
	
	}
}

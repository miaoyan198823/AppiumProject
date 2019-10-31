package testng;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.IReporter;
import org.testng.ITestListener;

public class InAdminEdu_Succeed {
	WebDriver driver;
	@BeforeMethod
	public void startUp(){
		driver= new FirefoxDriver();
		System.setProperty("Webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	}
	@Test
	public void InAdminEdu_verifyCourseSucceed() throws Exception{
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
//      ��֤ҳ���Ƿ�ɹ�����������ѵ��̨
		String expectedUrl = "http://betaadminbss.csdn.net/";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl,expectedUrl);

//      ��֤�Ƿ�ɹ������̨���ҿ��Կ���վ����ҳ����		
		WebElement homepage_text= driver.findElement(By.id("site_homepage"));
		String str_homepage_text= homepage_text.getText();
		Assert.assertEquals(str_homepage_text, "վ����ҳ");
		WebElement linkText= driver.findElement(By.linkText("�γ̹���"));
		linkText.click();
		WebElement frameRight= driver.findElement(By.id("rightMain"));
		driver.switchTo().frame(frameRight);
		driver.findElement(By.xpath("html/body/div[3]/div[2]/a[2]/em")).click();
		Thread.sleep(2000);
//      ��֤������б��Ƿ���֡�selenium_java_Texant���γ�
		WebElement course_name= driver.findElement(By.xpath("//td[.='selenium_javaApi']"));
		String str_course_name= course_name.getText();
		Assert.assertEquals(str_course_name,"selenium_javaApi");
//      ���ͨ������
		driver.findElement(By.xpath("html/body/div[4]/table/tbody/tr/td[10]/a[3]")).click();    //�˴�Ԫ�ض�λ��Ҫ����ʵ����˿γ�ȥ��λ�γ�Ԫ��
		WebElement frame_Opencheck=driver.findElement(By.name("Opencheck"));
		driver.switchTo().frame(frame_Opencheck);
		WebElement check_course_attr= driver.findElement(By.xpath("//input[@name='course_attr'][@value='2']"));
		if(!check_course_attr.isSelected()){
			check_course_attr.click();
		}
		Assert.assertTrue(check_course_attr.isSelected());
		WebElement admin_remark= driver.findElement(By.name("admin_remark"));
		admin_remark.clear();
		admin_remark.sendKeys("ͬ��ͨ��");
		WebElement checked= driver.findElement(By.xpath("//input[@name='to_status'][@value='1']"));
		if(!checked.isSelected()){
			checked.click();
		}
		Assert.assertTrue(checked.isSelected());
		WebElement course_price= driver.findElement(By.id("course_final_price"));
		course_price.clear();
		course_price.sendKeys("3");
		WebElement course_showprice= driver.findElement(By.id("course_showprice"));
		course_showprice.clear();
		course_showprice.sendKeys("2");
		WebElement submit= driver.findElement(By.xpath("//input[@type='submit'][@value='�ύ']"));
		submit.click();
		Thread.sleep(1000);
		
	}

}

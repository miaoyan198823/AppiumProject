package testng;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.ITestListener;
import org.testng.IReporter;
import org.testng.Assert;

public class InAdminEdu_Fail {
	WebDriver driver;
	@BeforeMethod
	public void startUp(){
		driver= new FirefoxDriver();
		System.setProperty("Webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	}
	@Test
	public void InAdminEdu_verifyCourseFail() throws Exception{
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
/*      ��˲�ͨ��������֤	
		WebElement frameRight= driver.findElement(By.id("rightMain"));	
		driver.switchTo().frame(frameRight);
		WebElement link_a= driver.findElement(By.xpath("html/body/div[4]/table/tbody/tr[2]/td[10]/a[3]"));//��λ��ͨ����˵Ŀγ̡��鿴����ťԪ��
		link_a.click();
		WebElement frame_Opencheck=driver.findElement(By.name("Opencheck"));
		driver.switchTo().frame(frame_Opencheck);
		WebElement checkbox= driver.findElement(By.xpath("//input[@name='to_status'][@value='2']"));
		if(!checkbox.isSelected()){
			checkbox.click();
		}
		Assert.assertTrue(checkbox.isSelected());
//      ������ύ����ť����֤�Ƿ����Alert���������ڵ�������ʾ�����ʧ�ܺ󣬲��ɻָ�ȷ�����ʧ���𣿡�		
		WebElement btn_submit= driver.findElement(By.xpath("//input[@type='submit'][@value='�ύ']"));
		btn_submit.click();
		Alert alert= driver.switchTo().alert();
		String str_alert= alert.getText();
		System.out.print(str_alert);
		Assert.assertTrue(str_alert.contains("���ʧ��"));
		alert.accept();
		Thread.sleep(3000);                               */
//      ��֤����ʦ-ѧ�����γ��Ƿ�����ڿγ���˲�ͨ���б�
		WebElement frameRight= driver.findElement(By.id("rightMain"));
		driver.switchTo().frame(frameRight);
		WebElement btn_fail= driver.findElement(By.xpath("html/body/div[3]/div[2]/a[4]/em"));
		btn_fail.click(); //��˲�ͨ����ť
		WebElement failCourse_name= driver.findElement(By.xpath("//td[.='��ʦ-ѧ��']"));
		String str_failCourse_name= failCourse_name.getText();
		Assert.assertEquals(str_failCourse_name,"��ʦ-ѧ��");
		
	}

}

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

import com.thoughtworks.selenium.webdriven.commands.Check;

public class InAdminEdu_Agency {
	WebDriver driver;
	@BeforeMethod
	public void startUp(){
		driver= new FirefoxDriver();
		System.setProperty("Webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
	}
	@Test
	public void InAdminEdu_verifyAddAgency() throws Exception{
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
		Thread.sleep(2000);
		driver.findElement(By.linkText("��������")).click();
/*		WebElement frameRight= driver.findElement(By.id("rightMain"));
		driver.switchTo().frame(frameRight);
		driver.findElement(By.xpath("html/body/div[3]/div[2]/a[1]/em")).click();
		Thread.sleep(1000);
		WebElement agency_name= driver.findElement(By.xpath("//td[.='��Ҷ�ݽ�������']"));
		String str_agency_name= agency_name.getText();
		Assert.assertEquals(str_agency_name,"��Ҷ�ݽ�������");
//      ���ͨ������
		driver.findElement(By.xpath("//*[@id='myform']/table/tbody/tr[4]/td[8]/a[1]")).click(); // ��λҪ��˵Ļ������鿴����ťԪ��
		WebElement frameOpencheck= driver.findElement(By.name("Opencheck"));
		driver.switchTo().frame(frameOpencheck);
		WebElement admin_remark= driver.findElement(By.name("admin_remark"));
		admin_remark.clear();
		admin_remark.sendKeys("ȷ�����ͨ��");
		WebElement submit= driver.findElement(By.xpath("//input[@type='submit'][@value='ͨ�����']"));
		submit.click();
		Thread.sleep(2000);                                                                          */
/*
//      ��֤���ͨ���б�Ҳ�Ƿ���ָղ����ͨ���Ļ�����Ϣ
		WebElement frameLeft= driver.findElement(By.id("rightMain"));
		driver.switchTo().frame(frameLeft);
		driver.findElement(By.xpath("html/body/div[3]/div[2]/a[2]/em")).click();
		Thread.sleep(2000);
		WebElement succeed_agency= driver.findElement(By.xpath("//td[.='��Ҷ�ݽ�������']"));
		String str_succeed_agency= succeed_agency.getText();
		Assert.assertEquals(str_succeed_agency,"��Ҷ�ݽ�������");                                          */
//      ��˲�ͨ������
		WebElement frameRight= driver.findElement(By.id("rightMain"));
		driver.switchTo().frame(frameRight);
		driver.findElement(By.xpath("//*[@id='myform']/table/tbody/tr[5]/td[8]/a[1]")).click();
		WebElement frameOpencheck= driver.findElement(By.name("Opencheck"));
		driver.switchTo().frame(frameOpencheck);
		driver.findElement(By.name("admin_remark")).clear();
		driver.findElement(By.name("admin_remark")).sendKeys("�����ϻ��������ʸ�");
		WebElement submit= driver.findElement(By.xpath("//input[@type='submit'][@value='��ͨ��']"));
		submit.click();
		Alert alert= driver.switchTo().alert();
		String str_alert= alert.getText();
		Assert.assertTrue(str_alert.contains("���ʧ��"));
		alert.accept();
		Thread.sleep(2000);
		
		
		
		
		
	}
}

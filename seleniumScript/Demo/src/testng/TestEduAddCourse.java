package testng;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.IReporter;
import org.testng.ITestListener;

public class TestEduAddCourse {
	WebDriver driver;
	@BeforeMethod
	public void startUp(){
		driver = new FirefoxDriver();
		System.setProperty("Webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		
	}
	@Test
	public void AddCourse() throws Exception{
		driver.get("https://passport.csdn.net/account/login?from=http://betaeduol.csdn.net/course/apply");
		Thread.sleep(2000);
		WebElement username_text= driver.findElement(By.id("username"));
		username_text.clear();
		username_text.sendKeys("miaoyan1989");
		String str_value= username_text.getAttribute("value");
		Assert.assertEquals(str_value, "miaoyan1989");
		WebElement password_text= driver.findElement(By.id("password"));
		password_text.clear();
		password_text.sendKeys("miaoyan2011");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='fm1']/input[6]")).click();
		Thread.sleep(3000);
//      ��д�¿γ�����������Ϣ
		String current_url= driver.getCurrentUrl();
		Assert.assertEquals(current_url,"http://betaeduol.csdn.net/course/apply");
		WebElement text_course_name= driver.findElement(By.id("course_name"));
		text_course_name.clear();
		text_course_name.sendKeys("selenium_javaApi");
		String str_text_course_name= text_course_name.getAttribute("value");
		Assert.assertEquals(str_text_course_name,"selenium_javaApi");
		Thread.sleep(3000);
//      ��ȡ������
		Select make= new Select(driver.findElement(By.id("course_cat1")));
//      ��֤�������ܶ�ѡ
		Assert.assertFalse(make.isMultiple());
		new Select(driver.findElement(By.id("course_cat1"))).selectByVisibleText("���ݿ�");
		Thread.sleep(4000);
		Select make2= new Select(driver.findElement(By.id("course_cat2")));
		Assert.assertFalse(make2.isMultiple());
		new Select(driver.findElement(By.id("course_cat2"))).selectByVisibleText("���ݿ����");
		Thread.sleep(2000);
		WebElement text_course_intro= driver.findElement(By.id("course_intro"));
		text_course_intro.clear();
		text_course_intro.sendKeys("¼����Ƶ����ϸ�鿴��Ƶ¼��Ҫ�󣬿μ������ӷ���ģ¼����Ƶ����ϸ�鿴��Ƶ¼��Ҫ�󣬿μ������ӷ���ģ");
		WebElement text_course_objectives= driver.findElement(By.id("course_objectives"));
		text_course_objectives.clear();
		text_course_objectives.sendKeys("�������簢��¸�������������˰��ϸ���IOS�����������������Ѹ���������ŷ쪸�˹Ŷ������ɩ��Ŷ��");
		WebElement text_course_plan= driver.findElement(By.id("course_plan"));
		text_course_plan.clear();
		text_course_plan.sendKeys("Ŷ�簡�����簢��¸�������������˰��ϸ���IOS�����������������Ѹ���������ŷ쪸�˹Ŷ����");
		Select make3= new Select(driver.findElement(By.name("course_suit")));
		Assert.assertFalse(make3.isMultiple());
		new Select(driver.findElement(By.name("course_suit"))).selectByVisibleText("IT��ά��Ա");
		Thread.sleep(2000);
		WebElement text_getTags= driver.findElement(By.id("getTags"));
		text_getTags.sendKeys("java");
		Thread.sleep(5000);
		
		WebElement check_name= driver.findElement(By.xpath("(//input[@name='course_type'])[2]"));
//      ����Ƿ�ѡ�����ûѡ����ѡ��
		if(!check_name.isSelected()){
			check_name.click();
		}
//      ��֤�γ������Ϣ�Ƿ���ȷѡ��ڶ���
		Assert.assertTrue(check_name.isSelected());
		WebElement course_lever_check= driver.findElement(By.xpath("(//input[@name='course_level'])[3]"));
		if(!course_lever_check.isSelected()){
			course_lever_check.click();
		}
		Assert.assertTrue(course_lever_check.isSelected());
		WebElement course_free_check= driver.findElement(By.xpath("(//input[@name='is_free'])[1]"));
		if(!course_free_check.isSelected()){
			course_free_check.click();
		}
		Assert.assertTrue(course_free_check.isSelected());
		WebElement course_count= driver.findElement(By.id("course_count"));
		course_count.clear();
		course_count.sendKeys("5");
		String str_course_count= course_count.getAttribute("value");
		Assert.assertEquals(str_course_count,"5");
		WebElement course_price= driver.findElement(By.id("course_price"));
		course_price.clear();
		course_price.sendKeys("2");
		String str_course_price= course_price.getAttribute("value");
		Assert.assertEquals(str_course_price,"2");
		WebElement upload= driver.findElement(By.id("uploadButton2"));
		upload.click();
		WebElement imgfile= driver.findElement(By.name("imgFile"));
		imgfile.sendKeys("E:\\123.png");
		WebElement comfiorm= driver.findElement(By.xpath("//input[@type='button'][@value='ȷ��']"));
		comfiorm.click();
		Thread.sleep(30000);
		WebElement submit= driver.findElement(By.xpath("//input[@type='submit'][@value='��һ��']"));
		submit.click();
		Thread.sleep(4000);
		WebElement checkbox= driver.findElement(By.xpath("//*[@id='myform']/ul/li[1]/span[2]/label/input"));
		Assert.assertTrue(checkbox.isSelected());
		WebElement class_name1= driver.findElement(By.name("course[1]"));
		class_name1.clear();
		class_name1.sendKeys("java1");
		WebElement class_name2= driver.findElement(By.name("course[2]"));
		class_name2.clear();
		class_name2.sendKeys("java2");
		WebElement class_name3= driver.findElement(By.name("course[3]"));
		class_name3.clear();
		class_name3.sendKeys("java3");
		WebElement class_name4= driver.findElement(By.name("course[4]"));
		class_name4.clear();
		class_name4.sendKeys("java4");
		WebElement class_name5= driver.findElement(By.name("course[5]"));
		class_name5.clear();
		class_name5.sendKeys("java5");
		WebElement subButton= driver.findElement(By.id("subButton"));
		subButton.click();
		Thread.sleep(30000);
		String current_Url= driver.getCurrentUrl();
		System.out.println(current_Url);
		WebElement extend_text= driver.findElement(By.xpath("html/body/div[3]/div[2]/div/div/div/span[2]"));
		String str_extend_text= extend_text.getText();
		Assert.assertEquals(str_extend_text,"���Ŀγ������Ѿ��ɹ��ύ�����ǽ��������������ڶ����Ŀγ̽�����ˣ���������");
		
		
	public void InAdminEdu_verifyCourseFail() throws Exception{
		driver.get("http://passport.csdn.net/account/login?from=http://betaadminbss.csdn.net/");
		WebElement text_user_name= driver.findElement(By.id("username"));
		text_user_name.clear();
		text_user_name.sendKeys("cpongo1");
		String str_value= text_user_name.getAttribute("value");
		Assert.assertEquals(str_value, "cpongo1");
		WebElement link_a= driver.findElement(By.xpath("html/body/div[4]/table/tbody/tr[2]/td[10]/a[3]"));//??��?????????��????????????
		link_a.click();
		WebElement frame_Opencheck=driver.findElement(By.name("Opencheck"));
		driver.switchTo().frame(frame_Opencheck);
		WebElement checkbox= driver.findElement(By.xpath("//input[@name='to_status'][@value='2']"));
		if(!checkbox.isSelected()){//      ??????????????????????????????????		
		}
	
	}



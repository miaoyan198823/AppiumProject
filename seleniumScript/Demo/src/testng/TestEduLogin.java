package testng;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.IReporter;

public class TestEduLogin {
	WebDriver driver;
	
	@Test()
	public void apply_teacher() throws Exception{
//	System.setProperty("Webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("http://passport.csdn.net/account/login?from=http://betaeduol.csdn.net/course");
		Thread.sleep(2000);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("miaoyan1989");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("miaoyan2011");
		driver.findElement(By.xpath("//*[@id='fm1']/input[6]")).click();
		driver.manage().window().maximize();
	
		driver.findElement(By.linkText("��ҳ")).click();
//		��֤�Ƿ�ɹ���¼������ѵ����¼��ȥ֮��ҳ���Ƿ������miaoyan1989������
		Assert.assertTrue(driver.findElement(By.className("name")).getText().contains("miaoyan1989"));
		driver.findElement(By.linkText("��ʦ/��������")).click();
//		��֤�������ʦ/�������롿��ť��ҳ���Ƿ�ɹ���������ҳ�棬���ӵ�ַ�Ƿ������apply��
		Assert.assertTrue(driver.getCurrentUrl().contains("apply"));
//		��֤�γ�������Ϣ�������
		driver.findElement(By.id("lecturer_name")).clear();
		driver.findElement(By.id("lecturer_name")).sendKeys("����");
		driver.findElement(By.id("lecturer_blog")).clear();
		driver.findElement(By.id("lecturer_blog")).sendKeys("http://blog.csdn.net");
		driver.findElement(By.id("lecturer_corp")).clear();
		driver.findElement(By.id("lecturer_corp")).sendKeys("CSDN");
//		��ȡ������
		Select make = new Select(driver.findElement(By.id("lecturer_pos")));
//		��֤�������ܶ�ѡ
		Assert.assertFalse(make.isMultiple());
		new Select(driver.findElement(By.id("lecturer_pos"))).selectByVisibleText("��Ʒ����");
		Thread.sleep(2000);
		new Select(driver.findElement(By.name("lecturer_agency"))).selectByVisibleText("CSDN��У���ֲ�");
		Thread.sleep(2000);
		driver.findElement(By.id("lecturer_tags")).clear();
		driver.findElement(By.id("lecturer_tags")).sendKeys("java,php,c");
		driver.findElement(By.id("lecturer_intro")).clear();
		driver.findElement(By.id("lecturer_intro")).sendKeys("���ڻ������Ϸ��������飬���������");
		driver.findElement(By.id("lecturer_expr")).clear();
		driver.findElement(By.id("lecturer_expr")).sendKeys("ӵ��3������IT��ҵ��ҵ���顢�Ȱ�IT����");
		driver.findElement(By.id("lecturer_weibo")).sendKeys("www.baidu.com");
		driver.findElement(By.id("uploadButton")).click();
		driver.findElement(By.name("imgFile")).sendKeys("E:\\123.png");
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/div[11]/div[1]/div[3]/span[1]/input")).click();
		Thread.sleep(30000);
		driver.findElement(By.id("lecturer_email")).clear();
		driver.findElement(By.id("lecturer_email")).sendKeys("550775725@qq.com");
		driver.findElement(By.id("lecturer_mobile")).clear();
		driver.findElement(By.id("lecturer_mobile")).sendKeys("15010719147");
		driver.findElement(By.name("lecturer_qq")).clear();
		driver.findElement(By.name("lecturer_qq")).sendKeys("550775725");
		driver.findElement(By.name("address")).clear();
		driver.findElement(By.name("address")).sendKeys("�����г�������˳����ָ������");
		Thread.sleep(5000);
		WebElement btn_sub= driver.findElement(By.xpath("//*[@id='form1']/div[2]/div[2]/ul/li[6]/div[2]/input"));
		btn_sub.click();
		
		
		}
	
	}
		
		
		
		
		
		
		
		
		
				
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
	
		

		
		
		
		
		
		
		
		
		
		
		
		

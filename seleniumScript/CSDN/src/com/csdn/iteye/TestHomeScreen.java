package com.csdn.iteye;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;




public class TestHomeScreen {
	private WebDriver driver;
	private HomeScreenPage hsPage;
	private static String homeScreenUrl = "http://www.iteye.com/";
	
	@BeforeMethod
	public void setUp(){
		if (driver==null) {
			driver = new FirefoxDriver();
			hsPage = new HomeScreenPage(driver, homeScreenUrl);
		}
	}
	
	@Test
	public void testNewsClick(){
		hsPage.newsClick();
		System.out.println("NewsUrl:"+hsPage.getCurrent());
		System.out.println("NewsTitle:"+hsPage.getTitle());
		Assert.assertTrue(true);
		Assert.assertTrue(hsPage.getCurrent().equals(hsPage.news_url));
	}
	
	@Test
	public void testEssenceClick(){
		hsPage.essenceClick();
		System.out.println("EssenceUrl:"+hsPage.getCurrent());
		System.out.println("EssenceTitle:"+hsPage.getTitle());
		Assert.assertTrue(true);
		Assert.assertEquals(hsPage.essence_url,hsPage.getCurrent());
	}
	
	@Test
	public void testForumClick(){
		hsPage.forumClick();
		System.out.println("ForumUrl:"+hsPage.getCurrent());
		System.out.println("ForumTitle:"+hsPage.getTitle());
		Assert.assertTrue(true);
	}
	
	@Test
	public void testAskClick(){
		hsPage.askClick();
		System.out.println("AskUrl:"+hsPage.getCurrent());
		System.out.println("AskTitle:"+hsPage.getTitle());
		Assert.assertTrue(true);
		Assert.assertTrue(hsPage.getCurrent().equals(hsPage.ask_url));
	}
	
	@Test
	public void testBlogClick(){
		hsPage.blogClick();
		System.out.println("BlogUrl:"+hsPage.getCurrent());
		System.out.println("BlogTitle:"+hsPage.getTitle());
		Assert.assertTrue(true);
		Assert.assertTrue(hsPage.blog_url.equals(hsPage.getCurrent()));
		
	}
	
	@Test
	public void testColumnClick(){
		hsPage.columnClick();
		System.out.println("ColumnUrl:"+hsPage.getCurrent());
		System.out.println("ColumnTitle:"+hsPage.getTitle());
		Assert.assertTrue(true);
		Assert.assertTrue(hsPage.getCurrent().equals(hsPage.colum_url));
	}
	
	@Test
	public void testGroupClick(){
		hsPage.groupClick();
		System.out.println("GroupUrl:"+hsPage.getCurrent());
		System.out.println("GroupTitle:"+hsPage.getTitle());
		Assert.assertTrue(true);
		Assert.assertEquals(hsPage.group_url,hsPage.getCurrent());
	}
	
	@Test	
	public void testSearchClick(){
		boolean isPageSource = true;
		try {
			hsPage.searchClick();
			Assert.assertTrue(true);
			Assert.assertTrue(hsPage.getPageSource().contains(hsPage.search_page_text));
			System.out.println("SearchUrl:"+hsPage.getCurrent());
			isPageSource = true;
		} catch (Exception e) {
			isPageSource = false;
			System.out.println("Not Find Page Source!");
		}finally{
			System.out.println("SearchPage contains 【search_page_text】："+isPageSource);
		}
		
	}
	

}








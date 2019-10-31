package com.csdn.iteye;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomeScreenPage {
	 public WebDriver driver;
	 public String homeScreenUr;
	 public static String news_title = "ITeye资讯频道首页";
	 public static String news_url = "http://www.iteye.com/news";
	 public static By newsLocator = By.linkText("资讯");
	 
	 public static String essence_title = "ITeye精华频道首页";
	 public static String essence_url = "http://www.iteye.com/magazines";
	 public static By essenceLocator = By.linkText("精华");  
	 
	 public static String forum_title = "ITeye论坛频道首页";
	 public static String forum_url = "http://www.iteye.com/forums";
	 public static By forumLocator = By.linkText("论坛");  
	 
	 public static String ask_title = "ITeye问答频道";
	 public static String ask_url = "http://www.iteye.com/ask";
	 public static By askLocator = By.linkText("问答");  
	 
	 public static String blog_title = "ITeye博客频道首页";
	 public static String blog_url = "http://www.iteye.com/blogs";
	 public static By blogLocator = By.linkText("博客");  
	 
	 public static String column_title = "ITeye博客专栏首页";
	 public static String colum_url = "http://www.iteye.com/blogs/subjects";
	 public static By columLocator = By.linkText("专栏");  
	 
	 public static String group_title = "ITeye群组频道首页";
	 public static String group_url = "http://www.iteye.com/groups";
	 public static By groupLocator = By.linkText("群组"); 
	 
	 public static String search_url = "http://www.iteye.com/search";
	 public static String search_page_text = "站内高级搜索";
	 public static By searchLocator = By.linkText("搜索");
	 
	 public HomeScreenPage(WebDriver driver,String homeScreenUrl){
		 this.driver = driver;
		 this.homeScreenUr = homeScreenUrl;
		 this.driver.get(homeScreenUrl);
		 
	 }
	 
	 public String getTitle(){
		 return this.driver.getTitle();
	 }	
	 
	 public String getCurrent(){
		 return this.driver.getCurrentUrl();
	 }
	 
	 public String getPageSource(){
		 return this.driver.getPageSource();
	 }
	
	 public WebElement getNewsField(){
		 return this.driver.findElement(newsLocator);
	 }
	 
	 public WebElement getEssenceField(){
		 return this.driver.findElement(essenceLocator);
	 }
	 
	 public WebElement getForumField(){
		 return this.driver.findElement(forumLocator);
	 }
	 
	 public WebElement getAskField(){
		 return this.driver.findElement(askLocator);
	 }
	 
	 public WebElement getBlogField(){
		 return this.driver.findElement(blogLocator);
	 }
	 
	 public WebElement getColumnField(){
		 return this.driver.findElement(columLocator);
	 }
	 
	 public WebElement getGroupField(){
		 return this.driver.findElement(groupLocator);
	 }
	 
	 public WebElement getSearchFild(){
		 return this.driver.findElement(searchLocator);
	 }
	 
	 public boolean newsClick(){
		 this.getNewsField().click();
		 return this.news_title.equals(this.getTitle());
	 }
	 
	 public boolean essenceClick(){
		 this.getEssenceField().click();
		 return this.essence_title.equals(this.getTitle());
	 }
	 
	 public boolean forumClick(){
		 this.getForumField().click();
		 return this.forum_title.equals(this.getTitle());
	 }
	 
	 public boolean askClick(){
		 this.getAskField().click();
		 return this.ask_title.equals(this.getTitle());
	 }
	 
	 public boolean blogClick(){
		 this.getBlogField().click();
		 return this.blog_title.equals(this.getTitle());
	 }
	 
	 public boolean columnClick(){
		 this.getColumnField().click();
		 return this.column_title.equals(this.getTitle());
	 }
	 
	 public boolean groupClick(){
		 this.getGroupField().click();
		 return this.group_title.equals(this.getTitle());
	 }
	 
	 public boolean searchClick(){
		 this.getSearchFild().click();
		 return this.search_url.equals(this.getCurrent());
	 }
	
	

}

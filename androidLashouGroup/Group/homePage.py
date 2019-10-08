# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

from selenium.webdriver.common.by import By
import time
from nose.tools import assert_equal

class HomePage():
    def __init__(self,app_driver):
        self.driver = app_driver

    def find_element(self,*loc):
        return self.driver.find_element(*loc)

    #定位美食元素
    food_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'美食')]")

    #定位电影元素
    movie_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'电影')]")

    #定位电影类别详情页【电影】Title文本
    movie_title_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'电影')]")

    #定位酒店元素
    hotel_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'酒店')]")

    #定位酒店类别详情页【酒店】Title文本
    hotel_title_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'酒店')]")

    #定位商城元素
    shopping_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'商城')]")

    #定位购物类别详情页【购物】Title文本
    # shopping_title_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'购物')]")

    #定位休闲娱乐元素
    entertainment_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'休闲娱乐')]")

    #定位休闲娱乐类别详情页【休闲娱乐】Title文本
    entertainment_title_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'休闲娱乐')]")

    #定位自助餐元素
    buffet_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'自助餐')]")
    #定位ktv元素
    ktv_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'KTV')]")

    #定位KTV类别详情页【KTV】Title文本
    ktv_title_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'KTV')]")

    #定位蛋糕甜品元素
    cake_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'蛋糕甜品')]")


    # 点击【首页】
    def homeCtvClick(self):
        return self.driver.find_element_by_android_uiautomator('new UiSelector().text("首页")').click()

    #点击首页各种类进入该详情页
    def foodClick(self):
        self.driver.find_element(*self.food_loc).click()
        time.sleep(3)
        self.driver.back()

    def movieListPageTitle(self):
        return self.driver.find_element(*self.movie_title_loc).text

    def movieClick(self):
        self.driver.find_element(*self.movie_loc).click()
        time.sleep(3)
        assert_equal(self.movieListPageTitle(),u'电影',msg=True)
        self.driver.back()

    def openMovie(self):
        return self.driver.find_element(*self.movie_loc).click()

    def hotelListPageTitle(self):
        return self.driver.find_element(*self.hotel_title_loc).text

    def hotelClick(self):
        self.driver.find_element(*self.hotel_loc).click()
        time.sleep(3)
        assert_equal(self.hotelListPageTitle(),u'酒店',msg=True)
        self.driver.back()

    def openHotel(self):
        return self.driver.find_element(*self.hotel_loc).click()

    # def shoppingListPageTitle(self):
    #     return self.driver.find_element(*self.shopping_title_loc).text

    def shoppingClick(self):
        self.driver.find_element(*self.shopping_loc).click()
        time.sleep(3)
        # assert_equal(self.shoppingListPageTitle(),u'购物',msg=True)
        self.driver.back()

    def entertainmentListPageTitle(self):
        return self.driver.find_element(*self.entertainment_title_loc).text

    def entertainmentClick(self):
        self.driver.find_element(*self.entertainment_loc).click()
        time.sleep(3)
        assert_equal(self.entertainmentListPageTitle(),u'休闲娱乐',msg=True)
        self.driver.back()

    def ktvListPageTitle(self):
        return self.driver.find_element(*self.ktv_title_loc).text

    def ktvClick(self):
        self.driver.find_element(*self.ktv_loc).click()
        time.sleep(3)
        assert_equal(self.ktvListPageTitle(),u'KTV',msg=True)
        self.driver.back()

    def buffetClick(self):
        self.driver.find_element(*self.buffet_loc).click()
        time.sleep(3)
        self.driver.back()

    def cakeClick(self):
        self.driver.find_element(*self.cake_loc).click()
        time.sleep(3)
        self.driver.back()



    # 通过遍历索引去点击一组元素
    # def forLoopHomePageTypeClick(self):
    #     types = self.driver.find_elements_by_class_name("android.widget.RelativeLayout")
    #     l = len(types)
    #     for x in range(l):
    #         types[x].click()
    #         time.sleep(5)
    #         self.driver.back()



    def homeTypeClick(self):
        self.foodClick()
        self.movieClick()
        self.hotelClick()
        self.shoppingClick()
        self.entertainmentClick()
        self.ktvClick()
        self.buffetClick()
        self.cakeClick()












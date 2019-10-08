# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

import time
from selenium.webdriver.common.by import By

class MovieListPage():
    def __init__(self,app_driver):
        self.driver = app_driver


    #定位【正在热映】元素
    filming_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'正在热映')]")
    #定位【即将上映】元素
    forthcoming_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'即将上映')]")
    #定位【影院选座】元素
    seat_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'影院选座')]")
    #定位【影票团购】元素
    group_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'影票团购')]")

    def find_element(self,*loc):
        return self.driver.find_element(*loc)

    def movieListPage(self):
        self.driver.find_element_by_android_uiautomator('new UiScrollable(new UiSelector().className("android.widget.ListView")).scrollIntoView(new UiSelector().textContains("燕山"))').click()
        time.sleep(2)
        self.driver.back()
        time.sleep(2)
        self.driver.back()


    def filmingClick(self):
        self.driver.find_element(*self.filming_loc).click()
        time.sleep(3)
        self.driver.back()

    # def forthcomingClick(self):
    #     self.driver.find_element(*self.forthcoming_loc).click()
    #     time.sleep(3)
    #     self.driver.back()

    # def seatClick(self):
    #     self.driver.find_element(*self.seat_loc).click()
    #     time.sleep(5)
    #     self.driver.back()

    def groupClick(self):
        self.driver.find_element(*self.group_loc).click()
        time.sleep(3)
        self.driver.back()


    def movieListPageIconClick(self):
        self.filmingClick()
        # self.forthcomingClick()
        # self.seatClick()
        self.groupClick()






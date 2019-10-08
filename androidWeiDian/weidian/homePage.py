# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

from selenium.webdriver.common.by import By
from appium.webdriver.common.touch_action import TouchAction




class HomePage(object):
    def __init__(self,app_driver):
        self.driver = app_driver


    #定位器：
    diancan_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'微点餐')]")
    waimai_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'微外卖')]")
    yuyue_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'微预约')]")
    kaquan_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'核销卡券')]")
    balance_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'会员余额')]")
    kaquan_page_title_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'核销卡券')]")


    def find_element(self,*loc):
        return self.driver.find_element(*loc)

    def  diancan_click(self):
        return self.driver.find_element(*self.diancan_loc).click()

    def diancan_page_title_text(self):
        return self.driver.find_element_by_accessibility_id("微点餐").get_attribute("name")

    def waimai_click(self):
        return self.driver.find_element(*self.waimai_loc).click()

    def waimai_page_title_text(self):
        return self.driver.find_element_by_accessibility_id("微外卖").get_attribute("name")

    def kaquan_click(self):
        return self.driver.find_element(*self.kaquan_loc).click()

    def kaquan_page_title_text(self):
        return self.driver.find_element(*self.kaquan_page_title_loc).text

    def banlance_click(self):
        return self.driver.find_element(*self.balance_loc).click()

    def banlance_page_titie_text(self):
        return self.driver.find_element_by_accessibility_id("会员余额").get_attribute("name")

    def yuyue_click(self):
        return self.driver.find_element(*self.yuyue_loc).click()

    def yuyue_page_title_text(self):
        return self.driver.find_element_by_accessibility_id("微预约").get_attribute("name")

# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

from selenium.webdriver.common.by import By

class HomePage():
    def __init__(self,app_driver):
        self.driver = app_driver

    #定位团购首页【商城】元素
    shopping_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'商城')]")

    #定位商城首页【分类】元素
    type_loc = (By.ID,"分类")

    #定位检测新版本【关闭】按钮
    close_loc = (By.ID,"com.lashou.groupurchasing:id/btn_close_upgrade")

    def find_element(self,*loc):
        return self.driver.find_element(*loc)

    def closeClick(self):
        return self.driver.find_element(*self.close_loc).click()

    def shoppingClick(self):
        return self.driver.find_element(*self.shopping_loc).click()

    def typeClick(self):
        return self.driver.find_element(*self.type_loc).click()
















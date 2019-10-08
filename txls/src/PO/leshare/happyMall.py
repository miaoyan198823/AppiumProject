# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

from selenium.webdriver.common.by import By
import sys


reload(sys)
sys.setdefaultencoding('utf8')


class HappyMall():
    def __init__(self,app_driver):
        self.driver = app_driver


    #定位【悦.商城】入口
    happyMall_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'悦·商城')]")


    def find_element(self,*loc):
        return self.driver.find_element(*loc)

    #点击【悦.商城】入口进入悦商城首页
    def happyMall_click(self):
        happyMall_X = 661
        happyMall_Y = 575
        return self.driver.tap([(happyMall_X,happyMall_Y)],5)

    #点击【镇店之宝】进入镇店之宝页面
    def townShop_click(self):
        townShop_X = 251
        townShop_Y = 885
        return self.driver.tap([(townShop_X,townShop_Y)],5)

    #点击【萌宝出行】进入萌宝出行页面
    def babyTravel_click(self):
        babyTravel_X = 754
        babyTravel_Y = 760
        return self.driver.tap([(babyTravel_X,babyTravel_Y)],5)

    #点击【新百有好货】进入新百购物首页
    def xinBaiShop_click(self):
        xinBaiShop_X = 749
        xinBaiShop_Y = 998
        return self.driver.tap([(xinBaiShop_X,xinBaiShop_Y)],5)




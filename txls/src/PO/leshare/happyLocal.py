# -*- coding: utf-8 -*-
__author__ = 'miaoyan'



import sys
import time
from selenium.webdriver.common.by import By
from src.PO.leshare import publicMethod

reload(sys)
sys.setdefaultencoding('utf8')


class HappyLocal():
    def __init__(self,app_driver):
        self.driver = app_driver


    #定位悦本地列表页Title
    happyLocal_list_title_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'悦·本地')]")


    #获取悦本地列表页Title
    def get_happyLocalList_title(self):
        return publicMethod.PublicMethod(self.driver).find_element(*self.happyLocal_list_title_loc).text


    #点击【悦本地】入口
    def happyLocalEnter_click(self):
        happyLocalEnter_X = 568
        happyLocalEnter_Y = 694
        return self.driver.tap([(happyLocalEnter_X,happyLocalEnter_Y)],4)


    #点击悦本地列表页包含【少儿编程】的内容
    def happyLocalListPart_click(self):
        scrollClick = self.driver.find_element_by_android_uiautomator('new UiScrollable(new UiSelector().className("android.widget.ListView")).scrollIntoView(new UiSelector().textContains("少儿编程兴趣养成"))')
        scrollClick.click()
        time.sleep(10)








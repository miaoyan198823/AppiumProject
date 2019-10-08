# -*- coding: utf-8 -*-
__author__ = 'miaoyan'


from selenium.webdriver.common.by import By
import sys

reload(sys)
sys.setdefaultencoding('utf8')


class HappyPurchase():
    def __init__(self,app_driver):
        self.driver = app_driver



    #点击【悦内购】入口进入悦内购页面(使用于768*1184设备)
    def purchaseEnter_click(self):
        purchaseEnter_X = 613
        purchaseEnter_Y = 1260
        return self.driver.tap([(purchaseEnter_X,purchaseEnter_Y)],4)



    #点击【内部福利图片】进入三胞内购福利页面
    def welfareImg_click(self):
        welfareImg_X = 486
        welfareImg_Y = 1438
        self.driver.tap([(welfareImg_X,welfareImg_Y)],5)








# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

from appium import webdriver
from Group import Base
import time
import homePage


a = 130.8/1080
b = 570.7/1776
class TestType():
    def setUp(self):
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',Base.setDevice())

    def tearDown(self):
        self.driver.quit()

    def meishiClick(self):
        self.driver.tap([(a,b)],5)


    def testTypeClick(self):
        time.sleep(8)
        homePage.HomePage(self.driver).closeClick()
        self.meishiClick()
        time.sleep(9)


        # homePage.HomePage(self.driver).shoppingClick()
        # time.sleep(3)
        # homePage.HomePage(self.driver).typeClick()
        # time.sleep(4)

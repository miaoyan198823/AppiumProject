# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

import os,time
from appium import webdriver
from nose.tools import assert_equal


PATH = lambda p:os.path.abspath(
    os.path.join(os.path.dirname(__file__),p)
)

class testNews():
    def setUp(self):
        desired_caps = {}
        desired_caps['device'] = 'android'
        desired_caps['deviceName'] = '192.168.214.101:5555'
        desired_caps['platformName'] = 'Android'
        desired_caps['platformVersion'] = '4.4'
        desired_caps['app'] = PATH('D:\wangyixinwen_588.apk')
        desired_caps['app-package'] = 'com.netease.newsreder.activity'
        desired_caps['app-activity'] = 'com.netease.nr.biz.ad.AdActivity'
        desired_caps['noReset'] = 'true'
        desired_caps['unicodeKeyboard'] = 'true'
        desired_caps['resetKeyboard'] = 'true'
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',desired_caps)



    def testNeteaseNew(self):
        self.driver.implicitly_wait(6)
        news = self.driver.find_element_by_android_uiautomator('new UiScrollable(new UiSelector().className("android.support.v4.view.ViewPager")).scrollIntoView(new UiSelector().textContains("习"))')
        news.click()
        time.sleep(6)
        views = self.driver.find_element_by_class_name("android.widget.ImageButton")
        views.click()
        time.sleep(5)





    def tearDown(self):
        self.driver.close_app()


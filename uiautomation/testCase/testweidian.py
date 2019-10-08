# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

from appium import webdriver
import os,time
from nose.tools import assert_equal

PATH = lambda p:os.path.abspath(
    os.path.join(os.path.dirname(__file__),p)
)

class testWeiDian():
    def setUp(self):
        desired_caps = {}
        desired_caps['device'] = 'android'
        desired_caps['deviceName'] = '192.168.214.101:5555'
        desired_caps['platformName'] = 'Android'
        desired_caps['platformVersion'] = '4.4'
        desired_caps['noSign'] = 'true'
        # desired_caps['app-package'] = 'com.lashou.weidian'
        # desired_caps['app-activity'] = 'activity.login.MainActivity'
        desired_caps['app'] = PATH('D:\WeiDianApp-release.apk')
        desired_caps['noReset'] = 'true'
        desired_caps['unicodeKeyboard'] = 'true'
        desired_caps['resetKeyboard'] = 'true'
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',desired_caps)

    def test_weidian(self):
        user_text = self.driver.find_element_by_android_uiautomator('new UiSelector().resourceId("com.lashou.weidian:id/user_et")')
        user_text.clear()
        user_text.send_keys("lashouceshi")
        pw_text = self.driver.find_element_by_id("com.lashou.weidian:id/password_et")
        pw_text.clear()
        pw_text.send_keys("LS2016!@#")
        login_btn = self.driver.find_element_by_android_uiautomator('new UiSelector().className("android.widget.Button").text("登录")')
        login_btn.click()



    def tearDown(self):
        self.driver.close_app()





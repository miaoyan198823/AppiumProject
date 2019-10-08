# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

import os,time
from appium import webdriver
from nose.tools import assert_equal


PATH = lambda p:os.path.abspath(
    os.path.join(os.path.dirname(__file__),p)
)


class testQQ():
    def setUp(self):
        desired_caps = {}
        desired_caps['device'] = 'android'
        desired_caps['deviceName'] = '192.168.214.101:5555'
        desired_caps['platformName'] = 'Android'
        desired_caps['platformVersion'] = '4.4'
        desired_caps['app'] = PATH('D:\QQ_422.apk')
        desired_caps['app-package'] = 'com.tencent.mobileqq'
        desired_caps['app-activity'] = 'com.tencent.mobileqq.debug.DebugActivity'
        desired_caps['noReset'] = 'true'
        desired_caps['unicodeKeyboard'] = 'true'
        desired_caps['resetKeyboard'] = 'true'
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',desired_caps)


    def test_qq(self):
        self.driver.implicitly_wait(5)
        try:
            us_text = self.driver.find_element_by_accessibility_id("请输入QQ号码或手机或邮箱")
            us_text.clear()
            us_text.send_keys("550775725")
            pw_text = self.driver.find_element_by_id("com.tencent.mobileqq:id/password")
            pw_text.clear()
            pw_text.send_keys("miaoyan2016")
            login_button = self.driver.find_element_by_accessibility_id("登录")
            login_button.click()
            l_succ = self.driver.find_element_by_id("com.tencent.mobileqq:id/name")
            if assert_equal(u"联系人",l_succ.text):
                print u"登录成功！"
        except:
            print u"登录失败！"












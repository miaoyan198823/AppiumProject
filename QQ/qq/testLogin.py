# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

from appium import webdriver
import time
import base
import login
import homePage


class TestLogin():
    global userName
    global passWord
    userName = '2480608506'
    passWord = 'miaoyan1998'

    def setUp(self):
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',base.setDevice())

    def tearDown(self):
        self.driver.quit()

    def testLogin(self):
        try:
            time.sleep(10)
            login.Login(self.driver).userLogin(userName,passWord)
            time.sleep(6)
            if homePage.HomePage(self.driver).messageText() == u'消息':
                print u'用户登录QQ成功！'
        except Exception,e:
            print e.message


# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

from nose.tools import assert_equal
from appium import webdriver
import time
import basePage
import loginPage


class TestLogin():
    global userName
    global passWord
    userName = 'lashouceshi'
    passWord = 'LS2016!@#'

    def setUp(self):
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',basePage.setDevice())

    def tearDown(self):
        self.driver.quit()

    def test_login(self):
        try:
            loginPage.LoginPage(self.driver).user_login(userName,passWord)
            time.sleep(2)
            assert_equal(loginPage.LoginPage(self.driver).home_title_text(),u'首页',msg='True')
            print u'登录成功！'
        except Exception,e:
            print e.message

    def test_logout(self):
        try:
            loginPage.LoginPage(self.driver).user_login(userName,passWord)
            time.sleep(2)
            loginPage.LoginPage(self.driver).user_loginout()
            time.sleep(2)
            if loginPage.LoginPage(self.driver).login_btn_text() == u'登录':
                print u'退出登录，成功返回登录页面！'
        except Exception,e:
            print e.message







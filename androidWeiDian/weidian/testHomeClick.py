# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

from appium import webdriver
from nose.tools import assert_equal
import time
import basePage
import loginPage
import homePage



class TestHomePage():
    global userName
    global passWord
    userName = 'lashouceshi'
    passWord = 'LS2016!@#'

    def setUp(self):
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',basePage.setDevice())

    def tearDown(self):
        self.driver.quit()

    def test_diancan_click(self):
        try:
            loginPage.LoginPage(self.driver).user_login(userName,passWord)
            time.sleep(2)
            homePage.HomePage(self.driver).diancan_click()
            time.sleep(6)
            assert_equal(homePage.HomePage(self.driver).diancan_page_title_text(),u'微点餐')
            print u"成功进入微点餐订单列表页！"
        except Exception,e:
            print e.message

    def test_waimai_click(self):
        try:
            loginPage.LoginPage(self.driver).user_login(userName,passWord)
            time.sleep(2)
            homePage.HomePage(self.driver).waimai_click()
            time.sleep(6)
            assert_equal(homePage.HomePage(self.driver).waimai_page_title_text(),u'微外卖')
            print u"成功进入微外卖订单列表页！"
        except Exception,e:
            print e.message

    def test_kaquan_click(self):
        try:
            loginPage.LoginPage(self.driver).user_login(userName,passWord)
            time.sleep(2)
            homePage.HomePage(self.driver).kaquan_click()
            time.sleep(6)
            assert_equal(homePage.HomePage(self.driver).kaquan_page_title_text(),u'核销卡券')
            print u'成功进入核销卡券页面！'
        except Exception,e:
            print e.message

    def test_banlance_click(self):
        try:
            loginPage.LoginPage(self.driver).user_login(userName,passWord)
            time.sleep(2)
            homePage.HomePage(self.driver).banlance_click()
            time.sleep(6)
            if homePage.HomePage(self.driver).banlance_page_titie_text() == u'会员余额':
                print u'成功进入会员余额页面！'
        except Exception,e:
            print e.message

    def test_yuyue_click(self):
        try:
            loginPage.LoginPage(self.driver).user_login(userName,passWord)
            time.sleep(2)
            homePage.HomePage(self.driver).yuyue_click()
            time.sleep(6)
            assert_equal(homePage.HomePage(self.driver).yuyue_page_title_text(),u'微预约')
            print u"成功进入微预约订单列表页！"
        except Exception,e:
            print e.message











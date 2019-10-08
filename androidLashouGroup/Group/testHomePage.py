# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

from appium import webdriver
import time
import Base
import loginPage
import homePage


class TestHomePage():
    global userName
    global passWord
    userName = '15101183723'
    passWord = 'miaoyan1989'

    def setUp(self):
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',Base.setDevice())
        self.driver.implicitly_wait(5)



    def  tearDown(self):
        self.driver.quit()

    def testHomePage(self):
        # self.driver.open_notifications()
        # self.driver.back()
        # X = self.driver.get_window_size()['width']
        # Y = self.driver.get_window_size()['height']
        # print X,Y
        loginPage.LoginPage(self.driver).user_login(userName,passWord)
        time.sleep(2)
        homePage.HomePage(self.driver).homeCtvClick()
        homePage.HomePage(self.driver).homeTypeClick()












        




















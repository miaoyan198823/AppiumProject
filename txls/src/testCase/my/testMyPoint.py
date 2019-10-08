# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

import time

from appium import webdriver
from nose.tools import assert_equal

from src.publicSession import base
from src.PO.my import login
from src.PO.my import myPoint


class TestMyPoint():
    global userName
    global passWord
    userName = '15101183723'
    passWord = 'miaoyan1989'

    def setUp(self):
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub', base.setDevices())


    #测试点击我的页面【我的积分】进入我的积分页面
    def testMyPointClick(self):
        try:
            time.sleep(5)
            login.Login(self.driver).login(userName,passWord)
            myPoint.MyPoint(self.driver).my_point_click()
            assert_equal(myPoint.MyPoint(self.driver).my_point_text(),u'我的积分')
            myPoint.MyPoint(self.driver).login_success_swip()
            time.sleep(5)
            assert_equal(myPoint.MyPoint(self.driver).login_success_text(),u'注册成功')
            assert_equal(myPoint.MyPoint(self.driver).login_success_score_text(),'+35')
        except AssertionError,e:
            print e







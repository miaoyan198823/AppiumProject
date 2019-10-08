# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

from nose.tools import assert_equal
from appium import webdriver
import time
import Base
import loginPage

class TestLogin():
    global userName
    global passWord
    userName = '15101183723'
    passWord = 'miaoyan1989'

    def setUp(self):
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',Base.setDevice())
        self.driver.implicitly_wait(20)

    def tearDown(self):
        self.driver.quit()

    def test_login(self):
        try:
            time.sleep(2)
            loginPage.LoginPage(self.driver).user_login(userName,passWord)
            time.sleep(3)
            assert_equal(loginPage.LoginPage(self.driver).user_login_assert_text(),u'QQ准会员，')
            print u"登录成功！"
            loginPage.LoginPage(self.driver).user_logout()
            time.sleep(3)
            assert_equal(loginPage.LoginPage(self.driver).user_unlogin_notice_text(),u'您还没有登录哦')
            print u"成功退出登录！"
        except Exception,e:
            print e.message


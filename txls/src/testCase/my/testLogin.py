# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

import logging
import logging.config
import time
import sys
from nose.tools import assert_equal
from appium import webdriver
from src.publicSession import base
from src.PO.my import login


reload(sys)
sys.setdefaultencoding('utf8')

class TestLogin():
    global userName
    global passWord
    userName = '15101183723'
    passWord = 'miaoyan1989'

    def __init__(self):
        self.logger = logging.getLogger(__name__)

    def setUp(self):
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub', base.setDevices())


    def testlogin(self):
        try:
            # time.sleep(10)
            # login.Login(self.driver).getelementPositionSwipe()
            time.sleep(8)
            login.Login(self.driver).login(userName,passWord)
            assert_equal(login.Login(self.driver).login_success_user_text(),u'这是真的吗')
            self.logger.info(u'用户登录成功！')
            self.driver.get_screenshot_as_file('D:/txls/src/result/successScreenShot/login.png')
        except AssertionError,e:
            print str(e)


    def tearDown(self):
        self.driver.quit()




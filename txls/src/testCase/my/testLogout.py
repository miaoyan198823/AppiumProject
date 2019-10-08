# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

import time
import sys
import logging

from appium import webdriver
from nose.tools import assert_equal

from src.publicSession import base
from src.PO.my import logout


reload(sys)
sys.setdefaultencoding('utf8')

class TestLogout():
    def __init__(self):
        self.logger = logging.getLogger(__name__)

    def setUp(self):
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub', base.setDevices())


    def testLogout(self):
        try:
            time.sleep(8)
            logout.LogOut(self.driver).logout()
            assert_equal(logout.LogOut(self.driver).loginout_assert_text(),u'立即登录')
            self.logger.info(u'退出登录成功！')
            self.driver.get_screenshot_as_file('D:/txls/src/result/successScreenShot/logout.png')
        except Exception as e:
            self.logger.error('logout fail:%s'%e)

    def tearDown(self):
        self.driver.quit()


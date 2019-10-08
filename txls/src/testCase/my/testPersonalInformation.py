# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

import sys
import logging
import logging.config
import time
from appium import webdriver
from nose.tools import assert_equal
from nose.tools import assert_true
from src.publicSession import base
from src.PO.my import login
from src.PO.my import logout
from src.PO.my import personalInfomation


reload(sys)
sys.setdefaultencoding('utf8')


class TestPersonalInformation():
    global userName
    global passWord
    global nickName
    userName = '15101183723'
    passWord = 'miaoyan1989'
    nickName = 'miaoyan1989'

    def __init__(self):
        self.logger = logging.getLogger(__name__)

    def setUp(self):
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub', base.setDevices())

    def testConfigureNickName(self):
        try:
            # login.Login(self.driver).getelementPositionSwipe()
            time.sleep(4)
            login.Login(self.driver).login(userName,passWord)
            personalInfomation.PersionalInfo(self.driver).user_headimg_click()
            personalInfomation.PersionalInfo(self.driver).user_nickName_click()
            time.sleep(2)
            personalInfomation.PersionalInfo(self.driver).user_nickName_input_click()
            time.sleep(2)
            personalInfomation.PersionalInfo(self.driver).user_nickName_input_clear(personalInfomation.PersionalInfo(self.driver).get_nickName_input_text())
            time.sleep(3)
            personalInfomation.PersionalInfo(self.driver).user_nickName_input('miaoyan1989')
            personalInfomation.PersionalInfo(self.driver).user_nickName_input_confirm_click()
            self.driver.back()
            time.sleep(1)
            self.driver.back()
            time.sleep(3)
            if personalInfomation.PersionalInfo(self.driver).user_name_text() == 'miaoyan1989':
                self.logger.info(u'配置昵称成功！')
                logout.LogOut(self.driver).logout()
        except AssertionError,e:
            print e.message


    def testConfigureBirthday(self):
        try:
            time.sleep(5)
            login.Login(self.driver).login(userName,passWord)
            personalInfomation.PersionalInfo(self.driver).user_headimg_click()
            personalInfomation.PersionalInfo(self.driver).user_birthday_click()
            personalInfomation.PersionalInfo(self.driver).userBirthdayConfig()
            personalInfomation.PersionalInfo(self.driver).user_birthday_confim_btn_click()
            time.sleep(4)
            assert_true(personalInfomation.PersionalInfo(self.driver).user_birthday_text())
            self.logger.info(u'配置用户生日成功！')
            self.driver.back()
            time.sleep(1)
            logout.LogOut(self.driver).logout()
        except AssertionError,e:
            print e.message


    def testConfitureUserSexy(self):
        try:
            time.sleep(5)
            login.Login(self.driver).login(userName,passWord)
            personalInfomation.PersionalInfo(self.driver).user_headimg_click()
            personalInfomation.PersionalInfo(self.driver).user_sexy_click()
            time.sleep(2)
            personalInfomation.PersionalInfo(self.driver).user_sexy_man_click()
            time.sleep(4)
            assert_equal(personalInfomation.PersionalInfo(self.driver).user_sexy_man_text()
            ,u'男')
            self.logger.info(u'配置用户性别成功！')
            self.driver.back()
            logout.LogOut(self.driver).logout()
        except AssertionError,e:
            print e.message


    def tearDown(self):
        self.driver.quit()





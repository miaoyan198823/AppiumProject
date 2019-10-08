# -*- coding: utf-8 -*-
__author__ = 'miaoyan'


import sys
import logging
import time
from appium import webdriver
from src.publicSession import base
from src.PO.leshare import enterpriseList
from src.PO.leshare import publicMethod
from src.PO.leshare import happyLocal


reload(sys)
sys.setdefaultencoding('utf8')



class TestHappyLocal():
    def __init__(self):
        self.logger = logging.getLogger(__name__)

    def setUp(self):
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',base.setDevices())

    def tearDown(self):
	    self.driver.quit()



    def testHappyLocalEnter(self):
        try:
            time.sleep(5)
            enterpriseList.EnterpriseList(self.driver).leshare_click()
            time.sleep(8)
            publicMethod.PublicMethod(self.driver).swipeLeshare()
            time.sleep(2)
            happyLocal.HappyLocal(self.driver).happyLocalEnter_click()
            time.sleep(6)
            if happyLocal.HappyLocal(self.driver).get_happyLocalList_title() == '悦·本地':
                self.logger.info(u'成功从悦本地入口进入悦本地列表页!')
                self.driver.get_screenshot_as_file('D:/txls/src/result/successScreenShot/happyLocalEnter.png')
        except:
            self.logger.warning(u'从悦本地入口进入悦本地列表页失败！')
            self.driver.get_screenshot_as_file('D:/txls/src/result/errorScreenShot/happyLocalEnter.png')


    def testHappyLocalPart(self):
        try:
            time.sleep(5)
            enterpriseList.EnterpriseList(self.driver).leshare_click()
            time.sleep(8)
            publicMethod.PublicMethod(self.driver).swipeLeshare()
            time.sleep(2)
            happyLocal.HappyLocal(self.driver).happyLocalEnter_click()
            time.sleep(5)
            happyLocal.HappyLocal(self.driver).happyLocalListPart_click()
            self.logger.info(u'从悦本地列表页点击【少儿编程兴趣养成】进入该详情页成功！')
            self.driver.get_screenshot_as_file('D:/txls/src/result/successScreenShot/happyLocalPart.png')
        except:
            self.logger.warning(u'从悦本地列表页点击【少儿编程兴趣养成】进入该内容详情页失败！')
            self.driver.get_screenshot_as_file('D:/txls/src/result/errorScreenShot/happyLocalPart.png')








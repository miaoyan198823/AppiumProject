# -*- coding: utf-8 -*-
__author__ = 'miaoyan'


import sys
import logging
import time
from appium import webdriver
from src.publicSession import base
from src.PO.leshare import enterpriseList
from src.PO.leshare import happyMall


reload(sys)
sys.setdefaultencoding('utf8')


class TestHappyMall():
    def __init__(self):
        self.logger = logging.getLogger(__name__)

    def setUp(self):
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',base.setDevices())

    def tearDown(self):
        self.driver.quit()


    def testHappyMallEntrance(self):
        try:
            time.sleep(4)
            enterpriseList.EnterpriseList(self.driver).leshare_click()
            time.sleep(8)
            happyMall.HappyMall(self.driver).happyMall_click()
            time.sleep(8)
            self.logger.info(u'成功进入悦商城首页！')
            self.driver.get_screenshot_as_file('D:/txls/src/result/successScreenShot/happyMall.png')
        except:
            self.logger.warning(u'进入悦商城失败！')


    def testTownShop(self):
        try:
            time.sleep(4)
            enterpriseList.EnterpriseList(self.driver).leshare_click()
            time.sleep(8)
            happyMall.HappyMall(self.driver).townShop_click()
            time.sleep(8)
            self.logger.info(u'成功进入镇店之宝页面！')
            self.driver.get_screenshot_as_file('D:/txls/src/result/successScreenShot/townShop.png')
        except:
            self.logger.warning(u'进入镇店之宝失败！')



    def testBabyTravel(self):
        try:
            time.sleep(4)
            enterpriseList.EnterpriseList(self.driver).leshare_click()
            time.sleep(82)
            happyMall.HappyMall(self.driver).babyTravel_click()
            time.sleep(8)
            self.logger.info(u'成功进入萌宝出行页面！')
            self.driver.get_screenshot_as_file('D:/txls/src/result/successScreenShot/babyTravel.png')
        except:
            self.logger.warning(u'进入萌宝出行失败！')


    def testXinBaiShop(self):
        try:
            time.sleep(4)
            enterpriseList.EnterpriseList(self.driver).leshare_click()
            time.sleep(8)
            happyMall.HappyMall(self.driver).xinBaiShop_click()
            time.sleep(8)
            self.logger.info(u'成功进入新百好货页面！')
            self.driver.get_screenshot_as_file('D:/txls/src/result/successScreenShot/xinBaiShop.png')
        except:
            self.logger.warning(u'进入新百好货失败！')










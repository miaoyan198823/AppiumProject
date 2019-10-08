# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

import sys
import logging
import time
from appium import webdriver
from src.publicSession import base
from src.PO.leshare import enterpriseList
from src.PO.leshare import happyPurchase



reload(sys)
sys.setdefaultencoding('utf8')


class TestPurchase():
    def __init__(self):
        self.logger = logging.getLogger(__name__)

    def setUp(self):
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',base.setDevices())

    def tearDown(self):
        self.driver.quit()


    def testPurchaseEnter(self):
        try:
            time.sleep(4)
            enterpriseList.EnterpriseList(self.driver).leshare_click()
            time.sleep(8)
            # X = self.driver.get_window_size()['width']
            # Y = self.driver.get_window_size()['height']
            happyPurchase.HappyPurchase(self.driver).purchaseEnter_click()
            time.sleep(8)
            self.logger.info(u'点击悦内购入口成功进入悦内购页面！')
            self.driver.get_screenshot_as_file('D:/txls/src/result/successScreenShot/PurchaseEnter.png')
        except:
            self.logger.warning(u'从悦内购入口进入悦内购页面失败！')



    def testWelfareImg(self):
        try:
            time.sleep(4)
            enterpriseList.EnterpriseList(self.driver).leshare_click()
            time.sleep(8)
            happyPurchase.HappyPurchase(self.driver).welfareImg_click()
            time.sleep(8)
            self.logger.info(u'点击悦内购图片成功进入悦内购页面！')
            self.driver.get_screenshot_as_file('D:/txls/src/result/successScreenShot/WelfareImg.png')
        except:
            self.logger.warning(u'点击悦内购图片进入悦内购页面失败！')






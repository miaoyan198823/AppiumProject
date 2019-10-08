# -*- coding: utf-8 -*-
__author__ = 'miaoyan'


import sys
import logging
import time
from appium import webdriver
from src.publicSession import base
from src.PO.leshare import publicMethod
from src.PO.leshare import enterpriseList
from src.PO.leshare import happyMember


reload(sys)
sys.setdefaultencoding('utf8')


class TestHappyMember():
    def __init__(self):
        self.logger = logging.getLogger(__name__)


    def setUp(self):
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',base.setDevices())

    def tearDown(self):
        self.driver.quit()

    def testHappyMemberEnter(self):
        try:
            time.sleep(5)
            enterpriseList.EnterpriseList(self.driver).leshare_click()
            time.sleep(2)
            publicMethod.PublicMethod(self.driver).swipeLeshare()
            time.sleep(2)
            happyMember.HappyMember(self.driver).happyMemberEnter_click()
            time.sleep(10)
            if happyMember.HappyMember(self.driver).get_intrgralMall_title() == '积分商城':
                self.logger.info(u'从悦会员入口成功进入积分商城页面！')
                self.driver.get_screenshot_as_file('D:/txls/src/result/successScreenShot/happyMemberEnter.png')
        except:
            self.logger.warning(u'从悦会员入口进入积分商城页面失败！')
            self.driver.get_screenshot_as_file('D:/txls/src/result/errorScreenShot/happyMemberEnter.png')


    def testTurntable(self):
        try:
            time.sleep(5)
            enterpriseList.EnterpriseList(self.driver).leshare_click()
            time.sleep(2)
            publicMethod.PublicMethod(self.driver).swipeLeshare()
            time.sleep(2)
            if happyMember.HappyMember(self.driver).turntable_click():
                time.sleep(7)
                self.logger.info(u'成功跳转进入大转盘抽奖页面！')
                self.driver.get_screenshot_as_file('D:/txls/src/result/successScreenShot/turntable.png')
        except:
            self.logger.warning(u'进入大转盘抽奖页面失败！')
            self.driver.get_screenshot_as_file('D:/txls/src/result/errorScreenShot/turntable.png')


    def testIntegralLottery(self):
        try:
            time.sleep(5)
            enterpriseList.EnterpriseList(self.driver).leshare_click()
            time.sleep(2)
            publicMethod.PublicMethod(self.driver).swipeLeshare()
            time.sleep(2)
            if happyMember.HappyMember(self.driver).integralLottery_click():
                time.sleep(7)
                self.logger.info(u'成功进入1积分抽爆品页面！')
                self.driver.get_screenshot_as_file('D:/txls/src/result/successScreenShot/integralLottery.png')
        except:
            self.logger.warning(u'进入1积分抽爆品页面失败！')
            self.driver.get_screenshot_as_file('D:/txls/src/result/errorScreenShot/integralLottery.png')





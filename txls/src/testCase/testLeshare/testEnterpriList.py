# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

import logging
import sys
import time
from appium import webdriver
from nose.tools import assert_equal
from src.publicSession import base
from src.PO.leshare import enterpriseList

reload(sys)
sys.setdefaultencoding('utf8')

class TestEnterpriseList():
    def __init__(self):
        self.logger = logging.getLogger(__name__)

    def setUp(self):
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',base.setDevices())

    def tearDown(self):
        self.driver.quit()

    def testNataliClick(self):
        try:
            time.sleep(4)
            enterpriseList.EnterpriseList(self.driver).leshare_click()
            time.sleep(2)
            enterpriseList.EnterpriseList(self.driver).natali_click()
            time.sleep(20)
            assert_equal(enterpriseList.EnterpriseList(self.driver).get_natali_title(),'纳塔力健康管理咨询有限公司')
            self.logger.info(u'欢迎进入纳塔力健康管理咨询有限公司首页！')
            self.driver.back()
        except:
            self.driver.get_screenshot_as_file('D:/txls/src/result/errorScreenShot/natali.png')
            self.logger.error(u'进入纳塔力公司首页失败！')


    def testMiaoHealthyClick(self):
        try:
            time.sleep(4)
            enterpriseList.EnterpriseList(self.driver).leshare_click()
            time.sleep(2)
            enterpriseList.EnterpriseList(self.driver).miaoHealthy_click()
            time.sleep(20)
            if enterpriseList.EnterpriseList(self.driver).get_miaoHealthy_title() == '妙健康-首页':
                self.logger.info(u'欢迎进入妙健康公司首页！')
                self.driver.back()
        except:
            self.driver.get_screenshot_as_file('D:/txls/src/result/errorScreenShot/miaoHealthy.png')
            self.logger.error(u'进入妙健康公司首页失败！')



    def testFanDiClick(self):
        try:
            time.sleep(4)
            enterpriseList.EnterpriseList(self.driver).leshare_click()
            time.sleep(2)
            enterpriseList.EnterpriseList(self.driver).fanDi_click()
            time.sleep(20)
            if enterpriseList.EnterpriseList(self.driver).get_fanDi_title() == '首页-凡迪基因':
                self.logger.info(u'欢迎进入凡迪基因公司首页！')
                self.driver.back()
        except:
            self.driver.get_screenshot_as_file('D:/txls/src/result/errorScreenShot/fanDi.png')
            self.logger.error(u'进入凡迪基因公司首页失败！')


    def testOuXiYaClick(self):
        try:
            time.sleep(4)
            enterpriseList.EnterpriseList(self.driver).leshare_click()
            time.sleep(2)
            enterpriseList.EnterpriseList(self.driver).ouxiya_click()
            time.sleep(40)
            if enterpriseList.EnterpriseList(self.driver).get_ouxiya_title() == '欧西亚官方微店- 店铺主页':
                self.logger.info(u'欢迎进入欧西亚官方微店店铺主页！')
        except:
            self.driver.get_screenshot_as_file('D:/txls/src/result/errorScreenShot/ouxiya.png')


    def testMaiLiDaClick(self):
        try:
            time.sleep(4)
            enterpriseList.EnterpriseList(self.driver).leshare_click()
            time.sleep(2)
            enterpriseList.EnterpriseList(self.driver).swipeEnterpriseList()
            time.sleep(2)
            enterpriseList.EnterpriseList(self.driver).mailida_click()
            time.sleep(20)
            if enterpriseList.EnterpriseList(self.driver).get_mailida_title() == '麦利达健康科技（上海）有限公司':
                self.logger.info(u'欢迎进入麦利达健康科技（上海）有限公司首页！')
                self.driver.back()
        except:
            self.driver.get_screenshot_as_file('D:/txls/src/result/errorScreenShot/mailida.png')
            self.logger.error(u'进入麦利达健康公司首页失败！')


    def testLeYuClick(self):
        try:
            time.sleep(4)
            enterpriseList.EnterpriseList(self.driver).leshare_click()
            time.sleep(2)
            enterpriseList.EnterpriseList(self.driver).swipeEnterpriseList()
            time.sleep(2)
            enterpriseList.EnterpriseList(self.driver).leyu_click()
            time.sleep(20)
            if enterpriseList.EnterpriseList(self.driver).get_leyu_title() == '乐语通讯 - 店铺首页':
                self.logger.info(u'欢迎进入乐语通讯店铺首页！')
                self.driver.back()
        except:
            self.driver.get_screenshot_as_file('D:/txls/src/result/errorScreenShot/leyu.png')
            self.logger.error(u'进入乐语通讯店铺失败！')



    def testViewAllClick(self):
        try:
            time.sleep(6)
            enterpriseList.EnterpriseList(self.driver).leshare_click()
            time.sleep(3)
            enterpriseList.EnterpriseList(self.driver).swipeEnterpriseList()
            time.sleep(2)
            enterpriseList.EnterpriseList(self.driver).viewall_click()
            time.sleep(15)
            if enterpriseList.EnterpriseList(self.driver).get_enterpriList_title() == '悦企业':
                self.logger.info(u'成功进入悦企业列表页！')
            else:
                self.logger.warning(u'进入悦企业列表页失败！')
            enterpriseList.EnterpriseList(self.driver).enterpriListMiaoHealthy_click()
            time.sleep(20)
            if enterpriseList.EnterpriseList(self.driver).get_miaoHealthy_title() == '妙健康-首页':
                self.logger.info(u'成功从悦企业列表进入妙健康公司首页！')
            else:
                self.logger.warning(u'从悦企业列表进入妙健康公司首页失败！')
        except:
            self.driver.get_screenshot_as_file('D:/txls/src/result/errorScreenShot/enterpriListMiaoHealthy.png')













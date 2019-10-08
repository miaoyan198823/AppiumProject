# -*- coding: utf-8 -*-
__author__ = 'miaoyan'


from selenium.webdriver.common.by import By
import sys

reload(sys)
sys.setdefaultencoding('utf8')

class EnterpriseList():
    def __init__(self,app_driver):
        self.driver = app_driver

    #定位导航【悦享】
    leshare_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'悦享')]")
    #定位纳塔力公司Title
    Natali_title_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'纳塔力健康管理咨询有限公司')]")
    #定位妙健康公司Title
    miaoHealthy_title_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'妙健康-首页')]")
    #定位凡迪基因公司Title
    fanDi_title_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'首页-凡迪基因')]")
    #定位欧西亚公司Title
    ouxiya_title_loc = (By.XPATH,"//android.widget.TextView[contians(@text,'欧西亚官方微店- 店铺主页')]")
    #定位麦利达公司Title
    mailida_title_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'麦利达健康科技（上海）有限公司')]")
    #定位乐语通讯公司Title
    leyu_title_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'店铺首页')]")
    #定位悦企业Title
    enterpri_title_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'悦企业')]")



    def find_element(self,*loc):
        return self.driver.find_element(*loc)

    #点击导航【悦享】
    def leshare_click(self):
        return self.driver.find_element(*self.leshare_loc).click()

    #点击进入纳塔里公司主页
    def natali_click(self):
        natali_X = 125
        natali_Y = 379
        return self.driver.tap([(natali_X,natali_Y)],5)


    #获取纳塔力公司主页Titile
    def get_natali_title(self):
        return self.driver.find_element(*self.Natali_title_loc).text

    #点击进入妙健康公司主页
    def miaoHealthy_click(self):
        miaoHealthy_X = 367
        miaoHealthy_Y = 395
        return self.driver.tap([(miaoHealthy_X,miaoHealthy_Y)],5)

    #获取妙健康公司主页Title
    def get_miaoHealthy_title(self):
        return self.driver.find_element(*self.miaoHealthy_title_loc).text

    #点击进入凡迪公司主页
    def fanDi_click(self):
        fanDi_X = 612
        fanDi_Y = 388
        return self.driver.tap([(fanDi_X,fanDi_Y)],5)

    #获取凡迪公司主页Title
    def get_fanDi_title(self):
        return self.driver.find_element(*self.fanDi_title_loc).text

    #点击进入欧西亚公司主页
    def ouxiya_click(self):
        ouxiya_X = 859
        ouxiya_Y = 388
        return self.driver.tap([(ouxiya_X,ouxiya_Y)],5)

    #获取欧西亚公司主页Title
    def get_ouxiya_title(self):
        return self.driver.find_element(*self.ouxiya_title_loc).text

    #点击进入麦利达健康公司主页
    def mailida_click(self):
        mailida_X = 201
        mailida_Y = 377
        return self.driver.tap([(mailida_X,mailida_Y)],5)

    #获取麦利达公司主页Title
    def get_mailida_title(self):
        return self.driver.find_element(*self.mailida_title_loc).text

    #点击进入乐语通讯店铺主页
    def leyu_click(self):
        leyu_X = 699
        leyu_Y = 386
        return self.driver.tap([(leyu_X,leyu_Y)],5)

    #获取乐语店铺主页Title
    def get_leyu_title(self):
        return self.driver.find_element(*self.leyu_title_loc).text

    #点击进入悦企业列表【查看全部】
    def viewall_click(self):
        viewall_X = 963
        viewall_Y = 376
        return self.driver.tap([(viewall_X,viewall_Y)],5)

    #获取余悦企业列表Title
    def get_enterpriList_title(self):
        return self.driver.find_element(*self.enterpri_title_loc).text

    #点击悦企业列表【妙健康】进入妙健康公司主页
    def enterpriListMiaoHealthy_click(self):
        return self.driver.find_element_by_accessibility_id('妙健康').click()


    def swipeEnterpriseList(self):
        X1 = 1057
        Y1 = 386
        X2 = 41
        Y2 = 406
        return self.driver.swipe(X1,Y1,X2,Y2,400)









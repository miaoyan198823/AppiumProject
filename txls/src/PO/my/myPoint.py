# -*- coding: utf-8 -*-
__author__ = 'miaoyan'


from selenium.webdriver.common.by import By

class MyPoint():
    def __init__(self,app_driver):
        self.driver = app_driver

    #定位我的页面【我的积分】
    my_point_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'我的积分')]")

    #定位我的积分页面【规则】
    rule_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'规则')]")

    #定位积分规则页面【积分规则】字样
    point_rule_text_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'积分规则')]")

    #定位我的积分页面【积分商城】按钮
    point_mall_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'积分商城')]")

    #定位我的积分页面【收入】Tap
    income_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'收入')]")

    #定位我的积分页面【支出】Tap
    expenditure_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'支出')]")

    #定位我的积分页面全部列表页【注册成功】积分记录
    login_success_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'注册成功')]")

    #定位我的积分页面全部列表页注册成功获得积分【+35】积分记录
    login_sucess_score_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'+35')]")


    def find_element(self,*loc):
        return self.driver.find_element(*loc)

    def my_point_click(self):
        return self.driver.find_element(*self.my_point_loc).click()

    def my_point_text(self):
        return self.driver.find_element(*self.my_point_loc).text

    def rule_click(self):
        return self.driver.find_element(*self.rule_loc).click()

    def point_rule_text(self):
        return self.driver.find_element(*self.point_rule_text_loc).text

    def point_mall_click(self):
        return self.driver.find_element(*self.point_mall_loc).click()

    def income_click(self):
        return self.driver.find_element(*self.income_loc).click()

    def expenditure_click(self):
        return self.driver.find_element(*self.expenditure_loc).click()

    #我积分列表，滑动到【注册成功】区域
    def login_success_swip(self):
        return  self.driver.swipe(548,1655,548,740,400)

    def login_success_text(self):
        return self.driver.find_element(*self.login_success_loc).text

    def login_success_score_text(self):
        return self.driver.find_element(*self.login_sucess_score_loc).text











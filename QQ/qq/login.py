# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

from selenium.webdriver.common.by import By
import time



class Login():
    def __init__(self,app_driver):
        self.driver = app_driver


    btn_login_loc = (By.ID,"com.tencent.mobileqq:id/btn_login")
    passwrod_loc = (By.ID,"com.tencent.mobileqq:id/password")
    login_loc = (By.ID,"com.tencent.mobileqq:id/login")


    def find_element(self,*loc):
        return self.driver.find_element(*loc)

    def btnLoginClick(self):
        return self.driver.find_element(*self.btn_login_loc).click()

    def userNameInputClear(self):
        return self.driver.find_element_by_android_uiautomator('new UiSelector().text("QQ号/手机号/邮箱")').clear()

    def userNameInput(self,userName):
        return self.driver.find_element_by_android_uiautomator('new UiSelector().text("QQ号/手机号/邮箱")').send_keys(userName)

    def passWordInputClear(self):
        return self.driver.find_element(*self.passwrod_loc).clear()

    def passWordInput(self,passWord):
        return self.driver.find_element(*self.passwrod_loc).send_keys(passWord)

    def loginClick(self):
        return self.driver.find_element(*self.login_loc).click()

    def userLogin(self,userName,passWord):
        # self.btnLoginClick()
        self.userNameInputClear()
        self.userNameInput(userName)
        self.passWordInputClear()
        self.passWordInput(passWord)
        self.loginClick()









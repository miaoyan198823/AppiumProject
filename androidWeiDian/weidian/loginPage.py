# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

from selenium.webdriver.common.by import By


class LoginPage(object):
    def __init__(self,app_driver):
        self.driver = app_driver

    #定位元素：
    username_loc = (By.ID,"com.lashou.weidian:id/user_et")
    password_loc = (By.ID,"com.lashou.weidian:id/password_et")
    submit_btn_loc = (By.ID,"com.lashou.weidian:id/login_bt")
    homepage_title_text_loc = (By.ID,"com.lashou.weidian:id/title_name")
    go_back_loc = (By.ID,"com.lashou.weidian:id/go_back")

    def find_element(self,*loc):
        return self.driver.find_element(*loc)

    def type_username_clear(self):
        return self.driver.find_element(*self.username_loc).clear()

    def type_username_input(self,userName):
        return self.driver.find_element(*self.username_loc).send_keys(userName)

    def type_password_clear(self):
        return self.driver.find_element(*self.password_loc).clear()

    def type_password_input(self,passWord):
        return self.driver.find_element(*self.password_loc).send_keys(passWord)

    def type_login_btn(self):
        return self.driver.find_element(*self.submit_btn_loc).click()

    def home_title_text(self):
        return self.driver.find_element(*self.homepage_title_text_loc).text

    def type_back_image_btn(self):
        return self.driver.find_element(*self.go_back_loc).click()
    def login_btn_text(self):
        return self.driver.find_element(*self.submit_btn_loc).text

    def user_login(self,userName,passWord):
        self.type_username_clear()
        self.type_username_input(userName)
        self.type_password_clear()
        self.type_password_input(passWord)
        self.type_login_btn()

    def user_loginout(self):
        self.type_back_image_btn()







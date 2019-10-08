# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

from selenium.webdriver.common.by import By
import  time


class LogOut():
    def __init__(self,app_driver):
        self.driver = app_driver


    #定位【我的】导航栏
    my_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'我的')]")

    #定位【账户设置】
    account_settings_loc = (By.ID,"com.lashou.cloud:id/rl_setting")

    #定位【退出登录】按钮
    loginout_btn_loc = (By.ID,"com.lashou.cloud:id/tv_login_out")

    #定位【确定】按钮
    confirm_btn_loc = (By.ID,"com.lashou.cloud:id/dialog_btn_right")

    #定位未登录页面【您还没有登录哦】页面文字
    loginout_assert_text_loc = (By.XPATH,"//android.widget.Button[contains(@text,'立即登录')]")

    def find_element(self,*loc):
        return self.driver.find_element(*loc)

    def my_click(self):
        return self.driver.find_element(*self.my_loc).click()

    def acount_setting_click(self):
        return self.driver.find_element(*self.account_settings_loc).click()

    def loginout_click(self):
        return self.driver.find_element(*self.loginout_btn_loc).click()

    def confirm_click(self):
        return self.driver.find_element(*self.confirm_btn_loc).click()

    def loginout_assert_text(self):
        return self.driver.find_element(*self.loginout_assert_text_loc).text


    def logout(self):
        self.my_click()
        self.acount_setting_click()
        self.loginout_click()
        time.sleep(3)
        self.confirm_click()




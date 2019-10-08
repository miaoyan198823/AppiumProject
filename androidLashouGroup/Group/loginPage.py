# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

from selenium.webdriver.common.by import By

class LoginPage(object):
    def __init__(self,app_driver):
        self.driver = app_driver


    # 定位用户登录按钮元素
    # btn_login_loc = (By.ID,"com.lashou.groupurchasing:id/bt_login")

    # 定位切换【账号登录】tap
    account_login_loc = (By.ID,"com.lashou.groupurchasing:id/tv_email_register")

    # 用户名输入框
    username_loc = (By.ID,"com.lashou.groupurchasing:id/username")

    # 密码输入框
    password_loc = (By.ID,"com.lashou.groupurchasing:id/password")

    # 定位登录页面登录按钮元素
    login_btn_loc = (By.ID,"com.lashou.groupurchasing:id/login_btn")

    #定位我的页面【更多】按钮
    arrow_more_btn_loc = (By.ID,"com.lashou.groupurchasing:id/iv_arrow_more")

    #定位登录成功验证信息
    tv_name_loc = (By.ID,"com.lashou.groupurchasing:id/tv_name")

    #定位未登录页面提示信息
    unlogin_notice_text_loc = (By.ID,"com.lashou.groupurchasing:id/tv_unlogin_notice")


    def find_element(self,*loc):
        return self.driver.find_element(*loc)

    #拉手团购APP底部导航栏【我的】
    def my_click(self):
        return self.driver.find_element_by_android_uiautomator('new UiSelector().text("我的")').click()

    #拉手团购App登录页面【点击登录】按钮
    def btn_login_click(self):
        return self.driver.find_element_by_android_uiautomator('new UiSelector().text("点击登录")').click()

    def account_login_tap_click(self):
        return self.driver.find_element(*self.account_login_loc).click()

    def username_input_clear(self):
        return self.driver.find_element(*self.username_loc).clear()

    def username_input(self,userName):
        return self.driver.find_element(*self.username_loc).send_keys(userName)

    def password_input_clear(self):
        return self.driver.find_element(*self.password_loc).clear()

    def password_input(self,passWord):
        return self.driver.find_element(*self.password_loc).send_keys(passWord)

    def login_btn_click(self):
        return self.driver.find_element(*self.login_btn_loc).click()

    def arrow_more_btn_click(self):
        return self.driver.find_element(*self.arrow_more_btn_loc).click()

    #拉手团购APP个人中心页面滑动查找【退出登录】按钮
    def logout_btn_click(self):
        return self.driver.find_element_by_android_uiautomator('new UiScrollable(new UiSelector().className("android.widget.ScrollView")).scrollIntoView(new UiSelector().textContains("退出登录"))').click()

    def user_login_assert_text(self):
        return self.driver.find_element(*self.tv_name_loc).text

    #退出登录二次确认弹窗【确定】按钮
    def user_logout_confirm_btn_click(self):
        return self.driver.find_element_by_android_uiautomator('new UiSelector().text("确定")').click()

    def user_unlogin_notice_text(self):
        return self.driver.find_element(*self.unlogin_notice_text_loc).text


    def user_login(self,userName,passWord):
        self.my_click()
        self.btn_login_click()
        self.account_login_tap_click()
        self.username_input_clear()
        self.username_input(userName)
        self.password_input_clear()
        self.password_input(passWord)
        self.login_btn_click()


    def user_logout(self):
        self.arrow_more_btn_click()
        self.logout_btn_click()
        self.user_logout_confirm_btn_click()
















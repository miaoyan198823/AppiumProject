# -*- coding: utf-8 -*-
__author__ = 'miaoyan'


from selenium.webdriver.common.by import By
import time

class Login():
    def __init__(self,app_driver):
        self.driver = app_driver

    #定位【我的】导航栏
    my_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'我的')]")

    #定位【立即登录】按钮
    now_loginbtn_loc = (By.ID,"com.lashou.cloud:id/btn_login")

    #定位【账号登录】按钮
    account_login_btn = (By.XPATH,"//android.widget.TextView[contains(@text,'账号登录')]")

    #定位【手机号码】输入框
    user_input_loc = (By.XPATH,"//android.widget.EditText[contains(@text,'请输入手机号')]")

    #定位【密码】输入框
    password_input_loc = (By.XPATH,"//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.EditText[1]")


    #定位【密码隐式】按钮功能
    password_show_loc = (By.ID,"com.lashou.cloud:id/iv_show_psw")

    #定位登录页面【登录】按钮
    login_btn_loc = (By.ID,"com.lashou.cloud:id/btn_login")

    #定位欢迎页面【立即体验】按钮
    now_experience_loc = (By.ID,"com.lashou.cloud:id/v_go")

    #定位登录成功用户用户名
    login_success_user_loc = (By.ID,"com.lashou.cloud:id/tv_user_name")


    def find_element(self,*loc):
        return self.driver.find_element(*loc)


    def my_click(self):
        return self.driver.find_element(*self.my_loc).click()

    def now_loginbtn_click(self):
        return self.driver.find_element(*self.now_loginbtn_loc).click()

    def account_loginBtn_click(self):
        return self.driver.find_element(*self.account_login_btn).click()

    def user_input_clear(self):
        return self.driver.find_element(*self.user_input_loc).clear()

    def user_input(self,userName):
        return self.driver.find_element(*self.user_input_loc).send_keys(userName)

    def password_input_clear(self):
        return self.driver.find_element(*self.user_input_loc).clear()

    def password_input(self,passWord):
        return self.driver.find_element(*self.password_input_loc).send_keys(passWord)

    def password_show_click(self):
        return self.driver.find_element(*self.password_show_loc).click()

    def login_btn_click(self):
        return self.driver.find_element(*self.login_btn_loc).click()

    def login_success_user_text(self):
        return self.driver.find_element(*self.login_success_user_loc).text

    def now_experience_btn_click(self):
        return self.driver.find_element(*self.now_experience_loc).click()



    def getelementPositionSwipe(self):
        #获取手机屏幕大小
        width = self.driver.get_window_size()['width']
        height = self.driver.get_window_size()['height']
        #第一个系统欢迎页面滑动
        self.driver.swipe(988,1177,95,1133,300)
        time.sleep(2)
        #第二张系统欢迎页滑动
        self.driver.swipe(963,1177,90,1130,300)
        self.now_experience_btn_click()

    def passWord_input_click(self):
        passWord_input_X = 576
        passWord_input_Y = 1031
        return self.driver.tap([passWord_input_X,passWord_input_Y],4)



    def login(self,userName,passWord):
        self.my_click()
        time.sleep(2)
        self.now_loginbtn_click()
        time.sleep(2)
        self.account_loginBtn_click()
        time.sleep(2)
        self.user_input(userName)
        self.password_input(passWord)
        self.login_btn_click()
        time.sleep(5)




















# -*- coding: utf-8 -*-
__author__ = 'miaoyan'


from selenium.webdriver.common.by import By
import time


class PersionalInfo():
    def __init__(self,app_driver):
        self.driver = app_driver


    #定位用户头像
    user_headimg_loc = (By.ID,"com.lashou.cloud:id/iv_user_headimg")

    #定位我的页面【用户名】内容
    user_name_loc = (By.ID,"com.lashou.cloud:id/tv_user_name")

    #定位用户昵称选项
    user_nickName_loc = (By.ID,"com.lashou.cloud:id/rl_change_name")

    #定位用户昵称输入框
    user_nickName_input_loc = (By.ID,"com.lashou.cloud:id/et_password")

    #定位昵称输入【确认】按钮
    user_nickName_input_confirm_loc = (By.ID,"com.lashou.cloud:id/btn_next")

    #定位生日选项
    user_birthday_loc = (By.ID,"com.lashou.cloud:id/rl_change_date")

    #定位生日信息元素定位
    user_birthday_text_loc = (By.ID,"com.lashou.cloud:id/tv_manage_date")

    #定位生日控件【确定】按钮
    user_birthday_confrim_btn_loc = (By.ID,"com.lashou.cloud:id/buttonsure")

    #定位性别选项
    user_sexy_loc = (By.ID,"com.lashou.cloud:id/rl_change_sex")

    #定位性别【男】
    user_sexy_man_loc = (By.ID,"com.lashou.cloud:id/tv_man")

    #定位已选性别【男】
    user_tv_sexy_loc = (By.ID,"com.lashou.cloud:id/tv_sex")



    def find_element(self,*loc):
        return self.driver.find_element(*loc)

    def user_headimg_click(self):
        return self.driver.find_element(*self.user_headimg_loc).click()

    def user_name_text(self):
        return self.driver.find_element(*self.user_name_loc).get_attribute("name")

    def user_nickName_click(self):
        return self.driver.find_element(*self.user_nickName_loc).click()

    def user_nickName_input_click(self):
        return self.driver.find_element(*self.user_nickName_input_loc).click()

    def get_nickName_input_text(self):
        return self.driver.find_element(*self.user_nickName_input_loc).get_attribute('name')

    def user_nickName_input_clear(self,text):
        # return self.driver.find_element(*self.user_nickName_input_loc).clear()
        self.driver.keyevent(123)
        for i in range(0,len(text)):
            self.driver.keyevent(67)

    def user_nickName_input(self,nickName):
        return self.driver.find_element(*self.user_nickName_input_loc).send_keys(nickName)

    def user_nickName_input_text(self):
        return self.driver.find_element(*self.user_nickName_loc).text

    def user_nickName_input_confirm_click(self):
        return self.driver.find_element(*self.user_nickName_input_confirm_loc).click()

    def user_birthday_click(self):
        return self.driver.find_element(*self.user_birthday_loc).click()

    def user_birthday_text(self):
        return self.driver.find_element(*self.user_birthday_text_loc).get_attribute("name")

    def user_birthday_confim_btn_click(self):
        return self.driver.find_element(*self.user_birthday_confrim_btn_loc).click()

    def userBirthdayConfig(self):
        Yx1 = 262
        Yy1 = 1615
        Yx2 = 172
        Yy2 = 1198
        Mx1 = 540
        My1 = 1649
        Mx2 = 526
        My2 = 1164
        Dx1 = 869
        Dy1 = 1610
        Dx2 = 859
        Dy2 = 1250
        self.driver.swipe(Yx1,Yy1,Yx2,Yy2,400)
        time.sleep(1)
        self.driver.swipe(Mx1,My1,Mx2,My2,400)
        time.sleep(1)
        self.driver.swipe(Dx1,Dy1,Dx2,Dy2,400)
        time.sleep(1)


    def user_sexy_click(self):
        return self.driver.find_element(*self.user_sexy_loc).click()

    def user_sexy_man_click(self):
        return self.driver.find_element(*self.user_sexy_man_loc).click()

    def user_sexy_man_text(self):
        return self.driver.find_element(*self.user_tv_sexy_loc).get_attribute("name")


















    




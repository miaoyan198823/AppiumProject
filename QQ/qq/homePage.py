# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

from selenium.webdriver.common.by import By
import base

class HomePage():
    def __init__(self,app_driver):
        self.driver = app_driver

    message_text_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'消息')]")


    def messageText(self):
        return base.find_element(*self.message_text_loc).text
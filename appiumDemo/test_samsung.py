# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

import time,os
from appium import webdriver


PATH = lambda p:os.path.abspath(
    os.path.join(os.path.dirname(__file__),p)
)


desired_caps = {}
desired_caps['device'] = 'android'
desired_caps['deviceName'] = '7e43a133'
desired_caps['platformName'] = 'Android'
desired_caps['platformVersion'] = '6.0.1'
desired_caps['app'] = PATH('D:\WeiDianApp-release.apk')
desired_caps['app-package'] = 'com.lashou.weidian'
desired_caps['app-activity'] = 'activity.login.MainActivity'
desired_caps['noReset'] = 'true'
desired_caps['unicodeKeyboard'] = 'true'
desired_caps['resetKeyboard'] = 'true'

driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',desired_caps)

driver.implicitly_wait(5)
user_text = driver.find_element_by_id("com.lashou.weidian:id/user_et")
user_text.clear()
user_text.send_keys("lashouceshi")

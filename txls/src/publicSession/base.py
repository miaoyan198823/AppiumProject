# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

import os
import time
from appium import webdriver


PATH = lambda p:os.path.abspath(
    os.path.join(os.path.dirname(__file__),p)
)


def setDevices():
    desired_caps = {
                    'deviceName':'192.168.96.101:5555',
                    'platformName':'Android',
                    'platfromVersion':'4.4',
                    'noSign':'True',
                    'app-package':'com.lashou.cloud',
                    'app-activity':'com.lashou.cloud.main.StartActivity',
                    'app':PATH('D:\\txls.apk'),
                    'noReset':'true',
                    'unicodeKeyboard':'true',
                    'resetKeyboard':'true'}
    return desired_caps


def clearCache():
    return os.popen('adb shell pm clear com.lashou.cloud')


def killProcess():
    return os.popen('adb shell am force-stop com.lashou.cloud')


def sleep(timeNum):
    return time.sleep(timeNum)



def get_driver():
    devices = ['deviceName1','deviceName2']
    for i in range(len(devices)):
        device = devices[i]
        url ='http://127.0.0.1:'+str(4723+i*2)+'/wd/hub'
        driver = webdriver.Remote(url,setDevices(device))
    return driver









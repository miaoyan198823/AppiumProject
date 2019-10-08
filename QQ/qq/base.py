# -*- coding: utf-8 -*-
__author__ = 'miaoyan'


import  os


PATH = lambda p:os.path.abspath(
    os.path.join(os.path.dirname(__file__),p)
)


def setDevice():
    desired_caps = {'device':'android',
                    'deviceName':'192.168.158.101:5555',
                    'platformName':'Android',
                    'platformVersion':'4.4',
                    'noSign':'true',
                    'app-package':'com.tencent.mobileqq',
                    'app-activity':'com.tencent.mobileqq.debug.DebugActivity',
                    'app':PATH('D:\QQ_692.apk'),
                    'noReset':'true',
                    'unicodeKeyboard':'true',
                    'resetKeyboard':'true'}
    return desired_caps


def find_element(*loc):
    return self.driver.find_element(*loc)

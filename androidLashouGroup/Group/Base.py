# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

import os

PATH = lambda p:os.path.abspath(
    os.path.join(os.path.dirname(__file__),p)
)


def setDevice():
    desired_caps = {'device':'android',
                    'deviceName':'192.168.209.101:5555',
                    'platformName':'Android',
                    'platformVersion':'4.4',
                    'noSign':'true',
                    'app-package':'com.lashou.groupurchasing',
                    'app-activity':'com.duoduo.widget.shareWidget.ShareToSina',
                    'app':PATH('D:\GroupPurchase.apk'),
                    'noReset':'true',
                    'unicodeKeyboard':'true',
                    'resetKeyboard':'true'}
    return desired_caps



#隐式等待方法：
def waitForElementIdPresent(driver,elementId,duration):
    try:
        if duration == None:
            duration = 30
        WebdriverWait(driver,duration).until(lambda driver:driver.find_element_by_id(elementId))
    except Exception,e:
        print e

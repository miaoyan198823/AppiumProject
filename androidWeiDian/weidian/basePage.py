# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

import os

PATH = lambda p:os.path.abspath(
    os.path.join(os.path.dirname(__file__),p)
)

def setDevice():
    desired_caps = {'device':'android',
                    'deviceName':'192.168.214.101:5555',
                    'platformName':'Android',
                    'platformVersion':'4.4',
                    'noSign':'true',
                    'app-package':'com.lashou.weidian',
                    'app-activity':'activity.login.MainActivity',
                    'app':PATH('D:\WeiDianApp-release.apk'),
                    'noReset':'true',
                    'unicodeKeyboard':'true',
                    'resetKeyboard':'true'}
    return desired_caps



# -*- coding: utf-8 -*-
__author__ = 'miaoyan'


from appium import webdriver
import threading
import os
import time

PATH = lambda p:os.path.abspath(
    os.path.join(os.path.dirname(__file__),p)
)

def de(i,device):
    desired_caps = {
                    'deviceName':device,
                    'platformName':'Android',
                    'platfromVersion':'4.4.4',
                    'noSign':'True',
                    'app-package':'com.lashou.cloud',
                    'app-activity':'com.lashou.cloud.main.StartActivity',
                    'app':PATH('D:\\txls.apk'),
                    # 'noReset':'true',
                    'unicodeKeyboard':'true',
                    'newCommandTimeout':7200,
                    'resetKeyboard':'true'}
    url = 'http://localhost:'+str(4723+i*2)+'/wd/hub'
    driver = webdriver.Remote(url,desired_caps)
    return driver



class MyThread(threading.Thread):
    def __init__(self,i,device):
        threading.Thread.__init__(self)
        self.i = i
        self.device = device

    def run(self):
        print "Starting" + self.name
        print "Exiting"  + self.name
        de(self.i,self.device)





data = ['71UBBLD225PP','192.168.96.101:5555']
for i in range(len(data)):
    t = MyThread(i,data[i])
    t.start()














# -*- coding: utf-8 -*-
__author__ = 'miaoyan'


import sys

reload(sys)
sys.setdefaultencoding('utf8')


class PublicMethod():
    def __init__(self,app_driver):
        self.driver = app_driver



    def swipeLeshare(self):
        X1 = 579.0
        Y1 = 1446.0
        X2= 613.0
        Y2 = 88.0
        return self.driver.swipe(X1,Y1,X2,Y2,400)


    def find_element(self,*loc):
        return self.driver.find_element(*loc)






# -*- coding: utf-8 -*-
__author__ = 'miaoyan'


from selenium.webdriver.common.by import By
import sys
from src.PO.leshare import publicMethod

reload(sys)
sys.setdefaultencoding('utf8')


class HappyMember():
    def __init__(self,app_driver):
        self.drvier = app_driver


    #定位积分商城页面Title
    integralMall_title_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'积分商城')]")


    #点击【悦会员】入口
    def happyMemberEnter_click(self):
        happyMemberEnter_X = 572
        happyMemberEnter_Y =  91
        return self.drvier.tap([(happyMemberEnter_X,happyMemberEnter_Y)],4)

    #获取积分商城Title
    def get_intrgralMall_title(self):
        return publicMethod.PublicMethod(self.drvier).find_element(*self.integralMall_title_loc).text


    #点击【积分撞大奖转盘】图片
    def turntable_click(self):
        turntable_X = 199
        turntable_Y = 354
        return self.drvier.tap([(turntable_X,turntable_Y)],4)

    #点击【1积分抽奖】图片
    def integralLottery_click(self):
        integralLottery_X = 529
        integralLottery_Y = 333
        return self.drvier.tap([(integralLottery_X,integralLottery_Y)],4)








# -*- coding: utf-8 -*-
__author__ = 'miaoyan'


from selenium.webdriver.common.by import By

class HotelReservation():
    def __init__(self,app_driver):
        self.driver = app_driver

    def find_element(self,*loc):
        return self.driver.find_element(*loc)


    #定位升级弹窗【关闭】按钮
    close_button = (By.ID,"com.lashou.groupurchasing:id/btn_close_upgrade")

    #定位酒店元素
    hotel_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'酒店')]")

    #定位酒店商家详情页，团购酒店价目
    hotel_detail_buy_items_loc = (By.XPATH,"android.widget.TextView[contaiins(@text,'【前门】北京盛堂居宾馆')]")

    #定位酒店详情页【立即购买】按钮
    buy_button_loc = (By.ID,"com.lashou.groupurchasing:id/btn_buy")


    def closeButtonClick(self):
        return self.driver.find_element(*self.close_button).click()

    def hotelClick(self):
        return self.driver.find_element(*self.hotel_loc).click()

    def hotelDetailClick(self):
        return self.driver.find_element_by_android_uiautomator('new UiScrollable(new UiSelector().className("android.widget.ListView")).scrollIntoView(new UiSelector().textContains("北京盛堂居宾馆"))').click()


    def hotelDetailBuyItems(self):
        return self.driver.find_element(*self.hotel_detail_buy_items_loc).click()

    def hotelDetailBuyButton(self):
        return self.driver.find_element(*self.hotel_detail_buy_items_loc).click()









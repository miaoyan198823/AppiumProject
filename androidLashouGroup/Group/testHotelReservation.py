# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

from appium import webdriver
import time
import Base
import loginPage
import homePage
import hotelReservation

class TestHotelReservation():
    global userName
    global passWord
    userName = '15101183723'
    passWord = 'miaoyan1989'

    def setUp(self):
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',Base.setDevice())
        self.driver.implicitly_wait(3)


    def tearDown(self):
        self.driver.quit()

    def testHotelReservation(self):
        time.sleep(6)
        hotelReservation.HotelReservation(self.driver).closeButtonClick()
        time.sleep(2)
        loginPage.LoginPage(self.driver).user_login(userName,passWord)
        time.sleep(2)
        homePage.HomePage(self.driver).homeCtvClick()
        hotelReservation.HotelReservation(self.driver).hotelClick()
        time.sleep(3)
        hotelReservation.HotelReservation(self.driver).hotelDetailClick()
        time.sleep(2)
        # hotelReservation.HotelReservation(self.driver).hotelDetailBuyItems()
        # time.sleep(2)





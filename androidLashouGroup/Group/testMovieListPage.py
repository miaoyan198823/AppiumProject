# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

from appium import webdriver
import time
import Base
import homePage
import movieListPage



class TestMovieListPage():
    def setUp(self):
        self.driver = webdriver.Remote('http://127.0.0.1:4723/wd/hub',Base.setDevice())
        self.driver.implicitly_wait(6)

    def tearDown(self):
        self.driver.quit()
    #
    # def testMovieistPage(self):
    #     time.sleep(3)
    #     homePage.HomePage(self.driver).openMovie()
    #     movieListPage.MovieListPage(self.driver).movieListPage()
    #     time.sleep(2)

    def testMoiveListPageIconClick(self):
        time.sleep(2)
        homePage.HomePage(self.driver).openMovie()
        time.sleep(2)
        movieListPage.MovieListPage(self.driver).movieListPageIconClick()
        time.sleep(2)







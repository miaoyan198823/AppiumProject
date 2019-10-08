# -*- coding: utf-8 -*-
__author__ = 'miaoyan'


from selenium.webdriver.common.by import By


class CreateSceneAccount(object):
    def __init__(self,app_driver):
        self.driver = app_driver


    #定位我的页面【我的场景号】
    mySceneAccount_loc = (By.ID,"com.lashou.cloud:id/my_scene")

    #定位创建场景号页面【创建场景号】按钮
    createSceneAccountBtn_loc = (By.ID,"com.lashou.cloud:id/iv_create_scene_account")

    #定位创建场景号页面【+选择封面】按钮
    selectCover_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'+ 选择封面')]")

    #定位封面图片
    coverImg_loc = (By.XPATH,"//android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[3]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ImageView[1]")

    #定位选择封面页面【确认】按钮
    coverConfimBtn_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'确定')]")

    #定位场景号名称输入框
    sceneAccountNameInput_loc = (By.ID,"com.lashou.cloud:id/et_title")

    #定位场景号描述信息输入框
    sceneAccountDescInput_loc = (By.ID,"com.lashou.cloud:id/et_desc")

    #定位应用场景选择
    sceneSelect_loc = (By.ID,"com.lashou.cloud:id/layout_add_application_scenarios")

    #定位切换场景页面场景
    recommendScene_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'南京新百')]")

    #定位【下一步】按钮
    nextBtn_loc = (By.XPATH,"//android.widget.TextView[contains(@text,'下一步')]")















    def find_element(self,*loc):
        return self.driver.find_element(*loc)


    def mySceneAccount_click(self):
        return self.driver.find_element(*self.mySceneAccount_loc).click()

    def createBtn_click(self):
        return self.driver.find_element(*self.createSceneAccountBtn_loc).click()

    def selectCover_click(self):
        return self.driver.find_element(*self.selectCover_loc).click()

    def selectCoverImg_click(self):
        return self.driver.find_element(*self.coverImg_loc).click()

    def coverConfirmBtn_click(self):
        return self.driver.find_element(*self.coverConfimBtn_loc).click()

    def sceneAsscountName_input(self,sceneAccountName):
        return self.driver.find_element(*self.sceneAccountNameInput_loc).send_keys(sceneAccountName)

    def sceneAccountDesc_input(self,sceneAccountDesc):
        return self.driver.find_element(*self.sceneAccountDescInput_loc).send_keys(sceneAccountDesc)

    def sceneSelect_click(self):
        return self.driver.find_element(*self.sceneSelect_loc).click()

    def recommendScene_click(self):
        return self.driver.find_element(*self.recommendScene_loc).click()

    def nextBtn_click(self):
        return self.driver.find_element(*self.nextBtn_loc).click()
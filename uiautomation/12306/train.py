# -*- coding: utf-8 -*-
__author__ = 'miaoyan'

import requests
import urllib


headers = {}
headers['User-Agent'] = 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36'
headers['Accept'] = 'application/json, text/javascript, */*; q=0.0'
headers['X-Requested-With'] = 'X-Requested-With'
headers['Content-Type'] = 'application/x-www-form-urlencoded; charset=UTF-8'
headers['Accept-Encoding'] = 'gzip, deflate,br'
headers['Origin'] = 'https://kyfw.12306.cn'
headers['Referer'] = 'https://kyfw.12306.cn/otn/login/init'


class Train(object):

    def __init__(self):
        self.rsession = requests.session()
        self.rsession.verify = False


    def changeNum(self,Num):
        strs = ''
        login_pic_position = ['36,31','103,36','201,51','249,42','41,114','103,115','190,121','278,122']
        for k,v in enumerate(Num):
            v = int(v)
            if k == 0:
                strs = strs + login_pic_position[v-1]
            else:
                strs = strs + ','+ login_pic_position[v-1]
        return strs



    def getLoginPic(self):
        url = "https://kyfw.12306.cn/passport/captcha/captcha-image?login_site=E&module=login&rand=sjrand&0.00453273863524716"
        res = self.rsession.get(url)
        with open('getPic.png','wb') as f:
            f.write(res.content)

    def loginPicAuth(self):
        url = "https://kyfw.12306.cn/passport/captcha/captcha-check"
        userinput = raw_input('输入验证码：').strip()
        user_input = self.changeNum(userinput)
        userInput = urllib.quote(user_input)
        par = 'answer=%s&login_site=E&rand=sjran'%userInput
        # data = {
        #     'answer':'%s'%userInput,
        #     'login_site':'E',
        #     'rand':'sjran'
        # }
        content = self.rsession.post(url,headers=headers,data=par)
        print(content.text)





if __name__ == '__main__':
    t = Train()
    t.getLoginPic()
    t.loginPicAuth()

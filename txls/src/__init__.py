    # -*- coding: utf-8 -*-
__author__ = 'miaoyan'

import logging
import logging.config
import logging.handlers
import sys
import os

reload(sys)
sys.setdefaultencoding('utf8')

# cwdDir = os.getcwd()
# configDir = os.path.join(cwdDir,"config")
# envDir = os.path.join(configDir,"env")
# logConfigFilePath = os.path.join(envDir,"log.conf")


#logging去读取log.conf文件
logging.config.fileConfig("D:/txls/src/config/env/log.conf")
logger = logging.getLogger(__name__)

#定义系统当前时间
# curTime = time.strftime('%Y%m%d%H%M%S',time.localtime())
# #定义log文件输入格式按当前系统时间输出
# logFile = os.path.abspath(os.path.join(os.getcwd(),'log','log_{}.log'.format(curTime)))
# handler = logging.handlers.RotatingFileHandler(logFile,maxBytes=4096000000,backupCount=9)
#重新传入日志格式
# fmt = '[%(asctime)s](%(levelname)s)%(name)s : %(message)s'
# formartter = logging.Formatter(fmt)
# handler.setFormatter(formartter)
# logger.addHandler(handler)

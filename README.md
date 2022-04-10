# XDUcat

#### 介绍
2022web工程-西电流浪猫之家

#### 第二次提交
使用@vue/cli 5.0.4,elementPlus,vue-router,axios
全新版本

 **2022.4.8说明**   
springboot部分的代码在“/ xducat-server / src / main / java / com / web / xducatserver”下  

其中Entity是实体类，和数据库的表对应。  
Repository里可以写自己的sql语句  
controller中可以通过浏览器访问相应地址得到数据  
config是解决跨域问题的  
我想应该是即开即用的。如果不行，参考[这个视频](https://www.bilibili.com/video/BV137411B7vB)中p1的使用方法重新配置并copy代码。(当然你可以选择只写前端)    


vue的部分是“ xducat/ xducat-client / src”  

其中router是放路由信息的  
App.vue具有路由导航和搜索模块
views中，HomeView是主页，LoginView是登录界面，ManageView是管理员使用的后台界面，NotFoundView是404页面，RefreshView是刷新搜索结果使用的过渡页面，SearchResult是搜索猫咪得到的结果页面   
如果npm run serve说你缺module，请尝试安装它   

**2022.4.9更新说明**    
更新了mysql文件，其中cat表新增一个img属性，存放对应猫咪图片的文件名。猫咪图片请放在“xducat-client\img\catProfile”目录下。    

**2022.4.10更新说明**     
在mysql里增加了一个comment表，存储了留言信息。增加了留言功能。   
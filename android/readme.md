# 
一种电影院在线售票系统，网站用来为用户显示电影信息的。web的主要用途是作为系统管理员的系统后台，
在这里可以查看和编辑电影院的所有信息。android应用可以让用户浏览电影信息，
查看放映信息，最重要的是买票。

用户端
i.查看电影详情(简介、证书、导演、主演)
2观看电影放映(日期、时间、电影院屏幕)
3购买成人，儿童(16岁以下，如果
适合证书)或高级(年龄>=65岁，折扣)
4办理购票现金支付(模拟)
5储存门票，并在我的购票列表中显示。
6用户注册登录功能
7.通过关键字或日期搜索电影/放映
8，用户端添加选座功能


管理员:（web端）
1查看每周收入，整体和每部电影
2用给定时间内售出的电影票数量来比较电影
3.上架新电影，供用户选择
4支持用户帐号和用户登录
5.通过关键字或日期搜索电影/放映
6.设置排座 不同影厅不同的排座 
7.管理员可以添加多个电影院供用户选择（多对多关系，多个用户对应多个应用）

服务端：
Mysql数据库存放数据

其他：写测试函数，备注，只是写函数，不显示具体功能

多对多模型（多家影院对应多个用户，管理员负责管理两边的数据传输与服务流程）(可选)、界面美观
（该系统是一个为2-3个电影院和想在线购买电影票的客户提供服务的网站。你必须为客户开发手机应用程序，
为每个电影院开发主页系统，为网站开发主页系统（网站内容基本相同）
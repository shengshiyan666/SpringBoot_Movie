
-- 电影票信息
CREATE TABLE IF NOT EXISTS `movie_info`(
  `id` bigint(20) UNSIGNED NOT NULL  AUTO_INCREMENT,
  `movieName` varchar(30) NOT NULL COMMENT '电影名称',
  `author` varchar(30) NOT NULL COMMENT '导演',
  `awards` varchar(250) NOT NULL COMMENT '证书，奖项',
  `actor` varchar(30) NOT NULL COMMENT '演员',
  `movieDesc` varchar(30) NOT NULL COMMENT '简介',
  `movieImgUrl` text NOT NULL COMMENT '电影图片信息',
  `movieLocation` varchar(30) NOT NULL COMMENT '电影院地址',
  `startTime` varchar(30) NOT NULL COMMENT '上映日期',
  `rowAndColumValue` varchar(30) NOT NULL COMMENT '排座信息',
  `ticketCount` int(30) NOT NULL COMMENT '票数',
  `sellCount` int(30) NOT NULL COMMENT '售出票数',
  `ticketMoney` double NOT NULL COMMENT '票价',
  `seatInfoStr` text  COMMENT '座位信息',
  `createAt` varchar(60) DEFAULT NULL COMMENT '创建时间',
  `updateAt` varchar(60) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
)ENGINE =InnoDB DEFAULT charset =utf8 COMMENT='电影票信息'



-- 用户信息
CREATE TABLE IF NOT EXISTS  `user`(
    `id` bigint(20) UNSIGNED NOT NULL  AUTO_INCREMENT,
    `userName` varchar (20) NOT NULL COMMENT '用户名',
    `passWord` varchar (20) NOT NULL COMMENT '密码',
    `age` int NOT NULL DEFAULT 0 COMMENT '年龄',
    `isBlack` int NOT NULL DEFAULT 0 COMMENT '是否黑名单',
    `isVip` int NOT NULL DEFAULT 0 COMMENT '是否为vip用户',
    PRIMARY KEY (`id`)
)ENGINE =InnoDB DEFAULT charset =utf8 COMMENT='用户信息'


--
CREATE TABLE IF NOT EXISTS  `comment`(
    `id` bigint(20) UNSIGNED NOT NULL  AUTO_INCREMENT,
    `userName` varchar (20) NOT NULL COMMENT '用户名',
    `appInfoId` bigint(20) NOT NULL COMMENT 'app信息id',
    `userId` bigint(20) NOT NULL COMMENT '用户ID',
    `comment` text COMMENT '评论信息',
    `createAt` varchar(60) DEFAULT NULL COMMENT '创建时间',
    `updateAt` varchar(60) DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
)ENGINE =InnoDB DEFAULT charset =utf8 COMMENT='评论'


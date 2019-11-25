/*
Navicat MySQL Data Transfer

Source Server         : UBUNTU
Source Server Version : 50727
Source Host           : 192.168.177.129:3306
Source Database       : jsfwlt

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-11-25 16:40:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for topic_comment
-- ----------------------------
DROP TABLE IF EXISTS `topic_comment`;
CREATE TABLE `topic_comment` (
  `comment_id` varchar(6) NOT NULL COMMENT '评论的id',
  `comment_content` varchar(255) DEFAULT NULL COMMENT '评论的内容',
  `comment_time` datetime DEFAULT NULL,
  `user_id` varchar(6) NOT NULL COMMENT '用户id',
  `user_nickname` varchar(6) NOT NULL COMMENT '用户名',
  `zan` int(4) DEFAULT NULL COMMENT '赞的数量',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of topic_comment
-- ----------------------------

-- ----------------------------
-- Table structure for topic_detail
-- ----------------------------
DROP TABLE IF EXISTS `topic_detail`;
CREATE TABLE `topic_detail` (
  `topic_children_id` varchar(9) NOT NULL COMMENT '话题的id',
  `content` varchar(500) DEFAULT NULL COMMENT '话题内容',
  `creation_time` datetime DEFAULT NULL COMMENT '话题创建时间',
  `modification_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `topic_id` varchar(9) NOT NULL,
  `comment_id` varchar(9) DEFAULT NULL COMMENT '评论的id',
  `user_id` varchar(9) NOT NULL COMMENT '用户id',
  `user_nickname` varchar(6) NOT NULL COMMENT '用户名',
  `like_number` int(11) DEFAULT NULL COMMENT '赞的数量',
  `dislike_number` int(11) DEFAULT NULL COMMENT '点踩数量',
  PRIMARY KEY (`topic_children_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='吐槽话题详情表';

-- ----------------------------
-- Records of topic_detail
-- ----------------------------

-- ----------------------------
-- Table structure for tucao_topic
-- ----------------------------
DROP TABLE IF EXISTS `tucao_topic`;
CREATE TABLE `tucao_topic` (
  `topic_id` varchar(9) NOT NULL COMMENT '吐槽信息id，作为主键',
  `title` varchar(100) NOT NULL COMMENT '吐槽标题',
  `content` varchar(500) NOT NULL COMMENT '吐槽内容',
  `comment_number` int(11) DEFAULT NULL COMMENT '评论数量',
  `like_number` int(11) DEFAULT NULL COMMENT '点赞数量',
  `dislike_number` int(11) DEFAULT NULL COMMENT '点踩数量',
  `image_url` varchar(45) DEFAULT NULL COMMENT '图片地址',
  `user_id` varchar(9) DEFAULT NULL COMMENT '发表吐槽的用户id',
  PRIMARY KEY (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='吐槽信息表';

-- ----------------------------
-- Records of tucao_topic
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` varchar(9) NOT NULL COMMENT '用户ID，作为主键',
  `user_nickname` varchar(6) NOT NULL COMMENT '用户名',
  `user_password` varchar(45) NOT NULL COMMENT '用户密码，以密文形式存储',
  `user_phone` varchar(20) DEFAULT NULL COMMENT '用户电话',
  `user_email` varchar(20) DEFAULT NULL COMMENT '用户邮箱',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user_info
-- ----------------------------

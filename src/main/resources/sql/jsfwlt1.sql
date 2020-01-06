/*
 Navicat Premium Data Transfer

 Source Server         : 京东云
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : 116.196.100.50:3306
 Source Schema         : jsfwlt

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 02/01/2020 15:44:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment_reply
-- ----------------------------
DROP TABLE IF EXISTS `comment_reply`;
CREATE TABLE `comment_reply`
(
    `reply_id`       int auto_increment NOT NULL COMMENT '回复评论的id',
    `reply_content`  varchar(300)       NULL DEFAULT NULL COMMENT '回复的内容',
    `reply_to_name`  varchar(30)        NULL DEFAULT NULL COMMENT '回复对象',
    `reply_to_id`    int                NULL DEFAULT NULL COMMENT '回复对象的id',
    `comment_id`     int                NULL DEFAULT NULL COMMENT '所属评论的id',
    `user_id`        int                NULL DEFAULT NULL COMMENT '用户id',
    `user_nickname`  varchar(30)        NULL DEFAULT NULL COMMENT '用户昵称',
    `like_number`    int                NULL DEFAULT NULL COMMENT '点赞数量',
    `dislike_number` int                NULL DEFAULT NULL COMMENT '踩的数量',
    logic_delete     bool comment '逻辑删除',
    `create_time`    datetime           NULL DEFAULT NULL COMMENT '创建时间',
    `modify_time`    datetime           NULL DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`reply_id`)
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '评论回复表'
  ROW_FORMAT = Dynamic
    comment '评论回复';

-- ----------------------------
-- Table structure for login_token
-- ----------------------------
DROP TABLE IF EXISTS `login_token`;
CREATE TABLE `login_token`
(
    `id`      int         NOT NULL AUTO_INCREMENT,
    `user_id` int         NOT NULL,
    `token`   varchar(45) NOT NULL,
    `expired` datetime(0) NOT NULL,
    `status`  int         NULL DEFAULT 0,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `ticket_UNIQUE` (`token`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 26
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for topic_answer
-- ----------------------------
DROP TABLE IF EXISTS `topic_answer`;
CREATE TABLE `topic_answer`
(
    `topic_answer_id` int auto_increment NOT NULL COMMENT '回答的id',
    `content`         varchar(1500)      NULL DEFAULT NULL COMMENT '回答内容',
    `topic_id`        int                NOT NULL comment '话题id',
    `user_id`         int                NOT NULL COMMENT '用户id',
    `user_nickname`   varchar(30)        NOT NULL COMMENT '用户名',
    `like_number`     int                NULL DEFAULT NULL COMMENT '赞的数量',
    `dislike_number`  int                NULL DEFAULT NULL COMMENT '点踩数量',
    logic_delete      bool comment '逻辑删除',
    `create_time`     datetime           NULL DEFAULT NULL COMMENT '回答创建时间',
    `modify_time`     datetime           NULL DEFAULT NULL COMMENT '回答最后修改时间',
    PRIMARY KEY (`topic_answer_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic
    comment '话题回答详情表';

-- ----------------------------
-- Table structure for topic_answer_comment
-- ----------------------------
DROP TABLE IF EXISTS `topic_answer_comment`;
CREATE TABLE `topic_answer_comment`
(
    `comment_id`      int auto_increment                                     NOT NULL comment '评论id',
    `comment_content` varchar(300)                                           NULL DEFAULT NULL comment '评论内容',
    `topic_answer_id` int                                                    NULL DEFAULT NULL comment '回答id',
    `user_id`         int                                                    NULL DEFAULT NULL,
    `user_nickname`   varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `like_number`     int                                                    NULL DEFAULT NULL,
    `dislike_number`  int                                                    NULL DEFAULT NULL,
    logic_delete      bool comment '逻辑删除',
    `create_time`     datetime                                               NULL DEFAULT NULL COMMENT '创建时间',
    `modify_time`     datetime                                               NULL DEFAULT NULL COMMENT '最后修改时间',
    PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic
    comment '回答评论表';

-- ----------------------------
-- Table structure for tucao_topic
-- ----------------------------
DROP TABLE IF EXISTS `roast_topic`;
CREATE TABLE `roast_topic`
(
    `topic_id`         int auto_increment                                      NOT NULL COMMENT '吐槽信息id，作为主键',
    `title`            varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '吐槽标题',
    `content_abstract` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '吐槽内容简介',
    content_id         int comment '全部内容的id',
    `comment_number`   int                                                     NULL DEFAULT NULL COMMENT '评论数量',
    `like_number`      int                                                     NULL DEFAULT NULL COMMENT '点赞数量',
    `dislike_number`   int                                                     NULL DEFAULT NULL COMMENT '点踩数量',
    `image_url`        varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
    `user_id`          int                                                     NULL DEFAULT NULL COMMENT '发表吐槽的用户id',
    user_nickname      varchar(30) comment '用户昵称',
    logic_delete       bool comment '逻辑删除',
    `create_time`      datetime                                                NULL DEFAULT NULL,
    `modify_time`      datetime                                                NULL DEFAULT NULL,
    PRIMARY KEY (`topic_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '吐槽信息表'
  ROW_FORMAT = Dynamic
    comment '话题详情表';

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`
(
    `user_id`       int auto_increment                                     NOT NULL COMMENT '用户ID，作为主键',
    user_name       varchar(30) comment '用户真名',
    `user_nickname` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
    `user_password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码，以密文形式存储',
    `user_phone`    varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户电话',
    `user_email`    varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
    create_time     datetime,
    modify_time     datetime,
    PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '用户表'
  ROW_FORMAT = Dynamic
    comment '用户详情表';

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `topic_content`;
create table topic_content
(
    content_id    int auto_increment not null comment '话题内容的Id',
    content       varchar(1500),
    logic_delete  bool comment '逻辑删除',
    `create_time` datetime           NULL DEFAULT NULL COMMENT '创建时间',
    `modify_time` datetime           NULL DEFAULT NULL COMMENT '最后修改时间',
    primary key (content_id)
) comment '内容详情表';

SET FOREIGN_KEY_CHECKS = 1;


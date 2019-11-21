/*
Navicat MySQL Data Transfer

Source Server         : UBUNTU
Source Server Version : 50727
Source Host           : 192.168.177.129:3306
Source Database       : jsfwlt

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-11-21 11:14:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `tid` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(5) DEFAULT NULL,
  `age` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', '1', '2');
INSERT INTO `test` VALUES ('2', '3', '4');
INSERT INTO `test` VALUES ('3', '1', '2');
INSERT INTO `test` VALUES ('4', '3', '4');
INSERT INTO `test` VALUES ('5', '1', '2');
INSERT INTO `test` VALUES ('6', '3', '4');

-- ----------------------------
-- Table structure for test2
-- ----------------------------
DROP TABLE IF EXISTS `test2`;
CREATE TABLE `test2` (
  `tid` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(5) DEFAULT NULL,
  `age` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of test2
-- ----------------------------
INSERT INTO `test2` VALUES ('1', '1', '2');
INSERT INTO `test2` VALUES ('2', '3', '4');

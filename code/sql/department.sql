/*
Navicat MySQL Data Transfer

Source Server         : mySQL
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : todolist

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-10-13 22:45:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('0', '未填');
INSERT INTO `department` VALUES ('1', '党群办');
INSERT INTO `department` VALUES ('2', '办公室');
INSERT INTO `department` VALUES ('3', '技术科');
INSERT INTO `department` VALUES ('4', '安全质量科(安全)');
INSERT INTO `department` VALUES ('5', '安全质量科(质检)');
INSERT INTO `department` VALUES ('6', '调度科');
INSERT INTO `department` VALUES ('7', '计划财务科');
INSERT INTO `department` VALUES ('8', '劳动人事科');
INSERT INTO `department` VALUES ('9', '职工教育科');
INSERT INTO `department` VALUES ('10', '驻段验收室');
INSERT INTO `department` VALUES ('11', '材料科');
INSERT INTO `department` VALUES ('12', '武装保卫科');
INSERT INTO `department` VALUES ('13', '经营开发部');
INSERT INTO `department` VALUES ('14', '杭州设备车间');
INSERT INTO `department` VALUES ('15', '乔司检修车间');
INSERT INTO `department` VALUES ('999', '其他');

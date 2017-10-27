/*
Navicat MySQL Data Transfer

Source Server         : mySQL
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : todolist

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-10-13 22:45:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dining_statistics`
-- ----------------------------
DROP TABLE IF EXISTS `dining_statistics`;
CREATE TABLE `dining_statistics` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `date` char(30) DEFAULT NULL,
  `br_num` int(10) DEFAULT NULL,
  `lu_num` int(10) DEFAULT NULL,
  `di_num` int(10) DEFAULT NULL,
  `dep_id` int(10) DEFAULT NULL,
  `content` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dep_id` (`dep_id`),
  CONSTRAINT `dining_statistics_ibfk_1` FOREIGN KEY (`dep_id`) REFERENCES `department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dining_statistics
-- ----------------------------
INSERT INTO `dining_statistics` VALUES ('1', '2017-10-12 20:52:21', '1', '1', '1', '3', '');
INSERT INTO `dining_statistics` VALUES ('2', '2017-10-12 22:51:03', '1', '1', '1', '0', '');
INSERT INTO `dining_statistics` VALUES ('3', '2017-10-19 00:00:00', '1', '1', '1', '1', '');
INSERT INTO `dining_statistics` VALUES ('4', '2017-10-12 22:52:50', '1', '1', '1', '0', '');
INSERT INTO `dining_statistics` VALUES ('5', '2017-10-12 00:00:00', '1', '1', '1', '0', '');
INSERT INTO `dining_statistics` VALUES ('6', '2017-10-19 00:00:00', '1', '1', '1', '0', '');
INSERT INTO `dining_statistics` VALUES ('7', '2017-10-12 00:00:00', '5', '7', '9', '2', '今天吃饭的人很多');
INSERT INTO `dining_statistics` VALUES ('8', '2017-10-12 00:00:00', '1', '1', '1', '3', '');
INSERT INTO `dining_statistics` VALUES ('9', 'Invalid Date', '1', '1', '1', '0', '');
INSERT INTO `dining_statistics` VALUES ('10', 'Invalid Date', '1', '1', '1', null, null);
INSERT INTO `dining_statistics` VALUES ('11', '2017-10-13 00:00:00', '7', '9', '7', '2', null);
INSERT INTO `dining_statistics` VALUES ('12', '2017-10-13 00:00:00', '7', '7', '8', '3', null);
INSERT INTO `dining_statistics` VALUES ('13', '2017-10-19 00:00:00', '9', '9', '7', '6', null);
INSERT INTO `dining_statistics` VALUES ('14', '2017-10-13 00:00:00', '4', '4', '4', '2', null);
INSERT INTO `dining_statistics` VALUES ('15', '2017-10-19 00:00:00', '8', '9', '8', '3', null);
INSERT INTO `dining_statistics` VALUES ('16', '2017-10-13 00:00:00', '8', '8', '6', '1', null);
INSERT INTO `dining_statistics` VALUES ('17', '2017-10-13 00:00:00', '7', '6', '5', '3', null);
INSERT INTO `dining_statistics` VALUES ('18', '2017-10-13 00:00:00', '5', '5', '6', '4', null);

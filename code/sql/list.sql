/*
Navicat MySQL Data Transfer

Source Server         : mySQL
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : todolist

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-10-13 22:45:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `list`
-- ----------------------------
DROP TABLE IF EXISTS `list`;
CREATE TABLE `list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` char(255) DEFAULT NULL,
  `name` char(20) DEFAULT NULL,
  `dep_id` int(10) DEFAULT NULL,
  `date` char(30) DEFAULT NULL,
  `number` int(3) DEFAULT NULL,
  `status` tinyint(1) unsigned zerofill DEFAULT NULL,
  `diningform` varchar(20) DEFAULT NULL,
  `phone` int(20) DEFAULT NULL,
  `standard` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `department` (`dep_id`),
  CONSTRAINT `list_ibfk_1` FOREIGN KEY (`dep_id`) REFERENCES `department` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of list
-- ----------------------------
INSERT INTO `list` VALUES ('2', '', 'aa', '1', '2017-10-11 15:26:11', '1', '1', '托盘', '0', null);
INSERT INTO `list` VALUES ('4', '', '士大夫', '2', 'Invalid Date', '1', '1', '', '0', null);
INSERT INTO `list` VALUES ('5', '', '', '3', '2017-10-11 19:35:34', '1', '1', '', '0', null);
INSERT INTO `list` VALUES ('6', '', '阿斯蒂芬', '4', '2017-10-12 12:35:41', '1', '1', '餐桌', '147483647', null);
INSERT INTO `list` VALUES ('7', '', '', '5', 'Invalid Date', '1', '1', '', '1568635483', null);
INSERT INTO `list` VALUES ('8', '', 'sadf', '6', 'Invalid Date', '1', '1', '托盘', '0', null);
INSERT INTO `list` VALUES ('9', '', '56465', '6', '2017-10-12 14:45:11', '1', '1', '餐桌', '2147483647', null);
INSERT INTO `list` VALUES ('10', '', '12', '1', '2017-10-12 14:52:07', '5', '1', '餐桌', '12', null);
INSERT INTO `list` VALUES ('11', '', '士大夫', '2', '2017-10-12 15:51:48', '4', '1', '餐桌', '0', null);
INSERT INTO `list` VALUES ('12', '', '12', '3', '2017-10-12 16:06:06', '1', '1', '餐桌', '0', '300');
INSERT INTO `list` VALUES ('13', '', '', '1', 'Invalid Date', '1', '1', '', '0', '0');
INSERT INTO `list` VALUES ('14', '', '', '3', 'Invalid Date', '1', '1', '', '0', '0');
INSERT INTO `list` VALUES ('15', '', '', '5', 'Invalid Date', '1', '1', '', '0', '0');
INSERT INTO `list` VALUES ('16', '', null, '8', 'Invalid Date', null, null, null, null, null);
INSERT INTO `list` VALUES ('17', null, null, '5', 'Invalid Date', '1', '1', null, null, '1555');
INSERT INTO `list` VALUES ('18', null, null, '6', '2017-10-13 10:44:48', '1', '1', '餐桌', null, '6');
INSERT INTO `list` VALUES ('19', null, '水岸东方', '1', '2017-10-13 13:45:23', '8', '1', '餐桌', '2147483647', '6');
INSERT INTO `list` VALUES ('20', null, '水岸东方', '2', '2017-10-13 14:10:21', '1', '1', '餐桌', '2147483647', '7');
INSERT INTO `list` VALUES ('21', null, '地方睡', '4', '2017-10-13 15:13:29', '9', '1', '餐桌', '32435', '600');

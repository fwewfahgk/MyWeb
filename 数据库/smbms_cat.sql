/*
 Navicat Premium Data Transfer

 Source Server         : juice
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : smbms

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 16/06/2023 09:27:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for smbms_cat
-- ----------------------------
DROP TABLE IF EXISTS `smbms_cat`;
CREATE TABLE `smbms_cat`  (
  `catnum` int(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `breed` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NULL DEFAULT NULL,
  `age` int(0) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NULL DEFAULT NULL,
  `character` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`catnum`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of smbms_cat
-- ----------------------------
INSERT INTO `smbms_cat` VALUES (1, '月饼', '暹罗猫', '母', 3, '操场', '较为乖巧');
INSERT INTO `smbms_cat` VALUES (2, '汤圆', '狸花猫', '公', 2, '操场', '乖巧');
INSERT INTO `smbms_cat` VALUES (3, '糯米', '奶牛猫', '公', 3, '东门', '暴躁');
INSERT INTO `smbms_cat` VALUES (4, '菠萝', '橘猫', '公', 2, '食堂', '挠人');
INSERT INTO `smbms_cat` VALUES (5, '西瓜', '橘猫', '母', 2, '食堂', '黏人');
INSERT INTO `smbms_cat` VALUES (7, '7', '狮子猫', '公', 3, '校门', '独立');

SET FOREIGN_KEY_CHECKS = 1;

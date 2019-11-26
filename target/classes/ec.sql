
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_sn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源编号',
  `resource_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源名称',
  `resource_type` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源类型',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源url',
  `parent_resource_sn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父级资源编号',
  `has_menu_children` bit(1) NOT NULL COMMENT '有子项',
  `show_sequence` int(11) NOT NULL COMMENT '显示顺序',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除状态',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk[resource]resource_sn`(`resource_sn`) USING BTREE,
  INDEX `fk[resource]parent_resource_sn`(`parent_resource_sn`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 448 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_sn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色编号',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '删除状态',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk[role]role_sn`(`role_sn`) USING BTREE,
  UNIQUE INDEX `UKt2lcmkirxrwsn0rtfjrlyek07`(`role_sn`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_resource
-- ----------------------------
DROP TABLE IF EXISTS `role_resource`;
CREATE TABLE `role_resource`  (
  `role_sn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编号',
  `resource_sn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源编号',
  PRIMARY KEY (`role_sn`, `resource_sn`) USING BTREE,
  UNIQUE INDEX `uk[role_resource]role_sn_resource_sn`(`role_sn`, `resource_sn`) USING BTREE,
  INDEX `fk[role_resource]resource_sn`(`resource_sn`) USING BTREE,
  CONSTRAINT `fk[role_resource]resource_sn` FOREIGN KEY (`resource_sn`) REFERENCES `resource` (`resource_sn`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk[role_resource]role_sn` FOREIGN KEY (`role_sn`) REFERENCES `role` (`role_sn`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(20) NULL DEFAULT NULL,
  `id` int(32) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('flow', 21, 1);
INSERT INTO `student` VALUES ('wind', 18, 2);
INSERT INTO `student` VALUES ('rose', 20, 3);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  `mobile_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `user_sn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户编号，不唯一',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名称',
  `pwd` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `last_password_reset_date` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '密码最后修改时间',
  `enabled` bit(1) NULL DEFAULT b'1' COMMENT '启用状态',
  `deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除标志，0：表示未删除，1：表示删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk[user]pid`(`pid`) USING BTREE,
  UNIQUE INDEX `uk[user]mobile_number`(`mobile_number`) USING BTREE,
  INDEX `user_sn`(`user_sn`) USING BTREE,
  INDEX `FULLTEXT_user`(`user_sn`, `user_name`, `mobile_number`) USING BTREE,
  INDEX `user_fulltext`(`mobile_number`, `user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3087 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '3203', '13775899277', '9277', '张三', '123456', '2019-11-26 14:19:07', b'1', b'0');

-- ----------------------------
-- Table structure for user_resource
-- ----------------------------
DROP TABLE IF EXISTS `user_resource`;
CREATE TABLE `user_resource`  (
  `pid` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `resource_sn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  UNIQUE INDEX `uk[user_role_department]email_role_sn_department_sn`(`pid`, `resource_sn`) USING BTREE,
  UNIQUE INDEX `UK7jlxk5bmjcdvrgo74o11i5p39`(`pid`, `resource_sn`) USING BTREE,
  INDEX `fk[user_role_department]role_sn`(`resource_sn`) USING BTREE,
  INDEX `fk[user_role_department]email`(`pid`) USING BTREE,
  CONSTRAINT `fk[user_role_department]pid` FOREIGN KEY (`pid`) REFERENCES `user` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk[user_role_department]role_sn` FOREIGN KEY (`resource_sn`) REFERENCES `resource` (`resource_sn`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `pid` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户身份证号',
  `role_sn` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`pid`, `role_sn`) USING BTREE,
  UNIQUE INDEX `uk[user_role]user_sn_role_sn`(`pid`, `role_sn`) USING BTREE,
  INDEX `fk[user_role]role_sn`(`role_sn`) USING BTREE,
  CONSTRAINT `fk[user_role]pid` FOREIGN KEY (`pid`) REFERENCES `user` (`pid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk[user_role]role_sn` FOREIGN KEY (`role_sn`) REFERENCES `role` (`role_sn`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

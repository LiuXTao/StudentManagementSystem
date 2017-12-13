# DROP Database IF EXISTS `education`;
CREATE Database education;
USE education;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `administor`
-- ----------------------------
DROP TABLE IF EXISTS `administor`;
CREATE TABLE `administor` (
`id`  int(10) NOT NULL ,
`password`  char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`name`  char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of administor
-- ----------------------------
BEGIN;
INSERT INTO `administor` VALUES ('2017112001', '123456789012340', 'chen'), ('2017112002', '123456789012340', 'li'), ('2017112003', '123456789012340', 'wang');
COMMIT;

-- ----------------------------
-- Table structure for `clazz`
-- ----------------------------
DROP TABLE IF EXISTS `clazz`;
CREATE TABLE `clazz` (
`id`  bigint(15) NOT NULL ,
`name`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`quantity`  int(3) NOT NULL ,
`majID`  int(5) NOT NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`majID`) REFERENCES `major` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `majID` (`majID`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of clazz
-- ----------------------------
BEGIN;
INSERT INTO `clazz` VALUES ('20171120101', '17软件1班', '40', '11201'), ('20171120102', '17软件2班', '40', '11201'), ('20171120201', '17软件卓越1班', '40', '11202');
COMMIT;

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
`id`  bigint(15) NOT NULL ,
`name`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`type`  int(2) NULL DEFAULT NULL ,
`credict`  int(4) NULL DEFAULT NULL ,
`totalTime`  int(3) NULL DEFAULT NULL ,
`learnTerm`  int(2) NULL DEFAULT NULL ,
`learnYear`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`classroom`  char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`depID`  int(3) NOT NULL ,
`timeSlotID`  int(10) NOT NULL ,
`proID`  bigint(15) NOT NULL ,
`admID`  int(10) NULL DEFAULT NULL ,
`stuNumber`  int(3) NULL DEFAULT NULL ,
`quantity`  int(3) NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`depID`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`timeSlotID`) REFERENCES `timeslot` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`proID`) REFERENCES `professor` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`admID`) REFERENCES `administor` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `depID` (`depID`) USING BTREE ,
INDEX `timeSlotID` (`timeSlotID`) USING BTREE ,
INDEX `proID` (`proID`) USING BTREE ,
INDEX `admID` (`admID`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of course
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES ('20171120001', 'IT项目管理', '1', '4', '64', '1', '20152016', 'A1-201', '112', '20173004', '201711201001', '2017112001', '1', '100'), ('20171120002', '软件架构', '1', '4', '64', '1', '20152016', 'A1-202', '112', '20173002', '201711201002', '2017112001', '1', '100'), ('20171120003', '机器学习', '2', '3', '64', '1', '20152016', 'A1-203', '112', '20173003', '201711201003', '2017112001', '1', '100'), ('20171120004', 'JAVA', '2', '2', '32', '1', '20152016', 'A3-102', '112', '20173001', '201711201001', '2017112002', '1', '100');
COMMIT;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
`id`  int(3) NOT NULL ,
`name`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`building`  char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`contactInfomation`  char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of department
-- ----------------------------
BEGIN;
INSERT INTO `department` VALUES ('2', '生物学院', 'B1', ''), ('101', '计算机学院', 'B3', ''), ('112', '软件学院', 'B7', '');
COMMIT;

-- ----------------------------
-- Table structure for `major`
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
`id`  int(5) NOT NULL ,
`name`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`depID`  int(3) NOT NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`depID`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `depID` (`depID`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of major
-- ----------------------------
BEGIN;
INSERT INTO `major` VALUES ('10101', '网络工程', '101'), ('11201', '软件工程', '112'), ('11202', '软件卓越班', '112');
COMMIT;

-- ----------------------------
-- Table structure for `notice`
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
`id`  bigint(15) NOT NULL ,
`noticeContent`  text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`time`  date NOT NULL ,
`admID`  int(10) NOT NULL ,
`readed`  int(1) NOT NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`admID`) REFERENCES `administor` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `admID` (`admID`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of notice
-- ----------------------------
BEGIN;
INSERT INTO `notice` VALUES ('201711200001', 'nitice 1', '2017-11-20', '2017112001', '1'), ('201711200002', 'nitics2', '2017-11-20', '2017112002', '1'), ('201711200003', 'nitice 3', '2017-11-20', '2017112003', '1'), ('201711200004', 'nitice4', '2017-11-22', '2017112001', '1'), ('201711200005', 'nitice5', '2017-11-23', '2017112002', '1'), ('201711200006', 'nitice6', '2017-11-22', '2017112003', '0'), ('201711200007', 'nitice7', '2017-11-24', '2017112001', '1');
COMMIT;

-- ----------------------------
-- Table structure for `noticepro`
-- ----------------------------
DROP TABLE IF EXISTS `noticepro`;
CREATE TABLE `noticepro` (
`notID`  bigint(15) NOT NULL ,
`proID`  bigint(15) NOT NULL ,
PRIMARY KEY (`notID`, `proID`),
FOREIGN KEY (`notID`) REFERENCES `notice` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (`proID`) REFERENCES `professor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
INDEX `noticepro_ibfk_2` (`proID`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of noticepro
-- ----------------------------
BEGIN;
INSERT INTO `noticepro` VALUES ('201711200001', '201711201001'), ('201711200002', '201711201001'), ('201711200003', '201711201002');
COMMIT;

-- ----------------------------
-- Table structure for `noticestu`
-- ----------------------------
DROP TABLE IF EXISTS `noticestu`;
CREATE TABLE `noticestu` (
`notID`  bigint(15) NOT NULL ,
`stuID`  bigint(15) NOT NULL ,
PRIMARY KEY (`notID`, `stuID`),
FOREIGN KEY (`notID`) REFERENCES `notice` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (`stuID`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
INDEX `noticestu_ibfk_2` (`stuID`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of noticestu
-- ----------------------------
BEGIN;
INSERT INTO `noticestu` VALUES ('201711200004', '201711201002'), ('201711200005', '201711201002'), ('201711200007', '201711201002'), ('201711200006', '201711201003');
COMMIT;

-- ----------------------------
-- Table structure for `professor`
-- ----------------------------
DROP TABLE IF EXISTS `professor`;
CREATE TABLE `professor` (
`id`  bigint(15) NOT NULL ,
`password`  char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`name`  char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`teachingAge`  int(3) NULL DEFAULT NULL ,
`title`  char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`educationBackground`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`birthday`  date NULL DEFAULT NULL ,
`nationality`  char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`areaInterest`  char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sex`  char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`politicalStatus`  char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`contactInfomation`  char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`depID`  int(3) NOT NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`depID`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `depID` (`depID`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of professor
-- ----------------------------
BEGIN;
INSERT INTO `professor` VALUES ('201711201001', '666666', '陈', '5', '', '博士', '1988-12-02', '汉族', '大数据', '', '党员', '', '112'), ('201711201002', '77777777', '王', '2', '', '硕士', '1988-12-03', '藏族', '金融软件', '', '群众', '', '112'), ('201711201003', '123456', '李', '7', '', '博士', '1988-12-04', '土家族', '大数据', '', '党员', '', '112');
COMMIT;

-- ----------------------------
-- Table structure for `securitypro`
-- ----------------------------
DROP TABLE IF EXISTS `securitypro`;
CREATE TABLE `securitypro` (
`id`  bigint(20) NOT NULL ,
`proID`  bigint(20) NOT NULL ,
`queone`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`quetwo`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`quethree`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`ansone`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`anstwo`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`ansthree`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`, `proID`),
FOREIGN KEY (`proID`) REFERENCES `professor` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `proID` (`proID`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of securitypro
-- ----------------------------
BEGIN;
INSERT INTO `securitypro` VALUES ('1', '201711201002', '你母亲的名字是什么', '你的故乡是哪里', '你的邮箱是多少', '1', '2', '3'), ('2', '201711201001', '你的手机号码是什么', '你的班主任叫什么', '你的邮箱是多少', '1', '1', '3'), ('3', '201711201003', '你第一所学校是什么', '你父亲的名字是什么', '你的邮箱是多少', '1', '1', '1');
COMMIT;

-- ----------------------------
-- Table structure for `securitystu`
-- ----------------------------
DROP TABLE IF EXISTS `securitystu`;
CREATE TABLE `securitystu` (
`id`  bigint(20) NOT NULL ,
`stuID`  bigint(20) NOT NULL ,
`queone`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`quetwo`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`quethree`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`ansone`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`anstwo`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`ansthree`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`, `stuID`),
FOREIGN KEY (`stuID`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `stuID` (`stuID`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of securitystu
-- ----------------------------
BEGIN;
INSERT INTO `securitystu` VALUES ('1', '201711201002', 'aaa', 'fff', 'bbb', 'eee', 'qqq', 'zzz'), ('2', '201711201003', '你第一所学校是什么', '你父亲的名字是什么', '你母亲的名字是什么', '1', '2', '3'), ('3', '201711201004', '你第一所学校是什么', '你的故乡是哪里', '你的邮箱是多少', '123', '321', '11111');
COMMIT;

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
`id`  bigint(15) NOT NULL ,
`password`  char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`name`  char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`timeEnrollment`  date NULL DEFAULT NULL ,
`timeGraduation`  date NULL DEFAULT NULL ,
`title`  char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`sex`  char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`birthday`  date NULL DEFAULT NULL ,
`nationality`  char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`areaInterest`  char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`healthState`  char(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`nativePlace`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`politicalStatus`  char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`majID`  int(20) NOT NULL ,
`claID`  bigint(15) NOT NULL ,
`proID`  bigint(15) NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`majID`) REFERENCES `major` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`claID`) REFERENCES `clazz` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`proID`) REFERENCES `professor` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `majID` (`majID`) USING BTREE ,
INDEX `claID` (`claID`) USING BTREE ,
INDEX `proID` (`proID`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('201711201002', '11111111', '陈', '2015-09-01', '2019-06-12', '干事', '', '2015-09-01', '壮族', '数媒', '', '广东汕头', '团员', '11201', '20171120101', '201711201001'), ('201711201003', '444444', '陈', '2015-09-01', '2019-06-12', '学生', '', '2015-09-01', '汉族', '嵌入式', '', '陕西', '团员', '11201', '20171120101', '201711201001'), ('201711201004', '555555', '陈', '2015-09-01', '2019-06-12', '会长', '', '2015-09-01', '汉族', '嵌入式', '', '湖南', '党员', '11201', '20171120101', '201711201001');
COMMIT;

-- ----------------------------
-- Table structure for `takes`
-- ----------------------------
DROP TABLE IF EXISTS `takes`;
CREATE TABLE `takes` (
`stuID`  bigint(15) NOT NULL ,
`couID`  bigint(15) NOT NULL ,
`grade`  float(3,1) NULL DEFAULT NULL ,
`ranking`  int(4) NULL DEFAULT NULL ,
`PerformancePoint`  float(3,1) NULL DEFAULT NULL ,
PRIMARY KEY (`stuID`, `couID`),
FOREIGN KEY (`stuID`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`couID`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `couID` (`couID`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of takes
-- ----------------------------
BEGIN;
INSERT INTO `takes` VALUES ('201711201002', '20171120001', '98.0', '14', '4.0'), ('201711201002', '20171120002', '95.0', '4', '4.0'), ('201711201002', '20171120003', '97.0', '2', '4.0'), ('201711201002', '20171120004', '57.0', '100', '0.0');
COMMIT;

-- ----------------------------
-- Table structure for `timeslot`
-- ----------------------------
DROP TABLE IF EXISTS `timeslot`;
CREATE TABLE `timeslot` (
`id`  int(10) NOT NULL ,
`endWeek`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`startWeek`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`times`  varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`, `times`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Records of timeslot
-- ----------------------------
BEGIN;
INSERT INTO `timeslot` VALUES ('20173001', '16', '2', '1-12;3-56;5-34'), ('20173002', '16', '3', '1-34;2-12;5-78'), ('20173003', '12', '2', '1-56;4-34'), ('20173004', '16', '8', '2-91011;4-56');
COMMIT;

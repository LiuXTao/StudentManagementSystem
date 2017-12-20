/*
Source Database       : education
*/
drop database education;
create database education;
use education;

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
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

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
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Table structure for `department`
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
`id`  int(3) NOT NULL ,
`name`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`building`  char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`contactInfomation`  char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`newProfessor` int(5) DEFAULT '0' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;



-- ----------------------------
-- Table structure for `major`
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
`id`  int(5) NOT NULL ,
`name`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`depID`  int(3) NOT NULL ,
`newStudent` int(5)  DEFAULT '0' ,
PRIMARY KEY (`id`),
FOREIGN KEY (`depID`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

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
FOREIGN KEY (`majID`) REFERENCES `major` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

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
FOREIGN KEY (`admID`) REFERENCES `administor` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Table structure for `professor`
-- ----------------------------
DROP TABLE IF EXISTS `professor`;
CREATE TABLE `professor` (
`id`  bigint(15) NOT NULL ,
`password`  char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`name`  char(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`year` int(5) NULL DEFAULT NULL ,
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
FOREIGN KEY (`depID`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


-- ----------------------------
-- Table structure for `noticepro`
-- ----------------------------
DROP TABLE IF EXISTS `noticepro`;
CREATE TABLE `noticepro` (
`notID`  bigint(15) NOT NULL ,
`proID`  bigint(15) NOT NULL ,
PRIMARY KEY (`notID`, `proID`),
FOREIGN KEY (`notID`) REFERENCES `notice` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (`proID`) REFERENCES `professor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
`id`  bigint(15) NOT NULL ,
`name`  char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`type`  int(2) NULL DEFAULT NULL ,
`classroom`  char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`depID`  int(3) NOT NULL, 
`timeSlotID`  int(10) NOT NULL ,
`proID`  bigint(15) NOT NULL ,
`admID`  int(10) NULL DEFAULT NULL ,
`stuNumber`  int(3) NULL DEFAULT NULL ,
`quantity`  int(3) NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
FOREIGN KEY (`depID`) REFERENCES `department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`timeSlotID`) REFERENCES `timeslot` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`proID`) REFERENCES `professor` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (`admID`) REFERENCES `administor` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

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
FOREIGN KEY (`proID`) REFERENCES `professor` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- Table structure for `noticestu`
-- ----------------------------
DROP TABLE IF EXISTS `noticestu`;
CREATE TABLE `noticestu` (
`notID`  bigint(15) NOT NULL ,
`stuID`  bigint(15) NOT NULL ,
PRIMARY KEY (`notID`, `stuID`),
FOREIGN KEY (`notID`) REFERENCES `notice` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (`stuID`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

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
FOREIGN KEY (`proID`) REFERENCES `professor` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

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
FOREIGN KEY (`stuID`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


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
FOREIGN KEY (`couID`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

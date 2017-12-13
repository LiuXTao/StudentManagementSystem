INSERT INTO `timeslot` VALUES (20171001, '16', '1', '5-78');
INSERT INTO `timeslot` VALUES (20172001, '16', '2', '1-12;3-56;5-34');
INSERT INTO `timeslot` VALUES (20172002, '12', '2', '1-56;4-34');
INSERT INTO `timeslot` VALUES (20173001, '16', '3', '1-34;2-12;5-78');
INSERT INTO `timeslot` VALUES (20173002, '18', '3', '1-12;4-12');
INSERT INTO `timeslot` VALUES (20173003, '14', '3', '3-12;5-12');
INSERT INTO `timeslot` VALUES (20173004, '14', '3', '2-34;4-34');
INSERT INTO `timeslot` VALUES (20173005, '14', '3', '2-56;4-56');
INSERT INTO `timeslot` VALUES (20178001, '16', '8', '2-91011;4-56');

INSERT INTO `administor` VALUES (2017112001, '123456', '陈');
INSERT INTO `administor` VALUES (2017112002, '123456', '李');
INSERT INTO `administor` VALUES (2017112003, '123456', '王');

INSERT INTO `department` VALUES (2, '生物学院', 'B1', '');
INSERT INTO `department` VALUES (101, '计算机学院', 'B3', '');
INSERT INTO `department` VALUES (112, '软件学院', 'B7', '');

INSERT INTO `major` VALUES (10101, '网络工程', 101);
INSERT INTO `major` VALUES (11201, '软件工程', 112);
INSERT INTO `major` VALUES (11202, '软件卓越班', 112);


INSERT INTO `clazz` VALUES (20171120101, '17软件1班', 40, 11201);
INSERT INTO `clazz` VALUES (20171120102, '17软件2班', 40, 11201);
INSERT INTO `clazz` VALUES (20171120201, '17软件卓越1班', 40, 11202);

INSERT INTO `notice` VALUES (201711200000001, 'nitice1', '2017-11-20', 2017112001, 1);
INSERT INTO `notice` VALUES (201711200000002, 'nitics2', '2017-11-20', 2017112002, 1);
INSERT INTO `notice` VALUES (201711200000003, 'nitice3', '2017-11-20', 2017112003, 1);
INSERT INTO `notice` VALUES (201711200000004, 'nitice4', '2017-11-22', 2017112001, 1);
INSERT INTO `notice` VALUES (201711200000005, 'nitice5', '2017-11-23', 2017112002, 1);
INSERT INTO `notice` VALUES (201711200000006, 'nitice6', '2017-11-22', 2017112003, 0);
INSERT INTO `notice` VALUES (201711200000007, 'nitice7', '2017-11-24', 2017112001, 1);

INSERT INTO `professor` VALUES (201711201001, '123456', '李红', 5, '', '博士', '1988-12-2', '汉族', '大数据', '', '党员', '', 112);
INSERT INTO `professor` VALUES (201711201002, '123456', '林连南', 2, '', '博士', '1988-12-3', '藏族', '金融软件', '', '群众', '', 112);
INSERT INTO `professor` VALUES (201711201003, '123456', '谭明奎', 7, '', '博士', '1988-12-4', '土家族', '机器学习', '', '党员', '', 112);
INSERT INTO `professor` VALUES (201711201004, '123456', '吴庆耀', 3, '', '博士', '1988-12-5', '汉族', '机器学习', '', '党员', '', 112);
INSERT INTO `professor` VALUES (201711201005, '123456', '张扬', 5, '', '博士', '1988-12-7', '汉族', '移动开发', '', '党员', '', 112);
INSERT INTO `professor` VALUES (201711201006, '123456', '曾兵', 6, '', '博士', '1988-12-8', '汉族', '大数据', '', '党员', '', 112);
INSERT INTO `professor` VALUES (201711201007, '123456', '吴秋霞', 1, '', '博士', '1988-12-9', '汉族', '嵌入式', '', '党员', '', 112);
INSERT INTO `professor` VALUES (201711201008, '123456', '刘艳霞', 9, '', '博士', '1988-12-10', '汉族', '移动开发', '', '党员', '', 112);


INSERT INTO `securitypro` VALUES (1, 201711201001, '你母亲的名字是什么', '你的故乡是哪里', '你的邮箱是多少', '1', '2', '3');
INSERT INTO `securitypro` VALUES (2, 201711201002, '你的手机号码是什么', '你的班主任叫什么', '你的邮箱是多少', '1', '2', '3');
INSERT INTO `securitypro` VALUES (3, 201711201003, '你第一所学校是什么', '你父亲的名字是什么', '你的邮箱是多少', '1', '2', '3');
INSERT INTO `securitypro` VALUES (4, 201711201004, '你第一所学校是什么', '你父亲的名字是什么', '你的邮箱是多少', '1', '2', '3');
INSERT INTO `securitypro` VALUES (5, 201711201005, '你第一所学校是什么', '你父亲的名字是什么', '你的邮箱是多少', '1', '2', '3');
INSERT INTO `securitypro` VALUES (6, 201711201006, '你第一所学校是什么', '你父亲的名字是什么', '你的邮箱是多少', '1', '2', '3');
INSERT INTO `securitypro` VALUES (7, 201711201007, '你第一所学校是什么', '你父亲的名字是什么', '你的邮箱是多少', '1', '2', '3');
INSERT INTO `securitypro` VALUES (8, 201711201008, '你第一所学校是什么', '你父亲的名字是什么', '你的邮箱是多少', '1', '2', '3');


INSERT INTO `course` VALUES (2017112001, 'IT项目管理', 1, 4, 64, 1, '20152016', 'A1-201', 112,                   20171001, 201711201001, 2017112001, 1, 100);
INSERT INTO `course` VALUES (2017112002, '软件架构', 1, 4, 64, 1, '20152016', 'A1-202', 112,                     20172001, 201711201002, 2017112001, 1, 100);
INSERT INTO `course` VALUES (2017112003, '机器学习', 2, 3, 64, 1, '20152016', 'A1-203', 112,                     20172002, 201711201003, 2017112001, 1, 100);
INSERT INTO `course` VALUES (2017112004, 'JAVA', 2, 2, 32, 1, '20152016', 'A3-102', 112,                         20173001, 201711201008, 2017112002, 1, 100);
INSERT INTO `course` VALUES (2017112005, '软件需求与分析', 1, 5, 32, 1, '20152016', 'A3-202', 112,                20173002, 201711201002, 2017112002, 1, 100);
INSERT INTO `course` VALUES (2017112006, '计算机网络', 1, 4, 32, 1, '20152016', 'A2-502', 112,                    20173003,201711201004, 2017112002, 1, 100);
INSERT INTO `course` VALUES (2017112007, '操作系统', 1, 4, 32, 1, '20152016', 'A2-208', 112,                      20173004,201711201005, 2017112002, 1, 100);
INSERT INTO `course` VALUES (2017112008, '数据库', 1, 4, 32, 1, '20152016', 'A2-107', 112,                        20173005, 201711201006, 2017112002, 1, 100);
INSERT INTO `course` VALUES (2017112009, '数字逻辑', 1, 2, 32, 1, '20152016', 'A2-303', 112,                      20178001, 201711201007, 2017112002, 1, 100);

INSERT INTO `student` VALUES (2017112010001, '123456', '陈人', '2015-9-1', '2019-6-12', '干事', '', '2015-9-1', '壮族', '数媒', '', '广东汕头', '团员', 11201, 20171120101, 201711201001);
INSERT INTO `student` VALUES (2017112010002, '123456', '李如', '2015-9-1', '2019-6-12', '学生', '', '2015-9-1', '汉族', '嵌入式', '', '陕西', '团员', 11201, 20171120101, 201711201002);
INSERT INTO `student` VALUES (2017112010003, '123456', '吴全', '2015-9-1', '2019-6-12', '会长', '', '2015-9-1', '汉族', '移动开发', '', '湖南', '党员', 11201, 20171120101, 201711201003);
INSERT INTO `student` VALUES (2017112010004, '123456', '和秋', '2015-9-1', '2019-6-12', '学生', '', '2015-9-1', '汉族', '人工智能', '', '广东湛江', '党员', 11201, 20171120101, 201711201004);
INSERT INTO `student` VALUES (2017112010005, '123456', '谭庆', '2015-9-1', '2019-6-12', '学生', '', '2015-9-1', '汉族', '移动开发', '', '广东广州', '党员', 11201, 20171120101, 201711201005);
INSERT INTO `student` VALUES (2017112010006, '123456', '秦光', '2015-9-1', '2019-6-12', '学生', '', '2015-9-1', '汉族', '人工智能', '', '广东潮州', '党员', 11201, 20171120101, 201711201006);
INSERT INTO `student` VALUES (2017112010007, '123456', '赵图', '2015-9-1', '2019-6-12', '学生', '', '2015-9-1', '汉族', '移动开发', '', '广东茂名', '党员', 11201, 20171120101, 201711201007);
INSERT INTO `student` VALUES (2017112010008, '123456', '周明', '2015-9-1', '2019-6-12', '学生', '', '2015-9-1', '汉族', '人工智能', '', '广东清远', '党员', 11201, 20171120101, 201711201008);
INSERT INTO `student` VALUES (2017112010009, '123456', '王问', '2015-9-1', '2019-6-12', '学生', '', '2015-9-1', '汉族', '大数据', '', '广东佛山', '党员', 11201, 20171120101, 201711201003);
INSERT INTO `student` VALUES (2017112010010, '123456', '莫团', '2015-9-1', '2019-6-12', '学生', '', '2015-9-1', '汉族', '移动开发', '', '广东深圳', '党员', 11201, 20171120101, 201711201005);

INSERT INTO `securitystu` VALUES (1,  2017112010001, '你第一所学校是什么', '你父亲的名字是什么', '你母亲的名字是什么', '1', '2', '3');
INSERT INTO `securitystu` VALUES (2,  2017112010002, '你第一所学校是什么', '你父亲的名字是什么', '你母亲的名字是什么', '1', '2', '3');
INSERT INTO `securitystu` VALUES (3,  2017112010003, '你第一所学校是什么', '你父亲的名字是什么', '你母亲的名字是什么', '1', '2', '3');
INSERT INTO `securitystu` VALUES (4,  2017112010004, '你第一所学校是什么', '你父亲的名字是什么', '你母亲的名字是什么', '1', '2', '3');
INSERT INTO `securitystu` VALUES (5,  2017112010005, '你第一所学校是什么', '你父亲的名字是什么', '你母亲的名字是什么', '1', '2', '3');
INSERT INTO `securitystu` VALUES (6,  2017112010006, '你第一所学校是什么', '你父亲的名字是什么', '你母亲的名字是什么', '1', '2', '3');
INSERT INTO `securitystu` VALUES (7,  2017112010007, '你第一所学校是什么', '你父亲的名字是什么', '你母亲的名字是什么', '1', '2', '3');
INSERT INTO `securitystu` VALUES (8,  2017112010008, '你第一所学校是什么', '你父亲的名字是什么', '你母亲的名字是什么', '1', '2', '3');
INSERT INTO `securitystu` VALUES (9,  2017112010009, '你第一所学校是什么', '你父亲的名字是什么', '你母亲的名字是什么', '1', '2', '3');
INSERT INTO `securitystu` VALUES (10, 2017112010010, '你第一所学校是什么', '你父亲的名字是什么', '你母亲的名字是什么', '1', '2', '3');

INSERT INTO `noticepro` VALUES (201711200000001, 201711201001);
INSERT INTO `noticepro` VALUES (201711200000002, 201711201001);
INSERT INTO `noticepro` VALUES (201711200000003, 201711201002);

INSERT INTO `noticestu` VALUES (201711200000004, 2017112010002);
INSERT INTO `noticestu` VALUES (201711200000005, 2017112010002);
INSERT INTO `noticestu` VALUES (201711200000007, 2017112010002);
INSERT INTO `noticestu` VALUES (201711200000006, 2017112010003);

INSERT INTO `takes` VALUES (2017112010001, 2017112001, 99.0, 1, 4.0);
INSERT INTO `takes` VALUES (2017112010001, 2017112002, 99.0, 1, 4.0);
INSERT INTO `takes` VALUES (2017112010001, 2017112003, 99.0, 1, 4.0);
INSERT INTO `takes` VALUES (2017112010001, 2017112004, 99.0, 1, 4.0);
INSERT INTO `takes` VALUES (2017112010001, 2017112005, 99.0, 1, 4.0);
INSERT INTO `takes` VALUES (2017112010001, 2017112006, 99.0, 1, 4.0);
INSERT INTO `takes` VALUES (2017112010001, 2017112007, 99.0, 1, 4.0);
INSERT INTO `takes` VALUES (2017112010001, 2017112008, 99.0, 1, 4.0);
INSERT INTO `takes` VALUES (2017112010001, 2017112009, 99.0, 1, 4.0);

INSERT INTO `takes` VALUES (2017112010002, 2017112001, 98.0, 2, 4.0);
INSERT INTO `takes` VALUES (2017112010002, 2017112002, 98.0, 2, 4.0);
INSERT INTO `takes` VALUES (2017112010002, 2017112003, 98.0, 2, 4.0);
INSERT INTO `takes` VALUES (2017112010002, 2017112004, 98.0, 2, 4.0);
INSERT INTO `takes` VALUES (2017112010002, 2017112005, 98.0, 2, 4.0);
INSERT INTO `takes` VALUES (2017112010002, 2017112006, 98.0, 2, 4.0);
INSERT INTO `takes` VALUES (2017112010002, 2017112007, 98.0, 2, 4.0);
INSERT INTO `takes` VALUES (2017112010002, 2017112008, 98.0, 2, 4.0);
INSERT INTO `takes` VALUES (2017112010002, 2017112009, 98.0, 2, 4.0);

INSERT INTO `takes` VALUES (2017112010003, 2017112001, 97.0, 3, 4.0);
INSERT INTO `takes` VALUES (2017112010003, 2017112002, 97.0, 3, 4.0);
INSERT INTO `takes` VALUES (2017112010003, 2017112003, 97.0, 3, 4.0);
INSERT INTO `takes` VALUES (2017112010003, 2017112004, 97.0, 3, 4.0);
INSERT INTO `takes` VALUES (2017112010003, 2017112005, 97.0, 3, 4.0);
INSERT INTO `takes` VALUES (2017112010003, 2017112006, 97.0, 3, 4.0);
INSERT INTO `takes` VALUES (2017112010003, 2017112007, 97.0, 3, 4.0);
INSERT INTO `takes` VALUES (2017112010003, 2017112008, 97.0, 3, 4.0);
INSERT INTO `takes` VALUES (2017112010003, 2017112009, 97.0, 3, 4.0);

INSERT INTO `takes` VALUES (2017112010004, 2017112001, 96.0, 4, 4.0);
INSERT INTO `takes` VALUES (2017112010004, 2017112002, 96.0, 4, 4.0);
INSERT INTO `takes` VALUES (2017112010004, 2017112003, 96.0, 4, 4.0);
INSERT INTO `takes` VALUES (2017112010004, 2017112004, 96.0, 4, 4.0);
INSERT INTO `takes` VALUES (2017112010004, 2017112005, 96.0, 4, 4.0);
INSERT INTO `takes` VALUES (2017112010004, 2017112006, 96.0, 4, 4.0);
INSERT INTO `takes` VALUES (2017112010004, 2017112007, 96.0, 4, 4.0);
INSERT INTO `takes` VALUES (2017112010004, 2017112008, 96.0, 4, 4.0);
INSERT INTO `takes` VALUES (2017112010004, 2017112009, 96.0, 4, 4.0);

INSERT INTO `takes` VALUES (2017112010005, 2017112001, 95.0, 5, 4.0);
INSERT INTO `takes` VALUES (2017112010005, 2017112002, 95.0, 5, 4.0);
INSERT INTO `takes` VALUES (2017112010005, 2017112003, 95.0, 5, 4.0);
INSERT INTO `takes` VALUES (2017112010005, 2017112004, 95.0, 5, 4.0);
INSERT INTO `takes` VALUES (2017112010005, 2017112005, 95.0, 5, 4.0);
INSERT INTO `takes` VALUES (2017112010005, 2017112006, 95.0, 5, 4.0);
INSERT INTO `takes` VALUES (2017112010005, 2017112007, 95.0, 5, 4.0);
INSERT INTO `takes` VALUES (2017112010005, 2017112008, 95.0, 5, 4.0);
INSERT INTO `takes` VALUES (2017112010005, 2017112009, 95.0, 5, 4.0);

INSERT INTO `takes` VALUES (2017112010006, 2017112001, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010006, 2017112002, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010006, 2017112003, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010006, 2017112004, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010006, 2017112005, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010006, 2017112006, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010006, 2017112007, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010006, 2017112008, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010006, 2017112009, 94.0, 6, 4.0);

INSERT INTO `takes` VALUES (2017112010007, 2017112001, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010007, 2017112002, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010007, 2017112003, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010007, 2017112004, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010007, 2017112005, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010007, 2017112006, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010007, 2017112007, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010007, 2017112008, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010007, 2017112009, 94.0, 6, 4.0);

INSERT INTO `takes` VALUES (2017112010008, 2017112001, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010008, 2017112002, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010008, 2017112003, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010008, 2017112004, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010008, 2017112005, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010008, 2017112006, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010008, 2017112007, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010008, 2017112008, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010008, 2017112009, 94.0, 6, 4.0);

INSERT INTO `takes` VALUES (2017112010009, 2017112001, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010009, 2017112002, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010009, 2017112003, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010009, 2017112004, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010009, 2017112005, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010009, 2017112006, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010009, 2017112007, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010009, 2017112008, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010009, 2017112009, 94.0, 6, 4.0);

INSERT INTO `takes` VALUES (2017112010010, 2017112001, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010010, 2017112002, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010010, 2017112003, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010010, 2017112004, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010010, 2017112005, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010010, 2017112006, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010010, 2017112007, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010010, 2017112008, 94.0, 6, 4.0);
INSERT INTO `takes` VALUES (2017112010010, 2017112009, 94.0, 6, 4.0);
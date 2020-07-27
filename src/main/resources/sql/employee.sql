CREATE TABLE `employee` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '员工id',
  `employee_name` varchar(50) NOT NULL COMMENT '员工姓名',
	`job_number` VARCHAR(50) NOT NULL COMMENT '工号',
  `sex` varchar(50) NOT NULL COMMENT '性别',
  `age` varchar(50) NOT NULL COMMENT '年龄',
	`salary` float(10,2) NOT NULL COMMENT '薪资',
	`id_number` varchar(50) NOT NULL COMMENT '身份证号',
	`native_place` VARCHAR(50) NOT NULL COMMENT '籍贯',
  `department` varchar(50) NOT NULL COMMENT '部门',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工表';
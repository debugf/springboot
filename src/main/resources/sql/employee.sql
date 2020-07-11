CREATE TABLE `t_employee` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `name` varchar(50) NOT NULL COMMENT '用户名',
  `sex` varchar(50) NOT NULL COMMENT '性别',
  `age` varchar(50) NOT NULL COMMENT '年龄',
  `department` varchar(50) NOT NULL COMMENT '部门',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工表';
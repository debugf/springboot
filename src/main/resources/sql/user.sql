CREATE TABLE `user` (
  `id` int(32) primary key not null AUTO_INCREMENT COMMENT '用户id'
  `username` varchar(255) not null COMMENT '用户名',
  `password` varchar(255) not null COMMENT '密码',
  `email` varchar(255) default null COMMENT '邮箱',
  `creatatime` timestamp not null default current_timestamp COMMENT '创建时间'
) engine=InnoDB default charset=utf8 COMMENT='用户表';
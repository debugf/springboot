CREATE TABLE `user` (
  `id` int(32) primary key not null auto_increment,
  `username` varchar(255) not null,
  `password` varchar(255) not null,
  `email` varchar(255) default null,
  `creatatime` timestamp not null default current_timestamp
) engine=InnoDB default charset=utf8 COMMENT='用户表';
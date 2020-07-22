CREATE TABLE `user` (
  `id` int(32) primary key not null auto_increment,
  `user_name` varchar(255) not null,
  `password` varchar(255) not null,
  `email` varchar(255) default null,
  `creata_time` timestamp not null default current_timestamp
) engine=InnoDB default charset=utf8;
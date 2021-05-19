
# 测试表
drop table if exists `test`;
create table `test` (
  `id` bigint not null comment 'id',
  `name` varchar(50) comment '名称',
  `password` varchar(50) comment '密码',
  primary key (`id`)
) engine=innodb default charset=utf8mb4 comment='测试';

insert into `test` (id, name, password) values (1, '测试', 'password');


# demo列表
drop table if exists `demo`;
create table `demo` (
                        `id` bigint not null comment 'id',
                        `name` varchar(50) comment '名称',
                        primary key (`id`)
) engine=innodb default charset =utf8mb4 comment '测试';

insert into `demo` (id,name) values(2,'测试2');


# pic列表
drop table if exists `pic`;
create table `pic` (
                        `id` bigint not null comment 'id',
                        `path` varchar(255) comment '图片路径',
                        primary key (`id`)
) engine=innodb default charset =utf8mb4 comment '测试';

insert into `demo` (id,name) values(1,'路径 1');


# 用户表 ，新的用户逻辑，只需要一个表，就可以了
drop table if exists `user`;
create table `user` (
                       `id` bigint not null comment 'id',
                       `path` varchar(255) comment '图片路径',
                       `phone` int(30) comment '电话号码',
                       `address` varchar(255) comment '宠物发现地址',
                       primary key (`id`)
) engine=innodb default charset =utf8mb4 comment '用户表';
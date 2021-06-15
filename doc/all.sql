# pic列表
drop table if exists `pic`;
create table `pic` (
                        `id` bigint not null comment 'id',
                        `path` varchar(255) comment '图片路径',
                        `userId` bigint comment '用户id',
                        `address` varchar(255) comment '发现地址',
                        primary key (`id`)
) engine=innodb default charset =utf8mb4 comment '图片表';



# 用户表 ，新的用户逻辑，只需要一个表，就可以了
drop table if exists `user`;
create table `user` (
                       `id` bigint not null comment 'id',
                       `loginName` varchar(255) comment '登录名称',
                       `realName` varchar(255) comment '真实名称',
                       `password` varchar(255) comment '登录密码',
                       `email` varchar(255) comment '邮箱',
                       `createTime` datetime comment '创建时间',
                       `loginTime` datetime comment '登录时间',
                       `address` varchar(255) comment '用户地址',
                       primary key (`id`)
) engine=innodb default charset =utf8mb4 comment '用户表';
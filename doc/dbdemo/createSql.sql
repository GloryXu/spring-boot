drop table `department`;
CREATE TABLE `department` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
`name` VARCHAR(255) NOT NULL COMMENT '部门名称',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT= 1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='部门表';


drop table `user`;
CREATE TABLE `user` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
`name` VARCHAR(255) NOT NULL COMMENT '用户名称',
`createdate` timestamp COMMENT '创建时间',
`did` int NOT NULL COMMENT '部门ID',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT= 1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';


drop table `role`;
CREATE TABLE `role` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
`name` VARCHAR(255) NOT NULL COMMENT '角色名称',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT= 1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色表';


drop table `user_role`;
CREATE TABLE `user_role` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
`roles_id` int NOT NULL COMMENT '角色ID',
`user_id` int NOT NULL COMMENT '用户ID',
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT= 1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户角色关联表';
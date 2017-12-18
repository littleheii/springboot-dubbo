/*创建数据库*/
create database study charset = utf8;

/*创建user表*/
CREATE TABLE `user` (
	id BIGINT NOT NULL PRIMARY KEY auto_increment COMMENT '主键id',
	`name` VARCHAR (20) NOT NULL COMMENT '姓名',
	age INT UNSIGNED NOT NULL COMMENT '年龄'
) ENGINE = INNODB charset = utf8;

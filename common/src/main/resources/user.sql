create table blog_role(
    id  bigint primary key auto_increment comment '编号',
    username varchar(8)  not null unique comment '用户名',
    password varchar(18) comment '密码',
    salt varchar(10) comment '盐',
    email varchar(40) comment '邮箱',
    mobile varchar(15) comment '手机号',
    status tinyint  comment '状态 0：锁定  1：正常',
    del_flag tinyint default 0 comment '是否删除 -1：已删除  0：正常'
)engine = InnoDB default charset = utf8 comment '用户'
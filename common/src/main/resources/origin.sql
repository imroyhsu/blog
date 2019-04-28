create table blog_user(
    id  bigint primary key auto_increment comment '编号',
    username varchar(8)  not null unique comment '用户名',
    password varchar(18) comment '密码',
    salt varchar(10) comment '盐',
    email varchar(40) comment '邮箱',
    mobile varchar(15) comment '手机号',
    status tinyint  comment '状态 0：锁定  1：正常',
    delFlag tinyint default 0 comment '是否删除 -1：已删除  0：正常'
)engine = InnoDB default charset = utf8 comment='用户';

create table blog_role(
    id  bigint primary key auto_increment comment '编号',
    roleName varchar(20) unique comment '角色名',
    remark varchar(100) comment '备注',
    delFlag tinyint default 0 comment '是否删除 -1：已删除  0：正常'
)engine = InnoDB default charset = utf8 comment='角色';

create table blog_permission(
    id  bigint primary key auto_increment comment '编号',
    permissionName varchar(20)  not null comment '权限名',
    remark varchar(100) comment '备注',
)engine = InnoDB default charset = utf8 comment='角色';

create table blog_user_role(
    id  bigint primary key auto_increment comment '编号',
    userId bigint comment '用户ID',
    roleId bigint comment '角色ID',
    KEY fk_user_role_blog_user_1 (userId),
    KEY fk_user_role_blog_role_1 (roleId),
    constraint fk_user_role_blog_user_1 foreign key (userId) references
                           blog_user(id) on delete CASCADE on UPDATE CASCADE,
    constraint fk_user_role_blog_role_1 foreign key (roleId) references
        blog_role(id) on delete CASCADE on UPDATE CASCADE
)engine = InnoDB default charset = utf8 comment='用户与角色对应表';

create table blog_role_permission(
    id  bigint primary key auto_increment comment '编号',
    roleId bigint comment '角色ID',
    permissionId bigint comment '权限ID',
    KEY fk_user_role_blog_user_1 (userId),
    KEY fk_user_role_blog_role_1 (roleId),
    constraint fk_role_permission_blog_role_1 foreign key (roleId) references
        blog_role(id) on delete CASCADE on UPDATE CASCADE,
    constraint fk_role_permission_blog_permission_1 foreign key (permissionId) references
        blog_permission(id) on delete CASCADE on UPDATE CASCADE
)engine = InnoDB default charset = utf8 comment='角色与权限对应表';
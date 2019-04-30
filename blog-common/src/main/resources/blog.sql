    -- ----------------------------------------------------
--  用户
-- ----------------------------------------------------
--  Table structure for `sys_user`
-- ----------------------------------------------------
CREATE TABLE `sys_user` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(50) NOT NULL COMMENT '用户名',
    `password` varchar(100) COMMENT '密码',
    `salt` varchar(40) COMMENT '盐',
    `email` varchar(100) COMMENT '邮箱',
    `mobile` varchar(100) COMMENT '手机号',
    `status` tinyint COMMENT '状态  0：禁用   1：正常',
    `deptId` bigint(20) COMMENT '机构ID',
    `createBy` varchar(50) COMMENT '创建人',
    `createTime` datetime COMMENT '创建时间',
    `lastUpdateBy` varchar(50) COMMENT '更新人',
    `lastUpdateTime` datetime COMMENT '更新时间',
    `delFlag` tinyint DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
    PRIMARY KEY (`id`),
    UNIQUE INDEX (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------------------------------
--  机构
-- ------------------------------------------------
--  Table structure for `sys_dept`
-- ------------------------------------------------
CREATE TABLE `sys_dept` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(50) COMMENT '机构名称',
    `parentId` bigint COMMENT '上级机构ID，一级机构为0',
    `orderNum` int COMMENT '排序',
    `createBy` varchar(50) COMMENT '创建人',
    `createTime` datetime COMMENT '创建时间',
    `lastUpdateBy` varchar(50) COMMENT '更新人',
    `lastUpdateTime` datetime COMMENT '更新时间',
    `delFlag` tinyint DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构管理';

-- ------------------------------------------------
--  角色
-- ------------------------------------------------
--  Table structure for `sys_role`
-- ------------------------------------------------
CREATE TABLE `sys_role` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(100) COMMENT '角色名称',
    `remark` varchar(100) COMMENT '备注',
    `createBy` varchar(50) COMMENT '创建人',
    `createTime` datetime COMMENT '创建时间',
    `lastUpdateBy` varchar(50) COMMENT '更新人',
    `last_updateTime` datetime COMMENT '更新时间',
    `delFlag` tinyint DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

-- ------------------------------------------------
--  菜单
-- ------------------------------------------------
--  Table structure for `sys_menu`
-- ------------------------------------------------
CREATE TABLE `sys_menu` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `name` varchar(50) COMMENT '菜单名称',
    `parentId` bigint COMMENT '父菜单ID，一级菜单为0',
    `url` varchar(200) COMMENT '菜单URL',
    `perms` varchar(500) COMMENT '授权(多个用逗号分隔，如：user:view,user:create)',
    `type` int COMMENT '类型   0：目录   1：菜单   2：按钮',
    `icon` varchar(50) COMMENT '菜单图标',
    `orderNum` int COMMENT '排序',
    `createBy` varchar(50) COMMENT '创建人',
    `createTime` datetime COMMENT '创建时间',
    `lastUpdateBy` varchar(50) COMMENT '更新人',
    `lastUpdateTime` datetime COMMENT '更新时间',
    `delFlag` tinyint DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ------------------------------------------------
--  用户与角色对应关系
-- ------------------------------------------------
--  Table structure for `sys_user_role`
-- ------------------------------------------------
CREATE TABLE `sys_user_role` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `userId` bigint COMMENT '用户ID',
    `roleId` bigint COMMENT '角色ID',
    `createBy` varchar(50) COMMENT '创建人',
    `createTime` datetime COMMENT '创建时间',
    `lastUpdateBy` varchar(50) COMMENT '更新人',
    `lastUpdateTime` datetime COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ------------------------------------------------
--  角色与机构对应关系
-- ------------------------------------------------
--  Table structure for `sys_role_dept`
-- ------------------------------------------------
CREATE TABLE `sys_role_dept` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `roleId` bigint COMMENT '角色ID',
    `deptId` bigint COMMENT '机构ID',
    `createBy` varchar(50) COMMENT '创建人',
    `createTime` datetime COMMENT '创建时间',
    `lastUpdateBy` varchar(50) COMMENT '更新人',
    `lastUpdateTime` datetime COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与机构对应关系';

-- ------------------------------------------------
--  角色与菜单对应关系
-- ------------------------------------------------
--  Table structure for `sys_role_menu`
-- ------------------------------------------------
CREATE TABLE `sys_role_menu` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `roleId` bigint COMMENT '角色ID',
    `menuId` bigint COMMENT '菜单ID',
    `createBy` varchar(50) COMMENT '创建人',
    `createTime` datetime COMMENT '创建时间',
    `lastUpdateBy` varchar(50) COMMENT '更新人',
    `lastUpdateTime` datetime COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ------------------------------------------------
--  用户Token
-- ------------------------------------------------
--  Table structure for `sys_user_token`
-- ------------------------------------------------
CREATE TABLE `sys_user_token` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `userId` bigint NOT NULL,
    `token` varchar(100) NOT NULL COMMENT 'token',
    `expireTime` datetime DEFAULT NULL COMMENT '过期时间',
    `createBy` varchar(50) COMMENT '创建人',
    `createTime` datetime COMMENT '创建时间',
    `lastUpdateBy` varchar(50) COMMENT '更新人',
    `lastUpdateTime` datetime COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户Token';

-- ------------------------------------------------
--  系统日志
-- ------------------------------------------------
--  Table structure for `sys_log`
-- ------------------------------------------------
CREATE TABLE `sys_log` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `userName` varchar(50) COMMENT '用户名',
    `operation` varchar(50) COMMENT '用户操作',
    `method` varchar(200) COMMENT '请求方法',
    `params` varchar(5000) COMMENT '请求参数',
    `time` bigint NOT NULL COMMENT '执行时长(毫秒)',
    `ip` varchar(64) COMMENT 'IP地址',
    `createBy` varchar(50) COMMENT '创建人',
    `createTime` datetime COMMENT '创建时间',
    `lastUpdateBy` varchar(50) COMMENT '更新人',
    `lastUpdateTime` datetime COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=`InnoDB` DEFAULT CHARACTER SET utf8 COMMENT='系统日志';

-- ------------------------------------------------
--  数据字典
-- ------------------------------------------------
--  Table structure for `sys_dict`
-- ------------------------------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '编号',
    `value` varchar(100) NOT NULL COMMENT '数据值',
    `label` varchar(100) NOT NULL COMMENT '标签名',
    `type` varchar(100) NOT NULL COMMENT '类型',
    `description` varchar(100) NOT NULL COMMENT '描述',
    `sort` decimal(10,0) NOT NULL COMMENT '排序（升序）',
    `createBy` varchar(50) COMMENT '创建人',
    `createTime` datetime COMMENT '创建时间',
    `lastUpdateBy` varchar(50) COMMENT '更新人',
    `lastUpdateTime` datetime COMMENT '更新时间',
    `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
    `delFlag` tinyint DEFAULT 0 COMMENT '是否删除  -1：已删除  0：正常',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';

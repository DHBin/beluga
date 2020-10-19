-- 菜单表
CREATE TABLE `sys_menu`
(
    `id`          bigint(20) UNSIGNED NOT NULL COMMENT 'id',
    `label`       varchar(20)         NOT NULL COMMENT '名称',
    `description` varchar(100)        NULL COMMENT '说明',
    `type`        tinyint(2)          NOT NULL COMMENT '1-顶部菜单 2-左侧菜单',
    `path`        varchar(500)        NULL COMMENT '前端页面路径',
    `component`   varchar(500)        NULL COMMENT '前端组件路径',
    `icon`        varchar(500)        NULL COMMENT '菜单图标',
    `num`         int(11)             NOT NULL COMMENT '编号',
    `parent_num`  int(11)             NOT NULL COMMENT '父级编码',
    `order_num`   int(11)             NOT NULL COMMENT '顺序',
    `create_time` datetime            NOT NULL COMMENT '创建时间',
    `update_time` datetime            NULL COMMENT '更新时间',
    `create_uid`  bigint(20) UNSIGNED NOT NULL COMMENT '创建uid',
    `update_uid`  bigint(20) UNSIGNED NULL COMMENT '更新uid',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT '菜单';


-- 权限表
CREATE TABLE `sys_perm`
(
    `id`             varchar(100)        NOT NULL COMMENT 'id',
    `own`            varchar(100)        NULL COMMENT '所属项目',
    `name`           varchar(100)        NULL COMMENT '名称',
    `description`    varchar(100)        NULL COMMENT '说明',
    `path`           varchar(256)        NULL COMMENT '路径',
    `method`         varchar(256)        NULL COMMENT '请求方法',
    `authorizations` varchar(256)        NULL COMMENT '权限标识',
    `create_time`    datetime            NOT NULL COMMENT '创建时间',
    `update_time`    datetime            NULL COMMENT '更新时间',
    `create_uid`     bigint(20) UNSIGNED NOT NULL COMMENT '创建uid',
    `update_uid`     bigint(20) UNSIGNED NULL COMMENT '更新uid',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT '权限';

-- 菜单-权限关系表
CREATE TABLE `sys_menu_perm`
(
    `id`          bigint(20) UNSIGNED NOT NULL COMMENT 'id',
    `mid`         bigint(20) UNSIGNED NOT NULL COMMENT '菜单id',
    `pid`         varchar(100)        NOT NULL COMMENT '权限id',
    `create_time` datetime            NOT NULL COMMENT '创建时间',
    `update_time` datetime            NULL COMMENT '更新时间',
    `create_uid`  bigint(20) UNSIGNED NOT NULL COMMENT '创建uid',
    `update_uid`  bigint(20) UNSIGNED NULL COMMENT '更新uid',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT '菜单-权限关系';

-- 角色表
CREATE TABLE `sys_role`
(
    `id`          bigint(20) UNSIGNED NOT NULL COMMENT 'id',
    `name`        varchar(20)         NOT NULL COMMENT '角色名',
    `role_key`    varchar(20)         NOT NULL COMMENT '角色标识',
    `description` varchar(255)        NULL COMMENT '说明',
    `create_time` datetime            NOT NULL COMMENT '创建时间',
    `update_time` datetime            NULL COMMENT '更新时间',
    `create_uid`  bigint(20) UNSIGNED NOT NULL COMMENT '创建uid',
    `update_uid`  bigint(20) UNSIGNED NULL COMMENT '更新uid',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT '角色';


-- 角色-菜单关系表
CREATE TABLE `sys_role_menu`
(
    `id`          bigint(20) UNSIGNED NOT NULL COMMENT 'id',
    `rid`         bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
    `mid`         bigint(20) UNSIGNED NOT NULL COMMENT '菜单id',
    `create_time` datetime            NOT NULL COMMENT '创建时间',
    `update_time` datetime            NULL COMMENT '更新时间',
    `create_uid`  bigint(20) UNSIGNED NOT NULL COMMENT '创建uid',
    `update_uid`  bigint(20) UNSIGNED NULL COMMENT '更新uid',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT '角色-菜单关系';

-- 角色-权限关系表
CREATE TABLE `sys_role_perm`
(
    `id`          bigint(20) UNSIGNED NOT NULL COMMENT 'id',
    `rid`         bigint(20) UNSIGNED NOT NULL COMMENT '角色id',
    `pid`         varchar(100)        NOT NULL COMMENT '权限id',
    `create_time` datetime            NOT NULL COMMENT '创建时间',
    `update_time` datetime            NULL COMMENT '更新时间',
    `create_uid`  bigint(20) UNSIGNED NOT NULL COMMENT '创建uid',
    `update_uid`  bigint(20) UNSIGNED NULL COMMENT '更新uid',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT '角色-权限';


-- 用户表
CREATE TABLE `sys_user`
(
    `id`          bigint(20) UNSIGNED NOT NULL COMMENT 'id',
    `username`    varchar(20)         NOT NULL COMMENT '用户名',
    `phone`       varchar(20)         NOT NULL COMMENT '手机号码',
    `email`       varchar(100)        NOT NULL COMMENT '邮箱',
    `password`    varchar(255)        NOT NULL COMMENT '密码',
    `dept_id`     bigint(20) UNSIGNED NULL COMMENT '部门id',
    `create_time` datetime            NOT NULL COMMENT '创建时间',
    `update_time` datetime            NULL COMMENT '更新时间',
    `create_uid`  bigint(20) UNSIGNED NOT NULL COMMENT '创建uid',
    `update_uid`  bigint(20) UNSIGNED NULL COMMENT '更新uid',
    `deleted`     tinyint(1)          NOT NULL DEFAULT 0 COMMENT '1为已删除，0为未删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `sys_user_username_uindex` (`username`) USING BTREE
) COMMENT '用户';

-- 用户-角色关系表
CREATE TABLE `sys_user_role`
(
    `id`          bigint(20) UNSIGNED NOT NULL COMMENT 'id',
    `user_id`     bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
    `rid`         bigint(20) UNSIGNED NOT NULL COMMENT '角色id',
    `create_time` datetime            NOT NULL COMMENT '创建时间',
    `update_time` datetime            NULL COMMENT '更新时间',
    `create_uid`  bigint(20) UNSIGNED NOT NULL COMMENT '创建uid',
    `update_uid`  bigint(20) UNSIGNED NULL COMMENT '更新uid',
    PRIMARY KEY (`id`) USING BTREE
) COMMENT '用户-角色关系';


-- 字典表
CREATE TABLE sys_dict
(
    id          bigint(20)              NOT NULL,
    type        varchar(100)            NOT NULL COMMENT '类型',
    description varchar(100) DEFAULT '' NOT NULL COMMENT '描述',
    create_time datetime                NOT NULL COMMENT '创建时间',
    update_time datetime                NULL COMMENT '更新时间',
    create_uid  bigint(20)              NOT NULL COMMENT '创建uid',
    update_uid  bigint(20)              NULL COMMENT '更新uid',
    PRIMARY KEY (id)
) COMMENT '字典';


-- 字典项表
CREATE TABLE sys_dict_item
(
    id          bigint(20)              NOT NULL,
    dict_id     bigint(20)              NOT NULL COMMENT '字典id',
    item_value  varchar(100)            NOT NULL COMMENT '值',
    item_label  varchar(100)            NOT NULL COMMENT '标签名',
    description varchar(100) DEFAULT '' NOT NULL COMMENT '描述',
    sort_num    int(10)      DEFAULT 0  NOT NULL COMMENT '排序编号',
    create_time datetime                NOT NULL COMMENT '创建时间',
    update_time datetime                NULL COMMENT '更新时间',
    create_uid  bigint(20)              NOT NULL COMMENT '创建uid',
    update_uid  bigint(20)              NULL COMMENT '更新uid',
    PRIMARY KEY (id)
) comment '字典项';

-- 菜单表
CREATE TABLE sys_menu
(
    id          bigint(20)   NOT NULL,
    label       varchar(100) NOT NULL,
    description varchar(100) NULL,
    type        smallint(2)  NOT NULL,
    path        varchar(500) NULL,
    component   varchar(500) NULL,
    icon        varchar(500) NULL,
    num         int(11)      NOT NULL,
    parent_num  int(11)      NOT NULL,
    order_num   int(11)      NOT NULL,
    create_time datetime     NOT NULL,
    update_time datetime     NULL,
    create_uid  bigint(20)   NOT NULL,
    update_uid  bigint(20)   NULL,
    PRIMARY KEY (id)
);


-- 权限表
CREATE TABLE sys_perm
(
    id             varchar(100) NOT NULL,
    own            varchar(100) NULL,
    name           varchar(100) NULL,
    description    varchar(100) NULL,
    path           varchar(256) NULL,
    method         varchar(256) NULL,
    authorizations varchar(256) NULL,
    create_time    datetime         NOT NULL,
    update_time    datetime         NULL,
    create_uid     bigint(20)   NOT NULL,
    update_uid     bigint(20)   NULL,
    PRIMARY KEY (id)
);

-- 菜单-权限关系表
CREATE TABLE sys_menu_perm
(
    id          bigint(20)   NOT NULL,
    mid         bigint(20)   NOT NULL,
    pid         varchar(100) NOT NULL,
    create_time datetime     NOT NULL,
    update_time datetime     NULL,
    create_uid  bigint(20)   NOT NULL,
    update_uid  bigint(20)   NULL,
    PRIMARY KEY (id)
);

-- 角色表
CREATE TABLE sys_role
(
    id          bigint(20)   NOT NULL,
    name        varchar(20)  NOT NULL,
    role_key    varchar(20)  NOT NULL,
    description varchar(255) NULL,
    create_time datetime     NOT NULL,
    update_time datetime     NULL,
    create_uid  bigint(20)   NOT NULL,
    update_uid  bigint(20)   NULL,
    PRIMARY KEY (id)
);


-- 角色-菜单关系表
CREATE TABLE sys_role_menu
(
    id          bigint(20) NOT NULL,
    rid         bigint(20) NOT NULL,
    mid         bigint(20) NOT NULL,
    create_time datetime   NOT NULL,
    update_time datetime   NULL,
    create_uid  bigint(20) NOT NULL,
    update_uid  bigint(20) NULL,
    PRIMARY KEY (id)
);

-- 角色-权限关系表
CREATE TABLE sys_role_perm
(
    id          bigint(20)   NOT NULL,
    rid         bigint(20)   NOT NULL,
    pid         varchar(100) NOT NULL,
    create_time datetime     NOT NULL,
    update_time datetime     NULL,
    create_uid  bigint(20)   NOT NULL,
    update_uid  bigint(20)   NULL,
    PRIMARY KEY (id)
);

-- 用户表
CREATE TABLE sys_user
(
    id          bigint(20)   NOT NULL,
    username    varchar(20)  NOT NULL,
    phone       varchar(20)  NOT NULL,
    email       varchar(100) NOT NULL,
    password    varchar(255) NOT NULL,
    dept_id     bigint(20)   NULL,
    create_time datetime     NOT NULL,
    update_time datetime     NULL,
    create_uid  bigint(20)   NOT NULL,
    update_uid  bigint(20)   NULL,
    deleted     tinyint(1)   NOT NULL,
    PRIMARY KEY (id)
);

create UNIQUE INDEX sys_user_username_uindex on sys_user (username);

-- 用户-角色关系表
CREATE TABLE sys_user_role
(
    id          bigint(20) NOT NULL,
    user_id     bigint(20) NOT NULL,
    rid         bigint(20) NOT NULL,
    create_time datetime   NOT NULL,
    update_time datetime   NULL,
    create_uid  bigint(20) NOT NULL,
    update_uid  bigint(20) NULL,
    PRIMARY KEY (id)
);
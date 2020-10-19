-- 菜单
INSERT INTO SYS_MENU VALUES (1, '系统管理', '错误页面', 2, '/admin', '', 'el-icon-s-tools', 1, -1, 1, TO_DATE('2020-07-02 14:50:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-02 14:50:30', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (2, '用户管理', '500', 2, 'user', 'views/upms/user', 'icon-user', 11, 1, 1, TO_DATE('2020-03-21 06:54:57', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-21 14:54:57', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (3, '角色管理', '400', 2, 'role', 'views/upms/role', 'icon-jiaoseguanli', 12, 1, 2, TO_DATE('2020-03-21 06:55:56', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-21 14:55:56', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (4, '菜单管理', '菜单', 2, 'menu', 'views/upms/menu', 'icon-caidan1', 13, 1, 3, TO_DATE('2020-03-21 06:54:09', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-21 14:54:09', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (5, '权限管理', NULL, 2, 'perm', 'views/upms/perm', 'icon-jiaosequanxian', 14, 1, 4, TO_DATE('2020-03-21 06:58:02', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-21 14:58:03', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (6, '新增用户', NULL, 3, '', '', '', 111, 11, 111, TO_DATE('2020-07-02 17:34:27', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-02 17:34:37', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (7, '更新用户', NULL, 3, '', '', '', 112, 11, 112, TO_DATE('2020-07-02 17:55:55', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-02 17:56:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (8, '用户列表', NULL, 3, '', '', '', 110, 11, 110, TO_DATE('2020-07-03 08:59:43', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 08:59:54', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (9, '角色列表', NULL, 3, '', '', '', 120, 12, 120, TO_DATE('2020-07-03 11:27:50', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:28:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (10, '创建角色', NULL, 3, '', '', '', 121, 12, 121, TO_DATE('2020-07-03 11:19:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:19:10', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (11, '更新角色', NULL, 3, '', '', '', 123, 12, 123, TO_DATE('2020-07-03 11:28:02', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:28:13', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (12, '删除角色', NULL, 3, '', '', '', 124, 12, 124, TO_DATE('2020-07-03 11:28:10', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:28:21', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (13, '删除用户', NULL, 3, '', '', '', 112, 11, 112, TO_DATE('2020-07-02 17:56:02', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-02 17:56:12', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (14, '菜单列表', NULL, 3, '', '', '', 131, 13, 131, TO_DATE('2020-07-03 11:17:39', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:17:49', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (15, '创建菜单', NULL, 3, '', '', '', 132, 13, 132, TO_DATE('2020-07-03 11:16:09', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:16:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (16, '更新菜单', NULL, 3, '', '', '', 133, 13, 133, TO_DATE('2020-03-21 14:45:56', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-21 14:45:56', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (17, '删除菜单', NULL, 3, '', '', '', 134, 13, 134, TO_DATE('2020-07-03 11:17:53', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:18:03', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (18, '权限列表', NULL, 3, '', '', '', 141, 14, 141, TO_DATE('2020-07-03 11:30:43', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:30:53', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (19, '更新角色菜单权限', NULL, 3, '', '', '', 125, 12, 125, TO_DATE('2020-07-03 11:39:35', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:39:45', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (20, '首页', NULL, 1, '/wel/index', '', 'el-icon-document', 10, -1, 50, TO_DATE('2020-03-21 13:29:51', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-21 21:29:51', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (21, '文档', NULL, 1, 'https://fymd.gitee.io/minion/', '', 'el-icon-document', 30, -1, 60, TO_DATE('2020-03-21 13:29:58', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-21 21:29:58', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (22, '重载权限', NULL, 3, '', '', '', 142, 14, 142, TO_DATE('2020-07-03 11:40:28', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:40:38', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU VALUES (23, '删除权限', NULL, 3, '', '', '', 143, 14, 143, TO_DATE('2020-07-03 11:40:36', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:40:47', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);

-- 菜单-权限-关系
INSERT INTO SYS_MENU_PERM VALUES (1, 16, '6d6c4b865cfe0a0df18cc3823f442138', TO_DATE('2020-07-03 11:15:14', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-21 14:45:56', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU_PERM VALUES (2, 6,  'a2152594edba84e83b43b14e376830b0', TO_DATE('2020-07-02 17:34:38', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-02 17:34:38', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU_PERM VALUES (3, 7,  '0b198531be1d236727f87ad030be3d2b', TO_DATE('2020-07-02 17:56:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-02 17:56:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU_PERM VALUES (4, 13, '1ec9aa46543aea9e83722e7fa16ee193', TO_DATE('2020-07-02 17:56:12', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-02 17:56:12', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU_PERM VALUES (5, 8,  'b226af2d9a1270822c2d2cbd70316f96', TO_DATE('2020-07-03 08:59:54', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 08:59:54', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU_PERM VALUES (6, 8,  'e77ff0adab18c95f75e13d477b569d69', TO_DATE('2020-07-03 08:59:54', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 08:59:54', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU_PERM VALUES (7, 15, '9750444b3247f1c9b175c4691e62bae2', TO_DATE('2020-07-03 11:16:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:16:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU_PERM VALUES (8, 14, '1ec86d1f1940932f299de033e16d7dc3', TO_DATE('2020-07-03 11:17:49', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:17:49', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU_PERM VALUES (9, 14, '56e56d875d1cd5adcae1a30c00a88f0e', TO_DATE('2020-07-03 11:17:49', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:17:49', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU_PERM VALUES (10, 17, '355c836412b15afffa9d7e05c6dd6e3f', TO_DATE('2020-07-03 11:18:03', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:18:03', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU_PERM VALUES (11, 10, '776ec71ccdffb353db4a88e71d1f73a8', TO_DATE('2020-07-03 11:19:10', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:19:10', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU_PERM VALUES (12, 9,  '1ec86d1f1940932f299de033e16d7dc3', TO_DATE('2020-07-03 11:28:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:28:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU_PERM VALUES (13, 9,  'da3fa36b04b33fc4c24a2192fa98a129', TO_DATE('2020-07-03 11:28:00', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:28:00', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU_PERM VALUES (14, 11, '521ec78d42e9329585d4c8e0e09f4cad', TO_DATE('2020-07-03 11:28:13', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:28:13', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU_PERM VALUES (15, 12, 'dace5c3dc2e1b2de682bb3b34f5297d5', TO_DATE('2020-07-03 11:28:21', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:28:21', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU_PERM VALUES (16, 18, '2d119a2cfcb3d34eaa51a9058a5ecc6a', TO_DATE('2020-07-03 11:30:53', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:30:53', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU_PERM VALUES (17, 19, '56e56d875d1cd5adcae1a30c00a88f0e', TO_DATE('2020-07-03 11:39:45', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:39:45', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU_PERM VALUES (18, 19, '879c83fbd96bad12b6d58f782fd37e82', TO_DATE('2020-07-03 11:39:45', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:39:45', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU_PERM VALUES (19, 19, 'b9bdbd66666e615c5635c4d232fe84ab', TO_DATE('2020-07-03 11:39:45', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:39:45', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU_PERM VALUES (20, 22, '73b406f4e9d929bdecf457e1dd790a75', TO_DATE('2020-07-03 11:40:39', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:40:39', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_MENU_PERM VALUES (21, 23, '262416c26b5cb25e499b7f86f066e5af', TO_DATE('2020-07-03 11:40:47', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 11:40:47', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);

-- 权限
INSERT INTO SYS_PERM VALUES ('0b198531be1d236727f87ad030be3d2b', '用户', '更新用户', '', '/upms/user', 'PUT', 'sys_user_update', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('1c1de9ec9bac57118e08bb6c6e782215', '用户', '登出', '', '/upms/user/logout', 'GET', '', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('1ec86d1f1940932f299de033e16d7dc3', '权限', '获取所有权限', '', '/upms/perm/all', 'GET', 'sys_perm_all', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('1ec9aa46543aea9e83722e7fa16ee193', '用户', '删除用户', '', '/upms/user/{id:\\d+}', 'DELETE', 'sys_user_delete', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('262416c26b5cb25e499b7f86f066e5af', '权限', '删除权限', '', '/upms/perm/{id}', 'DELETE', 'sys_perm_delete', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('268b7e7978161450cff5e678b63adb14', '验证码', '获取验证码', '', '/code', 'GET', '', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('2d119a2cfcb3d34eaa51a9058a5ecc6a', '权限', '分页获取权限', '', '/upms/perm', 'GET', 'sys_perm_list', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('3487c085e1f253072d0ff38802708718', '用户', '用户登录', '', '/upms/user/login', 'POST', '', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('355c836412b15afffa9d7e05c6dd6e3f', '菜单', '删除菜单', '', '/upms/menu/{id:\\d+}', 'DELETE', 'sys_menu_delete', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('42f1874a99f48c83a846cac72a184a14', '菜单', '获取顶部菜单', '', '/upms/menu/getTopMenu', 'GET', '', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('521ec78d42e9329585d4c8e0e09f4cad', '权限', '更新角色', '', '/upms/role', 'PUT', 'sys_role_update', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('56e56d875d1cd5adcae1a30c00a88f0e', '菜单', '获取所有菜单', '', '/upms/menu', 'GET', 'sys_menu_list', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('6d6c4b865cfe0a0df18cc3823f442138', '菜单', '更新菜单', '', '/upms/menu', 'PUT', 'sys_menu_update', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('73b406f4e9d929bdecf457e1dd790a75', '权限', '重载权限', '', '/upms/perm/reload', 'PUT', 'sys_perm_reload', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('776ec71ccdffb353db4a88e71d1f73a8', '权限', '创建角色', '', '/upms/role', 'POST', 'sys_role_create', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('8213e56a0188bddc2573ff02e833d1e8', '菜单', '获取左侧菜单', '', '/upms/menu/getMenu', 'GET', '', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('84ea8f335b26c45e9ca89417d461cc4d', '用户', '获取当前用户信息', '', '/upms/user/getUserInfo', 'GET', '', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('879c83fbd96bad12b6d58f782fd37e82', '菜单', '获取角色的菜单', '', '/upms/menu/role', 'GET', 'sys_menu_role_get', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('9750444b3247f1c9b175c4691e62bae2', '菜单', '创建菜单', '', '/upms/menu', 'POST', 'sys_menu_create', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('a2152594edba84e83b43b14e376830b0', '用户', '创建用户', '', '/upms/user', 'POST', 'sys_user_create', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('b226af2d9a1270822c2d2cbd70316f96', '用户', '获取用户列表', '', '/upms/user', 'GET', 'sys_user_list', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('b9bdbd66666e615c5635c4d232fe84ab', '菜单', '更新角色的菜单', '', '/upms/menu/role', 'PUT', 'sys_menu_role_update', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('da3fa36b04b33fc4c24a2192fa98a129', '权限', '分页获取角色', '', '/upms/role', 'GET', 'sys_role_list', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('dace5c3dc2e1b2de682bb3b34f5297d5', '权限', '删除角色', '', '/upms/role/{id:\\d+}', 'DELETE', 'sys_role_delete', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('e77ff0adab18c95f75e13d477b569d69', '权限', '获取所有角色', '', '/upms/role/all', 'GET', 'sys_role_all', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_PERM VALUES ('a9332353eb99d11721c8e91c79f73ce5', '用户', '修改密码', '', '/upms/user/changePassword', 'POST', '', TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-04 23:01:05', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);

-- 角色
INSERT INTO SYS_ROLE VALUES (1, '管理员', 'role_admin', '管理员（不要删除哦）', TO_DATE('2020-03-21 14:01:31', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-21 22:01:32', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);

-- 角色-菜单关系
INSERT INTO SYS_ROLE_MENU VALUES (1, 1, 1, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (2, 1, 2, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (3, 1, 8, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (4, 1, 6, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (5, 1, 7, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (6, 1, 13, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (7, 1, 3, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (8, 1, 9, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (9, 1, 10, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (10, 1, 11, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (11, 1, 12, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (12, 1, 19, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (13, 1, 4, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (14, 1, 14, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (15, 1, 15, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (16, 1, 16, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (17, 1, 17, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (18, 1, 5, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (19, 1, 18, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (20, 1, 22, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (21, 1, 23, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (22, 1, 20, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO SYS_ROLE_MENU VALUES (23, 1, 21, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);

-- 用户
INSERT INTO SYS_USER VALUES (1, 'admin', '13800138000', '13025667098a@gmail.com', '{bcrypt}$2a$10$wOR9pMjwEE8dhoCquVFqXe7nBy.Dm2gDYHnG5.GV/AB.taF744J0.', NULL, TO_DATE('2020-07-03 16:41:06', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 16:41:17', 'YYYY-MM-DD HH24:MI:SS'), 1, 1, 0);
INSERT INTO SYS_USER VALUES (2, 'DHB', '100010', 'xx158@qq.com', '{bcrypt}$2a$10$wsugThnpTpm2090fhj9.5OvhWpH.8eM0eZM85HFN/PzaeaYIq6oeO', NULL, TO_DATE('2020-07-03 14:30:21', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 14:30:31', 'YYYY-MM-DD HH24:MI:SS'), 0, 1, 0);

-- 用户-角色关系
INSERT INTO SYS_USER_ROLE VALUES (1, 1, 1, TO_DATE('2020-07-03 16:41:16', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-07-03 16:41:16', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);


-- 字典数据
INSERT INTO sys_menu VALUES (24, '字典管理', '字典', 2, 'sysDict', 'views/upms/sysDict', 'icon-zidianbiaoguanli', 15, 1, 15, TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), null, 1, 1);
INSERT INTO sys_menu VALUES (25, '字典列表', '字典列表', 3, '', '', '', 151, 15, 151, TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), null, 1, 1);
INSERT INTO sys_menu VALUES (26, '新增字典', '新增字典', 3, '', '', '', 152, 15, 152, TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), null, 1, 1);
INSERT INTO sys_menu VALUES (27, '更新字典', '更新字典', 3, '', '', '', 153, 15, 153, TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), null, 1, 1);
INSERT INTO sys_menu VALUES (28, '删除字典', '删除字典', 3, '', '', '', 154, 15, 154, TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), null, 1, 1);
INSERT INTO sys_menu VALUES (29, '字典项', '字典项', 3, '', '', '', 155, 15, 155, TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), null, 1, 1);
INSERT INTO sys_perm VALUES ('a68cfc9c860eacb1444f400004f5687c',     '字典', '字典列表', '', '/upms/sysDict', 'GET', 'SYS_DICT_page', TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_perm VALUES ('868238d988bdbd5bd5c1f6deb0b7d4e0',   '字典', '新增字典', '', '/upms/sysDict', 'POST', 'SYS_DICT_create', TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_perm VALUES ('66c54726208119aca6e2590ec80b1f99',   '字典', '删除字典', '', '/upms/sysDict/{id:\\d+}', 'DELETE', 'SYS_DICT_delete', TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_perm VALUES ('1620fb3b447018f5c31b30917a1b558d',   '字典', '更新字典', '', '/upms/sysDict', 'PUT', 'SYS_DICT_update', TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_perm VALUES ('25a14bbb5914257d8550392f333f8920', '字典', '通过id获取字典', '', '/upms/sysDict/{id:\\d+}', 'GET', 'SYS_DICT_retrieve', TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_menu_perm VALUES (22, 25,     'a68cfc9c860eacb1444f400004f5687c',  TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_menu_perm VALUES (23, 26, '868238d988bdbd5bd5c1f6deb0b7d4e0',   TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_menu_perm VALUES (24, 27, '1620fb3b447018f5c31b30917a1b558d',   TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_menu_perm VALUES (25, 28, '66c54726208119aca6e2590ec80b1f99', TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_menu_perm VALUES (26, 29, '9a339e9fc4fbc5b5a36f741413c4af72', TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_menu_perm VALUES (27, 29, 'f290dff400b71f0cd38fb0c70fe67c4e', TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_menu_perm VALUES (28, 29, '23dd4a7f04b612f39b8c345506a14135', TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_menu_perm VALUES (29, 29, 'f197436087cc2f95d6aceba1635d70dd', TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_menu_perm VALUES (30, 29, 'db7de42eaa0ab384e2b795672f5b74e1', TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-10-16 09:04:44', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_role_menu VALUES (24, 1, 24, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_role_menu VALUES (25, 1, 25, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_role_menu VALUES (26, 1, 26, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_role_menu VALUES (27, 1, 27, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_role_menu VALUES (28, 1, 28, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_role_menu VALUES (29, 1, 29, TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-03-26 00:01:20', 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_perm VALUES ('9a339e9fc4fbc5b5a36f741413c4af72',     '字典项', '字典项列表', '', '/upms/sysDictItem', 'GET', 'SYS_DICT_ITEM_page', TO_DATE('2020-10-16 11:36:20' , 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-10-16 11:36:20' , 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_perm VALUES ('f290dff400b71f0cd38fb0c70fe67c4e',   '字典项', '新增字典项', '', '/upms/sysDictItem', 'POST', 'SYS_DICT_ITEM_create', TO_DATE('2020-10-16 11:36:20' , 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-10-16 11:36:20' , 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_perm VALUES ('23dd4a7f04b612f39b8c345506a14135',   '字典项', '删除字典项', '', '/upms/sysDictItem/{id:\\d+}', 'DELETE', 'SYS_DICT_ITEM_delete', TO_DATE('2020-10-16 11:36:20' , 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-10-16 11:36:20' , 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_perm VALUES ('f197436087cc2f95d6aceba1635d70dd',   '字典项', '更新字典项', '', '/upms/sysDictItem', 'PUT', 'SYS_DICT_ITEM_update', TO_DATE('2020-10-16 11:36:20' , 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-10-16 11:36:20' , 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO sys_perm VALUES ('db7de42eaa0ab384e2b795672f5b74e1', '字典项', '通过id获取字典项', '', '/upms/sysDictItem/{id:\\d+}', 'GET', 'SYS_DICT_ITEM_retrieve', TO_DATE('2020-10-16 11:36:20' , 'YYYY-MM-DD HH24:MI:SS'), TO_DATE('2020-10-16 11:36:20' , 'YYYY-MM-DD HH24:MI:SS'), 1, 1);
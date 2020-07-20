-- 菜单
INSERT INTO sys_menu VALUES (1, '系统管理', '错误页面', 2, '/admin', '', 'el-icon-s-tools', 1, -1, 1, '2020-07-02 14:50:20', '2020-07-02 14:50:30', 1, 1);
INSERT INTO sys_menu VALUES (2, '用户管理', '500', 2, 'user', 'views/upms/user', 'el-icon-user-solid', 11, 1, 1, '2020-03-21 06:54:57', '2020-03-21 14:54:57', 1, 1);
INSERT INTO sys_menu VALUES (3, '角色管理', '400', 2, 'role', 'views/upms/role', 'el-icon-s-custom', 12, 1, 2, '2020-03-21 06:55:56', '2020-03-21 14:55:56', 1, 1);
INSERT INTO sys_menu VALUES (4, '菜单管理', '菜单', 2, 'menu', 'views/upms/menu', 'el-icon-menu', 13, 1, 3, '2020-03-21 06:54:09', '2020-03-21 14:54:09', 1, 1);
INSERT INTO sys_menu VALUES (5,  '权限管理', NULL, 2, 'perm', 'views/upms/perm', 'el-icon-s-platform', 14, 1, 4, '2020-03-21 06:58:02', '2020-03-21 14:58:03', 1, 1);
INSERT INTO sys_menu VALUES (6,  '新增用户', NULL, 3, '', '', '', 111, 11, 111, '2020-07-02 17:34:27', '2020-07-02 17:34:37', 1, 1);
INSERT INTO sys_menu VALUES (7,  '更新用户', NULL, 3, '', '', '', 112, 11, 112, '2020-07-02 17:55:55', '2020-07-02 17:56:05', 1, 1);
INSERT INTO sys_menu VALUES (8,  '用户列表', NULL, 3, '', '', '', 110, 11, 110, '2020-07-03 08:59:43', '2020-07-03 08:59:54', 1, 1);
INSERT INTO sys_menu VALUES (9,  '角色列表', NULL, 3, '', '', '', 120, 12, 120, '2020-07-03 11:27:50', '2020-07-03 11:28:00', 1, 1);
INSERT INTO sys_menu VALUES (10, '创建角色', NULL, 3, '', '', '', 121, 12, 121, '2020-07-03 11:19:00', '2020-07-03 11:19:10', 1, 1);
INSERT INTO sys_menu VALUES (11, '更新角色', NULL, 3, '', '', '', 123, 12, 123, '2020-07-03 11:28:02', '2020-07-03 11:28:13', 1, 1);
INSERT INTO sys_menu VALUES (12, '删除角色', NULL, 3, '', '', '', 124, 12, 124, '2020-07-03 11:28:10', '2020-07-03 11:28:21', 1, 1);
INSERT INTO sys_menu VALUES (13, '删除用户', NULL, 3, '', '', '', 112, 11, 112, '2020-07-02 17:56:02', '2020-07-02 17:56:12', 1, 1);
INSERT INTO sys_menu VALUES (14, '菜单列表', NULL, 3, '', '', '', 131, 13, 131, '2020-07-03 11:17:39', '2020-07-03 11:17:49', 1, 1);
INSERT INTO sys_menu VALUES (15, '创建菜单', NULL, 3, '', '', '', 132, 13, 132, '2020-07-03 11:16:09', '2020-07-03 11:16:20', 1, 1);
INSERT INTO sys_menu VALUES (16, '更新菜单', NULL, 3, '', '', '', 133, 13, 133, '2020-03-21 14:45:56', '2020-03-21 14:45:56', 1, 1);
INSERT INTO sys_menu VALUES (17, '删除菜单', NULL, 3, '', '', '', 134, 13, 134, '2020-07-03 11:17:53', '2020-07-03 11:18:03', 1, 1);
INSERT INTO sys_menu VALUES (18, '权限列表', NULL, 3, '', '', '', 141, 14, 141, '2020-07-03 11:30:43', '2020-07-03 11:30:53', 1, 1);
INSERT INTO sys_menu VALUES (19, '更新角色菜单权限', NULL, 3, '', '', '', 125, 12, 125, '2020-07-03 11:39:35', '2020-07-03 11:39:45', 1, 1);
INSERT INTO sys_menu VALUES (20, '首页', NULL, 1, '/wel/index', '', 'el-icon-document', 10, -1, 50, '2020-03-21 13:29:51', '2020-03-21 21:29:51', 1, 1);
INSERT INTO sys_menu VALUES (21, '文档', NULL, 1, 'https://fymd.gitee.io/beluga/', '', 'el-icon-document', 30, -1, 60, '2020-03-21 13:29:58', '2020-03-21 21:29:58', 1, 1);
INSERT INTO sys_menu VALUES (22, '重载权限', NULL, 3, '', '', '', 142, 14, 142, '2020-07-03 11:40:28', '2020-07-03 11:40:38', 1, 1);
INSERT INTO sys_menu VALUES (23, '删除权限', NULL, 3, '', '', '', 143, 14, 143, '2020-07-03 11:40:36', '2020-07-03 11:40:47', 1, 1);

-- 菜单-权限-关系
INSERT INTO sys_menu_perm VALUES (1, 16, '6d6c4b865cfe0a0df18cc3823f442138', '2020-07-03 11:15:14', '2020-03-21 14:45:56', 1, 1);
INSERT INTO sys_menu_perm VALUES (2, 6,  'a2152594edba84e83b43b14e376830b0', '2020-07-02 17:34:38', '2020-07-02 17:34:38', 1, 1);
INSERT INTO sys_menu_perm VALUES (3, 7,  '0b198531be1d236727f87ad030be3d2b', '2020-07-02 17:56:05', '2020-07-02 17:56:05', 1, 1);
INSERT INTO sys_menu_perm VALUES (4, 13, '1ec9aa46543aea9e83722e7fa16ee193', '2020-07-02 17:56:12', '2020-07-02 17:56:12', 1, 1);
INSERT INTO sys_menu_perm VALUES (5, 8,  'b226af2d9a1270822c2d2cbd70316f96', '2020-07-03 08:59:54', '2020-07-03 08:59:54', 1, 1);
INSERT INTO sys_menu_perm VALUES (6, 8,  'e77ff0adab18c95f75e13d477b569d69', '2020-07-03 08:59:54', '2020-07-03 08:59:54', 1, 1);
INSERT INTO sys_menu_perm VALUES (7, 15, '9750444b3247f1c9b175c4691e62bae2', '2020-07-03 11:16:20', '2020-07-03 11:16:20', 1, 1);
INSERT INTO sys_menu_perm VALUES (8, 14, '1ec86d1f1940932f299de033e16d7dc3', '2020-07-03 11:17:49', '2020-07-03 11:17:49', 1, 1);
INSERT INTO sys_menu_perm VALUES (9, 14, '56e56d875d1cd5adcae1a30c00a88f0e', '2020-07-03 11:17:49', '2020-07-03 11:17:49', 1, 1);
INSERT INTO sys_menu_perm VALUES (10, 17,'355c836412b15afffa9d7e05c6dd6e3f', '2020-07-03 11:18:03', '2020-07-03 11:18:03', 1, 1);
INSERT INTO sys_menu_perm VALUES (11, 10,'776ec71ccdffb353db4a88e71d1f73a8', '2020-07-03 11:19:10', '2020-07-03 11:19:10', 1, 1);
INSERT INTO sys_menu_perm VALUES (12, 9, '1ec86d1f1940932f299de033e16d7dc3', '2020-07-03 11:28:00', '2020-07-03 11:28:00', 1, 1);
INSERT INTO sys_menu_perm VALUES (13, 9, 'da3fa36b04b33fc4c24a2192fa98a129', '2020-07-03 11:28:00', '2020-07-03 11:28:00', 1, 1);
INSERT INTO sys_menu_perm VALUES (14, 11,'521ec78d42e9329585d4c8e0e09f4cad', '2020-07-03 11:28:13', '2020-07-03 11:28:13', 1, 1);
INSERT INTO sys_menu_perm VALUES (15, 12,'dace5c3dc2e1b2de682bb3b34f5297d5', '2020-07-03 11:28:21', '2020-07-03 11:28:21', 1, 1);
INSERT INTO sys_menu_perm VALUES (16, 18,'2d119a2cfcb3d34eaa51a9058a5ecc6a', '2020-07-03 11:30:53', '2020-07-03 11:30:53', 1, 1);
INSERT INTO sys_menu_perm VALUES (17, 19,'56e56d875d1cd5adcae1a30c00a88f0e', '2020-07-03 11:39:45', '2020-07-03 11:39:45', 1, 1);
INSERT INTO sys_menu_perm VALUES (18, 19,'879c83fbd96bad12b6d58f782fd37e82', '2020-07-03 11:39:45', '2020-07-03 11:39:45', 1, 1);
INSERT INTO sys_menu_perm VALUES (19, 19,'b9bdbd66666e615c5635c4d232fe84ab', '2020-07-03 11:39:45', '2020-07-03 11:39:45', 1, 1);
INSERT INTO sys_menu_perm VALUES (20, 22,'73b406f4e9d929bdecf457e1dd790a75', '2020-07-03 11:40:39', '2020-07-03 11:40:39', 1, 1);
INSERT INTO sys_menu_perm VALUES (21, 23,'262416c26b5cb25e499b7f86f066e5af', '2020-07-03 11:40:47', '2020-07-03 11:40:47', 1, 1);

-- 权限
INSERT INTO sys_perm VALUES ('0b198531be1d236727f87ad030be3d2b', '用户', '更新用户', '', '/upms/user', 'PUT', 'sys_user_update', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('1c1de9ec9bac57118e08bb6c6e782215', '用户', '登出', '', '/upms/user/logout', 'GET', '', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('1ec86d1f1940932f299de033e16d7dc3', '权限', '获取所有权限', '', '/upms/perm/all', 'GET', 'sys_perm_all', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('1ec9aa46543aea9e83722e7fa16ee193', '用户', '删除用户', '', '/upms/user/{id:\\d+}', 'DELETE', 'sys_user_delete', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('262416c26b5cb25e499b7f86f066e5af', '权限', '删除权限', '', '/upms/perm/{id}', 'DELETE', 'sys_perm_delete', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('268b7e7978161450cff5e678b63adb14', '验证码', '获取验证码', '', '/code', 'GET', '', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('2d119a2cfcb3d34eaa51a9058a5ecc6a', '权限', '分页获取权限', '', '/upms/perm', 'GET', 'sys_perm_list', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('3487c085e1f253072d0ff38802708718', '用户', '用户登录', '', '/upms/user/login', 'POST', '', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('355c836412b15afffa9d7e05c6dd6e3f', '菜单', '删除菜单', '', '/upms/menu/{id:\\d+}', 'DELETE', 'sys_menu_delete', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('42f1874a99f48c83a846cac72a184a14', '菜单', '获取顶部菜单', '', '/upms/menu/getTopMenu', 'GET', '', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('521ec78d42e9329585d4c8e0e09f4cad', '权限', '更新角色', '', '/upms/role', 'PUT', 'sys_role_update', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('56e56d875d1cd5adcae1a30c00a88f0e', '菜单', '获取所有菜单', '', '/upms/menu', 'GET', 'sys_menu_list', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('6d6c4b865cfe0a0df18cc3823f442138', '菜单', '更新菜单', '', '/upms/menu', 'PUT', 'sys_menu_update', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('73b406f4e9d929bdecf457e1dd790a75', '权限', '重载权限', '', '/upms/perm/reload', 'PUT', 'sys_perm_reload', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('776ec71ccdffb353db4a88e71d1f73a8', '权限', '创建角色', '', '/upms/role', 'POST', 'sys_role_create', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('8213e56a0188bddc2573ff02e833d1e8', '菜单', '获取左侧菜单', '', '/upms/menu/getMenu', 'GET', '', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('84ea8f335b26c45e9ca89417d461cc4d', '用户', '获取当前用户信息', '', '/upms/user/getUserInfo', 'GET', '', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('879c83fbd96bad12b6d58f782fd37e82', '菜单', '获取角色的菜单', '', '/upms/menu/role', 'GET', 'sys_menu_role_get', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('9750444b3247f1c9b175c4691e62bae2', '菜单', '创建菜单', '', '/upms/menu', 'POST', 'sys_menu_create', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('a2152594edba84e83b43b14e376830b0', '用户', '创建用户', '', '/upms/user', 'POST', 'sys_user_create', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('b226af2d9a1270822c2d2cbd70316f96', '用户', '获取用户列表', '', '/upms/user', 'GET', 'sys_user_list', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('b9bdbd66666e615c5635c4d232fe84ab', '菜单', '更新角色的菜单', '', '/upms/menu/role', 'PUT', 'sys_menu_role_update', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('da3fa36b04b33fc4c24a2192fa98a129', '权限', '分页获取角色', '', '/upms/role', 'GET', 'sys_role_list', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('dace5c3dc2e1b2de682bb3b34f5297d5', '权限', '删除角色', '', '/upms/role/{id:\\d+}', 'DELETE', 'sys_role_delete', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);
INSERT INTO sys_perm VALUES ('e77ff0adab18c95f75e13d477b569d69', '权限', '获取所有角色', '', '/upms/role/all', 'GET', 'sys_role_all', '2020-07-04 23:01:05', '2020-07-04 23:01:05', 1, 1);

-- 角色
INSERT INTO `sys_role` VALUES (1, '管理员', 'role_admin', '管理员（不要删除哦）', '2020-03-21 14:01:31', '2020-03-21 22:01:32', 1, 1);

-- 角色-菜单关系
INSERT INTO sys_role_menu VALUES (1, 1, 1, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (2, 1, 2, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (3, 1, 8, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (4, 1, 6, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (5, 1, 7, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (6, 1, 13, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (7, 1, 3, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (8, 1, 9, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (9, 1, 10, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (10, 1, 11, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (11, 1, 12, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (12, 1, 19, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (13, 1, 4, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (14, 1, 14, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (15, 1, 15, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (16, 1, 16, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (17, 1, 17, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (18, 1, 5, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (19, 1, 18, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (20, 1, 22, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (21, 1, 23, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (22, 1, 20, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);
INSERT INTO sys_role_menu VALUES (23, 1, 21, '2020-03-26 00:01:20', '2020-03-26 00:01:20', 1, 1);

-- 用户
INSERT INTO sys_user VALUES (1, 'admin', '13800138000', '13025667098a@gmail.com', '{bcrypt}$2a$10$wOR9pMjwEE8dhoCquVFqXe7nBy.Dm2gDYHnG5.GV/AB.taF744J0.', NULL, '2020-07-03 16:41:06', '2020-07-03 16:41:17', 1, 1, 0);
INSERT INTO sys_user VALUES (2, 'DHB', '100010', 'xx158@qq.com', '{bcrypt}$2a$10$wsugThnpTpm2090fhj9.5OvhWpH.8eM0eZM85HFN/PzaeaYIq6oeO', NULL, '2020-07-03 14:30:21', '2020-07-03 14:30:31', 0, 1, 0);

-- 用户-角色关系
INSERT INTO sys_user_role VALUES (1, 1, 1, '2020-07-03 16:41:16', '2020-07-03 16:41:16', 1, 1);

DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user
(
    id          bigint      NOT NULL AUTO_INCREMENT COMMENT 'ID',
    revision    INT         NOT NULL COMMENT '乐观锁',
    create_time DATETIME    NOT NULL COMMENT '创建时间',
    update_time DATETIME    NOT NULL COMMENT '更新时间',
    del_flag    VARCHAR(1)  NOT NULL DEFAULT 0 COMMENT '逻辑删除',
    work_id     VARCHAR(50) NOT NULL COMMENT '工号/学号',
    username    VARCHAR(50) NOT NULL COMMENT '用户名',
    password    VARCHAR(20) NOT NULL COMMENT '密码',
    nickname    VARCHAR(10) COMMENT '昵称',
    email       VARCHAR(50) COMMENT '邮箱',
    phone       VARCHAR(15) COMMENT '手机号',
    PRIMARY KEY (id)
) COMMENT = '用户系统表';


CREATE UNIQUE INDEX KEY_username ON sys_user (username);
CREATE UNIQUE INDEX KEY_work_id ON sys_user (work_id);

DROP TABLE IF EXISTS sys_user_team;
CREATE TABLE sys_user_team
(
    id                 bigint     NOT NULL AUTO_INCREMENT COMMENT 'ID',
    revision           INT        NOT NULL COMMENT '乐观锁',
    create_time        DATETIME   NOT NULL COMMENT '创建时间',
    update_time        DATETIME   NOT NULL COMMENT '更新时间',
    del_flag           VARCHAR(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
    user_id            INT        NOT NULL COMMENT '用户ID',
    team_id            INT        NOT NULL COMMENT '团队ID',
    user_team_nickname VARCHAR(50) COMMENT '团队内用户昵称',
    PRIMARY KEY (id)
) COMMENT = '用户-团队联系表';


CREATE UNIQUE INDEX KEY_user_team ON sys_user_team (user_id, team_id);

DROP TABLE IF EXISTS sys_team;
CREATE TABLE sys_team
(
    id          bigint      NOT NULL AUTO_INCREMENT COMMENT 'ID',
    revision    INT         NOT NULL COMMENT '乐观锁',
    create_time DATETIME    NOT NULL COMMENT '创建时间',
    update_time DATETIME    NOT NULL COMMENT '更新时间',
    del_flag    VARCHAR(1)  NOT NULL DEFAULT 0 COMMENT '逻辑删除',
    name        VARCHAR(50) NOT NULL COMMENT '团队名称',
    logo        VARCHAR(255) COMMENT '团队logo',
    PRIMARY KEY (id)
) COMMENT = '团队系统表';


CREATE UNIQUE INDEX KEY_name ON sys_team (name);

DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role
(
    id          bigint     NOT NULL AUTO_INCREMENT COMMENT 'ID',
    revision    INT        NOT NULL COMMENT '乐观锁',
    create_time DATETIME   NOT NULL COMMENT '创建时间',
    update_time DATETIME   NOT NULL COMMENT '更新时间',
    del_flag    VARCHAR(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
    user_id     INT        NOT NULL COMMENT '用户ID',
    role_id     INT        NOT NULL COMMENT '角色ID',
    PRIMARY KEY (id)
) COMMENT = '用户-角色联系表';


CREATE UNIQUE INDEX KEY_user_role ON sys_user_role (user_id, role_id);
CREATE INDEX KEY_user ON sys_user_role (user_id);

DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role
(
    id          bigint      NOT NULL AUTO_INCREMENT COMMENT 'ID',
    revision    INT         NOT NULL COMMENT '乐观锁',
    create_time DATETIME    NOT NULL COMMENT '创建时间',
    update_time DATETIME    NOT NULL COMMENT '更新时间',
    del_flag    VARCHAR(1)  NOT NULL DEFAULT 0 COMMENT '逻辑删除',
    team_id     bigint      NOT NULL COMMENT '团队ID',
    name        VARCHAR(50) NOT NULL COMMENT '角色名',
    code        VARCHAR(50) NOT NULL COMMENT '角色代码（英文大写）',
    sort        INT         NOT NULL COMMENT '角色层级（越大级别越高）',
    PRIMARY KEY (id)
) COMMENT = '角色系统表';


CREATE INDEX KEY_team ON sys_role (team_id);
CREATE INDEX KEY_team_code ON sys_role (team_id, code);

DROP TABLE IF EXISTS sys_function;
CREATE TABLE sys_function
(
    id          bigint       NOT NULL AUTO_INCREMENT COMMENT 'ID',
    revision    INT          NOT NULL COMMENT '乐观锁',
    create_time DATETIME     NOT NULL COMMENT '创建时间',
    update_time DATETIME     NOT NULL COMMENT '更新时间',
    del_flag    VARCHAR(1)   NOT NULL DEFAULT 0 COMMENT '逻辑删除',
    team_id     bigint       NOT NULL COMMENT '团队ID',
    parent_id   bigint       NOT NULL COMMENT '父功能ID',
    name        VARCHAR(50) COMMENT '名称',
    path        VARCHAR(255) NOT NULL COMMENT '路径',
    icon        VARCHAR(900) COMMENT '图标',
    PRIMARY KEY (id)
) COMMENT = '功能权限系统表';


CREATE INDEX KEY_team ON sys_function (team_id);
CREATE INDEX KEY_team_parent ON sys_function (team_id, parent_id);
CREATE INDEX KEY_team_path_parent ON sys_function (team_id, parent_id, path);

DROP TABLE IF EXISTS sys_role_function;
CREATE TABLE sys_role_function
(
    id          bigint       NOT NULL AUTO_INCREMENT COMMENT 'ID',
    revision    INT          NOT NULL COMMENT '乐观锁',
    create_time DATETIME     NOT NULL COMMENT '创建时间',
    update_time DATETIME     NOT NULL COMMENT '更新时间',
    del_flag    VARCHAR(1)   NOT NULL DEFAULT 0 COMMENT '逻辑删除',
    role_id     VARCHAR(255) NOT NULL COMMENT '角色ID',
    function_id VARCHAR(255) NOT NULL COMMENT '功能ID',
    PRIMARY KEY (id)
) COMMENT = '功能-角色联系表';


CREATE INDEX KEY_function ON sys_role_function (function_id);
CREATE INDEX KEY_role ON sys_role_function (role_id);

DROP TABLE IF EXISTS sys_permission;
CREATE TABLE sys_permission
(
    id            bigint       NOT NULL AUTO_INCREMENT COMMENT 'ID',
    revision      INT          NOT NULL COMMENT '乐观锁',
    create_time   DATETIME     NOT NULL COMMENT '创建时间',
    update_time   DATETIME     NOT NULL COMMENT '更新时间',
    del_flag      VARCHAR(1)   NOT NULL DEFAULT 0 COMMENT '逻辑删除',
    team_id       bigint       NOT NULL COMMENT '团队ID',
    path_rule     VARCHAR(100) NOT NULL COMMENT '路径规则',
    function_rule VARCHAR(50)  NOT NULL COMMENT '操作规则',
    PRIMARY KEY (id)
) COMMENT = '权限规则系统表';


CREATE INDEX KEY_team ON sys_permission (team_id);
CREATE INDEX KEY_team_path ON sys_permission (team_id, path_rule);

DROP TABLE IF EXISTS sys_role_permission;
CREATE TABLE sys_role_permission
(
    id            bigint     NOT NULL AUTO_INCREMENT COMMENT 'ID',
    revision      INT        NOT NULL COMMENT '乐观锁',
    create_time   DATETIME   NOT NULL COMMENT '创建时间',
    update_time   DATETIME   NOT NULL COMMENT '更新时间',
    del_flag      VARCHAR(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除',
    role_id       bigint     NOT NULL COMMENT '角色ID',
    permission_id bigint     NOT NULL COMMENT '权限ID',
    PRIMARY KEY (id)
) COMMENT = '角色-权限规则联系表';


CREATE INDEX KEY_role ON sys_role_permission (role_id);
CREATE INDEX KEY_permission ON sys_role_permission (permission_id);


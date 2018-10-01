delete from t_location;

INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('1', '信息园', 'XXY', '-1', '1', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('2', '楼栋', 'LD', '1', '1', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('3', '南栋', 'ND', '2', '1', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('4', '北栋', 'BD', '2', '1', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('5', '中栋', 'ZD', '2', '1', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('6', '附属楼', 'FSL', '2', '1', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('7', '连廊', 'LL', '2', '1', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('8', '地下室', 'DXS', '2', '1', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('9', '户外', 'HW', '1', '1', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('10', '中心花园', 'ZXHY', '9', '1', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('11', '前广场', 'QGG', '9', '0', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('12', '南向路', 'NXL', '9', '0', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('13', '北向路', 'BXL', '9', '0', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('14', '第一层', 'DYC', '3', '0', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('15', '第二层', 'DEC', '3', '0', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('16', '第三层', 'DSC', '3', '0', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('17', '第四层', 'DSC', '3', '0', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('18', '东向', 'DX', '14', '0', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('19', '南向', 'NX', '14', '0', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('20', '西向', 'XX', '14', '0', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('21', '北向', 'BX', '14', '0', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('22', '101房间', '101FJ', '18', '0', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('23', '102房间', '102FJ', '18', '0', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('24', '103房间', '103FJ', '18', '0', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('25', 'A区', 'AQ', '8', '0', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('26', 'B区', 'BQ', '8', '0', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('27', 'C区', 'CQ', '8', '0', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('28', '出入口', 'CRK', '9', '0', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('29', '东门', 'DM', '28', '0', now(), '1', now(), NULL, '1', NULL, NULL);
INSERT INTO `resmgr`.`t_location` (`id`, `name`, `code`, `parent_location_id`, `is_folder`, `create_time`, `create_user_id`, `update_time`, `update_user_id`, `dept_id`, `hierarchy`, `remark`)
VALUES ('30', '西门', 'XM', '28', '0', now(), '1', now(), NULL, '1', NULL, NULL);


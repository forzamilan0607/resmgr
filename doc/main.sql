DROP TABLE IF EXISTS sys_attr;
DROP TABLE IF EXISTS sys_attr_value;
DROP TABLE IF EXISTS sys_data_dict;
DROP TABLE IF EXISTS sys_department;
DROP TABLE IF EXISTS t_res_base_info;
DROP TABLE IF EXISTS t_res_type;
DROP TABLE IF EXISTS t_res_location;
DROP TABLE IF EXISTS t_res_purchase;
DROP TABLE IF EXISTS t_res_maintenance;
DROP TABLE IF EXISTS t_res_install_config;
DROP TABLE IF EXISTS t_res_component;
DROP TABLE IF EXISTS t_res_equip_param;


-- 属性定义
CREATE TABLE `sys_attr` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '属性ID',
  `name` varchar(32) NOT NULL COMMENT '属性名称',
  `type` int(10) NOT NULL COMMENT '属性类别，如：文本、数字、邮件、IP地址、下拉框等',
  `data_source` char(1) DEFAULT 1 COMMENT '数据来源，1、属性值表 2、字典表 3、业务表',
	`reg_expression` varchar(200) COMMENT '正则表达式',
	`query_text` varchar(10) COMMENT '数据来源=2时为字典KEY，=3时为业务表SQL',
  `status` char(1) NOT NULL DEFAULT 1 COMMENT '状态，1、有效，0、无效',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` int(10) COMMENT '创建人',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_user_id` int(10) COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='属性表';

-- 属性值定义
CREATE TABLE `sys_attr_value` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '属性值ID',
  `attr_id` int(10) NOT NULL COMMENT '属性ID',
  `value` varchar(50) NOT NULL COMMENT '属性值',
  `sort_order` tinyint(3) DEFAULT 1 COMMENT '顺序',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` int(10) COMMENT '创建人',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_user_id` int(10) COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='属性值表';

CREATE TABLE `sys_data_dict` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '字典ID',
  `name` varchar(32) NOT NULL COMMENT '字典名称',
  `type` varchar(50) NOT NULL COMMENT '字典类型',
  `value` varchar(200) COMMENT '字典项值',
  `ext_value` varchar(100) COMMENT '扩展值',
  `sort_order` tinyint(1) NOT NULL COMMENT '排序',
  `parent_id` int(10) COMMENT '父级字典',
  `parent_ids_text` varchar(100) COMMENT '父级字典ids，多个id以逗号分隔',
  `dict_desc` varchar(50) COMMENT '字典描述',
  `status` char(1) NOT NULL DEFAULT 1 COMMENT '状态，1、有效，0、无效',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` int(10) COMMENT '创建人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_user_id` int(10) COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典表';


-- 部门信息
CREATE TABLE `sys_department` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `name` varchar(32) NOT NULL COMMENT '部门名称',
  `park_id` int(10) NOT NULL COMMENT '园区ID',
  `parent_dept_id` int(10) NOT NULL COMMENT '上级部门ID',
  `status` char(1) NOT NULL DEFAULT 1 COMMENT '状态，1、有效，0、无效',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` int(10) COMMENT '创建人',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_user_id` int(10) COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门';

INSERT INTO `sys_department` (`id`, `name`, `park_id`, `parent_dept_id`, `status`, `create_time`, `create_user_id`, `update_time`, `update_user_id`) VALUES ('100001', '综合部', '1', '-1', '1', CURRENT_TIMESTAMP, '1', CURRENT_TIMESTAMP, NULL);

CREATE TABLE `sys_attachment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '附件ID',
  `name` varchar(64) NOT NULL COMMENT '附件名称',
  `url` varchar(255) NOT NULL COMMENT '附件URL',
  `obj_id` bigint(20) DEFAULT NULL COMMENT '对象ID',
  `obj_source` varchar(20) DEFAULT NULL COMMENT '对象来源',
  `size` int(10) DEFAULT NULL COMMENT '附件大小，KB为单位',
  `suffix_name` varchar(10) DEFAULT NULL COMMENT '文件后缀名',
  `type` varchar(10) DEFAULT NULL COMMENT '附件类型，如：图片、文档、视频',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` int(10) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_user_id` int(10) DEFAULT NULL COMMENT '修改人',
  `sort_order` tinyint(3) DEFAULT '0' COMMENT '顺序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='附件信息';


-- 资源基本信息
CREATE TABLE `t_res_base_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资源ID',
  `name` varchar(128) NOT NULL COMMENT '资源设备名称',
  `equip_id` int(10) NOT NULL COMMENT '设备ID',
  `code` varchar(128) COMMENT '资源编码',
  `res_type_id` int(10) NOT NULL COMMENT '资源类别',
  `brand` int(10) NOT NULL COMMENT '品牌',
  `series` int(10) NOT NULL COMMENT '系列',
  `model` int(10) COMMENT '型号',
  `factory_time` date COMMENT '出厂时间',
  `serial_no` varchar(64) NOT NULL COMMENT '整机序列号',
  `location_id` int(10) COMMENT '位置ID，如：调度大楼/中栋/3层/310房/东头/上方；附属楼/主楼/2层/走廊/西头/地面',
  `location_desc` varchar(255) COMMENT '描述性位置',
  `location_coordinate` varchar(20) COMMENT '坐标位置，如：F8、H13',
  `obj_id` varchar(32) COMMENT '三维图形对象ID',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` int(10) COMMENT '创建人',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_user_id` int(10) COMMENT '修改人',
  `dept_id` int(10) COMMENT '部门ID',
  `remark` varchar(512) COMMENT '资源描述',
  `person_responsible` int(10) COMMENT '责任人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源基本信息';

-- 资源类别
CREATE TABLE `t_res_type` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '资源类别ID',
  `name` varchar(52) NOT NULL COMMENT '资源类别名称',
  `code` varchar(52) NOT NULL COMMENT '资源类别编码',
  `parent_type_id` int(10) NOT NULL COMMENT '父级资源类别',
	`is_folder` char(1) DEFAULT 0 COMMENT '是否目录，1、是，0、否',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` int(10) COMMENT '创建人',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_user_id` int(10) COMMENT '修改人',
  `dept_id` int(10) COMMENT '部门ID',
  `hierarchy` varchar(512) COMMENT '资源类别层次结构',
  `remark` varchar(512) COMMENT '资源类别描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源类别';

-- 位置信息
CREATE TABLE `t_location` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '位置ID',
  `name` varchar(52) NOT NULL COMMENT '位置名称',
  `code` varchar(52) COMMENT '位置编码',
  `parent_location_id` int(10) NOT NULL COMMENT '父级位置类别',
	`is_folder` char(1) DEFAULT 0 COMMENT '是否目录，1、是，0、否',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` int(10) COMMENT '创建人',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_user_id` int(10) COMMENT '修改人',
  `dept_id` int(10) COMMENT '部门ID',
  `hierarchy` varchar(512) COMMENT '位置层次结构',
  `remark` varchar(512) COMMENT '位置描述',
  `has_children` tinyint(1) DEFAULT '0' COMMENT '是否有子节点,1、是，0、否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='位置信息';

-- 资源采购信息
CREATE TABLE `t_res_purchase` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '采购ID',
	`res_id` bigint(20) NOT NULL COMMENT '资源ID',
  `contract_company` varchar(50) COMMENT '合同单位',
  `contract_no` varchar(50) COMMENT '合同编号',
  `contract_attach` varchar(255) COMMENT '合同附件，多个附件ID以逗号分隔',
  `contract_desc` varchar(512) COMMENT '合同描述',
	`price` decimal(10,2) COMMENT '采购价格',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` int(10) COMMENT '创建人',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_user_id` int(10) COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源采购信息';


-- 资源运维信息
CREATE TABLE `t_res_maintenance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '运维ID',
	`res_id` bigint(20) NOT NULL COMMENT '资源ID',
  `maintain_dept_id` int(10) COMMENT '维护单位',
  `person_responsible` int(10) COMMENT '责任人',
  `warranty_start_date` date COMMENT '保修开始日期',
  `warranty_end_date` date COMMENT '保修结束日期',
  `maintain_company` varchar(50) COMMENT '维保单位',
  `maintain_period` date COMMENT '维保周期',
	`maintain_price` decimal(10,2) COMMENT '维保价格',
	`precautions_text` varchar(1000) COMMENT '运维或保养特别提示、注意事项（文字）',
	`res_status` int(10) COMMENT '设备状态,入库/在用/送修/注销',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` int(10) COMMENT '创建人',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_user_id` int(10) COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源运维信息';

-- 资源安装/配置信息
CREATE TABLE `t_res_install_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '安装配置ID',
	`res_id` bigint(20) NOT NULL COMMENT '资源ID',
	`operation_specification_text` varchar(3000) COMMENT '操作规范说明',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` int(10) COMMENT '创建人',
	`update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `update_user_id` int(10) COMMENT '修改人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源安装/配置信息';

-- 设备部件信息
CREATE TABLE `t_res_component` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部件ID',
  `res_id` bigint(20) NOT NULL COMMENT '资源ID',
  `name` varchar(64) NOT NULL COMMENT '部件名称',
  `serial_no` varchar(64) NOT NULL COMMENT '序列号',
  `dict_id` int(10) COMMENT '字典ID',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备部件信息';

-- 资源设备参数信息
CREATE TABLE `t_res_equip_param` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '参数ID',
	`res_id` bigint(20) NOT NULL COMMENT '资源ID',
	`attr_id` bigint(10) NOT NULL COMMENT '属性ID',
	`name` varchar(64) NOT NULL COMMENT '参数名称',
	`value` varchar(128) COMMENT '参数值',
  `dict_id` int(10) COMMENT '字典ID',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源设备参数信息';


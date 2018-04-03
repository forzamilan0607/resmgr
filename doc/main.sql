DROP TABLE IF EXISTS sys_attr;
DROP TABLE IF EXISTS sys_attr_value;
DROP TABLE IF EXISTS sys_dict;
DROP TABLE IF EXISTS sys_dict_item;
DROP TABLE IF EXISTS sys_department;
DROP TABLE IF EXISTS t_res_base_info;
DROP TABLE IF EXISTS t_res_attachment;
DROP TABLE IF EXISTS t_res_purchase;
DROP TABLE IF EXISTS t_res_maintenance;
DROP TABLE IF EXISTS t_res_install_config;
DROP TABLE IF EXISTS t_res_param_config;


-- 属性定义
CREATE TABLE `sys_attr` (
  `attr_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '属性ID',
  `attr_name` varchar(32) NOT NULL COMMENT '属性名称',
  `attr_type` int(10) NOT NULL COMMENT '属性类别，如：文本、数字、邮件、IP地址、下拉框等',
  `data_source` char(1) DEFAULT 1 COMMENT '数据来源，1、属性值表 2、字典表 3、业务表',
	`reg_expression` varchar(200) COMMENT '正则表达式',
	`query_text` varchar(10) COMMENT '数据来源=2时为字典KEY，=3时为业务表SQL',
  `status` char(1) NOT NULL DEFAULT 1 COMMENT '状态，1、有效，0、无效',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`is_sync` char(1) DEFAULT 0 COMMENT '是否同步，1、是，0、否',
  PRIMARY KEY (`attr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='属性表';

-- 属性值定义
CREATE TABLE `sys_attr_value` (
  `attr_value_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '属性值ID',
  `attr_id` int(10) NOT NULL COMMENT '属性ID',
  `attr_value` varchar(50) NOT NULL COMMENT '属性值',
  `sort_order` tinyint(3) DEFAULT 1 COMMENT '顺序',
	`is_sync` char(1) DEFAULT 0 COMMENT '是否同步，1、是，0、否',
  PRIMARY KEY (`attr_value_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='属性值表';

-- 字典
CREATE TABLE `sys_dict` (
  `dict_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '字典ID',
  `dict_name` varchar(32) NOT NULL COMMENT '字典名称',
  `dict_desc` varchar(50) NOT NULL COMMENT '字典描述',
  `parent_dict_id` int(10) COMMENT '父级字典ID',
  `status` char(1) NOT NULL DEFAULT 1 COMMENT '状态，1、有效，0、无效',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`is_sync` char(1) DEFAULT 0 COMMENT '是否同步，1、是，0、否',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';

CREATE TABLE `sys_dict_item` (
  `dict_item_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '字典项ID',
  `dict_id` int(10) NOT NULL COMMENT '字典ID',
  `dict_item_name` varchar(50) COMMENT '字典项值',
  `dict_item_value` varchar(200) COMMENT '字典项值',
  `ext_value1` varchar(100) COMMENT '扩展值1',
  `ext_value2` varchar(100) COMMENT '扩展值2',
  `sort_order` tinyint(1) NOT NULL COMMENT '排序',
	`is_sync` char(1) DEFAULT 0 COMMENT '是否同步，1、是，0、否',
  PRIMARY KEY (`dict_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门';

-- 部门信息
CREATE TABLE `sys_department` (
  `dept_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `dept_name` varchar(32) NOT NULL COMMENT '部门名称',
  `company_id` int(10) NOT NULL COMMENT '公司ID',
  `status` char(1) NOT NULL DEFAULT 1 COMMENT '状态，1、有效，0、无效',
	`create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` int(10) COMMENT '创建人',
	`modify_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modify_user_id` int(10) COMMENT '修改人',
	`is_sync` char(1) DEFAULT 0 COMMENT '是否同步，1、是，0、否',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门';

-- 资源基本信息
CREATE TABLE `t_res_base_info` (
  `res_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '资源ID',
  `res_type` int(10) NOT NULL COMMENT '资源类别',
  `brand` int(10) NOT NULL COMMENT '品牌',
  `series` int(10) NOT NULL COMMENT '系列',
  `model` int(10) NOT NULL COMMENT '型号',
  `factory_time` date COMMENT '出厂时间',
  `serial_no` varchar(32) NOT NULL COMMENT '整机序列号',
  `component_info` bigint(20) COMMENT '主要部件信息',
  `res_nameplate` varchar(100) COMMENT '资源铭牌，用于上传照片或其他附件，多个附件ID以逗号分隔',
  `position_desc` int(10) COMMENT '描述性位置，如：调度大楼/中栋/3层/310房/东头/上方；附属楼/主楼/2层/走廊/西头/地面',
  `position_coordinate` varchar(20) COMMENT '坐标位置，如：F8、H13',
  `obj_id` varchar(32) COMMENT '三维图形对象ID',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user_id` int(10) COMMENT '创建人',
	`modify_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `modify_user_id` int(10) COMMENT '修改人',
  `dept_id` int(10) COMMENT '部门ID',
  `person_responsible` int(10) COMMENT '责任人',
	`is_sync` char(1) DEFAULT 0 COMMENT '是否同步，1、是，0、否',
  PRIMARY KEY (`res_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源基本信息';

-- 资源附件
CREATE TABLE `t_res_attachment` (
  `attach_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '附件ID',
  `attach_name` varchar(52) NOT NULL COMMENT '附件名称',
  `res_id` bigint(20) NOT NULL COMMENT '资源ID',
  `attach_size` int(10) COMMENT '附件大小，KB为单位',
  `attach_type` int(10) COMMENT '附件类型，如：jpg、png、pdf、xls、word、mp4等',
	`upload_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
	`is_sync` char(1) DEFAULT 0 COMMENT '是否同步，1、是，0、否',
	`sort_order` tinyint(3) DEFAULT 0 COMMENT '顺序',
  PRIMARY KEY (`attach_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源附件';

-- 资源采购信息
CREATE TABLE `t_res_purchase` (
  `purchase_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '采购ID',
	`res_id` bigint(20) NOT NULL COMMENT '资源ID',
  `contract_company` varchar(50) COMMENT '合同单位',
  `contract_no` varchar(50) COMMENT '合同编号',
  `contract_attach` varchar(100) COMMENT '合同附件，多个附件ID以逗号分隔',
  `contract_desc` varchar(512) COMMENT '合同描述',
	`purchase_price` decimal(10,2) COMMENT '采购价格',
	`purchase_date` date COMMENT '采购时间',
	`is_sync` char(1) DEFAULT 0 COMMENT '是否同步，1、是，0、否',
  PRIMARY KEY (`purchase_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源采购信息';


-- 资源运维信息
CREATE TABLE `t_res_maintenance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '运维ID',
	`res_id` bigint(20) NOT NULL COMMENT '资源ID',
  `maintain_dept` int(10) COMMENT '维护单位',
  `person_responsible` int(10) COMMENT '责任人',
  `warranty_start_date` date COMMENT '保修开始日期',
  `warranty_end_date` date COMMENT '保修结束日期',
  `maintain_company` varchar(50) COMMENT '维保单位',
  `maintain_period` date COMMENT '维保周期',
	`maintain_price` decimal(10,2) COMMENT '维保价格',
	`maintain_contract` varchar(100) COMMENT '维保合同，多个附件ID以逗号分隔',
	`res_instructions` varchar(100) COMMENT '设备资源说明书，多个附件ID以逗号分隔',
	`precautions_text` varchar(1000) COMMENT '运维或保养特别提示、注意事项（文字）',
	`precautions_attach` varchar(100) COMMENT '运维或保养特别提示、注意事项（附件）',
	`res_status` int(10) COMMENT '设备状态,入库/在用/送修/注销',
	`is_sync` char(1) DEFAULT 0 COMMENT '是否同步，1、是，0、否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源运维信息';

-- 资源安装/配置信息
CREATE TABLE `t_res_install_config` (
  `config_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '安装配置ID',
	`res_id` bigint(20) NOT NULL COMMENT '资源ID',
	`drawing` varchar(100) COMMENT '图纸，多个附件ID以逗号分隔',
	`operation_specification_text` varchar(3000) COMMENT '操作规范说明',
	`operation_specification_attach` varchar(100) COMMENT '操作规范说明（附件），多个附件ID以逗号分隔',
	`is_sync` char(1) DEFAULT 0 COMMENT '是否同步，1、是，0、否',
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源安装/配置信息';

-- 资源参数配置信息
CREATE TABLE `t_res_param_config` (
	`res_id` bigint(20) NOT NULL COMMENT '资源ID',
	`attr_id` bigint(10) NOT NULL COMMENT '属性ID',
	`attr_value` varchar(500) COMMENT '属性值',
	`is_sync` char(1) DEFAULT 0 COMMENT '是否同步，1、是，0、否',
  PRIMARY KEY (`res_id`,`attr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源参数配置信息';


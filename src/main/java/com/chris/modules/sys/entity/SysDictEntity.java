package com.chris.modules.sys.entity;

import com.chris.common.model.SysUpdateInfo;
import com.oracle.deploy.update.UpdateInfo;

import java.io.Serializable;
import java.util.Date;


/**
 * 字典表
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
public class SysDictEntity extends SysUpdateInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//字典ID
	private Integer id;
	//字典名称
	private String name;
	//父级字典项
	private Integer parentDictitemId;
	//字典描述
	private String dictDesc;
	//状态，1、有效，0、无效
	private String status;

	public SysDictEntity() {
	}

	public SysDictEntity(Integer id) {
		this.id = id;
	}

	public SysDictEntity(String name) {
		this.name = name;
	}

	/**
	 * 设置：字典ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：字典ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：字典名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：字典名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：字典描述
	 */
	public void setDictDesc(String dictDesc) {
		this.dictDesc = dictDesc;
	}
	/**
	 * 获取：字典描述
	 */
	public String getDictDesc() {
		return dictDesc;
	}
	/**
	 * 设置：状态，1、有效，0、无效
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态，1、有效，0、无效
	 */
	public String getStatus() {
		return status;
	}

	public Integer getParentDictitemId() {
		return parentDictitemId;
	}

	public void setParentDictitemId(Integer parentDictitemId) {
		this.parentDictitemId = parentDictitemId;
	}
}

package com.chris.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 字典表
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
public class SysDictEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//字典ID
	private Integer dictId;
	//字典名称
	private String dictName;
	//字典KEY
	private String dictKey;
	//字典描述
	private String dictDesc;
	//父级字典ID
	private Integer parentDictId;
	//父级字典名称
	private String parentDicName;
	//状态，1、有效，0、无效
	private String status;
	//创建时间
	private Date createTime;
	//是否同步，1、是，0、否
	private String isSync;

	private List<SysDictItemEntity> dictItems;

	/**
	 * 设置：字典ID
	 */
	public void setDictId(Integer dictId) {
		this.dictId = dictId;
	}
	/**
	 * 获取：字典ID
	 */
	public Integer getDictId() {
		return dictId;
	}
	/**
	 * 设置：字典名称
	 */
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	/**
	 * 获取：字典名称
	 */
	public String getDictName() {
		return dictName;
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
	 * 设置：父级字典ID
	 */
	public void setParentDictId(Integer parentDictId) {
		this.parentDictId = parentDictId;
	}
	/**
	 * 获取：父级字典ID
	 */
	public Integer getParentDictId() {
		return parentDictId;
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
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：是否同步，1、是，0、否
	 */
	public void setIsSync(String isSync) {
		this.isSync = isSync;
	}
	/**
	 * 获取：是否同步，1、是，0、否
	 */
	public String getIsSync() {
		return isSync;
	}

	public String getParentDicName() {
		return parentDicName;
	}

	public void setParentDicName(String parentDicName) {
		this.parentDicName = parentDicName;
	}

	public List<SysDictItemEntity> getDictItems() {
		return dictItems;
	}

	public void setDictItems(List<SysDictItemEntity> dictItems) {
		this.dictItems = dictItems;
	}

	public String getDictKey() {
		return dictKey;
	}

	public void setDictKey(String dictKey) {
		this.dictKey = dictKey;
	}

	public SysDictEntity() {
	}

	public static SysDictEntity buildByDictKey(String dictKey) {
		SysDictEntity sysDictEntity = new SysDictEntity();
		sysDictEntity.setDictKey(dictKey);
		return sysDictEntity;
	}
}

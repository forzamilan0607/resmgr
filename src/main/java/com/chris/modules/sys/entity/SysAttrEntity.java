package com.chris.modules.sys.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 属性表
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Mar 22.18
 */
public class SysAttrEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//属性ID
	private Integer attrId;
	//属性名称
	private String attrName;
	//属性类别，如：文本、数字、邮件、IP地址、下拉框等
	private Integer attrType;
	//数据来源，1、属性值表 2、字典表 3、业务表
	private String dataSource;
	//正则表达式
	private String regExpression;
	//数据来源=2时为字典KEY，=3时为业务表SQL
	private String queryText;
	//状态，1、有效，0、无效
	private String status;
	//创建时间
	private Date createTime;
	//是否同步，1、是，0、否
	private String isSync;

	/**
	 * 设置：属性ID
	 */
	public void setAttrId(Integer attrId) {
		this.attrId = attrId;
	}
	/**
	 * 获取：属性ID
	 */
	public Integer getAttrId() {
		return attrId;
	}
	/**
	 * 设置：属性名称
	 */
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	/**
	 * 获取：属性名称
	 */
	public String getAttrName() {
		return attrName;
	}
	/**
	 * 设置：属性类别，如：文本、数字、邮件、IP地址、下拉框等
	 */
	public void setAttrType(Integer attrType) {
		this.attrType = attrType;
	}
	/**
	 * 获取：属性类别，如：文本、数字、邮件、IP地址、下拉框等
	 */
	public Integer getAttrType() {
		return attrType;
	}
	/**
	 * 设置：数据来源，1、属性值表 2、字典表 3、业务表
	 */
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	/**
	 * 获取：数据来源，1、属性值表 2、字典表 3、业务表
	 */
	public String getDataSource() {
		return dataSource;
	}
	/**
	 * 设置：正则表达式
	 */
	public void setRegExpression(String regExpression) {
		this.regExpression = regExpression;
	}
	/**
	 * 获取：正则表达式
	 */
	public String getRegExpression() {
		return regExpression;
	}
	/**
	 * 设置：数据来源=2时为字典KEY，=3时为业务表SQL
	 */
	public void setQueryText(String queryText) {
		this.queryText = queryText;
	}
	/**
	 * 获取：数据来源=2时为字典KEY，=3时为业务表SQL
	 */
	public String getQueryText() {
		return queryText;
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
}

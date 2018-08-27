package com.chris.modules.generator.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 属性表
 * 
 * @author chris
 * @email 258321511@qq.com
 * @since Aug 28.18
 */
public class SysAttrEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//属性ID
	private Integer id;
	//属性名称
	private String name;
	//属性类别，如：文本、数字、邮件、IP地址、下拉框等
	private Integer type;
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
	//创建人
	private Integer createUserId;
	//修改时间
	private Date updateTime;
	//修改人
	private Integer updateUserId;

	/**
	 * 设置：属性ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：属性ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：属性名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：属性名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：属性类别，如：文本、数字、邮件、IP地址、下拉框等
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：属性类别，如：文本、数字、邮件、IP地址、下拉框等
	 */
	public Integer getType() {
		return type;
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
	 * 设置：创建人
	 */
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	/**
	 * 获取：创建人
	 */
	public Integer getCreateUserId() {
		return createUserId;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}
	/**
	 * 获取：修改人
	 */
	public Integer getUpdateUserId() {
		return updateUserId;
	}
}

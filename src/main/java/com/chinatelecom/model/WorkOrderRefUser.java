package com.chinatelecom.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.buzheng.demo.esm.domain.SysUser;

public class WorkOrderRefUser {
	private Long id;

	private Long userId;

	private Long workOrderId;

	private String remark;

	private Date reachTime;

	private Date finishTime;

	private Integer state;

	private SysUser sysUser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getWorkOrderId() {
		return workOrderId;
	}

	public void setWorkOrderId(Long workOrderId) {
		this.workOrderId = workOrderId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Date getReachTime() {
		return reachTime;
	}

	public void setReachTime(Date reachTime) {
		this.reachTime = reachTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public String getFormatReachTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		return sdf.format(reachTime);
	}

	public String getFormatFinishTime() {
		if (finishTime != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
			return sdf.format(finishTime);
		} else {
			return "";
		}
	}

	public String getFormatState() {
		switch (state) {
		case 1:
			return "待处理";
		case 2:
			return "反馈";
		default:
			return "完成";
		}
	}
}
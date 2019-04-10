package org.buzheng.demo.esm.service;

public interface WorkOrderRefUserService {

	public boolean transmitToOthers(Long workOrderId, Long sourceUserId, String remark, String targetUserIds);

	public boolean endThisProcess(Long workOrderId, Long sourceUserId, String remark);

}

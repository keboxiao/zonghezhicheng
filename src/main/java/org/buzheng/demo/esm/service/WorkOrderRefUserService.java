package org.buzheng.demo.esm.service;

public interface WorkOrderRefUserService {

	public boolean transmitToOthers(Long workOrderId, Long sourceUserId, String remark, Long targetUserId);

}

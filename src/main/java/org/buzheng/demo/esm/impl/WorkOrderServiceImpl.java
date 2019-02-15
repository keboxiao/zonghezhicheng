package org.buzheng.demo.esm.impl;

import java.util.Date;

import org.buzheng.demo.esm.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.chinatelecom.dao.WorkOrderMapper;
import com.chinatelecom.dao.WorkOrderRefUserMapper;
import com.chinatelecom.model.WorkOrder;
import com.chinatelecom.model.WorkOrderRefUser;

public class WorkOrderServiceImpl implements WorkOrderService {

	@Autowired
	private WorkOrderMapper workOrderMapper;

	@Autowired
	private WorkOrderRefUserMapper workOrderRefUserMapper;

	@Override
	@Transactional
	public void createWorkOrder(WorkOrder workOrder, Long userId) {
		// TODO Auto-generated method stub
		workOrderMapper.insert(workOrder);
		WorkOrderRefUser workOrderRefUser = new WorkOrderRefUser();
		workOrderRefUser.setWorkOrderId(workOrder.getId());
		workOrderRefUser.setUserId(userId);
		workOrderRefUser.setReachTime(new Date());
		workOrderRefUser.setState(1);
		workOrderRefUserMapper.insert(workOrderRefUser);
	}

}

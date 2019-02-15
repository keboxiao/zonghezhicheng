package org.buzheng.demo.esm.service;

import com.chinatelecom.model.WorkOrder;

public interface WorkOrderService {

	public void createWorkOrder(WorkOrder workOrder, Long userId);

}

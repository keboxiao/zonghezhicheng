package org.buzheng.demo.esm.service;

import com.chinatelecom.model.DataGrid;
import com.chinatelecom.model.WorkOrder;

public interface WorkOrderService {

	public void createWorkOrder(WorkOrder workOrder, Long userId);
	
	public boolean deleteWorkOrder(Long workOrderId);

	public DataGrid getMyWorkOrderToBeProcessed(String title, Long userId, Integer page, Integer rows);
	
}

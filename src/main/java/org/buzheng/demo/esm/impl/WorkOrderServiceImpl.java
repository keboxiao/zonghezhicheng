package org.buzheng.demo.esm.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.buzheng.demo.esm.service.UpFileService;
import org.buzheng.demo.esm.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinatelecom.dao.UpFileMapper;
import com.chinatelecom.dao.WorkOrderMapper;
import com.chinatelecom.dao.WorkOrderRefUserMapper;
import com.chinatelecom.model.DataGrid;
import com.chinatelecom.model.UpFile;
import com.chinatelecom.model.UpFileExample;
import com.chinatelecom.model.WorkOrder;
import com.chinatelecom.model.WorkOrderRefUser;
import com.chinatelecom.model.WorkOrderRefUserExample;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class WorkOrderServiceImpl implements WorkOrderService {

	@Autowired
	private WorkOrderMapper workOrderMapper;

	@Autowired
	private WorkOrderRefUserMapper workOrderRefUserMapper;

	@Autowired
	private UpFileService upFileService;

	@Autowired
	private UpFileMapper upFileMapper;

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

	@Transactional
	public boolean deleteWorkOrder(Long workOrderId) {
		WorkOrderRefUserExample example = new WorkOrderRefUserExample();
		WorkOrderRefUserExample.Criteria criteria = example.createCriteria();
		criteria.andWorkOrderIdEqualTo(workOrderId);
		workOrderRefUserMapper.deleteByExample(example);
		workOrderMapper.deleteByPrimaryKey(workOrderId);
		UpFileExample uExample = new UpFileExample();
		UpFileExample.Criteria uCriteria = uExample.createCriteria();
		uCriteria.andFileClassEqualTo(2);
		uCriteria.andBatchNoEqualTo(workOrderId);
		List<UpFile> fileList = upFileMapper.selectByExample(uExample);
		for (UpFile tmp : fileList) {
			upFileService.deleteFile(tmp.getNo());
		}
		return true;
	}

	public DataGrid getMyWorkOrderToBeProcessed(String title, Long userId, Integer page, Integer rows) {
		PageHelper.startPage(page, rows);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("title", title);
		List list = workOrderMapper.getMyWorkOrderToBeProcessed(params);
		// 取分页信息
		Page<WorkOrder> pageInfo = (Page<WorkOrder>) list;
		DataGrid datagrid = new DataGrid();
		datagrid.setRows(list);
		datagrid.setTotal(pageInfo.getTotal());
		return datagrid;
	}
}

package org.buzheng.demo.esm.impl;

import java.util.Date;
import java.util.List;

import org.buzheng.demo.esm.service.WorkOrderRefUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinatelecom.dao.WorkOrderMapper;
import com.chinatelecom.dao.WorkOrderRefUserMapper;
import com.chinatelecom.model.WorkOrderRefUser;
import com.chinatelecom.model.WorkOrderRefUserExample;

@Service
public class WorkOrderRefUserServiceImpl implements WorkOrderRefUserService {

	@Autowired
	private WorkOrderMapper workOrderMapper;

	@Autowired
	private WorkOrderRefUserMapper workOrderRefUserMapper;

	@Override
	@Transactional
	public boolean transmitToOthers(Long workOrderId, Long sourceUserId, String remark, Long targetUserId) {
		WorkOrderRefUserExample example = new WorkOrderRefUserExample();
		WorkOrderRefUserExample.Criteria criteria = example.createCriteria();
		criteria.andWorkOrderIdEqualTo(workOrderId);
		criteria.andUserIdEqualTo(sourceUserId);
		criteria.andStateEqualTo(1);
		List<WorkOrderRefUser> list = workOrderRefUserMapper.selectByExample(example);
		WorkOrderRefUser workOrderRefUser = list.get(0);
		workOrderRefUser.setRemark(remark);
		workOrderRefUser.setFinishTime(new Date());
		workOrderRefUser.setState(3);
		workOrderRefUserMapper.updateByPrimaryKey(workOrderRefUser);
		WorkOrderRefUser newWorkOrderRef = new WorkOrderRefUser();
		newWorkOrderRef.setReachTime(new Date());
		newWorkOrderRef.setState(1);
		newWorkOrderRef.setUserId(targetUserId);
		workOrderRefUserMapper.insert(newWorkOrderRef);
		return true;
	}

}

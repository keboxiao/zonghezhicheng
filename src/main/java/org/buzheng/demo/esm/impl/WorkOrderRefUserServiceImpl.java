package org.buzheng.demo.esm.impl;

import java.util.Date;
import java.util.List;

import org.buzheng.demo.esm.dao.SysUserDao;
import org.buzheng.demo.esm.domain.SysUser;
import org.buzheng.demo.esm.service.WorkOrderRefUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chinatelecom.dao.WorkOrderMapper;
import com.chinatelecom.dao.WorkOrderRefUserMapper;
import com.chinatelecom.model.WorkOrderRefUser;
import com.chinatelecom.model.WorkOrderRefUserExample;
import com.parsedata.Send_SMS;

@Service
public class WorkOrderRefUserServiceImpl implements WorkOrderRefUserService {

	@Autowired
	private WorkOrderMapper workOrderMapper;

	@Autowired
	private WorkOrderRefUserMapper workOrderRefUserMapper;

	@Autowired
	private SysUserDao sysUserDao;

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
		newWorkOrderRef.setWorkOrderId(workOrderRefUser.getWorkOrderId());
		workOrderRefUserMapper.insert(newWorkOrderRef);
		SysUser sysUser = sysUserDao.findByUserId(targetUserId.toString());
		String res = sendSms(sysUser.getPhone());
		return true;
	}

	public String sendSms(String targetPhone) {
		Send_SMS sendSms = new Send_SMS();
		String CII_account = "mmftth";
		String CII_password = "Dxfs+2018";
		String SMS_content = "号码：18999999999,账号：mmtest,故障：测试发短信，处理完向用户确认";
		String[] array_receivers = new String[1];//{ "13376688127","18929797513" };
		array_receivers[0] = targetPhone;
		String SMS_password = "";
		String SMS_sender = "";
		String SMS_areacode = "";
		String st = sendSms.getXml(CII_account, CII_password, SMS_content, array_receivers, SMS_password, SMS_sender,
				SMS_areacode);
		return st;
	}

}

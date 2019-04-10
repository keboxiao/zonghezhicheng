package org.buzheng.demo.esm.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.buzheng.demo.esm.App;
import org.buzheng.demo.esm.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinatelecom.dao.WorkOrderMapper;
import com.chinatelecom.dao.WorkOrderRefUserMapper;
import com.chinatelecom.model.Json;
import com.chinatelecom.model.WorkOrder;
import com.chinatelecom.model.WorkOrderExample;
import com.chinatelecom.model.WorkOrderRefUser;

@Controller
public class WorkOrderController {

	@Autowired
	private WorkOrderMapper workOrderMapper;

	@Autowired
	private WorkOrderRefUserMapper workOrderRefUserMapper;

	@RequestMapping("listAllWorkOrder")
	@ResponseBody
	public List<WorkOrder> listAllWorkOrder(HttpServletRequest request) throws IllegalStateException, IOException {
		// String id = request.getParameter("id");
		WorkOrderExample example = new WorkOrderExample();
		WorkOrderExample.Criteria criteria = example.createCriteria();
		// criteria.andBatchNoEqualTo(Long.parseLong(id));
		return workOrderMapper.selectByExample(example);
	}

	@RequestMapping("listMyWorkOrderToBeProcessed")
	@ResponseBody
	public List<WorkOrder> listMyWorkOrderToBeProcessed(HttpServletRequest request, HttpSession session)
			throws IllegalStateException, IOException {
		// String id = request.getParameter("id");
		SysUser user = (SysUser) session.getAttribute(App.USER_SESSION_KEY);
		return workOrderMapper.getMyWorkOrderToBeProcessed(user.getUserId());
	}

	@RequestMapping("listOrderDetails")
	@ResponseBody
	public List<WorkOrderRefUser> listOrderDetails(Long workOrderId) {
		return workOrderRefUserMapper.listOrderDetailsInnerJoinUser(workOrderId);
	}

	@RequestMapping("createWorkOrder")
	@ResponseBody
	public Json createWorkOrder(HttpServletRequest request, HttpSession session) {
		SysUser user = (SysUser) session.getAttribute(App.USER_SESSION_KEY);
		WorkOrder workOrder = new WorkOrder();
		workOrder.setTitle(request.getParameter("title"));
		workOrder.setGroupid(Long.parseLong(request.getParameter("groupid")));
		workOrder.setAffectScope(request.getParameter("affectScope"));
		workOrder.setContacts(request.getParameter("contacts"));
		workOrder.setTel(request.getParameter("tel"));
		workOrderMapper.insert(workOrder);
		WorkOrderRefUser workOrderRefUser = new WorkOrderRefUser();
		workOrderRefUser.setReachTime(new Date());
		workOrderRefUser.setWorkOrderId(workOrder.getId());
		workOrderRefUser.setState(1);
		workOrderRefUser.setUserId(user.getUserId());
		workOrderRefUserMapper.insert(workOrderRefUser);
		Json j = new Json();
		j.setObj(workOrder);
		j.setSuccess(true);
		j.setMsg("建单成功");
		return j;
	}

}

package org.buzheng.demo.esm.web.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.buzheng.demo.esm.App;
import org.buzheng.demo.esm.domain.SysUser;
import org.buzheng.demo.esm.service.WorkOrderService;
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

	@Autowired
	private WorkOrderService workOrderService;

	@RequestMapping("listAllWorkOrder")
	@ResponseBody
	public List<WorkOrder> listAllWorkOrder(HttpServletRequest request) throws IllegalStateException, IOException {
		String title = request.getParameter("title");
		String begintime = request.getParameter("begintime");
		String endtime = request.getParameter("endtime");
		WorkOrderExample example = new WorkOrderExample();
		WorkOrderExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(title)) {
			criteria.andTitleLike(title);
		}
		try {
			if (StringUtils.isNotBlank(begintime)) {
				begintime += " 00:00:00";
				criteria.andHappenTimeGreaterThanOrEqualTo(DateFormat.getDateTimeInstance().parse(begintime));
			}
			if (StringUtils.isNotBlank(endtime)) {
				endtime += " 00:00:00";
				criteria.andHappenTimeLessThanOrEqualTo(DateFormat.getDateTimeInstance().parse(endtime));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
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
		workOrder.setGroupid(user.getGroupId());
		workOrder.setAffectScope(request.getParameter("affectScope"));
		workOrder.setContacts(request.getParameter("contacts"));
		workOrder.setTel(request.getParameter("tel"));
		workOrder.setHappenTime(new Date());
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

	@RequestMapping("deleteWorkOrder")
	@ResponseBody
	public Json deleteWorkOrder(HttpServletRequest request, HttpSession session) {
		String id = request.getParameter("id");
		workOrderService.deleteWorkOrder(Long.parseLong(id));
		Json j = new Json();
		j.setSuccess(true);
		j.setMsg("删除成功");
		return j;
	}

}

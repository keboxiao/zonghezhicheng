package org.buzheng.demo.esm.web.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.chinatelecom.model.DataGrid;
import com.chinatelecom.model.Json;
import com.chinatelecom.model.WorkOrder;
import com.chinatelecom.model.WorkOrderRefUser;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

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
	public DataGrid listAllWorkOrder(HttpServletRequest request, HttpSession session)
			throws IllegalStateException, IOException {
		SysUser user = (SysUser) session.getAttribute(App.USER_SESSION_KEY);
		String title = request.getParameter("title");
		String state = request.getParameter("state");
		String begintime = request.getParameter("begintime");
		String endtime = request.getParameter("endtime");
		Integer page = Integer.parseInt(request.getParameter("page"));
		Integer rows = Integer.parseInt(request.getParameter("rows"));
		Map<String, Object> params = new HashMap<>();
		if (StringUtils.isNotBlank(title)) {
			params.put("title", title);
		}
		if (user.getGroupId() != null) {
			params.put("groupId", user.getGroupId());
		}
		if (StringUtils.isNotBlank(state)) {
			params.put("state", state);
		}
		if (StringUtils.isNotBlank(begintime)) {
			begintime += " 00:00:00";
			params.put("begintime", begintime);
		}
		if (StringUtils.isNotBlank(endtime)) {
			endtime += " 00:00:00";
			params.put("endtime", endtime);
		}
		PageHelper.startPage(page, rows);
		List list = workOrderMapper.getWorkOrderByCondition(params);
		// 取分页信息
		Page<WorkOrder> pageInfo = (Page<WorkOrder>) list;
		DataGrid datagrid = new DataGrid();
		datagrid.setRows(list);
		datagrid.setTotal(pageInfo.getTotal());
		return datagrid;
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
		workOrder.setContacts(user.getName());
		workOrder.setTel(user.getPhone());
		workOrder.setHappenTime(new Date());
		workOrder.setServiceType(request.getParameter("serviceType"));
		workOrder.setFirstSystem(request.getParameter("firstSystem"));
		workOrder.setAppearance(request.getParameter("appearance"));
		workOrder.setEvent(request.getParameter("event"));
		workOrder.setInfluence(request.getParameter("influence"));
		workOrder.setPriority(request.getParameter("priority"));
		workOrder.setEvent(request.getParameter("event"));
		workOrder.setShoulirenyuan(request.getParameter("shoulirenyuan"));
		workOrder.setShoulirenyuandianhua(request.getParameter("shoulirenyuandianhua"));
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

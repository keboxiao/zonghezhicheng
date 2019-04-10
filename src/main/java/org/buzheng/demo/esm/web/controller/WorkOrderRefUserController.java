package org.buzheng.demo.esm.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.buzheng.demo.esm.App;
import org.buzheng.demo.esm.domain.SysUser;
import org.buzheng.demo.esm.service.WorkOrderRefUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinatelecom.model.Json;

@Controller
public class WorkOrderRefUserController {

	@Autowired
	private WorkOrderRefUserService workOrderRefUserService;

	@RequestMapping("transmitWorkOrderToOthers")
	@ResponseBody
	public Json transmitToOthers(HttpServletRequest request, HttpSession session) {
		SysUser user = (SysUser) session.getAttribute(App.USER_SESSION_KEY);
		Long workOrderId = Long.parseLong(request.getParameter("id"));
		String remark = request.getParameter("remark");
		String targetUserIds = request.getParameter("targetUserIds");
		String chulifangshi = request.getParameter("chulifangshi");
		Json j = new Json();
		if (chulifangshi.equals("1")) {
			workOrderRefUserService.transmitToOthers(workOrderId, user.getUserId(), remark, targetUserIds);
			j.setMsg("转派成功");
		} else if (chulifangshi.equals("2")) {
			workOrderRefUserService.endThisProcess(workOrderId, user.getUserId(), remark);
			j.setMsg("办结成功");
		}
		j.setSuccess(true);
		return j;
	}

}

package org.buzheng.demo.esm.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinatelecom.dao.WorkOrderMapper;
import com.chinatelecom.dao.WorkOrderRefUserMapper;
import com.chinatelecom.model.WorkOrder;
import com.chinatelecom.model.WorkOrderExample;

@Controller
public class WorkOrderController {

	@Autowired
	private WorkOrderMapper workOrderMapper;

	@Autowired
	private WorkOrderRefUserMapper workOrderRefUserMapper;

	@RequestMapping("listAllWorkOrder")
	@ResponseBody
	public List<WorkOrder> listAllWorkOrder(HttpServletRequest request) throws IllegalStateException, IOException {
		//String id = request.getParameter("id");
		WorkOrderExample example = new WorkOrderExample();
		WorkOrderExample.Criteria criteria = example.createCriteria();
		// criteria.andBatchNoEqualTo(Long.parseLong(id));
		return workOrderMapper.selectByExample(example);
	}

}

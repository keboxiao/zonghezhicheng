package org.buzheng.demo.esm.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.buzheng.demo.esm.App;
import org.buzheng.demo.esm.domain.SysUser;
import org.buzheng.demo.esm.service.SysUserService;
import org.buzheng.demo.esm.util.AppHelper;
import org.buzheng.demo.esm.web.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.chinatelecom.model.DataGrid;

@Controller
@RequestMapping("/sys/user")
@SessionAttributes(App.USER_SESSION_KEY)
public class SysUserController extends BaseController {

	@Resource
	private SysUserService sysUserService;

	@RequestMapping("/list")
	@ResponseBody
	public List<SysUser> list() {
		return this.sysUserService.findAll();
	}

	@RequestMapping("/page")
	@ResponseBody
	public DataGrid page(int page, int rows, String name, @ModelAttribute(App.USER_SESSION_KEY) SysUser user) {
		if (user == null) {
			return null;
		}
		DataGrid datagrid = null;
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.isNotBlank( name)) {
			params.put("name", name);
		}
		// 超级管理员才能查全部用户，其他只能查自己机构内部的用户
		if (App.SUPER_ROLE_ID.equals(user.getRoleId())) {
			//params.put("name", name);
			datagrid = this.sysUserService.findPage(page, rows);
		} else {
			params.put("groupId", user.getGroupId());
			//params.put("name", name);
			datagrid = this.sysUserService.findPage(params, page, rows);
		}
		return datagrid;
	}

	@RequestMapping("/findByName")
	@ResponseBody
	public DataGrid findByName(String name, int page, int rows) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		DataGrid datagrid = this.sysUserService.findPage(params, page, rows);
		return datagrid;
	}

	@RequestMapping("/add")
	@ResponseBody
	public Result add(SysUser user) throws Exception {
		this.sysUserService.save(user);
		return new Result();
	}

	@RequestMapping("/update")
	@ResponseBody
	public Result update(SysUser user) {
		this.sysUserService.update(user);
		return new Result();
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Result delete(@RequestParam("userId") String userId) {
		this.sysUserService.delete(userId);
		return new Result();
	}

	@RequestMapping("/updatePassword")
	@ResponseBody
	public Result updatePassword(@RequestParam("userId") String userId,
			@RequestParam(value = "oldPassword", defaultValue = "") String oldPassword,
			@RequestParam(value = "newPassword", defaultValue = "") String newPassword) {

		oldPassword = oldPassword.trim();
		newPassword = newPassword.trim();

		if (oldPassword.isEmpty()) {
			throw new IllegalArgumentException("缺少旧密码");
		}

		if (newPassword.isEmpty()) {
			throw new IllegalArgumentException("缺少新密码");
		}

		if (newPassword.equals(oldPassword)) {
			throw new IllegalArgumentException("新旧密码不能相同");
		}

		SysUser user = this.sysUserService.findByUserId(userId);
		if (user != null && AppHelper.encryptPassword(oldPassword).equals(user.getPassword())) {
			this.sysUserService.updatePassword(userId, newPassword.trim());
			return new Result();
		}

		return new Result("原密码输入错误");
	}

	@RequestMapping("/resetPassword")
	@ResponseBody
	public Result resetPassword(@RequestParam("userId") String userId) {

		this.sysUserService.resetPassword(userId);
		return new Result();
	}

}

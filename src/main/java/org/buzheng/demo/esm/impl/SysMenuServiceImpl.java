package org.buzheng.demo.esm.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.buzheng.demo.esm.dao.SysMenuDao;
import org.buzheng.demo.esm.dao.SysRoleMenuDao;
import org.buzheng.demo.esm.domain.SysMenu;
import org.buzheng.demo.esm.service.SysMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Resource
	private SysMenuDao sysMenuDao;

	@Resource
	private SysRoleMenuDao sysRoleMenuDao;

	@Override
	public List<SysMenu> findAll() {
		return this.sysMenuDao.findAll();
	}

	@Override
	public void save(SysMenu menu) {
		if (menu == null) {
			return;
		}

		if (menu.getMenuName() == null || menu.getMenuName().isEmpty()) {
			throw new IllegalArgumentException("menu.name.required");
		}

		if (menu.getParentMenuId() != null && "".equals(menu.getParentMenuId().trim())) {
			menu.setParentMenuId(null);
		}

		this.sysMenuDao.save(menu);
	}

	@Override
	public void update(SysMenu menu) {
		if (menu == null) {
			return;
		}

		if (menu.getMenuId() == null) {
			throw new IllegalArgumentException("menu.id.required");
		}

		if (menu.getMenuName() == null || menu.getMenuName().isEmpty()) {
			throw new IllegalArgumentException("menu.name.required");
		}

		this.sysMenuDao.update(menu);
	}

	@Override
	@Transactional
	public void delete(String menuId) {
		if (menuId == null) {
			return;
		}

		this.sysMenuDao.delete(menuId);

		// 删除菜单后再删除角色赋予的菜单
		this.sysRoleMenuDao.deleteByMenuId(menuId);
	}

	@Override
	public List<SysMenu> findByChildId(List<String> menuIds) {
		List<SysMenu> list = this.sysMenuDao.findByChildId(menuIds);
		Set<String> set = new HashSet<String>();
		for (SysMenu menu : list) {
			set.add(menu.getMenuId());
		}
		List<SysMenu> tmpList = new ArrayList<>();
		for (SysMenu tmp : list) {
			if (StringUtils.isNotBlank(tmp.getParentMenuId()) && !set.contains(tmp.getParentMenuId())) {
				SysMenu m = sysMenuDao.findById(tmp.getParentMenuId());
				set.add(m.getMenuId());
				tmpList.add(m);
			}
		}
		list.addAll(tmpList);
		return list;
	}

}

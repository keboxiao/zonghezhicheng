package org.buzheng.demo.esm.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.buzheng.demo.esm.App;
import org.buzheng.demo.esm.domain.SysUser;
import org.buzheng.demo.esm.service.UpFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinatelecom.dao.FileBatchMapper;
import com.chinatelecom.dao.UpFileMapper;
import com.chinatelecom.model.FileBatch;
import com.chinatelecom.model.FileBatchExample;
import com.chinatelecom.model.Json;
import com.chinatelecom.model.UpFile;
import com.chinatelecom.model.UpFileExample;

@Controller
public class FileBatchController {

	@Autowired
	private FileBatchMapper fileBatchMapper;

	@Autowired
	private UpFileMapper upFileMapper;

	@Autowired
	private UpFileService upFileService;

	@RequestMapping("/listFileBatch")
	@ResponseBody
	public List<FileBatch> listFileBatch(String title) {
		FileBatchExample example = new FileBatchExample();
		FileBatchExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(title)) {
			criteria.andTitleLike("%" + title + "%");
		}
		return fileBatchMapper.selectByExampleInnerjoinUser(example);
	}

	@RequestMapping("/addFileBatch")
	@ResponseBody
	public Json addFileBatch(String title, String remark, HttpSession session) {
		FileBatch fileBatch = new FileBatch();
		fileBatch.setTitle(title);
		fileBatch.setRemark(remark);
		SysUser sysUser = (SysUser) session.getAttribute(App.USER_SESSION_KEY);
		fileBatch.setUser(sysUser);
		fileBatchMapper.insert(fileBatch);
		return new Json();
	}

	@RequestMapping("/updateFileBatch")
	@ResponseBody
	public Json updateFileBatch(Long id, String title, String remark, HttpSession session) {
		FileBatch fileBatch = new FileBatch();
		fileBatch.setTitle(title);
		fileBatch.setRemark(remark);
		fileBatch.setId(id);
		SysUser sysUser = (SysUser) session.getAttribute(App.USER_SESSION_KEY);
		fileBatch.setUser(sysUser);
		fileBatchMapper.updateByPrimaryKey(fileBatch);
		return new Json();
	}

	@RequestMapping("/deleteById")
	@ResponseBody
	public Json deleteById(Long id) {
		UpFileExample example = new UpFileExample();
		UpFileExample.Criteria criteria = example.createCriteria();
		criteria.andBatchNoEqualTo(id);
		List<UpFile> list = upFileMapper.selectByExample(example);
		for (UpFile uf : list) {
			upFileService.deleteFile(uf.getNo());
		}
		fileBatchMapper.deleteByPrimaryKey(id);
		return new Json();
	}

}

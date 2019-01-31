package org.buzheng.demo.esm.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.buzheng.demo.esm.App;
import org.buzheng.demo.esm.domain.SysUser;
import org.buzheng.demo.esm.service.UpFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.chinatelecom.dao.UpFileMapper;
import com.chinatelecom.model.Json;
import com.chinatelecom.model.UpFile;
import com.chinatelecom.model.UpFileExample;

@Controller
public class UpFileController {

	@Autowired
	private UpFileMapper upFileMapper;

	@Autowired
	private UpFileService upFileService;

	@RequestMapping("springUpload")
	@ResponseBody
	public Json springUpload(HttpServletRequest request, HttpSession session)
			throws IllegalStateException, IOException {
		SysUser user = (SysUser) session.getAttribute(App.USER_SESSION_KEY);
		Json j = new Json();
		long startTime = System.currentTimeMillis();
		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next().toString());
				if (file != null) {
					// String username = request.getParameter("username");
					String batch_no = request.getParameter("batch_no");
					String fileName = batch_no + "_" + file.getOriginalFilename();
					String path = "d:/upload_file/" + fileName;
					file.transferTo(new File(path));
					UpFile upFile = new UpFile();
					upFile.setFilename(fileName);
					upFile.setBatchNo(Long.parseLong(batch_no));
					upFile.setUploadTime(new Date().toString());
					upFile.setUserid(user.getUserId());
					upFileMapper.insertSelective(upFile);
					String msg = "上传成功";
					j.setSuccess(true);
					j.setMsg(msg);
				}else{
					j.setSuccess(false);
					j.setMsg("上传失败！");
				}
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("方法三的运行时间：" + String.valueOf(endTime - startTime) + "ms");
		return j;
	}

	@RequestMapping("listFileByBatchId")
	@ResponseBody
	public List<UpFile> listFileByBatchId(HttpServletRequest request) throws IllegalStateException, IOException {
		String id = request.getParameter("id");
		UpFileExample example = new UpFileExample();
		UpFileExample.Criteria criteria = example.createCriteria();
		criteria.andBatchNoEqualTo(Long.parseLong(id));
		return upFileMapper.selectByExample(example);
	}

	@RequestMapping("downloadById")
	public void download(Long id, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		UpFile upFile = upFileMapper.selectByPrimaryKey(id);
		response.setHeader("Content-Disposition", "attachment;fileName=" + upFile.getFilename());
		try {
			// 打开本地文件流
			InputStream inputStream = new FileInputStream("d:/upload_file/"+upFile.getFilename());
			// 激活下载操作
			OutputStream os = response.getOutputStream();
			// 循环写入输出流
			byte[] b = new byte[2048];
			int length;
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
			}
			// 这里主要关闭。
			os.close();
			inputStream.close();
		} catch (Exception e) {
			// downloadRecord.setStatus(DownloadRecord.STATUS_ERROR);
			e.printStackTrace();
		}
	}

	@RequestMapping("deleteUpFile")
	@ResponseBody
	public Json deleteFile(Long id) {
		upFileService.deleteFile(id);
		Json j = new Json();
		String msg = "删除成功";
		j.setSuccess(true);
		j.setMsg(msg);
		return j;
	}

}

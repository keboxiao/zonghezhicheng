package org.buzheng.demo.esm.impl;

import java.io.File;

import org.buzheng.demo.esm.service.UpFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinatelecom.dao.UpFileMapper;
import com.chinatelecom.model.UpFile;

@Service
public class UpFileServiceImpl implements UpFileService {

	@Autowired
	private UpFileMapper upFileMapper;

	@Override
	public void deleteFile(Long id) {
		// TODO Auto-generated method stub
		UpFile upFile = upFileMapper.selectByPrimaryKey(id);
		File file = new File("d:/upload_file/" + upFile.getFilename());
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
		}
		upFileMapper.deleteByPrimaryKey(id);
	}

}

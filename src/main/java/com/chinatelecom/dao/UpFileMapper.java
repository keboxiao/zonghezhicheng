package com.chinatelecom.dao;

import com.chinatelecom.model.UpFile;
import com.chinatelecom.model.UpFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UpFileMapper {
    long countByExample(UpFileExample example);

    int deleteByExample(UpFileExample example);

    int deleteByPrimaryKey(Long no);

    int insert(UpFile record);

    int insertSelective(UpFile record);

    List<UpFile> selectByExample(UpFileExample example);

    UpFile selectByPrimaryKey(Long no);

    int updateByExampleSelective(@Param("record") UpFile record, @Param("example") UpFileExample example);

    int updateByExample(@Param("record") UpFile record, @Param("example") UpFileExample example);

    int updateByPrimaryKeySelective(UpFile record);

    int updateByPrimaryKey(UpFile record);
}
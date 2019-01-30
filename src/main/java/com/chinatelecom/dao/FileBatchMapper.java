package com.chinatelecom.dao;

import com.chinatelecom.model.FileBatch;
import com.chinatelecom.model.FileBatchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileBatchMapper {
    long countByExample(FileBatchExample example);

    int deleteByExample(FileBatchExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FileBatch record);

    int insertSelective(FileBatch record);

    List<FileBatch> selectByExample(FileBatchExample example);
    
    List<FileBatch> selectByExampleInnerjoinUser(FileBatchExample example);

    FileBatch selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FileBatch record, @Param("example") FileBatchExample example);

    int updateByExample(@Param("record") FileBatch record, @Param("example") FileBatchExample example);

    int updateByPrimaryKeySelective(FileBatch record);

    int updateByPrimaryKey(FileBatch record);
}
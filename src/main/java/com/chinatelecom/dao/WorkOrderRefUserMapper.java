package com.chinatelecom.dao;

import com.chinatelecom.model.WorkOrderRefUser;
import com.chinatelecom.model.WorkOrderRefUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkOrderRefUserMapper {
    long countByExample(WorkOrderRefUserExample example);

    int deleteByExample(WorkOrderRefUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WorkOrderRefUser record);

    int insertSelective(WorkOrderRefUser record);

    List<WorkOrderRefUser> selectByExample(WorkOrderRefUserExample example);

    WorkOrderRefUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WorkOrderRefUser record, @Param("example") WorkOrderRefUserExample example);

    int updateByExample(@Param("record") WorkOrderRefUser record, @Param("example") WorkOrderRefUserExample example);

    int updateByPrimaryKeySelective(WorkOrderRefUser record);

    int updateByPrimaryKey(WorkOrderRefUser record);
}
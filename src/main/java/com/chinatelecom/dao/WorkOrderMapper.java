package com.chinatelecom.dao;

import com.chinatelecom.model.WorkOrder;
import com.chinatelecom.model.WorkOrderExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface WorkOrderMapper {
	long countByExample(WorkOrderExample example);

	int deleteByExample(WorkOrderExample example);

	int deleteByPrimaryKey(Long id);

	int insert(WorkOrder record);

	int insertSelective(WorkOrder record);

	List<WorkOrder> selectByExampleWithBLOBs(WorkOrderExample example);

	List<WorkOrder> selectByExample(WorkOrderExample example);

	WorkOrder selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") WorkOrder record, @Param("example") WorkOrderExample example);

	int updateByExampleWithBLOBs(@Param("record") WorkOrder record, @Param("example") WorkOrderExample example);

	int updateByExample(@Param("record") WorkOrder record, @Param("example") WorkOrderExample example);

	int updateByPrimaryKeySelective(WorkOrder record);

	int updateByPrimaryKeyWithBLOBs(WorkOrder record);

	int updateByPrimaryKey(WorkOrder record);

	List<WorkOrder> getMyWorkOrderToBeProcessed(Long userId);

	List<WorkOrder> getWorkOrderByCondition(@Param("params") Map<String, Object> params);

}
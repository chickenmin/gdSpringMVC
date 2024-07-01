package com.min.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.min.edu.dto.JobsDto;

public interface InterfaceJobsMapperDao {

	
	@Select("SELECT JOB_ID,JOB_TITLE,MIN_SALARY,MAX_SALARY FROM JOBS")
	public List<JobsDto> selectAll(String seq);
	
	@SelectProvider(type = JobsProvider.class, method = "getSelectOne")
	public List<JobsDto> selectDynamic(String seq);
}

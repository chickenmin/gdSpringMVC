package com.edu.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.dto.JobsDto;
import com.min.edu.mapper.InterfaceJobsMapperDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class InterfaceMapperTest {

	@Autowired
	private InterfaceJobsMapperDao mapper;
	
	@Test
	public void test() {
		List<JobsDto> lists= mapper.selectAll("AD_VP");
		System.out.println(lists);
		assertNotEquals(0, lists.size());
	}
	
	public void dynamic() {
		List<JobsDto> lists= mapper.selectDynamic("AD_PRES");
	}

}

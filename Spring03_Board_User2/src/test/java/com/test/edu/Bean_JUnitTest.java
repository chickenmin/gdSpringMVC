package com.test.edu;

import static org.junit.Assert.*;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.aop.DaoLogAop_Anno;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class Bean_JUnitTest {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	
	@Test
	public void test() {
		BasicDataSource dataSource = context.getBean("dataSource",BasicDataSource.class); //이름으로 불러오기
		// context.getBean(BasicDataSource.class); 타입으로 불러오기
		System.out.println(dataSource.getDriverClassName());
		System.out.println(dataSource.getMaxActive());
		assertNotNull(dataSource);
		assertNotNull(sessionTemplate);
		
		DaoLogAop_Anno daoLogAop_Anno = 
		context.getBean("daoLogAop_Anno",DaoLogAop_Anno.class);
		
		assertNotNull(daoLogAop_Anno);
		
	}

}

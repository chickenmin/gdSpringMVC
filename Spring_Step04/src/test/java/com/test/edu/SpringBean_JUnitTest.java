package com.test.edu;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.min.edu.dto.EduboardVo;
import com.min.edu.model.IEduBoardDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/root-context.xml"})
public class SpringBean_JUnitTest {
//xml을 읽어서 bean으로 만들면 java객체가 되고 그 객체들이 들어가 있는 공간이 spring의 application-context
	//context - 이름으로 호출
	
	@Autowired //bean이 만들어져 있다면 해당 타입에 만들어져 있는 객체를 주입 (new 하지 않아도)
	private InternalResourceViewResolver resolver;
	
	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SqlSessionFactoryBean sqlSessionFactoryBean;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	private IEduBoardDao dao;
	
	
	@Test
	public void sqlSessionTemplate_test() {
		assertNotNull(sqlSessionTemplate);
	}
	
	
	
	//@Test
	public void resolver_Test() {
		//타입으로 가져오는 방법
//		InternalResourceViewResolver resolver =
//		context.getBean(InternalResourceViewResolver.class);
		
		assertNotNull(resolver);
		System.out.println(resolver);
	}
	
//	@Test
	public void datasource_Test() {
		//이름으로 bean 호출
		//("dataSource",BasicDataSource.class) invokation 문법
		BasicDataSource datasource = context.getBean("dataSource",BasicDataSource.class);
		System.out.println(datasource.getUrl());
		System.out.println(datasource.getDriverClassName());
		System.out.println(datasource.getUsername());
		System.out.println(datasource.getPassword());
		assertNotNull(datasource);
		assertNotNull(sqlSessionFactoryBean);
		assertNotNull(sqlSessionTemplate);
		
	}
//	@Test
	public void mybatis_test() {
		List<EduboardVo> list = sqlSessionTemplate.selectList("com.min.edu.model.EduBoardDaoImpl.selectBoard");
		assertNotEquals(0, list.size());
	}
	
//	@Test
	public void crud_test() {
		//입력수정 조회
		EduboardVo vo = new EduboardVo();
		vo.setId("HAPPY");
		vo.setTitle("CRUD 테스트");
		vo.setContent("spring crud 테스트");
		int n= dao.insertBoard(vo);
		
		assertEquals(1, n);
		
		int m = dao.updateBoard();
		assertNotEquals(0, m);
		
		List<EduboardVo> list = dao.selectBoard();
		assertNotEquals(0, list.size());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//
	
	

}

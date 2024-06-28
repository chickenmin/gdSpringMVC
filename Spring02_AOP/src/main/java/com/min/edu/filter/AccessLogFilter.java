package com.min.edu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Strings;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class AccessLogFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("~~~~~~~~~~~Filter 들어옴~~~~~~~~~~~~~~");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 요청 정보request와 header에 들어가 있다
		HttpServletRequest req = (HttpServletRequest)request;
		/*
		 * request 정보 : 요청 주소(remoteAddr), 요청 Param(queryString)
		 * Header 정보 : 요청된 사용자의 어플리케이션 타입, 운영체제, 브라우저 정보 User_Agent
		 * 				 이전 페이지의 주소, 유입경로 Referer
		 * 					Expires, Cach-Controller, Pragma : 캐시정보
		 * */
		
		//1) 접근을 시도하는 사용자의 주소 출력
		String remoteAddr = req.getRemoteAddr();
		
		//2)접근주소
		String url = req.getRequestURL().toString();
		//url : http~부터시작한 주소
		String uri = req.getRequestURI();
		//uri : 프로젝트명 부터 시작
		
		// 3)쿼리스트링
//		String queryString = req.getQueryString();
//		queryString = (queryString == null || queryString=="")?"":queryString;
		
		String queryString = StringUtils.defaultIfEmpty(req.getQueryString(), "");
		String guavaQueryString = Strings.nullToEmpty(req.getQueryString());
		//위에 3개 다 같은거 - 출근시 주소나 ip가 지하철이나 다를때 (출퇴근 접속시)
		
		//Header 정보
		String referer = StringUtils.defaultIfEmpty(req.getHeader("Referer"), "");
		String userAgent = StringUtils.defaultIfEmpty(req.getHeader("User-Agent"), "");
		
		log.info("이전 페이지 : {}",referer);
		log.info("Client 접속 정보 : {}",userAgent);
		
		String fullUrl = url;
		fullUrl += StringUtils.isNoneEmpty(queryString) ?"?"+guavaQueryString:queryString;
		
		StringBuffer sb = new StringBuffer();
		sb.append(remoteAddr).append(":")
		.append(fullUrl).append(":")
		.append(referer).append(":")
		.append(userAgent);
		
		log.info("[Filter Logger] {}",sb.toString());
		
		chain.doFilter(request, response);
		
		
		
	}

	@Override
	public void destroy() {
		log.info("~~~~~~~~~~~Filter 나감~~~~~~~~~~~~~~");
	}

}












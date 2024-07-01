package com.min.edu.comm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientAccessLog implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("~~~~~~~~~~~~ClientAccessLog init~~~~~~~~~~~~~");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		//    HttpServletRequest 정보
		String remoteAddr = req.getRemoteAddr();
		String url = req.getRequestURL().toString();
		String queryString = StringUtils.defaultIfEmpty(req.getQueryString(), "");
		//    request의 Header 정보
		String userAgent = StringUtils.defaultIfEmpty(req.getHeader("User-Agent"),"");
		String referer = StringUtils.defaultIfEmpty(req.getHeader("Referer"),"");
				
		StringBuffer sb = new StringBuffer();
		sb.append(remoteAddr)
		.append("\n")
		.append(url)
		.append("?")
		.append(queryString)
		.append("\n")
		.append(referer)
		.append(":")
		.append(userAgent);
		
		
		log.info("[Client Filter] {}", sb.toString());
		

		chain.doFilter(request, response); //doFilter메소드 작성시 제일먼저 작성해두기
	}

	@Override
	public void destroy() {
		log.info("~~~~~~~~~~~~ClientAccessLog destroy~~~~~~~~~~~~~");
	}

}

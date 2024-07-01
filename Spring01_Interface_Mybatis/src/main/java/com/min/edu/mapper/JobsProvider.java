package com.min.edu.mapper;

import org.apache.ibatis.jdbc.SQL;

public class JobsProvider {
	public String getSelectOne(String seq) {
		SQL sql = new SQL() {{
			SELECT("JOB_ID");
			SELECT("JOB_TITLE");
			SELECT("MIN_SALARY");
			SELECT("MAX_SALARY");
			FROM("JOBS");
			WHERE("JOB_ID=#{seq}");
			
		}};
		return sql.toString();
	}
}

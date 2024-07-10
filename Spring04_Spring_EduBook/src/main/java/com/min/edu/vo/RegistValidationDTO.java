package com.min.edu.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//TODO 077
public class RegistValidationDTO {
	
		@NotNull(message = "id는 필수 입니다")
		@Size(max = 10, min = 1)
		private String id;
		
		@NotNull(message = "name은 필수 입니다")
		@Size(max = 10, min = 1, message = "잘못된 이름 이름값 입니다.")
		private String name;
		
		@NotNull(message = "p은 필수 입니다")
		@Size(max = 10, min = 1, message = "잘못된 비밀번호 이름값 입니다.")
		private String pw;
		
		private String auth;
		
		private String delflag;
		
		private String joinindate;
		
		public RegistValidationDTO() {
			super();
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPw() {
			return pw;
		}
		public void setPw(String pw) {
			this.pw = pw;
		}
		public String getAuth() {
			return auth;
		}
		public void setAuth(String auth) {
			this.auth = auth;
		}
		public String getDelflag() {
			return delflag;
		}
		public void setDelflag(String delflag) {
			this.delflag = delflag;
		}
		public String getJoinindate() {
			return joinindate;
		}
		public void setJoinindate(String joinindate) {
			this.joinindate = joinindate;
		}
		@Override
		public String toString() {
			return "RegistValidationDTO [id=" + id + ", name=" + name + ", pw=" + pw + ", auth=" + auth + ", delflag="
					+ delflag + ", joinindate=" + joinindate + "]";
		}
		
		
		

}

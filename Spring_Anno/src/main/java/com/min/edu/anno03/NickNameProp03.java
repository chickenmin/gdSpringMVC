package com.min.edu.anno03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.min.edu.anno02.NickName;
import com.min.edu.anno03.bean.NickName03;

@Component
public class NickNameProp03 {

	@Autowired
	private NickName03 nickName03;
	
	@Autowired
	private NickName nickName02;
	

	public NickName03 getNickName03() {
		return nickName03;
	}

	public void setNickName03(NickName03 nickName03) {
		this.nickName03 = nickName03;
	}

	@Override
	public String toString() {
		return "NickNameProp03 [nickName03="+nickName03+"]\n"+nickName02;
	}
	
	
}

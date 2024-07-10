package com.min.edu.bean01;

public class MessageBeanImpl implements IMessageBean {

	private String coffee;
	private String price;
	
	
	
	
	
	public MessageBeanImpl() {
		super();
		this.coffee = "케냐AA";
		this.price = "2000";
	}
	
	





	public MessageBeanImpl(String coffee, String price) {
		super();
		this.coffee = coffee;
		this.price = price;
	}







	@Override
	public void call() {
		System.out.printf("%s의 가격은 %s 입니다 \n",coffee,price);
	}

}

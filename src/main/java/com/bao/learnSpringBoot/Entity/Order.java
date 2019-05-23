package com.bao.learnSpringBoot.Entity;

import java.io.Serializable;

public class Order implements Serializable{    //因为要到网络进行传输 所以要实现  Serializable 接口生成id
	private static final long serialVersionUID = -854207254828985258L;
	private int id;
	private String name;
	private int messageid;//储存消息发送的唯一id
	
	public Order() {
		
	}
	
	public Order(int id, String name, int messageid) {
		super();
		this.id = id;
		this.name = name;
		this.messageid = messageid;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMessageid() {
		return messageid;
	}
	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}
	
	
}

package com.bao.learnSpringBoot.Entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



/**
 * 逆向工程生成数据库
 */
@Entity //表明是一个实体 才会向数据库建表   注意 ：persistence.Entity;  不要导入错了
public class Luckmoney {

    @Id   // javax.persistence  该字段是id
    @GeneratedValue //自动增涨
    private Integer id;

    private BigDecimal money;
    
    private String sendRen;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getSendRen() {
		return sendRen;
	}

	public void setSendRen(String sendRen) {
		this.sendRen = sendRen;
	}
    
    
}

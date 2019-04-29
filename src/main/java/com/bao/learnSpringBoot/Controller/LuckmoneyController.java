package com.bao.learnSpringBoot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bao.learnSpringBoot.Dao.LuckMoneyRepository;
import com.bao.learnSpringBoot.Entity.Luckmoney;
import com.bao.learnSpringBoot.Service.LuckMoneyService;

@RestController
@RequestMapping("/luckmoney")
public class LuckmoneyController {
	
	//jap 的接口
	@Autowired
	private LuckMoneyRepository luckmoneyrep;
	
	@Autowired
	private LuckMoneyService luckMoneyService;
	
	//存入数据
	@GetMapping("/savehongbao")
	public Luckmoney saveH(Luckmoney luckmoney) {
		return luckmoneyrep.save(luckmoney);
		//http://localhost:8088/hlbbxh/luckmoney/savehongbao?money=10&sendRen=aa
	}
	
	/**
	 * 测试mysql事务的案例
	 */
	@GetMapping("/testtran")
	public void testTran() {
		luckMoneyService.createTwo();
	}
	
	
	
	
}

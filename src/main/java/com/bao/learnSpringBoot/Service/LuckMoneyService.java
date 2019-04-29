package com.bao.learnSpringBoot.Service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bao.learnSpringBoot.Dao.LuckMoneyRepository;
import com.bao.learnSpringBoot.Entity.Luckmoney;

/**
 * 发红包 事物部分  要么都成功  要么都失败
 */
@Service
public class LuckMoneyService {

	//装载jpa的类
    @Autowired
    private LuckMoneyRepository luckMoneyRepository;

    //开启事物机制
    @Transactional
    public void createTwo(){
        Luckmoney luckmoney1 = new Luckmoney();
        luckmoney1.setSendRen("aaa");
        luckmoney1.setMoney(new BigDecimal("520"));
        luckMoneyRepository.save(luckmoney1);

        Luckmoney luckmoney2 = new Luckmoney();
        luckmoney2.setSendRen("aaa");
        luckmoney2.setMoney(new BigDecimal("1314"));
        luckMoneyRepository.save(luckmoney2);
    }
}
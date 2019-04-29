package com.bao.learnSpringBoot.Service;

import java.math.BigDecimal;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bao.learnSpringBoot.Dao.LuckMoneyRepository;
import com.bao.learnSpringBoot.Entity.Luckmoney;
import com.bao.learnSpringBoot.Exception.ExceptionEnums;
import com.bao.learnSpringBoot.Exception.MyselfExpception;

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
    
    public Luckmoney findById(Integer id) throws MyselfExpception{
    	Optional<Luckmoney> findById = luckMoneyRepository.findById(id);
    	Luckmoney luckmoney = findById.get();
    	int money = (luckmoney.getMoney()).intValue();
    	if(money<10) {
    		//throw new MyselfExpception(500,"小气鬼");
    		throw new MyselfExpception(ExceptionEnums.XIAO_QI);
    	}else if(money>10&&money<100){
    		throw new MyselfExpception(ExceptionEnums.HAIBUCUO);
    	}else {
    		return luckmoney;//再100以上才会返回
    	}
    }
}
package com.bao.learnSpringBoot.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.bao.learnSpringBoot.Entity.Luckmoney;
/**
 * 这是 jpa 红包的  自带方法
 * @author hlb
 *
 */
@Service
public interface LuckMoneyRepository extends JpaRepository<Luckmoney,Integer> {
	
}

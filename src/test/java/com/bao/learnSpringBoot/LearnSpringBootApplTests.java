package com.bao.learnSpringBoot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bao.learnSpringBoot.Entity.Order;
import com.bao.learnSpringBoot.Rabbitmq.OrderSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnSpringBootApplTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired
	private OrderSender ordersender;
	
	@Test
	public void testrabbitmq() throws Exception {
		Order order = new Order();
		order.setId(1);
		order.setName("哇哈哈");
		order.setMessageid(00001);
		ordersender.send(order);
		System.out.println("消息发送完毕");
	}

}

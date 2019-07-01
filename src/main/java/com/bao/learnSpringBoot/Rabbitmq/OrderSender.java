package com.bao.learnSpringBoot.Rabbitmq;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bao.learnSpringBoot.Entity.Order;

@Component
public class OrderSender {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void send(Order order) throws Exception{
		CorrelationData correlationData = new CorrelationData();
		correlationData.setId(order.getMessageid()+"order");
		rabbitTemplate.convertAndSend(
				"order-exchange",//交换机名称 
				"order.2", //路由规则  这里注意是配置的 是* 还是#   现在配置的时候：order.* 现在只能写一个才可以发过去
				order,// message  需要发送的消息  自动序列化
				correlationData);//消息的唯一id correlationData 
	}
}

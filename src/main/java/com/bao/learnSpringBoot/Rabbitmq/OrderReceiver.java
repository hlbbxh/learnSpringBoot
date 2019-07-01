package com.bao.learnSpringBoot.Rabbitmq;

import java.io.IOException;
import java.util.Map;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.bao.learnSpringBoot.Entity.Order;
import com.rabbitmq.client.AMQP.Channel;

@Component
public class OrderReceiver {
	
	/**
	 * @param order 传递的消息 我们已经知道传的是order 了  直接写就可以了  要使用@Payload注解
	 * @param maps 消息头
	 * @param channel  手动签收模式 要加这个 spring.rabbitmq.listener.simple.acknowledge-mode=AUTO 对应配置文件这里的
	 * @throws IOException 
	 */
	//标识方法 消费 这里是创建队列 创建绑定   
	@RabbitListener(bindings=@QueueBinding(
				value=@Queue(value="order-queue",durable="true"),
				exchange=@Exchange(name="order-exchange",durable="true",type="topic"),
				key="order.#"
			)
		)
	//标识方法 消费 
	@RabbitHandler
	public void onOrderMessages(@Payload Order order,@Headers Map<String,Object> haders,com.rabbitmq.client.Channel channel) throws IOException {
		//进行消费操作
		System.out.println("收到消息：进行消费---");
		System.out.println("订单消息："+order.getId());
		//确认签收
		Long delivery_tag = (Long) haders.get(AmqpHeaders.DELIVERY_TAG);
		channel.basicAck(delivery_tag, false);
	}
}

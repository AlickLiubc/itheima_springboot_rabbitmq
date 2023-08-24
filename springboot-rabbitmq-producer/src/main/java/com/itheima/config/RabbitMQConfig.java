package com.itheima.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String EXCHANGE_NAME = "boot_topic_exchange";
    public static final String QUEUE_NAME = "boot_queue";

    // 1.交换机
    @Bean("bootExchange")
    public Exchange bootExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }

    // 2.队列
    @Bean("bootQueue")
    public Queue bootQueue() {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    // 3.队列和交换机绑定关系 Binding
    /*
        1.知道哪个队列
        2.知道哪个交换机
        3.routing key
    */
    @Bean
    public Binding bindingQueue(@Qualifier("bootQueue") Queue queue, @Qualifier("bootExchange")Exchange exchangeName) {
        return BindingBuilder.bind(queue).to(exchangeName).with("boot.#").noargs();
    }


}

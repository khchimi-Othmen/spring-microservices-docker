package com.example.msnotification_uesr.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.*;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

    public static final String TRS_QUEUE_2 = "transaction-queue-fanout3-ms1";
    public static final String TRS_EXCHANGE = "transaction-exchange_fanout3";



    @Bean
    public Queue trsQueue2() {
        return new Queue(TRS_QUEUE_2, true);
    }

    @Bean
    public FanoutExchange trsExchange() {
        return new FanoutExchange(TRS_EXCHANGE);
    }


    @Bean
    public Binding trsBinding2(Queue trsQueue2, FanoutExchange trsExchange) {
        return BindingBuilder.bind(trsQueue2).to(trsExchange);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Primary
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}

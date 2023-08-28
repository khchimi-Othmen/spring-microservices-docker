package tn.stb.mstransaction.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

    public static final String QUEUE = "first-ms-queue";
    public static final String EXCHANGE = "first-ms-exchange";
    public static final String ROUTING_KEY = "first-ms-routing-key";
    ///////////
    public static final String SECOND_QUEUE = "second-ms-queue";
    public static final String SECOND_EXCHANGE = "second-ms-exchange";
    public static final String SECOND_ROUTING_KEY = "second-ms-routing-key";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean
    public Queue secondQueue() {
        return new Queue(SECOND_QUEUE);
    }

    @Bean
    public TopicExchange secondExchange() {
        return new TopicExchange(SECOND_EXCHANGE);
    }

    @Bean
    public Binding secondBinding(Queue secondQueue, TopicExchange secondExchange) {
        return BindingBuilder.bind(secondQueue).to(secondExchange).with(SECOND_ROUTING_KEY);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }



}

package com.example.consumer.consmer;

import com.example.consumer.config.Config;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component
public class Usuario {

    @RabbitListener(queues = Config.QUEUE)
    public void consumeMessaggeFromQueue(String mensaje) {
        System.out.println("Mensaje: " + mensaje);
    }
}

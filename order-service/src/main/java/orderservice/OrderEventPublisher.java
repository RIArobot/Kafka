package orderservice;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderEventPublisher {
    private static final String TOPIC = "order-created";
    private final KafkaTemplate<String, OrderCreatedDTO> kafkaTemplate;

    public OrderEventPublisher(KafkaTemplate<String, OrderCreatedDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishOrderCreatedEvent(OrderCreatedDTO event) {

        kafkaTemplate.send(TOPIC, event);
    }
}


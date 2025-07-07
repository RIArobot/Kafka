package orderservice;

import dto.OrderCreatedDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {
    private final OrderEventPublisher eventPublisher;
    private final List<Order> orders = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);


    public OrderService(OrderEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public Order createOrder(Order order) {

        // публикация события
        OrderCreatedDTO event = new OrderCreatedDTO(
                order.getId(),
                order.getProductId(),
                order.getQuantity()
        );
        eventPublisher.publishOrderCreatedEvent(event);

        /*if (inventory == null || inventory.getQuantity() < order.getQuantity()) {
            throw new RuntimeException("Not enough inventory");
        }

        // 2. Сохраняем заказ в памяти
        order.setId(idCounter.getAndIncrement());
        order.setCompleted(true);
        orders.add(order);*/
        return order;
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }


}
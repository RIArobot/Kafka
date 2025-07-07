package inventoryservice;

import dto.OrderCreatedDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class OrderCreatedEventListener {
    private final InventoryService inventoryService;

    public OrderCreatedEventListener(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @KafkaListener(topics = "order-created", groupId = "inventory-group1")
    public void handleOrderCreatedEvent(OrderCreatedDTO event) {
        // обработка события
        Inventory inventory = inventoryService.getInventory(
                event.getProductId());
        System.out.println(inventory.getProductId() + " - " + inventory.getQuantity());
    }
}

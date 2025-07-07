package dto;

public class OrderCreatedDTO {
    private Long orderId;
    private String productId;
    private int quantity;

    // Обязательно добавьте конструктор без параметров!
    public OrderCreatedDTO() {
    }

    public OrderCreatedDTO(Long id, String productId, int quantity) {
        orderId = id;
        this.productId = productId;
        this.quantity = quantity;
    }
    public OrderCreatedDTO(String productId) {
        this.productId = productId;
    }

    // Геттеры и сеттеры
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }


    // конструкторы, геттеры, сеттеры
}

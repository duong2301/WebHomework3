package mvc.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orderdetails")
public class OrderDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderDetailsID")
    private Integer orderDetailsID;
//    @Column(name = "OrderId")
//    private Integer OrderId;
//    @Column(name = "ProductId")
//    private Integer ProductId;

    @ManyToOne
    @JoinColumn(name = "productId")
    private ProductsEntity products;

    @ManyToOne
    @JoinColumn(name="orderId")
    private OrdersEntity ordersEntities;

    @Column(name = "quantity")
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getOrderDetailsID() {
        return orderDetailsID;
    }

    public void setOrderDetailsID(Integer orderDetailsID) {
        this.orderDetailsID = orderDetailsID;
    }

    //    public Integer getOrderId() {
//        return OrderId;
//    }
//
//    public void setOrderId(Integer orderId) {
//        OrderId = orderId;
//    }
//
//    public Integer getProductId() {
//        return ProductId;
//    }
//
//    public void setProductId(Integer productId) {
//        ProductId = productId;
//    }


    public ProductsEntity getProducts() {
        return products;
    }

    public void setProducts(ProductsEntity products) {
        this.products = products;
    }

    public OrdersEntity getOrdersEntities() {
        return ordersEntities;
    }

    public void setOrdersEntities(OrdersEntity ordersEntities) {
        this.ordersEntities = ordersEntities;
    }

    @Override
    public String toString() {
        return "OrderDetailsEntity{" +
                "orderDetailsID=" + orderDetailsID +
                ", products=" + products +
                ", ordersEntities=" + ordersEntities +
                ", quantity=" + quantity +
                '}';
    }
}

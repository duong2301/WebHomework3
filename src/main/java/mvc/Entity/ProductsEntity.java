package mvc.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class ProductsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Integer productId;
    @Column(name = "productName")
    private String productName;
    @Column(name="productDescription")
    private String productDescription;
    @Column(name = "unitPrice")
    private double unitPrice;
    @OneToMany(mappedBy = "products",fetch = FetchType.EAGER)
    private List<OrderDetailsEntity>orderDetails;


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public List<OrderDetailsEntity> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailsEntity> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "ProductsEntity{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", unitPrice=" + unitPrice +
                ", orderDetails=" + orderDetails +
                '}';
    }
}

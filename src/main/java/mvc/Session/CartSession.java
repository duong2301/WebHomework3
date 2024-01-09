package mvc.Session;

import mvc.Entity.ProductsEntity;

public class CartSession {

    private ProductsEntity productsEntity;

    private Integer quantity;

    public ProductsEntity getProductsEntity() {
        return productsEntity;
    }

    public void setProductsEntity(ProductsEntity productsEntity) {
        this.productsEntity = productsEntity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}

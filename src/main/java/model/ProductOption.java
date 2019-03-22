package model;

import java.util.Objects;

public class ProductOption {

    private String id;
    private String created_at;
    private String updated_at;
    private boolean active;
    private String name;
    private String sku;
    private String productId;
    private long available_quantity;
    private String backordered_until;

    public ProductOption(String id, String created_at, String updated_at, boolean active, String name,
                         String sku, String productId) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.active = active;
        this.name = name;
        this.sku = sku;
        this.productId = productId;
    }

    public ProductOption() {
    }

    @Override
    public String toString() {
        return "ProductOption{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sku='" + sku + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductOption that = (ProductOption) o;
        return id.equals(that.id) &&
                sku.equals(that.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sku);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public long getAvailable_quantity() {
        return available_quantity;
    }

    public void setAvailable_quantity(long available_quantity) {
        this.available_quantity = available_quantity;
    }

    public String getBackordered_until() {
        return backordered_until;
    }

    public void setBackordered_until(String backordered_until) {
        this.backordered_until = backordered_until;
    }
}

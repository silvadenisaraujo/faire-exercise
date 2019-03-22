package model;

public class OrderItem {

    private String id;
    private String created_at;
    private String updated_at;
    private String order_id;
    private String product_id;
    private String product_option_id;
    private int quantity;
    private String sku;
    private long price_cents;
    private String product_name;
    private String product_option_name;
    private boolean includes_tester;

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

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_option_id() {
        return product_option_id;
    }

    public void setProduct_option_id(String product_option_id) {
        this.product_option_id = product_option_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public long getPrice_cents() {
        return price_cents;
    }

    public void setPrice_cents(long price_cents) {
        this.price_cents = price_cents;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_option_name() {
        return product_option_name;
    }

    public void setProduct_option_name(String product_option_name) {
        this.product_option_name = product_option_name;
    }

    public boolean isIncludes_tester() {
        return includes_tester;
    }

    public void setIncludes_tester(boolean includes_tester) {
        this.includes_tester = includes_tester;
    }
}

package model;

import java.util.List;
import java.util.Objects;

public class Product {

    private String id;
    private String created_at;
    private String updated_at;
    private String brand_id;
    private String short_description;
    private String description;
    private long wholesale_price_cents;
    private long retail_price_cents;
    private boolean active;
    private String name;
    private int unit_multiplier;
    private List<ProductOption> options;

    public Product(String id, String created_at, String updated_at, String brand_id, String short_description,
                   String description, long wholesalePriceCents, long retail_price_cents, boolean active, String name,
                   int unit_multiplier, List<ProductOption> options) {
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.brand_id = brand_id;
        this.short_description = short_description;
        this.description = description;
        this.wholesale_price_cents = wholesalePriceCents;
        this.retail_price_cents = retail_price_cents;
        this.active = active;
        this.name = name;
        this.unit_multiplier = unit_multiplier;
        this.options = options;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", brand_id='" + brand_id + '\'' +
                ", short_description='" + short_description + '\'' +
                ", description='" + description + '\'' +
                ", wholesale_price_cents=" + wholesale_price_cents +
                ", retail_price_cents=" + retail_price_cents +
                ", active=" + active +
                ", name='" + name + '\'' +
                ", unit_multiplier=" + unit_multiplier +
                ", options=" + options +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public String getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(String brand_id) {
        this.brand_id = brand_id;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getWholesale_price_cents() {
        return wholesale_price_cents;
    }

    public void setWholesale_price_cents(long wholesale_price_cents) {
        this.wholesale_price_cents = wholesale_price_cents;
    }

    public long getRetail_price_cents() {
        return retail_price_cents;
    }

    public void setRetail_price_cents(long retail_price_cents) {
        this.retail_price_cents = retail_price_cents;
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

    public int getUnit_multiplier() {
        return unit_multiplier;
    }

    public void setUnit_multiplier(int unit_multiplier) {
        this.unit_multiplier = unit_multiplier;
    }

    public List<ProductOption> getOptions() {
        return options;
    }

    public void setOptions(List<ProductOption> options) {
        this.options = options;
    }
}

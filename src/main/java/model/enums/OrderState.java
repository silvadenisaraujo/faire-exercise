package model.enums;

public enum OrderState {

    NEW("NEW", "The order has not yet been accepted by the brand."),
    PROCESSING("PROCESSING", "The brand has accepted the order, and is in the process of fulfilling it."),
    PRE_TRANSIT("PRE_TRANSIT", "The order has at least one shipment, but no shipments are in transit."),
    IN_TRANSIT("IN_TRANSIT", "At least one of the shipments is in transit."),
    DELIVERED("DELIVERED", "At least one of the shipments has been delivered."),
    BACKORDERED("BACKORDERED", "The brand did not have sufficient quantity to fulfill the order and will ship it when items are back in stock."),
    CANCELED("CANCELED", "The order was canceled by the brand or the retailer. Can only happen if the order is NEW or PROCESSING.");

    private String state;
    private String description;

    OrderState(String state, String description){
        this.state = state;
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

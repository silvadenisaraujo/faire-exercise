package processor;

import service.InventoryService;
import model.Order;
import model.OrderItem;
import model.enums.OrderState;

import java.util.List;
import java.util.stream.Collectors;

public class OrderProcessor {


    public static void processOrders(List<Order> orders) {
        List<Order> newOrders = orders
                .parallelStream()
                .filter(o -> o.getState().equalsIgnoreCase(OrderState.NEW.getState()))
                .collect(Collectors.toList());
        processNewOrders(newOrders);
    }

    private static void processNewOrders(List<Order> newOrders) {
        InventoryService inventoryService = InventoryService.getInstance();
        for(Order order : newOrders){
            for(OrderItem orderItem : order.getItems()){
                inventoryService.consumeProduct(orderItem.getProduct_option_id(), orderItem.getQuantity());
            }
            order.setState(OrderState.PROCESSING.getState());
        }
    }
}

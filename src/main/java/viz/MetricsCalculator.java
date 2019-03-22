package viz;

import model.Order;
import model.OrderItem;
import model.Product;
import model.ProductOption;

import java.util.*;

public class MetricsCalculator {


    public static void calculateOrderMetrics(List<Order> orders) {

        Metrics metrics = Metrics.getInstance();
        long largestOrder = 0L;
        long orderTotal = 0L;
        TreeMap<String, Long> orderPerState = new TreeMap<>();
        TreeMap<String, Integer> productSales = new TreeMap<>();

        for(Order order : orders){

            //Sum total of order
            for(OrderItem orderItem : order.getItems()){
                orderTotal += (orderItem.getPrice_cents() * orderItem.getQuantity());
                String productId = orderItem.getProduct_id();
                if(!productSales.containsKey(productId)){
                    productSales.put(productId, orderItem.getQuantity());
                }else{
                    productSales.put(productId, productSales.get(productId) + orderItem.getQuantity());
                }

            }

            //Updates order total
            if(orderTotal > largestOrder){
                largestOrder = orderTotal;
            }

            //Calculate the order per State
            String state = order.getAddress().getState();
            if(!orderPerState.containsKey(state)){
                orderPerState.put(state, 1L);
            }else{
                orderPerState.put(state, orderPerState.get(state) + 1);
            }

        }

        metrics.setLargestOrder(largestOrder);
        metrics.setOrderPerState(orderPerState);
        metrics.setProductSales(productSales);

    }

    public static void calculateProductMetrics(List<Product> products) {
        Metrics metrics = Metrics.getInstance();

        List<ProductOption> optionsBackordered = new ArrayList<>();
        List<ProductOption> optionsWithoutStock = new ArrayList<>();

        for(Product product : products){
            for(ProductOption option : product.getOptions()){
                if(option.getBackordered_until() != null){
                    optionsBackordered.add(option);
                }
                if(option.getAvailable_quantity() <= 0){
                    optionsWithoutStock.add(option);
                }
            }
        }

        metrics.setBackorderedProductOptions(optionsBackordered);
        metrics.setProductOptionsWithoutStock(optionsWithoutStock);
    }

}

import model.Order;
import model.Product;
import org.apache.commons.lang3.StringUtils;
import processor.OrderProcessor;
import service.InventoryService;
import service.OrderService;
import service.ProductService;
import util.Constants;
import viz.MetricsCalculator;
import viz.Printer;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String accessToken = StringUtils.EMPTY;
        if(args.length == 0){
            System.out.println("Missing access token!");
        } else {
            accessToken = args[0];
        }

        //1) Consume all products from a specific Brand and updates the inventory
        List<Product> products = ProductService.loadProductsByBrand(Constants.BRAND_TOKEN, accessToken);
        InventoryService.getInstance().initializeInventory(products);

        //2) Consume all orders
        List<Order> orders = OrderService.loadOrders(accessToken);

        //3) Process new orders and update inventory and order status
        OrderProcessor.processOrders(orders);

        //4) Calculate and print metrics
        MetricsCalculator.calculateOrderMetrics(orders);
        MetricsCalculator.calculateProductMetrics(products);
        Printer.printMetrics();
    }

}

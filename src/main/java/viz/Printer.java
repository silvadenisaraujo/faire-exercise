package viz;

import model.ProductOption;

import java.util.List;
import java.util.Map;

public class Printer {

    public static void printMetrics() {
        Metrics metrics = Metrics.getInstance();

        printLargestOrderConsumed(metrics);
        printSalesPerState(metrics);
        printTotalOrderedProductOptions(metrics);
        printProductOptionsList("List of Product Options Back Ordered", metrics.getBackorderedProductOptions());
        printProductOptionsList("List of Product Options Without Stock", metrics.getProductOptionsWithoutStock());
    }

    private static void printLargestOrderConsumed(Metrics metrics) {
        //Print largest order consumed
        System.out.println("The largest order amount read was: " + metrics.getLargestOrder() + " cents!" );
    }

    private static void printSalesPerState(Metrics metrics) {
        //Print sales per state
        System.out.println("---------------");
        System.out.println("Following we have the total ordered per State:");
        for(Map.Entry<String, Long> stateSale : metrics.getOrderPerState().entrySet()){
            System.out.println(stateSale.getKey() + " <> " + stateSale.getValue());
        }
        System.out.println("---------------");
    }

    private static void printTotalOrderedProductOptions(Metrics metrics) {
        //Print total ordered per product option
        System.out.println("----------------------------------");
        System.out.println("Following we have the total ordered per SKU:");
        for(Map.Entry<String, Integer> stateSale : metrics.getProductSales().entrySet()){
            System.out.println(stateSale.getKey() + " <> " + stateSale.getValue());
        }
        System.out.println("----------------------------------");
    }

    private static void printProductOptionsList(String header, List<ProductOption> productOptions) {
        //Print all product options without stock information
        System.out.println("-------------------------------------");
        System.out.println(header);
        if(productOptions.isEmpty()){
            System.out.println("NO VALUES TO SHOW!!");
        } else {
            productOptions.forEach(System.out::println);
        }
        System.out.println("-------------------------------------");
    }
}

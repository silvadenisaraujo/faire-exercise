package viz;

import model.ProductOption;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Metrics {
    private static Metrics ourInstance = new Metrics();

    private Map<String, Long> orderPerState = new HashMap<>();
    private Map<String, Integer> productSales = new HashMap<>();
    private Long largestOrder = 0l;
    private List<ProductOption> backorderedProductOptions;
    private List<ProductOption> productOptionsWithoutStock;

    public static Metrics getInstance() {
        return ourInstance;
    }

    private Metrics() {
    }

    public Map<String, Long> getOrderPerState() {
        return orderPerState;
    }

    public void setOrderPerState(Map<String, Long> orderPerState) {
        this.orderPerState = orderPerState;
    }

    public Map<String, Integer> getProductSales() {
        return productSales;
    }

    public void setProductSales(Map<String, Integer> productSales) {
        this.productSales = productSales;
    }

    public Long getLargestOrder() {
        return largestOrder;
    }

    public void setLargestOrder(Long largestOrder) {
        this.largestOrder = largestOrder;
    }

    public void setBackorderedProductOptions(List<ProductOption> backorderedProductOptions) {
        this.backorderedProductOptions = backorderedProductOptions;
    }

    public List<ProductOption> getBackorderedProductOptions() {
        return backorderedProductOptions;
    }

    public void setProductOptionsWithoutStock(List<ProductOption> productOptionsWithoutStock) {
        this.productOptionsWithoutStock = productOptionsWithoutStock;
    }

    public List<ProductOption> getProductOptionsWithoutStock() {
        return productOptionsWithoutStock;
    }
}

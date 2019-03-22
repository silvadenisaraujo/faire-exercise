package model;

import java.util.List;

public class ProductInformation {
    private int pageNumber;
    private int limit;
    private List<Product> products;

    public ProductInformation(int pageNumber, int limit, List<Product> products) {
        this.pageNumber = pageNumber;
        this.limit = limit;
        this.products = products;
    }

    public ProductInformation(){}

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

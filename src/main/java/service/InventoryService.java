package service;

import model.Product;
import model.ProductOption;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryService {

    private Map<String, ProductOption> productInventory = new HashMap<>();
    private LocalDateTime lastUpdatedDate;

    private static InventoryService INSTANCE;

    private InventoryService(){}


    public static synchronized InventoryService getInstance(){
        if(INSTANCE == null){
            INSTANCE = new InventoryService();
        }
        return INSTANCE;
    }


    private synchronized boolean addProduct(Product product){
        try{
            for(ProductOption option : product.getOptions()){
                this.productInventory.put(option.getId(), option);
            }
            this.lastUpdatedDate = LocalDateTime.now();
            return true;
        }catch (Exception e){
            System.out.println("Couldn't add product to inventory, product: " + product);
            return false;
        }
    }

    public boolean consumeProduct(String productOptionId, int quantity) {
        try{
            Long currentQuantity = this.productInventory.get(productOptionId).getAvailable_quantity();
            Long updatedQuantity = currentQuantity - quantity;
            return updateProductQuantity(productOptionId, updatedQuantity);
        }catch (NullPointerException e){
            return false;
        }
    }

    private synchronized boolean updateProductQuantity(String optionId, Long quantity){
        if(!this.productInventory.containsKey(optionId)){
            System.out.println("Product Option: " + optionId + " doesn't exist in the InventoryService yet.");
            return false;
        }
        try{
            ProductOption option = this.productInventory.get(optionId);
            option.setAvailable_quantity(quantity);
            this.productInventory.replace(optionId, option);
            this.lastUpdatedDate = LocalDateTime.now();
            return true;
        }catch (Exception e){
            System.out.println("Product could't be updated, product option: " + optionId + " ,quantity: " + quantity);
            return false;
        }
    }

    public synchronized void initializeInventory(List<Product> products) {
        if(products != null){
            for(Product product : products){
                addProduct(product);
            }
        }
    }


    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Map<String, ProductOption> getProductInventory() {
        return productInventory;
    }

    public void setProductInventory(Map<String, ProductOption> productInventory) {
        this.productInventory = productInventory;
    }

}

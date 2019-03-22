package service;

import model.Product;
import model.ProductOption;
import org.junit.Before;
import org.junit.Test;
import service.InventoryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class InventoryTests {

    InventoryService inventory = InventoryService.getInstance();
    List<Product> products;


    @Before
    public void setUp(){

        //Generates 100 products
        products = new ArrayList<>();
        for(int i = 0; i < 100; i++){

            Product testProduct = new Product();
            testProduct.setId("ProductTestID" + i);

            ProductOption testProductOption1 = new ProductOption();
            testProductOption1.setAvailable_quantity(100L);
            testProductOption1.setActive(true);
            testProductOption1.setProductId("ProductTestID" + i);
            testProductOption1.setId("ProductOptionID_1_" + i);

            List<ProductOption> options = new ArrayList<>();
            options.add(testProductOption1);

            testProduct.setOptions(options);

            products.add(testProduct);
        }

    }

    @Test
    public void validateInventoryInitializeNull(){
        inventory.initializeInventory(null);
        assertEquals(new HashMap<>(), inventory.getProductInventory());
    }

    @Test
    public void validateInventoryInitializeQuantity(){
        inventory.initializeInventory(products);
        assertEquals(100, inventory.getProductInventory().values().size());
    }

    @Test
    public void validateInventoryUpdateQtyExistentProduct(){
        inventory.initializeInventory(products);
        boolean consumeOperation = inventory.consumeProduct("ProductOptionID_1_0", 5);
        assertTrue(consumeOperation);
        assertEquals(95, inventory.getProductInventory().get("ProductOptionID_1_0").getAvailable_quantity());
    }

    @Test
    public void validateInventoryUpdateQtyUnExistentProduct(){
        inventory.initializeInventory(products);
        boolean consumeOperation = inventory.consumeProduct("WRONG_PRODUCT_ID", 1);
        assertFalse(consumeOperation);
    }



}

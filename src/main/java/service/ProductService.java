package service;

import model.Product;
import model.ProductInformation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public static List<Product> loadProductsByBrand(String brandId, String accessToken) {
        List<Product> selectedBrandProducts = new ArrayList<>();
        int currentPage = 0;
        ProductInformation productInformation;
        try {
            do{
                productInformation = ServerInterface.retrieveProductInformationFromServer(brandId, currentPage, accessToken);
                selectedBrandProducts.addAll(productInformation.getProducts());
                currentPage++;
            } while(!productInformation.getProducts().isEmpty());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return selectedBrandProducts;
    }
}

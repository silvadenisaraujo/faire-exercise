package service;

import com.google.gson.Gson;
import model.OrderInformation;
import model.ProductInformation;
import util.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServerInterface {
    public static ProductInformation retrieveProductInformationFromServer(String brandId, int pageNumber,
                                                                          String accessToken)
            throws IOException {
        ProductInformation productInformation;
        URL urlForGetRequest;
        if(pageNumber <= 0) {
            urlForGetRequest = new URL(Constants.BASE_URL + Constants.PRODUCTS_URL + "?brandId=" + brandId);
        } else {
            urlForGetRequest = new URL(Constants.BASE_URL + Constants.PRODUCTS_URL + "?brandId=" + brandId + "&page=" + pageNumber);
        }
        String productJson = getServerInformation(accessToken, urlForGetRequest);
        productInformation = new Gson().fromJson(productJson, ProductInformation.class);
        return productInformation;
    }

    public static OrderInformation retrieveOrderInformationFromServer(int pageNumber, String accessToken)
            throws IOException {
        OrderInformation orderInformation;
        URL urlForGetRequest;
        if(pageNumber <= 0) {
            urlForGetRequest = new URL(Constants.BASE_URL + Constants.ORDERS_URL + "?limit=");
        } else {
            urlForGetRequest = new URL(Constants.BASE_URL + Constants.ORDERS_URL + "?page=" + pageNumber);
        }
        String orderJson = getServerInformation(accessToken, urlForGetRequest);
        orderInformation = new Gson().fromJson(orderJson, OrderInformation.class);
        return orderInformation;
    }

    private static String getServerInformation(String accessToken, URL urlForGetRequest) throws IOException {
        String readLine;
        StringBuilder response = new StringBuilder();
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-FAIRE-ACCESS-TOKEN", accessToken);
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            while ((readLine = in.readLine()) != null) {
                response.append(readLine);
            }
            in.close();
        } else {
            throw new IOException("Error on requesting information from faire's API - Error Code: " + responseCode);
        }
        return response.toString();
    }
}

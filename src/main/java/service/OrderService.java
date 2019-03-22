package service;

import model.Order;
import model.OrderInformation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    public static List<Order> loadOrders(String accessToken) {
        List<Order> orders = new ArrayList<>();
        int currentPage = 0;
        OrderInformation orderInformation;
        try {
            do{
                orderInformation = ServerInterface.retrieveOrderInformationFromServer(currentPage, accessToken);
                orders.addAll(orderInformation.getOrders());
                currentPage++;
            } while(!orderInformation.getOrders().isEmpty());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }
}

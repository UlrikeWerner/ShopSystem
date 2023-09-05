package com.github.UlrikeWerner.shop.Services;

import com.github.UlrikeWerner.shop.Entities.Order;
import com.github.UlrikeWerner.shop.Repos.OrderListRepo;
import com.github.UlrikeWerner.shop.Repos.ProductRepo;

import java.util.List;

public class ShopService {
    private final ProductRepo productRepo;
    private OrderListRepo orderListRepo;

    public ShopService(ProductRepo productRepo, OrderListRepo orderListRepo) {
        this.productRepo = productRepo;
        this.orderListRepo = orderListRepo;
    }

    public void createNewOrder(List<Order> newOrder){
        for(Order order : newOrder){
            if(productRepo.getProductInfo(order.product().productId()) == null){
                System.out.println("Produkt existiert nicht mehr!");
                continue;
            }
            orderListRepo.addOrderToOrderList(order);
        }
    }
    public void createNewOrder(Order singleOrder){
        if(productRepo.getProductInfo(singleOrder.product().productId()) == null) {
            System.out.println("Produkt existiert nicht mehr!");
            return;
        }
        orderListRepo.addOrderToOrderList(singleOrder);
    }
}

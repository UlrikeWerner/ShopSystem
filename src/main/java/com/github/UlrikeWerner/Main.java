package com.github.UlrikeWerner;

import com.github.UlrikeWerner.shop.Entities.Order;
import com.github.UlrikeWerner.shop.Entities.Product;
import com.github.UlrikeWerner.shop.Repos.OrderListRepo;
import com.github.UlrikeWerner.shop.Repos.ProductRepo;
import com.github.UlrikeWerner.shop.Services.ShopService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        //Map<UUID, Product> productList = new HashMap<>();
        ProductRepo productRepo = new ProductRepo(new HashMap<>());
        OrderListRepo orderListRepo = new OrderListRepo();
        ShopService shopService = new ShopService(productRepo, orderListRepo);

        Product p1 = new Product(UUID.randomUUID(), "Handy", new BigDecimal("125.99"));
        Product p2 = new Product(UUID.randomUUID(), "Tablet", new BigDecimal("380.00"));
        Product p3 = new Product(UUID.randomUUID(), "PC", new BigDecimal("2300.00"));
        shopService.addNewProductToProductRepo(p1);
        shopService.addNewProductToProductRepo(p2);
        shopService.addNewProductToProductRepo(p3);

        System.out.println(productRepo);
        System.out.println(orderListRepo);
        shopService.createNewOrder(new Order(p1));
        shopService.createNewOrder(new Order(p3));
        System.out.println("-------------");
        System.out.println(orderListRepo);
        shopService.totalBill();
        System.out.println("---------------");
        shopService.deleteProductFromProductRepo(p1);
        System.out.println(orderListRepo);
        shopService.totalBill();
    }
}

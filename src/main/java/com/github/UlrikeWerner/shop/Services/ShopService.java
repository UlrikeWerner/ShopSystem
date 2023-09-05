package com.github.UlrikeWerner.shop.Services;

import com.github.UlrikeWerner.shop.Entities.Order;
import com.github.UlrikeWerner.shop.Entities.Product;
import com.github.UlrikeWerner.shop.Repos.OrderListRepo;
import com.github.UlrikeWerner.shop.Repos.ProductRepo;

import java.util.List;
import java.util.Objects;

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

    public void addNewProductToProductRepo(Product product){
        productRepo.addProductToList(product);
    }

    public void totalBill(){
        System.out.println("total Price: " + orderListRepo.getTotalPrice());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopService that = (ShopService) o;
        return Objects.equals(productRepo, that.productRepo) && Objects.equals(orderListRepo, that.orderListRepo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productRepo, orderListRepo);
    }
}

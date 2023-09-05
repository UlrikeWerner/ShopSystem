package com.github.UlrikeWerner.shop.Repos;

import com.github.UlrikeWerner.shop.Entities.Order;

import java.util.*;

public class OrderMapRepo implements OrderRepoInterface{
    private UUID orderNumber;
    private Map<UUID, Order> orderMap = new HashMap<>();

    public OrderMapRepo(){}
    public OrderMapRepo(UUID orderNumber, Map<UUID, Order> orderMap) {
        this.orderNumber = orderNumber;
        this.orderMap = orderMap;
    }

    @Override
    public void addOrderToOrderList(Order order) {
        orderMap.put(order.product().productId(), order);
    }

    @Override
    public void deleteOrderFromTheOrderList(Order order) {
        if(!orderMap.containsKey(order.product().productId())){
            System.out.println("Das Produkt ist nicht auf deiner Bestellungsliste!");
            return;
        }
        orderMap.remove(order.product().productId());
    }

    public Map<UUID, Order> findOrderList(UUID orderNumber) {
        if(this.orderNumber == orderNumber){
            return orderMap;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderMapRepo that = (OrderMapRepo) o;
        return Objects.equals(orderMap, that.orderMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderMap);
    }

}

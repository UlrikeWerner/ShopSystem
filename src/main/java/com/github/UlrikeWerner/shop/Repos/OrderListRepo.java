package com.github.UlrikeWerner.shop.Repos;

import com.github.UlrikeWerner.shop.Entities.Order;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class OrderListRepo {
    private final UUID orderNumber;
    List<Order> orderList;

    //Constructor
    public OrderListRepo(UUID orderNumber, List<Order> orderList) {
        this.orderNumber = orderNumber;
        this.orderList = orderList;
    }

    //Getter
    public UUID getOrderNumber() {
        return orderNumber;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    //methods
    public void addOrderToOrderList(Order order){
        orderList.add(order);
    }
    public void deleteOrderFromTheOrderList(Order order){
        if(!orderList.contains(order)){
            System.out.println("Das Produkt ist nicht auf deiner Bestellungsliste!");
            return;
        }
        orderList.remove(order);
    }

    //generated methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderListRepo that = (OrderListRepo) o;
        return Objects.equals(orderNumber, that.orderNumber) && Objects.equals(orderList, that.orderList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, orderList);
    }

    @Override
    public String toString() {
        return "OrderListRepo{" +
                "orderNumber=" + orderNumber +
                ", orderList=" + orderList +
                '}';
    }
}

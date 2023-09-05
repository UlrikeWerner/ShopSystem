package com.github.UlrikeWerner.shop.Repos;

import com.github.UlrikeWerner.shop.Entities.Order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class OrderListRepo {
    private UUID orderNumber;
    private List<Order> orderList;
    private BigDecimal totalPrice;

    //Constructor
    public OrderListRepo() {
        this.orderNumber = UUID.randomUUID();
        this.orderList = new ArrayList<>();
        this.totalPrice = new BigDecimal("0.00");
    }

    //Getter & Setter
    public UUID getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(UUID orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    //methods
    public void addOrderToOrderList(Order order){
        orderList.add(order);
        totalPrice = totalPrice.add(order.product().price());
    }
    public void deleteOrderFromTheOrderList(Order order){
        if(!orderList.contains(order)){
            System.out.println("Das Produkt ist nicht auf deiner Bestellungsliste!");
            return;
        }
        totalPrice = totalPrice.subtract(order.product().price());
        orderList.remove(order);
    }

    public List<Order> findOrderList(UUID orderNumber){
       if(this.orderNumber == orderNumber){
           return orderList;
       }
       return null;
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

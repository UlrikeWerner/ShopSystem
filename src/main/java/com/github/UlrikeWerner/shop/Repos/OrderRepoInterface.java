package com.github.UlrikeWerner.shop.Repos;

import com.github.UlrikeWerner.shop.Entities.Order;

public interface OrderRepoInterface {
    void addOrderToOrderList(Order order);
    void deleteOrderFromTheOrderList(Order order);
}

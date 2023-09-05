package com.github.UlrikeWerner.shop.Entities;

import java.math.BigDecimal;
import java.util.UUID;

public record Product(
        UUID productId,
        String productName,
        BigDecimal price
) {
}

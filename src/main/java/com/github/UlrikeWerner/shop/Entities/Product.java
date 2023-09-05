package com.github.UlrikeWerner.shop.Entities;

import java.util.UUID;

public record Product(
        UUID productId,
        String productName
) {
}

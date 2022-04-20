package com.devcode.marketplace.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Purchase {
    private int purchaseId;
    private String clientId;
    private LocalDateTime Date;
    private String paymentMethod;
    private String comment;
    private String state;
    private List<PurchaseItem> items;
}

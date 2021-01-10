package com.example.demo.mapper;

import com.example.demo.dto.PurchaseRequest;
import com.example.demo.model.Purchase;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMapper {
    public Purchase purchaseRequestToPurchase(PurchaseRequest purchaseRequest) {
        return new Purchase(purchaseRequest.getTouristCode(), purchaseRequest.getTripCode(), purchaseRequest.getStartDate(),
                            purchaseRequest.getEndDate(), purchaseRequest.getPurchaseDate(), purchaseRequest.getDiscount());
    }
}

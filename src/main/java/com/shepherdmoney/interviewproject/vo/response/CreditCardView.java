package com.shepherdmoney.interviewproject.vo.response;

import com.shepherdmoney.interviewproject.model.CreditCard;

public class CreditCardView {
    // Example fields that might be in a CreditCardView
    private int id;
    private String cardNumber;
    private String issuanceBank;
    private int ownerId;

    // Constructor that accepts a CreditCard entity and initializes the view model
    public CreditCardView(CreditCard creditCard) {
        this.id = creditCard.getId();
        this.cardNumber = creditCard.getCardNumber();
        this.issuanceBank = creditCard.getIssuanceBank();
        this.ownerId = creditCard.getOwner().getId(); // Assuming CreditCard has a 'getOwner' that returns a User
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getIssuanceBank() {
        return issuanceBank;
    }

    public void setIssuanceBank(String issuanceBank) {
        this.issuanceBank = issuanceBank;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}


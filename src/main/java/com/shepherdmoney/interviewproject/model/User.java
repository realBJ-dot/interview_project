package com.shepherdmoney.interviewproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;  
import java.util.ArrayList; 

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "MyUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String email;

    // User's credit cards. Configured to manage one-to-many relationship with CreditCard.
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CreditCard> creditCards;

    // Adds a credit card to this user and sets the user as the owner of the credit card.
    public void addCreditCard(CreditCard creditCard) {
        if (this.creditCards == null) {
            this.creditCards = new ArrayList<>();
        }
        this.creditCards.add(creditCard);
        creditCard.setOwner(this);
    }

    public int getUserId() {
        return id;
    }
    
    // Removes a credit card from this user and clears the owner of the credit card.
    public void removeCreditCard(CreditCard creditCard) {
        if (this.creditCards != null) {
            this.creditCards.remove(creditCard);
        }
        creditCard.setOwner(null);
    }
}

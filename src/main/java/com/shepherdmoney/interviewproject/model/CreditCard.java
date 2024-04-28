package com.shepherdmoney.interviewproject.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.*;
import java.util.Date;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String issuanceBank;

    private String number;

    @ManyToOne
    @JoinColumn(name = "user_id") 
    private User owner;

    @Transient // Not persisting this map directly to the database.
    private NavigableMap<Date, BigDecimal> balanceHistory = new TreeMap<>();

    public void setCardNumber(String cardNumber) {
        number = cardNumber;
    }
    public void setUserId(int userId) {
        id = userId;
    }

    public String getCardNumber(){
        return number;
    }

    public void updateBalanceHistory(Date date, BigDecimal newBalance) {
        balanceHistory.put(date, newBalance);
        // Ensure the most recent date is always at the end, which TreeMap naturally maintains by date order
    }
}

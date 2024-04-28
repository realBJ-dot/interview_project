package com.shepherdmoney.interviewproject.controller;

import com.shepherdmoney.interviewproject.model.CreditCard;
import com.shepherdmoney.interviewproject.repository.CreditCardRepository;
import com.shepherdmoney.interviewproject.vo.request.AddCreditCardToUserPayload;
import com.shepherdmoney.interviewproject.vo.request.UpdateBalancePayload;
import com.shepherdmoney.interviewproject.vo.response.CreditCardView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

@RestController
public class CreditCardController {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @PostMapping("/credit-card")
    public ResponseEntity<Integer> addCreditCardToUser(@RequestBody AddCreditCardToUserPayload payload) {
        CreditCard newCard = new CreditCard();
        newCard.setCardNumber(payload.getCardNumber());
        newCard.setUserId(payload.getUserId());
        newCard = creditCardRepository.save(newCard);
        return ResponseEntity.ok(newCard.getId());
    }

    @GetMapping("/credit-card/all")
    public ResponseEntity<List<CreditCardView>> getAllCardOfUser(@RequestParam int userId) {
        List<CreditCardView> cards = creditCardRepository.findByOwnerId(userId)
                                        .stream()
                                        .map(card -> new CreditCardView(card))
                                        .collect(Collectors.toList());
        return ResponseEntity.ok(cards);
    }

}

package com.shepherdmoney.interviewproject.repository;

import com.shepherdmoney.interviewproject.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
    // This method assumes that there is a 'User' entity linked from 'CreditCard' through 'owner' field
    // and the 'User' entity has an 'id' field.
    List<CreditCard> findByOwnerId(int userId);

    List<CreditCard> findByCardNumber(String cardNumber);
}

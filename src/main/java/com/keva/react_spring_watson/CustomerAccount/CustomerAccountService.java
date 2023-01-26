package com.keva.react_spring_watson.CustomerAccount;

import com.keva.react_spring_watson.CustomerAddress.CustomerAddress;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface CustomerAccountService {

    List<CustomerAccount> getAllCustomers();
    CustomerAccount getCustomerById(Long id);
    String getCustomerPlan(Long id);
    ResponseEntity<?> updateCustomerField(Map<String, Object> fields, Long id);
    void createCustomerAccount(CustomerAccount customerAccount);
}

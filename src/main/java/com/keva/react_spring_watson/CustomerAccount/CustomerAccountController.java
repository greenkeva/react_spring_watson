package com.keva.react_spring_watson.CustomerAccount;

import com.keva.react_spring_watson.CustomerAddress.CustomerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RequestMapping("api/v1/account")
@RestController
public class CustomerAccountController {

    @Autowired
    CustomerAccountImpl customerAccountImpl;

    @GetMapping
    public List<CustomerAccount> getAccounts(){
        return customerAccountImpl.getAllCustomers();
    }

    @GetMapping(path = "/{id}")
    public CustomerAccount getCustomerAccount(@PathVariable Long id){
       return customerAccountImpl.getCustomerById(id);
    }

    @GetMapping("/plan/{id}")
    public String getPlanOnAccount(@PathVariable Long id){
        return customerAccountImpl.getCustomerPlan(id);
    }

    @PostMapping(path = "/create")
    public void createNewAccount(@RequestBody CustomerAccount customerAccount){
        customerAccountImpl.createCustomerAccount(customerAccount);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updatePlanOnAccount(@RequestBody Map<String, Object> field, @PathVariable Long id){
        return customerAccountImpl.updateCustomerField(field, id);

    }

}

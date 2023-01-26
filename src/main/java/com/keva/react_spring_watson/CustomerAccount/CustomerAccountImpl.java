package com.keva.react_spring_watson.CustomerAccount;

import com.keva.react_spring_watson.CustomerAddress.CustomerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomerAccountImpl implements CustomerAccountService {

    @Autowired
    CustomerAccountRepo repo;

    @Override
    public List<CustomerAccount> getAllCustomers() {
        return repo.findAll();
    }

    @Override
    public CustomerAccount getCustomerById(Long id) {

        return repo.findById(id).isPresent() ? repo.findById(id).get() : null;
    }

    @Override
    public String getCustomerPlan(Long id) {
        return repo.findById(id).isPresent() ? repo.findById(id).get().getPlan() : null;
    }

    @Override
    public ResponseEntity<?> updateCustomerField(Map<String, Object> fields, Long id) {
        Optional<CustomerAccount> customerAccount = repo.findById(id);
        if(customerAccount.isPresent()){
            fields.forEach((k,v) ->{
                Field field = ReflectionUtils.findField(CustomerAccount.class, k);
                field.setAccessible(true);
                ReflectionUtils.setField(field, customerAccount.get(), v);
            });
            repo.save(customerAccount.get());
        }

        return ResponseEntity.ok("Your plan was updated successfully");
    }

    @Override
    public void createCustomerAccount(CustomerAccount customerAccount) {

        repo.save(customerAccount);

    }

}

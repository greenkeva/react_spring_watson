package com.keva.react_spring_watson.CustomerAccount;

import com.keva.react_spring_watson.CustomerAddress.CustomerAddressRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAccountRepo extends JpaRepository<CustomerAccount, Long> {
}

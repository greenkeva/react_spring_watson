package com.keva.react_spring_watson.CustomerAddress;

import jakarta.annotation.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAddressRepo extends JpaRepository<CustomerAddress,Long> {
}

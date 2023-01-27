package com.keva.react_spring_watson.CustomerAddress;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.keva.react_spring_watson.CustomerAccount.CustomerAccount;
import com.keva.react_spring_watson.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "address")
@Table(name = "customer_address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddress {

    @Id
    @SequenceGenerator(name = "address_id_sequence", sequenceName = "address_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id_sequence")
    private Long id;

    @Column(name = "house_no")
    private int houseNo;
    private String street;
    private String apt;
    private String city;
    private String state;
    private int zip;

    @OneToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "user_account_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

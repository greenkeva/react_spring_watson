package com.keva.react_spring_watson.CustomerAddress;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.keva.react_spring_watson.CustomerAccount.CustomerAccount;
import jakarta.persistence.*;

@Entity(name = "address")
@Table(name = "customer_address")
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
    @JoinColumn(name = "customer_account_id")
    private CustomerAccount customerAccount;


    public CustomerAddress(){}
    public CustomerAddress(int houseNo, String street, String apt, String city, String state, int zip) {
        this.houseNo = houseNo;
        this.street = street;
        this.apt = apt;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

//    public CustomerAddress(int houseNo, String street, String city, String state, int zip) {
//        this.houseNo = houseNo;
//        this.street = street;
//        this.city = city;
//        this.state = state;
//        this.zip = zip;
//    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApt() {
        return apt;
    }

    public void setApt(String apt) {
        this.apt = apt;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "CustomerAddress{" +
                "houseNo=" + houseNo +
                ", street='" + street + '\'' +
                ", apt='" + apt +',' + '\'' +
                ", city='" + city +',' + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                '}';
    }
}

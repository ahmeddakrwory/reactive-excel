package com.example.test.demo.test.entitys;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Immutable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Immutable

@Table(name = "tt_ts_agent_order_customer")
public class TtTsAgentOrderCustomer {
    @Id
    private TtTsAgentOrderCustomerId id;

    @Column(   "TITLE")
    private Integer title;

    @Column(   "FIRST_NAME")
    private String firstName;

    @Column(   "LAST_NAME")
    private String lastName;

    @Column(   "CUSTOMER_TYPE")
    private Integer customerType;

    @Column(   "TRAVELER_ID")
    private String travelerId;

    @Column(   "CORPORATE_ID")
    private String corporateId;

    @Column(   "COUNTRY")
    private String country;

    @Column(   "CITY")
    private String city;

    @Column(   "MOBILE_NO")
    private String mobileNo;

    @Column(   "EMAIL_ID")
    private String emailId;

    @Column(   "COMPANY_NAME")
    private String companyName;

    @Column(   "CUSTOMER_REF_ID")
    private String customerRefId;

    @Column(   "IDENTITY_NO")
    private String identityNo;

    @Column(   "ADDRESS")
    private String address;

    public TtTsAgentOrderCustomerId getId() {
        return id;
    }

    public void setId(TtTsAgentOrderCustomerId id) {
        this.id = id;
    }

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    public String getTravelerId() {
        return travelerId;
    }

    public void setTravelerId(String travelerId) {
        this.travelerId = travelerId;
    }

    public String getCorporateId() {
        return corporateId;
    }

    public void setCorporateId(String corporateId) {
        this.corporateId = corporateId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCustomerRefId() {
        return customerRefId;
    }

    public void setCustomerRefId(String customerRefId) {
        this.customerRefId = customerRefId;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
package com.example.test.demo.test.entitys;



import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.Instant;


@Table( "tt_user")
public class TtUser {
    @Id

    @Column( name="USER_ID")
    private Integer id;

    @Column( name = "USER_ALIAS")
    private String userAlias;

    @Column( name = "PASSWORD")
    private String password;

    @Column( name = "TITLE")
    private Integer title;

    @Column( name = "FIRST_NAME")
    private String firstName;

    @Column( name = "MIDDLE_NAME")
    private String middleName;

    @Column( name = "LAST_NAME")
    private String lastName;

    @Column( name = "MOBILE_NUMBER")
    private String mobileNumber;

    @Column( name = "DATE_OF_BIRTH")
    private Instant dateOfBirth;

    @Column( name = "PROFILE_IMAGE")
    private String profileImage;

    @Column( name = "EMAIL")
    private String email;

    @Column(name = "FAX")
    private String fax;

    @Column( name = "GENDER")
    private Integer gender;

    @Column(name = "MARITAL_STATUS")
    private Integer maritalStatus;

    @Column(name = "USER_TYPE")
    private Integer userType;

    @Column( name = "LAST_LOGIN_DATE")
    private Instant lastLoginDate;

    @Column( name = "CREATION_TIME")
    private Instant creationTime;

    @Column( name = "LAST_MOD_TIME")
    private Instant lastModTime;

    @Column( name = "USER_STATUS")
    private Integer userStatus;

    @Column( name = "DISABLE_SIGNIN")
    private Integer disableSignin;

    @Column( name = "MOBILE_NUMBER1")
    private String mobileNumber1;

    @Column( name = "APPROVAL_ID")
    private Integer approvalId;

    @Column( name = "IMPORT_PNR")
    private Integer importPnr;

    @Column( name = "USER_SCOPE_TYPE")
    private Integer userScopeType;

    @Column( name = "LAST_MODIFIED_PASS_TIME")
    private Instant lastModifiedPassTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Instant getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Instant dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Instant getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Instant lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Instant creationTime) {
        this.creationTime = creationTime;
    }

    public Instant getLastModTime() {
        return lastModTime;
    }

    public void setLastModTime(Instant lastModTime) {
        this.lastModTime = lastModTime;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getDisableSignin() {
        return disableSignin;
    }

    public void setDisableSignin(Integer disableSignin) {
        this.disableSignin = disableSignin;
    }

    public String getMobileNumber1() {
        return mobileNumber1;
    }

    public void setMobileNumber1(String mobileNumber1) {
        this.mobileNumber1 = mobileNumber1;
    }

    public Integer getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Integer approvalId) {
        this.approvalId = approvalId;
    }

    public Integer getImportPnr() {
        return importPnr;
    }

    public void setImportPnr(Integer importPnr) {
        this.importPnr = importPnr;
    }

    public Integer getUserScopeType() {
        return userScopeType;
    }

    public void setUserScopeType(Integer userScopeType) {
        this.userScopeType = userScopeType;
    }

    public Instant getLastModifiedPassTime() {
        return lastModifiedPassTime;
    }

    public void setLastModifiedPassTime(Instant lastModifiedPassTime) {
        this.lastModifiedPassTime = lastModifiedPassTime;
    }

}
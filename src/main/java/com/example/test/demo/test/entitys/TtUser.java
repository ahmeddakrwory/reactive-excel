package com.example.test.demo.test.entitys;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Immutable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Immutable
@Table(name = "tt_user")
public class TtUser {
    @Id
    @Column( "USER_ID")
    private Integer userId;

    @Column( "USER_ALIAS")
    private String userAlias;

    @Column( "PASSWORD")
    private String password;

    @Column(  "TITLE")
    private Integer title;

    @Column( "FIRST_NAME")
    private String firstName;

    @Column( "MIDDLE_NAME")
    private String middleName;

    @Column( "LAST_NAME")
    private String lastName;

    @Column( "MOBILE_NUMBER")
    private String mobileNumber;

    @Column( "DATE_OF_BIRTH")
    private java.sql.Timestamp dateOfBirth;

    @Column( "PROFILE_IMAGE")
    private String profileImage;

    @Column( "EMAIL")
    private String email;

    @Column( "FAX")
    private String fax;

    @Column( "GENDER")
    private Integer gender;

    @Column( "MARITAL_STATUS")
    private Integer maritalStatus;

    @Column( "USER_TYPE")
    private Integer userType;

    @Column( "LAST_LOGIN_DATE")
    private java.sql.Timestamp lastLoginDate;

    @Column( "CREATION_TIME")
    private java.sql.Timestamp creationTime;

    @Column( "LAST_MOD_TIME")
    private java.sql.Timestamp lastModTime;

    @Column( "USER_STATUS")
    private Integer userStatus;

    @Column( "DISABLE_SIGNIN")
    private Integer disableSignin;

    @Column( "MOBILE_NUMBER1")
    private String mobileNumber1;

    @Column("APPROVAL_ID")
    private Integer approvalId;

    @Column("IMPORT_PNR")
    private Integer importPnr;

    @Column( "USER_SCOPE_TYPE")
    private Integer userScopeType;

    @Column( "LAST_MODIFIED_PASS_TIME")
    private java.sql.Timestamp lastModifiedPassTime;

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserAlias() {
        return this.userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTitle() {
        return this.title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public java.sql.Timestamp getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(java.sql.Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getProfileImage() {
        return this.profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Integer getGender() {
        return this.gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getMaritalStatus() {
        return this.maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getUserType() {
        return this.userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public java.sql.Timestamp getLastLoginDate() {
        return this.lastLoginDate;
    }

    public void setLastLoginDate(java.sql.Timestamp lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public java.sql.Timestamp getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(java.sql.Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public java.sql.Timestamp getLastModTime() {
        return this.lastModTime;
    }

    public void setLastModTime(java.sql.Timestamp lastModTime) {
        this.lastModTime = lastModTime;
    }

    public Integer getUserStatus() {
        return this.userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getDisableSignin() {
        return this.disableSignin;
    }

    public void setDisableSignin(Integer disableSignin) {
        this.disableSignin = disableSignin;
    }

    public String getMobileNumber1() {
        return this.mobileNumber1;
    }

    public void setMobileNumber1(String mobileNumber1) {
        this.mobileNumber1 = mobileNumber1;
    }

    public Integer getApprovalId() {
        return this.approvalId;
    }

    public void setApprovalId(Integer approvalId) {
        this.approvalId = approvalId;
    }

    public Integer getImportPnr() {
        return this.importPnr;
    }

    public void setImportPnr(Integer importPnr) {
        this.importPnr = importPnr;
    }

    public Integer getUserScopeType() {
        return this.userScopeType;
    }

    public void setUserScopeType(Integer userScopeType) {
        this.userScopeType = userScopeType;
    }

    public java.sql.Timestamp getLastModifiedPassTime() {
        return this.lastModifiedPassTime;
    }

    public void setLastModifiedPassTime(java.sql.Timestamp lastModifiedPassTime) {
        this.lastModifiedPassTime = lastModifiedPassTime;
    }
}

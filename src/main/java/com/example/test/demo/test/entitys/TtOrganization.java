package com.example.test.demo.test.entitys;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Immutable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.Instant;
@Immutable
@Table(name = "tt_organization")
public class TtOrganization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("ORGANIZATION_ID")
    private String id;

    @Column( "GROUP_ID")
    private Integer groupId;

    @Column( "COUNTRY_ID")
    private Integer countryId;

    @Column( "STATE_ID")
    private Integer stateId;

    @Column("CITY_ID")
    private Integer cityId;

    @Column( "ADDRESS1")
    private String address1;

    @Column("ADDRESS2")
    private String address2;

    @Column( "ZIP")
    private String zip;

    @Column( "PHONE")
    private String phone;

    @Column( "FAX")
    private String fax;

    @Column( "EMAIL")
    private String email;

    @Column( "WEB")
    private String web;

    @Column( "LANGUAGE_ID")
    private String languageId;

    @Column( "CURRENCY_ID")
    private Integer currencyId;

    @Column( "CREATED_BY")
    private Integer createdBy;

    @Column( "CREATION_TIME")
    private Instant creationTime;

    @Column( "LAST_MOD_TIME")
    private Instant lastModTime;

    @Column( "LAST_UPDATED_BY")
    private Integer lastUpdatedBy;

    @Column( "ORGANIZATION_TYPE")
    private Integer organizationType;

    @Column( "STATUS")
    private Integer status;

    @Column("BRAND")
    private String brand;

    @Column( "IMPORT_PNR")
    private Integer importPnr;

    @Column( "IS_IATA_AGENCY")
    private Byte isIataAgency;

    @Column(  "APPROVAL_USER_ID")
    private Integer approvalUserId;

    @Column(  "APPROVAL_STATUS")
    private Integer approvalStatus;

    @Column( "APPROVAL_DATE")
    private Instant approvalDate;

    @Column("APPROVAL_REMARKS")
    private String approvalRemarks;

    @Column( "APPROVAL_BY")
    private Integer approvalBy;

    @Column( "NOTIFICATION_TYPE")
    private Integer notificationType;

    @Column("POS_OBJECT_ID")
    private String posObjectId;

    @Column( "TRANSACTION_ID")
    private String transactionId;

    @Column("LATITUDE")
    private String latitude;

    @Column( "LONGITUDE")
    private String longitude;

    @Column( "BRANCH_EMAIL")
    private String branchEmail;

    @Column( "BRANCH_EMAIL_PASSWORD")
    private String branchEmailPassword;

    @Column( "IS_ODR_DEFAULT_BRANCH")
    private Integer isOdrDefaultBranch;

    @Column( "PI_SEARCH")
    private Integer piSearch;

    @Column( "MAPPED_USER_ID")
    private String mappedUserId;

    @Column("RESTRICT_PRIVATE_FARE")
    private Integer restrictPrivateFare;

    @Column("PI_PACKAGE_GIT")
    private Integer piPackageGit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
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

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Integer getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(Integer organizationType) {
        this.organizationType = organizationType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getImportPnr() {
        return importPnr;
    }

    public void setImportPnr(Integer importPnr) {
        this.importPnr = importPnr;
    }

    public Byte getIsIataAgency() {
        return isIataAgency;
    }

    public void setIsIataAgency(Byte isIataAgency) {
        this.isIataAgency = isIataAgency;
    }

    public Integer getApprovalUserId() {
        return approvalUserId;
    }

    public void setApprovalUserId(Integer approvalUserId) {
        this.approvalUserId = approvalUserId;
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public Instant getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Instant approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getApprovalRemarks() {
        return approvalRemarks;
    }

    public void setApprovalRemarks(String approvalRemarks) {
        this.approvalRemarks = approvalRemarks;
    }

    public Integer getApprovalBy() {
        return approvalBy;
    }

    public void setApprovalBy(Integer approvalBy) {
        this.approvalBy = approvalBy;
    }

    public Integer getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(Integer notificationType) {
        this.notificationType = notificationType;
    }

    public String getPosObjectId() {
        return posObjectId;
    }

    public void setPosObjectId(String posObjectId) {
        this.posObjectId = posObjectId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getBranchEmail() {
        return branchEmail;
    }

    public void setBranchEmail(String branchEmail) {
        this.branchEmail = branchEmail;
    }

    public String getBranchEmailPassword() {
        return branchEmailPassword;
    }

    public void setBranchEmailPassword(String branchEmailPassword) {
        this.branchEmailPassword = branchEmailPassword;
    }

    public Integer getIsOdrDefaultBranch() {
        return isOdrDefaultBranch;
    }

    public void setIsOdrDefaultBranch(Integer isOdrDefaultBranch) {
        this.isOdrDefaultBranch = isOdrDefaultBranch;
    }

    public Integer getPiSearch() {
        return piSearch;
    }

    public void setPiSearch(Integer piSearch) {
        this.piSearch = piSearch;
    }

    public String getMappedUserId() {
        return mappedUserId;
    }

    public void setMappedUserId(String mappedUserId) {
        this.mappedUserId = mappedUserId;
    }

    public Integer getRestrictPrivateFare() {
        return restrictPrivateFare;
    }

    public void setRestrictPrivateFare(Integer restrictPrivateFare) {
        this.restrictPrivateFare = restrictPrivateFare;
    }

    public Integer getPiPackageGit() {
        return piPackageGit;
    }

    public void setPiPackageGit(Integer piPackageGit) {
        this.piPackageGit = piPackageGit;
    }

}
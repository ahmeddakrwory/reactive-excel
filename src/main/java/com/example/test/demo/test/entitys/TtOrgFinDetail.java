package com.example.test.demo.test.entitys;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Immutable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.Instant;

@Immutable
@Table(name = "tt_org_fin_detail")
public class TtOrgFinDetail {
    @Id
    @Column( "ORGANIZATION_ID")
    private String id;

    @Column( "PAN")
    private String pan;

    @Column( "SERVICE_TAX_NO")
    private String serviceTaxNo;

    @Column("IS_IATA")
    private Boolean isIata;

    @Column( "CONTRACT_START_DATE")
    private Instant contractStartDate;

    @Column( "CONTRACT_END_DATE")
    private Instant contractEndDate;

    @Column("IS_IMPORT_PNR")
    private Boolean isImportPnr;

    @Column( "IATA_NUMBER")
    private String iataNumber;

    @Column("INVOICE_SERIES")
    private String invoiceSeries;

    @Column("QUOTE_SERIES")
    private String quoteSeries;

    @Column("CREDIT_LIMIT")
    private BigDecimal creditLimit;

    @Column( "TARGET_AMOUNT")
    private BigDecimal targetAmount;

    @Column( "INVOICE_GEN_FREQUENCY")
    private Byte invoiceGenFrequency;

    @Column( "CREATED_BY")
    private Integer createdBy;

    @Column(         "LAST_UPDATED_BY")
    private Integer lastUpdatedBy;

    @Column(         "CREATION_TIME")
    private Instant creationTime;

    @Column(         "LAST_MOD_TIME"   )
    private String lastModTime;

    @Column(         "TOPUP_BALANCE"     )
    private BigDecimal topupBalance;

    @Column(         "WALLET_AMOUNT"     )
    private BigDecimal walletAmount;

    @Column(         "CREDIT_LIMIT_BALANCE"     )
    private BigDecimal creditLimitBalance;

    @Column(         "ODEYSYS_OS"      )
    private BigDecimal odeysysOs;

    @Column(         "TOPUP_REVERSE"      )
    private BigDecimal topupReverse;

    @Column(         "TOPUP_AMOUNT_LIMIT"      )
    private String topupAmountLimit;

    @Column("CREDIT_TERMS")
    private Integer creditTerms;

    @Column( "CREDIT_TERMS_DATE")
    private Instant creditTermsDate;

    @Column("REACHING_PERCENTAGE" )
    private BigDecimal reachingPercentage;

    @Column(         "WARNING_PROMT")
    private Integer warningPromt;

    @Column(         "CREDIT_AGENCY")
    private Integer creditAgency;

    @Column(         "IS_BLOCKED")
    private Boolean isBlocked;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getServiceTaxNo() {
        return serviceTaxNo;
    }

    public void setServiceTaxNo(String serviceTaxNo) {
        this.serviceTaxNo = serviceTaxNo;
    }

    public Boolean getIsIata() {
        return isIata;
    }

    public void setIsIata(Boolean isIata) {
        this.isIata = isIata;
    }

    public Instant getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Instant contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Instant getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Instant contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Boolean getIsImportPnr() {
        return isImportPnr;
    }

    public void setIsImportPnr(Boolean isImportPnr) {
        this.isImportPnr = isImportPnr;
    }

    public String getIataNumber() {
        return iataNumber;
    }

    public void setIataNumber(String iataNumber) {
        this.iataNumber = iataNumber;
    }

    public String getInvoiceSeries() {
        return invoiceSeries;
    }

    public void setInvoiceSeries(String invoiceSeries) {
        this.invoiceSeries = invoiceSeries;
    }

    public String getQuoteSeries() {
        return quoteSeries;
    }

    public void setQuoteSeries(String quoteSeries) {
        this.quoteSeries = quoteSeries;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(BigDecimal targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Byte getInvoiceGenFrequency() {
        return invoiceGenFrequency;
    }

    public void setInvoiceGenFrequency(Byte invoiceGenFrequency) {
        this.invoiceGenFrequency = invoiceGenFrequency;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Instant creationTime) {
        this.creationTime = creationTime;
    }

    public String getLastModTime() {
        return lastModTime;
    }

    public void setLastModTime(String lastModTime) {
        this.lastModTime = lastModTime;
    }

    public BigDecimal getTopupBalance() {
        return topupBalance;
    }

    public void setTopupBalance(BigDecimal topupBalance) {
        this.topupBalance = topupBalance;
    }

    public BigDecimal getWalletAmount() {
        return walletAmount;
    }

    public void setWalletAmount(BigDecimal walletAmount) {
        this.walletAmount = walletAmount;
    }

    public BigDecimal getCreditLimitBalance() {
        return creditLimitBalance;
    }

    public void setCreditLimitBalance(BigDecimal creditLimitBalance) {
        this.creditLimitBalance = creditLimitBalance;
    }

    public BigDecimal getOdeysysOs() {
        return odeysysOs;
    }

    public void setOdeysysOs(BigDecimal odeysysOs) {
        this.odeysysOs = odeysysOs;
    }

    public BigDecimal getTopupReverse() {
        return topupReverse;
    }

    public void setTopupReverse(BigDecimal topupReverse) {
        this.topupReverse = topupReverse;
    }

    public String getTopupAmountLimit() {
        return topupAmountLimit;
    }

    public void setTopupAmountLimit(String topupAmountLimit) {
        this.topupAmountLimit = topupAmountLimit;
    }

    public Integer getCreditTerms() {
        return creditTerms;
    }

    public void setCreditTerms(Integer creditTerms) {
        this.creditTerms = creditTerms;
    }

    public Instant getCreditTermsDate() {
        return creditTermsDate;
    }

    public void setCreditTermsDate(Instant creditTermsDate) {
        this.creditTermsDate = creditTermsDate;
    }

    public BigDecimal getReachingPercentage() {
        return reachingPercentage;
    }

    public void setReachingPercentage(BigDecimal reachingPercentage) {
        this.reachingPercentage = reachingPercentage;
    }

    public Integer getWarningPromt() {
        return warningPromt;
    }

    public void setWarningPromt(Integer warningPromt) {
        this.warningPromt = warningPromt;
    }

    public Integer getCreditAgency() {
        return creditAgency;
    }

    public void setCreditAgency(Integer creditAgency) {
        this.creditAgency = creditAgency;
    }

    public Boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

}
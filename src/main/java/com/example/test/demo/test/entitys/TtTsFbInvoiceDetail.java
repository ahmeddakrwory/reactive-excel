package com.example.test.demo.test.entitys;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Immutable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;


@Table(name = "tt_ts_fb_invoice_detail")
public class TtTsFbInvoiceDetail {
    @Id
    private TtTsFbInvoiceDetailId id;

    @Column(   "VENDOR_TYPE")
    private Integer vendorType;

    @Column(   "FARE_TYPE")
    private String fareType;

    @Column(   "AIRLINE_CODE")
    private String airlineCode;

    @Column(   "BASE_FARE")
    private Float baseFare;

    @Column(   "FEE_N_TAXES")
    private Float feeNTaxes;

    @Column(   "FLIGHT_FARE")
    private Float flightFare;

    @Column(   "ODEYSYS_MARKUP")
    private Float odeysysMarkup;

    @Column(   "ODEYSYS_SERVICE_CHARGE")
    private Float odeysysServiceCharge;

    @Column(   "ODEYSYS_FARE")
    private Float odeysysFare;

    @Column(   "ODEYSYS_DISCOUNT")
    private Float odeysysDiscount;

    @Column(   "ODEYSYS_BSP_COMMISION")
    private Float odeysysBspCommision;

    @Column(   "ODEYSYS_BSP_COMMISSION_PER")
    private Float odeysysBspCommissionPer;

    @Column(   "ODEYSYS_BSP_COMMISION_ON")
    private Integer odeysysBspCommisionOn;

    @Column(   "ODEYSYS_AGENCY_MARKUP")
    private Float odeysysAgencyMarkup;

    @Column(   "ODEYSYS_AGENT_ONFLY_MARKUP")
    private Float odeysysAgentOnflyMarkup;

    @Column(   "AGENT_AMT_TO_RECEIVE")
    private Float agentAmtToReceive;

    @Column(   "SUPPLIER_AMT_TO_PAY")
    private Float supplierAmtToPay;

    @Column(   "ODEYSYS_STAFF_MARKDOWN")
    private Float odeysysStaffMarkdown;

    @Column(   "AGENCY_INVOICE_AMT")
    private Float agencyInvoiceAmt;

    @Column(   "UCCF_TRANSACTION_CHARGE")
    private Float uccfTransactionCharge;

    @Column(   "UCCF_TRANSACTION_ON")
    private Integer uccfTransactionOn;

    @Column(   "SEARCH_PCC_ID")
    private Integer searchPccId;

    @Column(   "TICKETING_PCC_ID")
    private Integer ticketingPccId;

    @Column(   "CURRENCY")
    private String currency;

    @Column(   "CREATION_TIME")
    private Instant creationTime;

    @Column(   "CREATED_BY")
    private Integer createdBy;

    @Column(   "LAST_UPDATED_BY")
    private Integer lastUpdatedBy;

    @Column(   "LAST_MOD_TIME")
    private Instant lastModTime;

    @Column(   "TRANSACTION_ID")
    private String transactionId;

    @Column(   "ODEYSYS_BSP_COMMISION_CHILD")
    private Float odeysysBspCommisionChild;

    @Column(   "ODEYSYS_BSP_COMMISSION_PER_CHILD")
    private Float odeysysBspCommissionPerChild;

    @Column(   "ODEYSYS_BSP_COMMISION_ON_CHILD")
    private Integer odeysysBspCommisionOnChild;

    @Column(   "SUPPLIER_APPROVAL_CODE")
    private String supplierApprovalCode;

    @Column(   "SSR_AMOUNT")
    private Float ssrAmount;

    @Column(   "INVOICE_TYPE")
    private Integer invoiceType;

    @Column(   "BRANCH_ONFLY_MARKUP")
    private Float branchOnflyMarkup;

    @Column(   "TT_BRANCH_ONFLY_MARKDOWN")
    private Integer ttBranchOnflyMarkdown;

    @Column(   "AGENCY_COMMISSION")
    private Float agencyCommission;

    @Column(   "INVOICE_NUMBER")
    private String invoiceNumber;

    @Column(   "MANUAL_MARKUP")
    private Float manualMarkup;

    public TtTsFbInvoiceDetailId getId() {
        return id;
    }

    public void setId(TtTsFbInvoiceDetailId id) {
        this.id = id;
    }

    public Integer getVendorType() {
        return vendorType;
    }

    public void setVendorType(Integer vendorType) {
        this.vendorType = vendorType;
    }

    public String getFareType() {
        return fareType;
    }

    public void setFareType(String fareType) {
        this.fareType = fareType;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public Float getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(Float baseFare) {
        this.baseFare = baseFare;
    }

    public Float getFeeNTaxes() {
        return feeNTaxes;
    }

    public void setFeeNTaxes(Float feeNTaxes) {
        this.feeNTaxes = feeNTaxes;
    }

    public Float getFlightFare() {
        return flightFare;
    }

    public void setFlightFare(Float flightFare) {
        this.flightFare = flightFare;
    }

    public Float getOdeysysMarkup() {
        return odeysysMarkup;
    }

    public void setOdeysysMarkup(Float odeysysMarkup) {
        this.odeysysMarkup = odeysysMarkup;
    }

    public Float getOdeysysServiceCharge() {
        return odeysysServiceCharge;
    }

    public void setOdeysysServiceCharge(Float odeysysServiceCharge) {
        this.odeysysServiceCharge = odeysysServiceCharge;
    }

    public Float getOdeysysFare() {
        return odeysysFare;
    }

    public void setOdeysysFare(Float odeysysFare) {
        this.odeysysFare = odeysysFare;
    }

    public Float getOdeysysDiscount() {
        return odeysysDiscount;
    }

    public void setOdeysysDiscount(Float odeysysDiscount) {
        this.odeysysDiscount = odeysysDiscount;
    }

    public Float getOdeysysBspCommision() {
        return odeysysBspCommision;
    }

    public void setOdeysysBspCommision(Float odeysysBspCommision) {
        this.odeysysBspCommision = odeysysBspCommision;
    }

    public Float getOdeysysBspCommissionPer() {
        return odeysysBspCommissionPer;
    }

    public void setOdeysysBspCommissionPer(Float odeysysBspCommissionPer) {
        this.odeysysBspCommissionPer = odeysysBspCommissionPer;
    }

    public Integer getOdeysysBspCommisionOn() {
        return odeysysBspCommisionOn;
    }

    public void setOdeysysBspCommisionOn(Integer odeysysBspCommisionOn) {
        this.odeysysBspCommisionOn = odeysysBspCommisionOn;
    }

    public Float getOdeysysAgencyMarkup() {
        return odeysysAgencyMarkup;
    }

    public void setOdeysysAgencyMarkup(Float odeysysAgencyMarkup) {
        this.odeysysAgencyMarkup = odeysysAgencyMarkup;
    }

    public Float getOdeysysAgentOnflyMarkup() {
        return odeysysAgentOnflyMarkup;
    }

    public void setOdeysysAgentOnflyMarkup(Float odeysysAgentOnflyMarkup) {
        this.odeysysAgentOnflyMarkup = odeysysAgentOnflyMarkup;
    }

    public Float getAgentAmtToReceive() {
        return agentAmtToReceive;
    }

    public void setAgentAmtToReceive(Float agentAmtToReceive) {
        this.agentAmtToReceive = agentAmtToReceive;
    }

    public Float getSupplierAmtToPay() {
        return supplierAmtToPay;
    }

    public void setSupplierAmtToPay(Float supplierAmtToPay) {
        this.supplierAmtToPay = supplierAmtToPay;
    }

    public Float getOdeysysStaffMarkdown() {
        return odeysysStaffMarkdown;
    }

    public void setOdeysysStaffMarkdown(Float odeysysStaffMarkdown) {
        this.odeysysStaffMarkdown = odeysysStaffMarkdown;
    }

    public Float getAgencyInvoiceAmt() {
        return agencyInvoiceAmt;
    }

    public void setAgencyInvoiceAmt(Float agencyInvoiceAmt) {
        this.agencyInvoiceAmt = agencyInvoiceAmt;
    }

    public Float getUccfTransactionCharge() {
        return uccfTransactionCharge;
    }

    public void setUccfTransactionCharge(Float uccfTransactionCharge) {
        this.uccfTransactionCharge = uccfTransactionCharge;
    }

    public Integer getUccfTransactionOn() {
        return uccfTransactionOn;
    }

    public void setUccfTransactionOn(Integer uccfTransactionOn) {
        this.uccfTransactionOn = uccfTransactionOn;
    }

    public Integer getSearchPccId() {
        return searchPccId;
    }

    public void setSearchPccId(Integer searchPccId) {
        this.searchPccId = searchPccId;
    }

    public Integer getTicketingPccId() {
        return ticketingPccId;
    }

    public void setTicketingPccId(Integer ticketingPccId) {
        this.ticketingPccId = ticketingPccId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Instant creationTime) {
        this.creationTime = creationTime;
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

    public Instant getLastModTime() {
        return lastModTime;
    }

    public void setLastModTime(Instant lastModTime) {
        this.lastModTime = lastModTime;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Float getOdeysysBspCommisionChild() {
        return odeysysBspCommisionChild;
    }

    public void setOdeysysBspCommisionChild(Float odeysysBspCommisionChild) {
        this.odeysysBspCommisionChild = odeysysBspCommisionChild;
    }

    public Float getOdeysysBspCommissionPerChild() {
        return odeysysBspCommissionPerChild;
    }

    public void setOdeysysBspCommissionPerChild(Float odeysysBspCommissionPerChild) {
        this.odeysysBspCommissionPerChild = odeysysBspCommissionPerChild;
    }

    public Integer getOdeysysBspCommisionOnChild() {
        return odeysysBspCommisionOnChild;
    }

    public void setOdeysysBspCommisionOnChild(Integer odeysysBspCommisionOnChild) {
        this.odeysysBspCommisionOnChild = odeysysBspCommisionOnChild;
    }

    public String getSupplierApprovalCode() {
        return supplierApprovalCode;
    }

    public void setSupplierApprovalCode(String supplierApprovalCode) {
        this.supplierApprovalCode = supplierApprovalCode;
    }

    public Float getSsrAmount() {
        return ssrAmount;
    }

    public void setSsrAmount(Float ssrAmount) {
        this.ssrAmount = ssrAmount;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Float getBranchOnflyMarkup() {
        return branchOnflyMarkup;
    }

    public void setBranchOnflyMarkup(Float branchOnflyMarkup) {
        this.branchOnflyMarkup = branchOnflyMarkup;
    }

    public Integer getTtBranchOnflyMarkdown() {
        return ttBranchOnflyMarkdown;
    }

    public void setTtBranchOnflyMarkdown(Integer ttBranchOnflyMarkdown) {
        this.ttBranchOnflyMarkdown = ttBranchOnflyMarkdown;
    }

    public Float getAgencyCommission() {
        return agencyCommission;
    }

    public void setAgencyCommission(Float agencyCommission) {
        this.agencyCommission = agencyCommission;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public Float getManualMarkup() {
        return manualMarkup;
    }

    public void setManualMarkup(Float manualMarkup) {
        this.manualMarkup = manualMarkup;
    }

}
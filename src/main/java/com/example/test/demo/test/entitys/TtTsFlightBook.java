package com.example.test.demo.test.entitys;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Immutable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.math.BigDecimal;
import java.time.Instant;

@Immutable
@Table(name = "tt_ts_flight_book")
public class TtTsFlightBook {
    @Id

    @Column( "ID")
    private Integer id;

    @Column( "FB_BOOKING_REF_NO")
    private String fbBookingRefNo;

    @Column("ORDER_ID" )
    private String orderId;

    @Column( "AGENCY_ID")
    private String agencyId;

    @Column( "BRANCH_ID")
    private String branchId;

    @Column( "ORIGIN" )
    private String origin;

    @Column( "DESTINATION" )
    private String destination;

    @Column( "NO_OF_SEGMENT")
    private Integer noOfSegment;

    @Column( "NO_OF_PASSENGER")
    private Integer noOfPassenger;

    @Column( "TRIP_TYPE")
    private Integer tripType;

    @Column("BOOKING_STATUS")
    private Integer bookingStatus;

    @Column( "BOOKING_TYPE")
    private Integer bookingType;

    @Column( "TRANSACTION_STATUS")
    private Integer transactionStatus;

    @Column( "FARE_MISMATCH")
    private Integer fareMismatch;

    @Column( "UPGRADED_BOOKING")
    private Integer upgradedBooking;

    @Column( "TOTAL_AMOUNT")
    private Float totalAmount;

    @Column( "TOTAL_FEE_N_TAXES")
    private Float totalFeeNTaxes;

    @Column( "ODEYSYS_AMOUNT")
    private Float odeysysAmount;

    @Column( "ODEYSYS_DISCOUNT")
    private Float odeysysDiscount;

    @Column( "ODEYSYS_SERVICE_CHARGE")
    private Float odeysysServiceCharge;

    @Column("BSP_COMMISSION_PER")
    private Float bspCommissionPer;

    @Column( "QUEUE_PCC")
    private String queuePcc;

    @Column( "QUEUE_REF")
    private String queueRef;

    @Column( "CREATION_TIME")
    private Instant creationTime;

    @Column( "CREATED_BY")
    private Integer createdBy;

    @Column( "LAST_UPDATED_BY")
    private Integer lastUpdatedBy;

    @Column( "LAST_MOD_TIME")
    private Instant lastModTime;

    @Column( "TRAVEL_AGENT_NAME")
    private String travelAgentName;

    @Column("AGENCY_CLIENT_NAME" )
    private String agencyClientName;

    @Column( "TOTAL_BASE_FARE")
    private Float totalBaseFare;

    @Column( "TOTAL_FLIGHT_FARE")
    private Float totalFlightFare;

    @Column( "TOTAL_ODEYSYS_MARKUP")
    private Float totalOdeysysMarkup;

    @Column( "TOTAL_ODEYSYS_FARE")
    private Float totalOdeysysFare;

    @Column( "TOTAL_ODEYSYS_SERVICE_CHARGE")
    private Float totalOdeysysServiceCharge;

    @Column( "TOTAL_ODEYSYS_DISCOUNT")
    private Float totalOdeysysDiscount;

    @Column( "TOTAL_ODEYSYS_BSP_COMMISION")
    private Float totalOdeysysBspCommision;

    @Column( "ODEYSYS_BSP_COMMISSION_PER")
    private Float odeysysBspCommissionPer;

    @Column( "ODEYSYS_BSP_COMMISION_ON")
    private Integer odeysysBspCommisionOn;

    @Column( "TOTAL_ODEYSYS_AGENCY_MARKUP")
    private Float totalOdeysysAgencyMarkup;

    @Column( "TOTAL_ODEYSYS_AGENT_ONFLY_MARKUP")
    private Float totalOdeysysAgentOnflyMarkup;

    @Column( "TOTAL_AGENT_AMT_TO_RECEIVE")
    private Float totalAgentAmtToReceive;

    @Column( "TOTAL_SUPPLIER_AMT_TO_PAY")
    private Float totalSupplierAmtToPay;

    @Column( "TOTAL_ODEYSYS_STAFF_MARKDOWN")
    private Float totalOdeysysStaffMarkdown;

    @Column( "TOTAL_AGENCY_INVOICE_AMT")
    private Float totalAgencyInvoiceAmt;

    @Column( "UCCF_TRANSACTION_CHARGE")
    private Float uccfTransactionCharge;

    @Column( "UCCF_TRANSACTION_ON")
    private Integer uccfTransactionOn;

    @Column( "CURRENCY")
    private String currency;

    @Column( "LAST_TICKETING_DATE")
    private Instant lastTicketingDate;

    @Column( "IS_MARKDOWN_CASE")
    private Integer isMarkdownCase;

    @Column( "IMPORT_PNR_CASE")
    private Integer importPnrCase;

    @Column( "SUPPLIER_PAYMENT_MODE")
    private Integer supplierPaymentMode;

    @Column( "USD_EXCHANGE_RATE")
    private Float usdExchangeRate;

    @Column( "SUPPLIER_CURRENCY"   )
    private String supplierCurrency;

    @Column( "CURR_EXCHANGE_RATE")
    private Float currExchangeRate;

    @Column("IS_MULTICARRIER")
    private Integer isMulticarrier;

    @Column( "AGENCY_TO_SUPPLIER_ROE")
    private Float agencyToSupplierRoe;

    @Column( "SYNC_PNR_MODE")
    private Integer syncPnrMode;

    @Column( "LOGIN_ID")
    private Integer loginId;

    @Column( "IS_AMENDMENT")
    private Integer isAmendment;

    @Column( "SUPPLIER_NAME")
    private String supplierName;

    @Column( "REFUND_AMOUNT")
    private Double refundAmount;

    @Column( "PENALTY_AMOUNT")
    private Double penaltyAmount;

    @Column( "AMENDMENT_PENALTY")
    private Double amendmentPenalty;

    @Column ( "EMAIL_NOTIFICATION")
    private Integer emailNotification;

    @Column( "ONLY_BAGGAGE_FARE")
    private Integer onlyBaggageFare;

    @Column( "MANUAL_IMPORT_PRICING")
    private Integer manualImportPricing;

    @Column( "TOTAL_ODEYSYS_BRANCH_ONFLY_MARKUP")
    private BigDecimal totalOdeysysBranchOnflyMarkup;

    @Column( "AUTO_TICKETING_DISABLED")
    private Integer autoTicketingDisabled;

    @Column( "IS_TWO_ONE_WAY")
    private Boolean isTwoOneWay;

    @Column( "SPLIT_PNR_CASE")
    private Integer splitPnrCase;

    @Column( "FLIGHT_DOC_URL")
    private String flightDocUrl;

    @Column( "LAST_TICKETING_DATE_ZONE")
    private Instant lastTicketingDateZone;

    @Column( "Is_synced")
    private Boolean isSynced;

    @Column( "TOTAL_SURCHARGE_AMOUNT")
    private Double totalSurchargeAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFbBookingRefNo() {
        return fbBookingRefNo;
    }

    public void setFbBookingRefNo(String fbBookingRefNo) {
        this.fbBookingRefNo = fbBookingRefNo;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getNoOfSegment() {
        return noOfSegment;
    }

    public void setNoOfSegment(Integer noOfSegment) {
        this.noOfSegment = noOfSegment;
    }

    public Integer getNoOfPassenger() {
        return noOfPassenger;
    }

    public void setNoOfPassenger(Integer noOfPassenger) {
        this.noOfPassenger = noOfPassenger;
    }

    public Integer getTripType() {
        return tripType;
    }

    public void setTripType(Integer tripType) {
        this.tripType = tripType;
    }

    public Integer getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(Integer bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Integer getBookingType() {
        return bookingType;
    }

    public void setBookingType(Integer bookingType) {
        this.bookingType = bookingType;
    }

    public Integer getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(Integer transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public Integer getFareMismatch() {
        return fareMismatch;
    }

    public void setFareMismatch(Integer fareMismatch) {
        this.fareMismatch = fareMismatch;
    }

    public Integer getUpgradedBooking() {
        return upgradedBooking;
    }

    public void setUpgradedBooking(Integer upgradedBooking) {
        this.upgradedBooking = upgradedBooking;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Float getTotalFeeNTaxes() {
        return totalFeeNTaxes;
    }

    public void setTotalFeeNTaxes(Float totalFeeNTaxes) {
        this.totalFeeNTaxes = totalFeeNTaxes;
    }

    public Float getOdeysysAmount() {
        return odeysysAmount;
    }

    public void setOdeysysAmount(Float odeysysAmount) {
        this.odeysysAmount = odeysysAmount;
    }

    public Float getOdeysysDiscount() {
        return odeysysDiscount;
    }

    public void setOdeysysDiscount(Float odeysysDiscount) {
        this.odeysysDiscount = odeysysDiscount;
    }

    public Float getOdeysysServiceCharge() {
        return odeysysServiceCharge;
    }

    public void setOdeysysServiceCharge(Float odeysysServiceCharge) {
        this.odeysysServiceCharge = odeysysServiceCharge;
    }

    public Float getBspCommissionPer() {
        return bspCommissionPer;
    }

    public void setBspCommissionPer(Float bspCommissionPer) {
        this.bspCommissionPer = bspCommissionPer;
    }

    public String getQueuePcc() {
        return queuePcc;
    }

    public void setQueuePcc(String queuePcc) {
        this.queuePcc = queuePcc;
    }

    public String getQueueRef() {
        return queueRef;
    }

    public void setQueueRef(String queueRef) {
        this.queueRef = queueRef;
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

    public String getTravelAgentName() {
        return travelAgentName;
    }

    public void setTravelAgentName(String travelAgentName) {
        this.travelAgentName = travelAgentName;
    }

    public String getAgencyClientName() {
        return agencyClientName;
    }

    public void setAgencyClientName(String agencyClientName) {
        this.agencyClientName = agencyClientName;
    }

    public Float getTotalBaseFare() {
        return totalBaseFare;
    }

    public void setTotalBaseFare(Float totalBaseFare) {
        this.totalBaseFare = totalBaseFare;
    }

    public Float getTotalFlightFare() {
        return totalFlightFare;
    }

    public void setTotalFlightFare(Float totalFlightFare) {
        this.totalFlightFare = totalFlightFare;
    }

    public Float getTotalOdeysysMarkup() {
        return totalOdeysysMarkup;
    }

    public void setTotalOdeysysMarkup(Float totalOdeysysMarkup) {
        this.totalOdeysysMarkup = totalOdeysysMarkup;
    }

    public Float getTotalOdeysysFare() {
        return totalOdeysysFare;
    }

    public void setTotalOdeysysFare(Float totalOdeysysFare) {
        this.totalOdeysysFare = totalOdeysysFare;
    }

    public Float getTotalOdeysysServiceCharge() {
        return totalOdeysysServiceCharge;
    }

    public void setTotalOdeysysServiceCharge(Float totalOdeysysServiceCharge) {
        this.totalOdeysysServiceCharge = totalOdeysysServiceCharge;
    }

    public Float getTotalOdeysysDiscount() {
        return totalOdeysysDiscount;
    }

    public void setTotalOdeysysDiscount(Float totalOdeysysDiscount) {
        this.totalOdeysysDiscount = totalOdeysysDiscount;
    }

    public Float getTotalOdeysysBspCommision() {
        return totalOdeysysBspCommision;
    }

    public void setTotalOdeysysBspCommision(Float totalOdeysysBspCommision) {
        this.totalOdeysysBspCommision = totalOdeysysBspCommision;
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

    public Float getTotalOdeysysAgencyMarkup() {
        return totalOdeysysAgencyMarkup;
    }

    public void setTotalOdeysysAgencyMarkup(Float totalOdeysysAgencyMarkup) {
        this.totalOdeysysAgencyMarkup = totalOdeysysAgencyMarkup;
    }

    public Float getTotalOdeysysAgentOnflyMarkup() {
        return totalOdeysysAgentOnflyMarkup;
    }

    public void setTotalOdeysysAgentOnflyMarkup(Float totalOdeysysAgentOnflyMarkup) {
        this.totalOdeysysAgentOnflyMarkup = totalOdeysysAgentOnflyMarkup;
    }

    public Float getTotalAgentAmtToReceive() {
        return totalAgentAmtToReceive;
    }

    public void setTotalAgentAmtToReceive(Float totalAgentAmtToReceive) {
        this.totalAgentAmtToReceive = totalAgentAmtToReceive;
    }

    public Float getTotalSupplierAmtToPay() {
        return totalSupplierAmtToPay;
    }

    public void setTotalSupplierAmtToPay(Float totalSupplierAmtToPay) {
        this.totalSupplierAmtToPay = totalSupplierAmtToPay;
    }

    public Float getTotalOdeysysStaffMarkdown() {
        return totalOdeysysStaffMarkdown;
    }

    public void setTotalOdeysysStaffMarkdown(Float totalOdeysysStaffMarkdown) {
        this.totalOdeysysStaffMarkdown = totalOdeysysStaffMarkdown;
    }

    public Float getTotalAgencyInvoiceAmt() {
        return totalAgencyInvoiceAmt;
    }

    public void setTotalAgencyInvoiceAmt(Float totalAgencyInvoiceAmt) {
        this.totalAgencyInvoiceAmt = totalAgencyInvoiceAmt;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Instant getLastTicketingDate() {
        return lastTicketingDate;
    }

    public void setLastTicketingDate(Instant lastTicketingDate) {
        this.lastTicketingDate = lastTicketingDate;
    }

    public Integer getIsMarkdownCase() {
        return isMarkdownCase;
    }

    public void setIsMarkdownCase(Integer isMarkdownCase) {
        this.isMarkdownCase = isMarkdownCase;
    }

    public Integer getImportPnrCase() {
        return importPnrCase;
    }

    public void setImportPnrCase(Integer importPnrCase) {
        this.importPnrCase = importPnrCase;
    }

    public Integer getSupplierPaymentMode() {
        return supplierPaymentMode;
    }

    public void setSupplierPaymentMode(Integer supplierPaymentMode) {
        this.supplierPaymentMode = supplierPaymentMode;
    }

    public Float getUsdExchangeRate() {
        return usdExchangeRate;
    }

    public void setUsdExchangeRate(Float usdExchangeRate) {
        this.usdExchangeRate = usdExchangeRate;
    }

    public String getSupplierCurrency() {
        return supplierCurrency;
    }

    public void setSupplierCurrency(String supplierCurrency) {
        this.supplierCurrency = supplierCurrency;
    }

    public Float getCurrExchangeRate() {
        return currExchangeRate;
    }

    public void setCurrExchangeRate(Float currExchangeRate) {
        this.currExchangeRate = currExchangeRate;
    }

    public Integer getIsMulticarrier() {
        return isMulticarrier;
    }

    public void setIsMulticarrier(Integer isMulticarrier) {
        this.isMulticarrier = isMulticarrier;
    }

    public Float getAgencyToSupplierRoe() {
        return agencyToSupplierRoe;
    }

    public void setAgencyToSupplierRoe(Float agencyToSupplierRoe) {
        this.agencyToSupplierRoe = agencyToSupplierRoe;
    }

    public Integer getSyncPnrMode() {
        return syncPnrMode;
    }

    public void setSyncPnrMode(Integer syncPnrMode) {
        this.syncPnrMode = syncPnrMode;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getIsAmendment() {
        return isAmendment;
    }

    public void setIsAmendment(Integer isAmendment) {
        this.isAmendment = isAmendment;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Double getPenaltyAmount() {
        return penaltyAmount;
    }

    public void setPenaltyAmount(Double penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }

    public Double getAmendmentPenalty() {
        return amendmentPenalty;
    }

    public void setAmendmentPenalty(Double amendmentPenalty) {
        this.amendmentPenalty = amendmentPenalty;
    }

    public Integer getEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(Integer emailNotification) {
        this.emailNotification = emailNotification;
    }

    public Integer getOnlyBaggageFare() {
        return onlyBaggageFare;
    }

    public void setOnlyBaggageFare(Integer onlyBaggageFare) {
        this.onlyBaggageFare = onlyBaggageFare;
    }

    public Integer getManualImportPricing() {
        return manualImportPricing;
    }

    public void setManualImportPricing(Integer manualImportPricing) {
        this.manualImportPricing = manualImportPricing;
    }

    public BigDecimal getTotalOdeysysBranchOnflyMarkup() {
        return totalOdeysysBranchOnflyMarkup;
    }

    public void setTotalOdeysysBranchOnflyMarkup(BigDecimal totalOdeysysBranchOnflyMarkup) {
        this.totalOdeysysBranchOnflyMarkup = totalOdeysysBranchOnflyMarkup;
    }

    public Integer getAutoTicketingDisabled() {
        return autoTicketingDisabled;
    }

    public void setAutoTicketingDisabled(Integer autoTicketingDisabled) {
        this.autoTicketingDisabled = autoTicketingDisabled;
    }

    public Boolean getIsTwoOneWay() {
        return isTwoOneWay;
    }

    public void setIsTwoOneWay(Boolean isTwoOneWay) {
        this.isTwoOneWay = isTwoOneWay;
    }

    public Integer getSplitPnrCase() {
        return splitPnrCase;
    }

    public void setSplitPnrCase(Integer splitPnrCase) {
        this.splitPnrCase = splitPnrCase;
    }

    public String getFlightDocUrl() {
        return flightDocUrl;
    }

    public void setFlightDocUrl(String flightDocUrl) {
        this.flightDocUrl = flightDocUrl;
    }

    public Instant getLastTicketingDateZone() {
        return lastTicketingDateZone;
    }

    public void setLastTicketingDateZone(Instant lastTicketingDateZone) {
        this.lastTicketingDateZone = lastTicketingDateZone;
    }

    public Boolean getIsSynced() {
        return isSynced;
    }

    public void setIsSynced(Boolean isSynced) {
        this.isSynced = isSynced;
    }

    public Double getTotalSurchargeAmount() {
        return totalSurchargeAmount;
    }

    public void setTotalSurchargeAmount(Double totalSurchargeAmount) {
        this.totalSurchargeAmount = totalSurchargeAmount;
    }

}
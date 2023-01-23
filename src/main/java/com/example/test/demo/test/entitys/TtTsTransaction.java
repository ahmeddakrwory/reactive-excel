package com.example.test.demo.test.entitys;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Immutable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.Instant;

@Immutable
@Table(name = "tt_ts_transaction")
public class TtTsTransaction {
    @Id

    @Column(               "ID")
    private Integer id;

    @Column(               "ORDER_ID")
    private String orderId;

    @Column("TRANSACTION_ID" )
    private String transactionId;

    @Column(               "PAYMENT_MODE")
    private Integer paymentMode;

    @Column(               "PAYMENT_GATEWAY_ID")
    private Integer paymentGatewayId;

    @Column(               "PRODUCT_TYPE")
    private Integer productType;

    @Column(               "STATUS")
    private Integer status;

    @Column(               "USER_ID")
    private Integer userId;

    @Column(               "BOOKING_AMOUNT")
    private Float bookingAmount;

    @Column(               "PG_SERVICE_CHARGE")
    private Float pgServiceCharge;

    @Column(               "TOTAL_AMOUNT")
    private Float totalAmount;

    @Column(               "PAYMENT_CURRENCY")
    private String paymentCurrency;

    @Column(               "CURRENT_PAYMENT_STATUS")
    private Integer currentPaymentStatus;

    @Column(               "CURRENT_REFUND_STATUS")
    private Integer currentRefundStatus;

    @Column(               "PAYMENT_RESPONSE_CODE")
    private String paymentResponseCode;


    @Column(               "PAYMENT_RESPONSE_DESC")
    private String paymentResponseDesc;

    @Column(               "RECONCILE_WITH_PG")
    private Integer reconcileWithPg;

    @Column(               "SETTELEMENT_ID" )
    private String settelementId;

    @Column(               "SETTELEMENT_DATE")
    private Instant settelementDate;

    @Column(               "SETTLEMENT_TYPE")
    private Integer settlementType;


    @Column( "TRANS_TOKEN")
    private String transToken;

    @Column("JSESSION_ID")
    private String jsessionId;

    @Column( "PAYMENT_XID")
    private String paymentXid;

    @Column(  "PAY_MOBILE_NO")
    private String payMobileNo;

    @Column(               "REQUEST_ORIGIN")
    private Integer requestOrigin;

    @Column("FOP_SUPPLIER")
    private Integer fopSupplier;

    @Column("FOP_CUSTOMER")
    private Integer fopCustomer;

    @Column( "DOC_REFERENCE_NO ")
    private String docReferenceNo;

    @Column("TRANSACTION_REMARK")
    private String transactionRemark;

    @Column(               "BOOKER_ID")
    private Integer bookerId;

    @Column(               "CREATION_TIME" )
    private Instant creationTime;

    @Column(               "LAST_MOD_TIME")
    private Instant lastModTime;

    @Column(               "CREATED_BY")
    private Integer createdBy;

    @Column(               "LAST_UPDATED_BY")
    private Integer lastUpdatedBy;

    @Column(               "SUPPLIER_CURRENCY"  )
    private String supplierCurrency;

    @Column(               "AGENCY_CURRENCY")
    private String agencyCurrency;

    @Column(               "CURRENCY_CONVERT_RATE")
    private Double currencyConvertRate;

    @Column(               "SUPPLIER_PRICE")
    private Double supplierPrice;

    @Column(               "DOCUMENT_PATH"  )
    private String documentPath;

    @Column(               "PG_PAYMENT_AMOUNT")
    private Float pgPaymentAmount;

    @Column(               "ADJUSTMENT_AMOUNT")
    private Float adjustmentAmount;

    @Column(               "MOBILE_OPERATOR"  )
    private String mobileOperator;

    @Column(               "WALLET_PAYMENT_TYPE")
    private Integer walletPaymentType;

    @Column(               "WALLET_PAYMENT_REF" )
    private String walletPaymentRef;

    @Column(               "CROSSSELLING_DISCOUNT")
    private Float crosssellingDiscount;

    @Column(               "BATCH_NUMBER")
    private Integer batchNumber;

    @Column(               "WALLET_MODE")
    private Integer walletMode;

    @Column(               "FOP_SUPPLIER2")
    private Integer fopSupplier2;

    @Column(               "CUSTOMER_AMOUNT")
    private Float customerAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(Integer paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Integer getPaymentGatewayId() {
        return paymentGatewayId;
    }

    public void setPaymentGatewayId(Integer paymentGatewayId) {
        this.paymentGatewayId = paymentGatewayId;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Float getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(Float bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public Float getPgServiceCharge() {
        return pgServiceCharge;
    }

    public void setPgServiceCharge(Float pgServiceCharge) {
        this.pgServiceCharge = pgServiceCharge;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPaymentCurrency() {
        return paymentCurrency;
    }

    public void setPaymentCurrency(String paymentCurrency) {
        this.paymentCurrency = paymentCurrency;
    }

    public Integer getCurrentPaymentStatus() {
        return currentPaymentStatus;
    }

    public void setCurrentPaymentStatus(Integer currentPaymentStatus) {
        this.currentPaymentStatus = currentPaymentStatus;
    }

    public Integer getCurrentRefundStatus() {
        return currentRefundStatus;
    }

    public void setCurrentRefundStatus(Integer currentRefundStatus) {
        this.currentRefundStatus = currentRefundStatus;
    }

    public String getPaymentResponseCode() {
        return paymentResponseCode;
    }

    public void setPaymentResponseCode(String paymentResponseCode) {
        this.paymentResponseCode = paymentResponseCode;
    }

    public String getPaymentResponseDesc() {
        return paymentResponseDesc;
    }

    public void setPaymentResponseDesc(String paymentResponseDesc) {
        this.paymentResponseDesc = paymentResponseDesc;
    }

    public Integer getReconcileWithPg() {
        return reconcileWithPg;
    }

    public void setReconcileWithPg(Integer reconcileWithPg) {
        this.reconcileWithPg = reconcileWithPg;
    }

    public String getSettelementId() {
        return settelementId;
    }

    public void setSettelementId(String settelementId) {
        this.settelementId = settelementId;
    }

    public Instant getSettelementDate() {
        return settelementDate;
    }

    public void setSettelementDate(Instant settelementDate) {
        this.settelementDate = settelementDate;
    }

    public Integer getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(Integer settlementType) {
        this.settlementType = settlementType;
    }

    public String getTransToken() {
        return transToken;
    }

    public void setTransToken(String transToken) {
        this.transToken = transToken;
    }

    public String getJsessionId() {
        return jsessionId;
    }

    public void setJsessionId(String jsessionId) {
        this.jsessionId = jsessionId;
    }

    public String getPaymentXid() {
        return paymentXid;
    }

    public void setPaymentXid(String paymentXid) {
        this.paymentXid = paymentXid;
    }

    public String getPayMobileNo() {
        return payMobileNo;
    }

    public void setPayMobileNo(String payMobileNo) {
        this.payMobileNo = payMobileNo;
    }

    public Integer getRequestOrigin() {
        return requestOrigin;
    }

    public void setRequestOrigin(Integer requestOrigin) {
        this.requestOrigin = requestOrigin;
    }

    public Integer getFopSupplier() {
        return fopSupplier;
    }

    public void setFopSupplier(Integer fopSupplier) {
        this.fopSupplier = fopSupplier;
    }

    public Integer getFopCustomer() {
        return fopCustomer;
    }

    public void setFopCustomer(Integer fopCustomer) {
        this.fopCustomer = fopCustomer;
    }

    public String getDocReferenceNo() {
        return docReferenceNo;
    }

    public void setDocReferenceNo(String docReferenceNo) {
        this.docReferenceNo = docReferenceNo;
    }

    public String getTransactionRemark() {
        return transactionRemark;
    }

    public void setTransactionRemark(String transactionRemark) {
        this.transactionRemark = transactionRemark;
    }

    public Integer getBookerId() {
        return bookerId;
    }

    public void setBookerId(Integer bookerId) {
        this.bookerId = bookerId;
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

    public String getSupplierCurrency() {
        return supplierCurrency;
    }

    public void setSupplierCurrency(String supplierCurrency) {
        this.supplierCurrency = supplierCurrency;
    }

    public String getAgencyCurrency() {
        return agencyCurrency;
    }

    public void setAgencyCurrency(String agencyCurrency) {
        this.agencyCurrency = agencyCurrency;
    }

    public Double getCurrencyConvertRate() {
        return currencyConvertRate;
    }

    public void setCurrencyConvertRate(Double currencyConvertRate) {
        this.currencyConvertRate = currencyConvertRate;
    }

    public Double getSupplierPrice() {
        return supplierPrice;
    }

    public void setSupplierPrice(Double supplierPrice) {
        this.supplierPrice = supplierPrice;
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    public Float getPgPaymentAmount() {
        return pgPaymentAmount;
    }

    public void setPgPaymentAmount(Float pgPaymentAmount) {
        this.pgPaymentAmount = pgPaymentAmount;
    }

    public Float getAdjustmentAmount() {
        return adjustmentAmount;
    }

    public void setAdjustmentAmount(Float adjustmentAmount) {
        this.adjustmentAmount = adjustmentAmount;
    }

    public String getMobileOperator() {
        return mobileOperator;
    }

    public void setMobileOperator(String mobileOperator) {
        this.mobileOperator = mobileOperator;
    }

    public Integer getWalletPaymentType() {
        return walletPaymentType;
    }

    public void setWalletPaymentType(Integer walletPaymentType) {
        this.walletPaymentType = walletPaymentType;
    }

    public String getWalletPaymentRef() {
        return walletPaymentRef;
    }

    public void setWalletPaymentRef(String walletPaymentRef) {
        this.walletPaymentRef = walletPaymentRef;
    }

    public Float getCrosssellingDiscount() {
        return crosssellingDiscount;
    }

    public void setCrosssellingDiscount(Float crosssellingDiscount) {
        this.crosssellingDiscount = crosssellingDiscount;
    }

    public Integer getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(Integer batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Integer getWalletMode() {
        return walletMode;
    }

    public void setWalletMode(Integer walletMode) {
        this.walletMode = walletMode;
    }

    public Integer getFopSupplier2() {
        return fopSupplier2;
    }

    public void setFopSupplier2(Integer fopSupplier2) {
        this.fopSupplier2 = fopSupplier2;
    }

    public Float getCustomerAmount() {
        return customerAmount;
    }

    public void setCustomerAmount(Float customerAmount) {
        this.customerAmount = customerAmount;
    }

}
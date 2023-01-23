package com.example.test.demo.test.entitys;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Immutable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
@Immutable
@Table(name = "tt_ts_agent_order")
public class TtTsAgentOrder {
    @Id

    @Column( "ID")
    private Integer id;

    @Column( "ORDER_ID")
    private String orderId;

    @Column("AGENCY_ID")
    private String agencyId;

    @Column( "BRANCH_ID")
    private String branchId;

    @Column( "ORDER_TYPE")
    private Integer orderType;

    @Column( "ORDER_STATUS")
    private Integer orderStatus;

    @Column( "ORDER_TOTAL")
    private Float orderTotal;

    @Column( "ORDER_CURRENCY")
    private String orderCurrency;

    @Column( "CREATION_TIME")
    private Instant creationTime;

    @Column( "CREATED_BY")
    private Integer createdBy;

    @Column( "LAST_UPDATED_BY")
    private Integer lastUpdatedBy;

    @Column( "LAST_MOD_TIME")
    private Instant lastModTime;

    @Column( "AGENT_BOOKING_STATUS")
    private Integer agentBookingStatus;

    @Column( "PLACED_IN_QUEUE")
    private Integer placedInQueue;

    @Column( "ODEYSYS_BOOKING_STATUS")
    private Integer odeysysBookingStatus;

    @Column( "LOCKED_STATUS")
    private Integer lockedStatus;

    @Column( "LAST_LOCK_ACQUIRED_BY")
    private Integer lastLockAcquiredBy;

    @Column( "PAYMENT_DUE_DATE")
    private Instant paymentDueDate;

    @Column( "LAST_LOCK_ACQUIRED_DATE")
    private Instant lastLockAcquiredDate;

    @Column( "POS_OBJECT_ID")
    private String posObjectId;

    @Column( "TRANSACTION_ID")
    private String transactionId;

    @Column( "AGENT_OR_MANAGER_ID")
    private Integer agentOrManagerId;

    @Column( "LAST_TICKETING_DATE")
    private Instant lastTicketingDate;

    @Column("EMAIL_NOTIFICATION_STATUS")
    private Byte emailNotificationStatus;

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

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public String getOrderCurrency() {
        return orderCurrency;
    }

    public void setOrderCurrency(String orderCurrency) {
        this.orderCurrency = orderCurrency;
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

    public Integer getAgentBookingStatus() {
        return agentBookingStatus;
    }

    public void setAgentBookingStatus(Integer agentBookingStatus) {
        this.agentBookingStatus = agentBookingStatus;
    }

    public Integer getPlacedInQueue() {
        return placedInQueue;
    }

    public void setPlacedInQueue(Integer placedInQueue) {
        this.placedInQueue = placedInQueue;
    }

    public Integer getOdeysysBookingStatus() {
        return odeysysBookingStatus;
    }

    public void setOdeysysBookingStatus(Integer odeysysBookingStatus) {
        this.odeysysBookingStatus = odeysysBookingStatus;
    }

    public Integer getLockedStatus() {
        return lockedStatus;
    }

    public void setLockedStatus(Integer lockedStatus) {
        this.lockedStatus = lockedStatus;
    }

    public Integer getLastLockAcquiredBy() {
        return lastLockAcquiredBy;
    }

    public void setLastLockAcquiredBy(Integer lastLockAcquiredBy) {
        this.lastLockAcquiredBy = lastLockAcquiredBy;
    }

    public Instant getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(Instant paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public Instant getLastLockAcquiredDate() {
        return lastLockAcquiredDate;
    }

    public void setLastLockAcquiredDate(Instant lastLockAcquiredDate) {
        this.lastLockAcquiredDate = lastLockAcquiredDate;
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

    public Integer getAgentOrManagerId() {
        return agentOrManagerId;
    }

    public void setAgentOrManagerId(Integer agentOrManagerId) {
        this.agentOrManagerId = agentOrManagerId;
    }

    public Instant getLastTicketingDate() {
        return lastTicketingDate;
    }

    public void setLastTicketingDate(Instant lastTicketingDate) {
        this.lastTicketingDate = lastTicketingDate;
    }

    public Byte getEmailNotificationStatus() {
        return emailNotificationStatus;
    }

    public void setEmailNotificationStatus(Byte emailNotificationStatus) {
        this.emailNotificationStatus = emailNotificationStatus;
    }

}
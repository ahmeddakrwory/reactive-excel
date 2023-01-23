package com.example.test.demo.test.entitys;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Immutable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.Instant;


@Table(name = "cancellation_details")
public class CancellationDetail {
    @Id
    private CancellationDetailId id;

    @Column(   "REFUND_STATUS")
    private Integer refundStatus;

    @Column(   "REFUND_AMOUNT")
    private BigDecimal refundAmount;

    @Column(   "CANCELLATION_CHARGES")
    private BigDecimal cancellationCharges;

    @Column(   "TOTAL_REFUND_AMOUNT")
    private BigDecimal totalRefundAmount;

    @Column(   "CREDIT_NOTE_NO")
    private String creditNoteNo;

    @Column(   "CREATED_BY")
    private Integer createdBy;

    @Column(   "CREATION_TIME")
    private Instant creationTime;

    @Column(   "LAST_MOD_TIME")
    private Instant lastModTime;

    @Column(   "UPDATED_BY")
    private Integer updatedBy;

    @Column(   "PASSENGER_TYPE")
    private Integer passengerType;

    public CancellationDetailId getId() {
        return id;
    }

    public void setId(CancellationDetailId id) {
        this.id = id;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public BigDecimal getCancellationCharges() {
        return cancellationCharges;
    }

    public void setCancellationCharges(BigDecimal cancellationCharges) {
        this.cancellationCharges = cancellationCharges;
    }

    public BigDecimal getTotalRefundAmount() {
        return totalRefundAmount;
    }

    public void setTotalRefundAmount(BigDecimal totalRefundAmount) {
        this.totalRefundAmount = totalRefundAmount;
    }

    public String getCreditNoteNo() {
        return creditNoteNo;
    }

    public void setCreditNoteNo(String creditNoteNo) {
        this.creditNoteNo = creditNoteNo;
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

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(Integer passengerType) {
        this.passengerType = passengerType;
    }

}
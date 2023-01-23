package com.example.test.demo.test.entitys;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CancellationDetailId implements Serializable {
    private static final long serialVersionUID = 4591988106210961645L;
    @Column(name = "SEQ_NO", nullable = false)
    private Integer seqNo;

    @Column(name = "REFUND_ID", nullable = false, length = 45)
    private String refundId;

    @Column(name = "PASSENGER_NO", nullable = false)
    private Integer passengerNo;

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public Integer getPassengerNo() {
        return passengerNo;
    }

    public void setPassengerNo(Integer passengerNo) {
        this.passengerNo = passengerNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CancellationDetailId entity = (CancellationDetailId) o;
        return Objects.equals(this.seqNo, entity.seqNo) &&
                Objects.equals(this.passengerNo, entity.passengerNo) &&
                Objects.equals(this.refundId, entity.refundId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqNo, passengerNo, refundId);
    }

}
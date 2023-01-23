package com.example.test.demo.test.entitys;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TtTsFbInvoiceDetailId implements Serializable {
    private static final long serialVersionUID = 7572800746797902002L;
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "FB_BOOKING_REF_NO", nullable = false, length = 50)
    private String fbBookingRefNo;

    @Column(name = "VENDOR_SEQ", nullable = false)
    private Integer vendorSeq;

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

    public Integer getVendorSeq() {
        return vendorSeq;
    }

    public void setVendorSeq(Integer vendorSeq) {
        this.vendorSeq = vendorSeq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TtTsFbInvoiceDetailId entity = (TtTsFbInvoiceDetailId) o;
        return Objects.equals(this.vendorSeq, entity.vendorSeq) &&
                Objects.equals(this.fbBookingRefNo, entity.fbBookingRefNo) &&
                Objects.equals(this.id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendorSeq, fbBookingRefNo, id);
    }

}
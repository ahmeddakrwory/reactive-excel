package com.example.test.demo.test.entitys;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TtTsFbSegmentDetailId implements Serializable {
    private static final long serialVersionUID = -7149311329736704197L;
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "SEGMENT_NO", nullable = false)
    private Integer segmentNo;

    @Column(name = "FB_BOOKING_REF_NO", nullable = false, length = 50)
    private String fbBookingRefNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSegmentNo() {
        return segmentNo;
    }

    public void setSegmentNo(Integer segmentNo) {
        this.segmentNo = segmentNo;
    }

    public String getFbBookingRefNo() {
        return fbBookingRefNo;
    }

    public void setFbBookingRefNo(String fbBookingRefNo) {
        this.fbBookingRefNo = fbBookingRefNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TtTsFbSegmentDetailId entity = (TtTsFbSegmentDetailId) o;
        return Objects.equals(this.fbBookingRefNo, entity.fbBookingRefNo) &&
                Objects.equals(this.id, entity.id) &&
                Objects.equals(this.segmentNo, entity.segmentNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fbBookingRefNo, id, segmentNo);
    }

}
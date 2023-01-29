package com.example.test.demo.test.entitys;

import org.hibernate.annotations.Immutable;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;

import java.time.Instant;

/**
 * Mapping for DB view
 */

@Immutable
@Table(name = "vv_user_locked_itr")
public class VvUserLockedItr {
    @Column(name = "orderid", nullable = false, length = 50)
    private String orderid;

    @Column(name = "userid", nullable = false)
    private Integer userid;

    @Column(name = "bookingRef", nullable = false, length = 50)
    private String bookingRef;

    @Column(name = "username", nullable = false, length = 100)
    private String username;

    @Column(name = "contetnid", nullable = false)
    private Integer contetnid;

    @Column(name = "status")
    private Integer status;

    @Column(name = "lockeddate")
    private Instant lockeddate;

    @Column(name = "userrole")
    private Integer userrole;

    public String getOrderid() {
        return orderid;
    }

    public Integer getUserid() {
        return userid;
    }

    public String getBookingRef() {
        return bookingRef;
    }

    public String getUsername() {
        return username;
    }

    public Integer getContetnid() {
        return contetnid;
    }

    public Integer getStatus() {
        return status;
    }

    public Instant getLockeddate() {
        return lockeddate;
    }

    public Integer getUserrole() {
        return userrole;
    }

    protected VvUserLockedItr() {
    }
}
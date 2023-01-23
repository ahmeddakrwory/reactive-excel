package com.example.test.demo.test.entitys;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TtTsAgentOrderCustomerId implements Serializable {
    private static final long serialVersionUID = -7787719121434036155L;
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "CUSTOMER_SEQ", nullable = false)
    private Integer customerSeq;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerSeq() {
        return customerSeq;
    }

    public void setCustomerSeq(Integer customerSeq) {
        this.customerSeq = customerSeq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TtTsAgentOrderCustomerId entity = (TtTsAgentOrderCustomerId) o;
        return Objects.equals(this.customerSeq, entity.customerSeq) &&
                Objects.equals(this.id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerSeq, id);
    }

}
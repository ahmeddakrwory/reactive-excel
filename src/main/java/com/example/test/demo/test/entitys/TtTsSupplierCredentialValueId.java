package com.example.test.demo.test.entitys;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TtTsSupplierCredentialValueId implements Serializable {
    private static final long serialVersionUID = 4801288149281146590L;
    @Column(name = "CREDENTIAL_ID", nullable = false)
    private Integer credentialId;

    @Column(name = "SEQUENCE", nullable = false)
    private Integer sequence;

    public Integer getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(Integer credentialId) {
        this.credentialId = credentialId;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TtTsSupplierCredentialValueId entity = (TtTsSupplierCredentialValueId) o;
        return Objects.equals(this.sequence, entity.sequence) &&
                Objects.equals(this.credentialId, entity.credentialId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sequence, credentialId);
    }

}
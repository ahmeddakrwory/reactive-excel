package com.example.test.demo.test.entitys;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Immutable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
@Immutable

@Table(name = "tt_ts_supplier_credential_values")
public class TtTsSupplierCredentialValue {
    @Id
    private TtTsSupplierCredentialValueId id;

    @Column(    "CREDENTIAL_FIELD_ID")
    private Integer credentialFieldId;


    @Column(    "VALUE")
    private String value;

    public TtTsSupplierCredentialValueId getId() {
        return id;
    }

    public void setId(TtTsSupplierCredentialValueId id) {
        this.id = id;
    }

    public Integer getCredentialFieldId() {
        return credentialFieldId;
    }

    public void setCredentialFieldId(Integer credentialFieldId) {
        this.credentialFieldId = credentialFieldId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
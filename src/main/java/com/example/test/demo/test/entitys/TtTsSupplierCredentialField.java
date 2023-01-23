package com.example.test.demo.test.entitys;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Immutable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
@Immutable

@Table(name = "tt_ts_supplier_credential_fields")
public class TtTsSupplierCredentialField {
    @Id

    @Column( "CREDENTIAL_FIELD_ID" )
    private Integer id;

    @Column(   "SUPPLIER_ID")
    private Integer supplierId;

    @Column(   "PRODUCT_ID")
    private Integer productId;

    @Column(   "CREDENTIAL_FIELD_NAME")
    private String credentialFieldName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getCredentialFieldName() {
        return credentialFieldName;
    }

    public void setCredentialFieldName(String credentialFieldName) {
        this.credentialFieldName = credentialFieldName;
    }

}
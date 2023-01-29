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
@Table(name = "rv_pnrimport_history")
public class RvPnrimportHistory {
    @Column(name = "AGENTNAME", length = 100)
    private String agentname;

    @Column(name = "ORGNAME", length = 100)
    private String orgname;

    @Column(name = "SUPPLIERNAME", length = 50)
    private String suppliername;

    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "SP_PNR", nullable = false, length = 50)
    private String spPnr;

    @Column(name = "AGENCY_ID", nullable = false, length = 20)
    private String agencyId;

    @Column(name = "AGENT_ID")
    private Integer agentId;

    @Column(name = "IMPORT_DATE_TIME", nullable = false)
    private Instant importDateTime;

    @Column(name = "PCC_ID")
    private Integer pccId;

    @Column(name = "PNR_CREATED_BY_OFFICE_ID", length = 50)
    private String pnrCreatedByOfficeId;

    public String getAgentname() {
        return agentname;
    }

    public String getOrgname() {
        return orgname;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public Integer getId() {
        return id;
    }

    public String getSpPnr() {
        return spPnr;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public Instant getImportDateTime() {
        return importDateTime;
    }

    public Integer getPccId() {
        return pccId;
    }

    public String getPnrCreatedByOfficeId() {
        return pnrCreatedByOfficeId;
    }

    protected RvPnrimportHistory() {
    }
}
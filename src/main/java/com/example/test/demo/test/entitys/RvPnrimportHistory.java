package com.example.test.demo.test.entitys;

import org.hibernate.annotations.Immutable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;



import java.time.Instant;

/**
 * Mapping for DB view
 */

@Immutable
@Table(name = "rv_pnrimport_history")
public class RvPnrimportHistory {
    @Column( "AGENTNAME")
    private String agentname;

    @Column( "ORGNAME")
    private String orgname;

    @Column( "SUPPLIERNAME")
    private String suppliername;

    @Column( "ID")
    private Integer id;

    @Column( "SP_PNR")
    private String spPnr;

    @Column( "AGENCY_ID")
    private String agencyId;

    @Column( "AGENT_ID")
    private Integer agentId;

    @Column( "IMPORT_DATE_TIM")
    private Instant importDateTime;

    @Column( "PCC_ID")
    private Integer pccId;

    @Column( "PNR_CREATED_BY_OFFICE_ID")
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
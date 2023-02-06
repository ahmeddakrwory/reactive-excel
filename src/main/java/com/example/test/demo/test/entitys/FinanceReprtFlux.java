package com.example.test.demo.test.entitys;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.util.Date;

@Table
@NamedStoredProcedureQuery(name = "FinanceReport",procedureName = "SP_FINANCIAL_REPORT_OPTIMIZED",parameters = {
        @StoredProcedureParameter(mode= ParameterMode.IN,name = "END_DATE",type = Date.class),
        @StoredProcedureParameter(mode= ParameterMode.IN,name = "START_DATE",type = Date.class),  @StoredProcedureParameter(mode= ParameterMode.IN,name = "ORG_ID",type = String.class)

}
)

public class FinanceReprtFlux {
    @Column("REF")
    private  String ref;
    @Column("CNAME")
    private  String cname;
    @Column("CTITLE")
    private  Integer ctitle;
    @Column("CCITY")
    private String Ccity;
    @Column("CCOUNTRY")
    private  String ccountry;
    @Column("CMOBILE")
    private String combile;
    @Column("CEMAIL")
    private  String cemail;
    @Column("TICKET_NO")
    private String tInfo;
    @Column("AIRLINE_PNR")
    private  String  airlinePnr;
    @Column("SP_PNR")
    private  String spnr;
    @Column("TRIP_TYPE")
    private  Integer tripType;
    @Column("ORIGIN")
    private String orgin;
    @Column("DESTINATION")
    private  String destination;
    @Column("NO_OF_SEGMENT")
    private  Integer nofSegment;
    @Column("BOOKING_CLASS")
    private String  bookingClass;
    @Column("CABIN_CLASS")
    private Integer cabinclass;
    @Column("SUPPLIER_NAME")
    private String suppliername;
    @Column("TOTAL_BASE_FARE")
    private Double tottaleBaseFare;
    @Column("TOTAL_FEE_N_TAXES")
    private Double tottalFeeTex;
    @Column("TOTAL_ODEYSYS_MARKUP")
    private Double  tootallOdsysMarkrup;
    @Column("TOTAL_ODEYSYS_SERVICE_CHARGE")
    private  Double totallOdesysServiceCharge;
    @Column ("TOTAL_ODEYSYS_DISCOUNT")
    private  Double totalOdsysDiscount;
    @Column("ODEYSYS_BSP_COMMISION")
    private  Double odsysBspCommaision;
    //__________________________//*----------------------contenue




}

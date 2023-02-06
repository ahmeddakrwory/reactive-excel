package com.example.test.demo.test.entitys;

import org.hibernate.annotations.Immutable;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Mapping for DB view
 */

@Immutable
@Table(name = "rv_financialreport")
public class RvFinancialreport {
    @Column(name = "REF", nullable = false, length = 50)
    private String ref;

    @Column(name = "CNAME", length = 161)
    private String cname;

    @Column(name = "CTITLE")
    private Integer ctitle;

    @Column(name = "CCITY", length = 100)
    private String ccity;

    @Column(name = "CCOUNTRY", length = 80)
    private String ccountry;

    @Column(name = "CMOBILE", length = 50)
    private String cmobile;

    @Column(name = "CEMAIL", length = 80)
    private String cemail;

    @Column(name = "TICKET_NO", length = 50)
    private String ticketNo;

    @Column(name = "AIRLINE_PNR", length = 50)
    private String airlinePnr;

    @Column(name = "SP_PNR", length = 50)
    private String spPnr;

    @Column(name = "TRIP_TYPE")
    private Integer tripType;

    @Column(name = "ORIGIN", nullable = false, length = 50)
    private String origin;

    @Column(name = "DESTINATION", nullable = false, length = 50)
    private String destination;

    @Column(name = "NO_OF_SEGMENT")
    private Integer noOfSegment;

    @Column(name = "BOOKING_CLASS", nullable = false, length = 20)
    private String bookingClass;

    @Column(name = "CABIN_CLASS")
    private Integer cabinClass;

    @Column(name = "SUPPLIER_NAME", length = 100)
    private String supplierName;

    @Column(name = "TOTAL_BASE_FARE")
    private Float totalBaseFare;

    @Column(name = "TOTAL_FEE_N_TAXES")
    private Float totalFeeNTaxes;

    @Column(name = "TOTAL_ODEYSYS_MARKUP")
    private Float totalOdeysysMarkup;

    @Column(name = "TOTAL_ODEYSYS_SERVICE_CHARGE")
    private Float totalOdeysysServiceCharge;

    @Column(name = "TOTAL_ODEYSYS_DISCOUNT")
    private Float totalOdeysysDiscount;

    @Column(name = "ODEYSYS_BSP_COMMISION")
    private Float odeysysBspCommision;

    @Column(name = "ODEYSYS_BSP_COMMISSION_PER")
    private Float odeysysBspCommissionPer;

    @Column(name = "TOTAL_ODEYSYS_AGENCY_MARKUP")
    private Float totalOdeysysAgencyMarkup;

    @Column(name = "TOTAL_ODEYSYS_AGENT_ONFLY_MARKUP")
    private Float totalOdeysysAgentOnflyMarkup;

    @Column(name = "TOTAL_ODEYSYS_FARE")
    private Float totalOdeysysFare;

    @Column(name = "PAYMENT_MODE")
    private Integer paymentMode;

    @Column(name = "PTIME", nullable = false)
    private Instant ptime;

    @Column(name = "AGENCY_ID", nullable = false, length = 50)
    private String agencyId;

    @Column(name = "BRANCH_ID", nullable = false, length = 50)
    private String branchId;

    @Column(name = "CDATE", nullable = false)
    private Instant cdate;

    @Column(name = "PTYPE", nullable = false)
    private Integer ptype;

    @Column(name = "CTYPE")
    private Integer ctype;

    @Column(name = "SDATE", nullable = false)
    private Instant sdate;

    @Column(name = "TCUST")
    private Integer tcust;

    @Column(name = "UNAME", length = 100)
    private String uname;

    @Column(name = "BSTATUS", nullable = false)
    private String bstatus;

    @Column(name = "OID", nullable = false, length = 50)
    private String oid;

    @Column(name = "INVOICE_NUMBER", length = 20)
    private String invoiceNumber;

    @Column(name = "DOB", length = 20)
    private String dob;

    @Column(name = "REFUNDAMOUNT", precision = 10, scale = 3)
    private BigDecimal refundamount;

    @Column(name = "REFUNDCANCELATIONAMOUNT", precision = 10, scale = 3)
    private BigDecimal refundcancelationamount;

    @Column(name = "AGENCYNAME", length = 100)
    private String agencyname;

    @Column(name = "TOTAL_ODEYSYS_BRANCH_ONFLY_MARKUP", precision = 10, scale = 3)
    private BigDecimal totalOdeysysBranchOnflyMarkup;

    @Column(name = "BOOKING_TYPE")
    private Integer bookingType;

    @Column(name = "IMPORT_PNR_CASE")
    private Integer importPnrCase;

    @Column(name = "ODEYSYS_BSP_COMMISSION_PER_CHILD")
    private Float odeysysBspCommissionPerChild;

    @Column(name = "ODEYSYS_BSP_COMMISION_CHILD")
    private Float odeysysBspCommisionChild;

    @Column(name = "PAX_BASE_FARE")
    private Float paxBaseFare;

    @Column(name = "PAX_FEE_N_TAXES")
    private Float paxFeeNTaxes;

    @Column(name = "PAX_ODEYSYS_MARKUP")
    private Float paxOdeysysMarkup;

    @Column(name = "PAX_ODEYSYS_SERVICE_CHARGE")
    private Float paxOdeysysServiceCharge;

    @Column(name = "PAX_ODEYSYS_DISCOUNT")
    private Float paxOdeysysDiscount;

    @Column(name = "TCPAX", nullable = false)
    private Long tcpax;

    @Column(name = "IATANUMBER", length = 100)
    private String iatanumber;

    @Column(name = "BRANCHNAME", length = 100)
    private String branchname;

    @Column(name = "REFUNDSTATUS")
    private Integer refundstatus;

    @Column(name = "AGENTORDERSTATUS")
    private Integer agentorderstatus;

    @Column(name = "SSRAMOUNT")
    private Double ssramount;

    @Column(name = "REFUNDDATE")
    private Instant refunddate;

    @Column(name = "MANUAL_MARKUP")
    private Float manualMarkup;

    @Lob
    @Column(name = "PCCIATANUMBER")
    private String pcciatanumber;

    @Column(name = "NDCSTAFFNAME", nullable = false, length = 100)
    private String ndcstaffname;

    @Column(name = "TOTAL_SURCHARGE_AMOUNT", nullable = false)
    private Double totalSurchargeAmount;

    @Column(name = "STATE_NAME", length = 125)
    private String stateName;

    @Column(name = "CITY_NAME", length = 125)
    private String cityName;

    @Column(name = "ORGANIZATION_ID", nullable = false, length = 50)
    private String organizationId;

    public String getRef() {
        return ref;
    }

    public String getCname() {
        return cname;
    }

    public Integer getCtitle() {
        return ctitle;
    }

    public String getCcity() {
        return ccity;
    }

    public String getCcountry() {
        return ccountry;
    }

    public String getCmobile() {
        return cmobile;
    }

    public String getCemail() {
        return cemail;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public String getAirlinePnr() {
        return airlinePnr;
    }

    public String getSpPnr() {
        return spPnr;
    }

    public Integer getTripType() {
        return tripType;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Integer getNoOfSegment() {
        return noOfSegment;
    }

    public String getBookingClass() {
        return bookingClass;
    }

    public Integer getCabinClass() {
        return cabinClass;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public Float getTotalBaseFare() {
        return totalBaseFare;
    }

    public Float getTotalFeeNTaxes() {
        return totalFeeNTaxes;
    }

    public Float getTotalOdeysysMarkup() {
        return totalOdeysysMarkup;
    }

    public Float getTotalOdeysysServiceCharge() {
        return totalOdeysysServiceCharge;
    }

    public Float getTotalOdeysysDiscount() {
        return totalOdeysysDiscount;
    }

    public Float getOdeysysBspCommision() {
        return odeysysBspCommision;
    }

    public Float getOdeysysBspCommissionPer() {
        return odeysysBspCommissionPer;
    }

    public Float getTotalOdeysysAgencyMarkup() {
        return totalOdeysysAgencyMarkup;
    }

    public Float getTotalOdeysysAgentOnflyMarkup() {
        return totalOdeysysAgentOnflyMarkup;
    }

    public Float getTotalOdeysysFare() {
        return totalOdeysysFare;
    }

    public Integer getPaymentMode() {
        return paymentMode;
    }

    public Instant getPtime() {
        return ptime;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public String getBranchId() {
        return branchId;
    }

    public Instant getCdate() {
        return cdate;
    }

    public Integer getPtype() {
        return ptype;
    }

    public Integer getCtype() {
        return ctype;
    }

    public Instant getSdate() {
        return sdate;
    }

    public Integer getTcust() {
        return tcust;
    }

    public String getUname() {
        return uname;
    }

    public String getBstatus() {
        return bstatus;
    }

    public String getOid() {
        return oid;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getDob() {
        return dob;
    }

    public BigDecimal getRefundamount() {
        return refundamount;
    }

    public BigDecimal getRefundcancelationamount() {
        return refundcancelationamount;
    }

    public String getAgencyname() {
        return agencyname;
    }

    public BigDecimal getTotalOdeysysBranchOnflyMarkup() {
        return totalOdeysysBranchOnflyMarkup;
    }

    public Integer getBookingType() {
        return bookingType;
    }

    public Integer getImportPnrCase() {
        return importPnrCase;
    }

    public Float getOdeysysBspCommissionPerChild() {
        return odeysysBspCommissionPerChild;
    }

    public Float getOdeysysBspCommisionChild() {
        return odeysysBspCommisionChild;
    }

    public Float getPaxBaseFare() {
        return paxBaseFare;
    }

    public Float getPaxFeeNTaxes() {
        return paxFeeNTaxes;
    }

    public Float getPaxOdeysysMarkup() {
        return paxOdeysysMarkup;
    }

    public Float getPaxOdeysysServiceCharge() {
        return paxOdeysysServiceCharge;
    }

    public Float getPaxOdeysysDiscount() {
        return paxOdeysysDiscount;
    }

    public Long getTcpax() {
        return tcpax;
    }

    public String getIatanumber() {
        return iatanumber;
    }

    public String getBranchname() {
        return branchname;
    }

    public Integer getRefundstatus() {
        return refundstatus;
    }

    public Integer getAgentorderstatus() {
        return agentorderstatus;
    }

    public Double getSsramount() {
        return ssramount;
    }

    public Instant getRefunddate() {
        return refunddate;
    }

    public Float getManualMarkup() {
        return manualMarkup;
    }

    public String getPcciatanumber() {
        return pcciatanumber;
    }

    public String getNdcstaffname() {
        return ndcstaffname;
    }

    public Double getTotalSurchargeAmount() {
        return totalSurchargeAmount;
    }

    public String getStateName() {
        return stateName;
    }

    public String getCityName() {
        return cityName;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    protected RvFinancialreport() {
    }
}
package com.example.test.demo.test.entitys;



import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;



import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Mapping for DB view
 */

@Table( "rv_financialreport")
public class RvFinancialreport {

    @Id
    @Column( "ref")
    private String ref;

    @Column( "TRIP_TYPE")
    private Integer tripType;

    @Column( "ORIGIN")
    private String origin;

    @Column( "DESTINATION")
    private String destination;

    @Column( "NO_OF_SEGMENT")
    private Integer noOfSegment;

    @Column( "SUPPLIER_NAME")
    private String supplierName;

    @Column( "TOTAL_BASE_FARE")
    private Float totalBaseFare;

    @Column( "TOTAL_FEE_N_TAXES")
    private Float totalFeeNTaxes;

    @Column( "TOTAL_ODEYSYS_MARKUP")
    private Float totalOdeysysMarkup;

    @Column( "TOTAL_ODEYSYS_SERVICE_CHARGE")
    private Float totalOdeysysServiceCharge;

    @Column( "TOTAL_ODEYSYS_DISCOUNT")
    private Float totalOdeysysDiscount;

    @Column( "TOTAL_ODEYSYS_AGENCY_MARKUP")
    private Float totalOdeysysAgencyMarkup;

    @Column( "TOTAL_ODEYSYS_AGENT_ONFLY_MARKUP")
    private Float totalOdeysysAgentOnflyMarkup;

    @Column( "TOTAL_ODEYSYS_FARE")
    private Float totalOdeysysFare;

    @Column( "cDate")
    private LocalDateTime cDate;

    @Column( "tCust")
    private Integer tCust;

    @Column(  "oId")
    private String oId;

    @Column( "TOTAL_ODEYSYS_BRANCH_ONFLY_MARKUP")
    private BigDecimal totalOdeysysBranchOnflyMarkup;

    @Column( "BOOKING_TYPE")
    private Integer bookingType;

    @Column( "IMPORT_PNR_CASE")
    private Integer importPnrCase;

    @Column( "cNAME")
    private String cNAME;

    @Column("ctitle")
    private Integer ctitle;

    @Column( "ccountry")
    private String ccountry;

    @Column("cmobile")
    private String cmobile;

    @Column( "cemail")
    private String cemail;

    @Column( "DOB")
    private String dob;

    @Column( "ccity")
    private String ccity;

    @Column("cType")
    private Integer cType;

    @Column( "TICKET_NO")
    private String ticketNo;

    @Column(  "PAX_BASE_FARE")
    private Float paxBaseFare;

    @Column( "PAX_FEE_N_TAXES")
    private Float paxFeeNTaxes;

    @Column( "PAX_ODEYSYS_MARKUP")
    private Float paxOdeysysMarkup;

    @Column( "PAX_ODEYSYS_SERVICE_CHARGE")
    private Float paxOdeysysServiceCharge;

    @Column( "PAX_ODEYSYS_DISCOUNT")
    private Float paxOdeysysDiscount;

    @Column(  "AIRLINE_PNR")
    private String airlinePnr;

    @Column(  "SP_PNR")
    private String spPnr;

    @Column(  "BOOKING_CLASS")
    private String bookingClass;

    @Column(  "CABIN_CLASS")
    private Integer cabinClass;

    @Column(  "ODEYSYS_BSP_COMMISION")
    private Float odeysysBspCommision;

    @Column(  "ODEYSYS_BSP_COMMISSION_PER")
    private Float odeysysBspCommissionPer;

    @Column(  "INVOICE_NUMBER")
    private String invoiceNumber;

    @Column(  "ODEYSYS_BSP_COMMISSION_PER_CHILD")
    private Float odeysysBspCommissionPerChild;

    @Column(  "ODEYSYS_BSP_COMMISION_CHILD")
    private Float odeysysBspCommisionChild;

    @Column(  "MANUAL_MARKUP")
    private Float manualMarkup;

    @Column(  "PAYMENT_MODE")
    private Integer paymentMode;

    @Column(  "ptime")
    private LocalDateTime ptime;

    @Column(  "AGENCY_ID")
    private String agencyId;

    @Column(  "BRANCH_ID")
    private String branchId;

    @Column(  "pType")
    private Integer pType;

    @Column(  "agentOrderStatus")
    private Integer agentOrderStatus;

    @Column(  "uName")
    private String uName;

    @Column(  "bStatus")
    private String bStatus;

    @Column(  "sDate")
    private LocalDateTime sDate;

    @Column(  "refundAmount")
    private BigDecimal refundAmount;

    @Column(  "refundCancelationAmount")
    private BigDecimal refundCancelationAmount;

    @Column(  "agencyName")
    private String agencyName;

    @Column(  "tcPax")
    private Long tcPax;

    @Column(  "iatanumber")
    private String iatanumber;

    @Column(  "branchName")
    private String branchName;

    @Column(  "refundStatus")
    private Integer refundStatus;

    @Column(  "ssramount")
    private Double ssramount;

    @Column(  "refundDate")
    private LocalDateTime refundDate;


    @Column(  "pccIataNumber")
    private String pccIataNumber;

    public String getRef() {
        return ref;
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

    public Float getTotalOdeysysAgencyMarkup() {
        return totalOdeysysAgencyMarkup;
    }

    public Float getTotalOdeysysAgentOnflyMarkup() {
        return totalOdeysysAgentOnflyMarkup;
    }

    public Float getTotalOdeysysFare() {
        return totalOdeysysFare;
    }

    public  LocalDateTime getCDate() {
        return cDate;
    }

    public Integer getTCust() {
        return tCust;
    }

    public String getOId() {
        return oId;
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

    public String getCNAME() {
        return cNAME;
    }

    public Integer getCtitle() {
        return ctitle;
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

    public String getDob() {
        return dob;
    }

    public String getCcity() {
        return ccity;
    }

    public Integer getCType() {
        return cType;
    }

    public String getTicketNo() {
        return ticketNo;
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

    public String getAirlinePnr() {
        return airlinePnr;
    }

    public String getSpPnr() {
        return spPnr;
    }

    public String getBookingClass() {
        return bookingClass;
    }

    public Integer getCabinClass() {
        return cabinClass;
    }

    public Float getOdeysysBspCommision() {
        return odeysysBspCommision;
    }

    public Float getOdeysysBspCommissionPer() {
        return odeysysBspCommissionPer;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public Float getOdeysysBspCommissionPerChild() {
        return odeysysBspCommissionPerChild;
    }

    public Float getOdeysysBspCommisionChild() {
        return odeysysBspCommisionChild;
    }

    public Float getManualMarkup() {
        return manualMarkup;
    }

    public Integer getPaymentMode() {
        return paymentMode;
    }

    public  LocalDateTime getPtime() {
        return ptime;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public String getBranchId() {
        return branchId;
    }

    public Integer getPType() {
        return pType;
    }

    public Integer getAgentOrderStatus() {
        return agentOrderStatus;
    }

    public String getUName() {
        return uName;
    }

    public String getBStatus() {
        return bStatus;
    }

    public  LocalDateTime getSDate() {
        return sDate;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public BigDecimal getRefundCancelationAmount() {
        return refundCancelationAmount;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public Long getTcPax() {
        return tcPax;
    }

    public String getIatanumber() {
        return iatanumber;
    }

    public String getBranchName() {
        return branchName;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public Double getSsramount() {
        return ssramount;
    }

    public  LocalDateTime getRefundDate() {
        return refundDate;
    }

    public String getPccIataNumber() {
        return pccIataNumber;
    }

    protected RvFinancialreport() {
    }
}
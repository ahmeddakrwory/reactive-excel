package com.example.test.demo.test.entitys;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Immutable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Immutable
@Table(name = "tt_ts_fb_segment_detail")
public class TtTsFbSegmentDetail {
    @Id
    private TtTsFbSegmentDetailId id;

    @Column(    "ORIGIN")
    private String origin;

    @Column(    "DESTINATION")
    private String destination;

    @Column(    "SEGMENT_TRIP_TYPE")
    private Integer segmentTripType;

    @Column(    "TRAVEL_DATE")
    private Instant travelDate;

    @Column(    "BOOKING_DATE")
    private Instant bookingDate;

    @Column(    "BOOKING_CLASS")
    private String bookingClass;

    @Column(    "JOURNEY_DURATION")
    private String journeyDuration;

    @Column(    "CABIN_CLASS")
    private Integer cabinClass;

    @Column(    "BOOKING_STATUS")
    private Integer bookingStatus;

    @Column(    "SEARCH_PCC")
    private Integer searchPcc;

    @Column(    "TICKETING_PCC")
    private Integer ticketingPcc;

    @Column(    "VENDOR_TYPE")
    private Integer vendorType;

    @Column(    "BOOKER_ID")
    private Integer bookerId;

    @Column(    "BOOKER_CITY")
    private String bookerCity;

    @Column(    "BOOKER_COUNTRY")
    private String bookerCountry;

    @Column(    "AIRLINE_PNR")
    private String airlinePnr;

    @Column(    "SP_PNR")
    private String spPnr;

    @Column(    "INCL_CHECKIN_BAG_ALLOWANCE")
    private String inclCheckinBagAllowance;

    @Column(    "CANCELLED_BY")
    private Integer cancelledBy;

    @Column(    "CANCELLATION_DATE")
    private Instant cancellationDate;

    @Column(    "CANCELLATION_REMARK")
    private String cancellationRemark;

    @Column(    "DEAL_CODE")
    private String dealCode;

    @Column(    "MARKETING_CARRIER")
    private String marketingCarrier;

    @Column(    "OPERATING_CARRIER")
    private String operatingCarrier;

    @Column(    "ADULT_BASE_FARE")
    private Float adultBaseFare;

    @Column(    "CHILD_BASE_FARE")
    private Float childBaseFare;

    @Column(    "INFANT_BASE_FARE")
    private Float infantBaseFare;

    @Column(    "ADULT_FEE_N_TAXES")
    private Float adultFeeNTaxes;

    @Column(    "CHILD_FEE_N_TAXES")
    private Float childFeeNTaxes;

    @Column(    "INFANT_FEE_N_TAXES")
    private Float infantFeeNTaxes;

    @Column(    "SSR_TOTAL_AMOUNT")
    private Float ssrTotalAmount;

    @Column(    "TOTAL_AMOUNT")
    private Float totalAmount;

    @Column(    "TOTAL_BASE_FARE")
    private Float totalBaseFare;

    @Column(    "TOTAL_FEE_N_TAXES")
    private Float totalFeeNTaxes;

    @Column(    "ODEYSYS_DISCOUNT")
    private Float odeysysDiscount;

    @Column(    "ODEYSYS_SERVICE_CHARGE")
    private Float odeysysServiceCharge;

    @Column(    "ODEYSYS_AMOUNT")
    private Float odeysysAmount;

    @Column(    "CURRENCY")
    private String currency;

    @Column(    "USD_CONVERATION_RATE")
    private Float usdConverationRate;

    @Column(    "LAST_UPDATED_BY")
    private Integer lastUpdatedBy;

    @Column(    "LAST_MOD_TIME")
    private Instant lastModTime;

    @Column(    "TRANSACTION_ID")
    private String transactionId;

    @Column(    "QUEUE_PCC")
    private String queuePcc;

    @Column(    "QUEUE_REF")
    private String queueRef;

    @Column(    "FLIGHT_FARE")
    private Float flightFare;

    @Column(    "BASE_FARE")
    private Float baseFare;

    @Column(    "FEE_N_TAXES")
    private Float feeNTaxes;

    @Column(    "PLATING_CARRIER")
    private String platingCarrier;

    @Column(    "CHILD_INCL_CHECKIN_BAG_ALLOWANCE")
    private String childInclCheckinBagAllowance;

    @Column(    "INFANT_INCL_CHECKIN_BAG_ALLOWANCE")
    private String infantInclCheckinBagAllowance;

    @Column(    "ADULT_CABIN_BAGGAGE_ALLOWANCE")
    private String adultCabinBaggageAllowance;

    @Column(    "CHILD_CABIN_BAGGAGE_ALLOWANCE")
    private String childCabinBaggageAllowance;

    @Column(    "INFANT_CABIN_BAGGAGE_ALLOWANCE")
    private String infantCabinBaggageAllowance;

    @Column(    "JOURNEY_SELL_KEY")
    private String journeySellKey;

    @Column(    "FARE_SELL_KEY")
    private String fareSellKey;

    @Column(    "UNIVERSAL_RECORD_LOCATOR")
    private String universalRecordLocator;

    @Column(    "RESERVATION_RECORD_LOCATOR")
    private String reservationRecordLocator;

    @Column(    "MANUAL_DEAL_CODE")
    private String manualDealCode;

    public TtTsFbSegmentDetailId getId() {
        return id;
    }

    public void setId(TtTsFbSegmentDetailId id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getSegmentTripType() {
        return segmentTripType;
    }

    public void setSegmentTripType(Integer segmentTripType) {
        this.segmentTripType = segmentTripType;
    }

    public Instant getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Instant travelDate) {
        this.travelDate = travelDate;
    }

    public Instant getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Instant bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingClass() {
        return bookingClass;
    }

    public void setBookingClass(String bookingClass) {
        this.bookingClass = bookingClass;
    }

    public String getJourneyDuration() {
        return journeyDuration;
    }

    public void setJourneyDuration(String journeyDuration) {
        this.journeyDuration = journeyDuration;
    }

    public Integer getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(Integer cabinClass) {
        this.cabinClass = cabinClass;
    }

    public Integer getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(Integer bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Integer getSearchPcc() {
        return searchPcc;
    }

    public void setSearchPcc(Integer searchPcc) {
        this.searchPcc = searchPcc;
    }

    public Integer getTicketingPcc() {
        return ticketingPcc;
    }

    public void setTicketingPcc(Integer ticketingPcc) {
        this.ticketingPcc = ticketingPcc;
    }

    public Integer getVendorType() {
        return vendorType;
    }

    public void setVendorType(Integer vendorType) {
        this.vendorType = vendorType;
    }

    public Integer getBookerId() {
        return bookerId;
    }

    public void setBookerId(Integer bookerId) {
        this.bookerId = bookerId;
    }

    public String getBookerCity() {
        return bookerCity;
    }

    public void setBookerCity(String bookerCity) {
        this.bookerCity = bookerCity;
    }

    public String getBookerCountry() {
        return bookerCountry;
    }

    public void setBookerCountry(String bookerCountry) {
        this.bookerCountry = bookerCountry;
    }

    public String getAirlinePnr() {
        return airlinePnr;
    }

    public void setAirlinePnr(String airlinePnr) {
        this.airlinePnr = airlinePnr;
    }

    public String getSpPnr() {
        return spPnr;
    }

    public void setSpPnr(String spPnr) {
        this.spPnr = spPnr;
    }

    public String getInclCheckinBagAllowance() {
        return inclCheckinBagAllowance;
    }

    public void setInclCheckinBagAllowance(String inclCheckinBagAllowance) {
        this.inclCheckinBagAllowance = inclCheckinBagAllowance;
    }

    public Integer getCancelledBy() {
        return cancelledBy;
    }

    public void setCancelledBy(Integer cancelledBy) {
        this.cancelledBy = cancelledBy;
    }

    public Instant getCancellationDate() {
        return cancellationDate;
    }

    public void setCancellationDate(Instant cancellationDate) {
        this.cancellationDate = cancellationDate;
    }

    public String getCancellationRemark() {
        return cancellationRemark;
    }

    public void setCancellationRemark(String cancellationRemark) {
        this.cancellationRemark = cancellationRemark;
    }

    public String getDealCode() {
        return dealCode;
    }

    public void setDealCode(String dealCode) {
        this.dealCode = dealCode;
    }

    public String getMarketingCarrier() {
        return marketingCarrier;
    }

    public void setMarketingCarrier(String marketingCarrier) {
        this.marketingCarrier = marketingCarrier;
    }

    public String getOperatingCarrier() {
        return operatingCarrier;
    }

    public void setOperatingCarrier(String operatingCarrier) {
        this.operatingCarrier = operatingCarrier;
    }

    public Float getAdultBaseFare() {
        return adultBaseFare;
    }

    public void setAdultBaseFare(Float adultBaseFare) {
        this.adultBaseFare = adultBaseFare;
    }

    public Float getChildBaseFare() {
        return childBaseFare;
    }

    public void setChildBaseFare(Float childBaseFare) {
        this.childBaseFare = childBaseFare;
    }

    public Float getInfantBaseFare() {
        return infantBaseFare;
    }

    public void setInfantBaseFare(Float infantBaseFare) {
        this.infantBaseFare = infantBaseFare;
    }

    public Float getAdultFeeNTaxes() {
        return adultFeeNTaxes;
    }

    public void setAdultFeeNTaxes(Float adultFeeNTaxes) {
        this.adultFeeNTaxes = adultFeeNTaxes;
    }

    public Float getChildFeeNTaxes() {
        return childFeeNTaxes;
    }

    public void setChildFeeNTaxes(Float childFeeNTaxes) {
        this.childFeeNTaxes = childFeeNTaxes;
    }

    public Float getInfantFeeNTaxes() {
        return infantFeeNTaxes;
    }

    public void setInfantFeeNTaxes(Float infantFeeNTaxes) {
        this.infantFeeNTaxes = infantFeeNTaxes;
    }

    public Float getSsrTotalAmount() {
        return ssrTotalAmount;
    }

    public void setSsrTotalAmount(Float ssrTotalAmount) {
        this.ssrTotalAmount = ssrTotalAmount;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Float getTotalBaseFare() {
        return totalBaseFare;
    }

    public void setTotalBaseFare(Float totalBaseFare) {
        this.totalBaseFare = totalBaseFare;
    }

    public Float getTotalFeeNTaxes() {
        return totalFeeNTaxes;
    }

    public void setTotalFeeNTaxes(Float totalFeeNTaxes) {
        this.totalFeeNTaxes = totalFeeNTaxes;
    }

    public Float getOdeysysDiscount() {
        return odeysysDiscount;
    }

    public void setOdeysysDiscount(Float odeysysDiscount) {
        this.odeysysDiscount = odeysysDiscount;
    }

    public Float getOdeysysServiceCharge() {
        return odeysysServiceCharge;
    }

    public void setOdeysysServiceCharge(Float odeysysServiceCharge) {
        this.odeysysServiceCharge = odeysysServiceCharge;
    }

    public Float getOdeysysAmount() {
        return odeysysAmount;
    }

    public void setOdeysysAmount(Float odeysysAmount) {
        this.odeysysAmount = odeysysAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Float getUsdConverationRate() {
        return usdConverationRate;
    }

    public void setUsdConverationRate(Float usdConverationRate) {
        this.usdConverationRate = usdConverationRate;
    }

    public Integer getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Integer lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Instant getLastModTime() {
        return lastModTime;
    }

    public void setLastModTime(Instant lastModTime) {
        this.lastModTime = lastModTime;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getQueuePcc() {
        return queuePcc;
    }

    public void setQueuePcc(String queuePcc) {
        this.queuePcc = queuePcc;
    }

    public String getQueueRef() {
        return queueRef;
    }

    public void setQueueRef(String queueRef) {
        this.queueRef = queueRef;
    }

    public Float getFlightFare() {
        return flightFare;
    }

    public void setFlightFare(Float flightFare) {
        this.flightFare = flightFare;
    }

    public Float getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(Float baseFare) {
        this.baseFare = baseFare;
    }

    public Float getFeeNTaxes() {
        return feeNTaxes;
    }

    public void setFeeNTaxes(Float feeNTaxes) {
        this.feeNTaxes = feeNTaxes;
    }

    public String getPlatingCarrier() {
        return platingCarrier;
    }

    public void setPlatingCarrier(String platingCarrier) {
        this.platingCarrier = platingCarrier;
    }

    public String getChildInclCheckinBagAllowance() {
        return childInclCheckinBagAllowance;
    }

    public void setChildInclCheckinBagAllowance(String childInclCheckinBagAllowance) {
        this.childInclCheckinBagAllowance = childInclCheckinBagAllowance;
    }

    public String getInfantInclCheckinBagAllowance() {
        return infantInclCheckinBagAllowance;
    }

    public void setInfantInclCheckinBagAllowance(String infantInclCheckinBagAllowance) {
        this.infantInclCheckinBagAllowance = infantInclCheckinBagAllowance;
    }

    public String getAdultCabinBaggageAllowance() {
        return adultCabinBaggageAllowance;
    }

    public void setAdultCabinBaggageAllowance(String adultCabinBaggageAllowance) {
        this.adultCabinBaggageAllowance = adultCabinBaggageAllowance;
    }

    public String getChildCabinBaggageAllowance() {
        return childCabinBaggageAllowance;
    }

    public void setChildCabinBaggageAllowance(String childCabinBaggageAllowance) {
        this.childCabinBaggageAllowance = childCabinBaggageAllowance;
    }

    public String getInfantCabinBaggageAllowance() {
        return infantCabinBaggageAllowance;
    }

    public void setInfantCabinBaggageAllowance(String infantCabinBaggageAllowance) {
        this.infantCabinBaggageAllowance = infantCabinBaggageAllowance;
    }

    public String getJourneySellKey() {
        return journeySellKey;
    }

    public void setJourneySellKey(String journeySellKey) {
        this.journeySellKey = journeySellKey;
    }

    public String getFareSellKey() {
        return fareSellKey;
    }

    public void setFareSellKey(String fareSellKey) {
        this.fareSellKey = fareSellKey;
    }

    public String getUniversalRecordLocator() {
        return universalRecordLocator;
    }

    public void setUniversalRecordLocator(String universalRecordLocator) {
        this.universalRecordLocator = universalRecordLocator;
    }

    public String getReservationRecordLocator() {
        return reservationRecordLocator;
    }

    public void setReservationRecordLocator(String reservationRecordLocator) {
        this.reservationRecordLocator = reservationRecordLocator;
    }

    public String getManualDealCode() {
        return manualDealCode;
    }

    public void setManualDealCode(String manualDealCode) {
        this.manualDealCode = manualDealCode;
    }

}
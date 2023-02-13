package com.example.test.demo.test.utils;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Projection {
   String  AGENCY_ID;
   String AGENCYNAME;
   Integer AGENTORDERSTATUS;
   String AIRLINE_PNR;
   String BOOKING_CLASS;
   Integer BOOKING_TYPE;
   String BRANCH_ID;
   String BRANCHNAME;
   String BSTATUS;
   Integer CABIN_CLASS;
   String CCITY;
   String CITY_NAME;
   String REF;
   String CCOUNTRY;
   String  CMOBILE;
   String  CEMAIL;
   String  TICKET_NO;
   String  SP_PNR;
   Integer  TRIP_TYPE;
   String  Ccity;
   String  ORIGIN;
   String  DESTINATION;
   Integer  NO_OF_SEGMENT;
   String  SUPPLIER_NAME;
   Double  TOTAL_BASE_FARE;
   Double   TOTAL_ODEYSYS_MARKUP;
   Double  TOTAL_ODEYSYS_SERVICE_CHARGE;
    Double   TOTAL_ODEYSYS_DISCOUNT;
   Double  ODEYSYS_BSP_COMMISION;
   Double  TOTAL_ODEYSYS_AGENCY_MARKUP;
   Double  TOTAL_ODEYSYS_AGENT_ONFLY_MARKUP;
    int   PAYMENT_MODE;
   Date PTIME;
   Date  CDATE;
    int  CTYPE;
   String  SDATE;
    int   TCUST;
   String  UNAME;
   String  OID ;
   String  INVOICE_NUMBER;
   String  DOB;
   String  REFUNDAMOUNT;
   String  TOTAL_ODEYSYS_BRANCH_ONFLY_MARKUP;
   String  IMPORT_PNR_CASE;
   String  PAX_ODEYSYS_SERVICE_CHARGE;
   String  PAX_FEE_N_TAXES;
   String  PAX_ODEYSYS_MARKUP;
   String  PAX_ODEYSYS_DISCOUNT;
   String  TCPAX;
   Double  MANUAL_MARKUP;
//   String  IMPORT_PNR_CASE;
//   String  IMPORT_PNR_CASE;


}

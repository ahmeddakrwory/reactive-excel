package com.example.test.demo.test;

import com.example.test.demo.test.entitys.RvFinancialreport;
import com.example.test.demo.test.entitys.RvPnrimportHistory;
import com.example.test.demo.test.entitys.TtUser;
import com.example.test.demo.test.searchmodels.FinanceSerch;

import com.example.test.demo.test.utils.Projection;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.util.*;
import java.util.function.BiFunction;

import static org.springframework.data.relational.core.query.Criteria.where;
import static org.springframework.data.relational.core.query.Query.query;


@Service
public class Services {
@Autowired
    private R2dbcEntityTemplate entityTemplate;
     final DatabaseClient db;

    public Services(DatabaseClient db) {
        this.db = db;

    }


    @Transactional
   public Flux<TtUser> hal(){
    return entityTemplate.select(TtUser.class)
            .all();
   }
   @Transactional
    public Flux<TtUser>getsql() {
//   String query="FROM TtUser";
List<String>s=new ArrayList<String>();
s.add("M.Ashraf");
s.add("e.ramzy@ndceg.com");
       return
       entityTemplate.select(query(where("userAlias").in(s)), TtUser.class);

}
//@Transactional
//    public Flux<Object> getfinace (){
//
//}
//    @Transactional
    Flux<RvPnrimportHistory>getrv(ArrayList<String> s){

        return

        entityTemplate.select(query(where("orgname").in(s)), RvPnrimportHistory.class);
    }

    public Flux<RvFinancialreport> getFinaceData(FinanceSerch financeSerch){

        return entityTemplate.select(query(where("agencyName").in(financeSerch.getOrgname()).and("cDate").between(financeSerch.getFdate(),financeSerch.getTdate())), RvFinancialreport.class);
    }

    public Flux findAll() {

        return db.sql("SELECT \n" +
                        "    FB.FB_BOOKING_REF_NO AS REF,\n" +
                        "    CONCAT(FBPD.FIRST_NAME, ' ', FBPD.LAST_NAME) AS CNAME,\n" +
                        "    FBPD.TITLE AS CTITLE,\n" +
                        "    AC.CITY AS CCITY,\n" +
                        "\tFBPD.NATIONALITY AS CCOUNTRY,\n" +
                        "    FBPD.MOBILE_NO AS CMOBILE,\n" +
                        "    FBPD.EMAIL_ID AS CEMAIL,\n" +
                        "    FBSBD.TICKET_NO,\n" +
                        "    FS.AIRLINE_PNR,\n" +
                        "    FS.SP_PNR,\n" +
                        "    FB.TRIP_TYPE,\n" +
                        "    FB.ORIGIN,\n" +
                        "    FB.DESTINATION,\n" +
                        "    FB.NO_OF_SEGMENT,\n" +
                        "    FS.BOOKING_CLASS,\n" +
                        "    FS.CABIN_CLASS,\n" +
                        "    FB.SUPPLIER_NAME,\n" +
                        "    FB.TOTAL_BASE_FARE,\n" +
                        "    FB.TOTAL_FEE_N_TAXES,\n" +
                        "    FB.TOTAL_ODEYSYS_MARKUP,\n" +
                        "    FB.TOTAL_ODEYSYS_SERVICE_CHARGE,\n" +
                        "    FB.TOTAL_ODEYSYS_DISCOUNT,\n" +
                        "    FI.ODEYSYS_BSP_COMMISION,\n" +
                        "    FI.ODEYSYS_BSP_COMMISSION_PER,\n" +
                        "    FB.TOTAL_ODEYSYS_AGENCY_MARKUP,\n" +
                        "    FB.TOTAL_ODEYSYS_AGENT_ONFLY_MARKUP,\n" +
                        "    FB.TOTAL_ODEYSYS_FARE,\n" +
                        "    TST.PAYMENT_MODE, \n" +
                        "    TST.CREATION_TIME AS PTIME,\n" +
                        "    AO.AGENCY_ID,\n" +
                        "    AO.BRANCH_ID,\n" +
                        "    FB.CREATION_TIME AS CDATE,\n" +
                        "    APR.ORDER_TYPE AS PTYPE,\n" +
                        "    AC.CUSTOMER_TYPE AS CTYPE,\n" +
                        "    (SELECT SUBFS.TRAVEL_DATE FROM TT_TS_FB_SEGMENT_DETAIL SUBFS WHERE SUBFS.FB_BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND SUBFS.SEGMENT_NO = 1) AS SDATE,\n" +
                        "    FB.NO_OF_PASSENGER AS TCUST,\n" +
                        "    U.FIRST_NAME AS UNAME,\n" +
                        "    EV.VALUE AS BSTATUS ,\n" +
                        "    FB.ORDER_ID AS OID,\n" +
                        "    FI.INVOICE_NUMBER,\n" +
                        "\tFBPD.DOB,\n" +
                        "    (SELECT REFUND_AMOUNT FROM REFUND_DETAILS WHERE BOOKING_REF_NO = FB.FB_BOOKING_REF_NO LIMIT 1) AS REFUNDAMOUNT,\n" +
                        "    (SELECT CD.CANCELLATION_CHARGES FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID AND CD.PASSENGER_NO = FBPD.PASSENGER_NO LIMIT 1) AS REFUNDCANCELATIONAMOUNT,\n" +
                        "    (SELECT TU.GROUP_NAME FROM WONDERDB.TT_ORGANIZATION TTO, TT_USER_GROUP TU WHERE TTO.GROUP_ID = TU.GROUP_ID AND TTO.ORGANIZATION_ID = AO.AGENCY_ID) AS AGENCYNAME,\n" +
                        "    FB.TOTAL_ODEYSYS_BRANCH_ONFLY_MARKUP,\n" +
                        "    FB.BOOKING_TYPE,\n" +
                        "    FB.IMPORT_PNR_CASE,\n" +
                        "    FI.ODEYSYS_BSP_COMMISSION_PER_CHILD,\n" +
                        "    FI.ODEYSYS_BSP_COMMISION_CHILD,\n" +
                        "    FBSBD.PAX_BASE_FARE,\n" +
                        "    FBSBD.PAX_FEE_N_TAXES,\n" +
                        "    FBSBD.PAX_ODEYSYS_MARKUP,\n" +
                        "    FBSBD.PAX_ODEYSYS_SERVICE_CHARGE,\n" +
                        "    FBSBD.PAX_ODEYSYS_DISCOUNT,\n" +
                        "    (SELECT COUNT(*) FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID) TCPAX,\n" +
                        "    (SELECT OFD.IATA_NUMBER FROM TT_ORG_FIN_DETAIL OFD WHERE OFD.ORGANIZATION_ID = AO.AGENCY_ID) AS IATANUMBER,\n" +
                        "    (SELECT TU.GROUP_NAME FROM WONDERDB.TT_ORGANIZATION TTO, TT_USER_GROUP TU WHERE TTO.GROUP_ID = TU.GROUP_ID AND TTO.ORGANIZATION_ID = AO.BRANCH_ID) AS BRANCHNAME,\n" +
                        "    (SELECT CD.REFUND_STATUS FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID AND CD.PASSENGER_NO = FBPD.PASSENGER_NO LIMIT 1 ) AS REFUNDSTATUS,    \n" +
                        "     APR.AGENT_BOOKING_STATUS AGENTORDERSTATUS,\n" +
                        "    (SELECT SUM(FPS.SSR_AMOUNT) FROM TT_TS_FB_PASSENGER_SSR FPS WHERE FBPD.PASSENGER_NO = FPS.PASSENGER_NO AND FBPD.FB_BOOKING_REF_NO = FPS.FB_BOOKING_REF_NO GROUP BY FPS.FB_BOOKING_REF_NO) AS SSRAMOUNT,\n" +
                        "    (SELECT CREATION_TIME FROM REFUND_DETAILS WHERE BOOKING_REF_NO = FB.FB_BOOKING_REF_NO LIMIT 1 ) AS REFUNDDATE,\n" +
                        "    FI.MANUAL_MARKUP,\n" +
                        "    (SELECT TTCV.VALUE FROM TT_TS_SUPPLIER_CREDENTIAL_VALUES TTCV, TT_TS_SUPPLIER_CREDENTIAL_FIELDS TTFI WHERE TTFI.CREDENTIAL_FIELD_NAME = 'IATA_NUMBER' AND TTCV.CREDENTIAL_ID = FI.TICKETING_PCC_ID AND TTCV.CREDENTIAL_FIELD_ID = TTFI.CREDENTIAL_FIELD_ID LIMIT 1) AS PCCIATANUMBER,\n" +
                        "\tU.USER_ALIAS AS NDCSTAFFNAME,\n" +
                        "\tIFNULL(FB.TOTAL_SURCHARGE_AMOUNT, 0.0) TOTAL_SURCHARGE_AMOUNT,\n" +
                        "\tTS.STATE_NAME,\n" +
                        "\tTC.CITY_NAME\n" +
                        "FROM\n" +
                        "    TT_TS_FLIGHT_BOOK FB\n" +
                        "        INNER JOIN TT_TS_AGENT_ORDER AO ON FB.ORDER_ID = AO.ORDER_ID\n" +
                        "        INNER JOIN TT_TS_AGENT_ORDER_CUSTOMER AC ON AO.ID = AC.ID\n" +
                        "        INNER JOIN TT_TS_AGENT_ORDER_PRODUCT_REF APR ON AO.ID = APR.ID\n" +
                        "        INNER JOIN TT_TS_TRANSACTION TST ON FB.ORDER_ID = TST.ORDER_ID\n" +
                        "        INNER JOIN TT_TS_FB_INVOICE_DETAIL FI ON FB.FB_BOOKING_REF_NO = FI.FB_BOOKING_REF_NO\n" +
                        "        INNER JOIN TT_TS_FB_SEGMENT_DETAIL FS ON FB.FB_BOOKING_REF_NO = FS.FB_BOOKING_REF_NO\n" +
                        "        INNER JOIN TT_TS_FB_PASSENGER_DETAIL FBPD ON FB.FB_BOOKING_REF_NO = FBPD.FB_BOOKING_REF_NO\n" +
                        "        INNER JOIN TT_TS_FB_PAX_SEG_BOOK_DETAIL FBSBD ON FB.FB_BOOKING_REF_NO = FBSBD.FB_BOOKING_REF_NO AND FBSBD.PASSENGER_NO = FBPD.PASSENGER_NO\n" +
                        "        INNER JOIN TT_ENUM_VALUES EV ON EV.INT_CODE = FBSBD.TICKET_BOOKING_STATUS\n" +
                        "        INNER JOIN TT_USER U ON FB.CREATED_BY = U.USER_ID\n" +
                        "        INNER JOIN TT_ORGANIZATION AGN ON (AGN.ORGANIZATION_ID = AO.AGENCY_ID)\n" +
                        "        INNER JOIN TT_STATE TS ON (TS.STATE_ID = AGN.STATE_ID)\n" +
                        "\t\tINNER JOIN TT_CITY TC ON (TC.CITY_ID = AGN.CITY_ID)\n" +
                        "WHERE\n" +
                        "\tFBSBD.SEGMENT_REF_NO = 1\n" +
                        "        AND FB.BOOKING_STATUS IN (2 , 5, 8, 9, 12, 13, 15, 16)\n" +
                        "        AND EV.TYPE_NAME = 'BOOKING_STATUS'\n" +
                        "        AND TST.CREATION_TIME BETWEEN '2022-06-1 00:00:00' AND '2022-06-25 23:59:59'\n" +
                        "        AND APR.ORDER_TYPE = 0\n" +
                        "        AND (AO.AGENCY_ID IN ('AGN3' , 'AGN14',\n" +
                        "        'AGN34',\n" +
                        "        'AGN35',\n" +
                        "        'AGN50',\n" +
                        "        'AGN59',\n" +
                        "        'AGN60',\n" +
                        "        'AGN62',\n" +
                        "        'AGN92',\n" +
                        "        'AGN93',\n" +
                        "        'AGN97',\n" +
                        "        'AGN104',\n" +
                        "        'AGN107',\n" +
                        "        'AGN110',\n" +
                        "        'AGN120',\n" +
                        "        'AGN127',\n" +
                        "        'AGN139',\n" +
                        "        'AGN144',\n" +
                        "        'AGN147',\n" +
                        "        'AGN148',\n" +
                        "        'AGN154')\n" +
                        "        )\n" +
                        "GROUP BY REF , CNAME , CDATE , PTYPE , CTYPE , SDATE , TCUST , UNAME , BSTATUS , OID\n" +
                        "UNION\n" +
                        "SELECT \n" +
                        "\t FB.FB_BOOKING_REF_NO AS REF,\n" +
                        "    CONCAT(FBPD.FIRST_NAME, ' ', FBPD.LAST_NAME) AS CNAME,\n" +
                        "    FBPD.TITLE AS CTITLE,\n" +
                        "    AC.CITY AS CCITY,\n" +
                        "\tFBPD.NATIONALITY AS CCOUNTRY,\n" +
                        "    FBPD.MOBILE_NO AS CMOBILE,\n" +
                        "    FBPD.EMAIL_ID AS CEMAIL,\n" +
                        "    FBSBD.TICKET_NO,\n" +
                        "    FS.AIRLINE_PNR,\n" +
                        "    FS.SP_PNR,\n" +
                        "    FB.TRIP_TYPE,\n" +
                        "    FB.ORIGIN,\n" +
                        "    FB.DESTINATION,\n" +
                        "    FB.NO_OF_SEGMENT,\n" +
                        "    FS.BOOKING_CLASS,\n" +
                        "    FS.CABIN_CLASS,\n" +
                        "    FB.SUPPLIER_NAME,\n" +
                        "    FB.TOTAL_BASE_FARE,\n" +
                        "    FB.TOTAL_FEE_N_TAXES,\n" +
                        "    FB.TOTAL_ODEYSYS_MARKUP,\n" +
                        "    FB.TOTAL_ODEYSYS_SERVICE_CHARGE,\n" +
                        "    FB.TOTAL_ODEYSYS_DISCOUNT,\n" +
                        "    FI.ODEYSYS_BSP_COMMISION,\n" +
                        "    FI.ODEYSYS_BSP_COMMISSION_PER,\n" +
                        "    FB.TOTAL_ODEYSYS_AGENCY_MARKUP,\n" +
                        "    FB.TOTAL_ODEYSYS_AGENT_ONFLY_MARKUP,\n" +
                        "    FB.TOTAL_ODEYSYS_FARE,\n" +
                        "    TST.PAYMENT_MODE, \n" +
                        "    TST.CREATION_TIME AS PTIME,\n" +
                        "    AO.AGENCY_ID,\n" +
                        "    AO.BRANCH_ID,\n" +
                        "    FB.CREATION_TIME AS CDATE,\n" +
                        "    APR.ORDER_TYPE AS PTYPE,\n" +
                        "    AC.CUSTOMER_TYPE AS CTYPE,\n" +
                        "    (SELECT SUBFS.TRAVEL_DATE FROM TT_TS_FB_SEGMENT_DETAIL SUBFS WHERE SUBFS.FB_BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND SUBFS.SEGMENT_NO = 1) AS SDATE,\n" +
                        "    FB.NO_OF_PASSENGER AS TCUST,\n" +
                        "    U.FIRST_NAME AS UNAME,\n" +
                        "    EV.VALUE AS BSTATUS ,\n" +
                        "    FB.ORDER_ID AS OID,\n" +
                        "    FI.INVOICE_NUMBER,\n" +
                        "\tFBPD.DOB,\n" +
                        "    (SELECT REFUND_AMOUNT FROM REFUND_DETAILS WHERE BOOKING_REF_NO = FB.FB_BOOKING_REF_NO LIMIT 1) AS REFUNDAMOUNT,\n" +
                        "    (SELECT CD.CANCELLATION_CHARGES FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID AND CD.PASSENGER_NO = FBPD.PASSENGER_NO LIMIT 1) AS REFUNDCANCELATIONAMOUNT,\n" +
                        "    (SELECT TU.GROUP_NAME FROM WONDERDB.TT_ORGANIZATION TTO, TT_USER_GROUP TU WHERE TTO.GROUP_ID = TU.GROUP_ID AND TTO.ORGANIZATION_ID = AO.AGENCY_ID) AS AGENCYNAME,\n" +
                        "    FB.TOTAL_ODEYSYS_BRANCH_ONFLY_MARKUP,\n" +
                        "    FB.BOOKING_TYPE,\n" +
                        "    FB.IMPORT_PNR_CASE,\n" +
                        "    FI.ODEYSYS_BSP_COMMISSION_PER_CHILD,\n" +
                        "    FI.ODEYSYS_BSP_COMMISION_CHILD,\n" +
                        "    FBSBD.PAX_BASE_FARE,\n" +
                        "    FBSBD.PAX_FEE_N_TAXES,\n" +
                        "    FBSBD.PAX_ODEYSYS_MARKUP,\n" +
                        "    FBSBD.PAX_ODEYSYS_SERVICE_CHARGE,\n" +
                        "    FBSBD.PAX_ODEYSYS_DISCOUNT,\n" +
                        "    (SELECT COUNT(*) FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID) TCPAX,\n" +
                        "    (SELECT OFD.IATA_NUMBER FROM TT_ORG_FIN_DETAIL OFD WHERE OFD.ORGANIZATION_ID = AO.AGENCY_ID) AS IATANUMBER,\n" +
                        "    (SELECT TU.GROUP_NAME FROM WONDERDB.TT_ORGANIZATION TTO, TT_USER_GROUP TU WHERE TTO.GROUP_ID = TU.GROUP_ID AND TTO.ORGANIZATION_ID = AO.BRANCH_ID) AS BRANCHNAME,\n" +
                        "    (SELECT CD.REFUND_STATUS FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID AND CD.PASSENGER_NO = FBPD.PASSENGER_NO LIMIT 1 ) AS REFUNDSTATUS,    \n" +
                        "     APR.AGENT_BOOKING_STATUS AGENTORDERSTATUS,\n" +
                        "    (SELECT SUM(FPS.SSR_AMOUNT) FROM TT_TS_FB_PASSENGER_SSR FPS WHERE FBPD.PASSENGER_NO = FPS.PASSENGER_NO AND FBPD.FB_BOOKING_REF_NO = FPS.FB_BOOKING_REF_NO GROUP BY FPS.FB_BOOKING_REF_NO) AS SSRAMOUNT,\n" +
                        "    (SELECT CREATION_TIME FROM REFUND_DETAILS WHERE BOOKING_REF_NO = FB.FB_BOOKING_REF_NO LIMIT 1 ) AS REFUNDDATE,\n" +
                        "    FI.MANUAL_MARKUP,\n" +
                        "    (SELECT TTCV.VALUE FROM TT_TS_SUPPLIER_CREDENTIAL_VALUES TTCV, TT_TS_SUPPLIER_CREDENTIAL_FIELDS TTFI WHERE TTFI.CREDENTIAL_FIELD_NAME = 'IATA_NUMBER' AND TTCV.CREDENTIAL_ID = FI.TICKETING_PCC_ID AND TTCV.CREDENTIAL_FIELD_ID = TTFI.CREDENTIAL_FIELD_ID LIMIT 1) AS PCCIATANUMBER,\n" +
                        "\tU.USER_ALIAS AS NDCSTAFFNAME,\n" +
                        "\tIFNULL(FB.TOTAL_SURCHARGE_AMOUNT, 0.0) TOTAL_SURCHARGE_AMOUNT,\n" +
                        "\tTS_BR.STATE_NAME,\n" +
                        "\tTC_BR.CITY_NAME\n" +
                        "FROM\n" +
                        "    TT_TS_FLIGHT_BOOK FB\n" +
                        "        INNER JOIN TT_TS_AGENT_ORDER AO ON FB.ORDER_ID = AO.ORDER_ID\n" +
                        "        INNER JOIN TT_TS_AGENT_ORDER_CUSTOMER AC ON AO.ID = AC.ID\n" +
                        "        INNER JOIN TT_TS_AGENT_ORDER_PRODUCT_REF APR ON AO.ID = APR.ID\n" +
                        "        INNER JOIN TT_TS_TRANSACTION TST ON FB.ORDER_ID = TST.ORDER_ID\n" +
                        "        INNER JOIN TT_TS_FB_INVOICE_DETAIL FI ON FB.FB_BOOKING_REF_NO = FI.FB_BOOKING_REF_NO\n" +
                        "        INNER JOIN TT_TS_FB_SEGMENT_DETAIL FS ON FB.FB_BOOKING_REF_NO = FS.FB_BOOKING_REF_NO\n" +
                        "        INNER JOIN TT_TS_FB_PASSENGER_DETAIL FBPD ON FB.FB_BOOKING_REF_NO = FBPD.FB_BOOKING_REF_NO\n" +
                        "        INNER JOIN TT_TS_FB_PAX_SEG_BOOK_DETAIL FBSBD ON FB.FB_BOOKING_REF_NO = FBSBD.FB_BOOKING_REF_NO AND FBSBD.PASSENGER_NO = FBPD.PASSENGER_NO\n" +
                        "        INNER JOIN TT_ENUM_VALUES EV ON EV.INT_CODE = FBSBD.TICKET_BOOKING_STATUS\n" +
                        "        INNER JOIN TT_USER U ON FB.CREATED_BY = U.USER_ID\n" +
                        "\t\tINNER JOIN TT_ORGANIZATION BR ON (BR.ORGANIZATION_ID = AO.BRANCH_ID)\n" +
                        "\t\tINNER JOIN TT_STATE TS_BR ON (TS_BR.STATE_ID = BR.STATE_ID)\n" +
                        "\t\tINNER JOIN TT_CITY TC_BR ON (TC_BR.CITY_ID = BR.CITY_ID)\n" +
                        "WHERE\n" +
                        "\tFBSBD.SEGMENT_REF_NO = 1\n" +
                        "        AND FB.BOOKING_STATUS IN (2 , 5, 8, 9, 12, 13, 15, 16)\n" +
                        "        AND EV.TYPE_NAME = 'BOOKING_STATUS'\n" +
                        "        AND TST.CREATION_TIME BETWEEN '2022-06-1 00:00:00' AND '2022-06-25 23:59:59'\n" +
                        "        AND APR.ORDER_TYPE = 0\n" +
                        "        AND AO.BRANCH_ID IN ('BRN3')\n" +
                        "        AND AO.AGENCY_ID IS NULL\n" +
                        "GROUP BY REF , CNAME , CDATE , PTYPE , CTYPE , SDATE , TCUST , UNAME , BSTATUS , OID        \n" +
                        "UNION\n" +
                        "SELECT \n" +
                        "\t FB.FB_BOOKING_REF_NO AS REF,\n" +
                        "    CONCAT(FBPD.FIRST_NAME, ' ', FBPD.LAST_NAME) AS CNAME,\n" +
                        "    FBPD.TITLE AS CTITLE,\n" +
                        "    AC.CITY AS CCITY,\n" +
                        "\tFBPD.NATIONALITY AS CCOUNTRY,\n" +
                        "    FBPD.MOBILE_NO AS CMOBILE,\n" +
                        "    FBPD.EMAIL_ID AS CEMAIL,\n" +
                        "    FBSBD.TICKET_NO,\n" +
                        "    FS.AIRLINE_PNR,\n" +
                        "    FS.SP_PNR,\n" +
                        "    FB.TRIP_TYPE,\n" +
                        "    FB.ORIGIN,\n" +
                        "    FB.DESTINATION,\n" +
                        "    FB.NO_OF_SEGMENT,\n" +
                        "    FS.BOOKING_CLASS,\n" +
                        "    FS.CABIN_CLASS,\n" +
                        "    FB.SUPPLIER_NAME,\n" +
                        "    FB.TOTAL_BASE_FARE,\n" +
                        "    FB.TOTAL_FEE_N_TAXES,\n" +
                        "    FB.TOTAL_ODEYSYS_MARKUP,\n" +
                        "    FB.TOTAL_ODEYSYS_SERVICE_CHARGE,\n" +
                        "    FB.TOTAL_ODEYSYS_DISCOUNT,\n" +
                        "    FI.ODEYSYS_BSP_COMMISION,\n" +
                        "    FI.ODEYSYS_BSP_COMMISSION_PER,\n" +
                        "    FB.TOTAL_ODEYSYS_AGENCY_MARKUP,\n" +
                        "    FB.TOTAL_ODEYSYS_AGENT_ONFLY_MARKUP,\n" +
                        "    FB.TOTAL_ODEYSYS_FARE,\n" +
                        "    TST.PAYMENT_MODE, \n" +
                        "    TST.CREATION_TIME AS PTIME,\n" +
                        "    AO.AGENCY_ID,\n" +
                        "    AO.BRANCH_ID,\n" +
                        "    FB.CREATION_TIME AS CDATE,\n" +
                        "    APR.ORDER_TYPE AS PTYPE,\n" +
                        "    AC.CUSTOMER_TYPE AS CTYPE,\n" +
                        "    (SELECT SUBFS.TRAVEL_DATE FROM TT_TS_FB_SEGMENT_DETAIL SUBFS WHERE SUBFS.FB_BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND SUBFS.SEGMENT_NO = 1) AS SDATE,\n" +
                        "    FB.NO_OF_PASSENGER AS TCUST,\n" +
                        "    U.FIRST_NAME AS UNAME,\n" +
                        "    EV.VALUE AS BSTATUS ,\n" +
                        "    FB.ORDER_ID AS OID,\n" +
                        "    FI.INVOICE_NUMBER,\n" +
                        "\tFBPD.DOB,\n" +
                        "    (SELECT REFUND_AMOUNT FROM REFUND_DETAILS WHERE BOOKING_REF_NO = FB.FB_BOOKING_REF_NO LIMIT 1) AS REFUNDAMOUNT,\n" +
                        "    (SELECT CD.CANCELLATION_CHARGES FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID AND CD.PASSENGER_NO = FBPD.PASSENGER_NO LIMIT 1) AS REFUNDCANCELATIONAMOUNT,\n" +
                        "    (SELECT TU.GROUP_NAME FROM WONDERDB.TT_ORGANIZATION TTO, TT_USER_GROUP TU WHERE TTO.GROUP_ID = TU.GROUP_ID AND TTO.ORGANIZATION_ID = AO.AGENCY_ID) AS AGENCYNAME,\n" +
                        "    FB.TOTAL_ODEYSYS_BRANCH_ONFLY_MARKUP,\n" +
                        "    FB.BOOKING_TYPE,\n" +
                        "    FB.IMPORT_PNR_CASE,\n" +
                        "    FI.ODEYSYS_BSP_COMMISSION_PER_CHILD,\n" +
                        "    FI.ODEYSYS_BSP_COMMISION_CHILD,\n" +
                        "    FBSBD.PAX_BASE_FARE,\n" +
                        "    FBSBD.PAX_FEE_N_TAXES,\n" +
                        "    FBSBD.PAX_ODEYSYS_MARKUP,\n" +
                        "    FBSBD.PAX_ODEYSYS_SERVICE_CHARGE,\n" +
                        "    FBSBD.PAX_ODEYSYS_DISCOUNT,\n" +
                        "    (SELECT COUNT(*) FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID) TCPAX,\n" +
                        "    (SELECT OFD.IATA_NUMBER FROM TT_ORG_FIN_DETAIL OFD WHERE OFD.ORGANIZATION_ID = AO.AGENCY_ID) AS IATANUMBER,\n" +
                        "    (SELECT TU.GROUP_NAME FROM WONDERDB.TT_ORGANIZATION TTO, TT_USER_GROUP TU WHERE TTO.GROUP_ID = TU.GROUP_ID AND TTO.ORGANIZATION_ID = AO.BRANCH_ID) AS BRANCHNAME,\n" +
                        "    (SELECT CD.REFUND_STATUS FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID AND CD.PASSENGER_NO = FBPD.PASSENGER_NO LIMIT 1 ) AS REFUNDSTATUS,    \n" +
                        "     APR.AGENT_BOOKING_STATUS AGENTORDERSTATUS,\n" +
                        "    (SELECT SUM(FPS.SSR_AMOUNT) FROM TT_TS_FB_PASSENGER_SSR FPS WHERE FBPD.PASSENGER_NO = FPS.PASSENGER_NO AND FBPD.FB_BOOKING_REF_NO = FPS.FB_BOOKING_REF_NO GROUP BY FPS.FB_BOOKING_REF_NO) AS SSRAMOUNT,\n" +
                        "    (SELECT CREATION_TIME FROM REFUND_DETAILS WHERE BOOKING_REF_NO = FB.FB_BOOKING_REF_NO LIMIT 1 ) AS REFUNDDATE,\n" +
                        "    FI.MANUAL_MARKUP,\n" +
                        "    (SELECT TTCV.VALUE FROM TT_TS_SUPPLIER_CREDENTIAL_VALUES TTCV, TT_TS_SUPPLIER_CREDENTIAL_FIELDS TTFI WHERE TTFI.CREDENTIAL_FIELD_NAME = 'IATA_NUMBER' AND TTCV.CREDENTIAL_ID = FI.TICKETING_PCC_ID AND TTCV.CREDENTIAL_FIELD_ID = TTFI.CREDENTIAL_FIELD_ID LIMIT 1) AS PCCIATANUMBER,\n" +
                        "\tU.USER_ALIAS AS NDCSTAFFNAME,\n" +
                        "\tIFNULL(FB.TOTAL_SURCHARGE_AMOUNT, 0.0) TOTAL_SURCHARGE_AMOUNT,\n" +
                        "\tTS_BR.STATE_NAME,\n" +
                        "\tTC_BR.CITY_NAME\n" +
                        "FROM\n" +
                        "    TT_TS_FLIGHT_BOOK FB\n" +
                        "        INNER JOIN TT_TS_AGENT_ORDER AO ON FB.ORDER_ID = AO.ORDER_ID\n" +
                        "        INNER JOIN TT_TS_AGENT_ORDER_CUSTOMER AC ON AO.ID = AC.ID\n" +
                        "        INNER JOIN TT_TS_AGENT_ORDER_PRODUCT_REF APR ON AO.ID = APR.ID\n" +
                        "        INNER JOIN TT_TS_TRANSACTION TST ON FB.ORDER_ID = TST.ORDER_ID\n" +
                        "        INNER JOIN TT_TS_FB_INVOICE_DETAIL FI ON FB.FB_BOOKING_REF_NO = FI.FB_BOOKING_REF_NO\n" +
                        "        INNER JOIN TT_TS_FB_SEGMENT_DETAIL FS ON FB.FB_BOOKING_REF_NO = FS.FB_BOOKING_REF_NO\n" +
                        "        INNER JOIN TT_TS_FB_PASSENGER_DETAIL FBPD ON FB.FB_BOOKING_REF_NO = FBPD.FB_BOOKING_REF_NO\n" +
                        "        INNER JOIN TT_TS_FB_PAX_SEG_BOOK_DETAIL FBSBD ON FB.FB_BOOKING_REF_NO = FBSBD.FB_BOOKING_REF_NO AND FBSBD.PASSENGER_NO = FBPD.PASSENGER_NO\n" +
                        "        INNER JOIN TT_ENUM_VALUES EV ON EV.INT_CODE = FBSBD.TICKET_BOOKING_STATUS\n" +
                        "        INNER JOIN TT_USER U ON FB.CREATED_BY = U.USER_ID\n" +
                        "\t\tINNER JOIN TT_ORGANIZATION BR ON (BR.ORGANIZATION_ID = AO.BRANCH_ID)\n" +
                        "\t\tINNER JOIN TT_STATE TS_BR ON (TS_BR.STATE_ID = BR.STATE_ID)\n" +
                        "\t\tINNER JOIN TT_CITY TC_BR ON (TC_BR.CITY_ID = BR.CITY_ID)\n" +
                        "WHERE\n" +
                        "\tFBSBD.SEGMENT_REF_NO = 1\n" +
                        "        AND FB.BOOKING_STATUS IN (2 , 5, 8, 9, 12, 13, 15, 16)\n" +
                        "        AND EV.TYPE_NAME = 'BOOKING_STATUS'\n" +
                        "        AND TST.CREATION_TIME BETWEEN '2022-06-1 00:00:00' AND '2022-06-25 23:59:59'\n" +
                        "        AND APR.ORDER_TYPE = 0\n" +
                        "        AND AO.BRANCH_ID IN ('BRN3')\n" +
                        "        AND AO.AGENCY_ID = 'NULL'\n" +
                        "        \n" +
                        "GROUP BY REF , CNAME , CDATE , PTYPE , CTYPE , SDATE , TCUST , UNAME , BSTATUS , OID")
                .fetch()
                .all()
                .bufferUntilChanged(result -> result.get("REF"))
                ;
    }
    public static final  BiFunction<Row, RowMetadata, Projection> MAPPING_FUNCTION = (row, rowMetaData) -> Projection.builder()
            .AGENCYNAME(row.get("AGENCYNAME", String.class))
            .AGENCY_ID(row.get("AGENCY_ID", String.class))
            .AGENTORDERSTATUS(row.get("AGENTORDERSTATUS", Integer.class))
            .MANUAL_MARKUP(row.get("MANUAL_MARKUP",Double.class))
            .AIRLINE_PNR(row.get("AIRLINE_PNR",String.class))
            .CABIN_CLASS(row.get("CABIN_CLASS",Integer.class))
            .BOOKING_TYPE(row.get("BOOKING_TYPE",Integer.class))
            .BRANCH_ID(row.get("BRANCH_ID",String.class))
            .SUPPLIER_NAME(row.get("SUPPLIER_NAME",String.class))
            .BOOKING_CLASS(row.get("BSTATUS",String.class))
            .BOOKING_CLASS(row.get("BOOKING_CLASS",String.class))
            .NO_OF_SEGMENT(row.get("NO_OF_SEGMENT",Integer.class))
            .DESTINATION(row.get("DESTINATION",String.class))
            .PAYMENT_MODE(row.get("PAYMENT_MODE",Integer.class))
            .TRIP_TYPE(row.get("TRIP_TYPE" ,Integer.class))
            .TOTAL_BASE_FARE(row.get("TOTAL_BASE_FARE",Double.class))
            .BRANCHNAME(row.get("BRANCHNAME",String.class))
            .build();
    public Flux findAlsl() {

        String query = "SELECT \n" +
                "    FB.FB_BOOKING_REF_NO AS REF,\n" +
                "    CONCAT(FBPD.FIRST_NAME, ' ', FBPD.LAST_NAME) AS CNAME,\n" +
                "    FBPD.TITLE AS CTITLE,\n" +
                "    AC.CITY AS CCITY,\n" +
                "\tFBPD.NATIONALITY AS CCOUNTRY,\n" +
                "    FBPD.MOBILE_NO AS CMOBILE,\n" +
                "    FBPD.EMAIL_ID AS CEMAIL,\n" +
                "    FBSBD.TICKET_NO,\n" +
                "    FS.AIRLINE_PNR,\n" +
                "    FS.SP_PNR,\n" +
                "    FB.TRIP_TYPE,\n" +
                "    FB.ORIGIN,\n" +
                "    FB.DESTINATION,\n" +
                "    FB.NO_OF_SEGMENT,\n" +
                "    FS.BOOKING_CLASS,\n" +
                "    FS.CABIN_CLASS,\n" +
                "    FB.SUPPLIER_NAME,\n" +
                "    FB.TOTAL_BASE_FARE,\n" +
                "    FB.TOTAL_FEE_N_TAXES,\n" +
                "    FB.TOTAL_ODEYSYS_MARKUP,\n" +
                "    FB.TOTAL_ODEYSYS_SERVICE_CHARGE,\n" +
                "    FB.TOTAL_ODEYSYS_DISCOUNT,\n" +
                "    FI.ODEYSYS_BSP_COMMISION,\n" +
                "    FI.ODEYSYS_BSP_COMMISSION_PER,\n" +
                "    FB.TOTAL_ODEYSYS_AGENCY_MARKUP,\n" +
                "    FB.TOTAL_ODEYSYS_AGENT_ONFLY_MARKUP,\n" +
                "    FB.TOTAL_ODEYSYS_FARE,\n" +
                "    TST.PAYMENT_MODE, \n" +
                "    TST.CREATION_TIME AS PTIME,\n" +
                "    AO.AGENCY_ID,\n" +
                "    AO.BRANCH_ID,\n" +
                "    FB.CREATION_TIME AS CDATE,\n" +
                "    APR.ORDER_TYPE AS PTYPE,\n" +
                "    AC.CUSTOMER_TYPE AS CTYPE,\n" +
                "    (SELECT SUBFS.TRAVEL_DATE FROM TT_TS_FB_SEGMENT_DETAIL SUBFS WHERE SUBFS.FB_BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND SUBFS.SEGMENT_NO = 1) AS SDATE,\n" +
                "    FB.NO_OF_PASSENGER AS TCUST,\n" +
                "    U.FIRST_NAME AS UNAME,\n" +
                "    EV.VALUE AS BSTATUS ,\n" +
                "    FB.ORDER_ID AS OID,\n" +
                "    FI.INVOICE_NUMBER,\n" +
                "\tFBPD.DOB,\n" +
                "    (SELECT REFUND_AMOUNT FROM REFUND_DETAILS WHERE BOOKING_REF_NO = FB.FB_BOOKING_REF_NO LIMIT 1) AS REFUNDAMOUNT,\n" +
                "    (SELECT CD.CANCELLATION_CHARGES FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID AND CD.PASSENGER_NO = FBPD.PASSENGER_NO LIMIT 1) AS REFUNDCANCELATIONAMOUNT,\n" +
                "    (SELECT TU.GROUP_NAME FROM WONDERDB.TT_ORGANIZATION TTO, TT_USER_GROUP TU WHERE TTO.GROUP_ID = TU.GROUP_ID AND TTO.ORGANIZATION_ID = AO.AGENCY_ID) AS AGENCYNAME,\n" +
                "    FB.TOTAL_ODEYSYS_BRANCH_ONFLY_MARKUP,\n" +
                "    FB.BOOKING_TYPE,\n" +
                "    FB.IMPORT_PNR_CASE,\n" +
                "    FI.ODEYSYS_BSP_COMMISSION_PER_CHILD,\n" +
                "    FI.ODEYSYS_BSP_COMMISION_CHILD,\n" +
                "    FBSBD.PAX_BASE_FARE,\n" +
                "    FBSBD.PAX_FEE_N_TAXES,\n" +
                "    FBSBD.PAX_ODEYSYS_MARKUP,\n" +
                "    FBSBD.PAX_ODEYSYS_SERVICE_CHARGE,\n" +
                "    FBSBD.PAX_ODEYSYS_DISCOUNT,\n" +
                "    (SELECT COUNT(*) FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID) TCPAX,\n" +
                "    (SELECT OFD.IATA_NUMBER FROM TT_ORG_FIN_DETAIL OFD WHERE OFD.ORGANIZATION_ID = AO.AGENCY_ID) AS IATANUMBER,\n" +
                "    (SELECT TU.GROUP_NAME FROM WONDERDB.TT_ORGANIZATION TTO, TT_USER_GROUP TU WHERE TTO.GROUP_ID = TU.GROUP_ID AND TTO.ORGANIZATION_ID = AO.BRANCH_ID) AS BRANCHNAME,\n" +
                "    (SELECT CD.REFUND_STATUS FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID AND CD.PASSENGER_NO = FBPD.PASSENGER_NO LIMIT 1 ) AS REFUNDSTATUS,    \n" +
                "     APR.AGENT_BOOKING_STATUS AGENTORDERSTATUS,\n" +
                "    (SELECT SUM(FPS.SSR_AMOUNT) FROM TT_TS_FB_PASSENGER_SSR FPS WHERE FBPD.PASSENGER_NO = FPS.PASSENGER_NO AND FBPD.FB_BOOKING_REF_NO = FPS.FB_BOOKING_REF_NO GROUP BY FPS.FB_BOOKING_REF_NO) AS SSRAMOUNT,\n" +
                "    (SELECT CREATION_TIME FROM REFUND_DETAILS WHERE BOOKING_REF_NO = FB.FB_BOOKING_REF_NO LIMIT 1 ) AS REFUNDDATE,\n" +
                "    FI.MANUAL_MARKUP,\n" +
                "    (SELECT TTCV.VALUE FROM TT_TS_SUPPLIER_CREDENTIAL_VALUES TTCV, TT_TS_SUPPLIER_CREDENTIAL_FIELDS TTFI WHERE TTFI.CREDENTIAL_FIELD_NAME = 'IATA_NUMBER' AND TTCV.CREDENTIAL_ID = FI.TICKETING_PCC_ID AND TTCV.CREDENTIAL_FIELD_ID = TTFI.CREDENTIAL_FIELD_ID LIMIT 1) AS PCCIATANUMBER,\n" +
                "\tU.USER_ALIAS AS NDCSTAFFNAME,\n" +
                "\tIFNULL(FB.TOTAL_SURCHARGE_AMOUNT, 0.0) TOTAL_SURCHARGE_AMOUNT,\n" +
                "\tTS.STATE_NAME,\n" +
                "\tTC.CITY_NAME\n" +
                "FROM\n" +
                "    TT_TS_FLIGHT_BOOK FB\n" +
                "        INNER JOIN TT_TS_AGENT_ORDER AO ON FB.ORDER_ID = AO.ORDER_ID\n" +
                "        INNER JOIN TT_TS_AGENT_ORDER_CUSTOMER AC ON AO.ID = AC.ID\n" +
                "        INNER JOIN TT_TS_AGENT_ORDER_PRODUCT_REF APR ON AO.ID = APR.ID\n" +
                "        INNER JOIN TT_TS_TRANSACTION TST ON FB.ORDER_ID = TST.ORDER_ID\n" +
                "        INNER JOIN TT_TS_FB_INVOICE_DETAIL FI ON FB.FB_BOOKING_REF_NO = FI.FB_BOOKING_REF_NO\n" +
                "        INNER JOIN TT_TS_FB_SEGMENT_DETAIL FS ON FB.FB_BOOKING_REF_NO = FS.FB_BOOKING_REF_NO\n" +
                "        INNER JOIN TT_TS_FB_PASSENGER_DETAIL FBPD ON FB.FB_BOOKING_REF_NO = FBPD.FB_BOOKING_REF_NO\n" +
                "        INNER JOIN TT_TS_FB_PAX_SEG_BOOK_DETAIL FBSBD ON FB.FB_BOOKING_REF_NO = FBSBD.FB_BOOKING_REF_NO AND FBSBD.PASSENGER_NO = FBPD.PASSENGER_NO\n" +
                "        INNER JOIN TT_ENUM_VALUES EV ON EV.INT_CODE = FBSBD.TICKET_BOOKING_STATUS\n" +
                "        INNER JOIN TT_USER U ON FB.CREATED_BY = U.USER_ID\n" +
                "        INNER JOIN TT_ORGANIZATION AGN ON (AGN.ORGANIZATION_ID = AO.AGENCY_ID)\n" +
                "        INNER JOIN TT_STATE TS ON (TS.STATE_ID = AGN.STATE_ID)\n" +
                "\t\tINNER JOIN TT_CITY TC ON (TC.CITY_ID = AGN.CITY_ID)\n" +
                "WHERE\n" +
                "\tFBSBD.SEGMENT_REF_NO = 1\n" +
                "        AND FB.BOOKING_STATUS IN (2 , 5, 8, 9, 12, 13, 15, 16)\n" +
                "        AND EV.TYPE_NAME = 'BOOKING_STATUS'\n" +
                "        AND TST.CREATION_TIME BETWEEN '2022-06-1 00:00:00' AND '2022-06-25 23:59:59'\n" +
                "        AND APR.ORDER_TYPE = 0\n" +
                "        AND (AO.AGENCY_ID IN ('AGN3' , 'AGN14',\n" +
                "        'AGN34',\n" +
                "        'AGN35',\n" +
                "        'AGN50',\n" +
                "        'AGN59',\n" +
                "        'AGN60',\n" +
                "        'AGN62',\n" +
                "        'AGN92',\n" +
                "        'AGN93',\n" +
                "        'AGN97',\n" +
                "        'AGN104',\n" +
                "        'AGN107',\n" +
                "        'AGN110',\n" +
                "        'AGN120',\n" +
                "        'AGN127',\n" +
                "        'AGN139',\n" +
                "        'AGN144',\n" +
                "        'AGN147',\n" +
                "        'AGN148',\n" +
                "        'AGN154')\n" +
                "        )\n" +
                "GROUP BY REF , CNAME , CDATE , PTYPE , CTYPE , SDATE , TCUST , UNAME , BSTATUS , OID\n" +
                "UNION\n" +
                "SELECT \n" +
                "\t FB.FB_BOOKING_REF_NO AS REF,\n" +
                "    CONCAT(FBPD.FIRST_NAME, ' ', FBPD.LAST_NAME) AS CNAME,\n" +
                "    FBPD.TITLE AS CTITLE,\n" +
                "    AC.CITY AS CCITY,\n" +
                "\tFBPD.NATIONALITY AS CCOUNTRY,\n" +
                "    FBPD.MOBILE_NO AS CMOBILE,\n" +
                "    FBPD.EMAIL_ID AS CEMAIL,\n" +
                "    FBSBD.TICKET_NO,\n" +
                "    FS.AIRLINE_PNR,\n" +
                "    FS.SP_PNR,\n" +
                "    FB.TRIP_TYPE,\n" +
                "    FB.ORIGIN,\n" +
                "    FB.DESTINATION,\n" +
                "    FB.NO_OF_SEGMENT,\n" +
                "    FS.BOOKING_CLASS,\n" +
                "    FS.CABIN_CLASS,\n" +
                "    FB.SUPPLIER_NAME,\n" +
                "    FB.TOTAL_BASE_FARE,\n" +
                "    FB.TOTAL_FEE_N_TAXES,\n" +
                "    FB.TOTAL_ODEYSYS_MARKUP,\n" +
                "    FB.TOTAL_ODEYSYS_SERVICE_CHARGE,\n" +
                "    FB.TOTAL_ODEYSYS_DISCOUNT,\n" +
                "    FI.ODEYSYS_BSP_COMMISION,\n" +
                "    FI.ODEYSYS_BSP_COMMISSION_PER,\n" +
                "    FB.TOTAL_ODEYSYS_AGENCY_MARKUP,\n" +
                "    FB.TOTAL_ODEYSYS_AGENT_ONFLY_MARKUP,\n" +
                "    FB.TOTAL_ODEYSYS_FARE,\n" +
                "    TST.PAYMENT_MODE, \n" +
                "    TST.CREATION_TIME AS PTIME,\n" +
                "    AO.AGENCY_ID,\n" +
                "    AO.BRANCH_ID,\n" +
                "    FB.CREATION_TIME AS CDATE,\n" +
                "    APR.ORDER_TYPE AS PTYPE,\n" +
                "    AC.CUSTOMER_TYPE AS CTYPE,\n" +
                "    (SELECT SUBFS.TRAVEL_DATE FROM TT_TS_FB_SEGMENT_DETAIL SUBFS WHERE SUBFS.FB_BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND SUBFS.SEGMENT_NO = 1) AS SDATE,\n" +
                "    FB.NO_OF_PASSENGER AS TCUST,\n" +
                "    U.FIRST_NAME AS UNAME,\n" +
                "    EV.VALUE AS BSTATUS ,\n" +
                "    FB.ORDER_ID AS OID,\n" +
                "    FI.INVOICE_NUMBER,\n" +
                "\tFBPD.DOB,\n" +
                "    (SELECT REFUND_AMOUNT FROM REFUND_DETAILS WHERE BOOKING_REF_NO = FB.FB_BOOKING_REF_NO LIMIT 1) AS REFUNDAMOUNT,\n" +
                "    (SELECT CD.CANCELLATION_CHARGES FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID AND CD.PASSENGER_NO = FBPD.PASSENGER_NO LIMIT 1) AS REFUNDCANCELATIONAMOUNT,\n" +
                "    (SELECT TU.GROUP_NAME FROM WONDERDB.TT_ORGANIZATION TTO, TT_USER_GROUP TU WHERE TTO.GROUP_ID = TU.GROUP_ID AND TTO.ORGANIZATION_ID = AO.AGENCY_ID) AS AGENCYNAME,\n" +
                "    FB.TOTAL_ODEYSYS_BRANCH_ONFLY_MARKUP,\n" +
                "    FB.BOOKING_TYPE,\n" +
                "    FB.IMPORT_PNR_CASE,\n" +
                "    FI.ODEYSYS_BSP_COMMISSION_PER_CHILD,\n" +
                "    FI.ODEYSYS_BSP_COMMISION_CHILD,\n" +
                "    FBSBD.PAX_BASE_FARE,\n" +
                "    FBSBD.PAX_FEE_N_TAXES,\n" +
                "    FBSBD.PAX_ODEYSYS_MARKUP,\n" +
                "    FBSBD.PAX_ODEYSYS_SERVICE_CHARGE,\n" +
                "    FBSBD.PAX_ODEYSYS_DISCOUNT,\n" +
                "    (SELECT COUNT(*) FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID) TCPAX,\n" +
                "    (SELECT OFD.IATA_NUMBER FROM TT_ORG_FIN_DETAIL OFD WHERE OFD.ORGANIZATION_ID = AO.AGENCY_ID) AS IATANUMBER,\n" +
                "    (SELECT TU.GROUP_NAME FROM WONDERDB.TT_ORGANIZATION TTO, TT_USER_GROUP TU WHERE TTO.GROUP_ID = TU.GROUP_ID AND TTO.ORGANIZATION_ID = AO.BRANCH_ID) AS BRANCHNAME,\n" +
                "    (SELECT CD.REFUND_STATUS FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID AND CD.PASSENGER_NO = FBPD.PASSENGER_NO LIMIT 1 ) AS REFUNDSTATUS,    \n" +
                "     APR.AGENT_BOOKING_STATUS AGENTORDERSTATUS,\n" +
                "    (SELECT SUM(FPS.SSR_AMOUNT) FROM TT_TS_FB_PASSENGER_SSR FPS WHERE FBPD.PASSENGER_NO = FPS.PASSENGER_NO AND FBPD.FB_BOOKING_REF_NO = FPS.FB_BOOKING_REF_NO GROUP BY FPS.FB_BOOKING_REF_NO) AS SSRAMOUNT,\n" +
                "    (SELECT CREATION_TIME FROM REFUND_DETAILS WHERE BOOKING_REF_NO = FB.FB_BOOKING_REF_NO LIMIT 1 ) AS REFUNDDATE,\n" +
                "    FI.MANUAL_MARKUP,\n" +
                "    (SELECT TTCV.VALUE FROM TT_TS_SUPPLIER_CREDENTIAL_VALUES TTCV, TT_TS_SUPPLIER_CREDENTIAL_FIELDS TTFI WHERE TTFI.CREDENTIAL_FIELD_NAME = 'IATA_NUMBER' AND TTCV.CREDENTIAL_ID = FI.TICKETING_PCC_ID AND TTCV.CREDENTIAL_FIELD_ID = TTFI.CREDENTIAL_FIELD_ID LIMIT 1) AS PCCIATANUMBER,\n" +
                "\tU.USER_ALIAS AS NDCSTAFFNAME,\n" +
                "\tIFNULL(FB.TOTAL_SURCHARGE_AMOUNT, 0.0) TOTAL_SURCHARGE_AMOUNT,\n" +
                "\tTS_BR.STATE_NAME,\n" +
                "\tTC_BR.CITY_NAME\n" +
                "FROM\n" +
                "    TT_TS_FLIGHT_BOOK FB\n" +
                "        INNER JOIN TT_TS_AGENT_ORDER AO ON FB.ORDER_ID = AO.ORDER_ID\n" +
                "        INNER JOIN TT_TS_AGENT_ORDER_CUSTOMER AC ON AO.ID = AC.ID\n" +
                "        INNER JOIN TT_TS_AGENT_ORDER_PRODUCT_REF APR ON AO.ID = APR.ID\n" +
                "        INNER JOIN TT_TS_TRANSACTION TST ON FB.ORDER_ID = TST.ORDER_ID\n" +
                "        INNER JOIN TT_TS_FB_INVOICE_DETAIL FI ON FB.FB_BOOKING_REF_NO = FI.FB_BOOKING_REF_NO\n" +
                "        INNER JOIN TT_TS_FB_SEGMENT_DETAIL FS ON FB.FB_BOOKING_REF_NO = FS.FB_BOOKING_REF_NO\n" +
                "        INNER JOIN TT_TS_FB_PASSENGER_DETAIL FBPD ON FB.FB_BOOKING_REF_NO = FBPD.FB_BOOKING_REF_NO\n" +
                "        INNER JOIN TT_TS_FB_PAX_SEG_BOOK_DETAIL FBSBD ON FB.FB_BOOKING_REF_NO = FBSBD.FB_BOOKING_REF_NO AND FBSBD.PASSENGER_NO = FBPD.PASSENGER_NO\n" +
                "        INNER JOIN TT_ENUM_VALUES EV ON EV.INT_CODE = FBSBD.TICKET_BOOKING_STATUS\n" +
                "        INNER JOIN TT_USER U ON FB.CREATED_BY = U.USER_ID\n" +
                "\t\tINNER JOIN TT_ORGANIZATION BR ON (BR.ORGANIZATION_ID = AO.BRANCH_ID)\n" +
                "\t\tINNER JOIN TT_STATE TS_BR ON (TS_BR.STATE_ID = BR.STATE_ID)\n" +
                "\t\tINNER JOIN TT_CITY TC_BR ON (TC_BR.CITY_ID = BR.CITY_ID)\n" +
                "WHERE\n" +
                "\tFBSBD.SEGMENT_REF_NO = 1\n" +
                "        AND FB.BOOKING_STATUS IN (2 , 5, 8, 9, 12, 13, 15, 16)\n" +
                "        AND EV.TYPE_NAME = 'BOOKING_STATUS'\n" +
                "        AND TST.CREATION_TIME BETWEEN '2022-06-1 00:00:00' AND '2022-06-25 23:59:59'\n" +
                "        AND APR.ORDER_TYPE = 0\n" +
                "        AND AO.BRANCH_ID IN ('BRN3')\n" +
                "        AND AO.AGENCY_ID IS NULL\n" +
                "GROUP BY REF , CNAME , CDATE , PTYPE , CTYPE , SDATE , TCUST , UNAME , BSTATUS , OID        \n" +
                "UNION\n" +
                "SELECT \n" +
                "\t FB.FB_BOOKING_REF_NO AS REF,\n" +
                "    CONCAT(FBPD.FIRST_NAME, ' ', FBPD.LAST_NAME) AS CNAME,\n" +
                "    FBPD.TITLE AS CTITLE,\n" +
                "    AC.CITY AS CCITY,\n" +
                "\tFBPD.NATIONALITY AS CCOUNTRY,\n" +
                "    FBPD.MOBILE_NO AS CMOBILE,\n" +
                "    FBPD.EMAIL_ID AS CEMAIL,\n" +
                "    FBSBD.TICKET_NO,\n" +
                "    FS.AIRLINE_PNR,\n" +
                "    FS.SP_PNR,\n" +
                "    FB.TRIP_TYPE,\n" +
                "    FB.ORIGIN,\n" +
                "    FB.DESTINATION,\n" +
                "    FB.NO_OF_SEGMENT,\n" +
                "    FS.BOOKING_CLASS,\n" +
                "    FS.CABIN_CLASS,\n" +
                "    FB.SUPPLIER_NAME,\n" +
                "    FB.TOTAL_BASE_FARE,\n" +
                "    FB.TOTAL_FEE_N_TAXES,\n" +
                "    FB.TOTAL_ODEYSYS_MARKUP,\n" +
                "    FB.TOTAL_ODEYSYS_SERVICE_CHARGE,\n" +
                "    FB.TOTAL_ODEYSYS_DISCOUNT,\n" +
                "    FI.ODEYSYS_BSP_COMMISION,\n" +
                "    FI.ODEYSYS_BSP_COMMISSION_PER,\n" +
                "    FB.TOTAL_ODEYSYS_AGENCY_MARKUP,\n" +
                "    FB.TOTAL_ODEYSYS_AGENT_ONFLY_MARKUP,\n" +
                "    FB.TOTAL_ODEYSYS_FARE,\n" +
                "    TST.PAYMENT_MODE, \n" +
                "    TST.CREATION_TIME AS PTIME,\n" +
                "    AO.AGENCY_ID,\n" +
                "    AO.BRANCH_ID,\n" +
                "    FB.CREATION_TIME AS CDATE,\n" +
                "    APR.ORDER_TYPE AS PTYPE,\n" +
                "    AC.CUSTOMER_TYPE AS CTYPE,\n" +
                "    (SELECT SUBFS.TRAVEL_DATE FROM TT_TS_FB_SEGMENT_DETAIL SUBFS WHERE SUBFS.FB_BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND SUBFS.SEGMENT_NO = 1) AS SDATE,\n" +
                "    FB.NO_OF_PASSENGER AS TCUST,\n" +
                "    U.FIRST_NAME AS UNAME,\n" +
                "    EV.VALUE AS BSTATUS ,\n" +
                "    FB.ORDER_ID AS OID,\n" +
                "    FI.INVOICE_NUMBER,\n" +
                "\tFBPD.DOB,\n" +
                "    (SELECT REFUND_AMOUNT FROM REFUND_DETAILS WHERE BOOKING_REF_NO = FB.FB_BOOKING_REF_NO LIMIT 1) AS REFUNDAMOUNT,\n" +
                "    (SELECT CD.CANCELLATION_CHARGES FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID AND CD.PASSENGER_NO = FBPD.PASSENGER_NO LIMIT 1) AS REFUNDCANCELATIONAMOUNT,\n" +
                "    (SELECT TU.GROUP_NAME FROM WONDERDB.TT_ORGANIZATION TTO, TT_USER_GROUP TU WHERE TTO.GROUP_ID = TU.GROUP_ID AND TTO.ORGANIZATION_ID = AO.AGENCY_ID) AS AGENCYNAME,\n" +
                "    FB.TOTAL_ODEYSYS_BRANCH_ONFLY_MARKUP,\n" +
                "    FB.BOOKING_TYPE,\n" +
                "    FB.IMPORT_PNR_CASE,\n" +
                "    FI.ODEYSYS_BSP_COMMISSION_PER_CHILD,\n" +
                "    FI.ODEYSYS_BSP_COMMISION_CHILD,\n" +
                "    FBSBD.PAX_BASE_FARE,\n" +
                "    FBSBD.PAX_FEE_N_TAXES,\n" +
                "    FBSBD.PAX_ODEYSYS_MARKUP,\n" +
                "    FBSBD.PAX_ODEYSYS_SERVICE_CHARGE,\n" +
                "    FBSBD.PAX_ODEYSYS_DISCOUNT,\n" +
                "    (SELECT COUNT(*) FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID) TCPAX,\n" +
                "    (SELECT OFD.IATA_NUMBER FROM TT_ORG_FIN_DETAIL OFD WHERE OFD.ORGANIZATION_ID = AO.AGENCY_ID) AS IATANUMBER,\n" +
                "    (SELECT TU.GROUP_NAME FROM WONDERDB.TT_ORGANIZATION TTO, TT_USER_GROUP TU WHERE TTO.GROUP_ID = TU.GROUP_ID AND TTO.ORGANIZATION_ID = AO.BRANCH_ID) AS BRANCHNAME,\n" +
                "    (SELECT CD.REFUND_STATUS FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID AND CD.PASSENGER_NO = FBPD.PASSENGER_NO LIMIT 1 ) AS REFUNDSTATUS,    \n" +
                "     APR.AGENT_BOOKING_STATUS AGENTORDERSTATUS,\n" +
                "    (SELECT SUM(FPS.SSR_AMOUNT) FROM TT_TS_FB_PASSENGER_SSR FPS WHERE FBPD.PASSENGER_NO = FPS.PASSENGER_NO AND FBPD.FB_BOOKING_REF_NO = FPS.FB_BOOKING_REF_NO GROUP BY FPS.FB_BOOKING_REF_NO) AS SSRAMOUNT,\n" +
                "    (SELECT CREATION_TIME FROM REFUND_DETAILS WHERE BOOKING_REF_NO = FB.FB_BOOKING_REF_NO LIMIT 1 ) AS REFUNDDATE,\n" +
                "    FI.MANUAL_MARKUP,\n" +
                "    (SELECT TTCV.VALUE FROM TT_TS_SUPPLIER_CREDENTIAL_VALUES TTCV, TT_TS_SUPPLIER_CREDENTIAL_FIELDS TTFI WHERE TTFI.CREDENTIAL_FIELD_NAME = 'IATA_NUMBER' AND TTCV.CREDENTIAL_ID = FI.TICKETING_PCC_ID AND TTCV.CREDENTIAL_FIELD_ID = TTFI.CREDENTIAL_FIELD_ID LIMIT 1) AS PCCIATANUMBER,\n" +
                "\tU.USER_ALIAS AS NDCSTAFFNAME,\n" +
                "\tIFNULL(FB.TOTAL_SURCHARGE_AMOUNT, 0.0) TOTAL_SURCHARGE_AMOUNT,\n" +
                "\tTS_BR.STATE_NAME,\n" +
                "\tTC_BR.CITY_NAME\n" +
                "FROM\n" +
                "    TT_TS_FLIGHT_BOOK FB\n" +
                "        INNER JOIN TT_TS_AGENT_ORDER AO ON FB.ORDER_ID = AO.ORDER_ID\n" +
                "        INNER JOIN TT_TS_AGENT_ORDER_CUSTOMER AC ON AO.ID = AC.ID\n" +
                "        INNER JOIN TT_TS_AGENT_ORDER_PRODUCT_REF APR ON AO.ID = APR.ID\n" +
                "        INNER JOIN TT_TS_TRANSACTION TST ON FB.ORDER_ID = TST.ORDER_ID\n" +
                "        INNER JOIN TT_TS_FB_INVOICE_DETAIL FI ON FB.FB_BOOKING_REF_NO = FI.FB_BOOKING_REF_NO\n" +
                "        INNER JOIN TT_TS_FB_SEGMENT_DETAIL FS ON FB.FB_BOOKING_REF_NO = FS.FB_BOOKING_REF_NO\n" +
                "        INNER JOIN TT_TS_FB_PASSENGER_DETAIL FBPD ON FB.FB_BOOKING_REF_NO = FBPD.FB_BOOKING_REF_NO\n" +
                "        INNER JOIN TT_TS_FB_PAX_SEG_BOOK_DETAIL FBSBD ON FB.FB_BOOKING_REF_NO = FBSBD.FB_BOOKING_REF_NO AND FBSBD.PASSENGER_NO = FBPD.PASSENGER_NO\n" +
                "        INNER JOIN TT_ENUM_VALUES EV ON EV.INT_CODE = FBSBD.TICKET_BOOKING_STATUS\n" +
                "        INNER JOIN TT_USER U ON FB.CREATED_BY = U.USER_ID\n" +
                "\t\tINNER JOIN TT_ORGANIZATION BR ON (BR.ORGANIZATION_ID = AO.BRANCH_ID)\n" +
                "\t\tINNER JOIN TT_STATE TS_BR ON (TS_BR.STATE_ID = BR.STATE_ID)\n" +
                "\t\tINNER JOIN TT_CITY TC_BR ON (TC_BR.CITY_ID = BR.CITY_ID)\n" +
                "WHERE\n" +
                "\tFBSBD.SEGMENT_REF_NO = 1\n" +
                "        AND FB.BOOKING_STATUS IN (2 , 5, 8, 9, 12, 13, 15, 16)\n" +
                "        AND EV.TYPE_NAME = 'BOOKING_STATUS'\n" +
                "        AND TST.CREATION_TIME BETWEEN '2022-06-1 00:00:00' AND '2022-06-25 23:59:59'\n" +
                "        AND APR.ORDER_TYPE = 0\n" +
                "        AND AO.BRANCH_ID IN ('BRN3')\n" +
                "        AND AO.AGENCY_ID = 'NULL'\n" +
                "        \n" +
                "GROUP BY REF , CNAME , CDATE , PTYPE , CTYPE , SDATE , TCUST , UNAME , BSTATUS , OID";
        return db.sql(query).map(MAPPING_FUNCTION).all().limitRate(10);

    }
}

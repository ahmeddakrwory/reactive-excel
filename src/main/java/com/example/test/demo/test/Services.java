package com.example.test.demo.test;

import com.example.test.demo.test.entitys.RvFinancialreport;
import com.example.test.demo.test.entitys.RvPnrimportHistory;
import com.example.test.demo.test.entitys.TtUser;
import com.example.test.demo.test.searchmodels.FinanceSerch;

import com.example.test.demo.test.utils.BlockingService;
import com.example.test.demo.test.utils.FinanceProjection;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.RowMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
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

//    public Flux<RvFinancialreport> getFinaceData(FinanceSerch financeSerch){
//
//        return entityTemplate.select(query(where("agencyName").in(financeSerch.getOrgname()).and("cDate").between(financeSerch.getFdate(),financeSerch.getTdate())), RvFinancialreport.class);
//    }

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
    public static final  BiFunction<Row, RowMetadata, FinanceProjection> MAPPING_FUNCTION = (row, rowMetaData) -> FinanceProjection.builder()
            .AGENCYNAME(row.get("AGENCYNAME", String.class))
            .AGENCY_ID(row.get("AGENCY_ID", String.class))
            .AGENTORDERSTATUS(row.get("AGENTORDERSTATUS", Integer.class))
            .MANUAL_MARKUP(row.get("MANUAL_MARKUP",Double.class))
            .AIRLINE_PNR(row.get("AIRLINE_PNR",String.class))
            .CABIN_CLASS(row.get("CABIN_CLASS",Integer.class))
            .BOOKING_TYPE(row.get("BOOKING_TYPE",Integer.class))
            .BRANCH_ID(row.get("BRANCH_ID",String.class))
            .SUPPLIER_NAME(row.get("SUPPLIER_NAME",String.class))
            .NO_OF_SEGMENT(row.get("NO_OF_SEGMENT",Integer.class))
            .DESTINATION(row.get("DESTINATION",String.class))
            .PAYMENT_MODE(row.get("PAYMENT_MODE",Integer.class))
            .TRIP_TYPE(row.get("TRIP_TYPE" ,Integer.class))
            .TOTAL_BASE_FARE(row.get("TOTAL_BASE_FARE",Double.class))
            .BRANCHNAME(row.get("BRANCHNAME",String.class))
            .CMOBILE(row.get("CMOBILE",String.class))
            .TCUST(row.get("TCUST", Integer.class))
            .UNAME(row.get("UNAME", String.class))
            .OID(row.get("OID", String.class))
            .INVOICE_NUMBER(row.get("INVOICE_NUMBER", String.class))
            .TOTAL_ODEYSYS_BRANCH_ONFLY_MARKUP(row.get("TOTAL_ODEYSYS_BRANCH_ONFLY_MARKUP", Double.class))

            .IMPORT_PNR_CASE(row.get("IMPORT_PNR_CASE",Integer.class))
            .PAX_ODEYSYS_SERVICE_CHARGE(row.get("PAX_ODEYSYS_SERVICE_CHARGE", Double.class))
            .PAX_ODEYSYS_MARKUP(row.get("PAX_ODEYSYS_MARKUP", Double.class))
            .TCPAX(row.get("TCPAX", Long.class))
            .MANUAL_MARKUP(row.get("MANUAL_MARKUP", Double.class))
            .CDATE(row.get("CDATE", LocalDateTime.class))
            .PTIME(row.get("PTIME",LocalDateTime.class))
            .CTITLE(row.get("CTITLE",Integer.class))
            .ODEYSYS_BSP_COMMISSION_PER(row.get("ODEYSYS_BSP_COMMISSION_PER",Double.class))
            .TOTAL_ODEYSYS_FARE(row.get("TOTAL_ODEYSYS_FARE",Double.class))
            .REFUNDDATE(row.get("REFUNDDATE" , LocalDateTime.class))
            .SSRAMOUNT(row.get("SSRAMOUNT" , Double.class))
            .STATE_NAME(row.get("STATE_NAME" , String.class))
            .NDCSTAFFNAME(row.get("NDCSTAFFNAME" , String.class))
            .TOTAL_SURCHARGE_AMOUNT(row.get("TOTAL_SURCHARGE_AMOUNT",Double.class))
            .CNAME(row.get("CNAME" , String.class))
            .BOOKING_CLASS(row.get("BOOKING_CLASS" , String.class))
            .REFUNDAMOUNT(row.get("REFUNDAMOUNT" , Double.class))
            .REF(row.get("REF" , String.class))
            .Ccity(row.get("Ccity" , String.class))
            .BSTATUS(row.get("BSTATUS", String.class))
            .CITY_NAME(row.get("CITY_NAME",String.class))
            .CCOUNTRY(row.get("CCOUNTRY" ,String.class))
            .CEMAIL(row.get("CEMAIL", String.class))
            .TICKET_NO(row.get("TICKET_NO",String.class))
            .SP_PNR(row.get("SP_PNR",String.class))
            .ORIGIN(row.get("ORIGIN", String.class))
            .TOTAL_ODEYSYS_MARKUP(row.get("TOTAL_ODEYSYS_MARKUP", Double.class))
            .TOTAL_ODEYSYS_SERVICE_CHARGE(row.get("TOTAL_ODEYSYS_SERVICE_CHARGE" , Double.class))
            .TOTAL_ODEYSYS_DISCOUNT(row.get("TOTAL_ODEYSYS_DISCOUNT",Double.class))
            .ODEYSYS_BSP_COMMISION(row.get("ODEYSYS_BSP_COMMISION" , Double.class))
            .TOTAL_ODEYSYS_AGENCY_MARKUP(row.get("TOTAL_ODEYSYS_AGENCY_MARKUP",Double.class))
            .TOTAL_ODEYSYS_AGENT_ONFLY_MARKUP(row.get("TOTAL_ODEYSYS_AGENT_ONFLY_MARKUP",Double.class))
            .CTYPE(row.get("CTYPE" , Integer.class))
            .SDATE(row.get("SDATE",LocalDateTime.class))
            .DOB(row.get("DOB",String.class))
            .PAX_FEE_N_TAXES(row.get("PAX_FEE_N_TAXES",Double.class))
            .PAX_ODEYSYS_DISCOUNT(row.get("PAX_ODEYSYS_DISCOUNT",Double.class))
            .PCCIATANUMBER(row.get("PCCIATANUMBER",String.class))
            .TOTAL_FEE_N_TAXES(row.get("TOTAL_FEE_N_TAXES",Double.class))
            .PTYPE(row.get("PTYPE",Integer.class))
            .REFUNDCANCELATIONAMOUNT(row.get("REFUNDCANCELATIONAMOUNT",Double.class))
            .ODEYSYS_BSP_COMMISSION_PER_CHILD(row.get("ODEYSYS_BSP_COMMISSION_PER_CHILD", Double.class))
            .ODEYSYS_BSP_COMMISION_CHILD(row.get("ODEYSYS_BSP_COMMISION_CHILD", Double.class))
            .PAX_BASE_FARE(row.get("PAX_BASE_FARE",Double.class))




            .build();
    public Flux <FinanceProjection>findAlsl(FinanceSerch  financeSerch) {

//        String query = "SELECT \n" +
//                "    FB.FB_BOOKING_REF_NO AS REF,\n" +
//                "    CONCAT(FBPD.FIRST_NAME, ' ', FBPD.LAST_NAME) AS CNAME,\n" +
//                "    FBPD.TITLE AS CTITLE,\n" +
//                "    AC.CITY AS CCITY,\n" +
//                "\tFBPD.NATIONALITY AS CCOUNTRY,\n" +
//                "    FBPD.MOBILE_NO AS CMOBILE,\n" +
//                "    FBPD.EMAIL_ID AS CEMAIL,\n" +
//                "    FBSBD.TICKET_NO,\n" +
//                "    FS.AIRLINE_PNR,\n" +
//                "    FS.SP_PNR,\n" +
//                "    FB.TRIP_TYPE,\n" +
//                "    FB.ORIGIN,\n" +
//                "    FB.DESTINATION,\n" +
//                "    FB.NO_OF_SEGMENT,\n" +
//                "    FS.BOOKING_CLASS,\n" +
//                "    FS.CABIN_CLASS,\n" +
//                "    FB.SUPPLIER_NAME,\n" +
//                "    FB.TOTAL_BASE_FARE,\n" +
//                "    FB.TOTAL_FEE_N_TAXES,\n" +
//                "    FB.TOTAL_ODEYSYS_MARKUP,\n" +
//                "    FB.TOTAL_ODEYSYS_SERVICE_CHARGE,\n" +
//                "    FB.TOTAL_ODEYSYS_DISCOUNT,\n" +
//                "    FI.ODEYSYS_BSP_COMMISION,\n" +
//                "    FI.ODEYSYS_BSP_COMMISSION_PER,\n" +
//                "    FB.TOTAL_ODEYSYS_AGENCY_MARKUP,\n" +
//                "    FB.TOTAL_ODEYSYS_AGENT_ONFLY_MARKUP,\n" +
//                "    FB.TOTAL_ODEYSYS_FARE,\n" +
//                "    TST.PAYMENT_MODE, \n" +
//                "    TST.CREATION_TIME AS PTIME,\n" +
//                "    AO.AGENCY_ID,\n" +
//                "    AO.BRANCH_ID,\n" +
//                "    FB.CREATION_TIME AS CDATE,\n" +
//                "    APR.ORDER_TYPE AS PTYPE,\n" +
//                "    AC.CUSTOMER_TYPE AS CTYPE,\n" +
//                "    (SELECT SUBFS.TRAVEL_DATE FROM TT_TS_FB_SEGMENT_DETAIL SUBFS WHERE SUBFS.FB_BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND SUBFS.SEGMENT_NO = 1) AS SDATE,\n" +
//                "    FB.NO_OF_PASSENGER AS TCUST,\n" +
//                "    U.FIRST_NAME AS UNAME,\n" +
//                "    EV.VALUE AS BSTATUS ,\n" +
//                "    FB.ORDER_ID AS OID,\n" +
//                "    FI.INVOICE_NUMBER,\n" +
//                "\tFBPD.DOB,\n" +
//                "    (SELECT REFUND_AMOUNT FROM REFUND_DETAILS WHERE BOOKING_REF_NO = FB.FB_BOOKING_REF_NO LIMIT 1) AS REFUNDAMOUNT,\n" +
//                "    (SELECT CD.CANCELLATION_CHARGES FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID AND CD.PASSENGER_NO = FBPD.PASSENGER_NO LIMIT 1) AS REFUNDCANCELATIONAMOUNT,\n" +
//                "    (SELECT TU.GROUP_NAME FROM WONDERDB.TT_ORGANIZATION TTO, TT_USER_GROUP TU WHERE TTO.GROUP_ID = TU.GROUP_ID AND TTO.ORGANIZATION_ID = AO.AGENCY_ID) AS AGENCYNAME,\n" +
//                "    FB.TOTAL_ODEYSYS_BRANCH_ONFLY_MARKUP,\n" +
//                "    FB.BOOKING_TYPE,\n" +
//                "    FB.IMPORT_PNR_CASE,\n" +
//                "    FI.ODEYSYS_BSP_COMMISSION_PER_CHILD,\n" +
//                "    FI.ODEYSYS_BSP_COMMISION_CHILD,\n" +
//                "    FBSBD.PAX_BASE_FARE,\n" +
//                "    FBSBD.PAX_FEE_N_TAXES,\n" +
//                "    FBSBD.PAX_ODEYSYS_MARKUP,\n" +
//                "    FBSBD.PAX_ODEYSYS_SERVICE_CHARGE,\n" +
//                "    FBSBD.PAX_ODEYSYS_DISCOUNT,\n" +
//                "    (SELECT COUNT(*) FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID) TCPAX,\n" +
//                "    (SELECT OFD.IATA_NUMBER FROM TT_ORG_FIN_DETAIL OFD WHERE OFD.ORGANIZATION_ID = AO.AGENCY_ID) AS IATANUMBER,\n" +
//                "    (SELECT TU.GROUP_NAME FROM WONDERDB.TT_ORGANIZATION TTO, TT_USER_GROUP TU WHERE TTO.GROUP_ID = TU.GROUP_ID AND TTO.ORGANIZATION_ID = AO.BRANCH_ID) AS BRANCHNAME,\n" +
//                "    (SELECT CD.REFUND_STATUS FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID AND CD.PASSENGER_NO = FBPD.PASSENGER_NO LIMIT 1 ) AS REFUNDSTATUS,    \n" +
//                "     APR.AGENT_BOOKING_STATUS AGENTORDERSTATUS,\n" +
//                "    (SELECT SUM(FPS.SSR_AMOUNT) FROM TT_TS_FB_PASSENGER_SSR FPS WHERE FBPD.PASSENGER_NO = FPS.PASSENGER_NO AND FBPD.FB_BOOKING_REF_NO = FPS.FB_BOOKING_REF_NO GROUP BY FPS.FB_BOOKING_REF_NO) AS SSRAMOUNT,\n" +
//                "    (SELECT CREATION_TIME FROM REFUND_DETAILS WHERE BOOKING_REF_NO = FB.FB_BOOKING_REF_NO LIMIT 1 ) AS REFUNDDATE,\n" +
//                "    FI.MANUAL_MARKUP,\n" +
//                "    (SELECT TTCV.VALUE FROM TT_TS_SUPPLIER_CREDENTIAL_VALUES TTCV, TT_TS_SUPPLIER_CREDENTIAL_FIELDS TTFI WHERE TTFI.CREDENTIAL_FIELD_NAME = 'IATA_NUMBER' AND TTCV.CREDENTIAL_ID = FI.TICKETING_PCC_ID AND TTCV.CREDENTIAL_FIELD_ID = TTFI.CREDENTIAL_FIELD_ID LIMIT 1) AS PCCIATANUMBER,\n" +
//                "\tU.USER_ALIAS AS NDCSTAFFNAME,\n" +
//                "\tIFNULL(FB.TOTAL_SURCHARGE_AMOUNT, 0.0) TOTAL_SURCHARGE_AMOUNT,\n" +
//                "\tTS.STATE_NAME,\n" +
//                "\tTC.CITY_NAME\n" +
//                "FROM\n" +
//                "    TT_TS_FLIGHT_BOOK FB\n" +
//                "        INNER JOIN TT_TS_AGENT_ORDER AO ON FB.ORDER_ID = AO.ORDER_ID\n" +
//                "        INNER JOIN TT_TS_AGENT_ORDER_CUSTOMER AC ON AO.ID = AC.ID\n" +
//                "        INNER JOIN TT_TS_AGENT_ORDER_PRODUCT_REF APR ON AO.ID = APR.ID\n" +
//                "        INNER JOIN TT_TS_TRANSACTION TST ON FB.ORDER_ID = TST.ORDER_ID\n" +
//                "        INNER JOIN TT_TS_FB_INVOICE_DETAIL FI ON FB.FB_BOOKING_REF_NO = FI.FB_BOOKING_REF_NO\n" +
//                "        INNER JOIN TT_TS_FB_SEGMENT_DETAIL FS ON FB.FB_BOOKING_REF_NO = FS.FB_BOOKING_REF_NO\n" +
//                "        INNER JOIN TT_TS_FB_PASSENGER_DETAIL FBPD ON FB.FB_BOOKING_REF_NO = FBPD.FB_BOOKING_REF_NO\n" +
//                "        INNER JOIN TT_TS_FB_PAX_SEG_BOOK_DETAIL FBSBD ON FB.FB_BOOKING_REF_NO = FBSBD.FB_BOOKING_REF_NO AND FBSBD.PASSENGER_NO = FBPD.PASSENGER_NO\n" +
//                "        INNER JOIN TT_ENUM_VALUES EV ON EV.INT_CODE = FBSBD.TICKET_BOOKING_STATUS\n" +
//                "        INNER JOIN TT_USER U ON FB.CREATED_BY = U.USER_ID\n" +
//                "        INNER JOIN TT_ORGANIZATION AGN ON (AGN.ORGANIZATION_ID = AO.AGENCY_ID)\n" +
//                "        INNER JOIN TT_STATE TS ON (TS.STATE_ID = AGN.STATE_ID)\n" +
//                "\t\tINNER JOIN TT_CITY TC ON (TC.CITY_ID = AGN.CITY_ID)\n" +
//                "WHERE\n" +
//                "\tFBSBD.SEGMENT_REF_NO = 1\n" +
//                "        AND FB.BOOKING_STATUS IN (2 , 5, 8, 9, 12, 13, 15, 16)\n" +
//                "        AND EV.TYPE_NAME = 'BOOKING_STATUS'\n" +
//                "        AND TST.CREATION_TIME BETWEEN    "+ financeSerch.getFdate()+" "+ " AND "+financeSerch.getTdate()+"  " +
//                "        AND APR.ORDER_TYPE = 0\n" +
//                "        AND (AO.AGENCY_ID IN"+ "("+ financeSerch.getId()+"     "+")"+")"
//
//                +
//                "GROUP BY REF , CNAME , CDATE , PTYPE , CTYPE , SDATE , TCUST , UNAME , BSTATUS , OID\n" +
//                "UNION\n" +
//                "SELECT \n" +
//                "\t FB.FB_BOOKING_REF_NO AS REF,\n" +
//                "    CONCAT(FBPD.FIRST_NAME, ' ', FBPD.LAST_NAME) AS CNAME,\n" +
//                "    FBPD.TITLE AS CTITLE,\n" +
//                "    AC.CITY AS CCITY,\n" +
//                "\tFBPD.NATIONALITY AS CCOUNTRY,\n" +
//                "    FBPD.MOBILE_NO AS CMOBILE,\n" +
//                "    FBPD.EMAIL_ID AS CEMAIL,\n" +
//                "    FBSBD.TICKET_NO,\n" +
//                "    FS.AIRLINE_PNR,\n" +
//                "    FS.SP_PNR,\n" +
//                "    FB.TRIP_TYPE,\n" +
//                "    FB.ORIGIN,\n" +
//                "    FB.DESTINATION,\n" +
//                "    FB.NO_OF_SEGMENT,\n" +
//                "    FS.BOOKING_CLASS,\n" +
//                "    FS.CABIN_CLASS,\n" +
//                "    FB.SUPPLIER_NAME,\n" +
//                "    FB.TOTAL_BASE_FARE,\n" +
//                "    FB.TOTAL_FEE_N_TAXES,\n" +
//                "    FB.TOTAL_ODEYSYS_MARKUP,\n" +
//                "    FB.TOTAL_ODEYSYS_SERVICE_CHARGE,\n" +
//                "    FB.TOTAL_ODEYSYS_DISCOUNT,\n" +
//                "    FI.ODEYSYS_BSP_COMMISION,\n" +
//                "    FI.ODEYSYS_BSP_COMMISSION_PER,\n" +
//                "    FB.TOTAL_ODEYSYS_AGENCY_MARKUP,\n" +
//                "    FB.TOTAL_ODEYSYS_AGENT_ONFLY_MARKUP,\n" +
//                "    FB.TOTAL_ODEYSYS_FARE,\n" +
//                "    TST.PAYMENT_MODE, \n" +
//                "    TST.CREATION_TIME AS PTIME,\n" +
//                "    AO.AGENCY_ID,\n" +
//                "    AO.BRANCH_ID,\n" +
//                "    FB.CREATION_TIME AS CDATE,\n" +
//                "    APR.ORDER_TYPE AS PTYPE,\n" +
//                "    AC.CUSTOMER_TYPE AS CTYPE,\n" +
//                "    (SELECT SUBFS.TRAVEL_DATE FROM TT_TS_FB_SEGMENT_DETAIL SUBFS WHERE SUBFS.FB_BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND SUBFS.SEGMENT_NO = 1) AS SDATE,\n" +
//                "    FB.NO_OF_PASSENGER AS TCUST,\n" +
//                "    U.FIRST_NAME AS UNAME,\n" +
//                "    EV.VALUE AS BSTATUS ,\n" +
//                "    FB.ORDER_ID AS OID,\n" +
//                "    FI.INVOICE_NUMBER,\n" +
//                "\tFBPD.DOB,\n" +
//                "    (SELECT REFUND_AMOUNT FROM REFUND_DETAILS WHERE BOOKING_REF_NO = FB.FB_BOOKING_REF_NO LIMIT 1) AS REFUNDAMOUNT,\n" +
//                "    (SELECT CD.CANCELLATION_CHARGES FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID AND CD.PASSENGER_NO = FBPD.PASSENGER_NO LIMIT 1) AS REFUNDCANCELATIONAMOUNT,\n" +
//                "    (SELECT TU.GROUP_NAME FROM WONDERDB.TT_ORGANIZATION TTO, TT_USER_GROUP TU WHERE TTO.GROUP_ID = TU.GROUP_ID AND TTO.ORGANIZATION_ID = AO.AGENCY_ID) AS AGENCYNAME,\n" +
//                "    FB.TOTAL_ODEYSYS_BRANCH_ONFLY_MARKUP,\n" +
//                "    FB.BOOKING_TYPE,\n" +
//                "    FB.IMPORT_PNR_CASE,\n" +
//                "    FI.ODEYSYS_BSP_COMMISSION_PER_CHILD,\n" +
//                "    FI.ODEYSYS_BSP_COMMISION_CHILD,\n" +
//                "    FBSBD.PAX_BASE_FARE,\n" +
//                "    FBSBD.PAX_FEE_N_TAXES,\n" +
//                "    FBSBD.PAX_ODEYSYS_MARKUP,\n" +
//                "    FBSBD.PAX_ODEYSYS_SERVICE_CHARGE,\n" +
//                "    FBSBD.PAX_ODEYSYS_DISCOUNT,\n" +
//                "    (SELECT COUNT(*) FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID) TCPAX,\n" +
//                "    (SELECT OFD.IATA_NUMBER FROM TT_ORG_FIN_DETAIL OFD WHERE OFD.ORGANIZATION_ID = AO.AGENCY_ID) AS IATANUMBER,\n" +
//                "    (SELECT TU.GROUP_NAME FROM WONDERDB.TT_ORGANIZATION TTO, TT_USER_GROUP TU WHERE TTO.GROUP_ID = TU.GROUP_ID AND TTO.ORGANIZATION_ID = AO.BRANCH_ID) AS BRANCHNAME,\n" +
//                "    (SELECT CD.REFUND_STATUS FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID AND CD.PASSENGER_NO = FBPD.PASSENGER_NO LIMIT 1 ) AS REFUNDSTATUS,    \n" +
//                "     APR.AGENT_BOOKING_STATUS AGENTORDERSTATUS,\n" +
//                "    (SELECT SUM(FPS.SSR_AMOUNT) FROM TT_TS_FB_PASSENGER_SSR FPS WHERE FBPD.PASSENGER_NO = FPS.PASSENGER_NO AND FBPD.FB_BOOKING_REF_NO = FPS.FB_BOOKING_REF_NO GROUP BY FPS.FB_BOOKING_REF_NO) AS SSRAMOUNT,\n" +
//                "    (SELECT CREATION_TIME FROM REFUND_DETAILS WHERE BOOKING_REF_NO = FB.FB_BOOKING_REF_NO LIMIT 1 ) AS REFUNDDATE,\n" +
//                "    FI.MANUAL_MARKUP,\n" +
//                "    (SELECT TTCV.VALUE FROM TT_TS_SUPPLIER_CREDENTIAL_VALUES TTCV, TT_TS_SUPPLIER_CREDENTIAL_FIELDS TTFI WHERE TTFI.CREDENTIAL_FIELD_NAME = 'IATA_NUMBER' AND TTCV.CREDENTIAL_ID = FI.TICKETING_PCC_ID AND TTCV.CREDENTIAL_FIELD_ID = TTFI.CREDENTIAL_FIELD_ID LIMIT 1) AS PCCIATANUMBER,\n" +
//                "\tU.USER_ALIAS AS NDCSTAFFNAME,\n" +
//                "\tIFNULL(FB.TOTAL_SURCHARGE_AMOUNT, 0.0) TOTAL_SURCHARGE_AMOUNT,\n" +
//                "\tTS_BR.STATE_NAME,\n" +
//                "\tTC_BR.CITY_NAME\n" +
//                "FROM\n" +
//                "    TT_TS_FLIGHT_BOOK FB\n" +
//                "        INNER JOIN TT_TS_AGENT_ORDER AO ON FB.ORDER_ID = AO.ORDER_ID\n" +
//                "        INNER JOIN TT_TS_AGENT_ORDER_CUSTOMER AC ON AO.ID = AC.ID\n" +
//                "        INNER JOIN TT_TS_AGENT_ORDER_PRODUCT_REF APR ON AO.ID = APR.ID\n" +
//                "        INNER JOIN TT_TS_TRANSACTION TST ON FB.ORDER_ID = TST.ORDER_ID\n" +
//                "        INNER JOIN TT_TS_FB_INVOICE_DETAIL FI ON FB.FB_BOOKING_REF_NO = FI.FB_BOOKING_REF_NO\n" +
//                "        INNER JOIN TT_TS_FB_SEGMENT_DETAIL FS ON FB.FB_BOOKING_REF_NO = FS.FB_BOOKING_REF_NO\n" +
//                "        INNER JOIN TT_TS_FB_PASSENGER_DETAIL FBPD ON FB.FB_BOOKING_REF_NO = FBPD.FB_BOOKING_REF_NO\n" +
//                "        INNER JOIN TT_TS_FB_PAX_SEG_BOOK_DETAIL FBSBD ON FB.FB_BOOKING_REF_NO = FBSBD.FB_BOOKING_REF_NO AND FBSBD.PASSENGER_NO = FBPD.PASSENGER_NO\n" +
//                "        INNER JOIN TT_ENUM_VALUES EV ON EV.INT_CODE = FBSBD.TICKET_BOOKING_STATUS\n" +
//                "        INNER JOIN TT_USER U ON FB.CREATED_BY = U.USER_ID\n" +
//                "\t\tINNER JOIN TT_ORGANIZATION BR ON (BR.ORGANIZATION_ID = AO.BRANCH_ID)\n" +
//                "\t\tINNER JOIN TT_STATE TS_BR ON (TS_BR.STATE_ID = BR.STATE_ID)\n" +
//                "\t\tINNER JOIN TT_CITY TC_BR ON (TC_BR.CITY_ID = BR.CITY_ID)\n" +
//                "WHERE\n" +
//                "\tFBSBD.SEGMENT_REF_NO = 1\n" +
//                "        AND FB.BOOKING_STATUS IN (2 , 5, 8, 9, 12, 13, 15, 16)\n" +
//                "        AND EV.TYPE_NAME = 'BOOKING_STATUS'\n" +
//                "        AND TST.CREATION_TIME BETWEEN    "+financeSerch.getFdate()+"  AND  "+financeSerch.getTdate()+
//                "        AND APR.ORDER_TYPE = 0\n" +
//                "        AND AO.BRANCH_ID IN (" + financeSerch.getBranchId()+" )"+
//                "        AND AO.AGENCY_ID IS NULL\n" +
//                "GROUP BY REF , CNAME , CDATE , PTYPE , CTYPE , SDATE , TCUST , UNAME , BSTATUS , OID        \n" +
//                "UNION\n" +
//                "SELECT \n" +
//                "\t FB.FB_BOOKING_REF_NO AS REF,\n" +
//                "    CONCAT(FBPD.FIRST_NAME, ' ', FBPD.LAST_NAME) AS CNAME,\n" +
//                "    FBPD.TITLE AS CTITLE,\n" +
//                "    AC.CITY AS CCITY,\n" +
//                "\tFBPD.NATIONALITY AS CCOUNTRY,\n" +
//                "    FBPD.MOBILE_NO AS CMOBILE,\n" +
//                "    FBPD.EMAIL_ID AS CEMAIL,\n" +
//                "    FBSBD.TICKET_NO,\n" +
//                "    FS.AIRLINE_PNR,\n" +
//                "    FS.SP_PNR,\n" +
//                "    FB.TRIP_TYPE,\n" +
//                "    FB.ORIGIN,\n" +
//                "    FB.DESTINATION,\n" +
//                "    FB.NO_OF_SEGMENT,\n" +
//                "    FS.BOOKING_CLASS,\n" +
//                "    FS.CABIN_CLASS,\n" +
//                "    FB.SUPPLIER_NAME,\n" +
//                "    FB.TOTAL_BASE_FARE,\n" +
//                "    FB.TOTAL_FEE_N_TAXES,\n" +
//                "    FB.TOTAL_ODEYSYS_MARKUP,\n" +
//                "    FB.TOTAL_ODEYSYS_SERVICE_CHARGE,\n" +
//                "    FB.TOTAL_ODEYSYS_DISCOUNT,\n" +
//                "    FI.ODEYSYS_BSP_COMMISION,\n" +
//                "    FI.ODEYSYS_BSP_COMMISSION_PER,\n" +
//                "    FB.TOTAL_ODEYSYS_AGENCY_MARKUP,\n" +
//                "    FB.TOTAL_ODEYSYS_AGENT_ONFLY_MARKUP,\n" +
//                "    FB.TOTAL_ODEYSYS_FARE,\n" +
//                "    TST.PAYMENT_MODE, \n" +
//                "    TST.CREATION_TIME AS PTIME,\n" +
//                "    AO.AGENCY_ID,\n" +
//                "    AO.BRANCH_ID,\n" +
//                "    FB.CREATION_TIME AS CDATE,\n" +
//                "    APR.ORDER_TYPE AS PTYPE,\n" +
//                "    AC.CUSTOMER_TYPE AS CTYPE,\n" +
//                "    (SELECT SUBFS.TRAVEL_DATE FROM TT_TS_FB_SEGMENT_DETAIL SUBFS WHERE SUBFS.FB_BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND SUBFS.SEGMENT_NO = 1) AS SDATE,\n" +
//                "    FB.NO_OF_PASSENGER AS TCUST,\n" +
//                "    U.FIRST_NAME AS UNAME,\n" +
//                "    EV.VALUE AS BSTATUS ,\n" +
//                "    FB.ORDER_ID AS OID,\n" +
//                "    FI.INVOICE_NUMBER,\n" +
//                "\tFBPD.DOB,\n" +
//                "    (SELECT REFUND_AMOUNT FROM REFUND_DETAILS WHERE BOOKING_REF_NO = FB.FB_BOOKING_REF_NO LIMIT 1) AS REFUNDAMOUNT,\n" +
//                "    (SELECT CD.CANCELLATION_CHARGES FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID AND CD.PASSENGER_NO = FBPD.PASSENGER_NO LIMIT 1) AS REFUNDCANCELATIONAMOUNT,\n" +
//                "    (SELECT TU.GROUP_NAME FROM WONDERDB.TT_ORGANIZATION TTO, TT_USER_GROUP TU WHERE TTO.GROUP_ID = TU.GROUP_ID AND TTO.ORGANIZATION_ID = AO.AGENCY_ID) AS AGENCYNAME,\n" +
//                "    FB.TOTAL_ODEYSYS_BRANCH_ONFLY_MARKUP,\n" +
//                "    FB.BOOKING_TYPE,\n" +
//                "    FB.IMPORT_PNR_CASE,\n" +
//                "    FI.ODEYSYS_BSP_COMMISSION_PER_CHILD,\n" +
//                "    FI.ODEYSYS_BSP_COMMISION_CHILD,\n" +
//                "    FBSBD.PAX_BASE_FARE,\n" +
//                "    FBSBD.PAX_FEE_N_TAXES,\n" +
//                "    FBSBD.PAX_ODEYSYS_MARKUP,\n" +
//                "    FBSBD.PAX_ODEYSYS_SERVICE_CHARGE,\n" +
//                "    FBSBD.PAX_ODEYSYS_DISCOUNT,\n" +
//                "    (SELECT COUNT(*) FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID) TCPAX,\n" +
//                "    (SELECT OFD.IATA_NUMBER FROM TT_ORG_FIN_DETAIL OFD WHERE OFD.ORGANIZATION_ID = AO.AGENCY_ID) AS IATANUMBER,\n" +
//                "    (SELECT TU.GROUP_NAME FROM WONDERDB.TT_ORGANIZATION TTO, TT_USER_GROUP TU WHERE TTO.GROUP_ID = TU.GROUP_ID AND TTO.ORGANIZATION_ID = AO.BRANCH_ID) AS BRANCHNAME,\n" +
//                "    (SELECT CD.REFUND_STATUS FROM REFUND_DETAILS RD, CANCELLATION_DETAILS CD WHERE RD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO AND RD.REFUND_ID = CD.REFUND_ID AND CD.PASSENGER_NO = FBPD.PASSENGER_NO LIMIT 1 ) AS REFUNDSTATUS,    \n" +
//                "     APR.AGENT_BOOKING_STATUS AGENTORDERSTATUS,\n" +
//                "    (SELECT SUM(FPS.SSR_AMOUNT) FROM TT_TS_FB_PASSENGER_SSR FPS WHERE FBPD.PASSENGER_NO = FPS.PASSENGER_NO AND FBPD.FB_BOOKING_REF_NO = FPS.FB_BOOKING_REF_NO GROUP BY FPS.FB_BOOKING_REF_NO) AS SSRAMOUNT,\n" +
//                "    (SELECT CREATION_TIME FROM REFUND_DETAILS WHERE BOOKING_REF_NO = FB.FB_BOOKING_REF_NO LIMIT 1 ) AS REFUNDDATE,\n" +
//                "    FI.MANUAL_MARKUP,\n" +
//                "    (SELECT TTCV.VALUE FROM TT_TS_SUPPLIER_CREDENTIAL_VALUES TTCV, TT_TS_SUPPLIER_CREDENTIAL_FIELDS TTFI WHERE TTFI.CREDENTIAL_FIELD_NAME = 'IATA_NUMBER' AND TTCV.CREDENTIAL_ID = FI.TICKETING_PCC_ID AND TTCV.CREDENTIAL_FIELD_ID = TTFI.CREDENTIAL_FIELD_ID LIMIT 1) AS PCCIATANUMBER,\n" +
//                "\tU.USER_ALIAS AS NDCSTAFFNAME,\n" +
//                "\tIFNULL(FB.TOTAL_SURCHARGE_AMOUNT, 0.0) TOTAL_SURCHARGE_AMOUNT,\n" +
//                "\tTS_BR.STATE_NAME,\n" +
//                "\tTC_BR.CITY_NAME\n" +
//                "FROM\n" +
//                "    TT_TS_FLIGHT_BOOK FB\n" +
//                "        INNER JOIN TT_TS_AGENT_ORDER AO ON FB.ORDER_ID = AO.ORDER_ID\n" +
//                "        INNER JOIN TT_TS_AGENT_ORDER_CUSTOMER AC ON AO.ID = AC.ID\n" +
//                "        INNER JOIN TT_TS_AGENT_ORDER_PRODUCT_REF APR ON AO.ID = APR.ID\n" +
//                "        INNER JOIN TT_TS_TRANSACTION TST ON FB.ORDER_ID = TST.ORDER_ID\n" +
//                "        INNER JOIN TT_TS_FB_INVOICE_DETAIL FI ON FB.FB_BOOKING_REF_NO = FI.FB_BOOKING_REF_NO\n" +
//                "        INNER JOIN TT_TS_FB_SEGMENT_DETAIL FS ON FB.FB_BOOKING_REF_NO = FS.FB_BOOKING_REF_NO\n" +
//                "        INNER JOIN TT_TS_FB_PASSENGER_DETAIL FBPD ON FB.FB_BOOKING_REF_NO = FBPD.FB_BOOKING_REF_NO\n" +
//                "        INNER JOIN TT_TS_FB_PAX_SEG_BOOK_DETAIL FBSBD ON FB.FB_BOOKING_REF_NO = FBSBD.FB_BOOKING_REF_NO AND FBSBD.PASSENGER_NO = FBPD.PASSENGER_NO\n" +
//                "        INNER JOIN TT_ENUM_VALUES EV ON EV.INT_CODE = FBSBD.TICKET_BOOKING_STATUS\n" +
//                "        INNER JOIN TT_USER U ON FB.CREATED_BY = U.USER_ID\n" +
//                "\t\tINNER JOIN TT_ORGANIZATION BR ON (BR.ORGANIZATION_ID = AO.BRANCH_ID)\n" +
//                "\t\tINNER JOIN TT_STATE TS_BR ON (TS_BR.STATE_ID = BR.STATE_ID)\n" +
//                "\t\tINNER JOIN TT_CITY TC_BR ON (TC_BR.CITY_ID = BR.CITY_ID)\n" +
//                "WHERE\n" +
//                "\tFBSBD.SEGMENT_REF_NO = 1\n" +
//                "        AND FB.BOOKING_STATUS IN (2 , 5, 8, 9, 12, 13, 15, 16)\n" +
//                "        AND EV.TYPE_NAME = 'BOOKING_STATUS'\n" +
//                "        AND TST.CREATION_TIME BETWEEN '2022-06-25 00:00:00' AND '2022-06-26 23:59:59'\n" +
//                "        AND APR.ORDER_TYPE = 0\n" +
//                "        AND AO.BRANCH_ID IN ('BRN3')\n" +
//                "        AND AO.AGENCY_ID = 'NULL'\n" +
//                "        \n" +
//                "GROUP BY REF , CNAME , CDATE , PTYPE , CTYPE , SDATE , TCUST , UNAME , BSTATUS , OID;";
        Map<String, Object> paramMap = new HashMap<>();
//        List ag_list = new ArrayList<>();
        String query="select\n" +
                "\tFB.FB_BOOKING_REF_NO as ref,\n" +
                "\tCONCAT(FBPD.FIRST_NAME, ' ', FBPD.LAST_NAME) as CNAME,\n" +
                "\tFBPD.TITLE as CTITLE,\n" +
                "\tAC.CITY as CCITY,\n" +
                "\tFBPD.NATIONALITY as CCOUNTRY,\n" +
                "\tFBPD.MOBILE_NO as CMOBILE,\n" +
                "\tFBPD.EMAIL_ID as CEMAIL,\n" +
                "\tFBSBD.TICKET_NO,\n" +
                "\tFS.AIRLINE_PNR,\n" +
                "\tFS.SP_PNR,\n" +
                "\tFB.TRIP_TYPE,\n" +
                "\tFB.ORIGIN,\n" +
                "\tFB.DESTINATION,\n" +
                "\tFB.NO_OF_SEGMENT,\n" +
                "\tFS.BOOKING_CLASS,\n" +
                "\tFS.CABIN_CLASS,\n" +
                "\tFB.SUPPLIER_NAME,\n" +
                "\tFB.TOTAL_BASE_FARE,\n" +
                "\tFB.TOTAL_FEE_N_TAXES,\n" +
                "\tFB.TOTAL_ODEYSYS_MARKUP,\n" +
                "\tFB.TOTAL_ODEYSYS_SERVICE_CHARGE,\n" +
                "\tFB.TOTAL_ODEYSYS_DISCOUNT,\n" +
                "\tFI.ODEYSYS_BSP_COMMISION,\n" +
                "\tFI.ODEYSYS_BSP_COMMISSION_PER,\n" +
                "\tFB.TOTAL_ODEYSYS_AGENCY_MARKUP,\n" +
                "\tFB.TOTAL_ODEYSYS_AGENT_ONFLY_MARKUP,\n" +
                "\tFB.TOTAL_ODEYSYS_FARE,\n" +
                "\tTST.PAYMENT_MODE,\n" +
                "\tTST.CREATION_TIME as PTIME,\n" +
                "\tAO.AGENCY_ID,\n" +
                "\tAO.BRANCH_ID,\n" +
                "\tFB.CREATION_TIME as CDATE,\n" +
                "\tAPR.ORDER_TYPE as PTYPE,\n" +
                "\tAC.CUSTOMER_TYPE as CTYPE,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tSUBFS.TRAVEL_DATE\n" +
                "\tfrom\n" +
                "\t\tTT_TS_FB_SEGMENT_DETAIL SUBFS\n" +
                "\twhere\n" +
                "\t\tSUBFS.FB_BOOKING_REF_NO = FB.FB_BOOKING_REF_NO\n" +
                "\t\tand SUBFS.SEGMENT_NO = 1) as SDATE,\n" +
                "\tFB.NO_OF_PASSENGER as TCUST,\n" +
                "\tU.FIRST_NAME as UNAME,\n" +
                "\tEV.VALUE as BSTATUS,\n" +
                "\tFB.ORDER_ID as OID,\n" +
                "\tFI.INVOICE_NUMBER,\n" +
                "\tFBPD.DOB,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tREFUND_AMOUNT\n" +
                "\tfrom\n" +
                "\t\tREFUND_DETAILS\n" +
                "\twhere\n" +
                "\t\tBOOKING_REF_NO = FB.FB_BOOKING_REF_NO\n" +
                "\tlimit 1) as REFUNDAMOUNT,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tCD.CANCELLATION_CHARGES\n" +
                "\tfrom\n" +
                "\t\tREFUND_DETAILS RD,\n" +
                "\t\tCANCELLATION_DETAILS CD\n" +
                "\twhere\n" +
                "\t\tRD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO\n" +
                "\t\tand RD.REFUND_ID = CD.REFUND_ID\n" +
                "\t\tand CD.PASSENGER_NO = FBPD.PASSENGER_NO\n" +
                "\tlimit 1) as REFUNDCANCELATIONAMOUNT,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tTU.GROUP_NAME\n" +
                "\tfrom\n" +
                "\t\tWONDERDB.TT_ORGANIZATION TTO,\n" +
                "\t\tTT_USER_GROUP TU\n" +
                "\twhere\n" +
                "\t\tTTO.GROUP_ID = TU.GROUP_ID\n" +
                "\t\tand TTO.ORGANIZATION_ID = AO.AGENCY_ID) as AGENCYNAME,\n" +
                "\tFB.TOTAL_ODEYSYS_BRANCH_ONFLY_MARKUP,\n" +
                "\tFB.BOOKING_TYPE,\n" +
                "\tFB.IMPORT_PNR_CASE,\n" +
                "\tFI.ODEYSYS_BSP_COMMISSION_PER_CHILD,\n" +
                "\tFI.ODEYSYS_BSP_COMMISION_CHILD,\n" +
                "\tFBSBD.PAX_BASE_FARE,\n" +
                "\tFBSBD.PAX_FEE_N_TAXES,\n" +
                "\tFBSBD.PAX_ODEYSYS_MARKUP,\n" +
                "\tFBSBD.PAX_ODEYSYS_SERVICE_CHARGE,\n" +
                "\tFBSBD.PAX_ODEYSYS_DISCOUNT,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tCOUNT(*)\n" +
                "\tfrom\n" +
                "\t\tREFUND_DETAILS RD,\n" +
                "\t\tCANCELLATION_DETAILS CD\n" +
                "\twhere\n" +
                "\t\tRD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO\n" +
                "\t\tand RD.REFUND_ID = CD.REFUND_ID) TCPAX,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tOFD.IATA_NUMBER\n" +
                "\tfrom\n" +
                "\t\tTT_ORG_FIN_DETAIL OFD\n" +
                "\twhere\n" +
                "\t\tOFD.ORGANIZATION_ID = AO.AGENCY_ID) as IATANUMBER,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tTU.GROUP_NAME\n" +
                "\tfrom\n" +
                "\t\tWONDERDB.TT_ORGANIZATION TTO,\n" +
                "\t\tTT_USER_GROUP TU\n" +
                "\twhere\n" +
                "\t\tTTO.GROUP_ID = TU.GROUP_ID\n" +
                "\t\tand TTO.ORGANIZATION_ID = AO.BRANCH_ID) as BRANCHNAME,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tCD.REFUND_STATUS\n" +
                "\tfrom\n" +
                "\t\tREFUND_DETAILS RD,\n" +
                "\t\tCANCELLATION_DETAILS CD\n" +
                "\twhere\n" +
                "\t\tRD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO\n" +
                "\t\tand RD.REFUND_ID = CD.REFUND_ID\n" +
                "\t\tand CD.PASSENGER_NO = FBPD.PASSENGER_NO\n" +
                "\tlimit 1 ) as REFUNDSTATUS,\n" +
                "\tAPR.AGENT_BOOKING_STATUS AGENTORDERSTATUS,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tSUM(FPS.SSR_AMOUNT)\n" +
                "\tfrom\n" +
                "\t\tTT_TS_FB_PASSENGER_SSR FPS\n" +
                "\twhere\n" +
                "\t\tFBPD.PASSENGER_NO = FPS.PASSENGER_NO\n" +
                "\t\tand FBPD.FB_BOOKING_REF_NO = FPS.FB_BOOKING_REF_NO\n" +
                "\tgroup by\n" +
                "\t\tFPS.FB_BOOKING_REF_NO) as SSRAMOUNT,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tCREATION_TIME\n" +
                "\tfrom\n" +
                "\t\tREFUND_DETAILS\n" +
                "\twhere\n" +
                "\t\tBOOKING_REF_NO = FB.FB_BOOKING_REF_NO\n" +
                "\tlimit 1 ) as REFUNDDATE,\n" +
                "\tFI.MANUAL_MARKUP,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tTTCV.VALUE\n" +
                "\tfrom\n" +
                "\t\tTT_TS_SUPPLIER_CREDENTIAL_VALUES TTCV,\n" +
                "\t\tTT_TS_SUPPLIER_CREDENTIAL_FIELDS TTFI\n" +
                "\twhere\n" +
                "\t\tTTFI.CREDENTIAL_FIELD_NAME = 'IATA_NUMBER'\n" +
                "\t\tand TTCV.CREDENTIAL_ID = FI.TICKETING_PCC_ID\n" +
                "\t\tand TTCV.CREDENTIAL_FIELD_ID = TTFI.CREDENTIAL_FIELD_ID\n" +
                "\tlimit 1) as PCCIATANUMBER,\n" +
                "\tU.USER_ALIAS as NDCSTAFFNAME,\n" +
                "\tIFNULL(FB.TOTAL_SURCHARGE_AMOUNT, 0.0) TOTAL_SURCHARGE_AMOUNT,\n" +
                "\tTS.STATE_NAME,\n" +
                "\tTC.CITY_NAME\n" +
                "from\n" +
                "\tTT_TS_FLIGHT_BOOK FB\n" +
                "inner join TT_TS_AGENT_ORDER AO on\n" +
                "\tFB.ORDER_ID = AO.ORDER_ID\n" +
                "inner join TT_TS_AGENT_ORDER_CUSTOMER AC on\n" +
                "\tAO.ID = AC.ID\n" +
                "inner join TT_TS_AGENT_ORDER_PRODUCT_REF APR on\n" +
                "\tAO.ID = APR.ID\n" +
                "inner join TT_TS_TRANSACTION TST on\n" +
                "\tFB.ORDER_ID = TST.ORDER_ID\n" +
                "inner join TT_TS_FB_INVOICE_DETAIL FI on\n" +
                "\tFB.FB_BOOKING_REF_NO = FI.FB_BOOKING_REF_NO\n" +
                "inner join TT_TS_FB_SEGMENT_DETAIL FS on\n" +
                "\tFB.FB_BOOKING_REF_NO = FS.FB_BOOKING_REF_NO\n" +
                "inner join TT_TS_FB_PASSENGER_DETAIL FBPD on\n" +
                "\tFB.FB_BOOKING_REF_NO = FBPD.FB_BOOKING_REF_NO\n" +
                "inner join TT_TS_FB_PAX_SEG_BOOK_DETAIL FBSBD on\n" +
                "\tFB.FB_BOOKING_REF_NO = FBSBD.FB_BOOKING_REF_NO\n" +
                "\tand FBSBD.PASSENGER_NO = FBPD.PASSENGER_NO\n" +
                "inner join TT_ENUM_VALUES EV on\n" +
                "\tEV.INT_CODE = FBSBD.TICKET_BOOKING_STATUS\n" +
                "inner join TT_USER U on\n" +
                "\tFB.CREATED_BY = U.USER_ID\n" +
                "inner join TT_ORGANIZATION AGN on\n" +
                "\t(AGN.ORGANIZATION_ID = AO.AGENCY_ID)\n" +
                "inner join TT_STATE TS on\n" +
                "\t(TS.STATE_ID = AGN.STATE_ID)\n" +
                "inner join TT_CITY TC on\n" +
                "\t(TC.CITY_ID = AGN.CITY_ID)\n" +
                "where\n" +
                "\tFBSBD.SEGMENT_REF_NO = 1\n" +
                "\tand FB.BOOKING_STATUS in (2 , 5, 8, 9, 12, 13, 15, 16)\n" +
                "\tand EV.TYPE_NAME = 'BOOKING_STATUS'\n" +
                "\tand TST.CREATION_TIME between '2022-06-25 00:00:00' and '2022-06-25 23:59:59'\n" +
                "\tand APR.ORDER_TYPE = 0\n" +
                "\tand AO.AGENCY_ID in ('AGN3', 'AGN14', 'AGN34', 'AGN35', 'AGN50', 'AGN59', 'AGN60', 'AGN62', 'AGN92', 'AGN93', 'AGN97', 'AGN104', 'AGN107', 'AGN110', 'AGN120', 'AGN127', 'AGN139', 'AGN144', 'AGN147', 'AGN148', 'AGN154', 'AGN162', 'AGN164', 'AGN180', 'AGN182', 'AGN183', 'AGN188', 'AGN195', 'AGN196', 'AGN197', 'AGN199', 'AGN212', 'AGN215', 'AGN216', 'AGN230', 'AGN235', 'AGN239', 'AGN244', 'AGN245', 'AGN263', 'AGN270', 'AGN271', 'AGN272', 'AGN273', 'AGN323', 'AGN372', 'AGN374', 'AGN375', 'AGN376', 'AGN394', 'AGN419', 'AGN441', 'AGN450', 'AGN454', 'AGN456', 'AGN459', 'AGN470', 'AGN476', 'AGN501', 'AGN555', 'AGN557', 'AGN565', 'AGN572', 'AGN575', 'AGN603', 'AGN627', 'AGN661', 'AGN678', 'AGN685', 'AGN689', 'AGN830', 'AGN873', 'AGN932', 'AGN933', 'AGN934', 'AGN941', 'AGN942', 'AGN946', 'AGN947', 'AGN960', 'AGN971', 'AGN975', 'AGN983', 'AGN986', 'AGN992', 'AGN999', 'AGN1009', 'AGN1033', 'AGN1040', 'AGN1070', 'AGN1105', 'AGN1118', 'AGN1128', 'AGN1129', 'AGN1131', 'AGN1133', 'AGN1157', 'AGN1159', 'AGN1160', 'AGN1162', 'AGN1163', 'AGN1186', 'AGN1210', 'AGN1223', 'AGN1225', 'AGN1226', 'AGN1227', 'AGN1234', 'AGN1235', 'AGN1252', 'AGN1254', 'AGN1260', 'AGN1268', 'AGN1270', 'AGN1273', 'AGN1326', 'AGN1332', 'AGN1385', 'AGN1392', 'AGN1395', 'AGN1401', 'AGN1408', 'AGN1411', 'AGN1461', 'AGN1508', 'AGN1524', 'AGN1527', 'AGN1557', 'AGN1568', 'AGN1579', 'AGN1599', 'AGN1600', 'AGN1603', 'AGN1604', 'AGN1605', 'AGN1610', 'AGN1615', 'AGN1622', 'AGN1639', 'AGN1651', 'AGN1655', 'AGN1672', 'AGN1673', 'AGN1675', 'AGN1676', 'AGN1679', 'AGN1680', 'AGN1695', 'AGN1706', 'AGN1712', 'AGN1732', 'AGN1735', 'AGN1736', 'AGN1747', 'AGN1762', 'AGN1787', 'AGN1811', 'AGN1839', 'AGN1840', 'AGN1854', 'AGN1855', 'AGN1864', 'AGN1926', 'AGN1948', 'AGN1958', 'AGN1960', 'AGN1965', 'AGN1966', 'AGN1968', 'AGN1975', 'AGN1978', 'AGN1989', 'AGN2032', 'AGN2087', 'AGN2126', 'AGN2141', 'AGN2146', 'AGN2166', 'AGN2167', 'AGN2171', 'AGN2195', 'AGN2201', 'AGN2204', 'AGN2237', 'AGN2278', 'AGN2299', 'AGN2305', 'AGN2332', 'AGN2337', 'AGN2427', 'AGN2439', 'AGN2456', 'AGN2459', 'AGN2461', 'AGN2469', 'AGN2470', 'AGN2473', 'AGN2478', 'AGN2479', 'AGN2491', 'AGN2495', 'AGN2513', 'AGN2514', 'AGN2527', 'AGN2546', 'AGN2556', 'AGN2558', 'AGN2564', 'AGN2577', 'AGN2579', 'AGN2590', 'AGN2591', 'AGN2681', 'AGN2683', 'AGN2685', 'AGN2687', 'AGN2690', 'AGN2731', 'AGN2753', 'AGN2763', 'AGN2775', 'AGN2811', 'AGN2830', 'AGN2843', 'AGN2846', 'AGN2867', 'AGN2871', 'AGN2889', 'AGN2896', 'AGN2899', 'AGN2907', 'AGN2910', 'AGN2915', 'AGN2916', 'AGN2924', 'AGN2978', 'AGN2982', 'AGN2986', 'AGN2990', 'AGN2992', 'AGN2997', 'AGN2998', 'AGN3009', 'AGN3044', 'AGN3063', 'AGN3126', 'AGN3150', 'AGN3154', 'AGN3213', 'AGN3214', 'AGN3218', 'AGN3239', 'AGN3299', 'AGN3308', 'AGN3309', 'AGN3319', 'AGN3439', 'AGN3495', 'AGN3631', 'AGN3632', 'AGN3634', 'AGN3651', 'AGN3659', 'AGN3670', 'AGN4020', 'AGN4064', 'AGN4066', 'AGN4264', 'AGN4275', 'AGN4278', 'AGN4286', 'AGN4296', 'AGN4323', 'AGN4326', 'AGN4327', 'AGN4395', 'AGN4442', 'AGN4444', 'AGN4451', 'AGN4524', 'AGN4525', 'AGN4544', 'AGN4567', 'AGN4609', 'AGN4614', 'AGN4615', 'AGN4621', 'AGN4622', 'AGN4623', 'AGN4627', 'AGN4652', 'AGN4660', 'AGN4661', 'AGN4678', 'AGN4710', 'AGN4760', 'AGN4844', 'AGN4847', 'AGN4885', 'AGN4886', 'AGN4888', 'AGN4968', 'AGN4970', 'AGN5001', 'AGN5005', 'AGN5016', 'AGN5138', 'AGN5189', 'AGN5245', 'AGN5251', 'AGN5285', 'AGN5289', 'AGN5319', 'AGN5347', 'AGN5349', 'AGN5477', 'AGN5478', 'AGN5517', 'AGN5525', 'AGN5608', 'AGN5712', 'AGN5713', 'AGN5714', 'AGN5716', 'AGN5750', 'AGN5767', 'AGN5784', 'AGN5816', 'AGN5817', 'AGN5827', 'AGN5857', 'AGN5858', 'AGN5961', 'AGN5962', 'AGN5989')\n" +
                "\tand APR.ORDER_TYPE = 0\n" +
                "group by\n" +
                "\tref ,\n" +
                "\tCNAME ,\n" +
                "\tCDATE ,\n" +
                "\tPTYPE ,\n" +
                "\tCTYPE ,\n" +
                "\tSDATE ,\n" +
                "\tTCUST ,\n" +
                "\tUNAME ,\n" +
                "\tBSTATUS ,\n" +
                "\tOID\n" +
                "union\n" +
                "select\n" +
                "\tFB.FB_BOOKING_REF_NO as ref,\n" +
                "\tCONCAT(FBPD.FIRST_NAME, ' ', FBPD.LAST_NAME) as CNAME,\n" +
                "\tFBPD.TITLE as CTITLE,\n" +
                "\tAC.CITY as CCITY,\n" +
                "\tFBPD.NATIONALITY as CCOUNTRY,\n" +
                "\tFBPD.MOBILE_NO as CMOBILE,\n" +
                "\tFBPD.EMAIL_ID as CEMAIL,\n" +
                "\tFBSBD.TICKET_NO,\n" +
                "\tFS.AIRLINE_PNR,\n" +
                "\tFS.SP_PNR,\n" +
                "\tFB.TRIP_TYPE,\n" +
                "\tFB.ORIGIN,\n" +
                "\tFB.DESTINATION,\n" +
                "\tFB.NO_OF_SEGMENT,\n" +
                "\tFS.BOOKING_CLASS,\n" +
                "\tFS.CABIN_CLASS,\n" +
                "\tFB.SUPPLIER_NAME,\n" +
                "\tFB.TOTAL_BASE_FARE,\n" +
                "\tFB.TOTAL_FEE_N_TAXES,\n" +
                "\tFB.TOTAL_ODEYSYS_MARKUP,\n" +
                "\tFB.TOTAL_ODEYSYS_SERVICE_CHARGE,\n" +
                "\tFB.TOTAL_ODEYSYS_DISCOUNT,\n" +
                "\tFI.ODEYSYS_BSP_COMMISION,\n" +
                "\tFI.ODEYSYS_BSP_COMMISSION_PER,\n" +
                "\tFB.TOTAL_ODEYSYS_AGENCY_MARKUP,\n" +
                "\tFB.TOTAL_ODEYSYS_AGENT_ONFLY_MARKUP,\n" +
                "\tFB.TOTAL_ODEYSYS_FARE,\n" +
                "\tTST.PAYMENT_MODE,\n" +
                "\tTST.CREATION_TIME as PTIME,\n" +
                "\tAO.AGENCY_ID,\n" +
                "\tAO.BRANCH_ID,\n" +
                "\tFB.CREATION_TIME as CDATE,\n" +
                "\tAPR.ORDER_TYPE as PTYPE,\n" +
                "\tAC.CUSTOMER_TYPE as CTYPE,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tSUBFS.TRAVEL_DATE\n" +
                "\tfrom\n" +
                "\t\tTT_TS_FB_SEGMENT_DETAIL SUBFS\n" +
                "\twhere\n" +
                "\t\tSUBFS.FB_BOOKING_REF_NO = FB.FB_BOOKING_REF_NO\n" +
                "\t\tand SUBFS.SEGMENT_NO = 1) as SDATE,\n" +
                "\tFB.NO_OF_PASSENGER as TCUST,\n" +
                "\tU.FIRST_NAME as UNAME,\n" +
                "\tEV.VALUE as BSTATUS,\n" +
                "\tFB.ORDER_ID as OID,\n" +
                "\tFI.INVOICE_NUMBER,\n" +
                "\tFBPD.DOB,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tREFUND_AMOUNT\n" +
                "\tfrom\n" +
                "\t\tREFUND_DETAILS\n" +
                "\twhere\n" +
                "\t\tBOOKING_REF_NO = FB.FB_BOOKING_REF_NO\n" +
                "\tlimit 1) as REFUNDAMOUNT,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tCD.CANCELLATION_CHARGES\n" +
                "\tfrom\n" +
                "\t\tREFUND_DETAILS RD,\n" +
                "\t\tCANCELLATION_DETAILS CD\n" +
                "\twhere\n" +
                "\t\tRD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO\n" +
                "\t\tand RD.REFUND_ID = CD.REFUND_ID\n" +
                "\t\tand CD.PASSENGER_NO = FBPD.PASSENGER_NO\n" +
                "\tlimit 1) as REFUNDCANCELATIONAMOUNT,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tTU.GROUP_NAME\n" +
                "\tfrom\n" +
                "\t\tWONDERDB.TT_ORGANIZATION TTO,\n" +
                "\t\tTT_USER_GROUP TU\n" +
                "\twhere\n" +
                "\t\tTTO.GROUP_ID = TU.GROUP_ID\n" +
                "\t\tand TTO.ORGANIZATION_ID = AO.AGENCY_ID) as AGENCYNAME,\n" +
                "\tFB.TOTAL_ODEYSYS_BRANCH_ONFLY_MARKUP,\n" +
                "\tFB.BOOKING_TYPE,\n" +
                "\tFB.IMPORT_PNR_CASE,\n" +
                "\tFI.ODEYSYS_BSP_COMMISSION_PER_CHILD,\n" +
                "\tFI.ODEYSYS_BSP_COMMISION_CHILD,\n" +
                "\tFBSBD.PAX_BASE_FARE,\n" +
                "\tFBSBD.PAX_FEE_N_TAXES,\n" +
                "\tFBSBD.PAX_ODEYSYS_MARKUP,\n" +
                "\tFBSBD.PAX_ODEYSYS_SERVICE_CHARGE,\n" +
                "\tFBSBD.PAX_ODEYSYS_DISCOUNT,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tCOUNT(*)\n" +
                "\tfrom\n" +
                "\t\tREFUND_DETAILS RD,\n" +
                "\t\tCANCELLATION_DETAILS CD\n" +
                "\twhere\n" +
                "\t\tRD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO\n" +
                "\t\tand RD.REFUND_ID = CD.REFUND_ID) TCPAX,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tOFD.IATA_NUMBER\n" +
                "\tfrom\n" +
                "\t\tTT_ORG_FIN_DETAIL OFD\n" +
                "\twhere\n" +
                "\t\tOFD.ORGANIZATION_ID = AO.AGENCY_ID) as IATANUMBER,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tTU.GROUP_NAME\n" +
                "\tfrom\n" +
                "\t\tWONDERDB.TT_ORGANIZATION TTO,\n" +
                "\t\tTT_USER_GROUP TU\n" +
                "\twhere\n" +
                "\t\tTTO.GROUP_ID = TU.GROUP_ID\n" +
                "\t\tand TTO.ORGANIZATION_ID = AO.BRANCH_ID) as BRANCHNAME,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tCD.REFUND_STATUS\n" +
                "\tfrom\n" +
                "\t\tREFUND_DETAILS RD,\n" +
                "\t\tCANCELLATION_DETAILS CD\n" +
                "\twhere\n" +
                "\t\tRD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO\n" +
                "\t\tand RD.REFUND_ID = CD.REFUND_ID\n" +
                "\t\tand CD.PASSENGER_NO = FBPD.PASSENGER_NO\n" +
                "\tlimit 1 ) as REFUNDSTATUS,\n" +
                "\tAPR.AGENT_BOOKING_STATUS AGENTORDERSTATUS,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tSUM(FPS.SSR_AMOUNT)\n" +
                "\tfrom\n" +
                "\t\tTT_TS_FB_PASSENGER_SSR FPS\n" +
                "\twhere\n" +
                "\t\tFBPD.PASSENGER_NO = FPS.PASSENGER_NO\n" +
                "\t\tand FBPD.FB_BOOKING_REF_NO = FPS.FB_BOOKING_REF_NO\n" +
                "\tgroup by\n" +
                "\t\tFPS.FB_BOOKING_REF_NO) as SSRAMOUNT,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tCREATION_TIME\n" +
                "\tfrom\n" +
                "\t\tREFUND_DETAILS\n" +
                "\twhere\n" +
                "\t\tBOOKING_REF_NO = FB.FB_BOOKING_REF_NO\n" +
                "\tlimit 1 ) as REFUNDDATE,\n" +
                "\tFI.MANUAL_MARKUP,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tTTCV.VALUE\n" +
                "\tfrom\n" +
                "\t\tTT_TS_SUPPLIER_CREDENTIAL_VALUES TTCV,\n" +
                "\t\tTT_TS_SUPPLIER_CREDENTIAL_FIELDS TTFI\n" +
                "\twhere\n" +
                "\t\tTTFI.CREDENTIAL_FIELD_NAME = 'IATA_NUMBER'\n" +
                "\t\tand TTCV.CREDENTIAL_ID = FI.TICKETING_PCC_ID\n" +
                "\t\tand TTCV.CREDENTIAL_FIELD_ID = TTFI.CREDENTIAL_FIELD_ID\n" +
                "\tlimit 1) as PCCIATANUMBER,\n" +
                "\tU.USER_ALIAS as NDCSTAFFNAME,\n" +
                "\tIFNULL(FB.TOTAL_SURCHARGE_AMOUNT, 0.0) TOTAL_SURCHARGE_AMOUNT,\n" +
                "\tTS_BR.STATE_NAME,\n" +
                "\tTC_BR.CITY_NAME\n" +
                "from\n" +
                "\tTT_TS_FLIGHT_BOOK FB\n" +
                "inner join TT_TS_AGENT_ORDER AO on\n" +
                "\tFB.ORDER_ID = AO.ORDER_ID\n" +
                "inner join TT_TS_AGENT_ORDER_CUSTOMER AC on\n" +
                "\tAO.ID = AC.ID\n" +
                "inner join TT_TS_AGENT_ORDER_PRODUCT_REF APR on\n" +
                "\tAO.ID = APR.ID\n" +
                "inner join TT_TS_TRANSACTION TST on\n" +
                "\tFB.ORDER_ID = TST.ORDER_ID\n" +
                "inner join TT_TS_FB_INVOICE_DETAIL FI on\n" +
                "\tFB.FB_BOOKING_REF_NO = FI.FB_BOOKING_REF_NO\n" +
                "inner join TT_TS_FB_SEGMENT_DETAIL FS on\n" +
                "\tFB.FB_BOOKING_REF_NO = FS.FB_BOOKING_REF_NO\n" +
                "inner join TT_TS_FB_PASSENGER_DETAIL FBPD on\n" +
                "\tFB.FB_BOOKING_REF_NO = FBPD.FB_BOOKING_REF_NO\n" +
                "inner join TT_TS_FB_PAX_SEG_BOOK_DETAIL FBSBD on\n" +
                "\tFB.FB_BOOKING_REF_NO = FBSBD.FB_BOOKING_REF_NO\n" +
                "\tand FBSBD.PASSENGER_NO = FBPD.PASSENGER_NO\n" +
                "inner join TT_ENUM_VALUES EV on\n" +
                "\tEV.INT_CODE = FBSBD.TICKET_BOOKING_STATUS\n" +
                "inner join TT_USER U on\n" +
                "\tFB.CREATED_BY = U.USER_ID\n" +
                "inner join TT_ORGANIZATION BR on\n" +
                "\t(BR.ORGANIZATION_ID = AO.BRANCH_ID)\n" +
                "inner join TT_STATE TS_BR on\n" +
                "\t(TS_BR.STATE_ID = BR.STATE_ID)\n" +
                "inner join TT_CITY TC_BR on\n" +
                "\t(TC_BR.CITY_ID = BR.CITY_ID)\n" +
                "where\n" +
                "\tFBSBD.SEGMENT_REF_NO = 1\n" +
                "\tand FB.BOOKING_STATUS in (2 , 5, 8, 9, 12, 13, 15, 16)\n" +
                "\tand EV.TYPE_NAME = 'BOOKING_STATUS'\n" +
                "\tand TST.CREATION_TIME between '2022-06-25 00:00:00' and '2022-06-25 23:59:59'\n" +
                "\tand APR.ORDER_TYPE = 0\n" +
                "\tand AO.BRANCH_ID in ('BRN3')\n" +
                "\tand AO.AGENCY_ID is null\n" +
                "\tand APR.ORDER_TYPE = 0\n" +
                "group by\n" +
                "\tref ,\n" +
                "\tCNAME ,\n" +
                "\tCDATE ,\n" +
                "\tPTYPE ,\n" +
                "\tCTYPE ,\n" +
                "\tSDATE ,\n" +
                "\tTCUST ,\n" +
                "\tUNAME ,\n" +
                "\tBSTATUS ,\n" +
                "\tOID\n" +
                "union\n" +
                "select\n" +
                "\tFB.FB_BOOKING_REF_NO as ref,\n" +
                "\tCONCAT(FBPD.FIRST_NAME, ' ', FBPD.LAST_NAME) as CNAME,\n" +
                "\tFBPD.TITLE as CTITLE,\n" +
                "\tAC.CITY as CCITY,\n" +
                "\tFBPD.NATIONALITY as CCOUNTRY,\n" +
                "\tFBPD.MOBILE_NO as CMOBILE,\n" +
                "\tFBPD.EMAIL_ID as CEMAIL,\n" +
                "\tFBSBD.TICKET_NO,\n" +
                "\tFS.AIRLINE_PNR,\n" +
                "\tFS.SP_PNR,\n" +
                "\tFB.TRIP_TYPE,\n" +
                "\tFB.ORIGIN,\n" +
                "\tFB.DESTINATION,\n" +
                "\tFB.NO_OF_SEGMENT,\n" +
                "\tFS.BOOKING_CLASS,\n" +
                "\tFS.CABIN_CLASS,\n" +
                "\tFB.SUPPLIER_NAME,\n" +
                "\tFB.TOTAL_BASE_FARE,\n" +
                "\tFB.TOTAL_FEE_N_TAXES,\n" +
                "\tFB.TOTAL_ODEYSYS_MARKUP,\n" +
                "\tFB.TOTAL_ODEYSYS_SERVICE_CHARGE,\n" +
                "\tFB.TOTAL_ODEYSYS_DISCOUNT,\n" +
                "\tFI.ODEYSYS_BSP_COMMISION,\n" +
                "\tFI.ODEYSYS_BSP_COMMISSION_PER,\n" +
                "\tFB.TOTAL_ODEYSYS_AGENCY_MARKUP,\n" +
                "\tFB.TOTAL_ODEYSYS_AGENT_ONFLY_MARKUP,\n" +
                "\tFB.TOTAL_ODEYSYS_FARE,\n" +
                "\tTST.PAYMENT_MODE,\n" +
                "\tTST.CREATION_TIME as PTIME,\n" +
                "\tAO.AGENCY_ID,\n" +
                "\tAO.BRANCH_ID,\n" +
                "\tFB.CREATION_TIME as CDATE,\n" +
                "\tAPR.ORDER_TYPE as PTYPE,\n" +
                "\tAC.CUSTOMER_TYPE as CTYPE,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tSUBFS.TRAVEL_DATE\n" +
                "\tfrom\n" +
                "\t\tTT_TS_FB_SEGMENT_DETAIL SUBFS\n" +
                "\twhere\n" +
                "\t\tSUBFS.FB_BOOKING_REF_NO = FB.FB_BOOKING_REF_NO\n" +
                "\t\tand SUBFS.SEGMENT_NO = 1) as SDATE,\n" +
                "\tFB.NO_OF_PASSENGER as TCUST,\n" +
                "\tU.FIRST_NAME as UNAME,\n" +
                "\tEV.VALUE as BSTATUS,\n" +
                "\tFB.ORDER_ID as OID,\n" +
                "\tFI.INVOICE_NUMBER,\n" +
                "\tFBPD.DOB,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tREFUND_AMOUNT\n" +
                "\tfrom\n" +
                "\t\tREFUND_DETAILS\n" +
                "\twhere\n" +
                "\t\tBOOKING_REF_NO = FB.FB_BOOKING_REF_NO\n" +
                "\tlimit 1) as REFUNDAMOUNT,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tCD.CANCELLATION_CHARGES\n" +
                "\tfrom\n" +
                "\t\tREFUND_DETAILS RD,\n" +
                "\t\tCANCELLATION_DETAILS CD\n" +
                "\twhere\n" +
                "\t\tRD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO\n" +
                "\t\tand RD.REFUND_ID = CD.REFUND_ID\n" +
                "\t\tand CD.PASSENGER_NO = FBPD.PASSENGER_NO\n" +
                "\tlimit 1) as REFUNDCANCELATIONAMOUNT,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tTU.GROUP_NAME\n" +
                "\tfrom\n" +
                "\t\tWONDERDB.TT_ORGANIZATION TTO,\n" +
                "\t\tTT_USER_GROUP TU\n" +
                "\twhere\n" +
                "\t\tTTO.GROUP_ID = TU.GROUP_ID\n" +
                "\t\tand TTO.ORGANIZATION_ID = AO.AGENCY_ID) as AGENCYNAME,\n" +
                "\tFB.TOTAL_ODEYSYS_BRANCH_ONFLY_MARKUP,\n" +
                "\tFB.BOOKING_TYPE,\n" +
                "\tFB.IMPORT_PNR_CASE,\n" +
                "\tFI.ODEYSYS_BSP_COMMISSION_PER_CHILD,\n" +
                "\tFI.ODEYSYS_BSP_COMMISION_CHILD,\n" +
                "\tFBSBD.PAX_BASE_FARE,\n" +
                "\tFBSBD.PAX_FEE_N_TAXES,\n" +
                "\tFBSBD.PAX_ODEYSYS_MARKUP,\n" +
                "\tFBSBD.PAX_ODEYSYS_SERVICE_CHARGE,\n" +
                "\tFBSBD.PAX_ODEYSYS_DISCOUNT,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tCOUNT(*)\n" +
                "\tfrom\n" +
                "\t\tREFUND_DETAILS RD,\n" +
                "\t\tCANCELLATION_DETAILS CD\n" +
                "\twhere\n" +
                "\t\tRD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO\n" +
                "\t\tand RD.REFUND_ID = CD.REFUND_ID) TCPAX,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tOFD.IATA_NUMBER\n" +
                "\tfrom\n" +
                "\t\tTT_ORG_FIN_DETAIL OFD\n" +
                "\twhere\n" +
                "\t\tOFD.ORGANIZATION_ID = AO.AGENCY_ID) as IATANUMBER,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tTU.GROUP_NAME\n" +
                "\tfrom\n" +
                "\t\tWONDERDB.TT_ORGANIZATION TTO,\n" +
                "\t\tTT_USER_GROUP TU\n" +
                "\twhere\n" +
                "\t\tTTO.GROUP_ID = TU.GROUP_ID\n" +
                "\t\tand TTO.ORGANIZATION_ID = AO.BRANCH_ID) as BRANCHNAME,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tCD.REFUND_STATUS\n" +
                "\tfrom\n" +
                "\t\tREFUND_DETAILS RD,\n" +
                "\t\tCANCELLATION_DETAILS CD\n" +
                "\twhere\n" +
                "\t\tRD.BOOKING_REF_NO = FB.FB_BOOKING_REF_NO\n" +
                "\t\tand RD.REFUND_ID = CD.REFUND_ID\n" +
                "\t\tand CD.PASSENGER_NO = FBPD.PASSENGER_NO\n" +
                "\tlimit 1 ) as REFUNDSTATUS,\n" +
                "\tAPR.AGENT_BOOKING_STATUS AGENTORDERSTATUS,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tSUM(FPS.SSR_AMOUNT)\n" +
                "\tfrom\n" +
                "\t\tTT_TS_FB_PASSENGER_SSR FPS\n" +
                "\twhere\n" +
                "\t\tFBPD.PASSENGER_NO = FPS.PASSENGER_NO\n" +
                "\t\tand FBPD.FB_BOOKING_REF_NO = FPS.FB_BOOKING_REF_NO\n" +
                "\tgroup by\n" +
                "\t\tFPS.FB_BOOKING_REF_NO) as SSRAMOUNT,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tCREATION_TIME\n" +
                "\tfrom\n" +
                "\t\tREFUND_DETAILS\n" +
                "\twhere\n" +
                "\t\tBOOKING_REF_NO = FB.FB_BOOKING_REF_NO\n" +
                "\tlimit 1 ) as REFUNDDATE,\n" +
                "\tFI.MANUAL_MARKUP,\n" +
                "\t(\n" +
                "\tselect\n" +
                "\t\tTTCV.VALUE\n" +
                "\tfrom\n" +
                "\t\tTT_TS_SUPPLIER_CREDENTIAL_VALUES TTCV,\n" +
                "\t\tTT_TS_SUPPLIER_CREDENTIAL_FIELDS TTFI\n" +
                "\twhere\n" +
                "\t\tTTFI.CREDENTIAL_FIELD_NAME = 'IATA_NUMBER'\n" +
                "\t\tand TTCV.CREDENTIAL_ID = FI.TICKETING_PCC_ID\n" +
                "\t\tand TTCV.CREDENTIAL_FIELD_ID = TTFI.CREDENTIAL_FIELD_ID\n" +
                "\tlimit 1) as PCCIATANUMBER,\n" +
                "\tU.USER_ALIAS as NDCSTAFFNAME,\n" +
                "\tIFNULL(FB.TOTAL_SURCHARGE_AMOUNT, 0.0) TOTAL_SURCHARGE_AMOUNT,\n" +
                "\tTS_BR.STATE_NAME,\n" +
                "\tTC_BR.CITY_NAME\n" +
                "from\n" +
                "\tTT_TS_FLIGHT_BOOK FB\n" +
                "inner join TT_TS_AGENT_ORDER AO on\n" +
                "\tFB.ORDER_ID = AO.ORDER_ID\n" +
                "inner join TT_TS_AGENT_ORDER_CUSTOMER AC on\n" +
                "\tAO.ID = AC.ID\n" +
                "inner join TT_TS_AGENT_ORDER_PRODUCT_REF APR on\n" +
                "\tAO.ID = APR.ID\n" +
                "inner join TT_TS_TRANSACTION TST on\n" +
                "\tFB.ORDER_ID = TST.ORDER_ID\n" +
                "inner join TT_TS_FB_INVOICE_DETAIL FI on\n" +
                "\tFB.FB_BOOKING_REF_NO = FI.FB_BOOKING_REF_NO\n" +
                "inner join TT_TS_FB_SEGMENT_DETAIL FS on\n" +
                "\tFB.FB_BOOKING_REF_NO = FS.FB_BOOKING_REF_NO\n" +
                "inner join TT_TS_FB_PASSENGER_DETAIL FBPD on\n" +
                "\tFB.FB_BOOKING_REF_NO = FBPD.FB_BOOKING_REF_NO\n" +
                "inner join TT_TS_FB_PAX_SEG_BOOK_DETAIL FBSBD on\n" +
                "\tFB.FB_BOOKING_REF_NO = FBSBD.FB_BOOKING_REF_NO\n" +
                "\tand FBSBD.PASSENGER_NO = FBPD.PASSENGER_NO\n" +
                "inner join TT_ENUM_VALUES EV on\n" +
                "\tEV.INT_CODE = FBSBD.TICKET_BOOKING_STATUS\n" +
                "inner join TT_USER U on\n" +
                "\tFB.CREATED_BY = U.USER_ID\n" +
                "inner join TT_ORGANIZATION BR on\n" +
                "\t(BR.ORGANIZATION_ID = AO.BRANCH_ID)\n" +
                "inner join TT_STATE TS_BR on\n" +
                "\t(TS_BR.STATE_ID = BR.STATE_ID)\n" +
                "inner join TT_CITY TC_BR on\n" +
                "\t(TC_BR.CITY_ID = BR.CITY_ID)\n" +
                "where\n" +
                "\tFBSBD.SEGMENT_REF_NO = 1\n" +
                "\tand FB.BOOKING_STATUS in (2 , 5, 8, 9, 12, 13, 15, 16)\n" +
                "\tand EV.TYPE_NAME = 'BOOKING_STATUS'\n" +
                "\tand TST.CREATION_TIME between '2022-06-25 00:00:00' and '2022-06-25 23:59:59'\n" +
                "\tand APR.ORDER_TYPE = 0\n" +
                "\tand AO.BRANCH_ID in ('BRN3')\n" +
                "\tand AO.AGENCY_ID = 'NULL'\n" +
                "\tand APR.ORDER_TYPE = 0\n" +
                "group by\n" +
                "\tref ,\n" +
                "\tCNAME ,\n" +
                "\tCDATE ,\n" +
                "\tPTYPE ,\n" +
                "\tCTYPE ,\n" +
                "\tSDATE ,\n" +
                "\tTCUST ,\n" +
                "\tUNAME ,\n" +
                "\tBSTATUS ,\n" +
                "\tOID";
        paramMap.put("id", financeSerch.getId());
        return db.sql(query).map(MAPPING_FUNCTION).all().limitRate(600);

    }
}

package com.example.test.demo.test;

import com.example.test.demo.test.entitys.*;


import com.example.test.demo.test.historyService.HistoryService;
import com.example.test.demo.test.repos.*;
import com.example.test.demo.test.searchmodels.FinanceSerch;
import com.example.test.demo.test.searchmodels.ReportSearch;
import com.example.test.demo.test.utils.Pnrhistoryexcel;
import com.example.test.demo.test.utils.FinanceProjection;
import com.example.test.demo.test.utils.ResponseMessage;
import com.example.test.demo.test.utils.StorageService;
import com.opencsv.CSVWriter;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9090")
public class TestController {

    private static File file;
    @Autowired
    private CsvWriterService csvWriterService;
    private static List<TtUser> users;
    private static List<RvPnrimportHistory> rvPnrimportHistories;

@Autowired
    StorageService storageService;

    @Autowired
    private UserRepo repo;
//    @Autowired
//    private  RvFinancialreportRepo rvFinancialreportRepo;
    @Autowired
    private OrgannizationRepo organnizationRepo;
    @Autowired
    private Services services;
    @Autowired
    private CancellationDetailRepo cancellationDetailRepo;
    @Autowired
    private VvUserLockedItrRrpo vvUserLockedItrRrpo;
    @Autowired
    private RvPnrimportHistoryRepo rvPnrimportHistoryRepo;
    @Autowired
    private Pnrhistoryexcel historyCvWriter;
    @Autowired
    private HistoryService historyService;

    @GetMapping(value = "/getAllusers", produces = {"application/stream+json"})
    public  Flux<TtUser> prepare() throws IOException {
//        final int[] i = {0};
//        List<TtUser > user=new ArrayList<>();
//        String[] data2 = new String[3];
//        List<String[]> data = new ArrayList<String[]>();
//        File file = new File("D://ffb2.csv");
//        CSVWriter writer1;
//        FileWriter outputfile=new FileWriter(file);
//        try {
//
//            writer1 = new CSVWriter(outputfile);
//            String[] header = {"firstName", "email"};
////            writer1.writeAll(data);
//            String[] header2 = {"www", "ss"};
//            String[] header3 = {"www3", "ss33"};
//            writer1.writeNext(header);
//            writer1.writeNext(header2);
//            writer1.writeNext(header);
////             Flux<TtUser> all = new Flux[]{repo.findAll()};
//            repo.findAll()
//            .subscribe(ttUser ->{
//
//
//                System.out.println(ttUser.getFirstName());
//                writer1.writeNext(header3);
//            });
//
//
//
//        } finally {
//
//            outputfile.close();
//        return repo.findAll();
//        }

List<String>allieses=new ArrayList<String>();
allieses.add("esaady");
allieses.add("M.Ashraf");

return  services.getsql();
    }




    public List<TtUser> data() {
        return users;
    }

    @GetMapping(value = "/hql", produces = {"application/stream+json"})
    public Flux<TtUser> gethql() {
        System.out.println("runing");
        return services.getsql();
    }

    @GetMapping(value = "/getOrgs", produces = {"application/stream+json"})
    public Flux<TtOrganization> getAllprgs() {
        return organnizationRepo.findAll();
    }

    @GetMapping(value ="/empd", produces = {"application/stream+json"})
    public Flux<CancellationDetail> getCancellationDetailId() {
        return cancellationDetailRepo.findAll();
    }

    @GetMapping("/fu")
    public Flux<TtUser> ius() {
        return repo.findAll();
    }

    @GetMapping(value = "/locks", produces = {"application/stream+json"})
    public Flux<VvUserLockedItr> locks() {
        return vvUserLockedItrRrpo.findAll();
    }

    @GetMapping(value = "/history", produces = {"application/stream+json"})
    public Flux<RvPnrimportHistory> hist() {
        return rvPnrimportHistoryRepo.findAll();
    }

    @GetMapping(value = "/preparehistory", produces = {"application/stream+json"})
    public Disposable preparehistorr() {
        Flux<RvPnrimportHistory> all = rvPnrimportHistoryRepo.findAll();
        rvPnrimportHistories = new ArrayList<RvPnrimportHistory>();
        return all.subscribe(valus -> {

            System.out.println("AAA" + valus.getAgentname());
            rvPnrimportHistories.add(valus);
        });
    }

    @PostMapping("/pnrstram")

public String gitpnrHistoryGeneratedfile() throws IOException {
        Date date1 = new Date();
        ReportSearch reportSearch=new ReportSearch();
    ArrayList<String>allorgs=new ArrayList<String>();
    allorgs.add("mester eslam");
        allorgs.add("Elhady");

        reportSearch.setOrgname(allorgs);
        LocalDateTime date= LocalDateTime.of(2022,6,1,00,00);
        LocalDateTime datef= LocalDateTime.of(2022,7,31,00,00);
        String generatedString = RandomStringUtils.randomAlphabetic(10);
            reportSearch.setTdate(date);
            reportSearch.setFdate(datef);
    File file = new File("D://"+generatedString+".csv");
        //Long count= rvPnrimportHistoryRepo.count();
//     Mono<Long>count =rvPnrimportHistoryRepo.count();
    CSVWriter writer1;
    FileWriter outputfile=new FileWriter(file);
    try {

        writer1 = new CSVWriter(outputfile);
        String[] header = {"spnr", "orgname","suppliername","Agent name","Imprt pnrhistory","pccId","officeId"};

     //   rvPnrimportHistoryRepo.findAll()
        writer1.writeNext(header);
      historyService.date(reportSearch).limitRate(10)
        .doOnNext(s->{
//              System.out.println(s.getAgentname());
          }).doOnComplete(() -> {
              try {
                  writer1.close();
                  Date date2 = new  Date();
                  long diffInMillies = date2.getTime() - date1.getTime();
//                  System.out.println(diffInMillies);

              } catch (IOException e) {
                  throw new RuntimeException(e);
              }

          })
                .subscribe(rvPnrimportHistory ->{

                    header[0]=rvPnrimportHistory.getSpPnr();
                    header[1]=rvPnrimportHistory.getOrgname();
                    header[2]=rvPnrimportHistory.getSuppliername();
                   header[3]=rvPnrimportHistory.getAgentname();
                    header[4]=rvPnrimportHistory.getImportDateTime()+"";
                    header[5]=rvPnrimportHistory.getPccId()+"";
                    header[6]=rvPnrimportHistory.getPnrCreatedByOfficeId();
                    writer1.writeNext(header);
                    file.setWritable(true);
                    file.setWritable(true);
//                    generatedString="wating";

                });


    }
    catch (RuntimeException r){r.printStackTrace()

    ;}



    return generatedString;
}
    @GetMapping("/downloadcsv/{fileName}")
    public ResponseEntity downloadFileFromLocal(@PathVariable String fileName) {
        Path path = Paths.get("D://" + fileName+".csv");
        Resource resource = null;
        try {
            resource = new UrlResource(path.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()

                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + resource.getFilename() )
                .body(resource);
    }
    @DeleteMapping("/deletefiles/{filename}")
    public ResponseEntity<ResponseMessage> deleteFile(@PathVariable String filename){  String message = "";

        try {
            boolean existed = storageService.delete("D://"+filename+".csv");

            if (existed) {
                message = "Delete the file successfully: " + filename;
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            }

            message = "The file does not exist!";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not delete the file: " + filename + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage(message));
        }}
@GetMapping("/close/{filename}")
         public String close(@PathVariable String filename) throws IOException {
        File file1=new File("D://"+filename+".csv");
      FileOutputStream fileOutputStream=new FileOutputStream(file);
      fileOutputStream.close();
     return "closed";

    }
    @PostMapping(value = "/getallr", produces = {"application/stream+json"})
    public Flux<RvPnrimportHistory>rvPnrimportHistoryFluxs(@RequestBody ReportSearch reportSearch){
        return services.getrv(reportSearch.getOrgname());
    }
    @PostMapping("/pnrstramall")

    public String gitpnrHistoryGeneratedfileall() throws IOException {
        Date date1 = new Date();
        String generatedString = RandomStringUtils.randomAlphabetic(10);
        Flux<RvPnrimportHistory>all=null;
//        Flux<RvPnrimportHistory>rvPnrimportHistoryFlux=services.getrv(reportSearch.getOrgname());
        File file = new File("D://"+generatedString+".csv");
        //Long count= rvPnrimportHistoryRepo.count();
//     Mono<Long>count =rvPnrimportHistoryRepo.count();
        CSVWriter writer1;
        FileWriter outputfile=new FileWriter(file);
        try {

            writer1 = new CSVWriter(outputfile);
            String[] header = {"spnr", "Agent name","suppliername","Imprt pnrhistory","pccId","officeId"};

            //   rvPnrimportHistoryRepo.findAll()
            writer1.writeNext(header);
            rvPnrimportHistoryRepo.findAll()
                    .doOnNext(s->{
                        System.out.println(s.getAgentname());
                    }).doOnComplete(() -> {
                        try {
                            writer1.close();
                            Date date2 = new  Date();
                            long diffInMillies = date2.getTime() - date1.getTime();
                            System.out.println(diffInMillies);

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    })
                    .subscribe(rvPnrimportHistory ->{

                        header[0]=rvPnrimportHistory.getSpPnr();
                        header[1]=rvPnrimportHistory.getOrgname();
                        header[2]=rvPnrimportHistory.getSuppliername();

                        header[3]=rvPnrimportHistory.getImportDateTime()+"";
                        header[4]=rvPnrimportHistory.getPccId()+"";
                        header[5]=rvPnrimportHistory.getPnrCreatedByOfficeId();
                        writer1.writeNext(header);
                        file.setWritable(true);
//                    generatedString="wating";

                    });


        }
        catch (RuntimeException r){r.printStackTrace()

        ;}



        return generatedString;
    }
    @GetMapping(value = "/getfinance",produces = {"application/stream+json"})
    public Flux<RvFinancialreport> getfinance(){

         FinanceSerch financeSerch=new FinanceSerch();
         String ag="A.Corporate";
        ArrayList<String>agencyname=new ArrayList<String>();
        LocalDateTime date1=LocalDateTime.of( 2022,06,01, 00,00,00);
        LocalDateTime date2=LocalDateTime.of(2022,7,1,00,00);
        agencyname.add(ag);
        financeSerch .setOrgname(agencyname);
        financeSerch.setFdate(date1);
        financeSerch.setTdate(date2);
        return  services.getFinaceData(financeSerch)

        ;
    }
    @PostMapping(value = "/getfinancew",produces = {"application/stream+json"})

    public  String writefinancea(@RequestBody FinanceSerch financeSerch) throws IOException {
        String generatedString = RandomStringUtils.randomAlphabetic(10);
        System.out.println("started "+ new Date().getTime());
        Date dates = new  Date();
        File file = new File("D://"+"finace"+generatedString+".csv");
        //Long count= rvPnrimportHistoryRepo.count();
//     Mono<Long>count =rvPnrimportHistoryRepo.count();
        CSVWriter writer1;
        FinanceSerch financeSerchs=new FinanceSerch();
        String ag="A.Corporate";
        ArrayList<String>agencyname=new ArrayList<String>();
        LocalDateTime date1=LocalDateTime.of( 2022,06,01, 1,00,00);
        LocalDateTime date2=LocalDateTime.of(2022,07,2,00,00);
        agencyname.add(ag);
        financeSerchs.setOrgname(agencyname);
        financeSerchs.setFdate(date1);
        financeSerchs.setTdate(date2);
        FileWriter outputfile=new FileWriter(file);
        try {

            writer1 = new CSVWriter(outputfile);
            String[] header =


                    {"REF", "CNAME","CTITLE","CCITY","CCOUNTRY","CMOBILE","CEMAIL","TICKET_NO","clientname"
                            ,"AIRLINE_PNR","SP_PNR","TRIP_TYPE","ORIGIN","Origin","DESTINATION","NO_OF_SEGMENT","BOOKING_CLASS"
                            ,"CABIN_CLASS","SUPPLIER_NAME","TOTAL_BASE_FARE","TOTAL_FEE_N_TAXES","TOTAL_ODEYSYS_SERVICE_CHARGE"
                            ,"TOTAL_ODEYSYS_DISCOUNT","ODEYSYS_BSP_COMMISION","ODEYSYS_BSP_COMMISSION_PER","TOTAL_ODEYSYS_AGENCY_MARKUP"
                            ,"TOTAL_ODEYSYS_AGENT_ONFLY_MARKUP","TOTAL_ODEYSYS_FARE","PAYMENT_MODE","PTIME","AGENCY_ID"
                    ,"BRANCH_ID","BRANCH_ID","CDATE","SDATE","TCUST","UNAME","BSTATUS","OID","INVOICE_NUMBER"
                    ,"DOB","REFUNDAMOUNT","REFUNDCANCELATIONAMOUNT","AGENCYNAME","TOTAL_ODEYSYS_BRANCH_ONFLY_MARKUP"
                    ,"BOOKING_TYPE","IMPORT_PNR_CASE","ODEYSYS_BSP_COMMISSION_PER_CHILD","ODEYSYS_BSP_COMMISION_CHILD"
                     ,"PAX_BASE_FARE","PAX_FEE_N_TAXES","PAX_ODEYSYS_MARKUP","PAX_ODEYSYS_SERVICE_CHARGE"
                      ,"PAX_ODEYSYS_DISCOUNT","PAX_ODEYSYS_DISCOUNT","TCPAX","IATANUMBER","BRANCHNAME"
                            ,"REFUNDSTATUS","AGENTORDERSTATUS","MANUAL_MARKUP","PCCIATANUMBER","STATE_NAME"
                            ,"NDCSTAFFNAME","TOTAL_SURCHARGE_AMOUNT","CITY_NAME"

                    };

            //   rvPnrimportHistoryRepo.findAll()
            writer1.writeNext(header);
            services.getFinaceData(financeSerchs)
                    .doOnNext(s->{

                    }).doOnComplete(() -> {
                        try {
                            writer1.close();
                            Date dateE = new  Date();
                           long diffInMillies = dates.getTime() - dateE.getTime();
                            System.out.println(dates.getTime());
                            System.out.println(dateE.getTime());
                            System.out.println(diffInMillies);

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }

                    })
                    .subscribe(rvPnrimportHistory ->{

                        header[0]=rvPnrimportHistory.getRef();
                        header[1]=rvPnrimportHistory.getAgencyId();
                        header[2]=rvPnrimportHistory.getCNAME();

                        header[3]=rvPnrimportHistory.getCcountry()+"";
                        header[4]=rvPnrimportHistory.getCmobile()+"";
                        header[5]=rvPnrimportHistory.getBranchName();
                        header[6]=rvPnrimportHistory.getDob();
                        header[7]=rvPnrimportHistory.getTicketNo();
                        header[8]=rvPnrimportHistory.getCNAME();
                        header[9]=rvPnrimportHistory.getCcountry();
                        header[10]=rvPnrimportHistory.getAirlinePnr();
                        header[11]=rvPnrimportHistory.getBStatus();
                        header[12]=rvPnrimportHistory.getAgencyName();
                        header[13]=rvPnrimportHistory.getOrigin();
                        header[14]=rvPnrimportHistory.getDestination();
                        header[15]=rvPnrimportHistory.getBookingType()+"";
                        header[16]=rvPnrimportHistory.getSDate()+"";
                        header[17]=rvPnrimportHistory.getInvoiceNumber()+"";
                        header[18]=rvPnrimportHistory.getTotalBaseFare()+"";
                        header[19]=rvPnrimportHistory.getTotalOdeysysDiscount()+"";
                        header[20]=rvPnrimportHistory.getCabinClass()+"";
                        header[21]=rvPnrimportHistory.getTotalOdeysysAgencyMarkup()+"";
                        header[22]=rvPnrimportHistory.getRefundDate()+"";
                        header[23]=rvPnrimportHistory.getRefundCancelationAmount()+"";
                         header[24]=  rvPnrimportHistory.getTotalOdeysysAgencyMarkup()+"";
                        header[25]=  rvPnrimportHistory.getSupplierName()+"";
                        header[26]=  rvPnrimportHistory.getCtitle()+"";
                        header[27]=  rvPnrimportHistory.getCemail()+"";
                        header[28]=  rvPnrimportHistory.getPtime()+"";
                        header[29]=  rvPnrimportHistory.getIatanumber()+"";
                        header[30]=  rvPnrimportHistory.getPccIataNumber()+"";
                        header[31]=  rvPnrimportHistory.getUName()+"";
                        header[32]=  rvPnrimportHistory.getBookingType()+"";
                        header[33]=  rvPnrimportHistory.getTotalOdeysysServiceCharge()+"";
                        header[34]=  rvPnrimportHistory.getTotalFeeNTaxes()+"";
                        header[34]=  rvPnrimportHistory.getTotalFeeNTaxes()+"";
//                        header[17]=rvPnrimportHistory.getCcity();
//                        header[11]=rvPnrimportHistory.getcode;
                        writer1.writeNext(header);

                        file.setWritable(true);
//                    generatedString="wating";

                    });


        }
        catch (RuntimeException r){r.printStackTrace()

        ;}


        return generatedString;
    }
//    @GetMapping("/getalluser")
//    public String getsql() throws IOException {
//        String generatedString = RandomStringUtils.randomAlphabetic(10);
//        File file = new File("D://"+"finace"+generatedString+".csv");
//        CSVWriter writer1;
//        FileWriter outputfile=new FileWriter(file);
//        writer1=new CSVWriter(outputfile);
//         services.findAll().doOnNext(s->{}).doOnComplete(()->{
//             try {
//                 writer1.close();
//             } catch (IOException e) {
//                 throw new RuntimeException(e);
//             }
//         }).subscribe(maps ->{
//             System.out.println(maps);
////            System.out.println(maps.get(0));
////              Object o=maps.get(0);
//
////             Object[] os=maps.toArray();
//
//
//         });
//       return  generatedString;
//    }
    @GetMapping(value = "/getallsqlss",produces = {"application/stream+json"})
    @ResponseBody
    public String getsqls() throws IOException {
        String generatedString = "finace"+RandomStringUtils.randomAlphabetic(10);
        File file = new File("D://"+"finace"+generatedString+".csv");
        Date date1 = new Date();
        FileWriter outputfile=new FileWriter(file);
//        CSVWriter writer1 = null;
        CSVWriter   writer1 = new CSVWriter(outputfile);
        String[] header =




                {"REF", "CNAME","CTITLE","CCITY","CCOUNTRY","CMOBILE","CEMAIL","TICKET_NO","clientname"
                        ,"AIRLINE_PNR","SP_PNR","TRIP_TYPE","ORIGIN","Origin","DESTINATION","NO_OF_SEGMENT","BOOKING_CLASS"
                        ,"CABIN_CLASS","SUPPLIER_NAME","TOTAL_BASE_FARE","TOTAL_FEE_N_TAXES","TOTAL_ODEYSYS_SERVICE_CHARGE"
                        ,"TOTAL_ODEYSYS_DISCOUNT","ODEYSYS_BSP_COMMISION","ODEYSYS_BSP_COMMISSION_PER","TOTAL_ODEYSYS_AGENCY_MARKUP"
                        ,"TOTAL_ODEYSYS_AGENT_ONFLY_MARKUP","TOTAL_ODEYSYS_FARE","PAYMENT_MODE","PTIME","AGENCY_ID"
                        ,"BRANCH_ID","BRANCH_ID","CDATE","SDATE","TCUST","UNAME","BSTATUS","OID","INVOICE_NUMBER"
                        ,"DOB","REFUNDAMOUNT","REFUNDCANCELATIONAMOUNT","AGENCYNAME","TOTAL_ODEYSYS_BRANCH_ONFLY_MARKUP"
                        ,"BOOKING_TYPE","IMPORT_PNR_CASE","ODEYSYS_BSP_COMMISSION_PER_CHILD","ODEYSYS_BSP_COMMISION_CHILD"
                        ,"PAX_BASE_FARE","PAX_FEE_N_TAXES","PAX_ODEYSYS_MARKUP","PAX_ODEYSYS_SERVICE_CHARGE"
                        ,"PAX_ODEYSYS_DISCOUNT","PAX_ODEYSYS_DISCOUNT","TCPAX","IATANUMBER","BRANCHNAME"
                        ,"REFUNDSTATUS","AGENTORDERSTATUS","MANUAL_MARKUP","PCCIATANUMBER","STATE_NAME"
                        ,"NDCSTAFFNAME","TOTAL_SURCHARGE_AMOUNT","CITY_NAME"

                };
        writer1.writeNext(header);

        //   rvPnrimportHistoryRepo.findAll()

        Flux<FinanceProjection> testing = services.findAlsl();
        testing.doOnNext(s->{}).doOnComplete(()->{
            try {
                writer1.close();
                Date date2 = new  Date();
                long diffInMillies = date2.getTime() - date1.getTime();
                System.out.println("Close after  " + diffInMillies);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).subscribe(rvPnrimportHistory ->{
//    System.out.println(maps.getTCPAX().getClass().getTypeName());

            header[0]=rvPnrimportHistory.getREF();
            header[1]=rvPnrimportHistory.getCITY_NAME();
            header[2]=rvPnrimportHistory.getCTITLE()+"";

            header[3]=rvPnrimportHistory.getCCITY()+"";
            header[4]=rvPnrimportHistory.getCMOBILE()+"";
            header[5]=rvPnrimportHistory.getCEMAIL();
            header[6]=rvPnrimportHistory.getTICKET_NO();
            header[7]=rvPnrimportHistory.getAIRLINE_PNR();
            header[8]=rvPnrimportHistory.getSP_PNR();
            header[9]=rvPnrimportHistory.getCCOUNTRY();
            header[10]=rvPnrimportHistory.getAIRLINE_PNR();
            header[11]=rvPnrimportHistory.getSP_PNR();
            header[12]=rvPnrimportHistory.getTRIP_TYPE()+"";
            header[13]=rvPnrimportHistory.getORIGIN();
            header[14]=rvPnrimportHistory.getDESTINATION();
            header[15]=rvPnrimportHistory.getNO_OF_SEGMENT()+"";
            header[16]=rvPnrimportHistory.getBOOKING_CLASS()+"";
            header[17]=rvPnrimportHistory.getCABIN_CLASS()+"";
            header[18]=rvPnrimportHistory.getSUPPLIER_NAME()+"";
            header[19]=rvPnrimportHistory.getPAX_FEE_N_TAXES()+"";
            header[20]=rvPnrimportHistory.getTOTAL_ODEYSYS_MARKUP()+"";
            header[21]=rvPnrimportHistory.getTOTAL_ODEYSYS_SERVICE_CHARGE()+"";
           header[22]=rvPnrimportHistory.getTOTAL_ODEYSYS_DISCOUNT()+"";
            header[23]=rvPnrimportHistory.getODEYSYS_BSP_COMMISION()+"";
            header[24]=  rvPnrimportHistory.getODEYSYS_BSP_COMMISSION_PER()+"";
            header[25]=  rvPnrimportHistory.getTOTAL_ODEYSYS_AGENCY_MARKUP()+"";
            header[26]=  rvPnrimportHistory.getTOTAL_ODEYSYS_AGENT_ONFLY_MARKUP()+"";
            header[27]=  rvPnrimportHistory.getTOTAL_ODEYSYS_FARE()+"";
            header[28]=  rvPnrimportHistory.getPAYMENT_MODE()+"";
           header[29]=  rvPnrimportHistory.getPTIME()+"";
          header[30]=  rvPnrimportHistory.getAGENCY_ID()+"";
            header[31]=  rvPnrimportHistory.getCDATE()+"";
            header[32]=  rvPnrimportHistory.getBOOKING_TYPE()+"";
            header[33]=  rvPnrimportHistory.getTOTAL_ODEYSYS_SERVICE_CHARGE()+"";
            header[34]=  rvPnrimportHistory.getTOTAL_BASE_FARE()+"";
            header[35]=  rvPnrimportHistory.getTCPAX()+"";
            header[36]=  rvPnrimportHistory.getAGENTORDERSTATUS()+"";
////            header[37]=  rvPnrimportHistory.p()+"";
            writer1.writeNext(header);

            file.setWritable(true);

        });
        return generatedString;

            }
}









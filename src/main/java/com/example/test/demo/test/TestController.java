package com.example.test.demo.test;

import com.example.test.demo.test.entitys.*;


import com.example.test.demo.test.historyService.HistoryService;
import com.example.test.demo.test.repos.*;
import com.example.test.demo.test.searchmodels.ReportSearch;
import com.example.test.demo.test.utils.Pnrhistoryexcel;
import com.example.test.demo.test.utils.ResponseMessage;
import com.example.test.demo.test.utils.StorageService;
import com.opencsv.CSVWriter;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.web.bind.annotation.*;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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
    @Autowired
    private  RvFinancialreportRepo rvFinancialreportRepo;
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
        List<TtUser > user=new ArrayList<>();
        String[] data2 = new String[3];
        List<String[]> data = new ArrayList<String[]>();
        File file = new File("D://ffb2.csv");
        CSVWriter writer1;
        FileWriter outputfile=new FileWriter(file);
        try {

            writer1 = new CSVWriter(outputfile);
            String[] header = {"firstName", "email"};
//            writer1.writeAll(data);
            String[] header2 = {"www", "ss"};
            String[] header3 = {"www3", "ss33"};
            writer1.writeNext(header);
            writer1.writeNext(header2);
            writer1.writeNext(header);
//             Flux<TtUser> all = new Flux[]{repo.findAll()};
            repo.findAll()
            .subscribe(ttUser ->{


                System.out.println(ttUser.getFirstName());
                writer1.writeNext(header3);
            });



        } finally {

            outputfile.close();
        return repo.findAll();
        }




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

    @GetMapping(value = "/preparehistoryd", produces = {"application/stream+json"})
    public ResponseEntity<Mono<Resource>> downloapdCsv() {
        String fileName = String.format("%s.csv", RandomStringUtils.randomAlphabetic(10));
//        csvWriterService.setAll(data());
        historyCvWriter.setAllpnr(rvPnrimportHistories);
        return ResponseEntity.ok()

                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
                .body(historyCvWriter.generateCsv()
                        .flatMap(x -> {
                            Resource resource = new InputStreamResource(x);
                            return Mono.just(resource);
                        }));

    }

    @PostMapping(value = "/byspnr", produces = {"application/stream+json"})
    @ResponseBody
    public Disposable rvPnrimportHistoryFlux(@RequestBody ReportSearch reportSearch) {
//        ReportSearch spnr =new ReportSearch("VIW5KK");
        rvPnrimportHistories = new ArrayList<RvPnrimportHistory>();
        return historyService.getbySpnr(reportSearch).subscribe(value -> {
            System.out.println("aaaaaaa"+value.getSpPnr());
            rvPnrimportHistories.add(value);
        });
    }
    @GetMapping (value = "/fr", produces = {"application/stream+json"})
    public Flux<RvFinancialreport> getf(){
        return rvFinancialreportRepo.findAll();
    }


   @GetMapping(value = "/emptiy")
    public  void empityCash(){
        rvPnrimportHistories=null;
       System.out.println("Cleard");
   }

    @GetMapping(value = "/getAlluserss", produces = {"application/stream+json"})
    public  Disposable preparse() throws IOException {
//        final int[] i = {0};
        List<TtUser > user=new ArrayList<>();
        String[] data2 = new String[3];
        List<String[]> data = new ArrayList<String[]>();
        File file = new File("D://ffb2.csv");
        CSVWriter writer1;
        FileWriter outputfile=new FileWriter(file);
        try {

            writer1 = new CSVWriter(outputfile);
            String[] header = {"firstName", "email"};
//            writer1.writeAll(data);
            String[] header2 = {"www", "ss"};
            String[] header3 = {"www3", "ss33"};
            writer1.writeNext(header);
            writer1.writeNext(header2);
            writer1.writeNext(header);
//             Flux<TtUser> all = new Flux[]{repo.findAll()};
          return   repo.findAll()
                    .subscribe(ttUser ->{

                    header3[0]=ttUser.getEmail();
                        System.out.println(ttUser.getFirstName());
                        writer1.writeNext(header3);
                    });



        }
        catch (RuntimeException r){r.printStackTrace();}

//        finally {
//
          outputfile.close();
//        }

        return null;
    }
    @PostMapping("/pnrstram")

public String gitpnrHistoryGeneratedfile(@RequestBody  ReportSearch reportSearch) throws IOException {
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
        String[] header = {"spnr", "orgname","suppliername"};


        writer1.writeNext(header);
//        services.getrv(reportSearch.getOrgname()
        rvPnrimportHistoryRepo.findAll().doOnNext(s->{
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

                    header[0]=rvPnrimportHistory.getAgentname();
                    header[1]=rvPnrimportHistory.getOrgname();
                    header[2]=rvPnrimportHistory.getSuppliername();
                    System.out.println(rvPnrimportHistory.getAgentname());
                    writer1.writeNext(header);
                    file.setWritable(true);
                    file.setWritable(true);
//                    s1=rvPnrimportHistory.getOrgname();

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
}









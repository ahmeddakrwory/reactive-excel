package com.example.test.demo.test;

import com.example.test.demo.test.entitys.*;

//import javax.annotation.Resource;
//import java.io.*;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.commons.lang3.RandomStringUtils;
//import org.springframework.core.io.InputStreamResource;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Mono;
import com.example.test.demo.test.historyService.HistoryService;
import com.example.test.demo.test.repos.*;
import com.example.test.demo.test.searchmodels.ReportSearch;
import com.example.test.demo.test.utils.Pnrhistoryexcel;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    private static File file;
    @Autowired
    private CsvWriterService csvWriterService;
    private static List<TtUser> users;
    private static List<RvPnrimportHistory> rvPnrimportHistories;
    private static List<RvPnrimportHistory> rvPnrimportHistories2;
    @Autowired
    private UserRepo repo;
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
    public Disposable prepare() {
        Flux<TtUser> all = repo.findAll();
        users = new ArrayList<TtUser>();
        return all.subscribe(valus -> {

            System.out.println("AAA" + valus.getEmail());
            users.add(valus);
        });
    }

    @GetMapping(value = "/download", produces = {"application/stream+json"})
//    @GetMapping(value = "/download")
    @ResponseBody

    public ResponseEntity<Mono<Resource>> downloadCsv() {
        String fileName = String.format("%s.csv", RandomStringUtils.randomAlphabetic(10));
        csvWriterService.setAll(data());
        return ResponseEntity.ok()

                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
                .body(csvWriterService.generateCsv()
                        .flatMap(x -> {
                            Resource resource = new InputStreamResource(x);
                            return Mono.just(resource);
                        }));
    }

    public List<TtUser> data() {
        return users;
    }

    @GetMapping(value = "/hql", produces = {"application/stream+json"})
    public Flux<TtUser> gethql() {
        return services.getsql();
    }

    @GetMapping(value = "/getOrgs", produces = {"application/stream+json"})
    public Flux<TtOrganization> getAllprgs() {
        return organnizationRepo.findAll();
    }

    @GetMapping("/empd")
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
}






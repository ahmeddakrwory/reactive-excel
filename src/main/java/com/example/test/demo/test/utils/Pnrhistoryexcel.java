package com.example.test.demo.test.utils;

import com.example.test.demo.test.entitys.RvPnrimportHistory;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
@Service
public class Pnrhistoryexcel {
//    String agentname="agentname";
//
//    String orgname="orgname";
//    String supplierName="suppliername";
//    String id ="id";
//    String spPnr="spPnr";
//
//    String importDateTime="importDateTime";
//    String pccId="pccId";
//    String pnrCreatedByOfficeId="pnrCreatedByOfficeId";
//    private List<RvPnrimportHistory> allpnr;
//
//    public List<RvPnrimportHistory> getAllpnr() {
//        return allpnr;
//    }
//
//    public void setAllpnr(List<RvPnrimportHistory> allpnr) {
//        this.allpnr = allpnr;
//    }
//
//    public Pnrhistoryexcel() {
//    }
//
//    public Mono<ByteArrayInputStream> generateCsv(){
//        String [] columns=new String[10] ;
//        columns[0]=agentname;
//        columns[1]=id;
//        columns[2]=orgname;
//        columns[3]=supplierName;
//        columns[4]=pccId;
//        columns[5]=spPnr;
//        columns[6]=importDateTime;
//        columns[7]=pnrCreatedByOfficeId;
//
//
//
//
//        return Mono.fromCallable(() -> {
//            try {
//                ByteArrayInOutStream stream = new ByteArrayInOutStream();
//                OutputStreamWriter streamWriter = new OutputStreamWriter(stream);
//                CSVWriter writer = new CSVWriter(streamWriter);
//
//                ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
//                mappingStrategy.setType(RvPnrimportHistory.class);
//                mappingStrategy.setColumnMapping(columns);
//                writer.writeNext(columns);
//
//                StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
//                        .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
//                        .withMappingStrategy(mappingStrategy)
//                        .withSeparator(',')
//                        .build();
//
//                beanToCsv.write(allpnr);
//                streamWriter.flush();
//                return stream.getInputStream();
//            }
//            catch (CsvException | IOException e) {
//                throw new RuntimeException(e);
//            }
//
//        }).subscribeOn(Schedulers.boundedElastic());
//
//    }
}


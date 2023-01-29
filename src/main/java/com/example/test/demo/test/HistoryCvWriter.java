package com.example.test.demo.test;

import com.example.test.demo.test.entitys.RvPnrimportHistory;
import com.example.test.demo.test.utils.ByteArrayInOutStream;
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
public class HistoryCvWriter {
    String agentname="agentname";

     String orgName="orgName";
     String suppliername="suppliername";
     String id ="id";
    String pnrCreatedByOfficeId="pnrCreatedByOfficeId";

     String importDateTime="importDateTime";
     String pccId="pccId";
     String agentId="agentId";
    private List< RvPnrimportHistory> allpnr;

    public List<RvPnrimportHistory> getAllpnr() {
        return allpnr;
    }

    public void setAllpnr(List<RvPnrimportHistory> allpnr) {
        this.allpnr = allpnr;
    }

    public HistoryCvWriter() {
    }
    public Mono<ByteArrayInputStream> generateCsv(){
        String [] columns=new String[9] ;
        columns[0]=agentname;
        columns[1]=id;
        columns[2]=orgName;
        columns[3]=suppliername;

        columns[5]=pccId;
        columns[6]=importDateTime;
         columns[7]=pnrCreatedByOfficeId;


//    List<User> users = new ArrayList<>();
//    users.add(new User("Adewale Joseph", "adewale.joseph@example.com", "UK"));
//    users.add(new User("Adam Shaw", "adam.shaw@example.com", "DE"));
//    users.add(new User("Bisi Olukoja", "bisi@example.com", "US"));

        return Mono.fromCallable(() -> {
            try {
                ByteArrayInOutStream stream = new ByteArrayInOutStream();
                OutputStreamWriter streamWriter = new OutputStreamWriter(stream);
                CSVWriter writer = new CSVWriter(streamWriter);

                ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
                mappingStrategy.setType(RvPnrimportHistory.class);
                mappingStrategy.setColumnMapping(columns);
                writer.writeNext(columns);

                StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
                        .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                        .withMappingStrategy(mappingStrategy)
                        .withSeparator(',')
                        .build();

                beanToCsv.write(allpnr);
                streamWriter.flush();
                return stream.getInputStream();
            }
            catch (CsvException | IOException e) {
                throw new RuntimeException(e);
            }

        }).subscribeOn(Schedulers.boundedElastic());

    }
}

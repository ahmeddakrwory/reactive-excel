package com.example.test.demo.test;

import com.example.test.demo.test.entitys.TtUser;
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
class CsvWriterService {
 String userId="userId";
 String userAlias="userAlias";
 String password="   password  ";
    public CsvWriterService() {
    }

    private List<TtUser> all;



    public List<TtUser> getAll() {
        return all;
    }

    public void setAll(List<TtUser> all) {
        this.all = all;
    }
//    public Mono<ByteArrayInputStream> generateCsv(){
//        String[] columns = {"name","id"};
//        ArrayList<Muset> aaa=new ArrayList<>();
//        aaa.add(new Muset("Ahmed",1));
//        setAll(aaa);
////        List<Region>all=regionRepository.findAll();
//        return Mono.fromCallable(() -> {
//            try {
//                ByteArrayInOutStream stream = new ByteArrayInOutStream();
//                OutputStreamWriter streamWriter = new OutputStreamWriter(stream);
//                CSVWriter writer = new CSVWriter(streamWriter);
//
//                ColumnPositionMappingStrategy mappingStrategy = new ColumnPositionMappingStrategy();
//                mappingStrategy.setType(Muset.class);
//                mappingStrategy.setColumnMapping(columns);
//                writer.writeNext(columns);
//
//                StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
//                        .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
//                        .withMappingStrategy(mappingStrategy)
//                        .withSeparator(',')
//                        .build();
//
//                beanToCsv.write(getAll());
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
public Mono<ByteArrayInputStream> generateCsv(){
    String [] columns=new String[5] ;
    columns[0]=userId;
    columns[1]=userAlias;


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
            mappingStrategy.setType(TtUser.class);
            mappingStrategy.setColumnMapping(columns);
            writer.writeNext(columns);

            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withMappingStrategy(mappingStrategy)
                .withSeparator(',')
                    .build();

            beanToCsv.write(all);
            streamWriter.flush();
            return stream.getInputStream();
        }
        catch (CsvException | IOException e) {
            throw new RuntimeException(e);
        }

    }).subscribeOn(Schedulers.boundedElastic());

}
}





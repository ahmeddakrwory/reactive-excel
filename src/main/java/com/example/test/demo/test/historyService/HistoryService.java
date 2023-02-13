package com.example.test.demo.test.historyService;

import com.example.test.demo.test.entitys.RvPnrimportHistory;
import com.example.test.demo.test.entitys.TtUser;
import com.example.test.demo.test.searchmodels.ReportSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

import java.sql.Date;
import java.time.Instant;
import java.time.InstantSource;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.springframework.data.relational.core.query.Criteria.where;
import static org.springframework.data.relational.core.query.Query.query;

@Service
public class HistoryService {
    @Autowired
    private R2dbcEntityTemplate entityTemplate;
    final DatabaseClient db;

    public HistoryService(DatabaseClient db) {
        this.db = db;

    }



    @Transactional
    public Flux<RvPnrimportHistory>getbySpnr(ReportSearch reportSearch){
        return  entityTemplate.select(query(where("orgname").in(reportSearch.getOrgname()).and("importDateTime").between(reportSearch.getFdate(),reportSearch.getTdate())), RvPnrimportHistory.class);
    }
    public Flux<RvPnrimportHistory>date(ReportSearch reportSearch){
LocalDateTime date1= LocalDateTime.of(2022,6,1,00,00);
      LocalDateTime date2= LocalDateTime.of(2022,7,31,00,00);
        return  entityTemplate.select(query(where("importDateTime").between(date1,date2)).limit(10), RvPnrimportHistory.class);
    }
}

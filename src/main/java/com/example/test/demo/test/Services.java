package com.example.test.demo.test;

import com.example.test.demo.test.entitys.TtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;


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
//   @Transactional
//    public Flux<TtUser>getsql(){
//
//        entityTemplate.getDatabaseClient().sql("SELECT  * FROM  tt_user").map(row ->
//                row.
//
//                )
//   }



}

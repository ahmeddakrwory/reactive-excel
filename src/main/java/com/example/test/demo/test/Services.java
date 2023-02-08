package com.example.test.demo.test;

import com.example.test.demo.test.entitys.RvPnrimportHistory;
import com.example.test.demo.test.entitys.TtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;

import javax.persistence.StoredProcedureQuery;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.Sort.Order.by;
import static org.springframework.data.domain.Sort.Order.desc;
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
}

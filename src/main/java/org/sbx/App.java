package org.sbx;

import org.sbx.model.Record;
import org.sbx.services.RecordService;
import org.sbx.services.impl.RecordServiceImpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by isilme on 4/13/17.
 */
public class App {

    public static void main(String[] args){

        RecordService recordService = new RecordServiceImpl();

        List<Record> list = new ArrayList<Record>();
        Record record = null;

//        for (int i = 0; i < 1000; i++){
//            record = new Record();
//            record.setTitle("Title " + i);
//            record.setAuthor("Author");
//            record.setDate(new Date(new java.util.Date().getTime()));
//            record.setBody("Main record text " + i);
//
//            list.add(record);
//        }
//
//        recordService.addRecords(list);

        for (Record r: recordService.getAllRecords()){
            System.out.println(r);
        }

    }

}

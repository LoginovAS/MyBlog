package org.sbx.servlets;

import org.sbx.model.Record;
import org.sbx.services.RecordService;
import org.sbx.services.impl.RecordServiceImpl;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

/**
 * Created by isilme on 4/15/17.
 */
@WebServlet("/add-data")
public class AddDataServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RecordService recordService = new RecordServiceImpl();
        HttpSession session = request.getSession();

        Record record = (Record) request.getAttribute("recordBean");
        System.out.println(record);
        record.setDate(new Date(new java.util.Date().getTime()));
        record.setAuthor("Author");

//        String recordTitle = request.getParameter("recordTitle");
//        System.out.println(recordTitle);
//        String recordText = request.getParameter("recordText");
//
//        Record record = new Record();
//        record.setTitle(recordTitle);
//        record.setAuthor("Author");
//        record.setDate(new Date(new java.util.Date().getTime()));
//        record.setBody(recordText);
//
//        recordService.addRecord(record);
    }
}

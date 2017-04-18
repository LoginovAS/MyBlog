package org.sbx.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sbx.model.impl.Record;
import org.sbx.services.RecordService;
import org.sbx.services.impl.RecordServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/add-data")
public class AddDataServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(AddDataServlet.class);

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RecordService recordService = new RecordServiceImpl();

        request.setAttribute("success", recordService.addRecord(setRecord(request)));

        request.getRequestDispatcher("/add_new_record.jsp").forward(request, response);
    }

    private Record setRecord(HttpServletRequest request){
        Record record = new Record();
        record.newBuilder()
                .setTitle(request.getParameter("recordTitle"))
                .setAuthor(request.getParameter("recordAuthor"))
                .setDate(new Date(new java.util.Date().getTime()))
                .setBody(request.getParameter("recordText"))
                .build();

        return record;
    }
}

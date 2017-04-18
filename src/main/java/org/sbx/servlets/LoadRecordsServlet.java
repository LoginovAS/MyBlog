package org.sbx.servlets;

import org.sbx.services.RecordService;
import org.sbx.services.impl.RecordServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/load-data")
public class LoadRecordsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RecordService recordService = new RecordServiceImpl();

        request.setAttribute("recordList", recordService.getAllRecords());

        request.getRequestDispatcher("/show_records.jsp").forward(request, response);

    }

}

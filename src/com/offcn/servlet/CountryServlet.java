package com.offcn.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.offcn.bean.Country;
import com.offcn.dao.CountryDao;
import com.offcn.dao.CountryDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/CountryServlet")
public class CountryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          //调用方法
        CountryDao cd=new CountryDaoImpl();
        List<Country> list = cd.selectAllCountry();

        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(list);

        writer.print(s);
        System.out.println(s);
    }
}

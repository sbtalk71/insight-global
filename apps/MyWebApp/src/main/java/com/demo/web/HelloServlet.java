package com.demo.web;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        PrintWriter out=servletResponse.getWriter();
       String html ="""
        <html>
            <head>
            </head>
            <body>
            <h1>This is an HTMl File</h1>
            </body>
        </html>
        """;
        out.write(html);
        System.out.println(Thread.currentThread().getName());
    }
}

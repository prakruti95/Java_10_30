package com.example.servlet;

import com.example.dao.StudentDAO;
import com.example.model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    StudentDAO dao = new StudentDAO();

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");

        Student s = new Student();
        s.setName(name);
        s.setEmail(email);

        dao.save(s);

        resp.sendRedirect("index.jsp");
    }
}
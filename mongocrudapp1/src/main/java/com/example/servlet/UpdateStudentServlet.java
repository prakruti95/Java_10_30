package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.example.dao.StudentDAO;
import com.example.model.Student;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

    StudentDAO dao = new StudentDAO();

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        Student s = new Student();

        s.setId(request.getParameter("id"));
        s.setName(request.getParameter("name"));
        s.setEmail(request.getParameter("email"));

        dao.update(s);

        response.sendRedirect("students");
    }
}
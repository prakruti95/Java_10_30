package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.example.dao.StudentDAO;

@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {

    StudentDAO dao = new StudentDAO();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        dao.delete(id);

        response.sendRedirect("students");
    }
}
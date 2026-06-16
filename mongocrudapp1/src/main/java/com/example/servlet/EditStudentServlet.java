package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.example.dao.StudentDAO;
import com.example.model.Student;

@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet {

    StudentDAO dao = new StudentDAO();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        Student student = dao.getById(id);

        request.setAttribute("student", student);

        request.getRequestDispatcher("editStudent.jsp")
               .forward(request, response);
    }
}
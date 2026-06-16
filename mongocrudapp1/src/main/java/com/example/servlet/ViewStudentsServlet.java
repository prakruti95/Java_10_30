package com.example.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.StudentDAO;
import com.example.model.Student;

@WebServlet("/students")
public class ViewStudentsServlet extends HttpServlet {

    StudentDAO dao = new StudentDAO();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<Student> students = dao.getAll();

        request.setAttribute("students", students);

        request.getRequestDispatcher("viewStudents.jsp")
               .forward(request, response);
    }
}
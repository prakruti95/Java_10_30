import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;  

public class MyServlet2 extends HttpServlet {  

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
          
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  

        // Get the username and display a welcome message
        String username = request.getParameter("userName");  
        out.print("Welcome " + username);  
    }  
}
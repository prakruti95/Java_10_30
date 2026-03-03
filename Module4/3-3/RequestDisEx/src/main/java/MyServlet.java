import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;  


public class MyServlet extends HttpServlet {  

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
          
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  

        // Get the username and password from the form
        String username = request.getParameter("userName");  
        String password = request.getParameter("userPass");  

        // Check if the password is "servlet"
        if(password.equals("servlet")) 
        {  
            // Forward the request to WelcomeServlet
            RequestDispatcher rd = request.getRequestDispatcher("MyServlet2");  
            rd.forward(request, response);  
        } else {  
            // Display error message and include the original form (index.html)
            out.print("Sorry, username or password error!");  
            RequestDispatcher rd = request.getRequestDispatcher("index.html");  
            rd.include(request, response);  
        }  
    }  
}
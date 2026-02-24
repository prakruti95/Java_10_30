import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/signup")
public class SignupServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String uname = req.getParameter("username");
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		
		SignupModel m = new SignupModel();
		m.setUsername(uname);
		m.setEmail(email);
		m.setPassword(pass);
		
		int status = Dao.signupdata(m);
		
		if(status>0)
		{
			out.print("Inserted");
			resp.sendRedirect("SigninServlet");
			//System.out.println("Inserted");
		}
		else
		{
			out.print("Fail");
			
		}
		
		
		
	}
}

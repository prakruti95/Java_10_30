

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/send2")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
	
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		String e = req.getParameter("email");
		String p = req.getParameter("password");
		
		Model m = new Model();
		m.setEmail(e);
		m.setPassword(p);
		
		Model m2 = Dao.logindata(m);
		
		if(m2!=null)
		{
			HttpSession sess = req.getSession();
			sess.setAttribute("project",true);
			
			resp.sendRedirect("dashboard.html");	
			//out.print("Login Success");
		}
		else
		{
			//resp.sendRedirect("");
			out.print("Login Fail");
		}
		
		
		
		
		
	}
}

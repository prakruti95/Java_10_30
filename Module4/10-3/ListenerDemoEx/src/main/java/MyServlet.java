
/*

Here we create hit counter with listner 

*/
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	ServletContext context;
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.context=config.getServletContext();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int counter=1;
		
		if(context.getAttribute("counter")!=null)
		{
			counter=Integer.parseInt(context.getAttribute("counter").toString());
			counter++;
		}
		
		context.setAttribute("counter", counter);
		
		out.println("You are visiting this web page "+counter+" Times");
	}

}

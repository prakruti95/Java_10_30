import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		HttpSession sess = req.getSession();
		if(sess.getAttribute("project")!=null)
		{

			String pname = req.getParameter("pname");
			String pprice = req.getParameter("pprice");
			String pdes = req.getParameter("pdes");
		
			ProductModel pm = new ProductModel();
			pm.setPname(pname);
			pm.setPprice(pprice);
			pm.setPdes(pdes);
			System.out.println("Hello");
//			int status = Dao.addproduct(pm);
//		
//			if(status>0)
//			{
//				resp.sendRedirect("ViewServlet");
//			}
//			else
//			{
//				out.print("Product Added Fail");
//			}
			
		}
		else
		{
			out.print("<p>Please Login First</p>");
		}
		
		
		
	}
}

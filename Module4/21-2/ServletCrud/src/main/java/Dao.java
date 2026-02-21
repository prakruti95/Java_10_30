import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao 
{
	
	public static Connection getconnect()
	{
		Connection con = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","");
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return con;
	}
	
	public static int savedata(Model m)
	{
		Connection con = Dao.getconnect();
		int status = 0;
		try 
		{
			String sql = "insert into products(pname,pprice,pdes)values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,m.getPname());
			ps.setString(2,m.getPprice());
			ps.setString(3,m.getPdes());
			
			status = ps.executeUpdate();
			

		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static List<Model>viewdata()
	{
		List<Model>list = new ArrayList();
		Connection con = Dao.getconnect();
		String sql = "select * from products";
		try 
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet set = ps.executeQuery();
			
			while(set.next())
			{
				Model m = new Model();
				m.setId(set.getInt(1));
				m.setPname(set.getString(2));
				m.setPprice(set.getString(3));
				m.setPdes(set.getString(4));
				
				list.add(m);
			}
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
}

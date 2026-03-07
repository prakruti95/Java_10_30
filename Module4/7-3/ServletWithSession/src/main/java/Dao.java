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
			e.printStackTrace();
		}

		return con;
	}
	

	public static int savedata(Model m)
	{
		int status = 0;
		
		Connection con = Dao.getconnect();
		
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("insert into info (username,email,password) values (?,?,?)");
			ps.setString(1,m.getUsername());
			ps.setString(2,m.getEmail());
			ps.setString(3,m.getPassword());
			
			status = ps.executeUpdate();
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	
		return status;
	}
	
	
	public static Model logindata(Model m)
	{
		Model m2 = null;
		
		Connection con = Dao.getconnect();
		
		
		try 
		{
			PreparedStatement ps = con.prepareStatement("Select * from info where email=? and password=?");
			
			ps.setString(1,m.getEmail());
			ps.setString(2,m.getPassword());
			
			ResultSet set = ps.executeQuery();
			
			if(set.next())
			{
				int id = set.getInt(1);
				String uname = set.getString(2);
				String email = set.getString(3);
				String pass = set.getString(4);
				
				
				m2 = new Model();
				m2.setId(id);
				m2.setUsername(uname);
				m2.setEmail(email);
				m2.setPassword(pass);
			}
			else
			{
				
			}
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	
		return m2;
	}
	
	
}
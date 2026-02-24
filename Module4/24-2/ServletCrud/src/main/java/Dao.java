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
	
	public static int deletedata(int id)
	{
		Connection con = Dao.getconnect();
		int status = 0;
		try 
		{
			String sql = "delete from products where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			
			
			status = ps.executeUpdate();
			

		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static Model getrecord(int id)
	{
		Model m = null;
		Connection con = Dao.getconnect();
		String sql = "select * from products where id=?";
		try 
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet set = ps.executeQuery();
			
			if(set.next())
			{
				m = new Model();
				m.setId(set.getInt(1));
				m.setPname(set.getString(2));
				m.setPprice(set.getString(3));
				m.setPdes(set.getString(4));
				
				
			}
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return m;
	}
	
	public static int updatedata(Model m)
	{
		Connection con = Dao.getconnect();
		int status = 0;
		try 
		{
			String sql = "update products set pname=?,pprice=?,pdes=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,m.getPname());
			ps.setString(2,m.getPprice());
			ps.setString(3,m.getPdes());
			ps.setInt(4,m.getId());
			
			status = ps.executeUpdate();
			

		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static int signupdata(SignupModel m)
	{
		Connection con = Dao.getconnect();
		int status = 0;
		try 
		{
			String sql = "insert into users(username,email,password)values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,m.getUsername());
			ps.setString(2,m.getEmail());
			ps.setString(3,m.getPassword());
			
			status = ps.executeUpdate();
			

		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static SignupModel checksignin(SignupModel m)
	{
		SignupModel m2 = null;
		Connection con = Dao.getconnect();
		String sql = "select * from users where email=? and password=?";
		try 
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, m.getEmail());
			ps.setString(2, m.getPassword());
			ResultSet set = ps.executeQuery();
			
			if(set.next())
			{
				
				int id = set.getInt(1);
				String uname = set.getString(2);
				String email = set.getString(3);
				String pass = set.getString(4);
				
				
				m2 = new SignupModel();
				m2.setId(id);
				m2.setUsername(uname);
				m2.setEmail(email);
				m2.setPassword(pass);				
				
			}
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return m2;
	}
	
}

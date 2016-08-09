package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO 
{
	Connection con;
	public UserDAO(Connection con)
	{
		this.con = con;
	}
	public boolean select(String id, String pw)
	{
		boolean result = false;
		
		try{
			String sql = "select * from user_tbl where uid =? and upw = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			ResultSet rs = new pstmt.executeQuery();
			if(rs.next())
			{
				result = true;
			}else
			{
				result = false;
			}
			
		}catch(Exception e)
		{
			System.out.print(e);
		}
		
		return result;
	}
}

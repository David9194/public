package service;

import java.sql.Connection;

import dao.UserDAO;

public class UserService {
	
	// transaction은 하나의 단위 작업
	// service안의 method하나의 단위 작업을 수행
	// -> 사용자 로그인, 사용자 등록, 사요자 삭제
	// 일반적으로 이 런 하나의 작업을 여러개의 SQL로 분할.
	// transcation처리는java에서 connection단위로 처리

	public boolean login(String id, String pw)
	{
		boolean result = false;
		Connection con = common.DBTemplate.getConnection();
		
		UserDAO dao = new UserDAO(con);
		result = dao.select(id, pw);
		try{
			if(result)
			{
				con.commit();
			}else
			{
				con.rollback();
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return result;
	}
}

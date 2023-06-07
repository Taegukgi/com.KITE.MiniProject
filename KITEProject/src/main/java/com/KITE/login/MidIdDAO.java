package com.KITE.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.KITE.common.DataSourceManager;

public class MidIdDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	private static MidIdDAO instance = new MidIdDAO();
	private DataSource dataSource;
	
	private MidIdDAO() {
		dataSource = DataSourceManager.getInstance().getDataSource();
	}
	
	public static MidIdDAO getInstance() {
		return instance;
	}
	
	//Connection를 dbcp에 반납
	public void closeAll() {
		
		try {
			
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
			
			System.out.println("DB Connection Pool Resource Dismissed!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String MidId(String licenseKey) {
		String userId = null;
		String query = "SELECT USERID FROM ACCOUNT WHERE LICENSEKEY = ?";
		
		try {
			conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, licenseKey);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				userId = rs.getString("userId");
				System.out.println(userId);
			}
		}catch(Exception e) {
			System.out.println(userId);
			e.printStackTrace();
		}finally {
			try {
				if(rs != null ) rs.close();
				if(pstmt != null) pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return userId;
	}
}
	

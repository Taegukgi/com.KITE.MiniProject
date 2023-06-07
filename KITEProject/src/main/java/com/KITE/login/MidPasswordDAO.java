package com.KITE.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.KITE.SignUP.MemberDTO;
import com.KITE.common.DataSourceManager;

public class MidPasswordDAO {
	//비밀번호 찾기
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private static MidPasswordDAO instance = new MidPasswordDAO();
	private DataSource dataSource;
	
	private MidPasswordDAO() {
		dataSource = DataSourceManager.getInstance().getDataSource();
	}
	
	public static MidPasswordDAO getInstance() {
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
	
	
	public String MidPassword(MemberDTO mDto) {
		String password = null;
		String query = "SELECT PASSWORD FROM ACCOUNT WHERE USERID=? and LICENSEKEY=?";
		
		try {
			conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mDto.getUserId());
			pstmt.setString(2, mDto.getLicenseKey());
			rs = pstmt.executeQuery();
			
			System.out.println(mDto.getUserId());
			System.out.println(mDto.getLicenseKey());
			
			if(rs.next()) {
				password = rs.getString("password");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				
			}catch(Exception e) {
				e.printStackTrace();
		}
	}
		return password;
		
	}
}

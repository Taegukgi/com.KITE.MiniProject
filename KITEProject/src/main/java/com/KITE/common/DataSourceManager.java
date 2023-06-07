package com.KITE.common;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DataSourceManager {
	private static DataSourceManager instance = new DataSourceManager();
	private DataSource dataSource;
	
	private DataSourceManager() {
		
		BasicDataSource dbcp = new BasicDataSource();
		
		dbcp.setDriverClassName("com.mysql.cj.jdbc.mysql.Driver");
		dbcp.setUrl("jdbc:mysql://localhost:3306/miniproject");
		dbcp.setUsername("root");
		dbcp.setPassword("1234");
		
		dbcp.setInitialSize(3);
		
		dbcp.setMaxTotal(10);
		
		this.dataSource = dbcp;
		
	}
	
	public static DataSourceManager getInstance() {
		return instance;
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	

}

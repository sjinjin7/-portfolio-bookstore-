package com.sjb.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCTests {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = " jdbc:mysql://localhost:3306/ksj?serverTimezone=Asia/Seoul";
	private static final String USER = "root";
	private static final String PW = "1234";
	
	@Test
	public void testConnection() throws Exception{
	
		Class.forName(DRIVER);
		try(Connection con = DriverManager.getConnection(URL, USER, PW)){
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

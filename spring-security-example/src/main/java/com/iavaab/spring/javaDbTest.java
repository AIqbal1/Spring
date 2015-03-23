package com.iavaab.spring;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
 
public class javaDbTest {
 
	public static void main(String[] argv) {
		
		
	
			
			List<String> openBetPhaseCode = new ArrayList<String>();
			for(int i =0; i<10; i++) {
				openBetPhaseCode.add(Integer.toString(i));			
			}		
			
			System.out.println(StringUtils.join(openBetPhaseCode.toArray(), ","));
			
			int[] codes = new int[openBetPhaseCode.size()];
						
			
		
		
 
		System.out.println("-------- MySQL JDBC Connection Testing ------------");
 
		try {
 
			Class.forName("com.mysql.jdbc.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
 
		}
 
		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
 
		try {
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/spring_security",
							"root", "");
 
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
}

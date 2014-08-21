package dateProcess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class PartTest {
	@Test
	public void test1(){
		String username="root";
		String password="yyyy";
		String url="jdbc:mysql://127.0.0.1:3306/test";
		String driverName="com.mysql.jdbc.Driver";
		try {
			Class.forName(driverName);
			Connection conn=DriverManager.getConnection(url, username, password);
			if(conn.isClosed()){
				///conn.close();
				System.out.println("conn is closed;");
				return;
			}
			Statement stment=conn.createStatement();
			String sql="select * from test_alarm1";
			String str="yuantest95A5944469368E8B558A7E32B	2009-11-24	test	0	1	3	20E50042893F4D208B97F808DAAD2541	1	2	2013-11-22	0	2013-11-22	0000-00-00 ";
			String str1=str.replace("\t", "\',\'");
			str1="\'"+str1+"\'";
			System.out.println(str1);
			String sql2="insert into test_alarm1 values("+str1+")";
			System.out.println(sql2);
			stment.executeUpdate(sql2);
//			ResultSet rs = stment.executeQuery(sql);  
//			System.out.println("-----------------");  
//			System.out.println("执行结果如下所示:");  
//			System.out.println("-----------------");  
//			System.out.println("data " + "\t" + " date1");  
//			System.out.println("-----------------");  
//			String name = null;
//			while(rs.next()){
//				//rs.
//				//﻿F3CF2B495A5944469368E8B558A7E32B	2009-11-24	test	0	1	3	20E50042893F4D208B97F808DAAD2541	1	2	2013-11-22	0	2013-11-22	0000-00-00
//
//				//System.out.println("data is all "+rs.);
//				System.out.println("data is "+rs.getString("ID")+"\n");
//			}
//			rs.close();  
			conn.close(); 
			System.out.println("success!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

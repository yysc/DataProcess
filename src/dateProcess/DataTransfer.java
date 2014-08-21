package dateProcess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import sun.util.logging.resources.logging;


public class DataTransfer {	
	static Logger logger=Logger.getLogger(DataTransfer.class.getName());
	
	public static Statement connectSQL(){
		String username="root";
		String password="yyyy";
		String url="jdbc:mysql://127.0.0.1:3306/test";
		String driverName="com.mysql.jdbc.Driver";
		Statement stment=null;
		try {
			Class.forName(driverName);
			Connection conn=DriverManager.getConnection(url, username, password);
			if(conn.isClosed()){
				System.out.println("conn is closed;");
				System.exit(0);
			}
			stment=conn.createStatement();
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
			System.exit(0);
			
		}catch(SQLException e2){
			e2.printStackTrace();
			System.exit(0);
			
		}
		return stment;
	}
		
	public static void insertToTable(String insertData,Statement stment,String table_name){//1 insert 0 not insert;
		
		String forInsert=null;
		
		//forInsert=forInsert.replace("null","2001-01-02");
			
		//*************for choose not null data to insert 5 13   0 null  0 0 null null null 0 			
			String splitOfInsertData[]=insertData.split(",");
			//logger.info(splitOfInsertData[13]+splitOfInsertData[14]+splitOfInsertData[15]+(!splitOfInsertData[15].equals("null")));
			//logger.info(((!splitOfInsertData[13].equals("0"))||(!splitOfInsertData[6].equals("0")))&&((!splitOfInsertData[13].equals("null"))&&(!splitOfInsertData[6].equals("null"))));
			if(((!splitOfInsertData[5].equals("0"))||(!splitOfInsertData[6].equals("0")))&&((!splitOfInsertData[5].equals("null"))&&(!splitOfInsertData[6].equals("null")))){
				forInsert=insertData.replace(",", "\',\'");
				forInsert="\'"+forInsert+"\'";
				forInsert=forInsert.replace("\'null\'", "null");
				//System.out.println(forInsert);
				forInsert="insert into "+table_name+" values("+forInsert+")";
				//String sql="insert into "+table_name+" values("+forInsert+")";
				//logger.info(forInsert);
				try{
					stment.executeUpdate(forInsert);		
				}catch(SQLException e){
					e.printStackTrace();
				}	
	
			}
			//*************for choose not null data to insert

		
//		forInsert=insertData.replace(",", "\',\'");
//		forInsert="\'"+forInsert+"\'";
//		forInsert=forInsert.replace("\'null\'", "null");
//		System.out.println(forInsert);
//		String sql="insert into "+table_name+" values("+forInsert+")";
//
//		try{
//			stment.executeUpdate(sql);		
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
	}

	public void closedConnection(Connection conn) {
		try{
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
			return;
		}
	}
	
	public static String transferData(String dataOld){

		String str=dataOld.replace("\t", "\',\'");
		str="\'"+str+"\'";
		String finalStr="insert into test_alarm1 values("+str+")";
		return finalStr;
	}
	
	public static String ifHazPosition(String forcheck){
		
		return null;
	}
	
	@Test
	public void testPart() throws IOException{
		
		//File flread=new File("D:/root/VEHICLETRACKINFO/part-m-00000");//ALARMINFORMATION
		long startTime=System.currentTimeMillis();
		long endTime;
		//Logger logger=Logger.getLogger(DataTransfer.class.getName());
		//logger.info("start.");
		//PropertyConfigurator.configure("log4j.properties");
		File flread=new File("D:/root/ALARMINFORMATION/part-m-00000");
		flread=new File("D:/root/VEHICLETRACKINFO/part-m-00000");//ALARMINFORMATION
		String insertData;
		int line=1;	
		String tablename="vehicletrackinformation";
		//tablename="test_alarm1";
		
		BufferedReader reader=new BufferedReader(new FileReader(flread));
		//conection sql
		String username="root";
		String password="yyyy";
		String url="jdbc:mysql://127.0.0.1:3306/test";
		String driverName="com.mysql.jdbc.Driver";
		Connection conn=null;
		Statement stment=null;
		try {
			Class.forName(driverName);
			conn=DriverManager.getConnection(url, username, password);
			if(conn.isClosed()){
				logger.info("conn is closed;");
				System.exit(0);
			}
			stment=conn.createStatement();
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
			System.exit(0);
			
		}catch(SQLException e2){
			e2.printStackTrace();
			System.exit(0);			
		}

		logger.info("connection success  "+(System.currentTimeMillis()-startTime));
		
		insertData=reader.readLine();
		
		while(insertData!=null){
	
			insertToTable(insertData,stment,tablename);
//			line++;
			insertData=reader.readLine();	
//			if(line==100){
//				break;
//			}
		}
		reader.close();

		//connection closed
		try{
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
			return;
		}
		logger.info("insert complete .running "+(System.currentTimeMillis()-startTime)+"ms in total");
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File flread=new File("D:/root/VEHICLETRACKINFO/part-m-00000");
		BufferedReader reader=new BufferedReader(new FileReader(flread));
		String insertData;
		int line=1;		
		Statement stmt=connectSQL();
		String table_name="vehicletrackinfo";
		
		//conection sql
		String username="root";
		String password="yyyy";
		String url="jdbc:mysql://127.0.0.1:3306/test";
		String driverName="com.mysql.jdbc.Driver";
		Connection conn=null;
		Statement stment=null;
		try {
			Class.forName(driverName);
			conn=DriverManager.getConnection(url, username, password);
			if(conn.isClosed()){
				System.out.println("conn is closed;");
				System.exit(0);
			}
			stment=conn.createStatement();
		}catch(ClassNotFoundException e1){
			e1.printStackTrace();
			System.exit(0);
			
		}catch(SQLException e2){
			e2.printStackTrace();
			System.exit(0);			
		}
		
		insertData=reader.readLine();
		while(insertData!=null){
			insertToTable(insertData,stmt,table_name);
			line++;
			insertData=reader.readLine();	
		}

		//connection closed
		try{
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
			return;
		}
		System.out.println("insert complete");
	}

}

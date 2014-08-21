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

//test only
public class CopyOfDataTransfer {	
	
	public Statement connectSQL(){
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
		
	public void insertToTable(String insertData,Statement stment){
		
		String forInsert=null;
		forInsert=insertData.replace("\t", "\',\'");
		forInsert="\'"+forInsert+"\'";
		String sql="insert into test_alarm1 values("+forInsert+")";
		try{
			stment.executeUpdate(sql);		
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void closedConnection(Connection conn) {
		try{
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
			return;
		}
	}
	
	public void findAndInsert(){
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File flread=new File("D:/root/VEHICLETRACKINFO/part-m-00000");
		File flwrite=new File("D:/root/ALARMINFORMATION/writetest.txt");
		BufferedReader reader=null;
		Integer dateStart=null;
		Integer dateEnd=null;
		dateStart=0201;
		dateEnd=0403;
		//date=0312;
		Integer startmonth=dateStart/100;
		Integer endmonth=dateEnd/100;
		Integer startdate=dateStart%100;
		Integer enddate=dateEnd%100;
		Integer date1=null;
		Integer date2=null;
		String strtemp1[]=null;
		String str=null;
		String strtemp[]=null;
		String[] strtemp2;
		Integer month1, month2;
		
		int line=1;
//		line=;
		boolean beforeNull=true;
		boolean afterNull=false;

		if(flwrite.exists()){
			System.out.println("file exits.");
		}else{
			System.out.println("not exits.");
			if(flwrite.createNewFile()){
				System.out.println("create successful");	
			}else{
				System.out.println("failed to create");
			}
		}
		
//		bufferedReader input=new bufferedReader(new FileReader);
		try {
			reader=new BufferedReader(new FileReader(flread));
			
			str=reader.readLine();
			while(str!=null){				
				str=reader.readLine();
				strtemp=str.split(",");
				
				strtemp1=strtemp[3].split("-");// 2014 3 2
				strtemp2=strtemp[4].split("-");
				
				month1=Integer.parseInt(strtemp1[1]);
				month2=Integer.parseInt(strtemp2[1]);
				
				date1=Integer.parseInt(strtemp1[2]);
				date2=Integer.parseInt(strtemp1[2]);
				
				//between startdate and enddate
				//month1 col [3] month between;
//				if((month1>startmonth)&&(month1<endmonth)&&(date1>startdate)&&(date1<enddate)){
//					System.out.println("file  line "+line+" is "+str);
//					continue;
//					//插入数据库；	
//				}				
							
				if(!(strtemp[5].equals("0"))&&!(strtemp[6].equals("0"))){
					System.out.println("file  line "+line+" is "+str);
					str=reader.readLine();
					line++;
					continue;
				}
												
//				if(strtemp[1].equals("03")){	
//					System.out.println("file  line "+line+" is "+str);				
//					break;
//				}			
//				if(afterNull){
//					break;
//				}else{
//					continue;
//				}
//				System.out.println("file  line "+line+" is "+str);
				
			}
			reader.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(reader!=null){
				try{
					reader.close();
				}catch(IOException e){
					
				}
			}
		
		}
	}

}

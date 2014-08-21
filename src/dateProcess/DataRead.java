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


public class DataRead {

	public static void main(String[] args) {
		
			// TODO Auto-generated method stub
			File fl=new File("D:/root/VEHICLETRACKINFO/part-m-00000");
			BufferedReader reader=null;
			String driver = "com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/test";
			String user = "root";

			// Java连接MySQL配置时的密码

			String password = "yyyy";
			Connection conn=null;
			Statement stment=null;
			String sql=null;//"select * from test_alarm1";
			ResultSet rs = null;//stment.executeQuery(sql);
			String[] strtemp=null;
			String strfinal=null;
			int line=1;
			try {
				reader=new BufferedReader(new FileReader(fl));
				String str=null;
				
				Class.forName(driver);
				conn=DriverManager.getConnection(url,user,password);
				stment=conn.createStatement();
				
				while(line<12){
					
					str=reader.readLine();
					//str = str.replace(',','	') ;
					System.out.println("file  line "+line+" is "+str);
					strtemp=str.split("\\,");
					int i=0;
					int j=0;
					strfinal=null;
					//System.out.println("length is "+strtemp.length);
					while(i<strtemp.length){
						if(!strtemp[i].equals("null")){
							if(i==0){
								strfinal="'"+strtemp[i];
							}else if(strtemp[i-1].equals("null")){
								strfinal+=",'"+strtemp[i];
								j=0;
							}
							else{
								strfinal+="','"+strtemp[i];
							}					
						}else{
							if(j==0){
								strfinal+="',"+strtemp[i];
							}else{
								strfinal+=","+strtemp[i];
							}
							j++;
						}
						//System.out.println("data  "+strtemp[i]);
						i++;
					}
					strfinal+="'";
					System.out.println("file  line "+line+" is "+strfinal);
					line++;//INSERT INTO staff(name, age, sex,address, depart, worklen,wage)"  
		                  //  + " VALUES ('Tom1', 32, 'M', 'china','Personnel','3','3000')";
//					sql="insert into test_alarm1 "
//							+"VALUES ("+str+")";
//					stment.executeQuery(sql);
					
				}
				reader.close();
				//rs.close();  
				conn.close(); 
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(ClassNotFoundException e){
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("down in line"+line);
				e.printStackTrace();
			}finally{
				if(reader!=null){
					try{
						reader.close();
					}catch(IOException e){
						
					}
				}
				try {
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
			
	}

}

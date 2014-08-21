package dateProcess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

class Test {

	public static void main1(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String strtemp="2014-02-04";
		String strtemp1[]=strtemp.split("-");
		Integer dateStart=null;
		Integer dateEnd=null;
		dateStart=0201;
		dateEnd=0403;
		Integer startmonth=dateStart/100;
		Integer endmonth=dateEnd/100;
		Integer startdate=dateStart%100;
		Integer enddate=dateEnd%100;
		Integer date1=null;
		Integer date2=null;
		
		File fl=new File("D:/test.txt");
		
		BufferedReader readbf=new BufferedReader(new FileReader(fl));
		String line=readbf.readLine();
		while(line!=null){
			System.out.println(line);
			line=readbf.readLine();
		}
//		System.out.println(Integer.parseInt(strtemp1[1])+strtemp1[1]);

	}

}

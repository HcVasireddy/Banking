package miniProject;

import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Functions {
	public static void complaints_by_year(int year,ArrayList<complaint> loaded) {
		for(complaint x : loaded) {
			if((x.recieved_date).getYear()==year) {
				System.out.println(x);
			}
		}
	}
	public static void complaints_by_company(String company,ArrayList<complaint> loaded) {

		for(complaint x : loaded) {
			if(x.company.equals(company)) {
				System.out.println(x);
			}
		}
		System.out.println("End of Data");
	}
	
	public static void complaints_by_id(Long id,ArrayList<complaint> loaded) {
		for(complaint x : loaded) {
			if(x.complaint_id==id) {
				System.out.println(x);
			}
		}
	}
	
	public static void days_by_company(String company,ArrayList<complaint> loaded) {
		for(complaint x : loaded) {
			if(x.company.equals(company)) {
				System.out.println(x.getCompany() + "     " + TimeUnit.DAYS.convert((x.closed_date).getTime()-(x.recieved_date).getTime(),TimeUnit.MILLISECONDS) + " Days");
			}
		}
	}
	
	public static void complaints_closed(ArrayList<complaint> loaded) {
		for(complaint x : loaded) {
			if(x.company_response.equalsIgnoreCase("Closed") || x.company_response.equalsIgnoreCase("Closed with explanation")) {
				System.out.println(x);
			}
		}
		System.out.println("End of Data");
	}
	
	public static void timely_response(ArrayList<complaint> loaded) {
		for(complaint x : loaded) {
			if(x.timely_response.equalsIgnoreCase("Yes")) {
				System.out.println(x);
			}
		}
	}
	
	public static void new_complaint(ArrayList<complaint> loaded) throws ParseException {
		System.out.println("Enter the date of complaint creation in the format of MM/DD/YYYY (01/31/2001) : ");
		Scanner sc1=new Scanner(System.in);
		String a=sc1.nextLine();
		Date a1=new SimpleDateFormat("MM/dd/yyyy").parse(a);
		sc1.close();
		System.out.println("Enter Product name : ");
		Scanner sc2=new Scanner(System.in);
		String a2=sc2.nextLine();
		
		sc2.close();
		System.out.println("Enter Sub Product : ");
		Scanner sc3=new Scanner(System.in);
		String a3=sc3.nextLine();
		
		sc3.close();
		System.out.println("Enter Issue : ");
		Scanner sc4=new Scanner(System.in);
		String a4=sc4.nextLine();
		
		sc4.close();
		System.out.println("Enter Sub-Issue : ");
		Scanner sc5=new Scanner(System.in);
		String a5=sc5.nextLine();
		
		sc5.close();
		System.out.println("Enter Bank name : ");
		Scanner sc6=new Scanner(System.in);
		String a6=sc6.nextLine();
		
		sc6.close();
		System.out.println("Enter State code : ");
		Scanner sc7=new Scanner(System.in);
		String a7=sc7.nextLine();
		
		sc7.close();
		System.out.println("Enter Zip code : ");
		Scanner sc8=new Scanner(System.in);
		String a8=sc8.nextLine();
		
		sc8.close();
		System.out.println("Enter Submitted via : ");
		Scanner sc9=new Scanner(System.in);
		String a9=sc9.nextLine();
		
		sc9.close();
		System.out.println("Enter Complaint Closing Date in the format of MM/DD/YYYY (01/31/2001) : ");
		Scanner sca=new Scanner(System.in);
		String b10=sca.nextLine();
		Date a10=new SimpleDateFormat("MM/dd/yyyy").parse(b10);
		
		sca.close();
		System.out.println("Enter Bank response to the consumer : ");
		Scanner scb=new Scanner(System.in);
		String a11=scb.nextLine();
		
		scb.close();
		System.out.println("Enter Yes if company gave Timely response orelse enter No : ");
		Scanner scc=new Scanner(System.in);
		String a12=scc.nextLine();
		
		scc.close();
		System.out.println("Enter Yes if the costumer is disputed orelse enter No : ");
		Scanner scd=new Scanner(System.in);
		String a13=scd.nextLine();
		
		scd.close();
		System.out.println("Enter Complaint ID : ");
		Scanner sce=new Scanner(System.in);
		String b14=sce.nextLine();
		Long a14=Long.parseLong(b14);
		
		sce.close();
		complaint temp=new complaint(a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14);
		loaded.add(temp);
		System.out.println("New complaint Successfully registered............");
		System.out.println(temp);
	}
}

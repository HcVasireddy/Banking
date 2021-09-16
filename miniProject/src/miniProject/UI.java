package miniProject;
//import miniProject.Fileloader;
//import miniProject.Functions;
import java.util.TreeMap;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
	public static void main(String[] args) throws NumberFormatException, FileNotFoundException, ParseException {
		ArrayList<complaint> loaded=new ArrayList<complaint>(Fileloader.load());
		System.out.println("1.Display all the complaints based on the year");
		System.out.println("2.Display all the complaints based on the name of the bank");
		System.out.println("3.Display complaints based on the complaint id");
		System.out.println("4.Display number of days took by the Bank to close the complaint");
		System.out.println("5.Display all thecomplaints closed/closed with explanation");
		System.out.println("6.Displayall the complaints which received a timely response");
		System.out.println("7.New complaint");
		System.out.println("Enter an option : ");
		Scanner sc=new Scanner(System.in);
		
		
		int opt=sc.nextInt();
		//sc.close();
		switch(opt) {
		case 1:
			System.out.println("Enter the year in which you want to view complaints");
			//Scanner sc2=new Scanner(System.in);
			int year=sc.nextInt();
			//sc2.close();
			Functions.complaints_by_year(year, loaded);
			break;
		case 2:
			System.out.println("Enter the name of the bank in which you want to view complaints");
			Scanner sc3=new Scanner(System.in);
			String company=sc3.nextLine();
			Functions.complaints_by_company(company, loaded);
			sc3.close();
			break;
		case 3:
			System.out.println("Enter the complaint id :");
			Scanner sc4=new Scanner(System.in);
			Long id=sc4.nextLong();
			Functions.complaints_by_id(id, loaded);
			sc4.close();
			
			break;
		case 4:
			System.out.println("Enter the name of the bank in which you want to find the number of days taken to close the complaint :");
			Scanner sc5=new Scanner(System.in);
			String company1=sc5.nextLine();
			Functions.days_by_company(company1, loaded);
			sc5.close();
			
			break;
		case 5:
			Functions.complaints_closed(loaded);
			
			break;
		case 6:
			Functions.timely_response(loaded);
			
			break;
		case 7:
			Functions.new_complaint(loaded);
		}

	}

}

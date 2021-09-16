package miniProject;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeMap;
public class Fileloader {
	public static ArrayList<complaint> load() throws NumberFormatException, ParseException, FileNotFoundException{
		File file=new File("C:\\Users\\DELL\\Desktop\\complaints.txt");
		ArrayList<complaint> loadedarray=new ArrayList<complaint>();
		ArrayList<String> str=new ArrayList<String>();
		Scanner sc=new Scanner(file);
		while(sc.hasNextLine()) {
			str.add(sc.nextLine());
		}
		sc.close();
		str.remove(0);
		for(String x : str) {
			int n=x.length();
			boolean dap_start=false;
			int prev_loc=0;
			ArrayList<String> result=new ArrayList<String>();
			for(int i=0;i<x.length();i++) {
				if((x.charAt(i)=='\"') &&(dap_start) && (x.charAt(i+1)==',') ) {
					dap_start=false;
					result.add(x.substring(prev_loc, i));
					if(x.charAt(i+1)==',') {
						prev_loc=i+2;
						i++;
					}
						
					else
						prev_loc=i+1;
					
				}
				else if((x.charAt(i)=='\"') &&(!(dap_start)) && (x.charAt(i-1)==',')){
					dap_start=true;
					prev_loc=i+1;
				}
				else if(i==n-1){
					result.add(x.substring(prev_loc, i+1));
					break;
				}
				else if((x.charAt(i)==',')&&(!(dap_start))) {
					result.add(x.substring(prev_loc, i));
					int num=i+1;
					while((num<n)&&(x.charAt(num)==',')) {
						result.add(null);
						num++;
						}
					prev_loc=num;
					i=num-1;
					}
					
					
				}
				
			//System.out.println(result);
			String df1=new String();
			if((result.get(0)).charAt(2)=='-') {
				df1=new String("MM-dd-YYYY");
			}
			else {
				df1=new String("MM/dd/yyyy");
			}
			String df2=new String();
			if((result.get(9)).charAt(2)=='-') {
				df2=new String("MM-dd-YYYY");
			}
			else {
				df2=new String("MM/dd/yyyy");
			}
			
			complaint temp=new complaint(new SimpleDateFormat(df1).parse(result.get(0)),result.get(1),result.get(2),result.get(3),result.get(4),result.get(5),result.get(6),result.get(7),result.get(8),new SimpleDateFormat(df2).parse(result.get(9)),result.get(10),result.get(11),result.get(12),Long.parseLong(result.get(13)));
			loadedarray.add(temp);
		}
		return loadedarray;
	}

}

class complaint{
	Date recieved_date;
	String product;
	String sub_product;
	String issue;
	String sub_issue;
	String company;
	String state;
	String zip_code;
	String submitted_via;
	Date closed_date;
	String company_response;
	String timely_response;
	String disputed;
	Long complaint_id;
	
	
	
	public complaint(Date recieved_date, String product, String sub_product, String issue, String sub_issue,
			String company, String state, String zip_code, String submitted_via, Date closed_date,
			String company_response, String timely_response, String disputed, Long complaint_id) {
		super();
		this.recieved_date = recieved_date;
		this.product = product;
		this.sub_product = sub_product;
		this.issue = issue;
		this.sub_issue = sub_issue;
		this.company = company;
		this.state = state;
		this.zip_code = zip_code;
		this.submitted_via = submitted_via;
		this.closed_date = closed_date;
		this.company_response = company_response;
		this.timely_response = timely_response;
		this.disputed = disputed;
		this.complaint_id = complaint_id;
	}


	public Date getRecieved_date() {
		return recieved_date;
	}


	public void setRecieved_date(Date recieved_date) {
		this.recieved_date = recieved_date;
	}


	public String getProduct() {
		return product;
	}


	public void setProduct(String product) {
		this.product = product;
	}


	public String getSub_product() {
		return sub_product;
	}


	public void setSub_product(String sub_product) {
		this.sub_product = sub_product;
	}


	public String getIssue() {
		return issue;
	}


	public void setIssue(String issue) {
		this.issue = issue;
	}


	public String getSub_issue() {
		return sub_issue;
	}


	public void setSub_issue(String sub_issue) {
		this.sub_issue = sub_issue;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZip_code() {
		return zip_code;
	}


	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}


	public String getSubmitted_via() {
		return submitted_via;
	}


	public void setSubmitted_via(String submitted_via) {
		this.submitted_via = submitted_via;
	}


	public Date getClosed_date() {
		return closed_date;
	}


	public void setClosed_date(Date closed_date) {
		this.closed_date = closed_date;
	}


	public String getCompany_response() {
		return company_response;
	}


	public void setCompany_response(String company_response) {
		this.company_response = company_response;
	}


	public String getTimely_response() {
		return timely_response;
	}


	public void setTimely_response(String timely_response) {
		this.timely_response = timely_response;
	}


	public String getDisputed() {
		return disputed;
	}


	public void setDisputed(String disputed) {
		this.disputed = disputed;
	}


	public Long getComplaint_id() {
		return complaint_id;
	}


	public void setComplaint_id(Long complaint_id) {
		this.complaint_id = complaint_id;
	}


	@Override
	public String toString() {
		return "complaint [recieved_date=" + recieved_date + ", product=" + product + ", sub_product=" + sub_product
				+ ", issue=" + issue + ", sub_issue=" + sub_issue + ", company=" + company + ", state=" + state
				+ ", zip_code=" + zip_code + ", submitted_via=" + submitted_via + ", closed_date=" + closed_date
				+ ", company_response=" + company_response + ", timely_response=" + timely_response + ", disputed="
				+ disputed + ", complaint_id=" + complaint_id + "]";
	}
	
	
	
	
	
	
	
	
	
}







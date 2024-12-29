import java.util.Scanner;
import com.student.manage.*;
import java.io.*;
public class Start {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		System.out.println("Wellcome To Student Management App");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Press 1 to Add Student.");
			System.out.println("Press 2 to Delete Student.");
			System.out.println("Press 3 to Display Student.");
			System.out.println("Press 4 to Update Record.");
			System.out.println("Press 5 to Exit App.");
			//int input = sc.nextInt();
			int input = Integer.parseInt(br.readLine());
			
			if(input==1) {
				//Insert
				System.out.println("Enter Student Name: ");
				String name = br.readLine();
				System.out.println("Enter Student Contact Number: ");
				String contact = br.readLine();
				System.out.println("Enter City: ");
				String city = br.readLine();
				
				Student st = new Student(name, contact, city);
				
				boolean ans = StudentDao.insertStudent(st);
				
				if(ans) {
					System.out.println("Student Record Added Successfully!!");
				}
				else {
					System.out.println("Something Went Wrong, Please Try Again");
				}
				
				System.out.println(st);
			}
			else if(input==2) {
				//Delete
				System.out.println("Enter Student Id To Delete The Record:");
				int sid = Integer.parseInt(br.readLine());
				boolean result = StudentDao.deleteRecord(sid);
				if(result) {
					System.out.println("Student Record Deleted Successfully!!");
				}
				else {
					System.out.println("Something Went Wrong!!");
				}
			}
			else if(input==3) {
				//Select
				System.out.println("Press 1 for Display All Records.");
				System.out.println("Press 2 for Display Specific Record.");
				int input1 = Integer.parseInt(br.readLine());
				
				if(input1 == 1) {
					//Select all
					StudentDao.selectAll();
				}
				else if(input1 == 2) {
					//Select specific
					System.out.println("Enter Student Id To Display The Specific Record.");
					int sid1 = Integer.parseInt(br.readLine());
					StudentDao.specificRecord(sid1);
					
				}
			}
			else if(input==4) {
				System.out.println("Enter Student Id to Update The Record:");
				int sid2 = Integer.parseInt(br.readLine());
				System.out.println("Press 1 to Update Name.");
				System.out.println("Press 2 to Update Contact.");
				System.out.println("Press 3 to Update City.");
				
				int input2 = Integer.parseInt(br.readLine());
				
				if(input2==1) {
					System.out.println("Enter Updated Name");
					String updatedName = br.readLine();
					boolean result1 = StudentDao.updateName(sid2, updatedName);
					if(result1) {
						System.out.println("Record Updated Successfully!!");
					}
					else {
						System.out.println("Something Went Wrong!!");
					}
				}
				
				else if(input2 == 2) {
					System.out.println("Enter Updated Contact Number:");
					String updatedContact = br.readLine();
					boolean result1 = StudentDao.updateContact(sid2, updatedContact);
					if(result1) {
						System.out.println("Record Updated Successfully!!");
					}
					else {
						System.out.println("Something Went Wrong!!");
					}
				}
				
				else if(input2 == 3) {
					System.out.println("Enter Updated City:");
					String updatedCity = br.readLine();
					boolean result1 = StudentDao.updateCity(sid2, updatedCity);
					if(result1) {
						System.out.println("Record Updated Successfully!!");
					}
					else {
						System.out.println("Something Went Wrong!!");
					}
				}
				
				
			}
			else if(input==5) {
				break;
			}
			else {}
		}
		
		System.out.println("THANK YOU FOR USING MY APPLICATION!!");
	}

}

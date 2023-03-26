import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import src.com.student.manage.Student;
import src.com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
			System.out.println("Welcome to Student Mgmt App");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
				System.out.println("PRESS 1 to Add Student");
				System.out.println("PRESS 2 to Delete Student");
				System.out.println("PRESS 3 to Display Student");
				System.out.println("PRESS 4 to Exit Student App");
				int c = Integer.parseInt(br.readLine());
				
				if(c==1) {
					System.out.println("Enter Student Name");
					String name = br.readLine();
					
					System.out.println("Enter Student Phone");
					String phone = br.readLine();
					
					System.out.println("Enter Student City");
					String city = br.readLine();
 
					Student st = new Student(name,phone,city);
					boolean answer= StudentDao.insertIntoDB(st);
					if(answer == true) {
						System.out.println("Student Added Successfully...");
					}
					else {
						System.out.println("Something went wrong try again...");
					}
					System.out.println(st);
					
				}
				else if(c==2){
					System.out.println("Enter Id to Delete..");
					int userId = Integer.parseInt(br.readLine());
					boolean answer= StudentDao.deleteStudent(userId);
					if(answer == true) {
						System.out.println("Student Deleted Successfully...");
					}
					else {
						System.out.println("Something went wrong try again...");
					}
					
				}
				else if(c==3){
					SSystem.out.println("Displaying Students ------");
					StudentDao.showAllStudent();
					
				}
				else if(c==4) {
				
					break;
				}
				else {
					
				}
				

				
				
			}
			System.out.println("Thank You for Using App");
	}

}

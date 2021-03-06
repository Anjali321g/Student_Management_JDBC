package com.student.manage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Welcome to Student Management App");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true)
		{
			System.out.println("PRESS 1 to ADD student");
			System.out.println("PRESS 2 to DELETE student");
			System.out.println("PRESS 3 to DISPLAY student");
			System.out.println("PRESS 4 to UPDATE4 student");
			System.out.println("PRESS 5 to EXIT app");
			int c=Integer.parseInt(br.readLine());
			
			if(c==1)
			{
				//add student
				System.out.println("Enter user name : ");
				String name=br.readLine();
				
				System.out.println("Enter user phone : ");
				String phone=br.readLine();
				
				System.out.println("Enter user city : ");
				String city=br.readLine();
				
				//create student object to store student
				Student1 st=new Student1(name, phone, city);
				boolean answer=StudentDao.insertStudentToDB(st);
				if(answer) {
					System.out.println("Student is added successfully.....");
				}
				else
				{
					System.out.println("something went wrong... try again");
				}
				System.out.println(st);
			}
			else if(c==2)
			{
				//delete student
				System.out.println("enter student id to delete: ");
				int userId=Integer.parseInt(br.readLine());
				boolean f=StudentDao.deleteStudent(userId);
				if(f)
				{
					System.out.println("Deleted...");
				}
				else
				{
					System.out.println("something went wrong... try again");
				}
			}
			else if(c==3)
			{
				//display student
				StudentDao.showAllStudents();
			}
			else if(c==4)
			{
				//exit
				//System.out.println("enter student id to update");
				//int userId=Integer.parseInt(br.readLine());
				
				
				System.out.println("Enter user name : ");
				String name=br.readLine();
				
				System.out.println("Enter user phone : ");
				String phone=br.readLine();
				
				System.out.println("Enter user city : ");
				String city=br.readLine();
				
				System.out.println("Enter student Id : ");
				int id=Integer.parseInt(br.readLine());
				
				
				boolean f=StudentDao.updateStudent(id,name, phone, city);
				
				if(f)
				{
					System.out.println("Updated...");
				}
				else
				{
					System.out.println("something went wrong... try again");
				}
				
				
				
			}
			else if(c==5)
			{ 
				// exit
				break;
				
			}
		}
		System.out.println("Thank you for using my application...");
		System.out.println("See you soon...");
	}

}

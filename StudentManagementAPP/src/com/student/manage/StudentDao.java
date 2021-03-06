package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	
	public static boolean insertStudentToDB(Student1 st)
	{
		boolean f=false;
	
		//jdbc code
		try
		{
		Connection con=CP.createC();
		String q="insert into student(sname, sphone, scity) values(?,?,?)";
		//PreparedStatement
		PreparedStatement pstmt=con.prepareStatement(q);
		//set the values of parameters
		pstmt.setString(1, st.getStudentName());
		pstmt.setString(2, st.getStudentPhone());
		pstmt.setString(3, st.getStudentCity());
		
		// execute..
		pstmt.executeUpdate();
		f=true;
		
	} catch(Exception e)
		{
		e.printStackTrace();
		}
		return f;

}

	public static boolean deleteStudent(int userId) {
		// TODO Auto-generated method stub
		boolean f=false;
		
		//jdbc code
		try
		{
		Connection con=CP.createC();
		String q="delete from student where sid=?";
		//PreparedStatement
		PreparedStatement pstmt=con.prepareStatement(q);
		//set the values of parameters
		pstmt.setInt(1, userId);
		
		// execute..
		pstmt.executeUpdate();
		f=true;
		
	} catch(Exception e)
		{
		e.printStackTrace();
		}
		return f;
		
	}

	public static void showAllStudents() {
		// TODO Auto-generated method stub
	boolean f=false;
		
		//jdbc code
		try
		{
		Connection con=CP.createC();
		String q="select * from student;";
		// statement
		Statement stmt=con.createStatement();
		ResultSet set=stmt.executeQuery(q);
	
		while(set.next()) {
			int id=set.getInt(1);
			String name=set.getString(2);
			String phone=set.getString(3);
			String city=set.getString("scity");
			
			System.out.println("ID : "+id);
			System.out.println("Name : "+name);
			System.out.println("Phone : "+phone);
			System.out.println("City : "+city);
			
			System.out.println("----------------------------------------------------");
		}
		
	} catch(Exception e)
		{
		e.printStackTrace();
		}
	
	}

	public static boolean updateStudent(int id,String name,String phone, String city) {
		boolean f=false;
		// TODO Auto-generated method stub
		try
		{
		Connection con=CP.createC();
		String q="update student set sname=?, sphone=?, scity=? where sid=?  ";
		
		//PreparedStatement
		PreparedStatement pstmt=con.prepareStatement(q);
		

		pstmt.setString(1, name);
		pstmt.setString(2, phone);
		pstmt.setString(3, city);
		pstmt.setInt(4, id);
		
		
		
		// execute..
		pstmt.executeUpdate();
		f=true;
		
	} catch(Exception e)
		{
		e.printStackTrace();
		}
		return f;
	}
}

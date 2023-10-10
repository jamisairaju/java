package sample;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;
public class regist extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		String fname=req.getParameter("fname");	
		String name=req.getParameter("name");	
		String mail=req.getParameter("mail");	
		String number=req.getParameter("number");	
		String dob=req.getParameter("dob");	
		String pass=req.getParameter("pass");	
		
		PrintWriter out = res.getWriter();
		//out.println(name+mail+number+dob+pass);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			List<Data> list = new ArrayList<Data>();
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermark", "root", "Sairaju@9");
			Statement stmt = con.createStatement();
			//System.out.println("insert records");
			String insert="insert into register(first_name,last_name,email,phone,date_of_birth,password) values('"+fname+"','"+name+"','"+mail+"','"+number+"','"+dob+"','"+pass+"')";
			try{stmt.execute(insert);
			RequestDispatcher rd = req.getRequestDispatcher("page3.html");
			rd.forward(req, res);}catch (SQLIntegrityConstraintViolationException e) {
		        // Duplicate entry error occurred
		        out.println("Duplicate entry. Please go back and provide another details.");
		        
		    }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}


	}
	}
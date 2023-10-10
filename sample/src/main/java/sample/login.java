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
public class login extends HttpServlet {
	String u;
	String p;
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String i = req.getParameter("num1");
		String j = req.getParameter("num2");
		/*String fname=req.getParameter("fname");	
		String name=req.getParameter("name");	
		String mail=req.getParameter("mail");	
		String number=req.getParameter("number");	
		String dob=req.getParameter("dob");	
		String pass=req.getParameter("pass");*/	
		
		PrintWriter out = res.getWriter();
		//out.println(name+mail+number+dob+pass);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			List<Data> list = new ArrayList<Data>();
			int cnt = 0;

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermark", "root", "Sairaju@9");
			Statement stmt = con.createStatement();
			//System.out.println("insert records");
			//String insert="insert into register(first_name,last_name,Emails,phone,date_of_birth,password) values('"+fname+"','"+name+"','"+mail+"','"+number+"','"+dob+"','"+pass+"')";
			//stmt.execute(insert);
			
			String sql = "select last_name,password from register where last_name='" + i + "' and password='" + j + "'";
			
			ResultSet resultSet = stmt.executeQuery(sql);
			while (resultSet.next()) {
				cnt = cnt + 1;
			}
			if (cnt == 1) {
				
				RequestDispatcher rd = req.getRequestDispatcher("page2.html");
				rd.forward(req, res);
			} else {
				out.println("Invalid id and password");
			}
			System.out.println("");
			stmt.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}


	}
	}
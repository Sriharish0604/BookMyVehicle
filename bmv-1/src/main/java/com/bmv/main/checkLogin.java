package com.bmv.main;
import java.sql.*;
public class checkLogin {
	public static boolean flag;
	public static void verifyPwd(String u,String p,char role) throws ClassNotFoundException, SQLException{


	        String url      = "jdbc:oracle:thin:@localhost:1521:system";   //database specific url.
	        String user     = "system";
	        String password = "system";
	        Connection con=null;
	        try
	        {  
	       
	        con = DriverManager.getConnection(url,user,password);
	             System.out.println("connection estallished to Database ");
	             if(role=='u') {
	             PreparedStatement stmt=con.prepareStatement("SELECT email,pwd from customer2 where email=?");
	        stmt.setString(1,u);
	             ResultSet result = stmt.executeQuery();
	             while (result.next()) {
	             String usr =result.getString("email");
	             String pwd =result.getString("pwd");
	             System.out.println("Database Credentials : usr= "+usr +"  pwd=" +pwd+ "\n");
	             
	             if(pwd.equals(p)) {
	             flag=true;
	             System.out.println(flag);
	             break;
	             }
	             else {
	             flag=false;
	             System.out.println(flag);
	             
	             }
	             }
	       
	        }else {
	        PreparedStatement stmt=con.prepareStatement("SELECT username,password from ims_employee where username=?");
	           stmt.setString(1,u);
	            ResultSet result = stmt.executeQuery();
	            while (result.next()) {
	           
	             String pwd =result.getString("password");
	             String usr =result.getString("username");
	             System.out.println("Database Credentials : usr= "+usr +"  pwd=" +pwd+ "\n");
	             
	             
	             if(pwd.equals(p)) {
	             flag=true;
	             System.out.println(flag);
	             }
	             else {
	             flag=false;
	             System.out.println(flag);
	             }
	             }
	       
	        }
	        }
	        catch(Exception ex)
	        {
	            System.err.println(ex);
	           
	        }
	       
	     

	}
	}


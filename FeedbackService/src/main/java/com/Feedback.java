package com;
import java.sql.*;
public class Feedback {
	//Create the connection with Mysql database
	
	private Connection connect()
	 {
		 Connection con = null;
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
		
			 //Provide the Database details: DBServer/DBName, username, password
			 
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedbackdb", "root", "ndksliit");
		 }
			 catch (Exception e)
			 {e.printStackTrace();}
			 return con;
	 }
	//view Feedback API data section
	public String readFeedback()
	{
			String output = "";
			 try
			 {
				 Connection con = connect();
				 if (con == null)
				 {return "Error while connecting to the database for reading."; }
				 
				 // Prepare the html table to be displayed
				 
				 output = "<table class='table' border='1'><thead class='table-success'><tr><th scope='col'>Feedback ID</th><th scope='col'>USER ID</th>" +
						 "<th scope='col'>PRE BILL NO</th>" +"<th scope='col'>AMOUNT (RS)</th>" +"<th scope='col'>PAYED AMOUNT(RS)</th>" +
						 "<th scope='col'>BALANCE</th>" +"<th scope='col'>NEW BILL NO</th>"+"<th scope='col'>NEW AMOUNT</th>"+"<th scope='col'>TOTAL</th>" +"<th scope='col'>COMMENT</th>"+"<th scope='col'>Update</th>"+"<th scope='col'>Delete</th></tr></thead><tbody>";
				
			
				 String query = "select * from feedback";
				 Statement stmt = con.createStatement();
				 ResultSet rs = stmt.executeQuery(query);
				 
				 // iterate through the rows in the result set
				 
				 while (rs.next())
				 {
						 String id = Integer.toString(rs.getInt("id"));
						 String userid = rs.getString("userid");
						 String previousbillno = rs.getString("previousbillno");
						 String amount = rs.getString("amount");
						 String payedamount = rs.getString("payedamount");
						 String balance = rs.getString("balance");
						 String newbillno = rs.getString("newbillno");
						 String newamount = rs.getString("newamount");
						 String total = rs.getString("total");
						 String comment = rs.getString("comment");
					 
					
					 
					 // Add into the html table
					 
					 output += "<tr><td class='table-warning'><input id='hididUpdate' name='hididUpdate' type='hidden' value='" + id +  "'>" + userid + "</td>"; 
					 output += "<td class='table-warning'>" + previousbillno + "</td>";
					 output += "<td class='table-warning'>" + amount + "</td>";
					 output += "<td class='table-warning'>" + payedamount + "</td>";
					 output += "<td class='table-warning'>" + balance + "</td>";
					 output += "<td class='table-warning'>" + newbillno + "</td>";
					 output += "<td class='table-warning'>" + newamount + "</td>";
					 output += "<td class='table-warning'>" + total + "</td>";
					 output += "<td class='table-warning'>" + comment + "</td>";
					 
					 
					 
					 // buttons
					 
					 output += "<td><input name='btnUpdate'  type='button' value='Update' class='btnUpdate btn btn-secondary' data-itemid='"+ id+ "'>" + "</td>" 
					+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-itemid='"+ id + "'>" + "</td></tr></tbody>";		 
				 }
				 con.close();
				 
				 // Complete the html table
				 
				 output += "</table>";
			 }
			 catch (Exception e)
			 {
				 output = "Error while reading the feedback.";
				 System.err.println(e.getMessage());
			 }
			 return output;
	}
	
	//Insert Feedback API Data section
	public String insertFeedback(String userid, String previousbillno, String amount, String payedamount, String balance, String newbillno, String newamount, String total, String comment)
	{
		 String output = "";
		 try
		 {
			 Connection con = connect();
			 if (con == null)
			 {
				 return "Error while connecting to the database for inserting."; 
			 }
			 
			 // create a prepared statement
			 
			 String query = " insert into feedback (`id`,`userid`,`previousbillno`,`amount`,`payedamount`,`balance`,`newbillno`,`newamount`,`total`,`comment`)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 
			 // binding values
			 
				 preparedStmt.setInt(1, 0);
				 preparedStmt.setString(2, userid);
				 preparedStmt.setString(3, previousbillno);
				 preparedStmt.setString(4, amount);
				 preparedStmt.setString(5, payedamount);
				 preparedStmt.setString(6, balance);
				 preparedStmt.setString(7, newbillno);
				 preparedStmt.setString(8, newamount);
				 preparedStmt.setString(9, total);
				 preparedStmt.setString(10, comment);
			 
			 
			 
			 // execute the statement
			 
			 preparedStmt.execute();
			 con.close();
			 
			 String newpwrusage = readPowerusage(); 
			 String newfeedback = readFeedback(); 
				  output = "{\"status\":\"success\", \"data\": \"" + newfeedback + "\"}";
		 }
		 catch (Exception e)
		 {
			 output = "{\"status\":\"error\", \"data\": \"Error while inserting the feedback\"}";
			 System.err.println(e.getMessage());
		 }
		 return output;
	}
	
	
	//update Feedback API data section
	public String updateFeedback(String id,String userid, String previousbillno, String amount, String payedamount, String balance, String newbillno, String newamount, String total, String comment)
	{
			 String output = "";
			 try
			 {
				 Connection con = connect();
				 if (con == null)
				 {
					 return "Error while connecting to the database for updating."; 
				 }
				 
				 // create a prepared statement
				 
				 String query = "UPDATE feedback SET userid=?,previousbillno=?,amount=?,payedamount=?,balance=?,newbillno=?,newamount=?,total=?,comment=? WHERE id=?";
				 PreparedStatement preparedStmt = con.prepareStatement(query);
				 
				 // binding values
				 
				 
					 preparedStmt.setString(1, userid);
					 preparedStmt.setString(2, previousbillno);
					 preparedStmt.setString(3, amount);
					 preparedStmt.setString(4, payedamount);
					 preparedStmt.setString(5, balance);
					 preparedStmt.setString(6, newbillno);
					 preparedStmt.setString(7, newamount);
					 preparedStmt.setString(8, total);
					 preparedStmt.setString(9, comment);
					 preparedStmt.setInt(10, Integer.parseInt(id));
				 
				 // execute the statement
				 
				 preparedStmt.execute();
				 con.close();
				 
				 String newfeedback = readFeedback(); 
 					 output = "{\"status\":\"success\", \"data\": \"" + newfeedback + "\"}";
			 }
			 catch (Exception e)
			 {
				 output = "{\"status\":\"error\", \"data\": \"Error while updating the feedback.\"}";
				 System.err.println(e.getMessage());
			 }
			 return output;
	}
	
	
	// delete Feedback API  data section
	public String deleteFeedback(String id)
	{
		 String output = "";
		 try
		 {
			 Connection con = connect();
			 if (con == null)
			 {
				 return "Error while connecting to the database for deleting."; 
			 }
			 // create a prepared statement
			 String query = "delete from feedback where id=?";
			 PreparedStatement preparedStmt = con.prepareStatement(query);
			 // binding values
			 preparedStmt.setInt(1, Integer.parseInt(id));
			 // execute the statement
			 preparedStmt.execute();
			 con.close();
			 
			 String newfeedback = readFeedback(); 
 					 output = "{\"status\":\"success\", \"data\": \"" + newfeedback + "\"}";
			 
		 }
		 catch (Exception e)
		 {
			  output = "{\"status\":\"error\", \"data\": \"Error while deleting the feedback.\"}";
			 System.err.println(e.getMessage());
		 }
		 return output;
	 }
}

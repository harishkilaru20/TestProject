package com.framework.reader;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseReader {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/mysql";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "root";
	   static Connection conn = null;
	   static java.sql.Statement stmt = null;
	   static java.sql.ResultSet rs=null;
	   int rowNum;
	   int totalrec=0;
		   
		 
	   
	   public static void connectingToDatabase() throws ClassNotFoundException, SQLException{
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
		   
	   }
	    
	   public static String insert(String query){
		
			try {
		    	
		    	  connectingToDatabase();
		    	  
		    	  int insert = stmt.executeUpdate(query);
			     			      
			      if(insert>0){
			    	  System.out.println(insert+" "+"record(s) Inserted Successfully");
			      }else{
			    	  System.out.println("No Records Inserted");
			      }
			       stmt.close();
		           conn.close();
			} 
			catch (Exception e) {
				
				String str = e.getLocalizedMessage().toString();
				System.out.println(str);
			}
			
			return query;
		}
		

		 
		 public static String update(String query) throws ClassNotFoundException {
		
				     try {
				    	  
				    	  connectingToDatabase();
					     // String query = "UPDATE Emp SET EName='akram' WHERE EID =20 ";
				    	  
					      int no = stmt.executeUpdate(query);
					     
					      if(no>0){
					    	  System.out.println(no+" "+"record(s) updated Successfully");
					      }
					      else
					      {
					    	  System.out.println("No Records Found");
					      }
					      
					      stmt.close();
				          conn.close();
					} 
				      
				 catch (Exception e) 
				 	{
					  String str = e.getLocalizedMessage().toString();
					  System.out.println(str);
					}
					
				 return query;
		 }
		 
		 public static String delete(String query) throws ClassNotFoundException{
			 
			 
			 	try {
						  	      	      
					     int delete =  stmt.executeUpdate(query);
					      
					      if(delete>0){
					    	  System.out.println(delete+" "+"Record(s) Deleted Successfully ");
					      }else{
					    	  System.out.println("No Records Found");
					      }
					      stmt.close();
				          conn.close();
					} 
			 	 catch (SQLException e) {
						String str = e.getLocalizedMessage().toString();
						System.out.println(str);
					}
				
			 	return query;
			 
		 }
		 
		 public static String  retrieveRecords(String query) throws ClassNotFoundException {
			 
			 	try {
				 		 connectingToDatabase(); 
					     //ring query = "SELECT *+" +FROM Emp ";
					     rs = stmt.executeQuery(query);
					  
					     while(rs.next()){
					    	  
					         //Retrieve by column name
					       
					         String EName = rs.getString("EMPNAME");
					         System.out.println(" EName: " + EName);
					         String EID = rs.getString("EMPID");
					         System.out.println(" EName: " + EID);

					      
					      } 
					      rs.close();
				          stmt.close();
				          conn.close();
					} 
			 	
			 	 catch (SQLException e) {
						
						String str = e.getLocalizedMessage().toString();
						System.out.println(str);
					}
					
				  return null;
			 
		 }
		 
		 
		
		/* public static void main(String[] args) throws ClassNotFoundException, SQLException{
			 
			 Database_Reader.retrieveRecords("select * from emp1 where EMPNAME='Hema';");
			 
		 }*/
		
}
package course_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class course_1DButil {
	
	private static boolean isSuccess;
	private static ResultSet rs = null;
	
	//Method to add course details
	
			public static boolean createCourse( String cname, String cDuration, String cInstructor, String cDescription, String cLink) {
			
			 
			
					//create database connection
					String url ="jdbc:mysql://localhost:3306/courses_1";
					String user = "root";
					String pass = "it@22082510";	
					
					//insert course details
					
					try {
						
						System.out.print("bd ekat awa");
						
						Class.forName("com.mysql.jdbc.Driver");			
					    Connection con = DriverManager.getConnection(url, user, pass);		    
					    Statement stmt = con.createStatement();		    
					    String sql = "INSERT INTO cdetails values (0 , '"+ cname +"', '"+ cDuration + "', '"+ cInstructor + "','"+ cDescription + "','" + cLink + "' )";
					    int rs = stmt.executeUpdate(sql);	
					    
					    if(rs > 0) {
					    	isSuccess = true;
					    }   				       				    
					}		
					catch (Exception e) {
						e.printStackTrace();
					}		
			
					return isSuccess;
				}
		
			
			//Method to retrieve all course details
			
			public static List<Course_1> getAllCourse() {
				
				List<Course_1> Course  = new ArrayList<>();
				
				//create database connection
				String url ="jdbc:mysql://localhost:3306/courses_1";
				String user = "root";
				String pass = "it@22082510";	
								
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");			
				    Connection con = DriverManager.getConnection(url, user, pass);		    
				    Statement stmt = con.createStatement();	
				    
				    System.out.println("database connected");
					
					String sql = "select * from cdetails";
					rs = stmt.executeQuery(sql);
					
					System.out.println("query executed");
					
					// Get metadata of the result set
					
					 ResultSetMetaData metaData = rs.getMetaData();
			         int columnCount = metaData.getColumnCount();
			         
			         //Iterate over the result set and create Course_1 objects
					
					while (rs.next()) {
						
						  Map<String, Object> row = new HashMap<>();
			                for (int i = 1; i <= columnCount; i++) {
			                    String columnName = metaData.getColumnName(i);
			                    Object columnValue = rs.getObject(i);
			                    row.put(columnName, columnValue);
			                }
						
			                Course_1 cours = createCourseFromRow(row);
			                Course.add(cours);
			                System.out.println("read row");
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				return Course;	
			}

			// Helper method to create Course_1 object from row data
			
			  private static Course_1 createCourseFromRow(Map<String, Object> row) {
			        int cID = (int) row.get("cID");
			        String cname = (String) row.get("cname");
			        String cDuration = (String) row.get("cDuration");
			        String cInstructor = (String) row.get("cInstructor");
			        String cDescription = (String) row.get("cDescription");
			        String cLink = (String) row.get("cLink");
			        
			        return new Course_1(cID, cname, cDuration, cInstructor, cDescription, cLink);
			    }
			  
			  
			  //update
			  
				 public static boolean updateCourse( String cID,String cname, String cDuration, String cInstructor, String cDescription, String cLink) {
					 
					//create database connection
						String url ="jdbc:mysql://localhost:3306/courses_1";
						String user = "root";
						String pass = "it@22082510";	
						
						int coid = Integer.parseInt(cID);
						
						try {
							
							Class.forName("com.mysql.jdbc.Driver");			
						    Connection con = DriverManager.getConnection(url, user, pass);		    
						    Statement stmt = con.createStatement();	
						    
						    System.out.println("3 database connected");
						    
				    		String sql = "update cdetails set cname='"+cname+"',cDuration='"+cDuration+"',cInstructor='"+cInstructor+"',cDescription='"+cDescription+"',cLink='"+cLink+"'"
				    				+ "where cID='"+cID+"'";
				    		
				    		int rs = stmt.executeUpdate(sql);
				    		
				    		System.out.println("3 query executed");
				    		
				    		if(rs > 0) {
				    			isSuccess = true;
				    		}
				    		else {
				    			isSuccess = false;
				    		}
				    		
				    	}
				    	catch(Exception e) {
				    		e.printStackTrace();
				    	}
				    	
				    	return isSuccess;
				    }
				 
				 // Retrieve update data
				 
				 public static List<Course_1> getupdatecourse(String cID) {
					 
					 int cvid = Integer.parseInt(cID);
						
						ArrayList<Course_1> courseUpdate = new ArrayList<>();
						
						//create database connection
						String url ="jdbc:mysql://localhost:3306/courses_1";
						String user = "root";
						String pass = "it@22082510";	
										
						
						try {
							
							Class.forName("com.mysql.jdbc.Driver");			
						    Connection con = DriverManager.getConnection(url, user, pass);		    
						    Statement stmt = con.createStatement();	
						    
							String sql = "select * from cdetails where cID='"+cvid+"'";
							rs = stmt.executeQuery(sql);
							
							while (rs.next()) {
								int cID1 = rs.getInt(1);
								String cname = rs.getString(2);
								String cDuration = rs.getString(3);
								String cInstructor = rs.getString(4);
								String cDescription = rs.getString(5);
								String cLink = rs.getString(6);
								
								Course_1 courseup = new Course_1(cID1, cname, cDuration, cInstructor, cDescription, cLink);
								courseUpdate.add(courseup);
							}
							
						} catch (Exception e) {
							e.printStackTrace();
							
						}
						
						return courseUpdate;	
					}
				 
				 // delete course details 
				 
					public static boolean deletecourse(String cID) {
						
						
						int cvID = Integer.parseInt(cID);
						
						boolean isSuccess = false;  
						
						//create database connection
						String url ="jdbc:mysql://localhost:3306/courses_1";
						String user = "root";
						String pass = "it@22082510";	
						
						try {
							
							System.out.print("bd ekat awa");
							
							Class.forName("com.mysql.jdbc.Driver");			
						    Connection con = DriverManager.getConnection(url, user, pass);		    
						    Statement stmt = con.createStatement();	    

						    String sql = "DELETE FROM cdetails WHERE cID = '"+cvID+"'";
						    int r = stmt.executeUpdate(sql);	
    
								    if(r > 0) {
								    	isSuccess = true;
								    }   
								    
								    else {
						    			isSuccess = false;
						    		}
						    		
								}		
								catch (Exception e) {
									e.printStackTrace();
								}
						
								return isSuccess;
						}
					  
}
					 




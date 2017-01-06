package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Appointment;
import model.User;

public class BookAppointmentDao 
{
	private Connection conn;//creating reference for connection
	private PreparedStatement pst1 ;//reference for prepared statement
	ResultSet rst;//reference for resultset
	User user = null;
	
	//constructor to initialized connection with database
	public BookAppointmentDao() 
	{
			conn=JdbcConnection.getConn();
	}
	
	//to release the connection
	public void cleanUp() throws Exception {
		//if prepared statement not null closing prepared statement
		if (pst1 != null)
			pst1.close();
		
		conn.close();//connection close
		
	}
	
	
	//inserting employee details into database
	public int bookappointment(Appointment a) throws Exception {
		
			pst1 = conn.prepareStatement("Insert into appointment values(?,?,?,?)");
			pst1.setInt(1, a.getId());
			pst1.setString(2, a.getDate());
			pst1.setString(3, a.getTime());
			pst1.setString(4, a.getStatus());
			int row = pst1.executeUpdate();//executing preapared statement

		
	try {
		cleanUp();
	} catch (Exception e) {//handling error
		
		e.printStackTrace();
	}
		
		return row; 
		
	}
}


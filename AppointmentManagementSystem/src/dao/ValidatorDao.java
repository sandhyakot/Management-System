package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;



public class ValidatorDao {
	private Connection conn;//creating reference for connection
	private PreparedStatement pst1 ;//reference for prepared statement
	ResultSet rst;//reference for resultset
	User u = null;

	//constructor to initialized connection with database
	public ValidatorDao() 
	{
		conn=JdbcConnection.getConn();
	}


	//to release the connection
	public void cleanUp() throws Exception {
		//if prepared statement not null closing prepared statement
		if (pst1 != null)
			pst1.close();
		if (rst != null)
			rst.close();

		conn.close();//connection close

	}

	public User validate(int empid) {//is employee name is unique or not
		try {
			pst1 = conn.prepareStatement("Select * from user where id=(?)");
			pst1.setInt(1, empid);
			rst=pst1.executeQuery();

			if(rst.next())
			{
				u = new User(rst.getInt(1), rst.getString(2),rst.getString(3),rst.getString(4)); 

			}
		} catch (SQLException e) {//handal sqlException  
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		//closing the connections
		try {
			cleanUp();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return u; //return user

	}


}

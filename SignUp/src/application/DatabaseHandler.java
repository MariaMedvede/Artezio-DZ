package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;


public class DatabaseHandler extends Configs {

	static Connection dbConnection;

	public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
		String connectionString = "jdbc:mysql://localhost:3306/testvideo"+
                "?verifyServerCertificate=false"+
                "&useSSL=false"+
                "&requireSSL=false"+
                "&useLegacyDatetimeCode=false"+
                "&amp"+
                "&serverTimezone=UTC";

	dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
		return dbConnection;
	}

	
	public void SignUpUser(String FirstName, String LastName, String userName, String Password,
			String Date, String Answer, String Group, String email, String Phone) throws SQLException, ClassNotFoundException {

		String insert = "INSERT INTO " + "users" +"(" + "Name" + "," + 
				"surName" + "," + "login" + "," + "password" + "," + 
				"birthDate" + "," + "Answer" + "," +  "GroupNum" + "," +"email"  +"," + "Phone"  + ")" +  "VALUES(?,?,?,?,?,?,?,?,?)";

		PreparedStatement prSt = getDbConnection().prepareStatement(insert);
		prSt.setString(1, FirstName);
		prSt.setString(2, LastName);
		prSt.setString(3,userName);
		prSt.setString(4,Password);
		prSt.setString(5, Date);
		prSt.setString(6, Answer);
		prSt.setString(7, Group);
		prSt.setString(8, email);
		prSt.setString(9, Phone);
		prSt.executeUpdate();
		
		
          
         
	}
}

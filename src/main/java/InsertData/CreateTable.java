package InsertData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://localhost:5432/learning_adv_java?user=postgres&password=root";
			Connection connection=DriverManager.getConnection(url);
			String sql="create table employee(id integer primary key,name character varying,mobileno Bigint)";
			Statement statement=connection.createStatement();
			statement.execute(sql);
			connection.close();
			System.out.println("Table Has Been Created");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

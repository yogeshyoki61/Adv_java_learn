package SQLint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLint {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://localhost:5432/learning_adv_java?user=postgres&password=root";
			//external databse url access key
			//"jdbc:postgresql://dpg-d8el6pe8bjmc73b7ut80-a.oregon-postgres.render.com/adv_java_learn?user=adv_java_learn_user&password=itYDQB8HeCtWzXK0xvMoEanGUFpb1lGE"
			Connection connection=DriverManager.getConnection(url);
			Scanner sc =new Scanner(System.in);
			System.out.println("enter the username:");
			String username=sc.next();
			System.out.println("enter the password:");
			String password=sc.next();
			String sql="select * from login where username='"+username+"' and password='"+password+"'";
			Statement statement=connection.createStatement();
			statement.execute(sql);
			ResultSet rs=statement.getResultSet();
			if(rs.next())
			{
				System.out.println("Logged successfully");
			}
			else
			{
				System.out.println("logged in failed");
				System.out.println("invalid username and password");
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

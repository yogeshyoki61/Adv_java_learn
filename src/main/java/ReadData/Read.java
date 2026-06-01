package ReadData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Read {
	  public static void main(String[] args) {
		  	try {
				Class.forName("org.postgresql.Driver");
				String url="jdbc:postgresql://localhost:5432/learning_adv_java?user=postgres&password=root";
				Connection connection=DriverManager.getConnection(url);
				String sql="select * from student";
				Statement statement=connection.createStatement();
				statement.execute(sql);
				ResultSet rs = statement.getResultSet();
				System.out.println("id\t\tname\t\tweight\t\tmstatus\t\tDOB\t\tmobileno");
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t\t"
							+rs.getString(2)+"\t\t"
							+rs.getDouble(3)+"\t\t"
							+rs.getBoolean(4)+"\t\t"
							+rs.getDate(5)+"\t\t"
							+rs.getLong(6));
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

package InsertData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchProcessing {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://dpg-d8el6pe8bjmc73b7ut80-a.oregon-postgres.render.com/adv_java_learn?user=adv_java_learn_user&password=itYDQB8HeCtWzXK0xvMoEanGUFpb1lGE";
			//external databse url access key
			//"jdbc:postgresql://dpg-d8el6pe8bjmc73b7ut80-a.oregon-postgres.render.com/adv_java_learn?user=adv_java_learn_user&password=itYDQB8HeCtWzXK0xvMoEanGUFpb1lGE"
			Connection connection=DriverManager.getConnection(url);
			System.out.println("Connection Established");
			String sql="insert into employee values(?,?,?)";
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, 101);
			ps.setString(2, "yogesh");
			ps.setInt(3, 50000);
			ps.addBatch();
			ps.setInt(1, 102);
			ps.setString(2, "yoki");
			ps.setInt(3, 60000);
			ps.addBatch();
			ps.setInt(1, 103);
			ps.setString(2,"logesh");
			ps.setInt(3, 55000);
			ps.addBatch();
			ps.executeBatch();
			System.out.println("Data Saved");
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

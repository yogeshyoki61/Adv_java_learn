package InsertData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class InsertStudentData {

    public static void main(String[] args) {

        try {
        	FileInputStream fis =new FileInputStream("src\\main\\java\\InsertData\\jdbcinfo.properties");
        	Properties properties=new Properties();
        	properties.load(fis);
        	String driver=properties.getProperty("driver");
            // Step 1: Load/Register Driver
            Class.forName("org.postgresql.Driver");

            // Step 2: Establish Connection
           String url=properties.getProperty("url");

            Connection connection = DriverManager.getConnection(url,properties);

            // Step 3: Create SQL Query
            String sql = "insert into student values "+ "(104, 'abi', 5.5, false, '2003-06-01', 900008001)";

            Statement statement = connection.createStatement();

            // Step 4: Execute Query
            statement.execute(sql);

            // Step 5: Close Connection
            connection.close();

            System.out.println("Data Saved Successfully");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}

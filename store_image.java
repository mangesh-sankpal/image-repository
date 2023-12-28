package test1;
import java.io.*;
import java.sql.*;

public class store_image {

		
		public static void main(String [] args)

		{

			String url = "jdbc:mysql://localhost:3306/Test";

			String user="root";

			String password="1234";

			

			String filePath="C:\\Users\\HP\\Downloads\\camera.jpg";

			

			try

			{

				Connection con=DriverManager.getConnection(url,user,password);

				

				String sql= "INSERT INTO person (name,image) values(?,?)";

				PreparedStatement statement = con.prepareStatement(sql);

				statement.setString(1,"canon");

				

				InputStream inputStream= new FileInputStream(new File(filePath));

				statement.setBlob(2,inputStream);

				

				int row= statement.executeUpdate();

				

				if(row > 0)

				{

					System.out.println("A contact was inserted with photo image");

					

				}

				con.close();

				

				

			}

			catch(SQLException ex)

			{

				ex.printStackTrace();

			}

			catch(IOException ex)

			{

				ex.printStackTrace();

			}

		}
	
}

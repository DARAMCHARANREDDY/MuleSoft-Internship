package Movie;

import java.sql.DriverManager;
import java.sql.*;

public class RetrievingData
{
	public static void main(String mk[]) throws Exception
	{
		
		Class.forName("org.sqlite.JDBC");
		Connection con=DriverManager.getConnection("jdbc:sqlite:product:db");
		String s=sc.next();
                    String sq="select moviename from movie where leadactor == ?";
                    PreparedStatement preparedStatement=con.prepareStatement(sq);
                    preparedStatement.setString(1,s);
                    ResultSet rset = preparedStatement.executeQuery();
                    while(rset.next())
                    {                    System.out.println(rset.getString("moviename"));
                    }}
		
		
	}

}

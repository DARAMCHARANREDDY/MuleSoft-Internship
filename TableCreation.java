package Movie;

import java.sql.DriverManager;
import java.sql.*;

public class TableCreation
{
	public static void main(String mk[]) throws Exception
	{
		
		Class.forName("org.sqlite.JDBC");
		Connection con=DriverManager.getConnection("jdbc:sqlite:product:db");
		String sql="create table movie(id int primary key,mname text,lactor text,actress text,year int, dname text) ";
		Statement s=con.createStatement();
		s.execute(sql);
		System.out.print("Table Created");
		
	}
}

package Movie;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
public class locateaccordingtoActorname.java {

	public static void main(String[] args) throws Exception
	{
		Class.forName("org.sqlite.JDBC");
		Connection con=DriverManager.getConnection("jdbc:sqlite:product:db");
		String sql="select * from movie where lactor=?";
		PreparedStatement ps=con.prepareStatement(sql);
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter Actor Name");
		String nn=sc.next();
		ps.setString(1, nn);
		ResultSet rs=ps.executeQuery();
		System.out.print("Nd the Movie Name is : ");
		while(rs.next())
		{
			System.out.print(rs.getString(2));
		}
	}

}

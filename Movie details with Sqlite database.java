import java.sql.*;
import java.util.Scanner;
public class Internship {

	public static void main(String[] args) throws Exception {
		 Class.forName("org.sqlite.JDBC");
		 java.sql.Connection  con = DriverManager.getConnection("jdbc:sqlite:movies.db");
		 if(con!=null){
			 System.out.println("Connection Established Succesfully :) ");
			 PreparedStatement pstmt=con.prepareStatement("insert into MoviesList values(?,?,?,?,?,?)");
			 int n=stmt.executeUpdate("create table MoviesList(movieid int primary key,moviename text,leadactor text,actress text,year int,directorname text)");
			 System.out.println(n);
			 System.out.println("Table Created");
			 int x=stmt.executeUpdate("insert into MoviesList values(1,'kaleja','MaheshBabu','Anuskha',2008,'Venubabu')");
			 System.out.println(x);
			 Scanner sc=new Scanner(System.in);
			 System.out.println("Enter the Movie Id");
			 int movieid=sc.nextInt();
			 System.out.println("Enter the Movie Name");
			 String moviename=sc.next();
			 System.out.println("Enter the Movie Lead Actor");
			 String leadactor=sc.next();
			 System.out.println("Enter the Movie Actress");
			 String actress=sc.next();
			 System.out.println("Enter the Movie year");
			 int year=sc.nextInt();
			 System.out.println("Enter the Movie director name");
			 String directorname=sc.next();
			 pstmt.setInt(1,movieid);
			 pstmt.setString(2,moviename);
			 pstmt.setString(3,leadactor);
			 pstmt.setString(4,actress);
			 pstmt.setInt(5,year);
			 pstmt.setString(6,directorname);
			 int n=pstmt.executeUpdate();
			 System.out.println(n);*/
			 PreparedStatement pstmt=con.prepareStatement("select * from MoviesList");
			 ResultSet rs=pstmt.executeQuery();
			 System.out.println("movieid\tmoviename\tleadactor\tactress\tyear\tdirectorname");
			 System.out.println("__________________________________________________________");
			 while(rs.next()) {
			 System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t\t"+rs.getInt(4)+"\t"+rs.getString(6));
			 }
			 //updating
			 Statement stmt=con.createStatement();
			 String sql="updating the movielist with leadactor='charan' where movieid=4";
			 String sql1="delete from MoviesList where movieid=4";
			 int n=stmt.executeUpdate(sql);
			 System.out.println(n+"records deleted");
			 // retriving
			 PreparedStatement pstmt=con.prepareStatement("select * from MoviesList");
			 ResultSet rs=pstmt.executeQuery();
			 System.out.println("movieid\tmoviename\tleadactor\tactress\tyear\tdirectorname");
			 System.out.println("__________________________________________________________");
			 while(rs.next()) {
			 System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t\t"+rs.getInt(4)+"\t"+rs.getString(6));
			 }
			 
			 
		 }

	}

}

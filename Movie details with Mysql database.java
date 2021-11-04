
import java.sql.*;
import java.util.Scanner;
public class Movie {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Class Loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","root");
		System.out.println("Connection Established");
		while(true){
			System.out.println("*****Menu*****\n"+"1.Create movie table\n"+"2.Insert movie\n"+
		"3.Display Data\n"+"4.exit");
			int opt=sc.nextInt();
			switch(opt){
			case 1:createTable(); 
			       break;
			case 2:InsertMovie();
			       break;
			case 3:displayMovies();
			       break;
			case 4:System.exit(0);
	
			}}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	private static void displayMovies() {
		// TODO Auto-generated method stub
		try
		{
			Connection con=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Class Loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","root");
			System.out.println("Connection Established");
			String qry="select * from movie";
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery(qry);
			int count=1;
			while(rs.next())
			{
				
				System.out.println("movie record: "+count);
				System.out.println("movie Id: "+rs.getInt("mid"));
				System.out.println("movie Name: "+rs.getString("moviename"));
				System.out.println("actor: "+rs.getString("actor"));
				System.out.println("actress: "+rs.getString("actress"));
				System.out.println("release year: "+rs.getInt("releaseyear"));
				System.out.println("director: "+rs.getString("director"));
				count++;
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	private static void createTable() {
		try {
			Connection con=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","root");
			Statement smt=con.createStatement();
			smt.executeUpdate("create table movie(mid int primary key,moviename varchar(100),actor varchar(100),actress varchar(100),releaseyear int,director varchar(100))");
			System.out.println("Movie table create successfully");
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	

	

	private static void InsertMovie() {
		Scanner sc=new Scanner(System.in);
	try {
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","motherss");
		Statement smt=con.createStatement();
		System.out.println("Enter mid,movie name,actor,actress, director, release year ");
		int mid=sc.nextInt();
		String moviename=sc.next();
		String actor=sc.next();
		String actress=sc.next();
		int releaseyear=sc.nextInt();
		String director=sc.next();
		String qry="insert into movie values("+mid+",'"+moviename+"','"+actor+"','"+actress+"',"+releaseyear+",'"+director+"')";
		smt.executeUpdate(qry);
		System.out.println("movie added  succesfully");
		con.close();
	}
	catch (Exception e)
	{
		System.out.println(e);
	}
	}


}

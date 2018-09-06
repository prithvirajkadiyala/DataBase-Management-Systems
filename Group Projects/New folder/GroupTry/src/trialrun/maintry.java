//Written by PK
package trialrun;
import java.sql.*;
import java.util.*;

public class maintry {
	public static Scanner scan = new Scanner(System.in);
	private static Connection dbConnection;
	private static Statement stmt;
	
	public static void initdb() {
		try { 
			Class.forName("oracle.jdbc.OracleDriver"); 
	} catch(Exception x){ 
			System.out.println( "Unable to load the driver class!" );
			
		}
		try{
			dbConnection = DriverManager.getConnection ("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu"," kadi0000 ", " XWza6Tc8 "); 
			stmt = dbConnection.createStatement(); 
			} 
		catch(Exception e) { 
			System.out.println (e.getMessage()); 
			System.out.println ("Exception occurred in executing the statement");
		} 
	}
	public static String getInput(String prompt) {
		System.out.println(prompt);
		return scan.nextLine();
	}
	public static void main(String[] args) { 
		initdb();
		boolean shouldQuit = false;
		String bigPrompt = "------------------------------------------------------------------------------------------------\n" + 
		                                        "	WELCOME TO THE DATABASE OF GROUP PROJECT2 PROBLEM2\n" + 
				"------------------------------------------------------------------------------------------------\n" +
                "Please Enter you option(1-17):\n" + 
				"1. See all the data from Author\n" +
				"2. See all the data from Book\n" +
				"3. See all the data from Translator\n" +
				"4. See all the data from Written\n" +
				"5. See all the data from Customer\n" +
				"6. See all the data from Purchased\n" +
				"7. Display all the data you store in the database to verify that you have populated the relations correctly.\n" +
				"8. Find the levels and names of all customers who have purchased a book written by the author named 'Adams'.\n" +
				"9. Find the category and name of the oldest book that has more than 10 editions and was translated by 'Mark'\n" +
				"10. Find the Authors' names of all books, each of which has more than 2 authors.\n" +
				"11. Find the names of the translators for whom the combined number of authors for all books that they translated is equal to or more than 2.\n" +
				"12. Find the categories which have exactly 2 translators.\n" +
				"13. Find the names and aids of all authors who wrote two books that are in the same category.\n" +
				"14. For each category, display the category and the average number of editions for that category.\n" +
				"15. Increase the salary of all translators who translated the book titled “Beautiful Mind” by 10%.\n" +
				"16. Delete all cutomers with the children level.\n"+
				"17. Create Index on Book Table on  .\n"+
				"18. Quit\n";
		while(!shouldQuit)
			{
				String inp = getInput(bigPrompt);
				int input = -1;
				try {
					input = Integer.parseInt(inp.trim());
				}
				catch(Exception e) {}
					switch(input) {
					case 1:
						option1();
						break;
					case 2:
						option2();
						break;
					case 3:
						option3();
						break;
					case 4:
						option4();
						break;
					case 5:
						option5();
						break;
					case 6:
						option6();
						break;
					case 7:
						option7();
						break;
					case 8:
						option8();
						break;
					case 9:
						option9();
						break;
					case 10:
						option10();
						break;
					case 11:
						option11();
						break;
					case 12:
						option12();
						break;
					case 13:
						option13();
						break;
					case 14:
						option14();
						break;
					case 15:
						option15();
						break;
					case 16:
						option16();
						break;
					case 17:
						option16();
						break;
					case 18:
						shouldQuit = true;
						break;
					default:
						System.out.println("Sorry, Unrecognized input");
						break;
					}
				}
				System.out.println("Thank You for using the Program");
		}
		public static String getDateSQL() {
			String month = getInput("month(mm):");
			String day = getInput("day(dd):");
			String year = getInput("year(yyyy):");
			String dateString = "TO_DATE('" + month +"-"+day+"-"+year+"', MM-DD-YYYY)";
			return dateString;
			
		}
		//select all from Author Table
		public static void option1() {
			String sql = "SELECT * FROM AUTHOR";
			//Loop through result set and extract results of the query
			try {
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("aid|Author_Name|Age|Number of Publications");
				while(rs.next()) {
					System.out.println(rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3) + "|" + rs.getString(4));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}
		//Select all from Book Table
		public static void option2() {
			String sql = "SELECT * FROM BOOK";
			//Loop through result set and extract results of the query
			try {
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("Book Title||Category|Release Year|Edition|Translator_ID");
				while(rs.next()) {
					System.out.println(rs.getString(1) + "||" + rs.getString(2) + "|" + rs.getString(3) + "|" + rs.getString(4) + "|" + rs.getString(5));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}
		//SELECT ALL FROM TRANSLATOR TABLE
		public static void option3() {
			String sql = "SELECT * FROM TRANSLATOR";
			//Loop through result set and extract results of the query
			try {
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("Translator_ID|TRANSLATOR_NAME|SALARY");
				while(rs.next()) {
					System.out.println(rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}
		//SELECT ALL FROM WRITTEN TABLE
		public static void option4() {
			String sql = "SELECT * FROM WRITTEN";
			//Loop through result set and extract results of the query
			try {
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("aid  |  BookTitle");
				while(rs.next()) {
					System.out.println(rs.getString(1) + "|" + rs.getString(2));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}
		//CUSTOMER
		public static void option5() {
			String sql = "SELECT * FROM CUSTOMER";
			//Loop through result set and extract results of the query
			try {
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("Customer_ID | Customer_Name | Number of orders | Customer_Level");
				while(rs.next()) {
					System.out.println(rs.getString(1) + "|" + rs.getString(2) + "|" + rs.getString(3) + "|" + rs.getString(4));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}
		//PURCHASED
		public static void option6() {
			String sql = "SELECT * FROM PURCHASED";
			//Loop through result set and extract results of the query
			try {
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("Customer_ID | Book_Title");
				while(rs.next()) {
					System.out.println(rs.getString(1) + "|" + rs.getString(2));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}
		//Display All Tables
		public static void option7() {
			option1();
			System.out.println("\n\n");
			option2();
			System.out.println("\n\n");
			option3();
			System.out.println("\n\n");
			option4();
			System.out.println("\n\n");
			option5();
			System.out.println("\n\n");
			option6();
		}
		//Find the levels and names of all customers who have purchased a book written by the author named 'Adams'.
		public static void option8() {
			String sql = "Select cname, clevel from Customer where cid in (Select cid from Purchased where bTitle in(Select bTitle from written where aid in(Select aid from Author where aname='Adams')))";
			//Loop through result set and extract results of the query
			try {
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("\nCustomer_Name | Customer_Level");
				while(rs.next()) {
					System.out.println(rs.getString(1) + "|" + rs.getString(2));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}
		//Find the category and name of the oldest book that has more than 10 editions and was translated by 'Mark'.
		public static void option9() {
			String sql = "select btitle,category,edition from BOOK where edition >10 and tid in(Select tid from Translator where tname ='Mark')";
			//Loop through result set and extract results of the query
			try {
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("\nBook_Title | Category");
				while(rs.next()) {
					System.out.println(rs.getString(1) + "|" + rs.getString(2));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}
		//Find the Authors' names of all books, each of which has more than 2 authors.
		public static void option10() {
			String sql = "select aname from Author where aid in(select distinct aid from Written where bTitle in(select bTitle from Written group by bTitle having COUNT(*)>2))";
			//Loop through result set and extract results of the query
			try {
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("\nAuthor Name");
				while(rs.next()) {
					System.out.println(rs.getString(1));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}
		//Find the names of the translators for whom the combined number of authors for all books that they translated is equal to or more than 2.
		public static void option11() {
			String sql = "select tname from translator where tid in(select tid from Book group by tid having count(*)>2)";
			//Loop through result set and extract results of the query
			try {
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("\nTranslator Name");
				while(rs.next()) {
					System.out.println(rs.getString(1));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}
		//Find the categories which have exactly 2 translators.
		public static void option12() {
			String sql = "select category, count(*) from BOOK group by category having COUNT(*)=2";
			//Loop through result set and extract results of the query
			try {
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("Category | Count(*)");
				while(rs.next()) {
					System.out.println(rs.getString(1) + "|" + rs.getString(2));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}
		//Find the names and aids of all authors who wrote two books that are in the same category.
		public static void option13() {
			String sql = "select a.aid, a.aname from author a where a.aid IN(select  w.aid from book b, written w where b.btitle=w.btitle and w.aid IN (select unique(a.aid) from author a, written w, book b where a.aid = w.aid and w.btitle = b.btitle group by a.aid having count(aname) = 2) group by b.category, w.aid having count(b.category) =2)";
			//Loop through result set and extract results of the query
			try {
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("Author_ID | Author_Name");
				while(rs.next()) {
					System.out.println(rs.getString(1) + "|" + rs.getString(2));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}
		//For each category, display the category and the average number of editions for that category.
		public static void option14() {
			String sql = "select category, avg(edition) from book group by category";
			//Loop through result set and extract results of the query
			try {
				ResultSet rs = stmt.executeQuery(sql);
				System.out.println("Category | Avg(Edition)");
				while(rs.next()) {
					System.out.println(rs.getString(1) + "|" + rs.getString(2));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}
		//Increase the salary of all translators who translated the book titled “Beautiful Mind” by 10%.
		public static void option15() {
			String sql = "update translator set salary = salary * 1.10 where tid in (select tid from book where btitle='Beautiful Mind')";
			//Loop through result set and extract results of the query
			try {
				stmt.executeQuery(sql);
				System.out.println("Statement Executed and Updated the Salary");
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}
		//Delete all customers with the children level.
		public static void option16() {
			String sql = "delete from customer where clevel = 'Children'";
			//Loop through result set and extract results of the query
			try {
				stmt.executeQuery(sql);
				System.out.println("Occurences have been deleted");
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}
		public static void option17() {
			String sql = "CREATE INDEX BOOK_RELEASE_YEAR ON BOOK (RELEASE_YEAR)";
			//Loop through result set and extract results of the query
			try {
				stmt.executeQuery(sql);
				System.out.println("CREATED INDEX");
			}catch(SQLException e) {
				e.printStackTrace();
			}	
		}
} 


import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

/*
 * A singleton for managing the sqlite database we're using.
 * You can run SQL statements on the DB using:
 * 		DBManager.DB.runStatement(yourStatement);
 */

public enum DBManager {
	DB;

	// the database file to use
	final String filename = "hotel.db";
	
	private Connection c;
	private Statement s;

	// a database connection should be opened once, when the application starts
	private DBManager() {
		try {
			// open DB connection
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:" + filename);
			c.setAutoCommit(false);
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}

	// this closes the database connection. Should be run when the application
	// is exited
	public int close() {
		try {
			// close DB connection
			DB.c.close();
			return 0;
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
			return 1;
		}
	}

	// commits all pending changes to the DB
	public int commit() {
		try {
			DB.c.commit();
			return 0;
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return 1;
		}
	}

	// runs any SQL statement provided as a string argument
	public static int run(String sqlStatement) {
		try {
			DB.s = DB.c.createStatement();
			DB.s.executeUpdate(sqlStatement);
			DB.s.close();
			DB.c.commit();
			return 0;
		} catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return 1;
		}	
	}
	
	// Add a Client in the DB
	public static int addClient(Client c) {
		StringBuilder s = new StringBuilder();
		s.append("insert into client (cid, name, phone) values (\"");
		s.append(c.getId());
		s.append("\", \"");
		s.append(c.getName());
		s.append("\", ");
		s.append(c.getPhone());
		s.append(");");
		return run(new String(s));
	}

	// Update client details in the DB
	public static int updateClient(Client c) {
		StringBuilder s = new StringBuilder();
		s.append("update client set name = \"");
		s.append(c.getName());
		s.append("\", phone = ");
		s.append(c.getPhone());
		s.append(" where cid == \"");
		s.append(c.getId());
		s.append("\";");
		return DBManager.run(new String(s));
	}

	// delete the client from the DB
	public static int deleteClient(Client c) {
		StringBuilder s = new StringBuilder();
		s.append("delete from client where cid == \"");
		s.append(c.getId());
		s.append("\";");
		return DBManager.run(new String(s));
	}

	public static int createEmptyDB() {
		try {
			// read the DB creation statements from a file. It would be ugly to
			// put them all in a Java string.
			String sql = new String(Files.readAllBytes(Paths.get("create_db.sql")), "utf8");
			return run(sql);
		} catch (Exception e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			return 2;
		}
	}

	public static void main(String[] args) {
		createEmptyDB();
	}
}
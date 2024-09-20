package telBookApp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static Connection dbConn;

	public static Connection getConnection() {
		if (dbConn == null) { // 연결이 되지 않았다면

			try { // 접속 시도 해봄
				String dbDriver = "com.mysql.cj.jdbc.Driver";
				String dbUrl = "jdbc:mysql://localhost:3306/tel_db";
				String dbUser = "root";
				String dbPassword = "1111";
				Class.forName(dbDriver);
				
				dbConn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
//				System.out.println("DB 접속 성공");
			} catch (SQLException e) {
				System.out.println("DB 접속 실패");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("DB 접속 실패");
				e.printStackTrace();
			}
		}
		return dbConn;
	}
	
	public static void close() {
		if(dbConn != null) {
			try {
				if(! dbConn.isClosed()) {
					dbConn.close();
				}				
			} catch(Exception e) {
				System.out.println(e.toString());
			}
			dbConn = null;
		}
	}
}

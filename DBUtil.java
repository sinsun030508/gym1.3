package gym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static void init() {
    	Connection conn = null;
		try {
			conn = DBUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			System.out.println("📌 현재 접속 중인 DB 이름: " + conn.getCatalog());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("DB 드라이버 로딩 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로딩 실패");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/gym?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8",
            "root", "rootroot"
        );
    }
}
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Connect {

    private static Connect connect;
    private final String url;
    private final String uname;
    private final String pw;
    private Connection con;
    private final String db;
    private final String unicode ;

    private Connect() {
        unicode = "?useUnicode=yes&characterEncoding=UTF-8";
        db = "sms";
        url = "jdbc:mysql://localhost/" + db+unicode;
        uname = "root";
        pw = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, uname, pw);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public static Connect getConnect() {
        if (connect == null) {
            connect = new Connect();
        }
        return connect;
    }

    public Connection getConnection() {
        return con;
    }
}

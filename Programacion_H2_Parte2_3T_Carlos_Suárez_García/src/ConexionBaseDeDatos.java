import java.sql.*;

public class ConexionBaseDeDatos {
    private static final String url = "jdbc:mysql://localhost:3307/cine_carlossuarez";
    private static final String usuario = "root";
    private static final String contrase�a = "";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, usuario, contrase�a);
	}
}
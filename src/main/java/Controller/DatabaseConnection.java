        package Controller;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;

    public class DatabaseConnection {

        // Database URL, username, and password
        private static final String URL = "jdbc:mysql://localhost:3306/TechRepair";
        private static final String USER = "root"; // replace with your DB username
        private static final String PASSWORD = ""; // replace with your DB password

        // Method to establish a connection
        public static Connection getConnection() {
            Connection connection = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connected to the database.");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                System.out.println("Database connection failed.");
            }
            return connection;
        }
    }

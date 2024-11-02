package Controller;

import Model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerController {
    public boolean saveCustomer(Customer customer) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO customers (firstName, lastName, email, phone, address, password) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPhone());
            statement.setString(5, customer.getAddress());
            statement.setString(6, customer.getPassword()); // Set password field
            
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

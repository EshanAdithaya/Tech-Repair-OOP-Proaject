package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Order;


public class OrderController {

    // Save order method
    public boolean saveOrder(Order order) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String insertOrderSQL = "INSERT INTO Orders (CustomerName, CustomerPhoneNumber, ServiceType, TotalAmount, DeviceType, IssueDescription, Status) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(insertOrderSQL);

            statement.setString(1, order.getCustomerName());
            statement.setString(2, order.getCustomerPhoneNumber());
            statement.setString(3, order.getServiceType());
            statement.setBigDecimal(4, new java.math.BigDecimal(order.getTotalAmount()));
            statement.setString(5, order.getDeviceType());
            statement.setString(6, order.getIssueDescription());
            statement.setString(7, order.getStatus());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean updateOrder(Order order,int orderId) {
    try (Connection connection = DatabaseConnection.getConnection()) {
        String updateOrderSQL = "UPDATE Orders SET CustomerName = ?, CustomerPhoneNumber = ?, ServiceType = ?, TotalAmount = ?, DeviceType = ?, IssueDescription = ?, Status = ? WHERE OrderID = ?";
        PreparedStatement statement = connection.prepareStatement(updateOrderSQL);
        statement.setString(1, order.getCustomerName());
        statement.setString(2, order.getCustomerPhoneNumber());
        statement.setString(3, order.getServiceType());
        statement.setBigDecimal(4, new java.math.BigDecimal(order.getTotalAmount()));
        statement.setString(5, order.getDeviceType());
        statement.setString(6, order.getIssueDescription());
        statement.setString(7, order.getStatus());
        statement.setInt(8, orderId);  // Assuming Order class has getOrderID() method
        
        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
    
public boolean deleteOrder(int orderId) {
    try (Connection connection = DatabaseConnection.getConnection()) {
        String deleteOrderSQL = "DELETE FROM Orders WHERE OrderID = ?";
        PreparedStatement statement = connection.prepareStatement(deleteOrderSQL);
        statement.setInt(1, orderId);
        
        int rowsDeleted = statement.executeUpdate();
        return rowsDeleted > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    // Method to get all orders from the database
    public ResultSet getOrders() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT * FROM Orders";
            PreparedStatement statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

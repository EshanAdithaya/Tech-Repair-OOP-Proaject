package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.InventoryItem;
import Controller.DatabaseConnection;

public class InventoryController {

    // Save inventory item method
    public boolean saveInventoryItem(InventoryItem item) {
        String sql = "INSERT INTO inventory (ItemName, Description, Category, Stock, " +
                     "UnitPrice, SupplierName, SKU, WarehouseLocation, Status) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, item.getItemName());
            statement.setString(2, item.getDescription());
            statement.setString(3, item.getCategory());
            statement.setString(4, item.getStock());
            statement.setString(5, item.getUnitPrice());
            statement.setString(6, item.getSupplierName());
            statement.setString(7, item.getSku());
            statement.setString(8, item.getWarehouseLocation());
            statement.setString(9, item.getStatus());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateInventoryItem(InventoryItem item, int itemID) {
    String sql = "UPDATE inventory SET ItemName = ?, Description = ?, Category = ?, Stock = ?, " +
                 "UnitPrice = ?, SupplierName = ?, SKU = ?, WarehouseLocation = ?, Status = ? " +
                 "WHERE ItemID = ?";
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, item.getItemName());
        statement.setString(2, item.getDescription());
        statement.setString(3, item.getCategory());
        statement.setString(4, item.getStock());
        statement.setString(5, item.getUnitPrice());
        statement.setString(6, item.getSupplierName());
        statement.setString(7, item.getSku());
        statement.setString(8, item.getWarehouseLocation());
        statement.setString(9, item.getStatus());
        statement.setInt(10, itemID);

        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

public boolean deleteInventoryItem(int itemID) {
    String sql = "DELETE FROM inventory WHERE ItemID = ?";
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, itemID);

        int rowsDeleted = statement.executeUpdate();
        return rowsDeleted > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    // Fetch all inventory items from the database
    public ResultSet getInventoryItems() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT * FROM inventory";
            PreparedStatement statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import Model.Supplier;
import Controller.DatabaseConnection;

public class SupplierController {

    public boolean saveSupplier(Supplier supplier) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO suppliers (CompanyName, ContactName, Email, Phone, Street_Address, " +
                         "City, `State/Province`, Postal_Code, Country, `Main_Product/Service_Category`, `Active/Inactive`) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, supplier.getCompanyName());
            statement.setString(2, supplier.getContactName());
            statement.setString(3, supplier.getEmail());
            statement.setString(4, supplier.getPhone());
            statement.setString(5, supplier.getStreetAddress());
            statement.setString(6, supplier.getCity());
            statement.setString(7, supplier.getState());
            statement.setString(8, supplier.getPostalCode());
            statement.setString(9, supplier.getCountry());
            statement.setString(10, supplier.getCategory());
            statement.setString(11, supplier.getStatus());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                sendEnrollmentEmail(supplier);
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateSupplier(Supplier supplier, int supplierID) {
    String sql = "UPDATE suppliers SET CompanyName = ?, ContactName = ?, Email = ?, Phone = ?, " +
                 "Street_Address = ?, City = ?, `State/Province` = ?, Postal_Code = ?, Country = ?, " +
                 "`Main_Product/Service_Category` = ?, `Active/Inactive` = ? " +
                 "WHERE SupplierID = ?";
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, supplier.getCompanyName());
        statement.setString(2, supplier.getContactName());
        statement.setString(3, supplier.getEmail());
        statement.setString(4, supplier.getPhone());
        statement.setString(5, supplier.getStreetAddress());
        statement.setString(6, supplier.getCity());
        statement.setString(7, supplier.getState());
        statement.setString(8, supplier.getPostalCode());
        statement.setString(9, supplier.getCountry());
        statement.setString(10, supplier.getCategory());
        statement.setString(11, supplier.getStatus());
        statement.setInt(12, supplierID);

        int rowsUpdated = statement.executeUpdate();
        return rowsUpdated > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
public boolean deleteSupplier(int supplierID) {
    String sql = "DELETE FROM suppliers WHERE SupplierID = ?";
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, supplierID);

        int rowsDeleted = statement.executeUpdate();
        return rowsDeleted > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    
    public ResultSet getSuppliers() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT * FROM suppliers";
            PreparedStatement statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void sendEnrollmentEmail(Supplier supplier) {
        // Email configuration
        String host = "smtp.gmail.com";
        String port = "587";
        String username = "cocpissa12@gmail.com";
        String password = "kqmc qasj cemm wqxy";

        // Set properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Create session
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(supplier.getEmail()));
            message.setSubject("Welcome to TechRepair");
            message.setText("Dear " + supplier.getContactName() + ",\n\n"
                    + "We are pleased to inform you that you have been successfully enrolled as a supplier for our shop, TechRepair. "
                    + "We look forward to a fruitful partnership and are excited to work with you.\n\n"
                    + "If you have any questions or need further assistance, please do not hesitate to contact us.\n\n"
                    + "Best regards,\nTechRepair Team");

            // Send message
            Transport.send(message);

            System.out.println("Enrollment email sent successfully to " + supplier.getEmail());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}

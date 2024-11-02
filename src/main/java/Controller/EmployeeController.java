package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import Model.Employee;
import Controller.DatabaseConnection;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.text.Document;

public class EmployeeController {
    // Save employee method
    public boolean saveEmployee(Employee employee) {
        String sql = "INSERT INTO employees (EmployeeFname, EmployeeLname, EmployeeEmail, EmployeePhone, " +
                     "EmployeeJobRole, EmployeeWorkLocation, EmployeeStatus) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getEmail());
            statement.setString(4, employee.getPhone());
            statement.setString(5, employee.getJobRole());
            statement.setString(6, employee.getWorkLocation());
            statement.setString(7, employee.getStatus());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                sendEnrollmentEmail(employee);
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // Update employee method
    public boolean updateEmployee(Employee employee, int id) {
        String sql = "UPDATE employees SET EmployeeFname = ?, EmployeeLname = ?, EmployeeEmail = ?, EmployeePhone = ?, " +
                     "EmployeeJobRole = ?, EmployeeWorkLocation = ?, EmployeeStatus = ? " +
                     "WHERE EmployeeID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getEmail());
            statement.setString(4, employee.getPhone());
            statement.setString(5, employee.getJobRole());
            statement.setString(6, employee.getWorkLocation());
            statement.setString(7, employee.getStatus());
            statement.setInt(8, id);
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete employee method
    public boolean deleteEmployee(int employeeId) {
        String sql = "DELETE FROM employees WHERE EmployeeID = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, employeeId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    // Fetch all employees from the database
    public ResultSet getEmployees() {
        try {
            Connection connection = DatabaseConnection.getConnection();
            String query = "SELECT * FROM employees";
            PreparedStatement statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Send enrollment email to the employee
    private void sendEnrollmentEmail(Employee employee) {
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
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(employee.getEmail()));
            message.setSubject("Welcome to Our Company");
            message.setText("Dear " + employee.getFirstName() + ",\n\n"
                    + "You have been successfully enrolled in our company system. "
                    + "Welcome aboard!\n\n"
                    + "Best regards,\nHR Team");

            // Send message
            Transport.send(message);

            System.out.println("Enrollment email sent successfully to " + employee.getEmail());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
//    
//      public void generateEmployeePDF() {
//        String fileName = "EmployeeReport.pdf";
//
//        // Document instance
//        Document document = new Document() {};
//
//        try {
//            PdfWriter.getInstance((com.itextpdf.text.Document) document, new FileOutputStream(fileName));
//            document.open();
//            document.add(new Paragraph("Employee Report"));
//            document.add(new Paragraph(" "));
//
//            // Add table
//            PdfPTable table = new PdfPTable(8);
//            table.addCell("EmployeeID");
//            table.addCell("First Name");
//            table.addCell("Last Name");
//            table.addCell("Email");
//            table.addCell("Phone");
//            table.addCell("Job Role");
//            table.addCell("Work Location");
//            table.addCell("Status");
//
//            // Fetch employee data
//            ResultSet resultSet = getEmployees();
//            while (resultSet != null && resultSet.next()) {
//                table.addCell(String.valueOf(resultSet.getInt("EmployeeID")));
//                table.addCell(resultSet.getString("EmployeeFname"));
//                table.addCell(resultSet.getString("EmployeeLname"));
//                table.addCell(resultSet.getString("EmployeeEmail"));
//                table.addCell(resultSet.getString("EmployeePhone"));
//                table.addCell(resultSet.getString("EmployeeJobRole"));
//                table.addCell(resultSet.getString("EmployeeWorkLocation"));
//                table.addCell(resultSet.getString("EmployeeStatus"));
//            }
//            document.add(table);
//            document.close();
//            System.out.println("PDF generated successfully: " + fileName);
//        } catch (DocumentException | IOException | SQLException e) {
//            e.printStackTrace();
//        }
//    }
    
    
}
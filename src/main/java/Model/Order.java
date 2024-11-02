package Model;

public class Order {
    private String customerName;
    private String customerPhoneNumber;
    private String serviceType;
    private String totalAmount;
    private String deviceType;
    private String issueDescription;
    private String status;

    // Constructor
    public Order(String customerName, String customerPhoneNumber, String serviceType, 
                 String totalAmount, String deviceType, String issueDescription, 
                 String status) {
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.serviceType = serviceType;
        this.totalAmount = totalAmount;
        this.deviceType = deviceType;
        this.issueDescription = issueDescription;
        this.status = status;
    }

    // Getters and Setters
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerPhoneNumber() { return customerPhoneNumber; }
    public void setCustomerPhoneNumber(String customerPhoneNumber) { this.customerPhoneNumber = customerPhoneNumber; }

    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }

    public String getTotalAmount() { return totalAmount; }
    public void setTotalAmount(String totalAmount) { this.totalAmount = totalAmount; }

    public String getDeviceType() { return deviceType; }
    public void setDeviceType(String deviceType) { this.deviceType = deviceType; }

    public String getIssueDescription() { return issueDescription; }
    public void setIssueDescription(String issueDescription) { this.issueDescription = issueDescription; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

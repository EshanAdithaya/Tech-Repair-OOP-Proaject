package Model;

public class InventoryItem {
    private String itemName;
    private String description;
    private String category;
    private String stock;
    private String unitPrice;
    private String supplierName;
    private String sku;
    private String warehouseLocation;
    private String status;

    // Constructor
    public InventoryItem(String itemName, String description, String category, 
                         String stock, String unitPrice, String supplierName, 
                         String sku, String warehouseLocation, String status) {
        this.itemName = itemName;
        this.description = description;
        this.category = category;
        this.stock = stock;
        this.unitPrice = unitPrice;
        this.supplierName = supplierName;
        this.sku = sku;
        this.warehouseLocation = warehouseLocation;
        this.status = status;
    }

    // Getters and Setters
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getStock() { return stock; }
    public void setStock(String stock) { this.stock = stock; }

    public String getUnitPrice() { return unitPrice; }
    public void setUnitPrice(String unitPrice) { this.unitPrice = unitPrice; }

    public String getSupplierName() { return supplierName; }
    public void setSupplierName(String supplierName) { this.supplierName = supplierName; }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public String getWarehouseLocation() { return warehouseLocation; }
    public void setWarehouseLocation(String warehouseLocation) { this.warehouseLocation = warehouseLocation; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

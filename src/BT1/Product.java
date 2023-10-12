package BT1;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    int productId;
    String productName;
    private String manufacturer;
    private double price;
    private String description;

    public Product(int productId, String productName, String manufacturer, double price, String description) {
        this.productId = productId;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.price = price;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Id sản phẩm: " + productId +
                "\nTên sản phẩm: " + productName +
                "\nHãng sản phẩm: " + manufacturer +
                "\nGiá sản phẩm: " + price +
                "\nMô tả: " + description + "\n";
    }
}

package BT1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement implements Serializable {
    private static final long serialVersionUID = 1L;
    private static List<Product> products = new ArrayList<>();
    private static final String fileName = "src/BT1/products.dat";

    public static void main(String[] args) {
        loadProducts();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Tìm sản phẩm theo tên");
            System.out.println("4. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    displayProducts();
                    break;
                case 3:
                    searchProductByName(scanner);
                    break;
                case 4:
                    saveProducts();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ. Mời nhập lại");
            }
        }
    }

    private static void loadProducts() {
        File file = new File(fileName);
        if (file.exists()) {
            try {
                FileInputStream fileIn = new FileInputStream(fileName);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                products = (List<Product>) objectIn.readObject();
                objectIn.close();
                fileIn.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            products = new ArrayList<>();
        }
    }

    private static void saveProducts() {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(products);
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addProduct(Scanner scanner) {
        System.out.print("Nhập ID sản phẩm: ");
        int productId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String productName = scanner.nextLine();
        System.out.print("Nhập hãng sản xuất: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine();

        Product newProduct = new Product(productId, productName, manufacturer, price, description);
        products.add(newProduct);
        System.out.println("Đã thêm sản phẩm thành công");
    }

    private static void displayProducts() {
        System.out.println("Danh sách sản phẩm:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void searchProductByName(Scanner scanner) {
        System.out.print("Nhập tên sản phẩm tìm kiếm: ");
        String searchProductName = scanner.nextLine();
        boolean found = false;

        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(searchProductName)) {
                System.out.println("Sản phẩm được tìm thấy:\n" + product);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sản phẩm");
        }
    }
}

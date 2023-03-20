package ra.bussinessImp;

import ra.bussiness.IProduct;

import java.util.Comparator;
import java.util.Scanner;

public class Product implements IProduct, Comparable<Product> {
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, float importPrice, float exportPrice, float interest, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("Nhập thông tin sản phẩm từ bàn phím. ");
        System.out.println("Nhập mã sản phẩm: ");
        this.productId = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tên sản phẩm: ");
        this.productName = sc.nextLine();
        System.out.println("Nhập tiêu đề sản phẩm: ");
        this.title = sc.nextLine();
        System.out.println("Nhập mô tả sản phẩm: ");
        this.descriptions = sc.nextLine();
        System.out.println("Giá nhập: ");
        this.importPrice = Integer.parseInt(sc.nextLine());
        System.out.println("Giá xuất: ");
        this.exportPrice = Integer.parseInt(sc.nextLine());
        System.out.println("Trạng thái: ");
        this.productStatus = Boolean.parseBoolean(sc.nextLine());
        this.interest = this.exportPrice-this.importPrice;
    }


    @Override
    public void displayData() {
//        System.out.println("\nThông tin sản phẩm ");
        System.out.print("Mã sản phẩm: " + productId);
        System.out.print(", Tên sản phẩm: " + productName);
        System.out.print(", Tiêu đề sản phẩm: " + title);
        System.out.print("\n Mô tả sản phẩm: " + descriptions);
        System.out.print(", Giá nhập: " + importPrice);
        System.out.print(", Giá xuất: " + exportPrice);
        System.out.print(", Trạng thái: " + productStatus+"\n");
        System.out.println("-------------------------------------------------------------------------");
    }

    @Override
    public int compareTo(Product o) {
        return (int) (this.interest - o.getInterest());
    }
}

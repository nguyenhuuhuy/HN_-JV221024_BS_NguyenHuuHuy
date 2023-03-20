package ra.run;

import ra.bussinessImp.Product;

import java.util.*;

public class ProductManagement {
    static List<Product> listProduct = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số sản phẩm và nhập thông tin sản phẩm \n" +
                    "2. Hiển thị thông tin các sản phẩm \n" +
                    "3. Sắp xếp sản phẩm theo lợi nhuận tăng dần \n" +
                    "4. Xóa sản phẩm theo mã sản phẩm \n" +
                    "5. Tìm kiếm sản phẩm theo tên sản phẩm \n" +
                    "6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm \n" +
                    "7. Thoát \n");
            System.out.print("mời chọn số: ");
            int choise = Integer.parseInt(sc.nextLine());
            switch (choise) {
                case 1:
                    inputProduct(sc);
                    break;
                case 2:
                    displayListProduct();
                    break;
                case 3:
                    Collections.sort(listProduct);
                    break;
                case 4:
                    System.out.println("Nhập id sản phẩm muốn xóa");
                    int number = Integer.parseInt(sc.nextLine());
                    deleteProduct(number);
                    break;
                case 5:
                    searchProduct(sc);
                    break;
                case 6:
                    statusProduct(sc);
                    break;
                case 7:
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1->7");
            }
        } while (true);
    }

    public static void inputProduct(Scanner sc) {
        System.out.print("Nhập số sản phẩm cần nhập thông tin: ");
        int count = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < count; i++) {
            Product product = new Product();
            product.inputData(sc);
            listProduct.add(product);
        }
    }

    public static void displayListProduct() {
        System.out.println("\nThông tin sản phẩm ");
        for (int i = 0; i < listProduct.size(); i++) {
            listProduct.get(i).displayData();
        }
    }

    public static void deleteProduct(int index) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getProductId() == index) {
                listProduct.remove(i);
            }
        }
        System.out.println("sản phầm còn lại sau khi xóa: ");
        for (int i = 0; i < listProduct.size(); i++) {
            listProduct.get(i).displayData();
        }
    }

    public static void searchProduct(Scanner sc) {
        System.out.println("Nhập tên sản phẩm cần tìm kiếm: ");
        String searchProductName = sc.nextLine();
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getProductName().contains(searchProductName)) {
                listProduct.get(i).displayData();
            }
        }
    }

    public static void statusProduct(Scanner sc) {
        System.out.println("Mã sản phẩm cần thay đổi trạng thái: ");
        int changeStatus = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getProductId() == changeStatus) {
                boolean check = listProduct.get(i).isProductStatus();
                if (check) {
                    listProduct.get(i).setProductStatus(false);
                } else {
                    listProduct.get(i).setProductStatus(true);
                }
                System.out.println("sau khi thay đổi: ");
                listProduct.get(i).displayData();
            }
        }
    }
}

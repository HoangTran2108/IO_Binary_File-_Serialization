import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadAndWrite {
    public static List<Product>products = new ArrayList<>();
    public static void main(String[] args) {
        File file = new File("product.dat");
        products.add(new Product("1","rice","ST", 1500));
        products.add(new Product("2","potato","ST", 2500));
        products.add(new Product("3","corn","ST", 2000));
        writeToFile(file, products);
        List<Product> productList = readFromFile(file);
        for (Product product:productList) {
            System.out.println(product);
        }
        readByName();
    }
    public static boolean writeToFile(File file, List<Product>products) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(products);
            oos.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } return true;
    }
    public static List<Product> readFromFile(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            products = (List<Product>) ois.readObject();
            fileInputStream.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    public static void readByName(){
        Scanner sn = new Scanner(System.in);
        System.out.println("Nhập vào tên:");
        String name = sn.nextLine();
        for (Product pr:products) {
            if(pr.getName().equals(name)){
                System.out.println(pr);
            }
        }
    }
}
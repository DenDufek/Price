import java.util.Arrays;
import java.util.Scanner;

class Price implements Comparable<Price> {
    private String productName;
    private String storeName;
    private double productPrice;

    public Price(String productName, String storeName, double productPrice) {
        this.productName = productName;
        this.storeName = storeName;
        this.productPrice = productPrice;
    }

    public String getStoreName() {
        return storeName;
    }

    @Override
    public int compareTo(Price other) {
        return this.storeName.compareTo(other.storeName);
    }

    @Override
    public String toString() {
        return "Товар: " + productName +
                ", Магазин: " + storeName +
                ", Вартість: " + productPrice + " грн";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Price[] prices = new Price[2];

        System.out.println("Введіть дані товарів:");

        for (int i = 0; i < prices.length; i++) {
            System.out.println("Товар " + (i + 1) + ":");
            try {
                System.out.print("Назва товару: ");
                String productName = scanner.next();

                System.out.print("Назва магазину: ");
                scanner.nextLine();  // Очистка буфера
                String storeName = scanner.nextLine();

                System.out.print("Вартість товару (грн): ");
                double productPrice = scanner.nextDouble();

                prices[i] = new Price(productName, storeName, productPrice);
            } catch (Exception e) {
                System.out.println("Помилка у введенні даних. Спробуйте ще раз.");
                scanner.nextLine(); // Очистка буфера введення
                i--; // Повторити введення для поточного товару
            }
        }

        Arrays.sort(prices);

        System.out.print("\nВведіть назву магазину для пошуку: ");
        String requiredStore = scanner.next();

        boolean storeFound = false;

        System.out.println("\nІнформація про товари в магазині " + requiredStore + ":");

        for (Price price : prices) {
            if (price.getStoreName().equalsIgnoreCase(requiredStore)) {
                System.out.println(price);
                storeFound = true;
            }
        }

        if (!storeFound) {
            System.out.println("Магазин " + requiredStore + " не знайдено.");
        }
    }
}

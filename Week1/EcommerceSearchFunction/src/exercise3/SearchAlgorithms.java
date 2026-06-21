package exercise3;

import java.util.Arrays;
import java.util.Comparator;

public class SearchAlgorithms {

    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }


    public static Product binarySearch(Product[] products, String name) {

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int compare = products[mid].productName.compareToIgnoreCase(name);

            if (compare == 0) {
                return products[mid];
            } else if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mobile", "Electronics"),
                new Product(103, "Shoes", "Fashion"),
                new Product(104, "Watch", "Accessories"),
                new Product(105, "Book", "Education")
        };

        System.out.println("=== Linear Search ===");
        Product result1 = linearSearch(products, "Shoes");

        if (result1 != null)
            result1.display();
        else
            System.out.println("Product not found");

        Arrays.sort(products,
                Comparator.comparing(p -> p.productName));

        System.out.println("\n=== Binary Search ===");
        Product result2 = binarySearch(products, "Shoes");

        if (result2 != null)
            result2.display();
        else
            System.out.println("Product not found");

        System.out.println("\nTime Complexity Analysis");
        System.out.println("Linear Search : O(n)");
        System.out.println("Binary Search : O(log n)");
        System.out.println("Binary Search is faster for large sorted datasets.");
    }
}
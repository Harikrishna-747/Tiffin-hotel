import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MenuItem {
           String name;
           double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class TiffinHotel {
    private Map<Integer, MenuItem> menu;

    public TiffinHotel() {
        menu = new HashMap<>();
        // Initialize menu items
        menu.put(1, new MenuItem("Idly", 30));
        menu.put(2, new MenuItem("Bonda", 40));
        menu.put(3, new MenuItem("Dosa", 50));
        menu.put(4, new MenuItem("Vada", 30));
        menu.put(5, new MenuItem("Mysore Bonda", 40));
        menu.put(6, new MenuItem("Puri", 35));
       
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (Map.Entry<Integer, MenuItem> entry : menu.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getName() + " " + entry.getValue().getPrice());
        }
    }

    public double calculateBill(int[] itemNumbers) {
        double total = 0.0;
        for (int itemNumber : itemNumbers) {
            MenuItem item = menu.get(itemNumber);
            if (item != null) {
                total += item.getPrice();
            } else {
                System.out.println("Item with number '" + itemNumber + "' not found in the menu.");
            }
        }
        return total;
    }
}

public class TiffinHotelApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TiffinHotel hotel = new TiffinHotel();

        // Display menu
        hotel.displayMenu();

        // Take order
        System.out.println("Enter item numbers you want to order (separated by spaces):");
        String orderInput = scanner.nextLine();
        String[] orderItemsStr = orderInput.split(" ");
        int[] orderItems = new int[orderItemsStr.length];
        for (int i = 0; i < orderItemsStr.length; i++) {
            orderItems[i] = Integer.parseInt(orderItemsStr[i]);
        }

        // Calculate bill
        double totalBill = hotel.calculateBill(orderItems);
        System.out.println("Your total bill is: " + totalBill);


        scanner.close();
    }
}

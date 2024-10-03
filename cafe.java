import java.util.Scanner;
import java.util.ArrayList;
public class FoodItem {
    private int id;
    private String name;
    private String category;
    private double cost;

    public FoodItem(int id, String name, String category, double cost) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return cost;
    }

    @Override
    public String toString() {
        return id + ": " + name + " (" + category + ") - Kshs" + cost;
    }
}

class Menu {
    private ArrayList<FoodItem> items;

    public Menu() {
        items = new ArrayList<>();
        // Sample menu 
        items.add(new FoodItem(1, "Spring Rolls", "Appetizer", 250.50));
        items.add(new FoodItem(2, "Grilled Chicken", "Main Course", 130.50));
        items.add(new FoodItem(3, "Carrotcake", "Dessert", 45.50));
        items.add(new FoodItem(4, "Lemonade", "Beverage", 70.00));
    }

    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("Food Id's are to be entered one at a time.");
        for (FoodItem item : items) {
            System.out.println(item);
            
        }
    }

    public FoodItem getFoodItemById(int id) {
        for (FoodItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null; // Item not found
    }
    /*public RemoveItem(int id){
        
        }*/
}

class Order {
    private ArrayList<FoodItem> orderedItems;

    public Order() {
        orderedItems = new ArrayList<>();
    }

    public void addItem(FoodItem item) {
        orderedItems.add(item);
    }

    public void removeItem(FoodItem item) {
        orderedItems.remove(item);
    }

    public double calculateTotal(double taxRate, double tipRate) {
        double subtotal = 0;
        for (FoodItem item : orderedItems) {
            subtotal += item.getPrice();
        }
        
        double tax = subtotal * taxRate;
        double tip = subtotal * tipRate;

        return subtotal + tax + tip;
    }

    public void displayOrder() {
        System.out.println("Current Order:");
        for (FoodItem item : orderedItems) {
            System.out.println(item);
        }
    }
}

class FoodDeliverySystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Order order = new Order();
        
        while (true) {
            menu.displayMenu();
            System.out.print("Enter the food item ID to order (0 to finalize): ");
            int id = scanner.nextInt();
            
            if (id == 0) { // Finalize order
                break;
            }

            FoodItem item = menu.getFoodItemById(id);
            if (item != null) {
                order.addItem(item);
                System.out.println(item.getName() + " has been added to your order.");
            } else {
                System.out.println("Invalid food ID! Please try again.");
            }
            
            // Display current order
            order.displayOrder();
        }
       
        // Finalize and display bill
        double totalCost = order.calculateTotal(0.07, 0.09); // tax and tip rates
        System.out.printf("Total Cost: Kshs%.2f\n", totalCost);
        
        scanner.close();
    }
}
}
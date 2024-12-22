import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * order processing application for my family's business
 *
 * @Allen Lin
 * @version 1
 */
public class PekingV2
{
    public static void main(String[] args){
        //Initialize items in menu
        List<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("1", "Broccoli Beef", 8.75));
        menu.add(new MenuItem("2", "Pepper Beef", 8.75));
        menu.add(new MenuItem("16", "Broccoli Chicken", 8.50));
        menu.add(new MenuItem("27", "Sweet and Sour Chicken", 8.50));
        menu.add(new MenuItem("30", "Teryaki Chicken", 8.50));
        menu.add(new MenuItem("30B", "General Tso's Chicken", 9.25));
        menu.add(new MenuItem("30E", "Chicken on a Stick", 11.95));
        menu.add(new MenuItem("16", "Broccoli Chicken", 8.50));
        menu.add(new MenuItem("31", "Broccoli Shrimp", 9.20));
        menu.add(new MenuItem("48", "House Fried Rice", 7.75));
        menu.add(new MenuItem("54", "House Lo Mein", 8.75));
        
        //Display the menu
        System.out.println("Hello, welcome to Peking restaurant!");
        System.out.println("Here is our menu:");
        for (MenuItem item: menu) {
            System.out.printf("%s - %s - %.2f %n", item.getItemNumber(), item.getItemName(), item.getPrice());
        }
        
        //process order
        System.out.println("Would you like to place an order? Enter yes or no.");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        Order order = new Order();
        
        //only when the customer answers yes
        while (answer.toLowerCase().contains("yes")) {
            System.out.println("What would you like? Enter the item number or name. Enter \"done\" to finish order.");
            String enteredItem = scanner.nextLine();
            if (enteredItem.toLowerCase().contains("done")) {
                break;
            }
            
            MenuItem selectedItem = null;
            for (MenuItem item : menu)
            {
                //takes ietm number or name
                if (enteredItem.toLowerCase().equals(item.getItemNumber().toLowerCase())) {
                    selectedItem = item;
                    break;
                }
                if (enteredItem.replaceAll("\\s", "").toLowerCase().equals(item.getItemName().replaceAll("\\s", "").toLowerCase())) {
                    selectedItem = item;
                    break;
                }
                
            }

            if (selectedItem != null) {
                System.out.println("Enter quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                if (quantity > 0) {
                order.addItem(selectedItem, quantity);
                System.out.println(quantity + " x " + selectedItem.getItemName() + " added to your order.");
                } else  {
                   System.out.println("Invalid quantity."); 
                }
            } else {
                System.out.println("Invalid menu item.");
            }
        }
        System.out.println("Receipt:");
        order.displayOrder();
        System.out.println("Thank you!");
        scanner.close();
                  
    }
}

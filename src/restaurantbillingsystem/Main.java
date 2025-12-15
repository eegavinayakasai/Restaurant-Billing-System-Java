package restaurantbillingsystem;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        menu.addItem("Chicken Biryani", 130);
        menu.addItem("Mutton Biryani", 260);
        menu.addItem("Paneer Biryani", 120);
        menu.addItem("Chicken Tikka Masala", 250);
        menu.addItem("Coffee", 40);
        menu.addItem("Tea", 30);
        menu.addItem("Boost", 20);
        menu.addItem("Veg Biryani", 100);
        menu.addItem("Veg Pulav", 80);
        menu.addItem("Any Desert", 70);

        Bill bill = new Bill(7);

        System.out.println("===== WELCOME TO OUR RESTAURANT =====");
        boolean running = true;
        while(running)
        {
            System.out.println("\n--- OPTIONS ---");
            System.out.println("1. Add items");
            System.out.println("2. Remove ordered items");
            System.out.println("3. View ordered items");
            System.out.println("4. Checkout");
            System.out.print("\nEnter your Choice: ");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1: // ADD ITEM
                    while (true)
                    {
                        System.out.println("\n---- MENU ----");
                        for(MenuItem item : menu.getAllItems())
                        {
                            System.out.println(item.getId() + " - " + item.getName() + " - " + item.getPrice() + " Rs");
                        }
                        System.out.print("\nEnter item id to order (Enter 0 for options) : ");
                        int itemId = sc.nextInt();
                        if(itemId == 0) break;
                        MenuItem selectedItem = menu.getItem(itemId);
                        if(selectedItem == null)
                        {
                            System.out.println("Invalid item id!");
                            continue;
                        }
                            System.out.print("\nEnter quantity: ");
                            int quantity = sc.nextInt();
                            if(quantity <= 0)
                            {
                                System.out.println("Quantity must be greater than 0");
                                continue;
                            }
                            OrderItem orderItem = new OrderItem(selectedItem, quantity);
                            bill.addOrderItems(orderItem);
                            System.out.println(selectedItem.getName() + " x " + quantity + " Ordered");
                    }
                    break;
                case 2 :// Remove items
                    while(true)
                    {
                        bill.printOrderedItems();
                        System.out.print("\nEnter order id to remove (Enter 0 for options): ");
                        int id = sc.nextInt();
                        if(id == 0) break;
                        else
                        {
                            System.out.print("\nEnter quantity to remove: ");
                            int quantity = sc.nextInt();
                            boolean removed = bill.removeOrderItemById(id,quantity);
                            if(removed)
                            {
                                System.out.println("Item updated successfully..");
                            }
                            else
                            {
                                System.out.println("Failed to remove item!");
                            }
                        }
                    }
                    break;
                case 3 :// Ordered items
                    if (bill.isEmpty()) {
                        System.out.println("\nNo items ordered yet.");
                    } else {
                        bill.printOrderedItems();
                    }
                    System.out.print("\nPress any number to go back: ");
                    sc.nextInt();
                    break;
                case 4 :// Receipt
                    bill.printReceipt();
                    System.out.println("Thank You! Hope you like our food, Visit again");
                    running = false;
                    break;
            }
        }
        sc.close();
    }
}
//            System.out.println("\n---- MENU ----");
//            for(MenuItem item : menu.getAllItems())
//        {
//        System.out.println(item.getId() + " - " + item.getName() + " - " + item.getPrice() + "Rs");
//        }
//        System.out.print("\nEnter item id to order (Enter 0 to finish) : ");
//int choice = sc.nextInt();
//            if(choice == 0 )
//        {
//        break;
//        }
//MenuItem selectedItem = menu.getItem(choice);
//            if(selectedItem == null)
//        {
//        System.out.println("Invalid item id!");
//                continue;
//                        }
//                        System.out.print("Enter Quantity : ");
//int quantity = sc.nextInt();
//            if(quantity <= 0)
//        {
//        System.out.println("Quantity must be greater than 0!");
//                continue;
//                        }
//
//OrderItem orderItem = new OrderItem(selectedItem, quantity);
//            bill.addOrderItems(orderItem);
//            System.out.println(selectedItem.getName() + " x " + quantity + " Ordered");
//
//        }
//        System.out.println("1. Remove ordered items.");
//        System.out.println("2. Checkout.");
//int Choice = sc.nextInt();
//        while(true)
//                {
//                if (Choice == 1)
//        {
//        bill.printOrderedItems();
//
//                System.out.print("Enter item id to remove (Enter 0 to checkout) :");
//int itemId = sc.nextInt();
//                if(itemId == 0)
//        {
//        if(bill.isEmpty())
//        {
//        System.out.println("No items ordered yet.");
//                    }
//                            else
//                            {
//                            bill.printReceipt();
//                    }
//                            sc.close();
//                    System.out.println("Thank You! Hope you like our food, Visit again");
//                    break;
//                            }
//                            System.out.print("Enter quantity to remove: ");
//int removeQty = sc.nextInt();
//
//boolean removed = bill.removeOrderItemById(itemId, removeQty);
//
//                if (removed)
//        {
//        System.out.println("Item updated successfully");
//                    continue;
//                            }
//                            else
//                            {
//                            System.out.println("Failed to remove item");
//                    continue;
//                            }
//                            }
//                            else
//                            {
//                            if(bill.isEmpty())
//        {
//        System.out.println("No items ordered yet.");
//                }
//                        else
//                        {
//                        bill.printReceipt();
//                }
//                        sc.close();
//                System.out.println("Thank You! Hope you like our food, Visit again");
//                break;
//                        }
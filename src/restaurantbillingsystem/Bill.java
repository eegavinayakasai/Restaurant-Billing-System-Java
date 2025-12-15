package restaurantbillingsystem;

import java.util.ArrayList;
import java.util.List;

public class Bill
{
    private List<OrderItem> orderItems = new ArrayList<>();
    private double gstPercent;

    public Bill(double gstPercent)
    {
        this.gstPercent = gstPercent;
    }
    public void addOrderItems(OrderItem orderItem)
    {
        orderItems.add(orderItem);
    }
    public boolean isEmpty()
    {
        return orderItems.isEmpty();
    }

    public double getSubtotal()
    {
        double subTotal = 0;
        for(OrderItem oi : orderItems)
        {
            subTotal += oi.getLineTotal();
        }
        return subTotal;
    }
    public double getTaxAmount()
    {
        return getSubtotal() * (gstPercent / 100);
    }
    public double getTotal()
    {
        return getTaxAmount() + getSubtotal();
    }

    public void printReceipt()
    {
        System.out.println("\n--------- RECEIPT---------");
        for(OrderItem oi : orderItems)
        {
            System.out.println(oi.getItem().getName() + " x " + oi.getQuantity() +  " = " + oi.getLineTotal() + "Rs ");
        }
        System.out.println("--------------------------");
        System.out.println("Subtotal : " + getSubtotal());
        System.out.println("GST (" + gstPercent + "%) : " + getTaxAmount() + "Rs");
        System.out.println("Total : " + getTotal() + "Rs");
        System.out.println("--------------------------");
    }
    public void printOrderedItems() {

//        if (orderItems.isEmpty())
//        {
//            System.out.println("No items ordered yet.");
//            return;
//        }

        System.out.println("\n--- ORDERED ITEMS ---");
        for (OrderItem oi : orderItems)
        {
            System.out.println(oi.getItem().getId() + " - " + oi.getItem().getName() + " x " + oi.getQuantity() + " = " + oi.getLineTotal() + " Rs");
        }
    }
    public boolean removeOrderItemById(int itemId, int removeQty)
    {
        for(int i = 0; i< orderItems.size() ; i++)
        {
            OrderItem oi = orderItems.get(i);
            if(oi.getItem().getId() == itemId)
            {
                if(removeQty <= 0)
                {
                    return false;
                }
                if(removeQty > oi.getQuantity())
                {
//                    System.out.println("Cannot remove more than ordered quantity!");
                    return false;
                }
                if(removeQty == oi.getQuantity())
                {
                    orderItems.remove(i);
                }
                else
                {
                    oi.setQuantity(oi.getQuantity() - removeQty);
                }
                return true;
            }
        }
        return false;
    }
}

package restaurantbillingsystem;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Menu
{
   private Map<Integer, MenuItem> items = new LinkedHashMap<>();
   private int nextId = 1;

   public void addItem(String name, double price)
   {
       MenuItem newItem = new MenuItem(nextId, name, price);
       items.put(nextId,newItem);
       nextId++;
   }
   public boolean removeItem(int id)
   {
       return items.remove(id) != null;
   }
   public MenuItem getItem(int id)
   {
       return items.get(id);
   }
   public Collection<MenuItem> getAllItems()
   {
       return items.values();
   }
   public boolean isEmpty()
   {
       return items.isEmpty();
   }
}

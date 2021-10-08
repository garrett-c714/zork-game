import java.util.ArrayList;
public class Inventory {
  private ArrayList<Item> inventoryList;
  private int max = 5;
  public Inventory() {
    inventoryList = new ArrayList<Item>();
  }
  public Item getItem(int i)
  {
    return inventoryList.get(i);
  }
  public int getInventoryLength()
  {
    return inventoryList.size();
  }

  public void add(Item i) {
    inventoryList.add(i);
  }
  public boolean containsItem(Item item)
  {
    return inventoryList.contains(item);
  }
  public void remove(Item i) {
    if (!inventoryList.contains(i)) {
      return;
    }
    inventoryList.remove(i);
  }
  public int getWeight()
  {
    int total = 0;
    for(Item item : inventoryList)
    {
      total += item.getWeight();
    }
    return total;
  }
  public int getMax()
  {
    return max;
  }




}
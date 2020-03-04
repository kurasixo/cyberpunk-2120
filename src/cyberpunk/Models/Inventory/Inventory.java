package cyberpunk.Models.Inventory;

import java.util.HashMap;


// Maybe abstract
public class Inventory {
  HashMap<Item, Float> items = new HashMap<>();

  public void putItem(Item item, float amount) {
    if (this.items.containsKey(item)) {
      float currentAmount = this.items.get(item);
      this.items.put(item, currentAmount + amount);
      return;
    }

    this.items.put(item, amount);
  }

  public void removeItem(Item item, float amount) {
    if (this.items.containsKey(item)) {
      float currentAmount = this.items.get(item);
      float newAmount = currentAmount - amount;

      if (newAmount < 0) {
        System.out.println("New amount is more than prev");
        return;
      }

      this.items.put(item, currentAmount - amount);
      return;
    }

    this.items.put(item, amount);
  }

  public HashMap<Item, Float> getItems() {
    return items;
  }
}
